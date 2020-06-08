package wk.serviceImpl;

import org.springframework.stereotype.Service;
import wk.dao.GroupDAO;
import wk.entity.Group;
import wk.entity.userrole;
import wk.entity.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@Service("GroupService")
public class GroupServicelmpl implements wk.service.GroupService {
    @Autowired(required = false)
    private GroupDAO groupDAO;  //通过Autowired创建对象交给IOC管理

    /**
     * 创建小组功能
     */
    @Override
    public int insertGroup(Group group) {
        int result;
        result=groupDAO.insertGroup(group);
        return result;
    }

    @Override
    public int insertuserrole(Group group, String userID) {
        int result;
        result=groupDAO.insertUserrole(group,userID);
        return result;
    }

    /**
     * 加入小组功能

     */
    @Override
    public int joinGroup(String userID, String groupID,String role) {
        int success=0;
        success=groupDAO.joinGroup(userID,groupID,role);
        return success;
    }

    /**
     * 退出小组功能
     * @param user
     * @param group
     * @return
     */
    @Override
    public boolean quitGroup(User user, Group group) {
        groupDAO.quitGroup(user,group);
        return false;
    }

    /**
     * 查询所有小组的功能
     * @return
     */
    @Override
    public List<Group> queryAllGroup() {
        List<Group> group=groupDAO.queryAllGroup();
        return group;
    }

    /**
     * 通过名字查询小组
     * @param groupName
     * @return
     */
    @Override
    public List<Group> queryGroupByName(String groupName) {
        List<Group> group=groupDAO.queryGroupByName(groupName);
        return group;
    }

    /**
     * 通过ID查询小组
     * @param ID
     * @return
     */
    @Override
    public Group queryGroupByID(String ID) {
        Group group=groupDAO.queryGroupByID(ID);
        return group;
    }

    /**
     * 用户查询组内职位
     * @param userID
     * @param groupID
     * @return
     */
    @Override
    public userrole queryRoleByID(String userID, String groupID) {
        userrole role;
        role=groupDAO.queryRoleByID(userID,groupID);
        return role;
    }

    /**
     * 用户所加入的所有小组
     * @param userID
     * @return
     */
    @Override
    public List<Group> queryAllJoinGroup(String userID) {
        List<Group> groups=groupDAO.queryAllJoinGroup(userID);
        return groups;
    }

    /**
     * 查看组内所有成员
     * @param groupID
     * @return
     */
    @Override
    public List<User> queryAllMemberInGroup(String groupID) {
        List<User> users=groupDAO.queryAllMemberInGroup(groupID);
        return users;
    }

    /**
     * 查看用户在组内权限
     * @param userID
     * @param groupID
     * @return
     */
    @Override
    public userrole queryUserrole(String userID, String groupID) {
        userrole userrole=groupDAO.queryUserrole(userID,groupID);
        return userrole;
    }

    /**
     * 更新小组信息
     * @param groupID
     * @param groupName
     * @param groupDescribe
     * @return
     */
    @Override
    public int updateGroupinfo(String groupID, String groupName, String groupDescribe) {
        int success=0;
        success=groupDAO.updateGroupinfo(groupID,groupName,groupDescribe);
        return success;
    }

    /**
     * 移除小组成员
     * @param userID
     * @return
     */
    @Override
    public int kickMember(String userID,String groupID) {
        int success=0;
        success=groupDAO.kickMember(userID,groupID);
        return success;
    }

    /**
     * 邀请成员加入
     * @param userID
     * @param groupID
     * @return
     */
    @Override
    public int inviteMember(String userID, String groupID) {
        int success=0;
        Group group=groupDAO.queryGroupByID(groupID);
        if(group!=null) {
            String infoName = group.getGroupName() + "小组邀请你加入";
            String infoSelf = group.getGroupName() + "小组邀请你加入，请问是否接受";
            success = groupDAO.inviteMember(userID, infoName, infoSelf);
        }
        return success;
    }

    @Override
    public int updateMemberrole(String userID, String groupID, String userrole) {
        int success=0;
        userrole userrole1=groupDAO.queryUserrole(userID,groupID);
        if(userrole1.getRole().equals("0")||userrole1.getRole().equals("1"))
            success=0;
        else
        success=groupDAO.updateMemberrole(userID,groupID,userrole);
        return success;
    }
}

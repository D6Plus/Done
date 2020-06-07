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
     * @param group
     * @param user
     */
    @Override
    public void joinGroup(Group group, User user) {
        groupDAO.joinGroup(user,group);
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
}

package wk.serviceImpl;

import org.springframework.stereotype.Service;
import wk.dao.GroupDAO;
import wk.entity.Group;
import wk.entity.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@Service("GroupService")
public class GroupServicelmpl implements wk.service.GroupService {
    @Autowired(required = false)
    private GroupDAO groupDAO;  //通过Autowired创建对象交给IOC管理

    /**
     * 创建小组功能
     * @param group
     */
    @Override
    public void insertGroup(Group group) {
        groupDAO.insertGroup(group);
    }
    @Override
    public void insertUserrole(Group group, User user) {
        groupDAO.insertUserrole(group,user);
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
    public Group queryGroupByID(Integer ID) {
        Group group=groupDAO.queryGroupByID(ID);
        return group;
    }

}

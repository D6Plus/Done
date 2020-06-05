package wk.service;

import org.apache.ibatis.annotations.Param;
import wk.entity.Group;
import wk.entity.User;

import java.util.List;

public interface GroupService {
    //创建小组
    void insertGroup(Group group);
    void insertUserrole(Group group,User user);

    //加入小组
    void joinGroup(Group group,User user);

    //退出小组
    boolean quitGroup(User user, Group group);

    //查询所有小组
    List<Group> queryAllGroup();

    //通过名字查询小组
    List<Group> queryGroupByName(String groupName);

    //通过ID查询小组
    Group queryGroupByID(String ID);
}

package wk.dao;

import wk.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import wk.entity.Group;

import java.util.List;
import java.util.Map;

@Repository
public interface GroupDAO {
    Group queryByID(@Param("groupID") String groupID);
    List<Group> queryByName(@Param("groupName") String groupName);
    List<Group> queryAll();
    String getLastID();

    //创建小组
    void insertGroup(Group group);
    void insertUserrole(@Param("Group")Group group,@Param("User") User user);
    //加入小组
    void joinGroup(@Param("User") User user,@Param("Group") Group group);
    //退出小组
    void quitGroup(@Param("User") User user,@Param("Group") Group group);
    //查询所有小组
    List<Group> queryAllGroup();
    //通过名字查询小组
    List<Group> queryGroupByName(@Param("groupName")String groupName);

    void insertGroup(String newGroupID, String groupName, String groupDescribe);

    //通过ID查询小组
    Group queryGroupByID(@Param("groupID") Integer ID);
}

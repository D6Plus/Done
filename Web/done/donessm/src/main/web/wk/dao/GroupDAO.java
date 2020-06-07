package wk.dao;

import wk.entity.userrole;
import wk.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import wk.entity.Group;

import java.util.List;

@Repository
public interface GroupDAO {
    Group queryByID(@Param("groupID") String groupID);
    List<Group> queryByName(@Param("groupName") String groupName);
    List<Group> queryAll();
    String getLastID();

    //创建小组
    int insertGroup(Group group);
    int insertUserrole(@Param("Group")Group group,@Param("userID")String userID);
    //加入小组
    void joinGroup(@Param("User") User user,@Param("Group") Group group);
    //退出小组
    void quitGroup(@Param("User") User user,@Param("Group") Group group);
    //查询所有小组
    List<Group> queryAllGroup();
    //通过名字查询小组
    List<Group> queryGroupByName(@Param("groupName")String groupName);
    //通过ID查询小组
    Group queryGroupByID(@Param("groupID") String ID);

    //用户查询在组内职位
    userrole queryRoleByID(@Param("userID") String userID, @Param("groupID") String groupID);

    //返回用户所加入的所有小组
    List<Group> queryAllJoinGroup(@Param("userID")String userID);

    //查询小组详细成员
    List<User> queryAllMemberInGroup(@Param("groupID")String groupID);

    //修改小组信息
    userrole queryUserrole(@Param("userID")String userID,@Param("groupID")String groupID);//先查看用户是否有修改权限0，1才有权限
    int updateGroupinfo(@Param("groupID")String groupID,@Param("groupName")String groupName,@Param("groupDescribe")String groupDescribe);

    //修改小组成员权限
    int updateMemberrole(@Param("userID")String userID,@Param("userrole") String userrole);

    //移除小组成员
    int kickMember(@Param("userID")String userID,@Param("groupID")String groupID);

    //邀请组员加入小组

    int inviteMember(@Param("userID")String userID,@Param("groupID")String groupID);

    




}

package wk.service;

import org.apache.ibatis.annotations.Param;
import wk.entity.Group;
import wk.entity.userrole;
import wk.entity.User;

import java.util.List;

public interface GroupService {
    //创建小组
    int insertGroup(Group group);
    int insertuserrole(Group group,String userID);

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

    //用户查询在组内职位
   userrole queryRoleByID(String userID, String groupID);

   //用户查询自己加入的所有小组
    List<Group> queryAllJoinGroup(String userID);

    //小组详细成员
    List<User> queryAllMemberInGroup(String groupID);

    //更改小组信息
    userrole queryUserrole(String userID,String groupID);
    int updateGroupinfo(String groupID,String groupName,String groupDescribe);

    //移除小组成员
    int kickMember(String userID,String groupID);
}

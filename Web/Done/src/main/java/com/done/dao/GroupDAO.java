package com.done.dao;

import com.done.entity.Group;
import com.done.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

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
    //添加进入关联表
    void insertUserrole(@Param("Group")Group group,@Param("User") User user);

    //加入小组
    void JoinGroup(@Param("User") User user,@Param("Group") Group group);
}

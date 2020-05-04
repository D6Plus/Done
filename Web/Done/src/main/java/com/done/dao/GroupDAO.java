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

}

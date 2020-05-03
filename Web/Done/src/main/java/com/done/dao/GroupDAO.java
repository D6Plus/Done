package com.done.dao;

import com.done.entity.Group;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupDAO {
    Group queryByID(@Param("groupID") String groupID);
    List<Group> queryByName(@Param("groupName") String groupName);
    List<Group> queryAll();
    String getLastID();
    void insertGroup(@Param("groupID") String groupID, @Param("groupName") String groupName, @Param("groupDescribe") String groupDescribe);
}

package com.done.dao;

import com.done.entity.Group;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GroupDAO {
    Group queryByID(@Param("userID") String groupID);
    List<Group> queryAll();
}

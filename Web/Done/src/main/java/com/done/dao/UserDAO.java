package com.done.dao;

import com.done.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDAO {
    User queryByID(@Param("userID") String userID);
    List<User> queryAll();
}

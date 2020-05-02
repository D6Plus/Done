package com.done.dao;

import com.done.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDAO {
    User queryByID(@Param("userID") String userID);
    List<User> queryByName(@Param("userName") String userName);
    List<User> queryAll();
    String getLastID();
    void insertUser(@Param("userID") String userID, @Param("userName") String userName, @Param("pwd") String pwd, @Param("role") String role);
}

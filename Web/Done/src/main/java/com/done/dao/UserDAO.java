package com.done.dao;

import com.done.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDAO {
    User queryByID(@Param("userID") String userID);
    List<User> queryAll();
}

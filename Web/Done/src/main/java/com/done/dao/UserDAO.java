package com.done.dao;

import com.done.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDAO {
    public User login(@Param("userID") String userID, @Param("pwd") String pwd);
    public void createNewUser(@Param("newUserID") String newUserID, @Param("userName") String userName,@Param("pwd") String pwd ,@Param("role") String role);
    public User getMassage(@Param("userID") String userID);
    public void updateMassage(@Param("userID") String userID,@Param("userName") String userName,@Param("pNum") String pNum,
                              @Param("userSex") String userSex,@Param("userBirth") String userBirth);
    User queryByID(@Param("userID") String userID);
    List<User> queryByName(@Param("userName") String userName);
    List<User> queryAll();
    String getLastID();
    void insertUser(@Param("userID") String userID, @Param("userName") String userName, @Param("pwd") String pwd, @Param("role") String role);
}

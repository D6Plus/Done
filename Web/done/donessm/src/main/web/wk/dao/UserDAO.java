package wk.dao;

import wk.entity.Info;
import wk.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDAO {
    User login(@Param("userID") String userID, @Param("pwd") String pwd);
    void createNewUser(@Param("newUserID") String newUserID, @Param("userName") String userName,@Param("pwd") String pwd ,@Param("role") String role);
    void changePwd(@Param("userID") String userID,@Param("newpwd") String newpwd);
    void setRole(@Param("userID") String userID,@Param("role") String role);
    User getMassage(@Param("userID") String userID);
    void updateMassage(@Param("userID") String userID,@Param("userName") String userName,@Param("pNum") String pNum,
                       @Param("userSex") String userSex,@Param("userBirth") String userBirth);
    void changeRole(@Param("userID") String userID,@Param("newrole") String newrole);
    User queryByID(@Param("userID") String userID);
    List<User> queryByName(@Param("userName") String userName);
    List<User> queryAll();
    String getLastID();
    void insertUser(@Param("userID") String userID, @Param("userName") String userName, @Param("pwd") String pwd, @Param("role") String role);
    void createNewInfo(@Param("userID") String userID, @Param("infoName") String infoName, @Param("infoSelf") String infoSelf);
    int countNewInfo(@Param("userID") String userID,@Param("status") String status);
    List<Info> queryAllInfo(@Param("userID") String userID, @Param("status") String status);
    void updateInfoStatus(@Param("infoID") int infoID,@Param("status") String status);
}

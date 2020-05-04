package com.done.service;

import com.done.entity.Group;
import com.done.entity.Plan;
import com.done.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService {

    User getUserByID(String userID);
    List<User> getUserList();
    List<User> getUserByName(String userName);

    Plan getPlanByID(String planID);
    List<Plan> getPlanList();
    List<Plan> getPlanByName(String planName);

    Group getGroupByID(String groupID);
    List<Group> getGroupList();
    List<Group> getGroupByName(String groupName);

    //登录
    public User login(String userID, String pwd);
    //注册
    String createNewUser(String newUserID ,String userName,  String pwd);

    void createNewPlan(String planName, String planDescribe);
    void createNewGroup(String planName, String planDescribe);
}

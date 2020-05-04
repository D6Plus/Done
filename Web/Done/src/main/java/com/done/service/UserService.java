package com.done.service;

import com.done.entity.Group;
import com.done.entity.Plan;
import com.done.entity.User;

import java.util.Date;
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

    void createNewUser(String userName, String pwd);
    void createNewGroup(String planName, String planDescribe);


    /*
    ** Plan
    */
    void createNewPlan(String planName, String planHeading, Date planRelease,
                       Date planDeadline, String planDescribe);
    void deletePlanByID(String planID);
    void updatePlan(String planID, String planName, String planHeading,
                    Date planRelease, Date planDeadline, String planDescribe);
}

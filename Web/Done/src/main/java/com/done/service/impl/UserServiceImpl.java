package com.done.service.impl;

import com.done.dao.GroupDAO;
import com.done.dao.PlanDAO;
import com.done.dao.UserDAO;
import com.done.entity.Group;
import com.done.entity.Plan;
import com.done.entity.User;
import com.done.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private PlanDAO planDAO;

    @Autowired
    private GroupDAO groupDAO;

    @Override
    public User getUserByID(String userID) {
        return userDAO.queryByID(userID);
    }

    @Override
    public List<User> getUserList() {
        return userDAO.queryAll();
    }

    @Override
    public List<User> getUserByName(String userName) {
        return userDAO.queryByName(userName);
    }

    @Override
    public Plan getPlanByID(String planID) {
        return planDAO.queryByID(planID);
    }

    @Override
    public List<Plan> getPlanList() {
        return planDAO.queryAll();
    }

    @Override
    public List<Plan> getPlanByName(String planName) {
        return planDAO.queryByName(planName);
    }

    @Override
    public Group getGroupByID(String groupID) {
        return groupDAO.queryByID(groupID);
    }

    @Override
    public List<Group> getGroupList() {
        return groupDAO.queryAll();
    }

    @Override
    public List<Group> getGroupByName(String groupName) {
        return groupDAO.queryByName(groupName);
    }

    @Override
    public void createNewUser(String userName, String pwd) {
        String newUserID = "u" + (Integer.parseInt(userDAO.getLastID().substring(1)) + 1);
        userDAO.insertUser(newUserID, userName, pwd, "test");
    }

    @Override
    public void createNewPlan(String planName, String planDescribe) {
        String newPlanID = "p" + (Integer.parseInt(planDAO.getLastID().substring(1)) + 1);
        planDAO.insertPlan(newPlanID, planName, planDescribe);
    }

    @Override
    public void createNewGroup(String planName, String planDescribe) {

    }


}

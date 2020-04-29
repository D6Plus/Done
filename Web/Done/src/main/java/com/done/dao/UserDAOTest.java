package com.done.dao;

import com.done.BaseTest;
import com.done.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserDAOTest extends BaseTest {

    @Autowired
    private UserDAO userDAO;

    @Test
    public void testQueryById() {
        String userID = "u1";
        User user = userDAO.queryByID(userID);
        System.out.println(user);
    }

    @Test
    public void testQueryAll() {
        List<User> users = userDAO.queryAll();
        for (User user : users) {
            System.out.println(user);
        }
    }

}
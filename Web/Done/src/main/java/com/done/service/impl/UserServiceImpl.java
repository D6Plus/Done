package com.done.service.impl;

import com.done.dao.UserDAO;
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

    @Override
    public User getById(String userId) {
        return userDAO.queryByID(userId);
    }

    @Override
    public List<User> getList() {
        return userDAO.queryAll();
    }
}

package com.done.service;

import com.done.entity.User;

import java.util.List;

public interface UserService {
    User getById(String userId);
    List<User> getList();
}

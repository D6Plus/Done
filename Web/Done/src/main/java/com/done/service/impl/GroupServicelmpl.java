package com.done.service.impl;

import com.done.dao.GroupDAO;
import com.done.entity.Group;
import com.done.entity.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

public class GroupServicelmpl implements GroupService {
    @Autowired
    private GroupDAO groupDAO;  //通过Autowired创建对象交给IOC管理

    /**
     * 创建小组功能
     * @param group
     */
    public void insertGroup(Group group) {
         groupDAO.insertGroup(group);
    }

    @Override
    public void insertUserrole(Group group, User user) {
        groupDAO.insertUserrole(group,user);
    }

    /**
     * 加入小组功能
     * @param group
     * @param user
     */
    @Override
    public void joinGroup(Group group, User user) {
        groupDAO.joinGroup(user,group);
    }

    /**
     * 退出小组功能
     * @param user
     * @param group
     */
    @Override
    public void quitGroup(User user, Group group) {
        groupDAO.quitGroup(user,group);
    }

}

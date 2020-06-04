package com.done.service.impl;

import com.done.dao.GroupDAO;
import com.done.entity.Group;
import com.done.entity.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
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

    /**
     * 查询所有小组的功能
     * @return
     */
    @Override
    public List<Group> queryAllGroup() {
        List<Group> group=groupDAO.queryAllGroup();
        return group;
    }

    /**
     * 通过名字查询小组
     * @param groupName
     * @return
     */
    @Override
    public List<Group> queryGroupByName(String groupName) {
        List<Group> group=groupDAO.queryGroupByName(groupName);
        return group;
    }


}

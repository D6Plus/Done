package com.done.service;

import com.done.entity.Group;
import com.done.entity.User;

import java.util.List;
import java.util.Map;

public interface GroupService {
    //创建小组
    void insertGroup(Group group);
    void insertUserrole(Group group,User user);

    //加入小组
    void joinGroup(Group group,User user);

    //退出小组
    void quitGroup(User user,Group group);

    //查询所有小组
    List<Group> queryAllGroup();

    //通过名字查询小组
    List<Group> queryGroupByName(String groupName);
}

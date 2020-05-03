package com.done.service.impl;

import com.done.entity.Group;
import com.done.entity.User;

import java.util.Map;

public interface GroupService {
    //创建小组
    void insertGroup(Group group);
    void insertUserrole(Group group,User user);

    //加入小组
    void joinGroup(Group group,User user);

    //退出小组
    void quitGroup(User user,Group group);
}

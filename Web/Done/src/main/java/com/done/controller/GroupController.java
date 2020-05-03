package com.done.controller;

import com.done.entity.Group;
import com.done.entity.User;
import com.done.service.impl.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 功能描述：小组控制层
 */
@RestController
@RequestMapping("Group")
public class GroupController {
    @Autowired
    private GroupService groupService;//注入  放入ioc管理

    /**
     * 创建小组控制器
     * @param map
     */
    @RequestMapping(value = "insertGroup",produces = "application/json;charset=utf-8")
    @ResponseBody
    public void insertGroup(@RequestBody Map<String,Object> map){
        Group group=(Group)map.get("Group");
        User user=(User)map.get("User");
        System.out.println("接受到来自前台的json对象转换为类对象"+group);
        System.out.println("接受到来自前台的json对象转换为类对象"+user);
        groupService.insertGroup(group);
    }

    /**
     * 加入小组控制器
     * @param map
     */
    @RequestMapping(value="joinGroup",produces = "application/json;charset=utf-8")
    @ResponseBody
    public void joinGroup(@RequestBody Map<String,Object> map){
        Group group=(Group)map.get("Group");
        User user=(User)map.get("User");
        System.out.println("接受来自前台JSON对象转化为对象"+group);
        System.out.println("接受来自前台JSON的转化对象"+user);
        groupService.joinGroup(group,user);

    }

    /**
     * 退出小组控制器
     * @param map
     */
    @RequestMapping(value = "quitGroup",produces = "application/json;charset=utf-8")
    @ResponseBody
    public void quitGroup(@RequestBody Map<String,Object> map){
        Group group=(Group)map.get("Group");
        User user=(User)map.get("User");
        System.out.println("接受来自前台JSON对象转化为对象"+group);
        System.out.println("接受来自前台JSON的转化对象"+user);
        groupService.quitGroup(user,group);
    }
}

package com.done.controller;

import com.done.entity.Group;
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

    @RequestMapping(value = "insertGroup",produces = "application/json;charset=utf-8")
    @ResponseBody
    public void insertGroup(@RequestBody Group group){
        System.out.println("接受到来自前台的json对象转换为类对象"+group);
        groupService.insertGroup(group);
    }
}

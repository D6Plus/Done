package com.done.controller;

import com.alibaba.fastjson.JSON;
import com.done.entity.Group;
import com.done.entity.User;
import com.done.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


@RequestMapping("/index")
@Controller
public class UserController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;
    public  void setUserService(UserService userService){
        this.userService=userService;
    }

    /**
     * 查询所有用户
     * @return
     */
    @RequestMapping(value = "queryAllUser",produces = "application/json;charset=utf-8")
    public String queryAllUser(){
        List<User> UserList= userService.getUserList();
        String jsonOutput = JSON.toJSONString(UserList);
        return jsonOutput;
    }

    /**
     * 通过名字查询用户
     * @param UserName
     * @return
     */
    @RequestMapping(value = "queryUserByName",produces = "application/json;charset=utf-8")
    @ResponseBody
    public List<User> queryUserByName(@RequestBody String UserName){
        List<User> UserList= userService.getUserByName(UserName);
        return UserList;
    }

    /**
     * 通过ID查询用户
     * @param UserID
     * @return
     */
    @RequestMapping(value = "queryUserByName",produces = "application/json;charset=utf-8")
    @ResponseBody
    public User queryUserByID(@RequestBody String UserID){
        User user= userService.getUserByID(UserID);
        return user;
    }

    /**
     * 注册
     * @param userID
     * @param pwd
     * @return
     */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login (Model model,@RequestBody String userID,@RequestParam String pwd){
        User user = userService.login(userID,pwd);
        if(user!=null) {
            return null;
        }
        else{
            String jsonOutput = JSON.toJSONString(user);
            return jsonOutput;
        }
    }
}

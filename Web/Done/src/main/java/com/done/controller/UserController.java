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


@RequestMapping("User")
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
    @ResponseBody
    @RequestMapping(value = "queryUserByName",produces = "application/json;charset=utf-8")
    public List<User> queryUserByName(@RequestBody String UserName){
        List<User> UserList= userService.getUserByName(UserName);
        return UserList;
    }

    /**
     * 通过ID查询用户
     * @param UserID
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "queryUserByID",produces = "application/json;charset=utf-8")
    public User queryUserByID(@RequestBody String UserID){
        User user= userService.getUserByID(UserID);
        return user;
    }

    /*
     * 前台登录
     */
    @ResponseBody
    @RequestMapping(value = "login1",produces = "application/json;charset=utf-8", method = RequestMethod.POST)
    public String login1 (@RequestBody User user){
        User user1 = userService.login(user.getUserID(),user.getPwd());
        if(user!=null) {
            String jsonOutput = JSON.toJSONString(user1);
            return jsonOutput;
        }
        else{
            return null;
        }
    }

    /*
     * 后台登录
     */
    @ResponseBody
    @RequestMapping(value = "login2",produces = "application/json;charset=utf-8", method = RequestMethod.POST)
    public String login2 (@RequestBody User user){
        User user1 = userService.login2(user.getUserID(),user.getPwd());
        if(user!=null) {
            String jsonOutput = JSON.toJSONString(user1);
            return jsonOutput;
        }
        else{
            return null;
        }
    }

    /*
     * 修改密码
     */
    @ResponseBody
    @RequestMapping(value = "changePwd", method = RequestMethod.POST)
    public boolean changePwd(@RequestBody User user){
        if(userService.changePwd2(user.getUserID(),user.getPwd())) {
            return true;
        }
        else{
            return false;
        }
    }

    /*
     * 修改资料
     */
    @ResponseBody
    @RequestMapping(value = "changeMassage", method = RequestMethod.POST)
    public boolean updateMassage( @RequestBody User user){
        userService.updateMassage(user.getUserID(), user.getUserName(), user.getpNum(), user.getUserSex(), user.getUserBirth());
        return true;
    }

    /**
     * 通过ID查询用户资料
     * @param UserID
     * @return
     */
    @RequestMapping(value = "getMassage",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String getMassageByID(@RequestBody String UserID){
        User user= userService.getMassage(UserID);
        String jsonOutput = JSON.toJSONString(user);
        return jsonOutput;
    }


}

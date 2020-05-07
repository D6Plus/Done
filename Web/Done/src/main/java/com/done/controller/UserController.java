package com.done.controller;

import com.done.entity.User;
import com.done.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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

    @RequestMapping(value = "index")
    private String createNewPlan(Model model, @RequestParam("planID") String planID,
                                 @RequestParam("planName") String planName,
                                 @RequestParam("planHeading") String planHeading,
                                 @RequestParam("planRelease") Date planRelease,
                                 @RequestParam("planDeadline") Date planDeadline,
                                 @RequestParam("planDescribe") String planDescribe) {
        userService.createNewPlan(planName, planHeading, planRelease, planDeadline, planDescribe);
        return "index";
    }

    @RequestMapping(value = "/login.html", method = RequestMethod.GET)
    public String login (){
        return "login";
    }

    @RequestMapping(value = "/login.html", method = RequestMethod.POST)
    public String login (Model model,@RequestParam String userID,@RequestParam String pwd){
        User user = userService.login(userID,pwd);
        if(user!=null){
            model.addAttribute("msg","登陆成功");
        }
        else{
            model.addAttribute("msg","登陆失败");
        }
        return "index";
    }
}

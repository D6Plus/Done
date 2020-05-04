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
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/index")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

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
}

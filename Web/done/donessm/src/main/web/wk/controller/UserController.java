package wk.controller;

import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Qualifier;
import wk.entity.User;
import wk.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.ui.Model;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("User")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Qualifier("UserService")
    @Autowired
    private UserService userService;
    public  void setUserService(UserService userService){
        this.userService=userService;
    }

    /**
     * 查询所有用户
     * @return
     */

    @CrossOrigin(origins = "*",maxAge = 3600)
    @RequestMapping(value = "queryAllUser",produces = "application/json;charset=utf-8")
    public JSONArray queryAllUser(){
        List<User> UserList= userService.getUserList();
        JSONArray jsonOutput=JSONArray.fromObject(UserList);
        return jsonOutput;
    }

    /**
     * 通过名字查询用户
     * @param UserName
     * @return
     */
    @CrossOrigin(origins = "*",maxAge = 3600)
    @RequestMapping(value = "queryUserByName",produces = "application/json;charset=utf-8",method = RequestMethod.GET)
    public JSONArray queryUserByName(@RequestBody String UserName){
        List<User> UserList= userService.getUserByName(UserName);
        JSONArray jsonOutput=JSONArray.fromObject(UserList);
        return jsonOutput;
    }

    /**
     * 通过ID查询用户
     * @param UserID
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "queryUserByID",produces = "application/json;charset=utf-8", method = RequestMethod.GET)
    public User queryUserByID(@RequestParam String UserID){
        User user= userService.getUserByID(UserID);
        return user;
    }

    /*
     * 前台登录
     */
   /*@RequestMapping(value = "login1",produces = "application/json;charset=utf-8", method = RequestMethod.POST)
    public boolean login1 (@RequestBody User user){
        User user1 = userService.login(user.getUserID(),user.getPwd());
        if(user!=null) {
            return true;
        }
        else{
            return false;
        }
    }*/


    @RequestMapping(value = "login1", method = RequestMethod.POST)
    public void login1 (HttpSession session, @RequestParam String UserId, @RequestParam String pwd, HttpServletResponse response)
    throws IOException {
        User user1 = userService.login(UserId, pwd);
        if (user1 != null) {
            session.setAttribute("user", user1.getUserID());
            response.sendRedirect("/home.jsp");
        } else {
            response.sendRedirect("/index.jsp");
        }
    }
    /*
     * 后台登录
     */
    @RequestMapping(value = "login2",produces = "application/json;charset=utf-8", method = RequestMethod.POST)
    public boolean login2 (@RequestBody User user){
        User user1 = userService.login2(user.getUserID(),user.getPwd());
        if(user!=null) {
            return true;
        }
        else{
            return false;
        }
    }

    /*
     * 修改密码
     */
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
    @RequestMapping(value = "changeMassage", method = RequestMethod.POST)
    public boolean updateMassage( @RequestBody User user){
        return userService.updateMassage(user.getUserID(), user.getUserName(), user.getpNum(), user.getUserSex(), user.getUserBirth());
    }

    /**
     * 通过ID查询用户资料
     * @param UserID
     * @return
     */
    @RequestMapping(value = "getMassage",produces = "application/json;charset=utf-8")
    public User getMassageByID(@RequestBody String UserID){
        return userService.getMassage(UserID);
    }


}

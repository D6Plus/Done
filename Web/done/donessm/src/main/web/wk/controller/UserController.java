package wk.controller;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Qualifier;
import wk.entity.User;
import wk.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
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
     * @param userName
     * @return
     */
    @CrossOrigin(origins = "*",maxAge = 3600)
    @RequestMapping(value = "queryUserByName",produces = "application/json;charset=utf-8",method = RequestMethod.GET)
    public JSONArray queryUserByName(@RequestBody String userName){
        List<User> UserList= userService.getUserByName(userName);
        JSONArray jsonOutput=JSONArray.fromObject(UserList);
        return jsonOutput;
    }

    /**
     * 通过ID查询用户
     * @param UserID
     */
    @ResponseBody
    @RequestMapping(value = "queryUserByID",produces = "application/json;charset=utf-8", method = RequestMethod.GET)
    public JSONObject queryUserByID(@RequestBody String UserID){
        User user= userService.getUserByID(UserID);
        JSONObject jsonOutput=JSONObject.fromObject(user);
        return jsonOutput;
    }



/*
    @RequestMapping(value = "login1", method = RequestMethod.POST)
    public boolean login1 ( String UserID, String pwd){
        User user1 = userService.login(UserID,pwd);
        if(user1!=null) {
            return true;
        }
        else{
            return false;
        }
    }*/


    /**
     * 注册
     * @param userID
     * @param userName
     * @param pwd
     */
    @ResponseBody
    @RequestMapping(value = "sighup", method = RequestMethod.POST)
    public void login1 (@RequestBody  String userID,@RequestBody  String userName,@RequestBody  String pwd,HttpServletResponse response)
            throws IOException{
        if (userService.createNewUser(userID,userName,pwd)) {
            response.sendRedirect("/index.jsp");
        } else {
            response.sendRedirect("/home.jsp");
        }
    }
    /**
     * 前台登录
     * @param userID
     * @param pwd
     */
    @ResponseBody
    @RequestMapping(value = "login1", method = RequestMethod.POST)
    public void login1 (HttpSession session, @RequestBody  String userID,@RequestBody  String pwd, HttpServletResponse response)
    throws IOException {
        User user1 = userService.login(userID, pwd);
        if (user1 != null) {
            session.setAttribute("userID", user1.getUserID());
            session.setAttribute("userName", user1.getUserName());
            response.sendRedirect("/home.jsp");
        } else {
            response.sendRedirect("/index.jsp");
        }
    }
    /**
     * 后台登录
     * @param userID
     * @param pwd
     */
    @ResponseBody
    @RequestMapping(value = "login2", method = RequestMethod.POST)
    public void login2 (HttpSession session, @RequestBody  String userID,@RequestBody  String pwd, HttpServletResponse response)
            throws IOException {
        User user1 = userService.login2(userID, pwd);
        if (user1 != null) {
            session.setAttribute("userID", user1.getUserID());
            session.setAttribute("userName", user1.getUserName());
            response.sendRedirect("/home.jsp");
        } else {
            response.sendRedirect("/index.jsp");
        }
    }

    /**
     * 退出登录
     */
    @ResponseBody
    @RequestMapping(value = "login2", method = RequestMethod.POST)
    public void login2 (HttpSession session, HttpServletResponse response)
            throws IOException {
            session.setAttribute("userID", null);
            session.setAttribute("userName", null);
            response.sendRedirect("/home.jsp");
    }

    /**
     * 修改密码
     * @param userID
     * @param pwd
     */
    @ResponseBody
    @RequestMapping(value = "changePwd", method = RequestMethod.POST)
    public boolean changePwd( @RequestBody  String userID,@RequestBody  String pwd){
        if(userService.changePwd2(userID,pwd)) {
            return true;
        }
        else{
            return false;
        }
    }
    /**
     * 修改资料
     * @param userID
     * @param userName
     * @param pNum
     * @param userSex
     * @param userBirth
     */
    @RequestMapping(value = "changeMassage", method = RequestMethod.POST)
    public boolean updateMassage( @RequestBody String userID,@RequestBody String userName,@RequestBody String pNum,
                                  @RequestBody String userSex,@RequestBody String userBirth){
        return userService.updateMassage(userID, userName, pNum, userSex, userBirth);
    }

    /**
     * 通过ID查询用户资料
     * @param userID
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "getMassage",produces = "application/json;charset=utf-8")
    public User getMassageByID(@RequestBody String userID){
        return userService.getMassage(userID);
    }


}

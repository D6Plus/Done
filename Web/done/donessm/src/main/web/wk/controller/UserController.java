package wk.controller;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Qualifier;
import wk.entity.Info;
import wk.entity.User;
import wk.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

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
     * @param map
     * @return
     */
    @CrossOrigin(origins = "*",maxAge = 3600)
    @RequestMapping(value = "queryUserByName",produces = "application/json;charset=utf-8",method = RequestMethod.GET)
    public JSONArray queryUserByName(@RequestBody Map<String,Object> map){
        String userName = (String) map.get("userName");
        List<User> UserList= userService.getUserByName(userName);
        JSONArray jsonOutput=JSONArray.fromObject(UserList);
        return jsonOutput;
    }

    /**
     * 通过ID查询用户
     * @param map
     * @return
     */
    @CrossOrigin(origins = "*",maxAge = 3600)
    @ResponseBody
    @RequestMapping(value = "queryUserByID",produces = "application/json;charset=utf-8", method = RequestMethod.GET)
    public JSONObject queryUserByID(@RequestBody Map<String,Object> map){
        String userID = (String) map.get("userID");
        User user= userService.getUserByID(userID);
        JSONObject jsonOutput=JSONObject.fromObject(user);
        return jsonOutput;
    }




   /* @RequestMapping(value = "login1", method = RequestMethod.GET)
    public void login3 ( HttpSession session,   String userID,  String pwd, HttpServletResponse response)
            throws IOException {
        User user3 = userService.login(userID,pwd);
        if (user3 != null) {
            session.setAttribute("userID", user3.getUserID());
            session.setAttribute("userName", user3.getUserName());
            response.sendRedirect("/home.jsp");
        } else {
            response.sendRedirect("/index.jsp");
        }
    }
*/

    /**
     * 注册
     * @param map
     */
    @ResponseBody
    @RequestMapping(value = "sighup",produces = "application/json;charset=utf-8" ,method = RequestMethod.POST)
    public void sighup (@RequestBody Map<String,Object> map,HttpServletResponse response)
            throws IOException{
        String userID = (String) map.get("userID");
        String userName = (String) map.get("userName");
        String pwd = (String) map.get("pwd");
        if (userService.createNewUser(userID,userName,pwd)) {
            String infoName = "欢迎！";
            String infoSelf = "欢迎您使用Done！";
            userService.createNewInfo(userID,infoName,infoSelf);
            response.sendRedirect("/index.jsp");
        } else {
            response.sendRedirect("/home.jsp");
        }
    }

    /**
     * 前台登录
     * @param map
     */
    @ResponseBody
    @RequestMapping(value = "login1",produces = "application/json;charset=utf-8", method = RequestMethod.POST)
    public void login1 (HttpSession session,  @RequestBody Map<String,Object> map, HttpServletResponse response)
    throws IOException {
        String userID = (String) map.get("userID");
        String pwd = (String) map.get("pwd");
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
     * @param map
     */
    @ResponseBody
    @RequestMapping(value = "login2",produces = "application/json;charset=utf-8", method = RequestMethod.POST)
    public void login2 (HttpSession session, @RequestBody Map<String,Object> map, HttpServletResponse response)
            throws IOException {
        String userID = (String) map.get("userID");
        String pwd = (String) map.get("pwd");
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
    @RequestMapping(value = "logout", method = RequestMethod.POST)
    public void login2 (HttpSession session, HttpServletResponse response)
            throws IOException {
            session.setAttribute("userID", null);
            session.setAttribute("userName", null);
            response.sendRedirect("/home.jsp");
    }

    /**
     * 修改密码
     * @param map
     */
    @ResponseBody
    @RequestMapping(value = "changePwd",produces = "application/json;charset=utf-8", method = RequestMethod.POST)
    public boolean changePwd( @RequestBody Map<String,Object> map){
        String userID = (String) map.get("userID");
        String pwd = (String) map.get("pwd");
        if(userService.changePwd2(userID,pwd)) {
            return true;
        }
        else{
            return false;
        }
    }
    /**
     * 修改资料
     * @param map
     */
    @ResponseBody
    @RequestMapping(value = "changeMassage",produces = "application/json;charset=utf-8", method = RequestMethod.POST)
    public boolean updateMassage( @RequestBody Map<String,Object> map){
        String userID = (String) map.get("userID");
        String userName = (String) map.get("userName");
        String pNum = (String) map.get("pNum");
        String userSex = (String) map.get("userSex");
        String userBirth = (String) map.get("userBirth");
        return userService.updateMassage(userID, userName, pNum, userSex, userBirth);
    }

    /**
     * 通过ID查询用户资料
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "getMassage",produces = "application/json;charset=utf-8",method = RequestMethod.GET)
    public JSONObject getMassageByID(@RequestBody Map<String,Object> map) {
        String userID = (String) map.get("userID");
        User user = userService.getMassage(userID);
            JSONObject jsonOutput=JSONObject.fromObject(user);
            return jsonOutput;
    }

    /**
     * 通过ID查询未读通知数量
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "countNewInfo",produces = "application/json;charset=utf-8",method = RequestMethod.GET)
    public int countNewInfo(@RequestBody Map<String,Object> map) {
        String userID = (String) map.get("userID");

        return userService.countNewInfo(userID);
    }

    /**
     * 通过ID查询所有的通知
     * @param map
     * @return
     */
    @CrossOrigin(origins = "*",maxAge = 3600)
    @ResponseBody
    @RequestMapping(value = "queryAllInfo",produces = "application/json;charset=utf-8",method = RequestMethod.GET)
    public JSONArray  queryAllInfo(@RequestBody Map<String,Object> map){
        String userID = (String) map.get("userID");
        List<Info> UserList= userService.queryAllInfo(userID );
        JSONArray jsonOutput=JSONArray.fromObject(UserList);
        return jsonOutput;

    }
}

package wk.service;

import wk.entity.Group;
import wk.entity.Plan;
import wk.entity.User;

import java.util.Date;
import java.util.List;

public interface UserService {

    User getUserByID(String userID);
    List<User> getUserList();
    List<User> getUserByName(String userName);

    Plan getPlanByID(String planID);
    List<Plan> getPlanList();
    List<Plan> getPlanByName(String planName);

    Group getGroupByID(String groupID);
    List<Group> getGroupList();
    List<Group> getGroupByName(String groupName);


    //前台登录
    User login(String userID, String pwd);

    //后台登录
    User login2(String userID, String pwd);

    //注册
    boolean createNewUser(String newUserID ,String userName, String pwd);

    //获取个人信息
    User getMassage(String userID);

    //修改个人信息
    boolean updateMassage(String userID, String userName, String pNum, String userSex, String userBirth);

    //用户修改密码
    boolean changePwd1(String userID, String pwd, String newpwd);

    //管理员后台修改用户的密码
    boolean changePwd2(String userID, String newpwd);

    //管理员后台修改用户角色（状态)
    boolean changeRole(String userID, String newrole);


    void createNewPlan(String planName, String planDescribe);


    /*
     ** Plan
     */
    void createNewPlan(String planName, String planHeading, Date planRelease,
                       Date planDeadline, String planDescribe);
    boolean deletePlanByID(String planID);
    void updatePlan(String planID, String planName, String planHeading,
                    Date planRelease, Date planDeadline, String planDescribe);
}

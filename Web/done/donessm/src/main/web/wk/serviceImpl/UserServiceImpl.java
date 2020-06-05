package wk.serviceImpl;

import wk.dao.GroupDAO;
import wk.dao.PlanDAO;
import wk.dao.UserDAO;
import wk.entity.Group;
import wk.entity.Plan;
import wk.entity.User;
import wk.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;


@Service("UserService")
public class UserServiceImpl implements UserService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired(required = false)
    private UserDAO userDAO;
    /*public void setMapper(UserDAO userDAO){
    this.userDAO = userDAO;
    }
    */

    @Autowired
    private PlanDAO planDAO;

    @Autowired
    private GroupDAO groupDAO;



    @Override
    public User getUserByID(String userID) {
        return userDAO.queryByID(userID);
    }

    @Override
    public List<User> getUserList() {
        return userDAO.queryAll();
    }

    @Override
    public List<User> getUserByName(String userName) {
        return userDAO.queryByName(userName);
    }

    @Override
    public Plan getPlanByID(String planID) {
        return planDAO.queryByID(planID);
    }

    @Override
    public List<Plan> getPlanList() {
        return planDAO.queryAll();
    }

    @Override
    public List<Plan> getPlanByName(String planName) {
        return planDAO.queryByName(planName);
    }

    @Override
    public Group getGroupByID(String groupID) {
        return groupDAO.queryByID(groupID);
    }

    @Override
    public List<Group> getGroupList() {
        return groupDAO.queryAll();
    }

    @Override
    public List<Group> getGroupByName(String groupName) {
        return groupDAO.queryByName(groupName);
    }

    @Override
    public User login(String userID, String pwd) {
        return userDAO.login(userID,pwd);
    }

    @Override
    public void createNewPlan(String planName, String planHeading, Date planRelease,
                              Date planDeadline, String planDescribe) {
        String newPlanID = "p" + (Integer.parseInt(planDAO.getLastID().substring(1)) + 1);
        planDAO.insertPlan(newPlanID, planName, planHeading,
                planRelease, planDeadline, planDescribe);
    }

    @Override
    public User login2(String userID, String pwd) {
        User user = userDAO.login(userID,pwd);
        if(user != null) {
            if(Objects.equals(user.getRole(), "1")) {
                return user;
            }
            else {
                return null;
            }
        }
        else{
            return null;
        }
    }

    @Override
    public boolean createNewUser(String newUserID, String userName,  String pwd) {
        if(userDAO.queryByID(newUserID)==null){
            userDAO.createNewUser(newUserID, userName, pwd, "0");
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public boolean changePwd1(String userID, String pwd, String newpwd){
        if(userDAO.login(userID, pwd) != null){
            userDAO.changePwd(userID, newpwd);
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public boolean changePwd2(String userID, String newpwd){
        if(userDAO.queryByID(userID) != null){
            userDAO.changePwd(userID, newpwd);
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public boolean deletePlanByID(String planID) {
        planDAO.deletePlanByID(planID);
        return false;
    }

    @Override
    public void updatePlan(String planID, String planName,
                           String planHeading, Date planRelease,
                           Date planDeadline, String planDescribe) {
        planDAO.updatePlan(planID, planName, planHeading,
                planRelease, planDeadline, planDescribe);
    }
    @Override
    public boolean changeRole(String userID, String newrole){
        if(userDAO.queryByID(userID) != null){
            userDAO.changeRole(userID, newrole);
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public User getMassage(String userID){
        return userDAO.getMassage(userID);
    }

    @Override
    public boolean updateMassage(String userID, String userName, String pNum, String userSex, String userBirth){
        userDAO.updateMassage(userID, userName, pNum, userSex, userBirth);
        return true;
    }

    @Override
    public void createNewPlan(String planName, String planDescribe) {
        String newPlanID = "p" + (Integer.parseInt(planDAO.getLastID().substring(1)) + 1);
        planDAO.insertPlan(newPlanID, planName, planDescribe);
    }

    @Override
    public void createNewGroup(String groupName, String groupDescribe) {
        String newGroupID = "g" + (Integer.parseInt(groupDAO.getLastID().substring(1)) + 1);
        groupDAO.insertGroup(newGroupID, groupName, groupDescribe);
    }
}

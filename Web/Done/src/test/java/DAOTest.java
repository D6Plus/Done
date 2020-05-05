import com.done.dao.GroupDAO;
import com.done.dao.PlanDAO;
import com.done.dao.UserDAO;
import com.done.entity.Group;
import com.done.entity.Plan;
import com.done.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DAOTest extends BaseTest {

    @Autowired
    private UserDAO userDAO;
    @Autowired
    private GroupDAO groupDAO;
    @Autowired
    private PlanDAO planDAO;

    @Test
    public void testUserlogin() {
        String userID = "u1";
        String pwd = "aaa";
        User user = userDAO.login(userID,pwd);
        System.out.println(user);
    }

    @Test
    public void testCreateNewUser() {
        String username="kkk";
        String userID = "u12";
        String pwd = "aaa";
        String role = "test";
        userDAO.createNewUser(userID,username,pwd,role);
        System.out.println(username);
    }

    @Test
    public void testUpdateMassage() {
        String userID = "u12";
        String username = "哈哈哈";
        String pNum = "13556465465";
        String userSex = "男";
        String userBirth = "1999-06-24";
        userDAO.updateMassage(userID,username,pNum,userSex,userBirth);
        System.out.println(userDAO.getMassage(userID));
    }

    @Test
    public void testChangePwd() {
        String userID = "u1";
        String newpwd = "bbb";
        userDAO.changePwd(userID,newpwd);
        System.out.println(userDAO.queryByID(userID).getPwd());
    }

    @Test
    public void testUserQueryById() {
        String userID = "u1";
        User user = userDAO.queryByID(userID);
        System.out.println(user);
    }

    @Test
    public void testUserQueryAll() {
        List<User> users = userDAO.queryAll();
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testGroupQueryById() {
        String groupID = "g1";
        Group group = groupDAO.queryByID(groupID);
        System.out.println(group);
    }

    @Test
    public void testGroupQueryAll() {
        List<Group> groups = groupDAO.queryAll();
        for (Group group : groups) {
            System.out.println(group);
        }
    }

    @Test
    public void testPlanQueryById() {
        String planID = "p1";
        Plan plan = planDAO.queryByID(planID);
        System.out.println(plan);
    }

    @Test
    public void testPlanQueryAll() {
        List<Plan> plans = planDAO.queryAll();
        for (Plan plan : plans) {
            System.out.println(plan);
        }
    }

}
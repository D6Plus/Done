import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.done.entity.User;
import com.done.service.impl.UserServiceImpl;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class ServiceImplTest extends BaseTest {

    @Autowired
    private UserServiceImpl userService;

    @Test
    public void createNewUserTest() {
        boolean a = userService.createNewUser("4541", "created user","pwd");
        System.out.println(a);
    }

    @Test
    public void loginTest1() {
        User user = userService.login("u1", "bbb");
        System.out.println(user);
    }

    @Test
    public void loginTest2() {
        User user = userService.login2("u2", "bbb");
        System.out.println(user);
    }

    @Test
    public void getMassageTest() {
        User user = userService.getMassage("u12");
        System.out.println(user);
    }

    @Test
    public void updateMassageTest() {
        userService.updateMassage("4541","小明","13546478795","男","1998-4-3");
        System.out.println(userService.getMassage("4541"));
    }

    @Test
    public void changeRoleTest() {
        userService.changeRole("u1","0");
        System.out.println(userService.getUserByID("u1").getRole());
    }

    @Test
    public void changePwd1Test() {
        boolean a = userService.changePwd1("4541", "pwd" ,"bbb");
        System.out.println(a);
    }

    @Test
    public void changePwd2Test() {
        boolean a = userService.changePwd2("4541","ccc");
        System.out.println(a);
    }


    @Test
    public void getUserByIDTest() {
        User a = userService.getUserByID("4541");
        String jsonOutput = JSON.toJSONString(a);
        User user = JSON.parseObject(jsonOutput,User.class);
        User b = userService.getMassage(user.getUserID());
        System.out.println(b);

    }

    @Test
    public void getUserListTest() {
        List<User> a = userService.getUserList();
        String jsonOutput = JSON.toJSONString(a);

        System.out.println(a);
    }

    @Test
    public void getUserByNameTest() {
        List<User> a = userService.getUserByName("created user");
        System.out.println(a);
    }


    @Test
    public void createNewPlanTest() {
        userService.createNewPlan("created plan",
                "heading",
                new Date(),
                new Date(),
                "this is for test");
        System.out.println(userService.getPlanList());
    }

    @Test
    public void createNewGroupTest() {
        userService.createNewGroup("created group", "this is for test");
        System.out.println(userService.getGroupList());
    }

    @Test
    public void deletePlanByIDTest(){
        userService.deletePlanByID("p127");
        System.out.println(userService.getPlanList());
    }

    @Test
    public void updatePlanTest(){
        userService.updatePlan("p125","hhhhh","xxx",
                new Date(), new Date(), "change");
        System.out.println(userService.getPlanList());
    }
}

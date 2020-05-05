import com.done.entity.User;
import com.done.service.impl.UserServiceImpl;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ServiceImplTest extends BaseTest {

    @Autowired
    private UserServiceImpl userService;

    @Test
    public void createNewUserTest() {
        String id = userService.createNewUser("45454", "created user","pwd");
        System.out.println(id);
    }

    @Test
    public void loginTest() {
        User user = userService.login("u1", "aaa");
        System.out.println(user);
    }

    @Test
    public void changePwd1Test() {
        boolean a = userService.changePwd1("u12", "aaa" ,"bbb");
        System.out.println(a);
    }

    @Test
    public void changePwd2Test() {
        boolean a = userService.changePwd2("u123","ccc");
        System.out.println(a);
    }

    @Test
    public void createNewPlanTest() {
        userService.createNewPlan("created plan", "this is for test");
        System.out.println(userService.getPlanList());
    }

    @Test
    public void createNewGroupTest() {
        userService.createNewGroup("created group", "this is for test");
        System.out.println(userService.getGroupList());
    }
}

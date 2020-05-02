import com.done.service.impl.UserServiceImpl;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ServiceImplTest extends BaseTest {

    @Autowired
    private UserServiceImpl userService;

    @Test
    public void createNewUserTest() {
        userService.createNewUser("created user", "pwd");
        System.out.println(userService.getUserList());
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

import com.done.service.impl.UserServiceImpl;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ServiceImplTest extends BaseTest {

    @Autowired
    private UserServiceImpl userService;

    @Test
    public void userServiceTest() {
        System.out.println(userService.getById("u1"));
        System.out.println(userService.getList());
    }
}

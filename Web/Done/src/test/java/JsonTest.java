import com.alibaba.fastjson.JSONObject;
import com.done.dao.UserDAO;
import com.done.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.DateFormat;

public class JsonTest extends BaseTest {

    @Autowired
    private UserDAO userDAO;

    @Test
    public void test() {
        User user = userDAO.queryByID("u1");
        String jsonStr = JSONObject.toJSONString(user);
        System.out.println("bean to json: " + jsonStr);
        user = JSONObject.toJavaObject(JSONObject.parseObject(jsonStr), User.class);
        System.out.println("json to bean: " + user);
    }
}

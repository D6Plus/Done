import com.done.dao.GroupDAO;
import com.done.entity.Group;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
@RunWith(SpringJUnit4ClassRunner.class)
// 告诉junit spring配置文件
@ContextConfiguration({ "classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml" })
public class GroupTest {
    @Autowired
    GroupDAO groupDAO;

    @Test
    public void testInsertGroup(){
        Group group=new Group();
        group.setGroupDescribe("草泥马啊");
        group.setGroupName("你妈好像死了啊？");
        groupDAO.insertGroup(group);
    }
}

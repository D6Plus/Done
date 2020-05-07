import com.done.dao.GroupDAO;
import com.done.entity.Group;
import com.done.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
// 告诉junit spring配置文件
@ContextConfiguration({ "classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml" })
public class GroupTest {
    @Autowired
    GroupDAO groupDAO;


    /*//小组创建
    @Test
    public void testInsertGroup(){
        Group group=new Group();
        group.setGroupDescribe("草泥马2号");
        group.setGroupName("草泥马草泥马");
        User user=new User();
        user.setUserID("ZENGgg");
        user.setPwd("xianggeniub123456");
        groupDAO.insertGroup(group);
        groupDAO.insertUserrole(group,user);
    }


    //加入小组
    @Test
    public void testJoinGroup(){
        User user=new User();
        Group group=new Group();
        user.setUserID("xiangge789");
        user.setPwd("951753");
        group.setGroupDescribe("我们是冠军");
        group.setGroupName("RNG");
        group.setGroupID(22);
        System.out.println(group);
        groupDAO.joinGroup(user,group);
    }

    //退出小组
    @Test
    public void testquitGroup(){
        User user =new User();
        Group group=new Group();
        user.setUserID("HGNB");
        user.setPwd("123132");
        group.setGroupID(5);
        group.setGroupName("nimasile");
        groupDAO.quitGroup(user,group);

    }*/

    //查询所有小组
    @Test
    public void testqueryAllGroup(){
        List<Group> group=groupDAO.queryAllGroup();
        for(Group group1:group){
            System.out.println(group1);
        }
    }

    //通过名字查询小组
    @Test
    public void testqueryGroupByName(){
        String s="草泥马草泥马";
        List<Group> group=groupDAO.queryGroupByName(s);
        for(Group group1:group){
            System.out.println(group1);
        }
    }
}

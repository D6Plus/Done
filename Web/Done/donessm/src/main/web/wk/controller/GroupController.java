package wk.controller;

import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import wk.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import wk.entity.Group;
import wk.service.GroupService;

import java.util.List;
import java.util.Map;

/**
 * 功能描述：小组控制层
 */
@Controller
@ResponseBody
@CrossOrigin
@RequestMapping("/Group")
public class GroupController {
    @Autowired
    @Qualifier("GroupService")
    private GroupService groupService;//注入  放入ioc管理

    /**
     * 创建小组控制器
     * @param map
     */
    @RequestMapping(value = "/insertGroup",produces = "application/json;charset=utf-8")
    @ResponseBody
    public void insertGroup(@RequestBody Map<String,Object> map){
        Group group=(Group)map.get("Group");
        User user=(User)map.get("User");
        System.out.println("接受到来自前台的json对象转换为类对象"+group);
        System.out.println("接受到来自前台的json对象转换为类对象"+user);
        groupService.insertGroup(group);
    }

    /**
     * 加入小组控制器
     * @param map
     */
    @RequestMapping(value="/joinGroup",produces = "application/json;charset=utf-8")
    @ResponseBody
    public void joinGroup(@RequestBody Map<String,Object> map){
        Group group=(Group)map.get("Group");
        User user=(User)map.get("User");
        System.out.println("接受来自前台JSON对象转化为对象"+group);
        System.out.println("接受来自前台JSON的转化对象"+user);
        groupService.joinGroup(group,user);
    }

    /**
     * 退出小组控制器
     * @param map
     */
    @RequestMapping(value = "/quitGroup",produces = "application/json;charset=utf-8")
    @ResponseBody
    public boolean quitGroup(@RequestBody Map<String,Object> map){
        Group group=(Group)map.get("Group");
        User user=(User)map.get("User");
        System.out.println("接受来自前台JSON对象转化为对象"+group);
        System.out.println("接受来自前台JSON的转化对象"+user);
        return groupService.quitGroup(user,group);
    }

    /**
     * 查询所有小组
     * @return
     */
    @RequestMapping(value = "/queryAllGroup")
    @ResponseBody
    public JSONArray queryAllGroup(){
        List<Group> groupList=groupService.queryAllGroup();
        JSONArray jsonOutput=JSONArray.fromObject(groupList);
        return jsonOutput;
    }

    /**
     * 通过名字查询小组
     * @param groupName
     * @return
     */
    @RequestMapping(value = "/queryGroupByName",produces = "application/json;charset=utf-8")
    @ResponseBody
    public List<Group> queryGroupByName(@RequestBody String groupName){
        List<Group> groupList=groupService.queryGroupByName(groupName);
        JSONArray jsonOutput=JSONArray.fromObject(groupList);
        return jsonOutput;
    }
}

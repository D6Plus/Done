package wk.controller;

import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mock.web.DelegatingServletInputStream;
import org.springframework.web.bind.annotation.*;
import wk.entity.userrole;
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
     * 创建小组
     */
    @RequestMapping(value = "/insertGroup",produces = "application/json;charset=utf-8")
    @ResponseBody
    public int insertGroup(@RequestParam String groupName,@RequestParam String groupDescribe,@RequestParam String userID){
        Group group=new Group();
        group.setGroupDescribe(groupDescribe);
        group.setGroupName(groupName);
        int result;
        result=groupService.insertGroup(group);
        result=groupService.insertuserrole(group,userID);
        return result;
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
    @RequestMapping(value = "/queryAllGroup",produces = "application/json;charset=utf-8")
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
    public List<Group> queryGroupByName( @RequestParam String groupName){
        List<Group> groupList=groupService.queryGroupByName(groupName);
        JSONArray jsonOutput=JSONArray.fromObject(groupList);
        return jsonOutput;
    }

    /**
     * 通过ID查询小组
     * @param ID
     * @return
     */
    @RequestMapping(value="/queryGroupByID",produces = "application/json;charset=utf-8")
    @ResponseBody
    public Group queryGroupByID(@RequestParam String ID){
        Group group=new Group();
        group=groupService.queryGroupByID(ID);
        JSONArray jsonOutput=new JSONArray();
        return group;
    }


    /**
     * 用户查询自己的职位
     * @param userID
     * @param groupID
     * @return
     */
    @RequestMapping(value = "/queryRoleByID",produces = "application/json;charset=utf-8")
    @ResponseBody
    public userrole queryRoleByID(@RequestParam String userID, @RequestParam String groupID){
        userrole role;
            role=groupService.queryRoleByID(userID,groupID);
        if(role==null) {
            role=new userrole();
            role.setRole("您不在该小组内");
        }
        else if(role.getRole().equals('1'))
            role.setRole("管理员");

        else if(role.getRole().equals('2'))
            role.setRole("普通成员");
        else
        role.setRole("群主");
        return role;
    }

    /**
     * 用户查询所加入的所有小组
     * @param userID
     * @return
     */
    @RequestMapping(value="/queryAllJoinGroup",produces = "application/json;charset=utf-8")
    @ResponseBody
    public List<Group> queryAllJoinGroup(@RequestParam String userID){
        List<Group> groups=groupService.queryAllJoinGroup(userID);
        return groups;
    }

    /**
     * 查询组内所有成员
     * @param groupID
     * @return
     */
    @RequestMapping(value = "/queryAllMemberInGroup",produces = "application/json;charset=utf-8")
    @ResponseBody
    public List<User> queryAllMemberInGroup(@RequestParam String groupID){
        List<User> users=groupService.queryAllMemberInGroup(groupID);
        return users;
    }

    /**
     * 更新小组信息
     * @param groupID
     * @param groupName
     * @param groupDescribe
     * @param userID
     * @return
     */
    @RequestMapping(value = "updateGroupinfo",produces = "application/json;charset=utf-8")
    @ResponseBody
    public int updateGroupinfo(@RequestParam String groupID,@RequestParam String groupName,@RequestParam String groupDescribe,@RequestParam String userID){
        int success=0;
        userrole userrole=groupService.queryUserrole(userID,groupID);
        if(userrole.getRole().equals("1")||userrole.getRole().equals("0"))
            success=groupService.updateGroupinfo(groupID,groupName,groupDescribe);
        return success;
    }

    @RequestMapping(value="kickMember",produces ="application/json;charset=utf-8" )
    @ResponseBody
    public int kickMember(@RequestParam String userID,@RequestParam String groupID){
        int success=0;
        userrole userrole=groupService.queryRoleByID(userID,groupID);
        if(userrole.getRole().equals("1")||userrole.getRole().equals("0"))
            success=0;
        else
            success=groupService.kickMember(userID,groupID);
        return success;
    }
}

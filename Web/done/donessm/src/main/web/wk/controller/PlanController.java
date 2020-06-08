package wk.controller;

import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import wk.entity.Group;
import wk.entity.Plan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import wk.service.PlanService;
import wk.service.UserService;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 功能描述：小组控制层
 */
@CrossOrigin
@Controller
@RequestMapping("/Plan")
public class PlanController {
    @Qualifier("UserService")
    @Autowired
    private UserService userService;

    @Qualifier("PlanService")
    @Autowired
    private PlanService planService;

    @RequestMapping(value = "/getPlanListByUserID",produces = "application/json;charset=utf-8")
    @ResponseBody
    public List<Plan> getPlanListByUserID(@RequestParam String userID){
        return planService.getPlanListByUserID(userID);
    }

    @RequestMapping(value = "/getPlanById",produces = "application/json;charset=utf-8")
    @ResponseBody
    public Plan getPlanById(@RequestParam String planID){
        return planService.getPlanById(planID);
    }

    @RequestMapping(value = "/createNewPlan",produces = "application/json;charset=utf-8")
    @ResponseBody
    public boolean createNewPlan(
            @RequestParam String planName, @RequestParam String planHeading,
            @RequestParam  String planRelease,
            @RequestParam  String planDeadline,
            @RequestParam String planContent){

        return  planService.createNewPlan(planName,planHeading,planRelease,planDeadline,planContent);
    }

    @RequestMapping(value = "/getPlanRole",produces = "application/json;charset=utf-8")
    @ResponseBody
    public  String getPlanRole(@RequestParam String userID,@RequestParam String planID){

        return planService.getPlanRole(userID,planID);
    }

    @RequestMapping(value = "/updatePlan",produces = "application/json;charset=utf-8")
    @ResponseBody
    public boolean updatePlan(@RequestParam String planID, @RequestParam String planName,
                              @RequestParam String planHeading,
                              @RequestParam  String planRelease,
                              @RequestParam  String planDeadline,
                              @RequestParam String planContent){

        return planService.updatePlan(planID, planName, planHeading, planRelease, planDeadline, planContent);
    }

    /**
     * 创建计划控制器
     * @param map
     *//*
    @RequestMapping(value = "/creatPlan",produces = "application/json;charset=utf-8")
    @ResponseBody
    public boolean insertPlan(@RequestBody Map<String,Object> map){
        Plan plan=(Plan) map.get("Plan");
        userService.createNewPlan(plan.getPlanName(),plan.getPlanHeading(),
                plan.getPlanRelease(),plan.getPlanDeadline(),plan.getPlanDescribe());
        return true;
    }
*/
    /**
     * 删除计划控制器
     * @param map
     */
    @RequestMapping(value="/deletePlan",produces = "application/json;charset=utf-8")
    @ResponseBody
    public boolean deletePlan(@RequestBody Map<String,Object> map){
        Plan plan=(Plan)map.get("Plan");
        return userService.deletePlanByID(plan.getPlanID());

    }

    /**
     * 查询所有计划控制器
     * @return
     */
    @RequestMapping(value = "/queryallPlan",produces = "application/json;charset=utf-8")
    @ResponseBody
    public List<Plan> queryallPlan(){
        return userService.getPlanList();
    }

    /**
     * 通过计划命名查询计划
     * @return
     */
    @RequestMapping(value = "/queryPlanByName", method = RequestMethod.GET)
    @ResponseBody
    public List<Plan> queryPlanByName(@RequestParam String planName){
        List<Plan> planList=userService.getPlanByName(planName);
        JSONArray jsonOutput=JSONArray.fromObject(planList);
        return jsonOutput;
    }

    /**
     * 通过id查询计划
     * @param planID
     * @return
     */
    @RequestMapping(value = "/queryPlanByID",produces = "application/json;charset=utf-8",method = RequestMethod.GET)
    @ResponseBody
    public Plan queryPlanByID(@RequestParam String planID){
        return userService.getPlanByID(planID);
    }


}
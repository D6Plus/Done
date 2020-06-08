package wk.service;

import wk.entity.Plan;

import java.util.Date;
import java.util.List;

public interface PlanService {
    //查询所有计划
    List<Plan> getPlanListByUserID(String userID);
    //获取计划详情
    Plan getPlanById(String planID);
    //计划创建
    boolean createNewPlan(String planName, String planHeading,
                          String planRelease, String planDeadline, String planContent);
    //用户对应计划权限查询
    String getPlanRole(String userID, String planID);

    //计划编辑
    boolean updatePlan(String planID, String planName,
                       String planHeading, String planRelease,
                       String planDeadline, String planContent);
}

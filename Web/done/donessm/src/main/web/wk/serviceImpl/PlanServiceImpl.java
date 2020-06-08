package wk.serviceImpl;

import wk.dao.PlanDAO;
import wk.entity.Plan;
import wk.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("PlanService")
public class PlanServiceImpl implements PlanService {

    @Autowired(required = false)
    private PlanDAO planDAO;

    @Override
    public List<Plan> getAllPlan() {
        return planDAO.queryAll();
    }

    @Override
    public boolean deletePlanByID(String planID) {
        planDAO.deletePlanByID(planID);
        return true;
    }

    @Override
    public List<Plan> getPlanListByUserID(String userID) {

        return planDAO.getPlanListByUserID(userID);
    }

    @Override
    public Plan getPlanById(String planID) {
        return planDAO.queryByID(planID);
    }

    @Override
    public boolean createNewPlan(String planName, String planHeading, String planRelease,
                                 String  planDeadline, String planContent) {
        String PlanID = "p" + (Integer.parseInt(planDAO.getLastID().substring(1)) + 1);
        planDAO.insertPlan(PlanID, planName, planHeading,
                planRelease, planDeadline, planContent);
        return true;
    }

    @Override
    public String getPlanRole(String userID, String planID) {
        int i=planDAO.getUserPlanByPlanID(userID, planID);
        if(0==i) {
            String groupID = planDAO.getGroupIDByPlanID(planID);
            if(groupID==null){
                return "未找到该计划";
            }
            String r = planDAO.getRoleByGroupIDUserID(groupID, userID);
            return "组ID为"+groupID+"的"+r;
        }else {
            return "管理员";
        }
    }

    @Override
    public boolean updatePlan(String planID, String planName,
                              String planHeading, String  planRelease,
                              String  planDeadline, String planContent) {
        planDAO.updatePlan(planID, planName, planHeading,
                planRelease, planDeadline, planContent);
        return true;
    }
}

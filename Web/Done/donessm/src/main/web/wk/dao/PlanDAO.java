package wk.dao;

import wk.entity.Plan;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PlanDAO {
    Plan queryByID(@Param("planID") String planID);

    List<Plan> queryByName(@Param("planName") String planName);

    List<Plan> queryAll();

    String getLastID();

    void insertPlan(@Param("planID") String planID,
                    @Param("planName") String planName,
                    @Param("planHeading") String planHeading,
                    @Param("planRelease") Date planRelease,
                    @Param("planDeadline") Date planDeadline,
                    @Param("planDescribe") String planDescribe);

    void deletePlanByID(@Param("planID")String planID);

    void updatePlan(@Param("planID") String planID,
                    @Param("planName") String planName,
                    @Param("planHeading") String planHeading,
                    @Param("planRelease") Date planRelease,
                    @Param("planDeadline") Date planDeadline,
                    @Param("planDescribe") String planDescribe);

    void insertPlan(String newPlanID, String planName, String planDescribe);
}

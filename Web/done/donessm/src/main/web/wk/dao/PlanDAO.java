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

    List<Plan> getPlanListByUserID(@Param("userID") String userID);
    List<Plan> getPlanListByGroupID(@Param("groupID") String groupID);


    int getUserPlanByPlanID(@Param("userID") String userID,
                            @Param("planID") String planID);

    String getGroupIDByPlanID(@Param("planID") String planID);

    String getRoleByGroupIDUserID(@Param("groupID") String groupID,
                                  @Param("userID") String userID);

    void insertPlan(@Param("planID") String planID,
                    @Param("planName") String planName,
                    @Param("planHeading") String planHeading,
                    @Param("planRelease") String  planRelease,
                    @Param("planDeadline") String  planDeadline,
                    @Param("planContent") String planContent);

    void insertUserPlan(@Param("userID") String userID,
                        @Param("planID") String planID
    );

    void insertGroupPlan(@Param("groupID") String groupID,
                         @Param("planID") String planID
    );

    void deletePlanByID(@Param("planID") String planID);

    void updatePlan(@Param("planID") String planID,
                    @Param("planName") String planName,
                    @Param("planHeading") String planHeading,
                    @Param("planRelease") String  planRelease,
                    @Param("planDeadline") String planDeadline,
                    @Param("planContent") String planContent);

    void insertPlan(String newPlanID, String planName, String planContent);
}

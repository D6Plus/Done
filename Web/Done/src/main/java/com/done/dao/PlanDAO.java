package com.done.dao;

import com.done.entity.Plan;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlanDAO {
    Plan queryByID(@Param("planID") String planID);
    List<Plan> queryAll();
}

package com.done.dao;

import com.done.entity.Plan;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PlanDAO {
    Plan queryByID(@Param("planID") String planID);
    List<Plan> queryAll();
}

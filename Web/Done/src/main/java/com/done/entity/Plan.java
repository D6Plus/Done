package com.done.entity;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.stereotype.Component;

@Component
public class Plan {

    @JSONField(name = "planID")
    private String planID;
    @JSONField(name = "planName")
    private String planName;
    @JSONField(name = "planDescribe")
    private String planDescribe;

    public String getPlanID() {
        return planID;
    }

    public String getPlanName() {
        return planName;
    }

    public String getPlanDescribe() {
        return planDescribe;
    }

    public void setPlanID(String planID) {
        this.planID = planID;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public void setPlanDescribe(String planDescribe) {
        this.planDescribe = planDescribe;
    }

    @Override
    public String toString() {
        return "Plan{" +
                "planID='" + planID + '\'' +
                ", planName='" + planName + '\'' +
                ", planDescribe='" + planDescribe + '\'' +
                "}\n";
    }
}

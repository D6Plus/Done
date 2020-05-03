package com.done.entity;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.stereotype.Component;

@Component
public class Plan {

    @JSONField(name = "planID")
    private String planID;
    @JSONField(name = "planName")
    private String planName;
    @JSONField(name = "planContent")
    private String planContent;

    public String getPlanID() {
        return planID;
    }

    public String getPlanName() {
        return planName;
    }

    public String getplanContent() {
        return planContent;
    }

    public void setPlanID(String planID) {
        this.planID = planID;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public void setplanContent(String planContent) {
        this.planContent = planContent;
    }

    @Override
    public String toString() {
        return "Plan{" +
                "planID='" + planID + '\'' +
                ", planName='" + planName + '\'' +
                ", planDescribe='" + planContent + '\'' +
                "}\n";
    }
}

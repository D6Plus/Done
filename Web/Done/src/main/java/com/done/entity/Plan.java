package com.done.entity;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Plan {

    @JSONField(name = "planID")
    private String planID;
    @JSONField(name = "planName")
    private String planName;
    @JSONField(name = "planHeading")
    private String planHeading;
    @JSONField(name = "planRelease")
    private Date planRelease;
    @JSONField(name = "planDeadline")
    private Date planDeadline;
    @JSONField(name = "planDescribe")
    private String planDescribe;

    public String getPlanID() {
        return planID;
    }

    public String getPlanName() {
        return planName;
    }

    public String getPlanHeading() {return planHeading;}

    public Date getPlanRelease() {return planRelease;}

    public Date getPlanDeadline() {return planDeadline;}

    public String getPlanDescribe() {
        return planDescribe;
    }

    public void setPlanID(String planID) {
        this.planID = planID;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public void setPlanHeading(String planHeading) {this.planHeading = planHeading;}

    public void setPlanRelease(Date planRelease) {this.planRelease = planRelease;}

    public void setPlanDeadline(Date planDeadline) {this.planDeadline = planDeadline;}

    public void setPlanDescribe(String planDescribe) {
        this.planDescribe = planDescribe;
    }


    @Override
    public String toString() {
        return "Plan{" +
                "planID='" + planID + '\'' +
                ", planName='" + planName + '\'' +
                ", planHeading='" + planHeading + '\'' +
                ", planRelease='" + planRelease + '\'' +
                ", planDeadline='" + planDeadline + '\'' +
                ", planDescribe='" + planDescribe + '\'' +
                "}\n";
    }
}

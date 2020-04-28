package com.done.entity;

public class Plan {
    private String planID;
    private String planName;
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
                '}';
    }
}

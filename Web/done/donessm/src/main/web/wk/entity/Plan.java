package wk.entity;

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
    private String planRelease;
    @JSONField(name = "planDeadline")
    private String  planDeadline;
    @JSONField(name = "planContent")
    private String planContent;

    public String getPlanID() {
        return planID;
    }

    public String getPlanName() {
        return planName;
    }

    public String getPlanHeading() {return planHeading;}

    public String  getPlanRelease() {return planRelease;}

    public String  getPlanDeadline() {return planDeadline;}

    public String getPlanContent() {
        return planContent;
    }

    public void setPlanID(String planID) {
        this.planID = planID;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public void setPlanHeading(String planHeading) {this.planHeading = planHeading;}

    public void setPlanRelease(String  planRelease) {this.planRelease = planRelease;}

    public void setPlanDeadline(String  planDeadline) {this.planDeadline = planDeadline;}

    public void setPlanContent(String planContent) {
        this.planContent = planContent;
    }


    @Override
    public String toString() {
        return "Plan{" +
                "planID='" + planID + '\'' +
                ", planName='" + planName + '\'' +
                ", planHeading='" + planHeading + '\'' +
                ", planRelease='" + planRelease + '\'' +
                ", planDeadline='" + planDeadline + '\'' +
                ", planDescribe='" + planContent + '\'' +
                "}\n";
    }
}

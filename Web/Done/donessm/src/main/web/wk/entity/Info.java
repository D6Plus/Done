package wk.entity;

import com.alibaba.fastjson.annotation.JSONField;

public class Info {
    @JSONField(name = "userID")
    private String userID;
    @JSONField(name = "infoID")
    private String infoID;
    @JSONField(name = "infoName")
    private String infoName;
    @JSONField(name = "infoSelf")
    private String infoSelf;
    @JSONField(name = "status")
    private String status;

    public String getUserID() {
        return userID;
    }

    public String getInfoID() {
        return infoID;
    }

    public String getInfoName() {
        return infoName;
    }

    public String getInfoSelf() {
        return infoSelf;
    }

    public String getStatus() { return status; }

    public void setUserID(String userID) { this.userID = userID; }

    public void setInfoID(String infoID) { this.infoID = infoID; }

    public void setInfoName(String infoName) { this.infoName = infoName; }

    public void setInfoSelf(String infoSelf) { this.infoSelf = infoSelf; }

    public void setStatus(String status) { this.status = status; }

}

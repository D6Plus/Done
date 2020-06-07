package wk.entity;

import org.springframework.stereotype.Component;

@Component
public class userrole {
    private String userID;
    private String groupID;
    private String role;

    public String getGroupID() {
        return groupID;
    }

    public void setGroupID(String groupID) {
        this.groupID = groupID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "GroupMember{" +
                "userID='" + userID + '\'' +
                ", groupID='" + groupID + '\'' +
                ", role='" + role + '\'' +
                "}\n";
    }
}

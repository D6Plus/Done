package com.done.entity;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.stereotype.Component;

@Component
public class Group {

    @JSONField(name = "groupID")
    private String groupID;
    @JSONField(name = "groupName")
    private String groupName;
    @JSONField(name = "groupDescribe")
    private String groupDescribe;

    public String getGroupID() {
        return groupID;
    }

    public String getGroupName() {
        return groupName;
    }

    public String getGroupDescribe() {
        return groupDescribe;
    }

    public void setGroupID(String groupID) {
        this.groupID = groupID;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public void setGroupDescribe(String groupDescribe) {
        this.groupDescribe = groupDescribe;
    }

    @Override
    public String toString() {
        return "Group{" +
                "groupID='" + groupID + '\'' +
                ", groupName='" + groupName + '\'' +
                ", groupDescribe='" + groupDescribe + '\'' +
                '}';
    }
}

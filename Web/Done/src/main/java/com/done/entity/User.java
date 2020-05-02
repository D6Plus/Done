package com.done.entity;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.stereotype.Component;

@Component
public class User {

     @JSONField(name = "userID")
     private String userID;
     @JSONField(name = "userName")
     private String userName;
     @JSONField(name = "pwd")
     private String pwd;
     @JSONField(name = "role")
     private String role;

     public String getUserID() {
          return userID;
     }

     public String getUserName() {
          return userName;
     }

     public String getPwd() {
          return pwd;
     }

     public String getRole() {
          return role;
     }

     public void setUserID(String userID) {
          this.userID = userID;
     }

     public void setUserName(String userName) {
          this.userName = userName;
     }

     public void setPwd(String pwd) {
          this.pwd = pwd;
     }

     public void setRole(String role) {
          this.role = role;
     }

     @Override
     public String toString() {
          return "User{" +
                  "userID='" + userID + '\'' +
                  ", userName='" + userName + '\'' +
                  ", pwd='" + pwd + '\'' +
                  ", role='" + role + '\'' +
                  "}\n";
     }
}

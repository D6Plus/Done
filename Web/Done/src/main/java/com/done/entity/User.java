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
     @JSONField(name = "pNum")
     private String pNum;
     @JSONField(name = "userSex")
     private String userSex;
     @JSONField(name = "userBirth")
     private String userBirth;

     public String getUserID() {
          return userID;
     }

     public String getUserName() {
          return userName;
     }

     public String getPwd() {
          return pwd;
     }

     public String getpNum() {
          return pNum;
     }

     public String getUserSex() {
          return userSex;
     }

     public String getUserBirth() {
          return userBirth;
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

     public void setpNum(String pNum) { this.pNum = pNum; }

     public void setUserSex(String userSex) {
          this.userSex = userSex;
     }

     public void setUserBirth(String userBirth) {
          this.userBirth = userBirth;
     }

     @Override
     public String toString() {
          return "User{" +
                  "userID='" + userID + '\'' +
                  ", userName='" + userName + '\'' +
                  ", pwd='" + pwd + '\'' +
                  ", role='" + role + '\'' +
                  ", pNum='" + pNum + '\'' +
                  ", userSex='" + userSex + '\'' +
                  ", userBirth='" + userBirth + '\'' +
                  "}\n";
     }
}

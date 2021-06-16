package com.example.demo.entity;

public class User {
    public boolean getUserGrade;
    public int type;
    private int userId;
    private int actionId;
    private String userDate;
    private String userName;
    private String userAddress;
    private int userGrade;
    private int actionGrade;


    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getActionId() {
        return actionId;
    }

    public void setActionId(int actionId) {
        this.actionId = actionId;
    }


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserDate() {
        return userDate;
    }

    public void setUserDate(String userDate) {
        this.userDate = userDate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public int getUserGrade() {
        return userGrade;
    }

    public void setUserGrade(int userGrade) {
        this.userGrade = userGrade;
    }

    public int getActionGrade() {
        return actionGrade;
    }


    public void setActionGrade(int actionGrade) {
        this.actionGrade = actionGrade;
    }
    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userDate=" + userDate +
                ", userName='" + userName + '\'' +
                ", userAddress='" + userAddress + '\'' +
               // ", userGrade='" + userGrade + '\'' +
                '}';
    }
}

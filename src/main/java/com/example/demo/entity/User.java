package com.example.demo.entity;
//别名： model层 ，domain层
//用途： 实体层，用于存放我们的实体类，与数据库中的属性值基本保持一致，实现set和get的方法。
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
    private int oldGrade;


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
    public int getOldGrade() {
        return oldGrade;
    }


    public void setOldGrade(int oldGrade) {
        this.oldGrade = oldGrade;
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

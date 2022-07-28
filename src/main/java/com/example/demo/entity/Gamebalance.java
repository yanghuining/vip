package com.example.demo.entity;

public class Gamebalance {
    private int id;
    private int type;
    private int kind;
    private String name;
    private int budget;
    private int price;
    private int paid;
    private int balance;
    private int status;
    private String remark;
    private String creattime;
    private String updatetime;
    private int aciton;




    public void setType(Integer type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public void setKind(Integer kind) {
        this.kind = kind;
    }

    public int getKind() {
        return kind;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setPaid(int paid) {
        this.paid = paid;
    }

    public int getPaid() {
        return paid;
    }
    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }


    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }


    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreattime() {
        return creattime;
    }

    public void setCreattime(String creattime) {
        this.creattime = creattime;
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }

    public void setAction(Integer aciton) {
        this.aciton = aciton;
    }

    public int getAciton() {
        return aciton;
    }

}

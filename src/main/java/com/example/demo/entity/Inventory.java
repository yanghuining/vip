package com.example.demo.entity;

public class Inventory {
    private int newId;

    private String name;
    private String remark;
    private int quantity;
    private double price;
    public int getNewId() {
        return newId;
    }

    public void setNewId(int newId) {
        this.newId = newId;
    }


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
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


    @Override
    public String toString() {
        return "Inventory{" +
                "newId=" + newId +
                ", name='" + name + '\'' +
                ", quantity='" + quantity + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}

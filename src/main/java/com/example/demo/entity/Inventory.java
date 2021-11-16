package com.example.demo.entity;

public class Inventory {
    private Integer newId;
    private int id;
    private String name;
    private String remark;
    private int quantity;
    private int actionquantity;
    private int toId;
    private double price;
    private int oldquantity;
    private  int type;
    private String date;



    public Integer getNewId() {
        if(newId!=null)
        return newId;
        return 0;
    }

    public void setNewId(Integer newId) {
        this.newId = newId;
    }

    public int getId() {
        return id;
    }



    public void setOldquantity(Integer oldquantity) {
        this.oldquantity = oldquantity;
    }

    public int getOldquantity() {
        return oldquantity;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getToId() {
        return toId;
    }

    public void setToId(int toId) {
        this.toId = toId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    public int getActionquantity() {
        return actionquantity;
    }

    public void setActionquantity(int actionquantity) {
        this.actionquantity = actionquantity;
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
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    @Override
    public String toString() {
        return "Inventory{" +
                "newId=" + newId +
                ", name='" + name + '\'' +
                ", quantity='" + quantity + '\'' +
                ", remark" +
                "='" + remark + '\'' +
                '}';
    }
}

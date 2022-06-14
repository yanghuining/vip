package com.example.demo.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CodeEnum {

    ERROR(1, "上架数量超过实际库存量"),
    SUUCESS(2, "上架成功，库存量已减少，机器量增加");


    private int val;
    private String name;


    public String getname() {
        return this.name;
    }
}

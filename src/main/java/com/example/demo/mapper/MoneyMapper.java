package com.example.demo.mapper;

import com.example.demo.entity.Inventory;
import org.apache.ibatis.annotations.Mapper;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Mapper
public interface MoneyMapper {



    public  int todayquantity(String date, String afterdate);
    public double todaypay(String date, String afterdate);




}

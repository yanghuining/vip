package com.example.demo.service;

import ch.qos.logback.classic.Logger;
import com.example.demo.mapper.MoneyMapper;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


@Service
public class MoneyService {

    @Autowired
    private MoneyMapper moneyMapper;

    public  Logger logger = (Logger) LoggerFactory.getLogger(MoneyService.class);
    public Map today(String date) throws ParseException {
        // Logger logger = Logger.getLogger(this.getClass());
        //Map<String,Double> map = new HashMap<String,Double>();
       if(date==null){
            Calendar calendar = Calendar.getInstance(); // gets current instance of the calendar
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            calendar.set(Calendar.SECOND,0); //这是将当天的【秒】设置为0
            calendar.set(Calendar.MINUTE,0); //这是将当天的【分】设置为0
            calendar.set(Calendar.HOUR_OF_DAY,0); //这是将当天的【时】设置为0
            date=formatter.format(calendar.getTime());}
        Map map=new HashMap();
        //先转换格式为时间格式
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");//注意月份是MM
        Date newdate = simpleDateFormat.parse(date);
        System.out.println(newdate);
        //在原有时间上加一天，
        Calendar  calendar = new GregorianCalendar();
        calendar.setTime(newdate);
        calendar.add(calendar.DATE,1);
        Date datee = calendar.getTime();
        //转换为2021-11-16的格式
        String afterdate = simpleDateFormat.format(datee);
        System.out.println(date);
        System.out.println(afterdate);
        logger.info("这是log");
        logger.error("这是错误");
        //int a =moneyMapper.todayquantity(date,afterdate);
        //System.out.println(a);
        map.put("todayquantity",moneyMapper.todayquantity(date,afterdate));
        map.put("todaypay",moneyMapper.todaypay(date,afterdate));
        return  map;
    }


}

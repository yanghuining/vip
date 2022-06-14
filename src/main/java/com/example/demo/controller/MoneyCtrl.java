package com.example.demo.controller;

import com.example.demo.entity.Inventory;
import com.example.demo.service.MoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
public class MoneyCtrl {

    @Autowired
    private MoneyService moneyService;



        @RequestMapping(value="/money/today")
        @ResponseBody
        public Map today(String date) throws ParseException {
            return moneyService.today(date);
        }

}




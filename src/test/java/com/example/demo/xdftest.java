package com.example.demo;

import com.example.demo.entity.Login;
import com.example.demo.jwt.JwtUtils;
import com.example.demo.service.ApiMac;
import io.jsonwebtoken.Claims;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;


import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
@RunWith(SpringRunner.class)
@SpringBootTest
public class xdftest {

    @Test
    public void contextLoads() {
    }

    @Test
    public  void sign() {
        String sign = ApiMac.sign("795f833b63fd7b277588e3757bd97f63", "/bring/v1/student/old?activityId=510&schoolId=53&t=1679391739705&appId=api_app_wechat");
        System.out.println("签名是"+sign);
    }


    @Test
    public void testgetClaimsByToken() {


        //String token="eyJ0eXBlIjoiSldUIiwiYWxnIjoiSFM1MTIifQ.eyJzdWIiOiJhZG1pbiIsImlhdCI6MTYyOTExNjE5MiwiZXhwIjoxNjI5MTE2Nzk3fQ.dGAQ7dW1Tx6KNhqPsjdSluClRNEaz_mOIWYeyeOAz-npter-lOqCpMzN9uzmNSyLvGbfRhDCRIE49tI1rVVO6g";
        String token="eyJ0eXBlIjoiSldUIiwiYWxnIjoiSFM1MTIifQ.eyJzdWIiOiJhZG1pbiIsImlhdCI6MTYyOTM2OTExMywiZXhwIjoxNjI5MzY5NzE4fQ.L8zwIXqFRvc4Xxaeqew0HYztQ-C6tpERqyggG350I0Ve_bVFmnsNeGbuGjfCaho9lGfcJbN1XupmwGcxo4O4Ow";


        JwtUtils jwtUtils = new JwtUtils();
        Claims claim = jwtUtils.getClaimsByToken(token);
        System.out.println("chengg");
        System.out.println(claim);

    }
}

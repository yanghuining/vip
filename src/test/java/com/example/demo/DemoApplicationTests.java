package com.example.demo;

import com.example.demo.entity.Login;
import com.example.demo.jwt.JwtUtils;
import io.jsonwebtoken.Claims;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Test
    public void contextLoads() {
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

package com.example.demo.controller;

import cn.hutool.http.Header;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.Gamebalance;
import com.example.demo.service.GameService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import java.util.HashMap;
import java.util.List;
import com.alibaba.fastjson.JSON;
import okhttp3.*;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URLEncoder;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;



@RestController
public class XdfCtrl {


    // public static ResponseSpecification responseSpecification;
    String id;
    String Cookie;
    // Cookie cookie1 = new Cookie.Builder("e2e", "D9360401929BD48C8D8E4500123E35AF");
    //   "e2mf", "5695972f06af4f19b08d784bc2c88d0b"；
    public static String uri="https://nsale-activity-ms-test2.test.xdf.cn";
    @ResponseBody
    public  String gettoken( ) {

        //获取token
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("deviceId", "2115821C-C61B-4054-BFEB-854624F23F32");
        paramMap.put("email", "yanghuining2@xdf.cn");
        paramMap.put("pwdEncrypt", "1eupJPe0Utbxi4FO/q3zBA==");
        String result = HttpUtil.post("http://twxbackend-beta3.test.xdf.cn/api/e2/pwdDeviceCheckLogin", paramMap);

        System.out.println(result);
        JSONObject jsonObject = JSONObject.parseObject(result);
        String data = jsonObject.getString("data");
        JSONObject jsonObject2 = JSONObject.parseObject(data);
        String e2e = jsonObject2.getString("e2e");
        String e2mf = jsonObject2.getString("e2mf");
        System.out.println(e2e + e2mf);
        String Cookie="e2e="+e2e+";"+"e2mf="+e2mf;
        System.out.println(Cookie);
        return Cookie;

    }

    //新东方
    @RequestMapping(value = "/addactivity", method = RequestMethod.POST)
    @ResponseBody
    public  String addactivity(int type) {
        System.out.println(type);
        //获取token

        Cookie= gettoken();

        HttpRequest post = HttpUtil.createPost("https://nsale-activity-ms-test1.test.xdf.cn/ams/bringnew/save");
        // 设置头信息
        //post.header("Content-Type","text/plain");
       // post.header("sign","F139288D1593318BA230B00D2EA06DE5");
      //  post.header("Cookie","e2e=D9360401929BD48C8D8E4500123E35AF; e2mf=0ab84169d5004130a38a3262e1b22591");
        post.header("Cookie",Cookie);
        // 设置参数
        if(type==2)
        post.body("{\"schoolId\":53,\"deptCodeArr\":[\"33,青少部\",\"34,高中部\"],\"title\":\"测试创建学习机活动3\",\"dates\":[\"2022-07-27T11:00:00.000Z\",\"2023-08-31T12:00:00.000Z\"],\"pushData\":1,\"internalDistribution\":true,\"newStudentBannerUrl\":\"https://cfiles.xdf.cn/9da5e2e0-b281-498c-b364-38ff37f25dc6.jpeg\",\"oldStudentBannerUrl\":\"https://cfiles.xdf.cn/e6b959b8-ce91-4d30-bf3b-323e79dc9a5f.jpeg\",\"newStudentInfoUrl\":\"https://cfiles.xdf.cn/bc6fff8a-b4fa-4050-99eb-608c27628cb6.jpeg\",\"oldStudentInfoUrl\":\"https://cfiles.xdf.cn/70674b08-dcfc-44f9-acd0-b91ca521933a.jpeg\",\"fictitiousQrcodeUrl\":null,\"oldStudentInviteBillUrl\":\"https://cfiles.xdf.cn/df06550e-931e-404c-9db6-868582b85bb0.jpeg\",\"registerType\":3,\"distributionPattern\":2,\"promotionBillUrl\":\"https://cfiles.xdf.cn/1f23ebe3-23d8-4198-b55b-80db6a7b9a20.jpeg\",\"appShow\":1,\"oldStudentPreferentialWay\":1,\"newStudentPreferentialWay\":1,\"enrollUrl\":\"https://m.xdf.cn/study-card/course-pick?schoolId=53\",\"studentPreferentialList\":[{\"oldStudentPreferentialWay\":1,\"type\":1,\"rebateRule\":1,\"peopleCount\":1,\"collectCouponsRule\":2,\"startTime\":15,\"couponList\":[{\"ruleId\":\"10151\",\"couponAmount\":200,\"couponName\":\"小羊测试\",\"id\":\"\"}]},{\"newStudentPreferentialWay\":1,\"type\":2,\"couponList\":[{\"ruleId\":\"10299\",\"couponAmount\":1000,\"couponName\":\"测试小羊\",\"id\":\"\"}]}],\"astrictLadderPreferential\":0,\"isDraft\":0,\"deptCode\":\"33,34\",\"deptName\":\"青少部,高中部\",\"beginTime\":\"2022-07-27 19:00:00\",\"endTime\":\"2023-07-31 20:00:00\"}");
       if(type==1)
          post.body("{\n" +

                "  \"schoolId\": 53,\n" +
                "  \"beginTime\": \"2023-03-22 17:00:00\",\n" +
                "  \"endTime\": \"2024-04-07 18:00:00\",\n" +
                "  \"realPrice\": null,\n" +
                "  \"originPrice\": null,\n" +
                "  \"activityType\": 2,\n" +
                "  \"connectPhone\": null,\n" +
                "  \"title\": \"测试创建班课活动\",\n" +
                "  \"bannerUrl\": null,\n" +
                "  \"detailUrl\": null,\n" +
                "  \"shareUrl\": null,\n" +
                "  \"shareNumber\": null,\n" +
                "  \"qrcodeUrl\": null,\n" +
                "  \"status\": 1,\n" +
                "  \"creatorId\": null,\n" +
                "  \"createTime\": \"2023-03-29 16:06:14\",\n" +
                "  \"updaterId\": null,\n" +
                "  \"updateTime\": null,\n" +
                "  \"isDeleted\": false,\n" +
                "  \"schoolName\": \"洛阳\",\n" +
                "  \"shareDesc\": null,\n" +
                "  \"shareTitle\": null,\n" +
                "  \"isDraft\": 0,\n" +
                "  \"isPreferential\": 0,\n" +
                "  \"successUrl\": null,\n" +
                "  \"successName\": null,\n" +
                "  \"enable\": false,\n" +
                "  \"internalDistribution\": true,\n" +
                "  \"distributionPattern\": 2,\n" +
                "  \"oldStudentBannerUrl\": \"https://cfiles.xdf.cn/9184bbca-48ed-4cd5-8837-4e9a7a04839d.jpeg\",\n" +
                "  \"oldStudentInfoUrl\": \"https://cfiles.xdf.cn/a61ff7f5-35b3-40a7-8202-2c3de3da1f94.jpeg\",\n" +
                "  \"oldStudentInviteBillUrl\": \"https://cfiles.xdf.cn/9f2cf826-4b01-420f-9bb2-b8ef99c85c0c.jpeg\",\n" +
                "  \"promotionBillUrl\": \"https://cfiles.xdf.cn/73c42d08-50e5-4382-8303-8862240b2cf0.jpeg\",\n" +
                "  \"fictitiousQrcodeUrl\": null,\n" +
                "  \"newStudentBannerUrl\": \"https://cfiles.xdf.cn/fed62dd8-cfd4-49ec-990a-24920d151021.jpeg\",\n" +
                "  \"newStudentInfoUrl\": \"https://cfiles.xdf.cn/9a26c4d4-6644-4606-b060-52bf5ed61d42.jpeg\",\n" +
                "  \"astrictOldStudent\": 0,\n" +
                "  \"astrictNewStudent\": 0,\n" +
                "  \"astrictNewEnroll\": 1,\n" +
                "  \"oldStudentPreferentialWay\": 1,\n" +
                "  \"newStudentPreferentialWay\": 1,\n" +
                "  \"brewRuleList\": [],\n" +
                "  \"brewCashRuleList\": [],\n" +
                "  \"studentPreferentialList\": [\n" +
                "    {\n" +
                "      \"oldStudentPreferentialWay\": 1,\n" +
                "      \"astrictLadderPreferential\": 0,\n" +
                "      \"rebateRule\": 1,\n" +
                "      \"peopleCount\": 1,\n" +
                "      \"couponList\": [\n" +
                "        {\n" +
                "          \"ruleId\": \"crule-n0014399\",\n" +
                "          \"couponAmount\": \"1\",\n" +
                "          \"couponName\": \"测试\"\n" +
                "        }\n" +
                "      ],\n" +
                "      \"collectCouponsRule\": 4,\n" +
                "      \"type\": 1,\n" +
                "      \"reward\": 1\n" +
                "    },\n" +
                "    {\n" +
                "      \"newStudentPreferentialWay\": 1,\n" +
                "      \"couponList\": [\n" +
                "        {\n" +
                "          \"ruleId\": \"crule-n0014399\",\n" +
                "          \"couponAmount\": \"2\",\n" +
                "          \"couponName\": \"测试\"\n" +
                "        }\n" +
                "      ],\n" +
                "      \"type\": 2,\n" +
                "      \"reward\": 1\n" +
                "    }\n" +
                "  ],\n" +
                "  \"channelList\": null,\n" +
                "  \"email\": null,\n" +
                "  \"deptCode\": \"33,34\",\n" +
                "  \"deptName\": \"青少部,高中部\",\n" +
                "  \"astrictLadderPreferential\": 0,\n" +
                "  \"astrictOldStudentId\": null,\n" +
                "  \"astrictNewStudentId\": null,\n" +
                "  \"astrictNewEnrollId\": null,\n" +
                "  \"enrollUrl\": \"\",\n" +
                "  \"appShow\": 0,\n" +
                "  \"registerType\": 1,\n" +
                "  \"highPreferentialRuleId\": null,\n" +
                "  \"highProductId\": null,\n" +
                "  \"highClassType\": null,\n" +
                "  \"createEmail\": \"yanghuining2@xdf.cn\",\n" +
                "  \"pushData\": 2,\n" +
                "  \"uniActivityId\": null,\n" +
                "  \"endEarly\": false,\n" +
                "  \"customizePoster\": false,\n" +
                "  \"dates\": [\n" +
                "    \"2023-03-22T09:00:00.000Z\",\n" +
                "    \"2024-04-07T10:00:00.000Z\"\n" +
                "  ],\n" +
                "  \"deptCodeArr\": [\n" +
                "    \"33,青少部\",\n" +
                "    \"34,高中部\"\n" +
                "  ]\n" +
                "}");
        HttpResponse execute = post.execute();
        System.out.println(execute.body());
        return execute.body();

    }

    //新东方
    @RequestMapping(value = "/activity", method = RequestMethod.POST)
    @ResponseBody
    public  String activity() {
      /*  //获取token
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("deviceId", "2115821C-C61B-4054-BFEB-854624F23F32");
        paramMap.put("email", "yanghuining2@xdf.cn");
        paramMap.put("pwdEncrypt", "1eupJPe0Utbxi4FO/q3zBA==");
        String result= HttpUtil.post("http://twxbackend-beta3.test.xdf.cn/api/e2/pwdDeviceCheckLogin", paramMap);

        System.out.println(result);
        JSONObject jsonObject = JSONObject.parseObject(result);
        String data = jsonObject.getString("data");
        JSONObject jsonObject2 = JSONObject.parseObject(data);
        String e2e = jsonObject2.getString("e2e");
        String e2mf = jsonObject2.getString("e2mf");
        System.out.println(e2e+e2mf);*/
       Cookie= gettoken();

        //创建活动
        HttpRequest post = HttpUtil.createPost("https://nsale-activity-ms-test1.test.xdf.cn/ams/market/platform/marketactivity/next");

         //post.header("Cookie","e2e="+e2e+";"+"e2mf="+e2mf);
        post.header("Cookie",Cookie);
        // 设置参数
        post.body("{ \"schoolId\": 53,    \"deptCodeArr\": \"33,青少部\",    \"title\": \"测试专题活动\",    \"dates\": [        \"2023-05-15T07:12:00.254Z\",        \"2025-05-31T08:12:00.254Z\"    ],    \"lessonType\": 1,    \"pushData\": 1,    \"connectPhone\": \"18322077001\",    \"bannerUrl\": \"https://cfiles.xdf.cn/b9492c6b-b9f2-4f78-9059-d080372aa962.jpeg\",    \"detailUrl\": \"https://cfiles.xdf.cn/a54caf02-2433-4eb3-9b8f-f8426ce6be8e.jpeg\",    \"shareUrl\": \"https://cfiles.xdf.cn/04cd75ee-43e4-45e3-b2a8-0f157bc870bd.jpeg\",    \"shareTitle\": \"测试专题\",    \"shareDesc\": \"测试专题\",    \"posterId\": null,    \"beginTime\": \"2023-05-15 15:00:00\",    \"endTime\": \"2025-05-31 16:00:00\",    \"isDraft\": 0,    \"id\": \"\",    \"deptCode\": \"33\",    \"deptName\": \"青少部\"}"
        );
        HttpResponse execute = post.execute();
        JSONObject jsonObject3 = JSONObject.parseObject(execute.body());
        String id = jsonObject3.getString("data");
        System.out.println(execute.body());
        System.out.println(id);




        HashMap<String, Object> paramMap2 = new HashMap<>();
        paramMap2.put("schoolId", 53);
        paramMap2.put("isDraft", 0);
        paramMap2.put("showClassType", 2);
        paramMap2.put("id", id);
        paramMap2.put("classConfig", "{\"classConfigArr\":[{\"classCodes\":\"20232094\"}]}");
        String str = JSON.toJSONString(paramMap2);

        String result2 = HttpRequest.post("https://nsale-activity-ms-test1.test.xdf.cn/ams/market/platform/marketactivity/save")
                .header("Cookie",Cookie)//头信息，多个头信息多次调用此方法即可
                .header("Content-Type","application/json")//头信息，多个头信息多次调用此方法即可
               // .form(paramMap2)//表单内容
                .body(String.valueOf(str))
                .timeout(20000)//超时，毫秒
                .execute().body();
        System.out.println(result2);
        return execute.body();


    }
}

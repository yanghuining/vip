package com.example.demo.controller;

import com.example.demo.entity.Login;
import com.example.demo.entity.User;
import com.example.demo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginCtrl {
    @Autowired
    private  LoginService loginService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public int mima(Login login) {
//测试提交代码
        String result = loginService.mima(login);
        System.out.println(result);
        if (result !=null) {
            return 200 ;
        } else {
            return 500 ;
        }

    }
}


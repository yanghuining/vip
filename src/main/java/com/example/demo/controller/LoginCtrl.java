package com.example.demo.controller;

import com.example.demo.entity.Login;
import com.example.demo.entity.User;
import com.example.demo.jwt.JwtUtils;
import com.example.demo.jwt.ResultT;
import com.example.demo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginCtrl {
    @Autowired
    private  LoginService loginService;
    @Autowired
    private JwtUtils jwtUtils;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public ResultT mima(Login login) {

        String result = loginService.mima(login);
        String loginName=login.getLoginName();
        System.out.println(result);
        if (result !=null) {
            String token = jwtUtils.generateToken(loginName);
            System.out.println(token);
            return ResultT.ok().put("token", token) ;
        } else {
            return ResultT.error(1,"密码错误");
        }

    }
}


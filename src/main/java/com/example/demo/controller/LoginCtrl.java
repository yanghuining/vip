package com.example.demo.controller;
import com.example.demo.Result;
import com.example.demo.entity.Login;
import com.example.demo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


public class LoginCtrl {
    @Autowired
    LoginService loginService;

    @PostMapping(value = "/api/login")
    public Result login(@RequestBody Login login){
        return loginService.login(login);
    }
}

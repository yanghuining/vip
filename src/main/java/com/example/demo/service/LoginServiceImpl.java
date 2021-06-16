
/*package com.example.demo.service;


import com.example.demo.Result;
import com.example.demo.entity.Login;
import com.example.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.UUID;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public Result login(Login login) {
        if (StringUtils.isEmpty(login.getLoginName())){
            return new Result(400,"账号不能为空","");
        }
        if (StringUtils.isEmpty(login.getPassword())){
            return new Result(400,"密码不能为空","");
        }
        //通过登录名查询用户
        QueryWrapper<User> wrapper = new QueryWrapper();
        wrapper.eq("login_name", login.getLoginName());
        User uer=userMapper.selectOne(wrapper);
        //比较密码
        if (uer!=null&&uer.getPassword().equals(login.getPassword())){
            LoginVO loginVO=new LoginVO();
            loginVO.setId(uer.getId());
            //这里token直接用一个uuid
            //使用jwt的情况下，会生成一个jwt token,jwt token里会包含用户的信息
            loginVO.setToken(UUID.randomUUID().toString());
            loginVO.setUser(uer);
            return new Result(200,"",loginVO);
        }
        return new Result(401,"登录失败","");
    }
}*/

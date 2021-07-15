
package com.example.demo.service;


import com.example.demo.entity.Login;
import com.example.demo.mapper.LoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class LoginService {
    @Autowired
    private LoginMapper loginMapper;
    public String mima(Login login) {
   /*   if (StringUtils.isEmpty(login.getLoginName())){
            return new Result(400,"账号不能为空","");
        }
        if (StringUtils.isEmpty(login.getPassword())){
            return new Result(400,"密码不能为空","");
        }*/

        String mm = login.getPassword();
        String password = loginMapper.mima(login);
        System.out.println(mm);
        System.out.println(password);

        if (mm.equals(password)) {
            return mm;
        }

       // if (mm != password) {
      //      return ("登录失败");
      //  }
        else {
            return null;
        }

    }


}


        //通过登录名查询用户
        // QueryWrapper<User> wrapper = new QueryWrapper();
        //  wrapper.eq("login_name", login.getLoginName());
        // User uer=userMapper.selectOne(wrapper);
        //比较密码
        // if (uer!=null&&uer.getPassword().equals(login.getPassword()))
        //      return new Result(200,"",uer);
        //}
      /*  //比较密码
        if (uer!=null&&uer.getPassword().equals(login.getPassword())){
            LoginVO loginVO=new LoginVO();
            loginVO.setId(uer.getId());
            //这里token直接用一个uuid
            //使用jwt的情况下，会生成一个jwt token,jwt token里会包含用户的信息
            loginVO.setToken(UUID.randomUUID().toString());
            loginVO.setUser(uer);
            return new Result(200,"",loginVO);
        }
        */






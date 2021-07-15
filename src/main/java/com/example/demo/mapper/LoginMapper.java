
package com.example.demo.mapper;

import com.example.demo.entity.Login;
import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginMapper {

    public String mima(Login login);

}


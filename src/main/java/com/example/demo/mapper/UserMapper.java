package com.example.demo.mapper;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    public List<User> findUserByName(String userName);

    public List<User> ListUser();
    public List<User> memory(Integer userId);
    public List<User> today(String userDate);

    public List<User> queryPage(Integer startRows);

    public int getRowCount();

    public int insertUser(User user);

    public int delete(int userId);

    public int Update(User user);
    public int Cun(User user);

    public int grade(User user);

    public int insertMemory(User user);




}

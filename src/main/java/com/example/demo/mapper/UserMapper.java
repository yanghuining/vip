package com.example.demo.mapper;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
// dao层
//用途： 对数据库进行数据持久化操作，他的方法语句是直接针对数据库操作的，主要实现一些增删改查操作，在mybatis中方法主要与与xxx.xml内相互一一映射。

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

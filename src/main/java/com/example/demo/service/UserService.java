package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public List<User> findByName(String userName) {
        return userMapper.findUserByName(userName);
    }

    public List<User> queryPage(Integer startRows) {
        return userMapper.queryPage(startRows);
    }

    public int getRowCount() {
        return userMapper.getRowCount();
    }

    public User insertUser(User user) throws ParseException {
        String time =user.getUserDate();
        //格式化时间
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSX");
        Date parse = df.parse(time);
       SimpleDateFormat df2=new SimpleDateFormat("yyyy-MM-dd HH:mm");
        user.setUserDate(df2.format(parse));
        userMapper.insertUser(user);
        return user;
    }

    public List<User> ListUser(){
        return userMapper.ListUser();
    }

    public List<User> memory(Integer userId){

        return userMapper.memory(userId);
    }
    public List<User> today(String userDate){
        if(userDate==null){
            Calendar calendar = Calendar.getInstance(); // gets current instance of the calendar
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            calendar.set(Calendar.SECOND,0); //这是将当天的【秒】设置为0
            calendar.set(Calendar.MINUTE,0); //这是将当天的【分】设置为0
            calendar.set(Calendar.HOUR_OF_DAY,0); //这是将当天的【时】设置为0
            userDate=formatter.format(calendar.getTime());}
        return userMapper.today(userDate);
    }
    public int Update(User user){
        return userMapper.Update(user);
    }

    public int Cun(User user){
        if (user.getType()==1){
            int x=userMapper.grade(user);

            user.setOldGrade(x);

            //user.setActionGrade(user.getUserGrade());
            user.setUserGrade(user.getUserGrade()+x);}
        if (user.getType()==2){
            int x=userMapper.grade(user);

            user.setOldGrade(x);

            // user.setActionGrade(user.getUserGrade());
            user.setUserGrade(x-user.getUserGrade());}
        Calendar calendar = Calendar.getInstance(); // gets current instance of the calendar
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        user.setUserDate(formatter.format(calendar.getTime()));
        userMapper.insertMemory(user);
        return userMapper.Cun(user);
    }

    public int delete(int userId){
        return userMapper.delete(userId);
    }

}

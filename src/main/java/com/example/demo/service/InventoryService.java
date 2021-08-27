package com.example.demo.service;

import com.example.demo.entity.Inventory;
import com.example.demo.mapper.InventoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class InventoryService {

    @Autowired
    private InventoryMapper inventoryMapper;

  /*  public List<User> findByName(String userName) {
        return userMapper.findUserByName(userName);
    } */

    public List<Inventory> queryPage(Integer startRows) {
        return inventoryMapper.queryPage(startRows);
    }

    public int getRowCount() {
        return inventoryMapper.getRowCount();
    }
/*
    public User insertUser(User user) {
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
*/
}
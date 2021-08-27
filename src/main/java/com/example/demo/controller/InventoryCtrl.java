package com.example.demo.controller;

import com.example.demo.entity.Inventory;
import com.example.demo.entity.User;
import com.example.demo.service.InventoryService;
import com.example.demo.service.UserService;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InventoryCtrl {

    @Autowired
    private InventoryService inventoryService;

   /* @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public Integer delete(Integer userId) {
        System.out.println(userId);
        int result = userService.delete(userId);
        return result;
    }


    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public String update(User user) {
        int result = userService.Update(user);
        if (result >= 1) {
            return "修改成功";
        } else {
            return "修改失败";
        }

    }

    @RequestMapping(value = "/cun", method = RequestMethod.POST)
    @ResponseBody
    public String cun(User user) {

        int result = userService.Cun(user);
        if (result >= 1) {
            return "修改成功";
        } else {
            return "修改失败";
        }

    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public User insert(User user) {
        return userService.insertUser(user);
    }

    @RequestMapping("/ListUser")
    @ResponseBody
    public List<User> ListUser() {
        return userService.ListUser();
    }


    @RequestMapping("/memory")
    @ResponseBody
    public List<User> memory(Integer userId) {
        return userService.memory(userId);
    }

    @RequestMapping("/today")
    @ResponseBody
    public List<User> today(String userDate) {
        return userService.today(userDate);
    }

    @RequestMapping("/ListByName")
    @ResponseBody
    public List<User> ListUserByName(String userName) {
        return userService.findByName(userName);
    }

    /**
     * 分页
     * @return
     */
    @RequestMapping(value="/inventory/page")
    @ResponseBody
    public List<Inventory> page(Integer page){
        int pageNow = page == null ? 1 : page;
        int pageSize = 5;
        int startRows = pageSize*(pageNow-1);
        List<Inventory> list = inventoryService.queryPage(startRows);
        return list;
    }

    /**
     * rows
     * @return
     */
    @RequestMapping(value="/inventory/rows")
    @ResponseBody
    public int rows(){
        return inventoryService.getRowCount();
    }
}
package com.example.demo.controller;

import com.example.demo.entity.Gamebalance;
import com.example.demo.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
@RestController
public class GameCtrl {

    @Autowired
    private GameService gameService;



    //约稿接口
        @RequestMapping(value = "/gamebalance/art", method = RequestMethod.POST)
        @ResponseBody
        public String art(Gamebalance gamebalance) {
            if(gamebalance.getAciton()==1){
                 int result = gameService.appoint(gamebalance);
                 if (result >= 1) {
                     return "修改成功";
                 } else {
                     return "修改失败";
                 }
             }
            /*
             if(inventory.getToId()>0)
            {
                return inventoryService.up(inventory);
                if (result >= 1) {
                    return "修改成功";
                } else {
                    return "修改失败";
                }
            }
*/
             else
             {
                 int result =gameService.end(gamebalance);
                 if (result >= 1) {
                     return "修改成功";
                 } else {
                     return "修改失败";
                 }
             }

        }

//添加约稿接口
    @RequestMapping(value = "/gamebalance/insert", method = RequestMethod.POST)
    public Gamebalance insert(Gamebalance gamebalance) {

        System.out.println(gamebalance.getRemark() + "get");
        return gameService.insertplan(gamebalance);
    }
    //修改信息接口
    @RequestMapping(value = "/gamebalance/modify", method = RequestMethod.POST)
    public Gamebalance modify(Gamebalance gamebalance) {

        System.out.println(gamebalance.getRemark() + "get");
        return gameService.modifyplan(gamebalance);
    }
    /*
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
*/
    //查询支出接口
         @RequestMapping(value="/gamebalance/pay")
        @ResponseBody
        public String pay() {
            return gameService.pay();
        }


        /**
         * 分页
         * @return
         */

        //机器内
    @RequestMapping(value="/gamebalance/list")
    @ResponseBody
    public List<Gamebalance> page(Integer page){
        int pageNow = page == null ? 1 : page;
        int pageSize = 10;
        int startRows = pageSize*(pageNow-1);
        List<Gamebalance> list = gameService.list(startRows);
        return list;
    }
/*
    //库存
    @RequestMapping(value="/inventory/base")
    @ResponseBody
    public List<Inventory> base(Integer page){
        int pageNow = page == null ? 1 : page;
        int pageSize = 10;
        int startRows = pageSize*(pageNow-1);
        List<Inventory> list = inventoryService.base(startRows);
        return list;
    }


    @RequestMapping(value = "/inventory/last")
    @ResponseBody
    public  List<Inventory> last(String date){
        List<Inventory> list=inventoryService.inveroylast(date);
        return list;
    }


    @RequestMapping(value="/inventory/rows")
    @ResponseBody
    public int rows(){

        return inventoryService.getRowCount();
    }
    */

}

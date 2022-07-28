package com.example.demo.service;

import com.example.demo.entity.Inventory;
import com.example.demo.entity.Gamebalance;
import com.example.demo.enums.CodeEnum;
import com.example.demo.mapper.GameMapper;
import com.example.demo.mapper.InventoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;


@Service
public class GameService {

    @Autowired
    private GameMapper gameMapper;
    private InventoryMapper inventoryMapper;


    public List<Gamebalance> list(Integer startRows) {
        return gameMapper.list(startRows);
    }

    public List<Inventory> base(Integer startRows) {
        return inventoryMapper.base(startRows);
    }

    public int getRowCount() {
        return inventoryMapper.getRowCount();
    }


//添加
    public Gamebalance insertplan(Gamebalance gamebalance) {
        Calendar calendar = Calendar.getInstance(); // gets current instance of the calendar
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        gamebalance.setCreattime(formatter.format(calendar.getTime()));
        gamebalance.setStatus(1);
        gameMapper.insertplan(gamebalance);
        return gamebalance;
    }
    //修改
    public Gamebalance modifyplan(Gamebalance gamebalance) {
        Calendar calendar = Calendar.getInstance(); // gets current instance of the calendar
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        gamebalance.setUpdatetime((formatter.format(calendar.getTime())));
        gameMapper.modifyplan(gamebalance);
        return gamebalance;
    }

    //计算总价值
    public String pay() {
        //已支出
        int paid = gameMapper.paid();
        int balance = gameMapper.balance();
        int pend=gameMapper.pend();
        int price = paid + balance;
        String text = "已约" + price + "元；（其中已支付" + paid + "元，待支付"+balance+"元）剩余待约预算参考为" + pend + "元";


        return text;

    }


    public int appoint(Gamebalance gamebalance) {
        //约稿接口
        gamebalance.setStatus(2);//约稿后状态为2
        Calendar calendar = Calendar.getInstance(); // gets current instance of the calendar
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        gamebalance.setUpdatetime(formatter.format(calendar.getTime()));
        gamebalance.setBalance(gamebalance.getPrice()-gamebalance.getPaid());//计算待付金额

        //更新库存
        return gameMapper.appoint(gamebalance);


    }
  //结清接口
    public int end(Gamebalance gamebalance) {


        gamebalance.setStatus(3);//结清后已完成，状态为3
        Calendar calendar = Calendar.getInstance(); // gets current instance of the calendar
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        gamebalance.setUpdatetime(formatter.format(calendar.getTime()));
        //价格全付完
        gamebalance.setPaid(gamebalance.getPrice());
        gamebalance.setBalance(0);

        return gameMapper.end(gamebalance);


    }


    //上架功能
    public String up(Inventory inventory) {
//去掉仓库库存
        int x = inventoryMapper.inventory(inventory);
        inventory.setOldquantity(x);//在库存记录里记录下库存娃娃原来数量
        if (x < inventory.getActionquantity())
            return CodeEnum.ERROR.getname();
        inventory.setQuantity(x - inventory.getActionquantity());
        inventoryMapper.go(inventory);//根据id更新库存
        //增加机器库存
        inventory.setNewId(inventory.getToId());
        System.out.println("kucun" + inventory.getNewId());
        int y = inventoryMapper.inventorynew(inventory);//获取当前库存
        inventory.setQuantity(y + inventory.getActionquantity());//增加库存
        inventoryMapper.Cun(inventory);//根据机器号码更新库存
        //增加上架记录

        inventory.setType(2);
        Calendar calendar = Calendar.getInstance(); // gets current instance of the calendar
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        inventory.setDate(formatter.format(calendar.getTime()));
        inventory.setQuantity(inventoryMapper.inventorynew(inventory));//获取最新的机器娃娃数量
        inventoryMapper.insertInventorylastup(inventory);

        return CodeEnum.SUUCESS.getname();
    }

    //查询库存记录表，默认时间为当天
    public List<Inventory> inveroylast(String date) {
        if (date == null) {
            Calendar calendar = Calendar.getInstance(); // gets current instance of the calendar
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            calendar.set(Calendar.SECOND, 0); //这是将当天的【秒】设置为0
            calendar.set(Calendar.MINUTE, 0); //这是将当天的【分】设置为0
            calendar.set(Calendar.HOUR_OF_DAY, 0); //这是将当天的【时】设置为0
            date = formatter.format(calendar.getTime());
        }
        System.out.println(date);

        return inventoryMapper.inventorylast(date);

    }

}

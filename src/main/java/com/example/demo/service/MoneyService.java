package com.example.demo.service;

import com.example.demo.entity.Inventory;
import com.example.demo.enums.CodeEnum;
import com.example.demo.mapper.InventoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;


@Service
public class MoneyService {

    @Autowired
    private InventoryMapper inventoryMapper;

  /*  public List<User> findByName(String userName) {
        return userMapper.findUserByName(userName);
    } */

    public List<Inventory> queryPage(Integer startRows) {
        return inventoryMapper.queryPage(startRows);
    }
    public List<Inventory> base(Integer startRows) {
        return inventoryMapper.base(startRows);
    }
    public int getRowCount() {
        return inventoryMapper.getRowCount();
    }

    public Inventory insertInventory(Inventory inventory) {

        inventoryMapper.insertInventory(inventory);
        return inventory;
    }
   /* private void insertInventory(Integer startRows,Inventory inventory) {
        List<Inventory> Inventory = inventoryMapper.queryPage(startRows);
        Map<String, Inventory> InventoryMap = Inventory.stream().collect(Collectors.toMap(Inventory::getNewId, e -> e, (v1, v2) -> v1));
    }/*
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
        }*///

    //计算总价值
        public String value(){
            //上架总价值
            double valueup =inventoryMapper.valueup();
            double valuedown =inventoryMapper.valuedown();
            double valueall=valueup+valuedown;
            String text="当前机器内总价值"+valueup+"元；未上架库存价值"+valuedown+"元；总价值为"+valueall+"元";
            return text;

        }
 public void today(){
            int salequantity=0;



 }

public  int Cun(Inventory inventory){
            //增加修改库存记录
        inventory.setOldquantity(inventoryMapper.inventorynew(inventory));
        inventory.setType(1);
    Calendar calendar = Calendar.getInstance(); // gets current instance of the calendar
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    inventory.setDate(formatter.format(calendar.getTime()));
  inventoryMapper.insertInventorylast(inventory);

            //更新库存
    return inventoryMapper.Cun(inventory);


    }
    public  int basecun(Inventory inventory){

        //增加修改库存记录
        int s=inventoryMapper.inventory(inventory);
        inventory.setOldquantity(s);
        inventory.setQuantity(s+inventory.getActionquantity());
        inventory.setType(3);
        Calendar calendar = Calendar.getInstance(); // gets current instance of the calendar
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        inventory.setDate(formatter.format(calendar.getTime()));
        inventoryMapper.insertInventorylast(inventory);

        //更新库存
        return inventoryMapper.basecun(inventory);


    }



//上架功能
    public  String up(Inventory inventory){
//去掉仓库库存
        int x=inventoryMapper.inventory(inventory);
        inventory.setOldquantity(x);//在库存记录里记录下库存娃娃原来数量
        if(x<inventory.getActionquantity())
            return CodeEnum.ERROR.getname();
        inventory.setQuantity(x- inventory.getActionquantity());
        inventoryMapper.go(inventory);//根据id更新库存
//增加机器库存

        inventory.setNewId(inventory.getToId());
        System.out.println("kucun"+inventory.getNewId());
        int y=inventoryMapper.inventorynew(inventory);//获取当前库存
        inventory.setQuantity(y+ inventory.getActionquantity());//增加库存
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
    public List<Inventory> inveroylast(String date)

    {
        if(date==null){
            Calendar calendar = Calendar.getInstance(); // gets current instance of the calendar
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            calendar.set(Calendar.SECOND,0); //这是将当天的【秒】设置为0
            calendar.set(Calendar.MINUTE,0); //这是将当天的【分】设置为0
            calendar.set(Calendar.HOUR_OF_DAY,0); //这是将当天的【时】设置为0
            date=formatter.format(calendar.getTime());}

       return  inventoryMapper.inventorylast(date);

    }
/*
    public int delete(int userId){
        return userMapper.delete(userId);
    }


*/
}

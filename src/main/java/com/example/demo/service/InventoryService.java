package com.example.demo.service;

import com.example.demo.entity.Inventory;
import com.example.demo.enums.CodeEnum;
import com.example.demo.mapper.InventoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


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


public  int Cun(Inventory inventory){
//更新库存
    return inventoryMapper.Cun(inventory);
    }

//上架功能
    public  String up(Inventory inventory){
//去掉仓库库存
int x=inventoryMapper.inventory(inventory);//
        if(x<inventory.getActionquantity())
            return CodeEnum.ERROR.getname();
inventory.setQuantity(x- inventory.getActionquantity());
inventoryMapper.go(inventory);//根据id更新库存
//增加机器库存

        inventory.setNewId(inventory.getToId());
        System.out.println("kucun"+inventory.getNewId());
        int y=inventoryMapper.inventorynew(inventory);
        inventory.setQuantity(y+ inventory.getActionquantity());
        inventoryMapper.Cun(inventory);//根据机器号码更新库存
        return CodeEnum.SUUCESS.getname();
    }
/*
    public int delete(int userId){
        return userMapper.delete(userId);
    }
*/
}

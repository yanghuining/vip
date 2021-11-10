package com.example.demo.mapper;

import com.example.demo.entity.User;
import com.example.demo.entity.Inventory;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface InventoryMapper {

  /*  public List<User> findUserByName(String userName);

    public List<User> ListUser();
    public List<User> memory(Integer userId);
    public List<User> today(String userDate);

   */

    public List<Inventory> queryPage(Integer startRows);
    public List<Inventory> base(Integer startRows);
    public int getRowCount();
    public int valueup();
    public int valuedown();
    public  int Cun(Inventory inventory);
    public  int inventory(Inventory inventory);
    public  int inventorynew(Inventory inventory);
    public  int go(Inventory inventory);
    public  int insertInventory(Inventory inventory);
/*
    public int delete(int userId);


*/



}

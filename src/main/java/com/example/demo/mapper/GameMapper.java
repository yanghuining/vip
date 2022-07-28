package com.example.demo.mapper;

import com.example.demo.entity.Gamebalance;
import com.example.demo.entity.Inventory;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GameMapper {

  /*  public List<User> findUserByName(String userName);

    public List<User> ListUser();
    public List<User> memory(Integer userId);
    public List<User> today(String userDate);

   */

    public List<Gamebalance> list(Integer startRows);
    public List<Inventory> base(Integer startRows);
    public List<Inventory> inventorylast(String date);
    public int getRowCount();
    public int paid();
    public int balance();
    public int pend();
    public  int appoint(Gamebalance gamebalance);
    public  int end(Gamebalance gamebalance);
    public  int inventory(Inventory inventory);
    public  int inventorynew(Inventory inventory);
    public  int go(Inventory inventory);
    public  int insertplan(Gamebalance gamebalance);
    public  int modifyplan(Gamebalance gamebalance);
public  int insertInventorylast(Inventory inventory);
    public  int insertInventorylastup(Inventory inventory);

  /*  public int delete(int userId);


*/



}

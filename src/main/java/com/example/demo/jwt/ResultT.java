package com.example.loginintercept.config;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO
 *
 * @author ch
 * @version 1.0.0
 * @since 1.0.0
 * <p>
 * Created at 2020/8/6 5:04 下午
 */
public class ResultT extends HashMap<String, Object> {

  public ResultT() {
    put("code", 0);
    put("msg", "success");
  }

  public static ResultT ok() {
    ResultT t = new ResultT();
    t.put("msg", "操作成功");
    return t;
  }

  public static ResultT ok(String msg) {
    ResultT t = new ResultT();
    t.put("msg", msg);
    return t;
  }

  public static ResultT ok(Map<String, Object> map) {
    ResultT t = new ResultT();
    t.putAll(map);
    return t;
  }

  public static ResultT error(int code, String msg) {

    ResultT t = new ResultT();
    t.put("code", code);
    t.put("msg", msg);
    return t;
  }

  public static ResultT error() {
    return error(500, "未知异常");
  }

  public ResultT put(String key, Object value){
    super.put(key, value);
    return this;
  }
}

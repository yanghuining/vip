package com.example.loginintercept.exception;

import com.example.loginintercept.config.ResultT;
import com.example.loginintercept.exception.TokenRuntimeException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理
 *
 * @author ch
 * @version 1.0.0
 * @since 1.0.0
 * <p>
 * Created at 2020/8/6 5:03 下午
 */
@RestControllerAdvice
public class SysRuntimeExceptionHandler {

  @ExceptionHandler(TokenRuntimeException.class)
  public ResultT tokenRuntimeException(TokenRuntimeException e) {
    e.printStackTrace();
    return ResultT.error(e.getCode(), e.getMsg());
  }

  @ExceptionHandler(Exception.class)
  public ResultT handlerException(Exception e){
    e.printStackTrace();
    return ResultT.error();
  }
}

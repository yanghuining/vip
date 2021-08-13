package com.example.loginintercept.exception;

import lombok.Data;

/**
 * 自定义 token 异常
 *
 * @author ch
 * @version 1.0.0
 * @since 1.0.0
 * <p>
 * Created at 2020/8/6 4:58 下午
 */
@Data
public class TokenRuntimeException extends RuntimeException{

  private Integer code = 401;
  private String msg;

  public TokenRuntimeException(String msg) {
    this.msg = msg;
  }

}

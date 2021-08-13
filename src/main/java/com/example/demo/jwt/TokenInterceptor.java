package com.example.loginintercept.config;

import com.example.loginintercept.exception.TokenRuntimeException;
import io.jsonwebtoken.Claims;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * 创建一个 token 拦截器.
 * 需要继承 HandlerInterceptorAdapter,并且声明为spring的组件
 * @author ch
 * @version 1.0.0
 * @since 1.0.0
 * <p>
 * Created at 2020/7/30 2:19 下午
 */
@Component
public class TokenInterceptor extends HandlerInterceptorAdapter {

  // 注入jwt工具类
  @Autowired
  private JwtUtils jwtUtils;

  // 重写 前置拦截方法
  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws Exception {
    // 1、从请求头中获取token
    String token = request.getHeader("token");

    // 2、判断 token 是否存在
    if (token == null ||"".equals(token)) {
      System.out.println("未登录");
      // 这里可以自定义 抛出 token 异常
      throw new TokenRuntimeException("未登录");
    }

    // 3、解析token
    Claims claim = jwtUtils.getClaimsByToken(token);

    if (null == claim) {
      System.out.println("token 解析错误");
      // 这里可以自定义 抛出 token 异常
      throw  new TokenRuntimeException("token 解析错误");
    }

    // 4、判断 token 是否过期
    Date expiration = claim.getExpiration();
    boolean tokenExpired = jwtUtils.isTokenExpired(expiration);
    if (tokenExpired) {
      System.out.println("token已过期，请重新登录");
      // 这里可以自定义 抛出 token 异常
      throw new TokenRuntimeException("token已过期，请重新登录");
    }

    // 5、 从 token 中获取员工信息
    String subject = claim.getSubject();

    // 6、去数据库中匹配 id 是否存在 (这里直接写死了)
    if (null == subject ) {
      System.out.println("员工不存在");
      // 这里可以自定义 抛出 token 异常
      throw new TokenRuntimeException("员工不存在");
    }

    // 7、成功后 设置想设置的属性，比如员工姓名
    request.setAttribute("userId", subject);
    request.setAttribute("userName", "张三");

    return true;
  }
}

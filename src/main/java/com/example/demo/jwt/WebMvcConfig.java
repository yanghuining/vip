package com.example.demo.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 设置拦截器.
 * 打上configuration 注解，标注为配置项
 * @author ch
 * @version 1.0.0
 * @since 1.0.0
 * <p>
 * Created at 2020/7/30 2:17 下午
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

  // 注入 token 拦截器
  @Autowired
  private TokenInterceptor interceptor;

  /**
   * 重写添加拦截器
   */
  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    // 添加自定义拦截器，并拦截对应 url
    registry.addInterceptor(interceptor).addPathPatterns("/page");
    registry.addInterceptor(interceptor).addPathPatterns("/rows");
    registry.addInterceptor(interceptor).addPathPatterns("/delete");
    registry.addInterceptor(interceptor).addPathPatterns("/update");
    registry.addInterceptor(interceptor).addPathPatterns("/cun");
    registry.addInterceptor(interceptor).addPathPatterns("/insert");
    registry.addInterceptor(interceptor).addPathPatterns("/ListUser");
    registry.addInterceptor(interceptor).addPathPatterns("/memory");
    registry.addInterceptor(interceptor).addPathPatterns("/today");
    registry.addInterceptor(interceptor).addPathPatterns("/ListByName");

  }

}

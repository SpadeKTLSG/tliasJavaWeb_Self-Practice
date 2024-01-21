package cwx.config;

import cwx.interceptor.LoginCheckInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {//注册拦截器

    //自定义的拦截器对象,直接注入
    @Autowired
    private LoginCheckInterceptor loginCheckInterceptor;


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册自定义拦截器对象,从bean工厂中获取
        registry.addInterceptor(loginCheckInterceptor).addPathPatterns("/**").excludePathPatterns("/login");//设置拦截器拦截的请求路径（ /** 表示拦截所有请求）
        //设置拦截所有的请求:/**  但是不拦截某些请求：/login
    }
}
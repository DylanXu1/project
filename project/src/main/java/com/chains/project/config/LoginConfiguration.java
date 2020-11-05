package com.chains.project.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author xdx
 * @date 2020/4/14
 * @version 1.0
 */

@Configuration
public class LoginConfiguration implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册拦截器
        LoginInterceptor loginInterceptor = new LoginInterceptor();
        InterceptorRegistration loginRegistry = registry.addInterceptor(loginInterceptor);
        //注册资源

        // 拦截路径
        //loginRegistry.addPathPatterns("/**");
        loginRegistry.addPathPatterns("");  //不拦截
        // 排除路径
        loginRegistry.excludePathPatterns("/");
        loginRegistry.excludePathPatterns("/login");
        loginRegistry.excludePathPatterns("/login.html");
        loginRegistry.excludePathPatterns("/login/*");
        loginRegistry.excludePathPatterns("/header.html");
        loginRegistry.excludePathPatterns("/viadm/login.html");
        loginRegistry.excludePathPatterns("/index.html");
        loginRegistry.excludePathPatterns("/detail.html");
        loginRegistry.excludePathPatterns("/loginout");
        //外部资源
        loginRegistry.excludePathPatterns("/image/**/**");
        //排除接口
        loginRegistry.excludePathPatterns("/item/itemList");
        loginRegistry.excludePathPatterns("/item/sysMenuList");
        loginRegistry.excludePathPatterns("/item/itemDetail");
        loginRegistry.excludePathPatterns("/introduce/IntroduceList");
        //loginRegistry.excludePathPatterns("/item/itemList");

        // 排除资源请求
        loginRegistry.excludePathPatterns("/css/*.css");
        loginRegistry.excludePathPatterns("/js/*.js");
        loginRegistry.excludePathPatterns("/fonts/**");
        loginRegistry.excludePathPatterns("/images/*");
        loginRegistry.excludePathPatterns("/lib/layui/**");
        loginRegistry.excludePathPatterns("/favicon.ico");
    }

    /**
     * 自定义资源映射
     * addResourceHandler(String... pathPatterns) : 添加静态资源映射路径，这些资源都不会被拦截.
     * addResourceLocations(String... resourceLocations)：添加静态资源路径
     * pathPatterns：虚拟路径/映射路径，即用户从前端请求的路径，如 http://ip:port/context-path/uploadFiles/1.mp4
     * resourceLocations：实际路径(结尾的斜杆不能省略)。可以是类路径，也可以是磁盘的实际路径，如 D:/wmx/mp4
     * classpath 表示类路径、file 表示磁盘路径
     * pathPatterns（虚拟路径）会自动映射到 resourceLocations（实际资源位置）
     *
     * @param registry
     */
    /*注册静态资源,也可以在application.properties配置*/
    /*@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
       *//* registry.addResourceHandler("/data/**").addResourceLocations("classpath:/data/");
        registry.addResourceHandler("/disk/**").addResourceLocations("file:///C:/wmx/desktop/");*//*
        registry.addResourceHandler("F:/OTA/").addResourceLocations("file:F://OTA/");

    }*/


}

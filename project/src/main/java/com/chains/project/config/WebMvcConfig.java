package com.chains.project.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author xdx
 * @date 2020/4/7
 * @version 1.0
 */

/*@Configuration
 *//*@CrossOrigin(allowCredentials = "true",allowedHeaders = "*")*//*
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/**")
                //.allowCredentials(true)    //此项为true,allowedOrigins不能为“*”须为具体的值，且前端withCredentials需为true
                //.allowedOrigins("http://192.168.0.119:8080")
                //.allowedOrigins("http://127.0.0.1:8020")
                .allowedOrigins("*")
                //.allowedOrigins("http://192.168.3.157:8080")
                .allowedHeaders("*")
                .allowedMethods("*")
                .maxAge(30*1000);

    }
}*/

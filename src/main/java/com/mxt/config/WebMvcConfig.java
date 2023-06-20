package com.mxt.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/resources/")
                .addResourceLocations("classpath:/templates/")
                .addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/MXTupl0ad/**")
                .addResourceLocations("file:/usr/local/src/MXTupl0ad/");//本地路径
    }
}
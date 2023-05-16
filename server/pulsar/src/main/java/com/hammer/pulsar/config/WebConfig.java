package com.hammer.pulsar.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Spring Web MVC의 설정을 위한 설정 클래스
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    // 리소스에 대한 접근 경로를 설정한다.
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // classpath:/static/ 에 있는 리소스에 접근할 수 있는 URL path pattern을 /**로 설정
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
    }
}

package com.hammer.pulsar.config;

import com.hammer.pulsar.interceptor.AuthCheckInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Spring Web MVC의 설정을 위한 설정 클래스
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    private AuthCheckInterceptor authCheckInterceptor;

    // 리소스에 대한 접근 경로를 설정한다.
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // classpath:/static/ 에 있는 리소스에 접근할 수 있는 URL path pattern을 /**로 설정
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
    }

    @Autowired
    public void setAuthCheckInterceptor(AuthCheckInterceptor authCheckInterceptor) {
        this.authCheckInterceptor = authCheckInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authCheckInterceptor)
                // excludePathPatterns 를 제외한 모든 경로에서 로그인 여부를 체크합니다.
                .addPathPatterns("/**")
                // 회원가입, 게시글 상세보기, 태그 조회, 운동 조회는 로그인을 체크하지 않습니다.
                .excludePathPatterns("/member/signup/**", "/community/*/static", "/tag", "/exercise");
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("*");
    }

}

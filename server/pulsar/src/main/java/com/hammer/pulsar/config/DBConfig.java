package com.hammer.pulsar.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * MyBatis를 이용해 DB와 통신하기 위한 설정 클래스
 * com.hammer.pulsar.dao 패키지에 있는 클래스들을 MyBatis mapper로 등록한다
 */
@Configuration
@MapperScan(basePackages = "com.hammer.pulsar.dao")
public class DBConfig {
}

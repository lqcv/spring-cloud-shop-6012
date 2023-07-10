package com.newer.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;

public class LogConfiguration {
    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;//full完全，打印open-feign接口调用所有信息。
    }
}

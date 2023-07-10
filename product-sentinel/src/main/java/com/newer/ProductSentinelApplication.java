package com.newer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

@EnableFeignClients//打开open-feign
@SpringBootApplication
@EnableDiscoveryClient//代表·服务提供者
public class ProductSentinelApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(ProductSentinelApplication.class);
        Environment env = run.getEnvironment();
        String port = env.getProperty("server.port");
        String path = env.getProperty("server.servlet.context-path");
        System.out.println("\n--------------------------------------\n\t" +
                "Application is running! Access URLs:\n\t" +
                "Local: \t\thttp://localhost:" + port + path + "/index.html\n\t" +
                "----------------------------------------------------------");
    }

}

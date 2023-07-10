package com.newer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

@EnableDiscoveryClient//这里必须EnableDiscoveryClient注解，以便通过Nacos进行路由
@SpringBootApplication
public class ProductGatewayApplication {

    public static void main(String[] args) {
        //        SpringApplication.run(ProductServiceApplication.class, args);
        ConfigurableApplicationContext run = SpringApplication.run(ProductGatewayApplication.class);
        Environment env = run.getEnvironment();
        String port = env.getProperty("server.port");
        String path = env.getProperty("server.servlet.context-path");
        System.out.println("\n--------------------------------------\n\t" +
                "Application is running! Access URLs:\n\t" +
                "Local: \t\thttp://localhost:" + port + path+ "/index.html\n\t" +
                "----------------------------------------------------------");
    }
}

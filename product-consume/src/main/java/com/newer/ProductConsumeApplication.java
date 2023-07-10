package com.newer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
//@EnableFeignClients
//@EnableDiscoveryClient
public class ProductConsumeApplication {

    /*
     * 将restTemplate注入到spring ioc容器
     *实例化RestTemplate
     * :查找注册中心提供者提供的方法。
     */
//    @Bean
//    public RestTemplate restTemplate() {
//        return new RestTemplate();
//    }

//    @Bean
//    @LoadBalanced//通知服务器启动LoadBanlaceInterceptor实现负载均衡。
//    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
////        return new RestTemplate();
//        return restTemplateBuilder.build();
//    }

    public static void main(String[] args) {


        //        SpringApplication.run(ProductServiceApplication.class, args);
        ConfigurableApplicationContext run = SpringApplication.run(ProductConsumeApplication .class);
        Environment env = run.getEnvironment();
        String port = env.getProperty("server.port");
        String path = env.getProperty("server.servlet.context-path");
        System.out.println("\n--------------------------------------\n\t" +
                "Application is running! Access URLs:\n\t" +
                "Local: \t\thttp://localhost:" + port + path+ "/index.html\n\t" +
                "----------------------------------------------------------");
    }

}

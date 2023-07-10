package com.newer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class ProductStreamConsumer2Application {

    public static void main(String[] args) {
        //        SpringApplication.run(ProductStreamConsumer2Application.class, args);
        ConfigurableApplicationContext run = SpringApplication.run(ProductStreamConsumer2Application.class);
        Environment env = run.getEnvironment();
        String port = env.getProperty("server.port");
        String path = env.getProperty("server.servlet.context-path");
        System.out.println("\n--------------------------------------\n\t" +
                "Application is running! Access URLs:\n\t" +
                "Local: \t\thttp://localhost:" + port + path+ "/index.html\n\t" +
                "----------------------------------------------------------");
    }

}
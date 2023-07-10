package com.newer.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * SpringBoot配置类实现路由规则的配置。
 */
@Configuration
public class GateWayConfig {
//        @Bean
//    public RouteLocator gateWayConfigInfo(RouteLocatorBuilder routeLocatorBuilder){
//        // 构建多个路由routes
//            //Route路由Locator定位器
//            RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
//        // 具体路由地址
//        //routes.route("id",r->r.path("path").uri("URI")).build();
//        /**
//         * spring.cloud.gateway.routes[0].id=product-service
//         * spring.cloud.gateway.routes[0].uri=lb://product-service
//         * spring.cloud.gateway.routes[0].predicates[0]=Path=/findProductById/**
//         */
//        routes.route("product-service",r -> r.path("/findProductById/**")
//                .uri("lb://product-service")).build();
//        // 返回所有路由规则
//        return routes.build();
//    }
}

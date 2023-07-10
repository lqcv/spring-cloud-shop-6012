package com.newer.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.cloud.gateway.support.GatewayToStringStyler;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
import reactor.netty.http.server.HttpServerRequest;
import javax.servlet.http.*;
import java.net.URI;
import java.util.Arrays;
import java.util.List;

@Component
@Slf4j
public class TbUserGatewayFilterFactory  extends AbstractGatewayFilterFactory<AbstractGatewayFilterFactory.NameConfig>{

    public TbUserGatewayFilterFactory() {
        super(NameConfig.class);
    }

    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList("name");
    }

    @Override
    public GatewayFilter apply(NameConfig config) {
        return new GatewayFilter() {
            //public void doFilter(HttpServletRequest,HttpServletResponse,FilterChain)
            @Override
            public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
                // 获取请求路径
                //ServerWebExchange.getRequest返回HttpServletRequest
                //.getRespnose返回HttpServerletResponse
                URI uri = exchange.getRequest().getURI();
                log.info("获取到请求路径：{}", uri.toString());
//                ServerHttpRequest myRequest =  exchange.getRequest();
//                HttpServletRequest my = (HttpServletRequest) myRequest;
//                String name= my.getParameter("name");
                String name= exchange.getRequest().getQueryParams().getFirst("userName");
                if(!"guest".equals(name)){
                    System.out.println("打印用户名必须是guest");
                }
                return chain.filter(exchange);
            }

            @Override
            public String toString() {
                return GatewayToStringStyler
                        .filterToStringCreator(TbUserGatewayFilterFactory.this).toString();
            }
        };
    }
}

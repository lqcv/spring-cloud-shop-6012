package com.newer.JwtFilter;


import com.alibaba.fastjson.JSONObject;
import com.alibaba.nacos.api.utils.StringUtils;
import com.newer.data.entity.Response;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;

@Data
@Slf4j
@Component
@ConfigurationProperties("org.my.jwt")
public class LoginGlobalFilter  implements GlobalFilter, Ordered {
    // 跳过路由数组
    private String[] skipAuthUrls;
    @Override
    public Mono<Void> filter(ServerWebExchange exchange,GatewayFilterChain chain) {
        //获取请求url地址
        String url = exchange.getRequest().getURI().getPath();
        //跳过不需要验证的路径
        if (null != skipAuthUrls && isSkipUrl(url)) {
            System.out.println("不需要验证的地址有："+skipAuthUrls[0]);
            return chain.filter(exchange);
        }
        //从请求头中取得token
        String token = exchange.getRequest().getHeaders().getFirst("Authorization");
        if (StringUtils.isEmpty(token)) {
            return createResponseObj(exchange,500,"token参数缺失");
        }
        //请求中的token是否有效
        boolean verifyResult = JWTUtil.verify(token);
        if (!verifyResult) {
            return createResponseObj(exchange,500,"token失效");
        }
        //如果各种判断都通过，执行chain上的其他业务逻辑
        return chain.filter(exchange);
    }
    @Override
    public int getOrder() {
        return 0;
    }
    /**
     * 判断当前访问的url是否开头URI是在配置的忽略
     url列表中
     *
     * @param url
     * @return
     */
    public boolean isSkipUrl(String url) {
        for (String skipAuthUrl : skipAuthUrls) {
            if (url.startsWith(skipAuthUrl)) {
                return true;
            }
        }
        return false;
    }
    // 组装返回数据
    private Mono<Void>
    createResponseObj(ServerWebExchange exchange,Integer code,String message){
        ServerHttpResponse response = exchange.getResponse();
        // 设置响应状态码200
        response.setStatusCode(HttpStatus.OK);
        // 设置响应头
        response.getHeaders().add("ContentType", "application/json;charset=UTF-8");
        // 创建响应对象
        Response res = new Response(code,
                message);
        // 把对象转成字符串
        byte[] responseByte = JSONObject.toJSONString(res).toString().getBytes(StandardCharsets.UTF_8);
        DataBuffer buffer = response.bufferFactory().wrap(responseByte);
        return response.writeWith(Flux.just(buffer));
    }
}

package com.newer.sercive;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class SentinelService {

    private static final Logger logger = LoggerFactory.getLogger(SentinelService.class);

    /**
     * @SentinelResource: 可以理解就是一个资源名
     * 利用sentinelChain一个URL路径唯一标识业务层方法。
     */
    @SentinelResource("sentinelChain")
    public String sentinelChain() {
        logger.info("测试Sentinel流控模式 - 链路模式");
        return "Sentinel Mode - Chain";
    }
}

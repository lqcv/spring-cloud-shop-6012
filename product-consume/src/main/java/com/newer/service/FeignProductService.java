package com.newer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import com.newer.service.ProductService;

@FeignClient("product-service")//配置服务提供者为product-service
public interface FeignProductService extends ProductService{

//public interface FeignProductService extends ProductEmpService{
}

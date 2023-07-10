package com.newer.data.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor //带所有参数构造方法
@NoArgsConstructor//不带参数默认构造方法
public class Goods {
    int goodsId;//货物编号
    String goodsName;//货物名字
    double goodsPrice;//货物价格
}

package com.newer.data.entity;

import lombok.Data;

@Data
public class Response {
    //响应状态码
    private Integer code;
    //相应信息
    private String message;


    public Response(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Response() {

    }
}

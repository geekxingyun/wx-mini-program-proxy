package com.xingyun.wxminiprogramproxy.framework.model.constant;

import lombok.Getter;

/***
 * @author qingfeng.zhao
 * @date 2023/5/7
 * @apiNote
 */
public enum ResponseCodeEnum {
    OK_SUCCESS(20000,"请求成功"),
    REQUEST_PARAM_ERROR(40001,"客户端请求参数错误"),
    REQUEST_TOKEN_ERROR(50014,"无效的Token"),
    REQUEST_ERROR(50000,"服务器数据异常"),
    INVALID_ACCOUNT_OR_PASSWORD(60204,"账号或密码不正确");

    @Getter
    private Integer code;

    @Getter
    private String message;
    ResponseCodeEnum(Integer code, String message){
        this.code=code;
        this.message=message;
    }
}

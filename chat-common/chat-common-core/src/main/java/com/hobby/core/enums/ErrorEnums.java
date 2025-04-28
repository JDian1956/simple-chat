package com.hobby.core.enums;

/**
 * @author Harris
 * 10000 成功， 12xxx 认证异常，13xxx 服务异常，14xxx 参数异常，15xxx 业务异常，16xxx 其他异常
 */
public enum ErrorEnums {

    /**
     * 成功
     */
    SUCCESS(10000, "成功"),
    /**
     * 未授权
     */
    UNAUTHORIZED(12001, "未授权"),
    /**
     * 禁止访问
     */
    FORBIDDEN(12002, "禁止访问"),
    /**
     * 服务未找到
     */
    NOT_FOUND(13004, "服务未找到"),
    /**
     * 系统异常
     */
    SERVER_ERROR(13005, "系统异常"),
    /**
     * 请求失败
     */
    REQUEST_FAIL(15001, "访问失败"),
    /**
     * 其他错误, 请自行扩展
     */
    OTHERS_ERROR(16001, "其他错误"),
    ;


    private final int code;
    private final String msg;

    ErrorEnums(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}

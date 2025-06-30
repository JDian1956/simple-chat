package com.hobby.core.util;

import com.hobby.core.enums.HttpStatusEnums;

import java.io.Serializable;

/**
 * @author Harris
 */
public class ResponseResult<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    private int code;

    private String msg;

    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static <T> ResponseResult<T> success() {
        return success(HttpStatusEnums.SUCCESS.getCode(), HttpStatusEnums.SUCCESS.getMsg(), null);
    }

    public static <T> ResponseResult<T> success(String msg) {
        return success(HttpStatusEnums.SUCCESS.getCode(), msg, null);
    }

    public static <T> ResponseResult<T> success(T data) {
        return success(HttpStatusEnums.SUCCESS.getCode(), HttpStatusEnums.SUCCESS.getMsg(), data);
    }

    public static <T> ResponseResult<T> success(Integer code, String msg, T data) {
        ResponseResult<T> result = new ResponseResult<>();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }

    public static <T> ResponseResult<T> error() {
        return error(HttpStatusEnums.REQUEST_FAIL.getCode(), HttpStatusEnums.REQUEST_FAIL.getMsg(), null);
    }

    public static <T> ResponseResult<T> error(HttpStatusEnums httpStatusEnums) {
        return error(httpStatusEnums.getCode(), httpStatusEnums.getMsg(), null);
    }

    public static <T> ResponseResult<T> error(int code, String msg) {
        return error(code, msg, null);
    }

    public static <T> ResponseResult<T> error(T data) {
        return error(HttpStatusEnums.REQUEST_FAIL.getCode(), HttpStatusEnums.REQUEST_FAIL.getMsg(), data);
    }

    public static <T> ResponseResult<T> error(int code, String msg, T data) {
        ResponseResult<T> result = new ResponseResult<>();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }
}

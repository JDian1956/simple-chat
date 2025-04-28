package com.hobby.core.pojo;

import com.hobby.core.enums.ErrorEnums;

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
        return success(ErrorEnums.SUCCESS.getCode(), ErrorEnums.SUCCESS.getMsg(), null);
    }

    public static <T> ResponseResult<T> success(String msg) {
        return success(ErrorEnums.SUCCESS.getCode(), msg, null);
    }

    public static <T> ResponseResult<T> success(T data) {
        return success(ErrorEnums.SUCCESS.getCode(), ErrorEnums.SUCCESS.getMsg(), data);
    }

    public static <T> ResponseResult<T> success(Integer code, String msg, T data) {
        ResponseResult<T> result = new ResponseResult<>();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }

    public static <T> ResponseResult<T> error() {
        return error(ErrorEnums.REQUEST_FAIL.getCode(), ErrorEnums.REQUEST_FAIL.getMsg(), null);
    }

    public static <T> ResponseResult<T> error(ErrorEnums errorEnums) {
        return error(errorEnums.getCode(), errorEnums.getMsg(), null);
    }

    public static <T> ResponseResult<T> error(int code, String msg) {
        return error(code, msg, null);
    }

    public static <T> ResponseResult<T> error(T data) {
        return error(ErrorEnums.REQUEST_FAIL.getCode(), ErrorEnums.REQUEST_FAIL.getMsg(), data);
    }

    public static <T> ResponseResult<T> error(int code, String msg, T data) {
        ResponseResult<T> result = new ResponseResult<>();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }
}

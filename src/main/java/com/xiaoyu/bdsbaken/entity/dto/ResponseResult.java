package com.xiaoyu.bdsbaken.entity.dto;

import java.io.Serializable;

public class ResponseResult<T> implements Serializable {
    private Integer code;
    private String msg;
    private T data;
    private long timestamp=System.currentTimeMillis();;


    public ResponseResult() {
        this.timestamp = System.currentTimeMillis();

    }

    public ResponseResult(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <T> ResponseResult<T> success() {
        return new ResponseResult<>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMsg(), null);
    }

    public static <T> ResponseResult<T> success(T data) {
        System.out.println("请求成功");
        return new ResponseResult<>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMsg(), data);
    }


    public static <T> ResponseResult<T> failed(String msg) {
        System.out.println("请求失败");
        return new ResponseResult<>(ResultCode.FAILED.getCode(), msg, null);
    }

    public static <T> ResponseResult<T> failed(String msg, T data) {
        return new ResponseResult<>(ResultCode.FAILED.getCode(), msg, data);
    }

    public static <T> ResponseResult<T> failed(ResultCode errorCode) {
        return new ResponseResult<>(errorCode.getCode(), errorCode.getMsg(), null);
    }

    public static <T> ResponseResult<T> failed(ResultCode errorCode, T data) {
        return new ResponseResult<>(errorCode.getCode(), errorCode.getMsg(), data);
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }


    public long getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "ResponseResult{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
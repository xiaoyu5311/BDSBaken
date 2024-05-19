package com.xiaoyu.bdsbaken.entity.dto;

public enum ResultCode {
    SUCCESS(10000, "请求成功"),
    FAILED(10001, "操作失败"),
    TOKEN_EXPIRED(10002, "token过期"),
    TOKEN_INVALID(2001, "无效token 访问令牌不合法"),
    NONE(99999, "无"),
    RC500(500, "系统异常，请稍后重试"),
    RC403(403, "无访问权限,请联系管理员授予权限"),
    RC200(200, "服务开启限流保护,请稍后再试!"),
    RC401(401, "匿名用户访问无权限资源时的异常"),
    RC444(444, "请求次数过多，请稍后重试"),
    RC250(250, "账号已注册"),

    RC251(251, "注册成功");


    private int code;
    private String msg;

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    private ResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }


}
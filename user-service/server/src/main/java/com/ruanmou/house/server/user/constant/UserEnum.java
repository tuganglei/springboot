package com.ruanmou.house.server.user.constant;

/**
 * @author tuganglei
 * @date 2018/11/22 16:55
 */
public enum UserEnum {

    ACTIVE(1,"已激活"),
    DISABLE(0,"未激活");

    private int code;
    private String msg;

    UserEnum(int code, String msg) {
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

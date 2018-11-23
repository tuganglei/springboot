package com.ruanmou.house.server.user.exception;

/**
 * @author tuganglei
 * @date 2018/11/22 16:39
 */
public class UserException extends RuntimeException {

    private UserType type;

    public UserException() {
    }

    public UserException(UserType type,String message){
            super(message);
            this.type = type;
    }

    public UserType Type() {
         return type;
    }

    public enum UserType{
        ACCOUNT_AND_PASSWORD_IS_NULL,
        USER_AUTH_FAIL,
        USER_NOT_LOGIN,
        USER_NOT_FOUNT
    }
}

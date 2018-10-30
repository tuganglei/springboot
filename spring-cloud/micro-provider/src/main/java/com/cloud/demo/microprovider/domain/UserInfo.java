package com.cloud.demo.microprovider.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author tuganglei
 * @date 2018/10/30 14:02
 */

@Setter
@Getter
public class UserInfo {

    private Integer userId;
    private String userName;
    private int userAge;
    private Date userBirth;
}

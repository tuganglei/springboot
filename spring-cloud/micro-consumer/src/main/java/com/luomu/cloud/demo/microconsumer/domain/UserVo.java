package com.luomu.cloud.demo.microconsumer.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author tuganglei
 * @date 2018/10/30 14:51
 */
@Setter
@Getter
public class UserVo {
    private Integer UserId;
    private String userName;
    private int userAge;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date userBirth;
}

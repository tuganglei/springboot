package com.cloud.demo.microprovider.mapper;

import com.cloud.demo.microprovider.domain.UserInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author tuganglei
 * @date 2018/10/30 14:06
 */


public interface UserInfoMapper {

    //@Select("SELECT USER_ID,USER_NAME,USER_AGE,USER_BIRTH FROM T_USER WHERE USER_ID = #{userId}")
    UserInfo getUser(Integer userId);
}

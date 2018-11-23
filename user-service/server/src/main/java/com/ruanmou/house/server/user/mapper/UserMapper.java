package com.ruanmou.house.server.user.mapper;

import com.ruanmou.house.server.user.common.mapper.UserBaseMapper;
import com.ruanmou.house.server.user.domain.User;

/**
 * @ProjectName: microservice-house
 * @Auther: GERRY
 * @Date: 2018/11/12 20:12
 * @Description:
 */
public interface UserMapper extends UserBaseMapper<User> {
    void updateUser(User user);
}

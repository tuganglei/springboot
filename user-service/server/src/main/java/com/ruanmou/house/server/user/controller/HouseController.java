package com.ruanmou.house.server.user.controller;

import com.ruanmou.house.common.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ProjectName: microservice-house
 * @Auther: GERRY
 * @Date: 2018/11/8 20:36
 * @Description:
 */
@RestController
public class HouseController {

    @GetMapping("/testApiRequest")
    public ApiResponse get() {
        return ApiResponse.ofSuccess("成功");
    }

    @GetMapping("/testApiRequest1")
    public ApiResponse get1() {
        return ApiResponse.ofMessage(10001, "余额不足");
    }


    @GetMapping("/ex")
    public ApiResponse getEx() {
        throw new RuntimeException();
    }
}

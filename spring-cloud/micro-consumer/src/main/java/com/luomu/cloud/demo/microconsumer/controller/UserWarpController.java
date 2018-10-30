package com.luomu.cloud.demo.microconsumer.controller;

import com.luomu.cloud.demo.microconsumer.domain.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author tuganglei
 * @date 2018/10/30 14:52
 */
@RestController
public class UserWarpController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/warp/user/{id}")
    public UserVo getUser(@PathVariable("id")Integer userId){
//        ServiceInstance ser = loadBalancerClient.choose("provider");
//        String host = ser.getHost();
//        int port = ser.getPort();
//        String url = String.format("http://%s:%s/%s/%s",host,port,"user",userId);
//        System.out.println(url);
        return restTemplate.getForObject("http://provider/user/"+userId,UserVo.class);
        //return restTemplate.getForObject(url,UserVo.class);
    }
}

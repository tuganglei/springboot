package com.boot.config.bootconfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author tuganglei
 * @date 2018/10/18 16:52
 */

@Component
public class RedisConfig {

    @Value("${redis.prot:6379}")
    private int port;
    @Value("${redis.host:127.0.0.1}")
    private String host;
    @Value("${redis.auth:1234}")
    private String auth;

    public void show(){
        System.out.println(port+","+host+","+auth);
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }
}

package com.boot.config.bootconfig;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author tuganglei
 * @date 2018/10/18 17:11
 */
@SpringBootConfiguration
@ConfigurationProperties(prefix = "luomu.datasource")
public class DataSource {

    private String driver;

    private String url;

    @Override
    public String toString() {
        return "DataSource{" +
                "driver='" + driver + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

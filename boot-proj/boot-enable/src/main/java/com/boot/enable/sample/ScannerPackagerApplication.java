package com.boot.enable.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


/**
 * @author tuganglei
 * @date 2018/10/22 15:49
 */
@SpringBootApplication
@EnableScanner(packages = {"com.boot.enable.sample.per","com.boot.enable.sample.vo"})
public class ScannerPackagerApplication {


    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ScannerPackagerApplication.class, args);

        context.close();
    }


}

package com.boot.enable.bootenable;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author tuganglei
 * @date 2018/10/22 15:37
 */
@Component
public class RunnableDemo {

    @Async
    public void run(){
        for(int i = 0 ;i<10;i++){
            System.out.println(i);
        }
    }
}

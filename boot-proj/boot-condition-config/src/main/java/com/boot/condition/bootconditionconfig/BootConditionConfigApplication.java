package com.boot.condition.bootconditionconfig;

import com.boot.condition.bootconditionconfig.convert.EcodingConvert;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Map;

@SpringBootApplication
public class BootConditionConfigApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(BootConditionConfigApplication.class, args);
		Map<String, EcodingConvert> beansOfType = context.getBeansOfType(EcodingConvert.class);
		System.out.println(beansOfType);
		System.out.println(System.getProperty("file.encoding"));
	}
}

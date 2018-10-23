package com.boot.auto.config.bootauto;

import com.boot.config.core.configcore1.DatasourceProperties;
import com.boot.config.core.domain.Order;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan
public class BootAutoApplication {


	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(BootAutoApplication.class, args);

		System.out.println(context.getBean(Order.class));
		String driverClassName = context.getBean(DatasourceProperties.class).getDriverClassName();
		System.out.println(driverClassName);


		context.close();

	}
}

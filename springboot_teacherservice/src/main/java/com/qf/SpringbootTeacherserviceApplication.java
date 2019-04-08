package com.qf;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.qf")
@MapperScan("com.qf.dao")
@DubboComponentScan("com.qf.serviceimpl")
public class SpringbootTeacherserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootTeacherserviceApplication.class, args);
	}

}

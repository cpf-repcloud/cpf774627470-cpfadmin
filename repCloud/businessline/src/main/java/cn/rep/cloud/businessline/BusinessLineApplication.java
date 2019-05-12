package cn.rep.cloud.businessline;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BusinessLineApplication {

	public static void main(String[] args) {
		SpringApplication.run(BusinessLineApplication.class, args);
	}

}


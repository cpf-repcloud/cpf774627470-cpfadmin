package cn.rep.cloud.cloudui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableScheduling
@EnableZuulProxy
@EnableFeignClients
/**
 * hyg测试git提交
 */
public class ClouduiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClouduiApplication.class, args);
	}

	//    启用负载均衡，默认算法是轮询
//	@LoadBalanced
//	@Bean
//	public RestTemplate restTemplate(){
//		return new RestTemplate();
//	}

}


/**
 * 
 */
package com.yuruicai.test.ribbon.way;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

// resttemplate的方式
@RestController
@RequestMapping("/resttemplate")
@Configuration
public class TestResttemplateController {
	static Logger logger = LoggerFactory.getLogger(TestResttemplateController.class);

	@Bean
	@LoadBalanced // 这个注解一定要加，不然LoadBalancerAutoConfiguration不会对它进行处理
	RestTemplate RestTemplate() {
		return new RestTemplate();
	}

	@Autowired
	RestTemplate restTemplate; // spring内置,封装了http请求的工具类

	// properties
	@RequestMapping("/properties")
	public void properties() {
		String body = restTemplate.getForObject("http://service-by-properties/", String.class);
		testprint(body);// 仅仅是为了根据输出内容来判断是调用的哪个接口
	}

	// annotation
	@RequestMapping("/annotation")
	public void annotation() {
		String body = restTemplate.getForObject("http://service-by-annotation/", String.class);
		testprint(body);// 仅仅是为了根据输出内容来判断是调用的哪个接口
	}

	// eureka
	@RequestMapping("/eureka")
	public void eureka() {
		String body = restTemplate.getForObject("http://lession-3-sms-interface/", String.class);
		logger.warn("TestResttemplateController.eureka执行结果：{}", body);
	}

	// 仅仅是为了根据输出内容来判断是调用的哪个接口
	private void testprint(String body) {
		if (body.contains("dongnaoedu")) {
			logger.warn("根据负载均衡策略，选择实例:dongnaoedu.com");
		} else if (body.contains("csdn")) {
			logger.warn("根据负载均衡策略，选择实例:csdn.net");
		} else if (body.contains("baidu")) {
			logger.warn("根据负载均衡策略，选择实例:baidu.com");
		} else {
			logger.warn("火星....");
		}
	}

}

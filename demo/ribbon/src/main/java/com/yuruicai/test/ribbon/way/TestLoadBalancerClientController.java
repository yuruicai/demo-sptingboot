package com.yuruicai.test.ribbon.way;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// LoadBalancerClient的方式
@RestController
@RequestMapping("/loadbalance")
public class TestLoadBalancerClientController {
	static Logger logger = LoggerFactory.getLogger(TestLoadBalancerClientController.class);
	@Autowired
	LoadBalancerClient loadbalancerClient; // spring cloud 封装的 关于负载均衡组件 ribbon的工具类
	// properties

	@RequestMapping("/properties")
	public void properties() {
		ServiceInstance serviceInstance = loadbalancerClient.choose("service-by-properties");
		logger.warn("TestLoadBalancerClientController.properties执行结果：{}", serviceInstance.getUri());
	}

	// annotation
	@RequestMapping("/annotation")
	public void annotation() {
		ServiceInstance serviceInstance = loadbalancerClient.choose("service-by-annotation");
		logger.warn("TestLoadBalancerClientController.annotation执行结果：{}", serviceInstance.getUri());
	}

	// eureka
	@RequestMapping("/eureka")
	public void eureka() {
		ServiceInstance serviceInstance = loadbalancerClient.choose("MS-SIMPLE-PROVIDER-USER");
		logger.warn("TestLoadBalancerClientController.eureka执行结果：{}", serviceInstance.getUri());
	}
}

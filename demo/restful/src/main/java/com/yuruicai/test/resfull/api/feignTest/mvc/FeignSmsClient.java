package com.yuruicai.test.resfull.api.feignTest.mvc;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


// 必须引入hytrix, 才会生效fallback = FeignSmsMvcClientFailback.class
// 不配置fallback，出错了就会直接返回错误信息
@FeignClient(name = "lession-3-sms-interface", fallback = FeignSmsMvcClientFailback.class)
public interface FeignSmsClient {

	/** 普通 */
	@RequestMapping(value = "/sms", method = RequestMethod.GET)
	String querySms();

	/** 传递对象 */
	// 实际上是对象转json，作为请求报文
	@RequestMapping(value = "/sms", method = RequestMethod.POST)
	String sendSms(@RequestBody Sms sms);

	/** 获取短信内容 */
	@RequestMapping(value = "/sms/{id}", method = RequestMethod.GET)
	Sms getSms(@PathVariable("id") String id);

	/** 这是一个会报错的请求，测试fallback */
	@RequestMapping(value = "/fail404", method = RequestMethod.GET)
	String fail404();

}

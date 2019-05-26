package com.yuruicai.test.resfull.api.feignTest.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/feign2")
public class TestController2 {

	@Autowired
	FeignSmsClient feignSmsClient;

	// get 请求
	@RequestMapping("/test1")
	public String test1() {
		String body = feignSmsClient.querySms();
		return body;
	}
	
	// post 请求
	@RequestMapping("/test2")
	public String test2(@RequestBody Sms sms) {
		String body = feignSmsClient.sendSms(sms);
		return body;
	}
	
	@RequestMapping("/test4")
	public Sms test4(String id) {
		Sms sendSmsTemplate = feignSmsClient.getSms(id);
		return sendSmsTemplate;
	}
	
	@RequestMapping("/test5")
	public String test5() {
		String sendSmsTemplate = feignSmsClient.fail404();
		return sendSmsTemplate;
	}
}

package com.cdac.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
/*
 * = @Controller - added on the class level + @ResponseBody - added on ret types
 * of all req handling methods req handling methods - @RequestMapping
 * | @GetMapping ...... ResponseBody - serialialization(=marshalling) Java ->
 * JSON | XML
 * 
 */
@RequestMapping("/dummy") // resource name
public class TestController {
	public TestController() {
		System.out.println("in ctor " + getClass());
	}
	/*
	 * Add REST API end point
	 * URL - http://host:port/dummy
	 * Method - GET
	 * Payload - none
	 * Resp body - List of numbers
	 */
	@GetMapping
	public /* @ResponseBody */ List<Integer> testDummyEndPoint() {
		System.out.println("in test dummy");
		return List.of(10, 20, 30, 40);
	}
}

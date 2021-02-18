package com.dailycodebuffer.cloud.gateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackMethodController {
	
	@GetMapping("/userServiceFallBack")
	public String userServiceFallBackMethod() {
		return "User service is taking more than expected, Please Again later";
	}
	
	@GetMapping("/departmentServiceFallBack")
	public String departmentServiceFallBackMethod() {
		return "Department service is taking more than expected, Please Again later";
	}

}

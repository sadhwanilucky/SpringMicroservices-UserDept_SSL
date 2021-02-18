package com.dailycodebuffer.department.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dailycodebuffer.department.entity.Department;
import com.dailycodebuffer.department.service.DepartmentService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/departments")
@Slf4j
public class DepartmentController {
	private static Logger logger = LoggerFactory.getLogger(DepartmentController.class);
	@Autowired
	private DepartmentService departmentService;

	@PostMapping("/")
	public Department saveDepartment(@RequestBody Department department) {
		logger.info("Inside saveDepartment of DepartmentController");
		return departmentService.saveDepartment(department);

	}
	
	@GetMapping("/{id}")
	public Department findDepartmentById(@PathVariable("id") Long departmentId) {
		logger.info("Inside findDeparmentById of DepartmentController");
		return departmentService.findByDepartmentId(departmentId);
		
	}

}

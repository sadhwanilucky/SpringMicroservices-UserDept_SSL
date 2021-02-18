package com.dailycodebuffer.department.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dailycodebuffer.department.controller.DepartmentController;
import com.dailycodebuffer.department.entity.Department;
import com.dailycodebuffer.department.repository.DepartmentRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DepartmentService {
	private static Logger logger = LoggerFactory.getLogger(DepartmentController.class);
	@Autowired
	private DepartmentRepository departmentRepository;

	public Department saveDepartment(Department department) {
		logger.info("Inside saveDepartment of DepartmentService");
		return departmentRepository.save(department);
	}

	public Department findByDepartmentId(Long departmentId) {
		logger.info("Inside findDeparmentById of DepartmentService");
		return departmentRepository.findByDepartmentId(departmentId);
	}
}

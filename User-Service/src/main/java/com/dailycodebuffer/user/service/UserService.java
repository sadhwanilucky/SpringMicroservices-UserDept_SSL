package com.dailycodebuffer.user.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.dailycodebuffer.user.VO.Department;
import com.dailycodebuffer.user.VO.ResponseTemplateVO;
import com.dailycodebuffer.user.entity.User;
import com.dailycodebuffer.user.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {
	private static Logger logger = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RestTemplate restTemplate;
	
	public User saveUser(User user) {
		logger.info("Inside saveUser of UserService");
		return userRepository.save(user);
	}

	public User getUserById(Long userId) {
		logger.info("Inside getUserById of UserService");
		return userRepository.findByUserId(userId);
	}

	public ResponseTemplateVO getUserWithDepartment(Long userId) {
		logger.info("Inside getUserWithDepartment of UserService");
		ResponseTemplateVO vo = new ResponseTemplateVO();
		User user = userRepository.findByUserId(userId);
		Department department =
				restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/"+user.getDepartmentId(), Department.class);
		vo.setUser(user);
		vo.setDepartment(department);
		return vo;
	}
}

package com.chinmay.mobileApp.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinmay.mobileApp.UserRepository;
import com.chinmay.mobileApp.io.entity.UserEntity;
import com.chinmay.mobileApp.service.UserService;
import com.chinmay.mobileApp.shared.dto.UserDto;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public UserDto createUser(UserDto user) {
		
				
		if(userRepository.findByEmail(user.getEmail()) !=null) throw 
		new RuntimeException("Record Already exists");
		
		UserEntity userEntity = new UserEntity();
		BeanUtils.copyProperties(user, userEntity);
		
		userEntity.setEncryptedPassword("Test@123");
		userEntity.setUserId("TestUserId123");

		UserEntity storedUserDetails = userRepository.save(userEntity);
		
		UserDto returnValue = new UserDto();
		BeanUtils.copyProperties(storedUserDetails, returnValue);

		return returnValue;
	}

}

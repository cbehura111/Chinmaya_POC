package com.chinmay.mobileApp.ui.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chinmay.mobileApp.service.UserService;
import com.chinmay.mobileApp.shared.dto.UserDto;
import com.chinmay.mobileApp.ui.model.request.UserDetailsRequestModel;
import com.chinmay.mobileApp.ui.model.response.UserRest;

@RestController
@RequestMapping("users") // http://localhost:8080/users
public class UserController {
	
	@Autowired
	UserService userService;

	@GetMapping
	public String getUser() {
		return "Get User Is Called !!!";
	}

	@PostMapping
	public UserRest createUser(@RequestBody UserDetailsRequestModel userDetails) {
		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(userDetails, userDto);

		UserDto createdUser = userService.createUser(userDto);

		UserRest returnValue = new UserRest();
		BeanUtils.copyProperties(createdUser, returnValue);
		
		return returnValue;
	}

	@PutMapping
	public String updateUser() {
		return "Update User Is Called !!!";
	}

	@DeleteMapping
	public String deleteUser() {
		return "Delete User Is Called !!!";
	}

}

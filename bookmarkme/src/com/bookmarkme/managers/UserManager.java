package com.bookmarkme.managers;

import com.bookmarkme.entities.User;

public class UserManager {
	private static UserManager instance=new UserManager();
	private UserManager() {}
		
	public static UserManager getInstance(){
		return instance;
	}
	
	public User createUser(long id,String email,String password,String firstName,String lastName,int gender,String userType) {
		User user= new User();
		user.setId(id);
		user.setEmail(email);
		user.setPassword(password);
		user.setPassword(lastName);
		user.setFirstname(firstName);
		user.setLastname(lastName);
		user.setGender(gender);
		user.setUserType(userType);
		
		return user;
	}
}

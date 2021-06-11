package com.bookmarkme.managers;

import com.bookmarkme.entities.User;

public class UserManager {
	private static UserManager instance=new UserManager();
	private UserManager() {}
		
	public static UserManager getInstance(){
		return instance;
	}
	
	public User createUer(long id,String email,String firstName,String lastName,int gender,String userType) {
		User user= new User();
		user.setId(id);
		user.setEmail(email);
		user.setPassword(lastName);
		user.setFirstname(firstName);
		user.setLastname(lastName);
		user.setGender(gender);
		user.setUserType(userType);
		
		return user;
	}
}

package com.bookmarkme.dao;

import com.bookmarkme.DataStore;
import com.bookmarkme.entities.User;

public class UserDao {
	public User[] getUsers() {
		return DataStore.getUsers();
	}
}

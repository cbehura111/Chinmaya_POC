package com.chinmay.thrillio.dao;

import com.chinmay.thrillio.DataStore;
import com.chinmay.thrillio.entities.User;

public class UserDao {
	public User[] getUsers() {
		return DataStore.getUsers();
	}
}

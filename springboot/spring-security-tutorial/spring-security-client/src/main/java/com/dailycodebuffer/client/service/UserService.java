package com.dailycodebuffer.client.service;

import com.dailycodebuffer.client.entity.User;
import com.dailycodebuffer.client.model.UserModel;

public interface UserService {
    User registerUser(UserModel userModel);
}

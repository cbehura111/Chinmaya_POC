package com.chinmay.mobileApp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chinmay.mobileApp.io.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {
//	UserEntity findUserByEmail(String email);
	UserEntity findByEmail(String email);
}

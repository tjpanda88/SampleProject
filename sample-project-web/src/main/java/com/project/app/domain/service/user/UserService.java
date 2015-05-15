package com.project.app.domain.service.user;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.project.app.domain.model.User;

public interface UserService {

	public Page<User> searchUser(Pageable pageable);
	
	public User saveUser(User user);
}

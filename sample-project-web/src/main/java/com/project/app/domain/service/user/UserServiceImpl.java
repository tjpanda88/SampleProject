package com.project.app.domain.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.project.app.domain.model.User;
import com.project.app.domain.repository.user.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public Page<User> searchUser(Pageable pageable) {
		return userRepository.findAll(pageable);
	}
	
	public User saveUser(User user) {
		return userRepository.save(user);
	}
}

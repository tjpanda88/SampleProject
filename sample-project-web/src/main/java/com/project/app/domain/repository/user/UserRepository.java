package com.project.app.domain.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.app.domain.model.User;

public interface UserRepository  extends JpaRepository<User, String> {

}

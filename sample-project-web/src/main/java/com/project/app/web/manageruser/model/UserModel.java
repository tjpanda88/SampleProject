package com.project.app.web.manageruser.model;

import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class UserModel {

	@Size(min = 1,message="用户名不能为空")
	private String id;

	private String roleId;

	private String name;

	private String password;

	private String registerDate;
}

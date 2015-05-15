package com.project.app.domain.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "USER_TABLE")
public class User implements Serializable {

	private static final long serialVersionUID = -8528854691896111209L;

	@Id
	@NotNull
	@Column(nullable = false, name = "USER_ID", length = 6)
	private String id;
	
	@NotNull
	@Column(nullable = false, name = "USER_TYPE", length = 2)
	private String type;

	@NotNull
	@Column(nullable = false, name = "USER_NAME", length = 30)
	private String name;
	
	@NotNull
	@Column(nullable = false, name = "USER_PASSWORD", length = 30)
	private String password;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}

package com.project.app.domain.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
@Table(name = "USER_TABLE")
public class User implements Serializable {

	private static final long serialVersionUID = -8528854691896111209L;

	@Id
	@NotNull
	@Column(nullable = false, name = "USER_ID", length = 6)
	private String id;

	@NotNull
	@Column(nullable = false, name = "USER_ROLE_ID", length = 2)
	private String roleId;

	@NotNull
	@Column(nullable = false, name = "USER_NAME", length = 30)
	private String name;

	@NotNull
	@Column(nullable = false, name = "USER_PASSWORD", length = 30)
	private String password;

	@NotNull
	@Column(nullable = false, name = "USER_REGISTER_DATE")
	private Date registerDate;

}

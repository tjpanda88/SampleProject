package com.project.app.web.adduser;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class AddUserForm implements Serializable {
	/**
     * serialVersion.
     */
	private static final long serialVersionUID = 6713033250301914074L;

	private String id;
	
	private String type;

	private String name;
	
	private String password;
}

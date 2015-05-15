package com.project.app.web.searchuser;

import java.io.Serializable;

import lombok.Data;

@Data
public class SearchUserForm implements Serializable {

    /**
     * serialVersion.
     */
	private static final long serialVersionUID = 6713033250301914074L;

    private String searchId;
    private String searchName;
    private String searchType;
}


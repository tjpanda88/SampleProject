package com.project.app.fw.datatables.beans;

import java.util.Map;

import lombok.Data;

@Data
public class EditorInputModel {

	private String action;
	private Map<String,String> data;
}

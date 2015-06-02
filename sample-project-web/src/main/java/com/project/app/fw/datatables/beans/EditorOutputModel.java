package com.project.app.fw.datatables.beans;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class EditorOutputModel<S> {

	private S row;
	private List<EditorFieldErrorModel> fieldErrors;
}

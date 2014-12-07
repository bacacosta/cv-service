package com.chuvadasquatro.domain;

import java.util.List;

public class Tasks {
	private String label;
	private List<String> tasks;

	public Tasks(List<String> tasks) {
		this.label = "Tasks:";
		this.tasks = tasks;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public List<String> getTasks() {
		return tasks;
	}

	public void setTasks(List<String> tasks) {
		this.tasks = tasks;
	}
}

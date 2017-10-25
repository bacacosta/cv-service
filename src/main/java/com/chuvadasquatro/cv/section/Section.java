package com.chuvadasquatro.cv.section;

import java.util.List;

public class Section {

	private List<Object> items;

	public Section(List<Object> items) {
		this.items = items;
	}

	public List<Object> getItems() {
		return items;
	}

	public void setItems(List<Object> items) {
		this.items = items;
	}

}

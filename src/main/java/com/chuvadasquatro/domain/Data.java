package com.chuvadasquatro.domain;

import java.util.List;

public class Data {
	private List<Object> data;

	public Data(List<Object> data) {
		this.data = data;
	}

	public List<Object> getData() {
		return data;
	}

	public void setData(List<Object> data) {
		this.data = data;
	}
}

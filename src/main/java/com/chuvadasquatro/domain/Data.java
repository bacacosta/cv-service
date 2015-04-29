package com.chuvadasquatro.domain;

import java.util.List;

public class Data {
	private List<String> data;

	public Data(List<String> data) {
		this.data = data;
	}

	public List<String> getData() {
		return data;
	}

	public void setData(List<String> data) {
		this.data = data;
	}
}

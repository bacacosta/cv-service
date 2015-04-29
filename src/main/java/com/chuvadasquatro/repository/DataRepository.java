package com.chuvadasquatro.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.chuvadasquatro.datasource.ODFDataSource;
import com.chuvadasquatro.domain.Data;

@Repository
public class DataRepository {
	@Autowired
	private ODFDataSource dataSource;

	public Data getData(String page) {
		return new Data(getList(dataSource.getListIterator(page)));
	}

	private List<String> getList(Iterator<org.odftoolkit.simple.text.list.List> iterator) {
		List<String> list = new ArrayList<String>();

		while (iterator.hasNext()) {
			for (org.odftoolkit.simple.text.list.ListItem item : iterator.next().getItems()) {
				list.add(item.getTextContent());
				list.addAll(getList(item.getListIterator()));
			}
		}

		return list;
	}
}

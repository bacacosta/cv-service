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

	public Data getPages() {
		return new Data(new ArrayList<Object>(ODFDataSource.getTableIndex().keySet()));
	}

	public Data getData(String page) {
		return new Data(getList(dataSource.getListIterator(page)));
	}

	private List<Object> getList(Iterator<org.odftoolkit.simple.text.list.List> iterator) {
		List<Object> list = new ArrayList<Object>();

		while (iterator.hasNext()) {
			for (org.odftoolkit.simple.text.list.ListItem item : iterator.next().getItems()) {
				list.add(item.getTextContent());
				if (item.getListIterator().hasNext()) {
					list.add(getList(item.getListIterator()));
				}
			}
		}

		return list;
	}
}

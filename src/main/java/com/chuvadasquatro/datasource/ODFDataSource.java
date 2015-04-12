package com.chuvadasquatro.datasource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.odftoolkit.simple.TextDocument;
import org.odftoolkit.simple.table.Table;
import org.odftoolkit.simple.text.list.ListItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.chuvadasquatro.FilesConfig;

@Component
public class ODFDataSource {
	@Autowired
	private FilesConfig filesConfig;

	private static Table table;
	private static Map<String, Integer> tableIndex;
	static {
		tableIndex = new HashMap<String, Integer>();
		tableIndex.put("info",         0);
		tableIndex.put("education",    2);
		tableIndex.put("courses",      4);
		tableIndex.put("languages",    6);
		tableIndex.put("skills",       8);
		tableIndex.put("interests",   10);
		tableIndex.put("experiences", 12);
	}

	@PostConstruct
	public void loadTable() {
		try {
			if (table == null) {
				table = TextDocument.loadDocument(filesConfig.getSourcePath() + filesConfig.getFilename() + ".odt").getTableList().get(1);
			}
		} catch (Exception e) {
			throw new RuntimeException("Unable to read document.", e);
		}
	}

	public Iterator<org.odftoolkit.simple.text.list.List> getListIterator(String page) {
		return table.getRowByIndex(tableIndex.get(page)).getCellByIndex(1).getListIterator();
	}

	public Iterator<org.odftoolkit.simple.text.list.List> getListIterator(ListItem item) {
		return item.getListIterator();
	}

	public List<String> getData(Iterator<org.odftoolkit.simple.text.list.List> iterator) {
		List<String> data = new ArrayList<String>();

		while (iterator.hasNext()) {
			for (ListItem item : iterator.next().getItems()) {
				data.add(item.getTextContent());
			}
		}

		return data;
	}
}
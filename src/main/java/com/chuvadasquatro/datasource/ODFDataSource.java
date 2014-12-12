package com.chuvadasquatro.datasource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.odftoolkit.simple.TextDocument;
import org.odftoolkit.simple.table.Table;
import org.odftoolkit.simple.text.list.ListItem;

public class ODFDataSource {
	private static Table table;
	private static Map<String, Integer> tableIndex;
	static {
		try {
			table = TextDocument.loadDocument("data/Rodrigo-Costa.odt").getTableList().get(1);
		} catch (Exception e) {
			throw new RuntimeException("Unable to read document.");
		}

		tableIndex = new HashMap<String, Integer>();
		tableIndex.put("info", 0);
		tableIndex.put("education", 2);
		tableIndex.put("courses", 4);
		tableIndex.put("languages", 6);
		tableIndex.put("skills", 8);
		tableIndex.put("interests", 10);
		tableIndex.put("experiences", 12);
	}

	public static List<String> getData(String page) {
		List<String> data = new ArrayList<String>();

		Iterator<org.odftoolkit.simple.text.list.List> lists = table.getRowByIndex(tableIndex.get(page)).getCellByIndex(1).getListIterator();
		while (lists.hasNext()) {
			for (ListItem item : lists.next().getItems()) {
				data.add(item.getTextContent());
			}
		}

		return data;
	}
}

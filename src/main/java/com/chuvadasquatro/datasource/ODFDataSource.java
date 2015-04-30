package com.chuvadasquatro.datasource;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.odftoolkit.simple.TextDocument;
import org.odftoolkit.simple.table.Table;
import org.odftoolkit.simple.text.list.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.chuvadasquatro.FilesConfig;

@Component
public class ODFDataSource {
	@Autowired
	private FilesConfig filesConfig;

	private static Table table;
	private static Map<String, Integer> tableIndex;

	@PostConstruct
	public void loadTable() {
		try {
			if (table == null) {
				table = TextDocument.loadDocument(filesConfig.getSourcePath() + filesConfig.getFilename() + ".odt").getTableByName("Data");
				tableIndex = new LinkedHashMap<String, Integer>();
				String title;
				for (int i = 0; i < table.getRowCount(); i++) {
					if (!(title = table.getRowByIndex(i).getCellByIndex(0).getDisplayText()).isEmpty()) {
						tableIndex.put(title.replace(" ", "-").toLowerCase(), i);
					}
				}
			}
		} catch (Exception e) {
			throw new RuntimeException("Unable to read document.", e);
		}
	}

	public static Map<String, Integer> getTableIndex() {
		return tableIndex;
	}

	public Iterator<List> getListIterator(String page) {
		if (!tableIndex.containsKey(page)) page = "personal-info";
		return table.getRowByIndex(tableIndex.get(page)).getCellByIndex(1).getListIterator();
	}
}

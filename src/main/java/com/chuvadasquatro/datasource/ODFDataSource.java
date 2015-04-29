package com.chuvadasquatro.datasource;

import java.util.HashMap;
import java.util.Iterator;
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
				tableIndex = new HashMap<String, Integer>();
				String title;
				for (int i = 0; i < table.getRowCount(); i++) {
					if (!(title = table.getRowByIndex(i).getCellByIndex(0).getDisplayText()).isEmpty()) {
						tableIndex.put(getPageFromTitle(title), i);
					}
				}
			}
		} catch (Exception e) {
			throw new RuntimeException("Unable to read document.", e);
		}
	}

	private String getPageFromTitle(String title) {
		String[] splitTitle = title.split(" ");
		return splitTitle[splitTitle.length - 1].toLowerCase();
	}

	public Iterator<List> getListIterator(String page) {
		if (!tableIndex.containsKey(page)) page = "info";
		return table.getRowByIndex(tableIndex.get(page)).getCellByIndex(1).getListIterator();
	}
}

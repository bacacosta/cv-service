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

	@PostConstruct
	public void loadTable() {
		try {
			if (table == null) {
				table = TextDocument.loadDocument(filesConfig.getSourcePath() + filesConfig.getFilename() + ".odt").getTableByName("Data");
				tableIndex = new HashMap<String, Integer>();
				String title;
				String[] splitTitle;
				for (int i = 0; i < table.getRowCount(); i++) {
					if (!(title = table.getRowByIndex(i).getCellByIndex(0).getDisplayText()).isEmpty()) {
						splitTitle = title.split(" ");
						tableIndex.put(splitTitle[splitTitle.length - 1].toLowerCase(), i);
					}
				}
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

package com.chuvadasquatro;

import java.util.Iterator;

import org.odftoolkit.simple.TextDocument;
import org.odftoolkit.simple.table.Table;
import org.odftoolkit.simple.text.list.List;
import org.odftoolkit.simple.text.list.ListItem;

public class ODFDataSourceStaticTest {
	public static void main(String[] args) {
		try {
			TextDocument doc = TextDocument.loadDocument("data/source/Rodrigo-Costa.odt");
			Table table = doc.getTableByName("Data");
			for (int i = 0; i < table.getRowCount(); i++) {
				if (i % 2 != 0) continue;
				System.out.println("* " + table.getRowByIndex(i).getCellByIndex(0).getDisplayText() + ":");
				Iterator<List> listsLevel1 = table.getRowByIndex(i).getCellByIndex(1).getListIterator();
				while (listsLevel1.hasNext()) {
					for (ListItem itemLevel1 : listsLevel1.next().getItems()) {
						System.out.println(itemLevel1.getTextContent());
						Iterator<List> listsLevel2 = itemLevel1.getListIterator();
						while (listsLevel2.hasNext()) {
							for (ListItem itemLevel2 : listsLevel2.next().getItems()) {
								System.out.println("\t" + itemLevel2.getTextContent());
							}
						}
					}
				}
				System.out.println();
			}
		} catch (Exception e) {
			System.err.println("There's something wrong with the world today: " + e.getMessage());
		}
	}
}

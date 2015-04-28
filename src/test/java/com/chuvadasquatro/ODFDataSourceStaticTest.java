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
			Table table = doc.getTableList().get(1);
			for (int i = 0; i < table.getRowCount(); i++) {
				if (i % 2 != 0) continue;
				Iterator<List> listsLevel1 = table.getRowByIndex(i).getCellByIndex(1).getListIterator();
				while (listsLevel1.hasNext()) {
					for (ListItem itemLevel1 : listsLevel1.next().getItems()) {
						System.out.println(itemLevel1.getTextContent());
						Iterator<List> listsLevel2 = itemLevel1.getListIterator();
						while (listsLevel2.hasNext()) {
							for (ListItem itemLevel2 : listsLevel2.next().getItems()) {
								System.out.println("\t" + itemLevel2.getTextContent());
								Iterator<List> listsLevel3 = itemLevel2.getListIterator();
								while (listsLevel3.hasNext()) {
									for (ListItem itemLevel3 : listsLevel3.next().getItems()) {
										System.out.println("\t\t" + itemLevel3.getTextContent());
									}
								}
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

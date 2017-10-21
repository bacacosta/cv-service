package com.chuvadasquatro.cv.datasource;

import com.chuvadasquatro.cv.config.FilesConfig;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import org.odftoolkit.odfdom.converter.pdf.PdfConverter;
import org.odftoolkit.odfdom.converter.pdf.PdfOptions;
import org.odftoolkit.odfdom.doc.OdfTextDocument;
import org.odftoolkit.simple.TextDocument;
import org.odftoolkit.simple.table.Table;
import org.odftoolkit.simple.text.list.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@SuppressWarnings("deprecation")
@Component
public class ODFDataSource {

	@Autowired
	private FilesConfig filesConfig;

	private static Table table;
	private static Map<String, Integer> tableIndex;

	@PostConstruct
	public void loadTable() throws Exception {
		File source = new File(filesConfig.getSourcePath() + filesConfig.getFilename() + ".odt");
		if (source.exists()) {
			table = TextDocument.loadDocument(source).getTableByName("Data");
			tableIndex = new LinkedHashMap<String, Integer>();
			String title;
			for (int i = 0; i < table.getRowCount(); i++) {
				if (!(title = table.getRowByIndex(i).getCellByIndex(0).getDisplayText()).isEmpty()) {
					tableIndex.put(title.replace(" ", "-").toLowerCase(), i);
				}
			}
		}
	}

	public static Map<String, Integer> getTableIndex() {
		return tableIndex;
	}

	public Iterator<List> getListIterator(String page) {
		return table.getRowByIndex(tableIndex.get(page)).getCellByIndex(1).getListIterator();
	}

	public void generatePDF() throws Exception {
		// create target directory
		new File(filesConfig.getTargetPath()).mkdirs();

		PdfConverter.getInstance().convert(
				OdfTextDocument.loadDocument(filesConfig.getSourcePath() + filesConfig.getFilename() + ".odt"),
				new FileOutputStream(filesConfig.getTargetPath() + filesConfig.getFilename() + ".pdf"),
				PdfOptions.create());
	}

}

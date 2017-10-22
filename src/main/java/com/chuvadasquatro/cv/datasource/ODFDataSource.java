package com.chuvadasquatro.cv.datasource;

import com.chuvadasquatro.cv.config.FilesConfig;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
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
	public void loadTable() {
		File source = new File(filesConfig.getSourcePath() + filesConfig.getFilename() + ".odt");
		if (source.exists()) {
			try {
				table = TextDocument.loadDocument(source).getTableByName("Data");
			} catch (Exception e) {
				// delete broken file
				source.delete();

				throw new IllegalStateException("Error reading source file!", e);
			}
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
		return Optional.ofNullable(tableIndex).orElseThrow(() -> new IllegalStateException("ODF table index is null!"));
	}

	public Iterator<List> getListIterator(String section) {
		try {
			return table.getRowByIndex(tableIndex.get(section)).getCellByIndex(1).getListIterator();
		} catch (NullPointerException e) {
			throw new IllegalArgumentException("Section " + section + " not found!", e);
		}
	}

	public void generatePDF() {
		// create target directory
		new File(filesConfig.getTargetPath()).mkdirs();

		try {
			PdfConverter.getInstance().convert(
					OdfTextDocument.loadDocument(filesConfig.getSourcePath() + filesConfig.getFilename() + ".odt"),
					new FileOutputStream(filesConfig.getTargetPath() + filesConfig.getFilename() + ".pdf"),
					PdfOptions.create());
		} catch (Exception e) {
			throw new IllegalStateException("Error generating PDF!", e);
		}
	}

}

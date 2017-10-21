package com.chuvadasquatro.cv.repository;

import com.chuvadasquatro.cv.config.FilesConfig;
import com.chuvadasquatro.cv.datasource.ODFDataSource;
import com.chuvadasquatro.cv.domain.Section;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

@Repository
public class SectionRepository {

	@Autowired
	private ODFDataSource dataSource;

	@Autowired
	private FilesConfig filesConfig;

	public Section readAll() {
		return new Section(new ArrayList<Object>(ODFDataSource.getTableIndex().keySet()));
	}

	public Section read(String section) {
		return new Section(getList(dataSource.getListIterator(section)));
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

	public Boolean create(MultipartFile file) {
		// create source directory
		new File(filesConfig.getSourcePath()).mkdirs();

		try {
			byte[] bytes = file.getBytes();
			OutputStream stream = new BufferedOutputStream(
					new FileOutputStream(new File(filesConfig.getSourcePath() + filesConfig.getFilename() + ".odt")));

			stream.write(bytes);
			stream.close();
		} catch (IOException e) {
			throw new IllegalArgumentException("Error uploading file!", e);
		}

		// reload data and generate PDF
		dataSource.loadTable();
		dataSource.generatePDF();

		return true;
	}

}

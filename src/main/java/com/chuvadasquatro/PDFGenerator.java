package com.chuvadasquatro;

import java.io.File;
import java.io.FileOutputStream;

import org.odftoolkit.odfdom.converter.pdf.PdfConverter;
import org.odftoolkit.odfdom.converter.pdf.PdfOptions;
import org.odftoolkit.odfdom.doc.OdfTextDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@SuppressWarnings("deprecation")
@Component
public class PDFGenerator implements ApplicationListener<ContextRefreshedEvent> {
	@Autowired
	private FilesConfig filesConfig;

	@Override
	public void onApplicationEvent(final ContextRefreshedEvent event) {
		try {
			new File(filesConfig.getTargetPath()).mkdirs();
			PdfConverter.getInstance().convert(
					OdfTextDocument.loadDocument(filesConfig.getSourcePath() + filesConfig.getFilename() + ".odt"),
					new FileOutputStream(filesConfig.getTargetPath() + filesConfig.getFilename() + ".pdf"),
					PdfOptions.create()
			);
		} catch (Exception e) {
			throw new RuntimeException("Error converting ODT to PDF.", e);
		}
	}
}

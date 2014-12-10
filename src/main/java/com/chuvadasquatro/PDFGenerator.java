package com.chuvadasquatro;

import java.io.File;
import java.io.FileOutputStream;

import org.odftoolkit.odfdom.converter.pdf.PdfConverter;
import org.odftoolkit.odfdom.converter.pdf.PdfOptions;
import org.odftoolkit.odfdom.doc.OdfTextDocument;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@SuppressWarnings("deprecation")
@Component
public class PDFGenerator implements ApplicationListener<ContextRefreshedEvent> {
	@Override
	public void onApplicationEvent(final ContextRefreshedEvent event) {
		try {
			new File("static/").mkdir();
			PdfConverter.getInstance().convert(
					OdfTextDocument.loadDocument("data/Resume - Rodrigo Costa.odt"),
					new FileOutputStream("static/Resume - Rodrigo Costa.pdf"),
					PdfOptions.create()
			);
		} catch (Exception e) {
			throw new RuntimeException("Error converting ODT to PDF.");
		}
	}
}

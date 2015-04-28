package com.chuvadasquatro;

import java.io.File;
import java.io.FileOutputStream;

import org.odftoolkit.odfdom.converter.pdf.PdfConverter;
import org.odftoolkit.odfdom.converter.pdf.PdfOptions;
import org.odftoolkit.odfdom.doc.OdfTextDocument;

@SuppressWarnings("deprecation")
public class PDFGeneratorStaticTest {
	public static void main(String[] args) {
		try {
			new File("data/target/").mkdirs();
			PdfConverter.getInstance().convert(
					OdfTextDocument.loadDocument("data/source/Rodrigo-Costa.odt"),
					new FileOutputStream("data/target/Rodrigo-Costa.pdf"),
					PdfOptions.create()
			);
			System.out.println("Convertion completed successfully!");
		} catch (Exception e) {
			System.err.println("There's something wrong with the world today: " + e.getMessage());
		}
	}
}

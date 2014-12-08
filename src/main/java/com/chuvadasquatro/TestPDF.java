package com.chuvadasquatro;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;

public class TestPDF {
	public static void main(String[] args) {
		try {
			PDDocument doc = PDDocument.load("data/Resume - Rodrigo Costa.pdf");
			PDFTextStripper ts = new PDFTextStripper();
			System.out.println(ts.getText(doc));
		} catch (Exception e) {
			System.err.println("There's something wrong with the world today: " + e.getMessage());
		}
	}
}

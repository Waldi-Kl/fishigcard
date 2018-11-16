package com.waldi.fishingcard.dao.impl;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.waldi.fishingcard.dao.PdfCreator;


@Service
public class PdfCreatorImp implements PdfCreator {

	@Override
	public void printPdf() {
		// TODO Auto-generated method stub3
		System.out.println("Uruchomi³ siê PDFCreator");
		final String dir = System.getProperty("user.dir");
		System.out.println("current dir = " + dir);

		String para1 = "Tutorials Point originated from the idea that there exists"
				+ "class of readers who respond better to online content and prefer to learn "
				+ "new skills at their own pace from the comforts of their drawing rooms.";

		String para2 = "The journey commenced with a single tutorial on HTML in 2006 "
				+ "and elated by the response it generated, we worked our way to adding fresh "
				+ "tutorials to our repository which now proudly flaunts a wealth of tutorials "
				+ "and allied articles on topics ranging from programming languages to web designing "
				+ "to academics and much more.";

		Document document = new Document();
		
		 Paragraph paragraph1 = new Paragraph(para1);             
	      Paragraph paragraph2 = new Paragraph(para2); 
	      
		try {
			PdfWriter.getInstance(document, new FileOutputStream("./iTextTable.pdf"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		document.open();

		PdfPTable table = new PdfPTable(3);
		addTableHeader(table);
		addRows(table);
		try {
			addCustomRows(table);
		} catch (BadElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			document.add(table);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
		Chunk chunk = new Chunk("Hello World", font);

		try {
			document.add(chunk);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	      // Adding paragraphs to document       
	      try {
			document.add(paragraph1);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}       
	      try {
			document.add(paragraph2);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  

		document.close();

	}

	private void addTableHeader(PdfPTable table) {
		Stream.of("column header 1", "column header 2", "column header 3").forEach(columnTitle -> {
			PdfPCell header = new PdfPCell();
			header.setBackgroundColor(BaseColor.LIGHT_GRAY);
			header.setBorderWidth(2);
			header.setPhrase(new Phrase(columnTitle));
			table.addCell(header);
		});
	}

	private void addRows(PdfPTable table) {
		table.addCell("row 1, col 1");
		table.addCell("row 1, col 2");
		table.addCell("row 1, col 3");
	}

	private void addCustomRows(PdfPTable table) throws URISyntaxException, BadElementException, IOException {
		// Path path =
		// Paths.get(ClassLoader.getSystemResource("Java_logo.png").toURI());
		// Path path = (Path)
		// java.nio.file.Paths.get(ClassLoader.getSystemResource("Java_logo.png").toURI());
		// Image img = Image.getInstance(((java.nio.file.Path)
		// path).toAbsolutePath().toString());
		// img.scalePercent(10);

		// PdfPCell imageCell = new PdfPCell(img);
		// table.addCell(imageCell);

		PdfPCell horizontalAlignCell = new PdfPCell(new Phrase("row 2, col 2"));
		horizontalAlignCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(horizontalAlignCell);

		PdfPCell verticalAlignCell = new PdfPCell(new Phrase("row 2, col 3"));
		verticalAlignCell.setVerticalAlignment(Element.ALIGN_BOTTOM);
		table.addCell(verticalAlignCell);
	}
}

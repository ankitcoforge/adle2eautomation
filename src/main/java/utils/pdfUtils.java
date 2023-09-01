package utils;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.testng.Assert;

public class pdfUtils {

	public void verifyContentInPDf(String url, String program) {
		// specify the url of the pdf file
		try {
			System.out.println(program);
			System.out.println(url);
			String pdfContent = readPdfContent(url);
			Assert.assertTrue(pdfContent.contains(program));
			if(program.contains("Sentinel")) {
				Assert.assertTrue(pdfContent.contains("Sentinel"));
			}
			else {
				
				Assert.assertTrue(pdfContent.contains(program), "Text Not found" + program);
			}

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String readPdfContent(String url) throws IOException {

		URL pdfUrl = new URL(url);
		InputStream in = pdfUrl.openStream();
		BufferedInputStream bf = new BufferedInputStream(in);
		PDDocument doc = PDDocument.load(bf);
		int numberOfPages = getPageCount(doc);
		System.out.println("The total number of pages " + numberOfPages);
		String content = new PDFTextStripper().getText(doc);
		doc.close();
		return content;
	}

	public int getPageCount(PDDocument doc) {
		// get the total number of pages in the pdf document
		int pageCount = doc.getNumberOfPages();
		return pageCount;

	}

}

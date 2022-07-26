package pageActions;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import pageObjects.contractpo;
import utils.utilityClass;

public class pdfAction extends contractpo {

	utilityClass event = new utilityClass();
	generateContractAction gc = new generateContractAction();
	createContractAction ca = new createContractAction();

	/************************
	 * Create contract
	 * 
	 * @throws InterruptedException
	 ****************************************/
	public void validatePDFContract(String[] inputArray) throws InterruptedException {

		HashMap<String, String> searchData1 = new HashMap<String, String>();
		searchData1 = contractData(inputArray);
		event.inputfield("cssSelector", textbox, searchData1.get("Firstname"), 0);
		event.inputfield("cssSelector", textbox, searchData1.get("Lastname"), 1);
		event.inputfield("cssSelector", textbox, searchData1.get("Mileage"), 5);
		event.inputfield("cssSelector", textbox, searchData1.get("Vin"), 6);
		event.clickfield("xpath", getProducts);
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		ca.programSelect(searchData1.get("program"));
		if ((searchData1.get("program").contains("Absolute Reserve Care Lease"))) {
			js.executeScript("window.scrollTo(0, 2200)");
			driver.findElement(By.cssSelector("adl-select[placeholder=\"Select Months\"]>ng-select")).click();
			driver.findElement(By.cssSelector(".ng-dropdown-panel-items > div > div")).click();
			driver.findElement(By.cssSelector("adl-select[placeholder=\"Select Miles\"]>ng-select")).click();
			driver.findElement(By.cssSelector(".ng-dropdown-panel-items > div > div")).click();
		}
		event.clickfield("cssSelector", table, 0);
		js.executeScript("window.scrollTo(0, 2400)");
		if (!((searchData1.get("program").contains("Limited Warranty")) || (searchData1.get("program").contains("Absolute Reserve Care Lease"))) ) {
			event.clickfield("xpath", businessUse);
		}
		List <WebElement> a = driver.findElements(By.cssSelector(inServiceDate));
		if(a.size() == 1) {
			String a1  = driver.findElement(By.cssSelector("adl-text-input[label='In-Service Date'] >div  >div + div")).getAttribute("class");
			if(!(a1.contains("disabled"))) {
				driver.findElement(By.cssSelector(inServiceDateTextBox)).click();
				System.out.println("td[aria-label='" + getDate() + "']");
				driver.findElement(By.cssSelector("td[aria-label='" + getDate() + "']")).click();
			}
			
		}
		js.executeScript("window.scrollTo(0, 2000)");
		event.inputfield("cssSelector", contract, "10000", 0);
		driver.findElements(By.cssSelector(textbox)).get(14).clear();
		event.inputfield("cssSelector", textbox, "20130", 14);
		driver.findElements(By.cssSelector(textbox)).get(13).clear();
		event.inputfield("cssSelector", textbox, "Address", 13);
		Thread.sleep(2000);
		event.clearfield("cssSelector", phone);
		event.inputfield("cssSelector", phone, "1234567890");
		event.clickfield("xpath", generateContract);
		getDriver().findElement(By.xpath(gc.generateContractHeading)).isDisplayed();
		Thread.sleep(2000);
		event.clickfield("cssSelector", gc.checkbox, 0);
		event.clickfield("cssSelector", gc.checkbox, 1);
		event.clickfield("xpath", gc.genrateContractButton);
		Thread.sleep(4000);
		HashSet<String> b = new HashSet<>();
		b = isFileDownloaded( System.getProperty("user.dir") + "\\PDF", ".pdf");
		event.clickfield("cssSelector", ".notification__container__actions > button");
//		driver.findElement(By.xpath("//span[contains(text(),\"View / Print Contract\")]//..")).click();
		Thread.sleep(3000);
		HashSet<String> a1 = new HashSet<>();
		a1 = isFileDownloaded( System.getProperty("user.dir") + "\\PDF", ".pdf");
		a1.removeAll(b);
		String pdfUrl = "file:///" +  System.getProperty("user.dir") + "\\PDF\\" + a1.toString().replaceAll("\\,|\\[|\\]|\\s", "");
		String pdfUrl1 = pdfUrl.replace("\\", "/");
		verifyContentInPDf(pdfUrl1, searchData1.get("program"));
		verifyContentInPDf(pdfUrl1, searchData1.get("Firstname"));
		verifyContentInPDf(pdfUrl1, searchData1.get("Lastname"));
		verifyContentInPDf(pdfUrl1, searchData1.get("Vin"));
		b.addAll(a1);
		event.clickfield("xpath", newQuotelink);

	}

//	public void verifyContentInPDf(String url, String program) {
//		// specify the url of the pdf file
//		try {
//			String pdfContent = readPdfContent(url);
//			if (program.contains("Sentinel")) {
//				Assert.assertTrue(pdfContent.contains("Sentinel"));
//			} else {
//				Assert.assertTrue(pdfContent.contains("AUL"));
//			}
//
//		} catch (MalformedURLException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}

//	public static String readPdfContent(String url) throws IOException {
//
//		URL pdfUrl = new URL(url);
//		InputStream in = pdfUrl.openStream();
//		BufferedInputStream bf = new BufferedInputStream(in);
//		PDDocument doc = PDDocument.load(bf);
//		int numberOfPages = getPageCount(doc);
//		System.out.println("The total number of pages " + numberOfPages);
//		String content = new PDFTextStripper().getText(doc);
//		doc.close();
//
//		return content;
//	}
//
//	public int getPageCount(PDDocument doc) {
//		// get the total number of pages in the pdf document
//		int pageCount = doc.getNumberOfPages();
//		return pageCount;
//
//	}

//	public HashSet<String> isFileDownloaded(String downloadPath, String fileName) {
////			boolean flag = false;
//		String pathnames[] = null;
//		File dir = new File(downloadPath);
//		// Populates the array with names of files and directories
//		pathnames = dir.list();
//		// For each pathname in the pathnames array
//		HashSet<String> a = new HashSet<>();
//
//		for (String pathname : pathnames) {
//			// Print the names of files and directories
//			a.add(pathname);
//		}
//		return a;
//	}

}

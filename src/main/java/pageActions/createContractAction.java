package pageActions;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import pageObjects.contractpo;
import utils.baseClass;
import utils.utilityClass;

public class createContractAction extends contractpo{
		
	    utilityClass event = new utilityClass();
	    generateContractAction gc = new generateContractAction();

		/************************Create contract 
		 * @throws InterruptedException ****************************************/
		public void createContract(String[] inputArray) throws InterruptedException {

			HashMap<String, String> searchData1 = new HashMap<String, String>();
			searchData1 = contractData(inputArray);
			event.inputfield("cssSelector", textbox, searchData1.get("Firstname"), 0);
			event.inputfield("cssSelector", textbox, searchData1.get("Lastname"), 1);
			event.inputfield("cssSelector", textbox, searchData1.get("Mileage"), 5);
			event.inputfield("cssSelector", textbox, searchData1.get("Vin"), 6);
			event.clickfield("xpath", getProducts);
			programSelect(searchData1.get("program"));
			event.clickfield("cssSelector", table, 0);
			String header = event.text("cssSelector", programNameCode);
			String[] program = header.split(" • ");
			String programCode = program[0];
			String programName = program[1];
			//String price = event.text("cssSelector", table,0);
			event.inputfield("cssSelector", contract, "10000", 0);
			if(!(searchData1.get("program").contains("Limited Warranty"))) {
				event.clickfield("xpath", businessUse);
			}
			List <WebElement> a = driver.findElements(By.cssSelector(inServiceDate));
			if(a.size() == 1) {
				driver.findElement(By.cssSelector(inServiceDateTextBox)).click();
				driver.findElement(By.cssSelector("td[aria-label=\"June 1, 2022\"]")).click();
			}
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
			if((searchData1.get("GenerateContract")).equals("one")) {
				gc.generateContractPopUp(programCode, programName);
			}
			event.clickfield("cssSelector", gc.checkbox, 0);
			event.clickfield("cssSelector", gc.checkbox, 1);
			event.clickfield("xpath", gc.genrateContractButton);
			Thread.sleep(5000);
			String text1 = event.text("cssSelector", successMessage);
			Assert.assertEquals(text1, "You have successfully generated a contract!");
			event.clickfield("xpath", newQuotelink);					
		}
		
		public void verifyContentInPDf(String url, String program) {
			//specify the url of the pdf file
			try {
				String pdfContent = readPdfContent(url);
				if(program.contains("Sentinel")) {
					Assert.assertTrue(pdfContent.contains("Sentinel"));
				}
				else {
					Assert.assertTrue(pdfContent.contains("AUL"));
				}
				
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		public static  String readPdfContent(String url) throws IOException {
			
			URL pdfUrl = new URL(url);
			InputStream in = pdfUrl.openStream();
			BufferedInputStream bf = new BufferedInputStream(in);
			PDDocument doc = PDDocument.load(bf);
			int numberOfPages = getPageCount(doc);
			System.out.println("The total number of pages "+numberOfPages);
			String content = new PDFTextStripper().getText(doc);
			doc.close();
		
		return content;
	}
		
		public static int getPageCount(PDDocument doc) {
			//get the total number of pages in the pdf document
			int pageCount = doc.getNumberOfPages();
			return pageCount;
			
		}
		
		public void programSelect(String programName) {
				getDriver().findElement(By.xpath(programfirstname + programName + programlastname)).isDisplayed();
				getDriver().findElement(By.xpath(programfirstname + programName + programlastname + "/preceding-sibling::div")).click();
			
		}
		
		public HashSet <String> isFileDownloaded(String downloadPath, String fileName) {
//			boolean flag = false;
		    String pathnames[] = null;
		    File dir = new File(downloadPath);
		 // Populates the array with names of files and directories
	        pathnames = dir.list();
	        // For each pathname in the pathnames array
	        HashSet <String> a = new HashSet<> ();
	        
	        for (String pathname : pathnames) {
	            // Print the names of files and directories
	            a.add(pathname);
	        }
	       
	        return a;
	    }

		public boolean calculatePrice() {
			String covPrice = event.text("xpath", table, 1);
			String price = covPrice.substring(1);
			String totalPrice = event.text("cssSelector",total);
			String[] calPrice = totalPrice.split("\\W+");
			if(price.compareTo(calPrice[1]) == 0){
				 return false;
			} else 
				return false;
			
		}
		
	}

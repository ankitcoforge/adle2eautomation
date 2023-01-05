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
			driver.findElement(By.cssSelector(monthDropdown)).click();
			driver.findElement(By.cssSelector(optionFirst)).click();
			driver.findElement(By.cssSelector(milesDropdown)).click();
			driver.findElement(By.cssSelector(optionFirst)).click();
		}
		event.clickfield("cssSelector", table, 0);
		js.executeScript("window.scrollTo(0, 2400)");
		if (!((searchData1.get("program").contains("Limited Warranty")) || (searchData1.get("program").contains("Absolute Reserve Care Lease")) ||  (searchData1.get("program").contains("Absolute Lifetime Powertrain Warranty")) || (searchData1.get("program").contains("Absolute Certified Warranty")))  ) {
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
		event.clickfield("cssSelector", gc.checkbox, 0);
		event.clickfield("cssSelector", gc.checkbox, 1);
		event.clickfield("xpath", gc.genrateContractButton);
		Thread.sleep(4000);
		HashSet<String> b = new HashSet<>();
		b = isFileDownloaded( System.getProperty("user.dir") + "\\PDF", ".pdf");
		event.clickfield("cssSelector", ".notification__container__actions > button");
		event.clickfield("xpath", newQuotelink);
		Thread.sleep(3000);
		HashSet<String> a1 = new HashSet<>();
		a1 = isFileDownloaded( System.getProperty("user.dir") + "\\PDF", ".pdf");
		a1.removeAll(b);
		String pdfUrl = "file:///" +  System.getProperty("user.dir") + "\\PDF\\" + a1.toString().replaceAll("\\,|\\[|\\]|\\s", "");
		String pdfUrl1 = pdfUrl.replace("\\", "/");
		verifyContentInPDf(pdfUrl1, "AUL");
		b.addAll(a1);

	}

}

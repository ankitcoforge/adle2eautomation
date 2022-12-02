package pageActions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;

import pageObjects.contractpo;
import utils.utilityClass;
@Listeners(utils.listnerlogs.class)

public class printQuoteAction extends contractpo{
	
    utilityClass event = new utilityClass();
    generateContractAction gc = new generateContractAction();
    createContractAction co = new createContractAction();
    quoteContractSuccessAction qc = new quoteContractSuccessAction();
    
    String savequote = "//span[contains(text(),'Print Quote')]";

	/************************Create contract 
	 * @throws InterruptedException ****************************************/
	public void printQuote() throws InterruptedException {

		
		try {
		event.inputfield("cssSelector", textbox, "Single", 0);
		event.inputfield("cssSelector", textbox, "Test", 1);
		event.inputfield("cssSelector", textbox, "1234", 5);
		event.inputfield("cssSelector", textbox, "5J6RW2H89NA004619", 6);
		event.clickfield("xpath", getProducts);
		co.programSelect("Limited Warranty - OCW");
		event.clickfield("cssSelector", table, 0);
		event.inputfield("cssSelector", contract, "10000", 0);
		List <WebElement> a = driver.findElements(By.cssSelector(inServiceDate));
		if(a.size() == 1) {
			String a1  = driver.findElement(By.cssSelector("adl-text-input[label='In-Service Date'] >div  >div + div")).getAttribute("class");
			if(!(a1.contains("disabled"))) {
				driver.findElement(By.cssSelector(inServiceDateTextBox)).click();
				System.out.println("td[aria-label='" + getDate() + "']");
				driver.findElement(By.cssSelector("td[aria-label='" + getDate() + "']")).click();
			}
			
		}
		driver.findElements(By.cssSelector(textbox)).get(14).clear();
		event.inputfield("cssSelector", textbox, "20130", 14);
		driver.findElements(By.cssSelector(textbox)).get(13).clear();
		event.inputfield("cssSelector", textbox, "Address", 13);
		Thread.sleep(2000);
		event.clearfield("cssSelector", phone);
		event.inputfield("cssSelector", phone, "1234567890");
		event.clickfield("xpath", savequote);
		Thread.sleep(5000);
		String text1 = event.text("cssSelector", successMessage);
		Assert.assertEquals(qc.closeButton(), "close");
		Assert.assertEquals(qc.viewPrintButton(), "View / Print Quote");
		Assert.assertEquals(qc.goToQuotePagelink(), "Go to Quote Page");
		Assert.assertEquals(qc.startNewQuotelink(), "Start New Quote");
		event.clickfield("xpath", newQuotelink);
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Test Case failed ");
			e.getCause();
			Assert.fail();
		}
	}
	
	public void validateQuotePDF(String[] inputArray) throws InterruptedException {

		HashMap<String, String> searchData1 = new HashMap<String, String>();
		searchData1 = contractData(inputArray);
		event.inputfield("cssSelector", textbox, searchData1.get("Firstname"), 0);
		event.inputfield("cssSelector", textbox, searchData1.get("Lastname"), 1);
		event.inputfield("cssSelector", textbox, searchData1.get("Mileage"), 5);
		event.inputfield("cssSelector", textbox, searchData1.get("Vin"), 6);
		event.clickfield("xpath", getProducts);
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		co.programSelect(searchData1.get("program"));
		if ((searchData1.get("program").contains("Absolute Reserve Care Lease"))) {
			js.executeScript("window.scrollTo(0, 2200)");
			driver.findElement(By.cssSelector("adl-select[placeholder=\"Select Months\"]>ng-select")).click();
			driver.findElement(By.cssSelector(".ng-dropdown-panel-items > div > div")).click();
			driver.findElement(By.cssSelector("adl-select[placeholder=\"Select Miles\"]>ng-select")).click();
			driver.findElement(By.cssSelector(".ng-dropdown-panel-items > div > div")).click();
		}
		event.clickfield("cssSelector", table, 0);
		js.executeScript("window.scrollTo(0, 2400)");
		if (!((searchData1.get("program").contains("Limited Warranty")) || (searchData1.get("program").contains("Absolute Reserve Care Lease")) ||  (searchData1.get("program").contains("Absolute Lifetime Powertrain Warranty"))) ) {
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
		HashSet<String> b = new HashSet<>();
		b = isFileDownloaded( System.getProperty("user.dir") + "\\PDF", ".pdf");
		System.out.println(b);
		event.clickfield("xpath", savequote);
//		String text1 = event.text("cssSelector", successMessage);
		Thread.sleep(4000);
		//event.clickfield("cssSelector", goToQuote);
		HashSet<String> a1 = new HashSet<>();
		a1 = isFileDownloaded( System.getProperty("user.dir") + "\\PDF", ".pdf");
		a1.removeAll(b);
		String pdfUrl = "file:///" +  System.getProperty("user.dir") + "\\PDF\\" + a1.toString().replaceAll("\\,|\\[|\\]|\\s", "");
		String pdfUrl1 = pdfUrl.replace("\\", "/");
		verifyContentInPDf(pdfUrl1, "Online Service Contract Quote");
		b.addAll(a1);
		event.clickfield("cssSelector", goToQuote);

	}

}

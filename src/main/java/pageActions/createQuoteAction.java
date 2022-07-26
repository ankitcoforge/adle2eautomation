package pageActions;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import utils.baseClass;
import utils.utilityClass;

public class createQuoteAction extends baseClass{

	utilityClass event = new utilityClass();
	createContractAction co = new createContractAction();
    quoteContractSuccessAction qc = new quoteContractSuccessAction();
    verticalMenuAction vo = new verticalMenuAction();

	
	/*************page object for Save quote page is declared ********************/
	String savequote = "//span[contains(text(),'Save Quote')]";
	
public void printQuote() throws InterruptedException {

		
		try {
		event.inputfield("cssSelector", co.textbox, "Single", 0);
		event.inputfield("cssSelector", co.textbox, "Test", 1);
		event.inputfield("cssSelector", co.textbox, "1234", 5);
		event.inputfield("cssSelector", co.textbox, "5J6RW2H89NA004619", 6);
		event.clickfield("xpath", co.getProducts);
		co.programSelect("Limited Warranty - OCW");
		event.clickfield("cssSelector", co.table, 0);
		event.inputfield("cssSelector", co.contract, "10000", 0);
		List <WebElement> a = driver.findElements(By.cssSelector(co.inServiceDate));
		if(a.size() == 1) {
			String a1  = driver.findElement(By.cssSelector("adl-text-input[label='In-Service Date'] >div  >div + div")).getAttribute("class");
			if(!(a1.contains("disabled"))) {
				driver.findElement(By.cssSelector(co.inServiceDateTextBox)).click();
				System.out.println("td[aria-label='" + getDate() + "']");
				driver.findElement(By.cssSelector("td[aria-label='" + getDate() + "']")).click();
			}
			
		}
		driver.findElements(By.cssSelector(co.textbox)).get(14).clear();
		event.inputfield("cssSelector", co.textbox, "20130", 14);
		driver.findElements(By.cssSelector(co.textbox)).get(13).clear();
		event.inputfield("cssSelector", co.textbox, "Address", 13);
		Thread.sleep(2000);
		event.clearfield("cssSelector", co.phone);
		event.inputfield("cssSelector", co.phone, "1234567890");
		event.clickfield("xpath", savequote);
		Thread.sleep(5000);
		String text1 = event.text("cssSelector", co.successMessage);
		Assert.assertEquals(driver.getCurrentUrl(), "https://qa.adl.aulcorp.com/portal/rate/rate-contract");
		Assert.assertEquals(qc.closeButton(), "close");
		Assert.assertEquals(qc.viewPrintButton(), "View / Print Quote");
		Assert.assertEquals(qc.goToQuotePagelink(), "Go to Quote Page");
		Assert.assertEquals(qc.startNewQuotelink(), "Start New Quote");
		event.clickfield("cssSelector",qc.goToQuotePage);
		Assert.assertEquals(driver.getCurrentUrl(), "https://qa.adl.aulcorp.com/portal/rate/quote-history");
		vo.navigatetoLeftMenu("Rate/Contract");
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Test Case failed ");
			e.getCause();
			Assert.fail();
		}
	}

	
	/************************Create contract 
	 * @throws InterruptedException ****************************************/
	public void createQuote(String [] inputArray) throws InterruptedException {
		HashMap<String, String> searchData1 = new HashMap<String, String>();
		searchData1 = contractData(inputArray);
		event.inputfield("cssSelector", co.textbox, searchData1.get("Firstname"), 0);
		event.inputfield("cssSelector", co.textbox, searchData1.get("Lastname"), 1);
		event.inputfield("cssSelector", co.textbox, searchData1.get("Mileage"), 5);
		event.inputfield("cssSelector", co.textbox, searchData1.get("Vin"), 6);
		event.clickfield("xpath", co.getProducts);
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		co.programSelect(searchData1.get("program"));
		if ((searchData1.get("program").contains("Absolute Reserve Care Lease"))) {
			js.executeScript("window.scrollTo(0, 2200)");
			Assert.assertEquals(driver.findElements(By.cssSelector("adl-lease-term >div >div> span")).get(0).getText(), "Lease Term Months:");
			Assert.assertEquals(driver.findElements(By.cssSelector("adl-lease-term >div >div> span")).get(1).getText(), "Lease Term Miles:");
			driver.findElement(By.cssSelector("adl-select[placeholder=\"Select Months\"]>ng-select")).click();
			driver.findElement(By.cssSelector(".ng-dropdown-panel-items > div > div")).click();
			driver.findElement(By.cssSelector("adl-select[placeholder=\"Select Miles\"]>ng-select")).click();
			driver.findElement(By.cssSelector(".ng-dropdown-panel-items > div > div")).click();
			Assert.assertEquals(driver.findElement(By.cssSelector("adl-warning-message >div > p>span")).getText(), "Please select the rate in the table.");
		}
		event.clickfield("cssSelector", co.table, 0);
		String price = event.text("cssSelector", co.table,0);
		event.inputfield("cssSelector", co.contract, "10000", 0);
		if(!(searchData1.get("program").contains("Limited Warranty") || (searchData1.get("program").contains("Absolute Reserve Care Lease"))) ){
			event.clickfield("xpath", co.businessUse);
		}
		List <WebElement> a = driver.findElements(By.cssSelector(co.inServiceDate));
		if(a.size() == 1) {
			String a1  = driver.findElement(By.cssSelector("adl-text-input[label='In-Service Date'] >div  >div + div")).getAttribute("class");
			if(!(a1.contains("disabled"))) {
				driver.findElement(By.cssSelector(co.inServiceDateTextBox)).click();
				System.out.println("td[aria-label='" + getDate() + "']");
				driver.findElement(By.cssSelector("td[aria-label='" + getDate() + "']")).click();
			}
			
		}
		driver.findElements(By.cssSelector(co.textbox)).get(14).clear();
		event.inputfield("cssSelector", co.textbox, "20130", 14);
		driver.findElements(By.cssSelector(co.textbox)).get(13).clear();
		event.inputfield("cssSelector", co.textbox, "Address", 13);
		Thread.sleep(4000);
		event.clearfield("cssSelector", co.phone);
		event.inputfield("cssSelector", co.phone, "1234567890");	
		event.clickfield("xpath", savequote);
		Thread.sleep(3000);
		String x1 = event.text("cssSelector", co.successMessage);
		Assert.assertEquals(x1, "Your Quote has been successfully saved!");
		event.clickfield("xpath", co.newQuotelink);
	}

}

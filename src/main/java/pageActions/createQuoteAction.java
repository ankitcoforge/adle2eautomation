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
		co.selectOptionSurcharge();
		co.inserviceDate();
		filladdressQuote();
		WebElement element = new WebDriverWait(driver, Duration.ofSeconds(9)).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(co.successMessage)));
		Assert.assertEquals(element.getText(), "Your Quote has been successfully saved!");
//		String text1 = event.text("cssSelector", co.successMessage);
		Assert.assertEquals(driver.getCurrentUrl(), "https://qa2.adl.aulcorp.com/portal/rate/rate-contract");
		Assert.assertEquals(qc.closeButton(), "close");
		Assert.assertEquals(qc.viewPrintButton(), "View / Print Quote");
		Assert.assertEquals(qc.goToQuotePagelink(), "Go to Quote Page");
		Assert.assertEquals(qc.startNewQuotelink(), "Start New Quote");
		event.clickfield("cssSelector",qc.goToQuotePage);
		Assert.assertEquals(driver.getCurrentUrl(), "https://qa2.adl.aulcorp.com/portal/rate/quote-history");
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
			co.leaseProgram();
		}
		event.clickfield("cssSelector", co.table, 0);
		event.inputfield("cssSelector", co.contract, "10000", 0);
		co.selectOptionSurcharge();
		co.inserviceDate();
		filladdressQuote();
		WebElement element = new WebDriverWait(driver, Duration.ofSeconds(9)).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(co.successMessage)));
		Assert.assertEquals(element.getText(), "Your Quote has been successfully saved!");
		event.clickfield("cssSelector", co.newQuotelink);
	}

	
	public void filladdressQuote() throws InterruptedException {
		driver.findElements(By.cssSelector(co.textbox)).get(14).clear();
		event.inputfield("cssSelector", co.textbox, "20130", 14);
		driver.findElements(By.cssSelector(co.textbox)).get(13).clear();
		event.inputfield("cssSelector", co.textbox, "Address", 13);
		Thread.sleep(2000);
		event.clearfield("cssSelector", co.phone);
		event.inputfield("cssSelector", co.phone, "1234567890");	
		event.clickfield("xpath", savequote);
	}
}

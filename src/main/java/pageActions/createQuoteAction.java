package pageActions;

import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import utils.baseClass;
import utils.utilityClass;

public class createQuoteAction extends baseClass{

	utilityClass event = new utilityClass();
	createContractAction co = new createContractAction();
	
	/*************page object for Save quote page is declared ********************/
	String savequote = "//span[contains(text(),'Save Quote')]";
	
	/************************Create contract 
	 * @throws InterruptedException ****************************************/
	public String createQuote(String [] inputArray) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOf(event.element("xpath", co.getProducts)));
		HashMap<String, String> searchData1 = new HashMap<String, String>();
		searchData1 = contractData(inputArray);
		event.inputfield("cssSelector", co.textbox, searchData1.get("Firstname"), 0);
		event.inputfield("cssSelector", co.textbox, searchData1.get("Lastname") , 1);
		event.inputfield("cssSelector", co.textbox, searchData1.get("Mileage"), 5);
		event.inputfield("cssSelector", co.textbox, searchData1.get("Vin"), 6);
		event.clickfield("xpath", co.getProducts);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(event.element("xpath", co.selectProgram, 2)));
		co.programSelect(searchData1.get("program"));
		wait.until(ExpectedConditions.visibilityOf(event.element("xpath", co.table, 1)));
		event.clickfield("xpath", co.table, 1);
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
		Thread.sleep(4000);
		//getDriver().findElements(By.cssSelector(".ng-input")).get(2).click();
		getDriver().findElements(By.tagName("adl-option-card")).get(0).click();
		getDriver().findElements(By.tagName("adl-option-card")).get(2).click();
		event.inputfield("cssSelector", co.contract, "10000", 0);
		driver.findElements(By.cssSelector(co.textbox)).get(14).clear();
		//event.inputfield("cssSelector", contract, "10000", 0);
		
		event.inputfield("cssSelector", co.textbox, "20130", 14);
		driver.findElements(By.cssSelector(co.textbox)).get(13).clear();
		event.inputfield("cssSelector", co.textbox, "Address", 13);
		event.clearfield("cssSelector", co.textbox, 17);
		event.inputfield("cssSelector", co.textbox, "1234567890", 17);
		event.clickfield("xpath", savequote);
		Thread.sleep(3000);
		String x1 = event.text("cssSelector", co.successMessage);
		event.clickfield("xpath", "//a[contains(text(),'Start New Quote')]");
		return(x1);
	}

}

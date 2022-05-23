package pageActions;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
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
	
	/*************page object for Save quote page is declared ********************/
	String savequote = "//span[contains(text(),'Save Quote')]";
	
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
		co.programSelect(searchData1.get("program"));
		event.clickfield("xpath", co.table, 1);
		event.inputfield("cssSelector", co.contract, "10000", 0);
		if(!(searchData1.get("program").contains("Limited Warranty"))) {
			event.clickfield("xpath", "//p[contains(text(),'Business Use')]//..");
		}
		List <WebElement> a = driver.findElements(By.cssSelector("adl-text-input[label='In-Service Date']"));
		if(a.size() == 1) {
			driver.findElement(By.cssSelector("button > span >mat-icon")).click();
			driver.findElement(By.cssSelector("td[aria-label=\"May 1, 2022\"]")).click();
		}
		driver.findElements(By.cssSelector(co.textbox)).get(14).clear();
		event.inputfield("cssSelector", co.textbox, "20130", 14);
		driver.findElements(By.cssSelector(co.textbox)).get(13).clear();
		event.inputfield("cssSelector", co.textbox, "Address", 13);
		Thread.sleep(4000);
		event.clearfield("cssSelector", "adl-text-input[label='Phone Number'] > div > div.text-field__input.secure > input");
		event.inputfield("cssSelector", "adl-text-input[label='Phone Number'] > div > div.text-field__input.secure > input", "1234567890");	
		event.clickfield("xpath", savequote);
		Thread.sleep(3000);
		String x1 = event.text("cssSelector", co.successMessage);
		Assert.assertEquals(x1, "Your Quote has been successfully saved!");
		event.clickfield("xpath", "//a[contains(text(),'Start New Quote')]");
	}

}

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
			event.clickfield("xpath", table, 1);
			event.inputfield("cssSelector", contract, "10000", 0);
			if(!(searchData1.get("program").contains("Limited Warranty"))) {
				event.clickfield("xpath", "//p[contains(text(),'Business Use')]//..");
			}
			List <WebElement> a = driver.findElements(By.cssSelector("adl-text-input[label='In-Service Date']"));
			System.out.println(a.size());
			if(a.size() == 1) {
				driver.findElement(By.cssSelector("button > span >mat-icon")).click();
				driver.findElement(By.cssSelector("td[aria-label=\"May 1, 2022\"]")).click();
			}
			driver.findElements(By.cssSelector(textbox)).get(14).clear();
			event.inputfield("cssSelector", textbox, "20130", 14);
			driver.findElements(By.cssSelector(textbox)).get(13).clear();
			event.inputfield("cssSelector", textbox, "Address", 13);
			Thread.sleep(5000);
			event.clearfield("cssSelector", "adl-text-input[label='Phone Number'] > div > div.text-field__input.secure > input");
			event.inputfield("cssSelector", "adl-text-input[label='Phone Number'] > div > div.text-field__input.secure > input", "1234567890");
			//Assert.assertEquals(x, true, "Total Price Mismatch");
			event.clickfield("xpath", generateContract);
			getDriver().findElement(By.xpath("//h3[contains(text(),'Generate Contract')]")).isDisplayed();
			Thread.sleep(5000);
			if((searchData1.get("GenerateContract")).equals("one")) {
				gc.generateContractPopUp();
			}
			event.clickfield("cssSelector", "div.review_contract__validate__checkbox > adl-checkbox > div > mat-checkbox", 0);
			event.clickfield("cssSelector", "div.review_contract__validate__checkbox > adl-checkbox > div > mat-checkbox", 1);
			Thread.sleep(3000);
			event.clickfield("xpath", "//span[contains(text(),'Generate Contract')]");
			Thread.sleep(5000);
			//String text = event.text("cssSelector", successMessage);
			String text = driver.findElement(By.cssSelector("div.notification__container__message > span")).getText();
			Assert.assertEquals(text, "You have successfully generated a contract!");
			event.clickfield("xpath", "//a[contains(text(),'Start New Quote')]");
			
			
		}
		
		public void programSelect(String programName) {
				getDriver().findElement(By.xpath(programfirstname + programName + programlastname)).isDisplayed();
				getDriver().findElement(By.xpath(programfirstname + programName + programlastname + "/preceding-sibling::div")).click();
			
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




package pageActions;

import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.contractpo;
import utils.baseClass;
import utils.utilityClass;

public class createContractAction extends contractpo{
		
	    utilityClass event = new utilityClass();

		int i =0;
		/************************Create contract 
		 * @throws InterruptedException ****************************************/
		public String createContract(String[] inputArray) throws InterruptedException {

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
			driver.findElements(By.cssSelector(textbox)).get(14).clear();
			event.inputfield("cssSelector", textbox, "20130", 14);
			driver.findElements(By.cssSelector(textbox)).get(13).clear();
			event.inputfield("cssSelector", textbox, "Address", 13);
			Thread.sleep(5000);
			event.clearfield("cssSelector", textbox, 17);
			event.inputfield("cssSelector", textbox, "1234567890", 17);
			boolean x = calculatePrice();
			//Assert.assertEquals(x, true, "Total Price Mismatch");
			event.clickfield("xpath", generateContract);
			getDriver().findElement(By.xpath("//h3[contains(text(),'Generate Contract')]")).isDisplayed();
			Thread.sleep(5000);
			event.clickfield("cssSelector", "div.review_contract__validate__checkbox > adl-checkbox > div > mat-checkbox", 0);
			event.clickfield("cssSelector", "div.review_contract__validate__checkbox > adl-checkbox > div > mat-checkbox", 1);
			Thread.sleep(3000);
			event.clickfield("xpath", "//span[contains(text(),'Generate Contract')]");
			Thread.sleep(3000);
			//String x1 = event.text("cssSelector", successMessage);
			String x1 = driver.findElement(By.cssSelector(".notification__container__message >span")).getText();
			System.out.println(x1);
			event.clickfield("xpath", "//a[contains(text(),'Start New Quote')]");
			return (x1);	
			
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




package pageActions;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import pageObjects.contractpo;
import utils.utilityClass;

public class twoProgramContractAction extends contractpo {

	utilityClass event = new utilityClass();
	generateContractAction gc = new generateContractAction();
	createContractAction ca = new createContractAction();

	/************************
	 * Create contract
	 * 
	 * @throws InterruptedException
	 ****************************************/
	public void createTwoContract(String[] inputArray) throws InterruptedException {

		try {
			HashMap<String, String> searchData2 = new HashMap<String, String>();
			searchData2 = twoContractData(inputArray);
			event.inputfield("cssSelector", textbox, searchData2.get("Firstname"), 0);
			event.inputfield("cssSelector", textbox, searchData2.get("Lastname"), 1);
			event.inputfield("cssSelector", textbox, searchData2.get("Mileage"), 5);
			event.inputfield("cssSelector", textbox, searchData2.get("Vin"), 6);
			event.clickfield("xpath", getProducts);
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			ca.programSelect(searchData2.get("programs"));
			System.out.println(searchData2.get("program2"));
			Thread.sleep(10000);
			ca.programSelect(searchData2.get("program2"));
			Thread.sleep(5000);
			event.clickfield("cssSelector", table, 0);
			String borderColorFirst = driver.findElements(By.cssSelector(tableborder)).get(0).getCssValue("border-color");
			Assert.assertEquals(Color.fromString(borderColorFirst).asHex(), prop.getProperty("orangeColorInHexaForm"));
			Thread.sleep(5000);
			WebElement element = driver.findElement(By.cssSelector("adl-rates-table > table >tbody > tr:nth-child(1) > td:nth-child(2)"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element); 
			//element.click();
			event.clickfield("cssSelector", table, 1);
			js.executeScript("window.scrollTo(0, 2500)");
			String borderColorSecond = driver.findElements(By.cssSelector(tableborder)).get(1).getCssValue("border-color");
			Assert.assertEquals(Color.fromString(borderColorSecond).asHex(), prop.getProperty("orangeColorInHexaForm"));
			selectOptionSurcharge();
			((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
			WebElement card = driver.findElement(By.cssSelector("div.card"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", card); 
			card.click();
			inserviceDate();
			event.inputfield("cssSelector", fieldbyLabelName("Deal Number"), "12345");
			String dealValue = driver.findElement(By.cssSelector(fieldbyLabelName("Deal Number"))).getDomProperty("value");
			Assert.assertEquals(dealValue, "12345");
			Assert.assertEquals(length(vehiclePurchasePrice), 1);
			event.inputfield("cssSelector", contract, "10000", 0);
			Assert.assertEquals(length(contractNo), 1);
			Assert.assertEquals(length(overideContractNo), 2);
			Assert.assertEquals(length(retailPrice), 2);
			String a2 = driver.findElements(By.cssSelector(fieldbyLabelName("Contract Retail Price"))).get(0).getDomProperty("value");
			String a3 = driver.findElements(By.cssSelector(fieldbyLabelName("Contract Retail Price"))).get(1).getDomProperty("value");
		    String a4 = a2.replace(",","");
		    double t1 = Double.parseDouble(a4);
		    String a5 = a3.replace(",","");
		    double t2 = Double.parseDouble(a5);
		    double total = t1 + t2;
//		    Assert.assertEquals(addGapLabel(), "Add GAP");
			event.clearfield("xpath", zipcode);
			event.inputfield("xpath", zipcode, "20130");
			String fullTotal = event.text("cssSelector", totalFooter);
			String updateTotal = fullTotal.replace("Total: $", "");
			String t = updateTotal.replace(",","");
			System.out.println(t);
			Assert.assertEquals(total, Double.parseDouble(t));
			event.clearfield("xpath", address);
			event.inputfield("xpath", address, "Address");
			Thread.sleep(2000);
			event.clearfield("xpath", phoneno);
			event.inputfield("xpath", phoneno, "1234567890");
			
			event.clickfield("xpath", generateContract);
			Thread.sleep(2000);
			event.clickfield("cssSelector", gc.checkbox, 0);
			event.clickfield("cssSelector", gc.checkbox, 1);
			event.clickfield("xpath", gc.genrateContractButton);
			Thread.sleep(5000);
			String text1 = event.text("cssSelector", successMessage);
			Assert.assertEquals(text1, "You have successfully generated contracts!");
			event.clickfield("xpath", newQuotelink);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Test Case failed ");
			e.getCause();
			Assert.fail();
			driver.navigate().refresh();
		}
	}
	
	
	public void businessSelection (String program, int flag){

		switch (program) {
		
		
		case "Limited Warranty" : System.out.println("No business program");
		break;
		
		case "Unlimited Time - AUN" : System.out.println("No business program");
		break;
		
		case "Lifetime Warranty - New" : System.out.println("No business program");
		break;
		
	
		default:event.clickfield("xpath", businessUse, flag);
		flag++;
		
		}
	}
}

package pageActions;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
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
			js.executeScript("window.scrollTo(0, 700)");
			ca.programSelect(searchData2.get("programs"));
			Thread.sleep(3000);
			js.executeScript("window.scrollTo(0, 900)");
			ca.programSelect(searchData2.get("program2"));
			Thread.sleep(3000);
			event.clickfield("cssSelector", table, 0);
			String borderColorFirst = driver.findElements(By.cssSelector(tableborder)).get(0).getCssValue("border-color");
			Assert.assertEquals(Color.fromString(borderColorFirst).asHex(), prop.getProperty("orangeColorInHexaForm"));
			int flag = 0;
			js.executeScript("window.scrollTo(0, 2200)");
			if (!(searchData2.get("programs").contains("Limited Warranty"))) {
				if(!(searchData2.get("program2").contains("Unlimited Time - AUN"))) {
					event.clickfield("xpath", businessUse, flag);
					flag++;
					}
			}
			event.inputfield("cssSelector", fieldbyLabelName("Deal Number"), "12345");
			js.executeScript("window.scrollTo(0, 2400)");
			event.clickfield("cssSelector", table, 1);
			String borderColorSecond = driver.findElements(By.cssSelector(tableborder)).get(1).getCssValue("border-color");
			Assert.assertEquals(Color.fromString(borderColorSecond).asHex(), prop.getProperty("orangeColorInHexaForm"));
			if (!(searchData2.get("program2").contains("Limited Warranty"))) {
				if(!(searchData2.get("program2").contains("Unlimited Time - AUN"))) {
				event.clickfield("xpath", businessUse, flag);
				flag++;
				}
			}
			List<WebElement> a = driver.findElements(By.cssSelector(inServiceDate));
			if (a.size() == 1) {
				String a1 = driver
						.findElement(By.cssSelector("adl-text-input[label='In-Service Date'] >div  >div + div"))
						.getAttribute("class");
				if (!(a1.contains("disabled"))) {
					driver.findElement(By.cssSelector(inServiceDateTextBox)).click();
					System.out.println("td[aria-label='" + getDate() + "']");
					driver.findElement(By.cssSelector("td[aria-label='" + getDate() + "']")).click();
				}

			}
			String dealValue = driver.findElement(By.cssSelector(fieldbyLabelName("Deal Number"))).getDomProperty("value");
			Assert.assertEquals(dealValue, "12345");
			Assert.assertEquals(length(vehiclePurchasePrice), 1);
			event.inputfield("cssSelector", contract, "10000", 0);
			Assert.assertEquals(length(contractNo), 2);
			Assert.assertEquals(length(overideContractNo), 2);
			Assert.assertEquals(length(retailPrice), 2);
			String a2 = driver.findElements(By.cssSelector(fieldbyLabelName("Contract Retail Price"))).get(0).getDomProperty("value");
			String a3 = driver.findElements(By.cssSelector(fieldbyLabelName("Contract Retail Price"))).get(1).getDomProperty("value");
		    String a4 = a2.replace(",","");
		    double t1 = Double.parseDouble(a4);
		    String a5 = a3.replace(",","");
		    double t2 = Double.parseDouble(a5);
		    double total = t1 + t2;
		    Assert.assertEquals(addGapLabel(), "Add GAP");
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

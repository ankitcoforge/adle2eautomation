package pageActions;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
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
//			js.executeScript("window.scrollTo(0, 1800)");
//			event.clickfield("cssSelector", table, 1);
			int flag = 0;
			js.executeScript("window.scrollTo(0, 2200)");
			if (!(searchData2.get("programs").contains("Limited Warranty"))) {
				if(!(searchData2.get("program2").contains("Unlimited Time - AUN"))) {
					event.clickfield("xpath", businessUse, flag);
					flag++;
					}
			}
			js.executeScript("window.scrollTo(0, 2400)");
			event.clickfield("cssSelector", table, 1);
			if (!(searchData2.get("program2").contains("Limited Warranty"))) {
				if(!(searchData2.get("program2").contains("Unlimited Time - AUN"))) {
				event.clickfield("xpath", businessUse, flag);
				flag++;
				}
			}
//			js.executeScript("window.scrollTo(0, 2000)");
//			List<WebElement> ba1 = driver.findElements(By.cssSelector("p[class='card__label']"));
//			if(ba1.size()!=0) {
//				System.out.println(ba1.size());
//			for(int i = 0; i< ba1.size(); i++) {
//				System.out.println(ba1.get(i).getText());
//			if(ba1.get(i).getText().equals("Business Use")){
//				ba1.get(i).click();
//			}
//			}
//			}
			//js.executeScript("window.scrollTo(0, 2200)");
			//System.out.println(searchData2.get("programs"));
			//businessSelection(searchData2.get("programs"), flag);
			//js.executeScript("window.scrollTo(0, 2300)");		
			//businessSelection(searchData2.get("program2"), flag);
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

			event.inputfield("cssSelector", contract, "10000", 0);
			event.clearfield("xpath", zipcode);
			event.inputfield("xpath", zipcode, "20130");
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

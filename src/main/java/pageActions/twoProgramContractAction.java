package pageActions;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import pageObjects.contractpo;
import utils.utilityClass;

public class twoProgramContractAction extends contractpo{

	utilityClass event = new utilityClass();
	generateContractAction gc = new generateContractAction();
	createContractAction ca = new createContractAction();

	/************************
	 * Create contract
	 * 
	 * @throws InterruptedException
	 ****************************************/
	public void createContract(String[] inputArray) throws InterruptedException {

		HashMap<String, String> searchData2 = new HashMap<String, String>();
		searchData2 = twoContractData(inputArray);
		event.inputfield("cssSelector", textbox, searchData2.get("Firstname"), 0);
		event.inputfield("cssSelector", textbox, searchData2.get("Lastname"), 1);
		event.inputfield("cssSelector", textbox, searchData2.get("Mileage"), 5);
		event.inputfield("cssSelector", textbox, searchData2.get("Vin"), 6);
		event.clickfield("xpath", getProducts);
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0, 1000)");
		ca.programSelect(searchData2.get("programs"));
		Thread.sleep(3000);
		ca.programSelect(searchData2.get("program2"));
		Thread.sleep(9000);
		event.clickfield("cssSelector", table, 0);
		int flag =0;
		js.executeScript("window.scrollTo(0, 1200)");
		if (!(searchData2.get("programs").contains("Limited Warranty"))) {
		event.clickfield("xpath", businessUse, flag);
		flag++;
		}
		js.executeScript("window.scrollTo(0, 1800)");
		event.clickfield("cssSelector", table, 1);
		if (!(searchData2.get("program2").contains("Limited Warranty"))) {
			event.clickfield("xpath", businessUse, flag);
			flag++;
			}

		List<WebElement> a = driver.findElements(By.cssSelector(inServiceDate));
		if (a.size() == 1) {
			driver.findElement(By.cssSelector(inServiceDateTextBox)).click();
			driver.findElement(By.cssSelector("td[aria-label=\"June 1, 2022\"]")).click();
		}

		event.inputfield("cssSelector", contract, "10000", 0);
		js.executeScript("window.scrollTo(0, 2200)");
		event.clearfield("xpath", zipcode);
		event.inputfield("xpath", zipcode, "20130");
		event.clearfield("xpath", address);
		event.inputfield("xpath", address, "Address");
		Thread.sleep(2000);
		event.clearfield("xpath", phoneno);
		event.inputfield("xpath", phoneno, "1234567890");
		event.clickfield("xpath", generateContract);
		event.clickfield("cssSelector", gc.checkbox, 0);
		event.clickfield("cssSelector", gc.checkbox, 1);
		event.clickfield("xpath", gc.genrateContractButton);
		Thread.sleep(5000);
		String text1 = event.text("cssSelector", successMessage);
		Assert.assertEquals(text1, "You have successfully generated contracts!");
		event.clickfield("xpath", newQuotelink);
	}
}

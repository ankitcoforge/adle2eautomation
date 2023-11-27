package pageActions;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pageObjects.contractpo;
import utils.utilityClass;

public class createContractAction extends contractpo {

	utilityClass event = new utilityClass();
	generateContractAction gc = new generateContractAction();
	loginAction lo = new loginAction();
	

	/************************
	 * Create contract
	 * 
	 * @throws InterruptedException
	 ****************************************/
	@SuppressWarnings("deprecation")
	public void createContract(String[] inputArray) throws InterruptedException {

		try {
			
			HashMap<String, String> searchData1 = new HashMap<String, String>();
			searchData1 = contractData(inputArray);
			event.inputfield("cssSelector", textbox, searchData1.get("Firstname"), 0);
			event.inputfield("cssSelector", textbox, searchData1.get("Lastname"), 1);
			event.inputfield("cssSelector", textbox, searchData1.get("Mileage"), 5);
			event.inputfield("cssSelector", textbox, searchData1.get("Vin"), 6);
			event.clickfield("xpath", getProducts);
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			programSelect(searchData1.get("program"));
			if ((searchData1.get("program").contains("Absolute Reserve Care Lease"))) {
				js.executeScript("window.scrollTo(0, 2200)");
				leaseProgram();
			}
			event.clickfield("cssSelector", table, 0);
			String header = event.text("cssSelector", programNameCode);
			String[] program = header.split(" � ");
			String programCode = program[0];
			String programName = program[1];
			event.inputfield("cssSelector", contract, "10000", 0);
			System.out.println(searchData1.get("program"));
			selectOptionSurcharge();
			inserviceDate();
			filladdress();
			getDriver().findElement(By.xpath(gc.generateContractHeading)).isDisplayed();
			WebElement heading = new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(gc.generateContractHeading)));
			if ((searchData1.get("GenerateContract")).equals("one")) {
				gc.generateContractPopUp(programCode, programName);
			}
			gc.selectGenerateContract();
			WebElement element = new WebDriverWait(driver, Duration.ofSeconds(9)).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(successMessage)));
			Assert.assertEquals(element.getText(), "You have successfully generated a contract!");
			event.clickfield("cssSelector", newQuotelink);
		} catch (ElementNotInteractableException e) {
			e.printStackTrace();
			System.out.println("Test Case failed ");
			e.getCause();
			Assert.fail();
			lo.logout();
			lo.login("shreya.agarwal@protective.com", prop.getProperty("password"));
		}
	}
	
	@SuppressWarnings("deprecation")
	public void createlenderContract(String[] inputArray) throws InterruptedException {

		try {
			driver.findElement(By.cssSelector("input[placeholder ='Type or Select Dealer Name']")).click();
			dealerList("TestDealer_17july2023");
			HashMap<String, String> searchData1 = new HashMap<String, String>();
			searchData1 = contractData(inputArray);
			event.inputfield("cssSelector", textbox, searchData1.get("Firstname"), 0);
			event.inputfield("cssSelector", textbox, searchData1.get("Lastname"), 1);
			event.inputfield("cssSelector", textbox, searchData1.get("Mileage"), 5);
			event.inputfield("cssSelector", textbox, searchData1.get("Vin"), 6);
			event.clickfield("xpath", getProducts);
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			programSelect(searchData1.get("program"));
			if ((searchData1.get("program").contains("Absolute Reserve Care Lease"))) {
				js.executeScript("window.scrollTo(0, 2200)");
				leaseProgram();
			}
			event.clickfield("cssSelector", table, 0);
			String header = event.text("cssSelector", programNameCode);
			String[] program = header.split(" � ");
			String programCode = program[0];
			String programName = program[1];
			event.inputfield("cssSelector", contract, "10000", 0);
			System.out.println(searchData1.get("program"));
			selectOptionSurcharge();
			inserviceDate();
			filladdress();
			getDriver().findElement(By.xpath(gc.generateContractHeading)).isDisplayed();
			WebElement heading = new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(gc.generateContractHeading)));
			if ((searchData1.get("GenerateContract")).equals("one")) {
				gc.generateContractPopUp(programCode, programName);
			}
			gc.selectGenerateContract();
			WebElement element = new WebDriverWait(driver, Duration.ofSeconds(9)).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(successMessage)));
			Assert.assertEquals(element.getText(), "You have successfully generated a contract!");
			event.clickfield("cssSelector", newQuotelink);
		} catch (ElementNotInteractableException e) {
			e.printStackTrace();
			System.out.println("Test Case failed ");
			e.getCause();
			Assert.fail();
			lo.logout();
			lo.login("shreya.agarwal@protective.com", prop.getProperty("password"));
		}
	}

	public void programSelect(String programName) {

		getDriver().findElement(By.xpath(programfirstname + programName + programlastname)).isDisplayed();
		getDriver().findElement(By.xpath(programfirstname + programName + programlastname + "/preceding-sibling::div"))
				.click();

	}

	public boolean calculatePrice() {
		String covPrice = event.text("xpath", table, 1);
		String price = covPrice.substring(1);
		String totalPrice = event.text("cssSelector", total);
		String[] calPrice = totalPrice.split("\\W+");
		if (price.compareTo(calPrice[1]) == 0) {
			return false;
		} else
			return false;

	}

	public void createContractWithUniversalLenders(String[] inputArray) throws InterruptedException {

		try {
			HashMap<String, String> searchData1 = new HashMap<String, String>();
			searchData1 = contractData(inputArray);
			event.inputfield("cssSelector", textbox, searchData1.get("Firstname"), 0);
			event.inputfield("cssSelector", textbox, searchData1.get("Lastname"), 1);
			event.inputfield("cssSelector", textbox, "Universal Lenders LLC", 2);
			event.inputfield("cssSelector", textbox, searchData1.get("Mileage"), 5);
			event.inputfield("cssSelector", textbox, searchData1.get("Vin"), 6);
			event.clickfield("xpath", getProducts);
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			programSelect(searchData1.get("program"));
			if ((searchData1.get("program").contains("Absolute Reserve Care Lease"))) {
				js.executeScript("window.scrollTo(0, 2200)");
				Assert.assertEquals(driver.findElements(By.cssSelector("adl-lease-term >div >div> span")).get(0).getText(), "Lease Term Months:");
				Assert.assertEquals(driver.findElements(By.cssSelector("adl-lease-term >div >div> span")).get(1).getText(), "Lease Term Miles:");
				driver.findElement(By.cssSelector("adl-select[placeholder=\"Select Months\"]>ng-select")).click();
				driver.findElement(By.cssSelector(".ng-dropdown-panel-items > div > div")).click();
				driver.findElement(By.cssSelector("adl-select[placeholder=\"Select Miles\"]>ng-select")).click();
				driver.findElement(By.cssSelector(".ng-dropdown-panel-items > div > div")).click();
				Assert.assertEquals(warningTextMesssage(), "Please select the rate in the table.");
			}
			event.clickfield("cssSelector", table, 0);
			String header = event.text("cssSelector", programNameCode);
			String[] program = header.split(" � ");
			String programCode = program[0];
			String programName = program[1];
			event.inputfield("cssSelector", contract, "10000", 0);
			if (!((searchData1.get("program").contains("Limited Warranty")) || (searchData1.get("program").contains("Absolute Reserve Care Lease")) ||  (searchData1.get("program").contains("Absolute Lifetime Powertrain Warranty")) || (searchData1.get("program").contains("Absolute Certified Warranty")))  ) {
				event.clickfield("xpath", businessUse);
			}
			List<WebElement> a = driver.findElements(By.cssSelector(inServiceDate));
			if (a.size() == 1) {
				String a1 = driver
						.findElement(By.cssSelector(inServicefield))
						.getAttribute("class");
				if (!(a1.contains("disabled"))) {
					driver.findElement(By.cssSelector(inServiceDateTextBox)).click();
					driver.findElement(By.cssSelector("td[aria-label='" + getDate() + "']")).click();
				}

			}
			Assert.assertEquals(addGapLabel(), "Add GAP");
			js.executeScript("window.scrollTo(0, 2500)");
			System.out.println("Hello world");
			driver.findElements(By.cssSelector(textbox)).get(14).clear();
			event.inputfield("cssSelector", textbox, "20130", 14);
			driver.findElements(By.cssSelector(textbox)).get(13).clear();
			event.inputfield("cssSelector", textbox, "Address", 13);
			Thread.sleep(2000);
			event.clearfield("cssSelector", phone);
			event.inputfield("cssSelector", phone, "1234567890");
			event.clickfield("xpath", generateContract);
			getDriver().findElement(By.xpath(gc.generateContractHeading)).isDisplayed();
			Thread.sleep(2000);
			if ((searchData1.get("GenerateContract")).equals("one")) {
				gc.generateContractPopUp(programCode, programName);
			}
			event.clickfield("cssSelector", gc.checkbox, 0);
			event.clickfield("cssSelector", gc.checkbox, 1);
			event.clickfield("xpath", gc.genrateContractButton);
			Thread.sleep(5000);
			String text1 = event.text("cssSelector", successMessage);
			Assert.assertEquals(text1, "You have successfully generated a contract!");
			event.clickfield("xpath", newQuotelink);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Test Case failed ");
			e.getCause();
			Assert.fail();
		}
	}

}

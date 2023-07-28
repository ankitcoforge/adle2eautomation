package pageActions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import pageObjects.contractpo;
import utils.baseClass;
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
			String[] program = header.split(" • ");
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
			String[] program = header.split(" • ");
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

}

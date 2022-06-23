package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import utils.baseClass;

public class ERateContractpo extends baseClass {

	// span[contains(text(),"Get Products")]
	public String RCMileageTextBox = "// label[contains(text(),\"Mileage\")]//following::input[1]";
	public String RCVINTextBox = "// label[contains(text(),\"VIN\")]//following::input[1]";
	public String RCLimitedWaranty = "//span[contains(text(),\" Limited Warranty - RAW \")]";
	public String RCGetProducts = "//span[contains(text(),\"Get Products\")]";
	public String RCCustomerLastNameTextBox = "//strong[contains(text(),\"Customer Information\")]//following::label[contains(text(),\"Last Name\")]//following::input[1]";
	public String RCCustomerAddressTextBox = "//strong[contains(text(),\"Customer Information\")]//following::label[contains(text(),\"Address\")]//following::input[1]";
	public String RCCustomerCityTextBox = "//strong[contains(text(),\"Customer Information\")]//following::label[contains(text(),\"City\")]//following::input[1]";
	public String RCCustomerZipcodeTextBox = "//strong[contains(text(),\"Customer Information\")]//following::label[contains(text(),\"Zip Code\")]//following::input[1]";
	public String RCCustomerEmailAddressTextBox = "//strong[contains(text(),\"Customer Information\")]//following::label[contains(text(),\"Email\")]//following::input[1]";
	public String RCCustomerPhoneNumberTextBox = "//strong[contains(text(),\"Customer Information\")]//following::label[contains(text(),\"Phone Number\")]//following::input[1]";
	public String RCProceedToGenerateContractButton = "//span[contains(text(),\"Proceed to generate contract(s)\")]";
	public String RCInvalidZipErrorMessage = "//label[contains(text(),\"Zip Code\")]//following::span[contains(text(),\"Invalid format. Please try again.\")][1]";
	public String RCInvalidEmailErrorMessage = "//label[contains(text(),\"Email\")]//following::span[contains(text(),\"Invalid format. Please try again.\")][1]";
	public String RCInvalidPhoneNumberErrorMessage = "//label[contains(text(),\"Phone Number\")]//following::span[contains(text(),\"Invalid format. Please try again.\")][1]";
	public String RCProceedToGeneratePopUpCloseIcon = "//mat-icon[contains(text(),\"close\")]";
	public String RCSaveQuoteButton = "//span[contains(text(),\"Save Quote\")]";
	public String RCViewPrintQuoteButton = "//span[contains(text(),\"View / Print Quote\")]";
	public String RCGoToQuotePageButton  ="//a[contains(text(),\"Go to Quote Page\")]";
	public String RCGenerateContractCheckboxOne = "//*[contains(text(),\"Total\")]//following::input[@type=\"checkbox\"][1]";
	public String RCGenerateContractCheckboxTwo = "//*[contains(text(),\"Total\")]//following::input[@type=\"checkbox\"][2]";

	public int requiredfieldCount() {

		int count = 0;

		List<WebElement> mandatoryFields = driver.findElements(By.xpath("//span[contains(text(),\"Required\")]"));

		return mandatoryFields.size();
	}
	
	public void clickAction(String element) {
		
		driver.findElement(By.xpath(element)).click();
	}

	public void verifyEmptyTextField(int i, String value) {

		WebElement element;
		String textBoxValue;

		switch (i) {

		case 0:

			element = driver.findElement(By.xpath(RCMileageTextBox));
			textBoxValue = element.getAttribute("value");

			Assert.assertTrue(textBoxValue.isEmpty());

			element.sendKeys(value);
			break;

		case 1:
			element = driver.findElement(By.xpath(RCVINTextBox));
			textBoxValue = element.getAttribute("value");

			Assert.assertTrue(textBoxValue.isEmpty());

			element.sendKeys(value);
			break;

		}
	}

//	public void insertValue(String value) {
//
//		driver.findElement(By.xpath(RCMileageTextBox)).sendKeys(value);
//
//	}

	public void sleepWaitFunction(int time) {

		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void windowScroll() {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,800)", "");

	}

	public void verifyEmptyTextFieldandInsert(int i, String value) {

		WebElement element;
		String textBoxValue;

		switch (i) {

		case 0:

			element = driver.findElement(By.xpath(RCCustomerLastNameTextBox));
			textBoxValue = element.getAttribute("value");

			Assert.assertTrue(textBoxValue.isEmpty());

			element.sendKeys(value);
			break;

		case 1:
			element = driver.findElement(By.xpath(RCCustomerAddressTextBox));
			textBoxValue = element.getAttribute("value");

			Assert.assertTrue(textBoxValue.isEmpty());

			element.sendKeys(value);
			break;

		case 3:
			element = driver.findElement(By.xpath(RCCustomerCityTextBox));
			textBoxValue = element.getAttribute("value");

			Assert.assertTrue(textBoxValue.isEmpty());

			element.sendKeys(value);
			break;
		case 2:
			element = driver.findElement(By.xpath(RCCustomerZipcodeTextBox));
			textBoxValue = element.getAttribute("value");

			Assert.assertTrue(textBoxValue.isEmpty());

			element.sendKeys(value);
			break;

		case 4:
			element = driver.findElement(By.xpath(RCCustomerPhoneNumberTextBox));
			textBoxValue = element.getAttribute("value");

//			Assert.assertTrue(textBoxValue.isEmpty());

			element.sendKeys(value);
			break;

		}
	}

	public void VerifyInvalidFormat(int i) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10, 1));

		WebElement element;
		String textBoxValue;

		switch (i) {

		case 0:

			driver.findElement(By.xpath(RCCustomerZipcodeTextBox)).clear();
			driver.findElement(By.xpath(RCCustomerZipcodeTextBox)).sendKeys("895");
			driver.findElement(By.xpath(RCProceedToGenerateContractButton)).click();

			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(RCInvalidZipErrorMessage)));
			sleepWaitFunction(5000);
			driver.findElement(By.xpath(RCCustomerZipcodeTextBox)).clear();
			driver.findElement(By.xpath(RCCustomerZipcodeTextBox)).sendKeys("95842");
			driver.findElement(By.xpath(RCProceedToGenerateContractButton)).click();
			driver.findElement(By.xpath(RCProceedToGeneratePopUpCloseIcon)).click();
			break;

		case 1:
			driver.findElement(By.xpath(RCCustomerEmailAddressTextBox)).clear();
			driver.findElement(By.xpath(RCCustomerEmailAddressTextBox)).sendKeys("abc@m");
			driver.findElement(By.xpath(RCProceedToGenerateContractButton)).click();
			sleepWaitFunction(5000);

			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(RCInvalidEmailErrorMessage)));
			driver.findElement(By.xpath(RCCustomerEmailAddressTextBox)).clear();
			driver.findElement(By.xpath(RCCustomerEmailAddressTextBox)).sendKeys("abc@mail.com");
			driver.findElement(By.xpath(RCProceedToGenerateContractButton)).click();
			driver.findElement(By.xpath(RCProceedToGeneratePopUpCloseIcon)).click();
			sleepWaitFunction(5000);
			break;

		case 2:
			driver.findElement(By.xpath(RCCustomerPhoneNumberTextBox)).clear();
			sleepWaitFunction(5000);
			driver.findElement(By.xpath(RCCustomerPhoneNumberTextBox)).sendKeys("96514284");
			driver.findElement(By.xpath(RCProceedToGenerateContractButton)).click();
			sleepWaitFunction(5000);

			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(RCInvalidPhoneNumberErrorMessage)));
			String ActualMessage = driver.findElement(By.xpath(RCInvalidPhoneNumberErrorMessage)).getText();
			driver.findElement(By.xpath(RCCustomerPhoneNumberTextBox)).clear();
			driver.findElement(By.xpath(RCCustomerPhoneNumberTextBox)).sendKeys("9876215768");
			driver.findElement(By.xpath(RCProceedToGenerateContractButton)).click();
			driver.findElement(By.xpath(RCProceedToGeneratePopUpCloseIcon)).click();
			sleepWaitFunction(5000);
			break;

		}

	}

	public void switchToActiveElement() {

		driver.switchTo().activeElement();
	}

}

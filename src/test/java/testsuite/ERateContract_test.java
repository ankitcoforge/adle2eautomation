package testsuite;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageActions.loginAction;
import pageActions.verticalMenuAction;
import pageObjects.ERateContractpo;
@Listeners(utils.listnerlogs.class)
public class ERateContract_test extends ERateContractpo {

	loginAction lo = new loginAction();
	verticalMenuAction vo = new verticalMenuAction();

	/*************
	 * login to the application
	 * 
	 * @throws InterruptedException
	 *********************/
	@BeforeClass
	public void login() throws InterruptedException {

		navigate();
		lo.login(prop.getProperty("username"), prop.getProperty("password"));
		vo.navigatetoContract();

	}

	@Test(priority = 1)
	public void ValidateContractBasicInformationMandatoryField() {
		
		clickAction(RCGetProducts);

		int count = requiredfieldCount();

		String[] values = { "65472", "JN8AS58TX9W905001" };

		for (int i = 0; i < count; i++) {

			verifyEmptyTextField(i, values[i]);

		}
		
		clickAction(RCGetProducts);

	}

	@Test(dependsOnMethods = "ValidateContractBasicInformationMandatoryField", priority = 2)
	public void ProgramSelectionFromResults() {

		switchToActiveElement();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10, 1));

		WebElement checkbox1 = driver.findElement(By.xpath("//span[contains(text(),\" Limited Warranty - RAW \")]"));
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//span[contains(text(),\" Limited Warranty - RAW \")]")));

		checkbox1.click();

		WebElement checkbox2 = driver.findElement(By.xpath("//span[contains(text(),\" Used Vehicle - RNL \")]"));
		wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),\" Used Vehicle - RNL \")]")));

		sleepWaitFunction(5000);

		checkbox2.click();

	}

	@Test(dependsOnMethods = "ProgramSelectionFromResults", priority = 3)
	public void selectClassValueAmount() {

		sleepWaitFunction(5000);

		driver.findElement(
				By.xpath("//*[contains(text(),\"RAW • Limited Warranty - RAW\")]//following::table/tbody/tr[1]/td[2]"))
				.click();

		sleepWaitFunction(5000);

		windowScroll();

		driver.findElement(
				By.xpath("//*[contains(text(),\"RNL • Used Vehicle - RNL\")]//following::table/tbody/tr[1]/td[2]"))
				.click();

		sleepWaitFunction(4000);

	}

	@Test(dependsOnMethods = "selectClassValueAmount", priority = 4)
	public void verifySurchargesMandatoryFields() {
		
		clickAction(RCProceedToGenerateContractButton);

		sleepWaitFunction(4000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10, 1));

		WebElement checkbox1 = driver.findElement(By.xpath("//*[contains(text(),\" No Surcharges \")]"));

		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),\" No Surcharges \")]")));

		boolean flag = checkbox1.isSelected();

		if (!checkbox1.isSelected()) {
			checkbox1.click();
		}

	}

	@Test(dependsOnMethods = "verifySurchargesMandatoryFields", priority = 5)
	public void verifyContractInformationMandatoryFields() {
		sleepWaitFunction(4000);

		WebElement element = driver
				.findElement(By.xpath("//label[contains(text(),\"Vehicle Purchase Price\")]//following::input[1]"));
		String textBoxValue = element.getAttribute("value");

		Assert.assertTrue(textBoxValue.isEmpty());

		element.sendKeys("8088");

		sleepWaitFunction(4000);

	}

	@Test(dependsOnMethods = "verifyContractInformationMandatoryFields", priority = 6)
	public void verifyCustomerInformationMandatoryFields() {

		windowScroll();

		int count = requiredfieldCount();

		String[] values = { "LastName", "Address01", "95842", "SACRAMENTO", "6067421942" };

		for (int i = 0; i < count; i++) {

			verifyEmptyTextFieldandInsert(i, values[i]);

		}

	}

	@Test(priority = 7)
	public void validateInvalidZipFormatCustomerInformationFields() {

//		VerifyInvalidFormat(0);

	}

	@Test(priority = 8)
	public void validateInvalidEmailFormatCustomerInformationFields() {

		VerifyInvalidFormat(1);

	}

	@Test(priority = 9)
	public void validateInvalidPhoneNumberFormatCustomerInformationFields() {

		VerifyInvalidFormat(2);

	}

	@Test(dependsOnMethods = "verifyCustomerInformationMandatoryFields", priority = 10)
	public void verifySaveQuoteAndPrintFunctionality() {

		sleepWaitFunction(2000);
		
		clickAction(RCSaveQuoteButton);
		
		sleepWaitFunction(4000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10, 1));

		WebElement Element = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//span[contains(text(),\"Your Quote has been successfully saved!\")]")));
		boolean flag = Element.isDisplayed();

		Assert.assertEquals(flag, true);
		
		clickAction(RCViewPrintQuoteButton);
		clickAction(RCGoToQuotePageButton);

		driver.findElement(By.xpath(
				"//span[contains(text(),\"RAW9W905001F22\")]//following::i[@class=\"pi pi-pencil clickeable\"][1]"))
				.click();

	}

	@Test(dependsOnMethods = "verifySaveQuoteAndPrintFunctionality", priority = 11)
	public void verifyGenerateContractsandContractsDetails() {

		sleepWaitFunction(10000);
		
		clickAction(RCProceedToGenerateContractButton);

		sleepWaitFunction(4000);

		WebElement E1, E2;
		String value1, value2;
		boolean flag1;
		E1 = driver.findElement(By.xpath(
				"//*[contains(text(),\"Generate Contracts\")][1]//following::label[contains(text(),\"Limited Warranty - RAW\")]//following::label[1]"));
		flag1 = E1.isDisplayed();
		Assert.assertEquals(flag1, true);
		value1 = E1.getText();

		Assert.assertEquals(value1, "$210.00");

		E2 = driver.findElement(By.xpath(
				"//*[contains(text(),\"Generate Contracts\")][1]//following::label[contains(text(),\"Used Vehicle - RNL\")]//following::label[1]"));
		flag1 = E2.isDisplayed();
		Assert.assertEquals(flag1, true);
		value2 = E2.getText();

		Assert.assertEquals(value1, "$1,065.00");
		
		clickAction(RCGenerateContractCheckboxOne);
		clickAction(RCGenerateContractCheckboxTwo);

		sleepWaitFunction(50000);// Proceed to generate contract(s)

	}

	/***************
	 * logout to the application
	 * 
	 * @throws InterruptedException
	 ********************/
	@AfterClass
	public void close() throws InterruptedException {

		lo.logout();

	}

}

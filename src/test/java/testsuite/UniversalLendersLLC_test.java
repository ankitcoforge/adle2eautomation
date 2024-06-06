package testsuite;

import java.text.ParseException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageActions.UniversalLendersAction;
import pageActions.WebMileageExceptionAction;
import pageActions.cobuyerContractAction;
import pageActions.createContractAction;
import pageActions.generateContractAction;
import pageActions.impersonateAction;
import pageActions.loginAction;
import pageActions.singleContractAction;
import pageActions.verticalMenuAction;
import utils.CalenderUtils;
import utils.utilityClass;

public class UniversalLendersLLC_test extends UniversalLendersAction {

	loginAction login = new loginAction();
	verticalMenuAction verticalMenu = new verticalMenuAction();
	impersonateAction impersonate = new impersonateAction();
	WebMileageExceptionAction wme = new WebMileageExceptionAction();
	utilityClass event = new utilityClass();
	CalenderUtils calander = new CalenderUtils();
	GAP_test gap = new GAP_test();
	cobuyerContractAction cobuyerContract = new cobuyerContractAction();
	singleContractAction singleContractAction = new singleContractAction();
	createContractAction contract = new createContractAction();
	EditContract_test EditContract = new EditContract_test();

	@BeforeMethod(alwaysRun = true)
	public void login() throws InterruptedException {
		navigate();
		Assert.assertEquals(login.getTitle(), "Protective");
	}

	@Test(priority = 1)
	public void verifyPageAfterSelecetingUniversalLenders_11931_11948_11977() throws InterruptedException, ParseException {
		login.login(prop.getProperty("adminusername"), prop.getProperty("password"));
		verticalMenu.navigatetoimpersonate();
		impersonate.impersonateUser("Dealer", "29422");
		Thread.sleep(2000);
		verticalMenu.navigatetoLeftMenu("E-Rate", "Rate/Contract");
		Thread.sleep(2000);
		getProducts("5FNRL6H27NB019645", "100");
		Assert.assertTrue(event.element("xpath", gap.results).isDisplayed());
		Assert.assertTrue(event.element("xpath", gap.makeModelYear).isDisplayed());
		Assert.assertTrue(event.element("xpath", gap.manufacturerPowerTrainWarranty).isDisplayed());
		Assert.assertTrue(event.element("xpath", gap.fullFactoryWarranty).isDisplayed());
		Assert.assertTrue(event.element("xpath", gap.chooseTwoPrograms).isDisplayed());
		event.scrollDownUsingJSE();
		for (int i = 0; i < getRadioBtnsForPrograms().size(); i++) {
			Assert.assertFalse(getRadioBtnsForPrograms().get(i).isSelected());
		}
		selectProgram("Absolute Certified Warranty");
		Thread.sleep(10000);
		event.clickfield("cssSelector", wme.table);
		Assert.assertTrue(getTotalTxt().isDisplayed());
		Assert.assertTrue(getTotalValue().isDisplayed());

	}

	
	@Test(priority = 2)
	public void verifyErrorMsgs_11938_11949_11950_11951_11952_11953_11965()
			throws InterruptedException, ParseException {
		login.login(prop.getProperty("adminusername"), prop.getProperty("password"));
		verticalMenu.navigatetoimpersonate();
		impersonate.impersonateUser("Dealer", "29422");
		Thread.sleep(2000);
		verticalMenu.navigatetoLeftMenu("E-Rate", "Rate/Contract");
		Thread.sleep(2000);
		getProducts("5FNRL6H27NB019645", "100");
		event.scrollDownUsingJSE();
		selectProgram("Used Vehicle - SNL");
		Thread.sleep(10000);
		event.clickfield("cssSelector", wme.table);
		Thread.sleep(2000);
		event.scrollDownUsingJSE();
		Thread.sleep(2000);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click()", event.element("xpath", overrideContractNoCheckbox));
		Thread.sleep(1000);
		// clearing retail price
		event.element("cssSelector", singleContractAction.contract, 1).sendKeys(Keys.BACK_SPACE);
		event.element("cssSelector", singleContractAction.contract, 1).sendKeys(Keys.BACK_SPACE);
		event.element("cssSelector", singleContractAction.contract, 1).sendKeys(Keys.BACK_SPACE);
		event.element("cssSelector", singleContractAction.contract, 1).sendKeys(Keys.BACK_SPACE);
		event.element("cssSelector", singleContractAction.contract, 1).sendKeys(Keys.BACK_SPACE);
		event.element("cssSelector", singleContractAction.contract, 1).sendKeys(Keys.BACK_SPACE);
		event.element("cssSelector", singleContractAction.contract, 1).sendKeys(Keys.BACK_SPACE);
		event.scrollDownUsingJSE();
		Thread.sleep(2000);
		driver.findElements(By.cssSelector(contract.textbox)).get(14).clear();
		driver.findElements(By.cssSelector(contract.textbox)).get(13).clear();
		Thread.sleep(2000);
		event.clearfield("cssSelector", contract.phone);
		String invalidMail = "abcd";
		EditContract.getCoustomerInfoFields().get(5).clear();
		EditContract.getCoustomerInfoFields().get(5).sendKeys(invalidMail);
		Thread.sleep(2000);
		Thread.sleep(2000);
		event.scrollDown();
		Thread.sleep(2000);
		event.scrollDown();
		event.clickfield("xpath", nextButton);
		Thread.sleep(2000);
		// verifications
		jse.executeScript("window.scrollTo(0, 200)");
		Assert.assertTrue(event.element("xpath", surchargesErrorMsg).isDisplayed());
		Assert.assertTrue(verifyErrorMsg("Contract Number").isDisplayed());
		Thread.sleep(2000);
		Assert.assertTrue(verifyErrorMsg("Contract Retail Price").isDisplayed());
		Thread.sleep(2000);
		Assert.assertTrue(verifyErrorMsg("Vehicle Purchase Price").isDisplayed());
		jse.executeScript("window.scrollTo(0, 200)");
		Thread.sleep(2000);
		Assert.assertTrue(verifyErrorMsg("Zip Code").isDisplayed());
		Thread.sleep(2000);
		Assert.assertTrue(verifyErrorMsg("Phone Number").isDisplayed());
		Assert.assertTrue(EditContract.getInvalidFormatErrorMsg().isDisplayed(),
				"Invalid Format error is displayed for email field");
	}

	@Test(priority = 3)
	public void verifyErrorMsgsForCobuyerFields_11954_11966_11968_11972_11973()
			throws InterruptedException, ParseException {
		login.login(prop.getProperty("adminusername"), prop.getProperty("password"));
		verticalMenu.navigatetoimpersonate();
		impersonate.impersonateUser("Dealer", "29422");
		Thread.sleep(2000);
		verticalMenu.navigatetoLeftMenu("E-Rate", "Rate/Contract");
		Thread.sleep(2000);
		getProducts("5FNRL6H27NB019645", "100");
		event.scrollDownUsingJSE();
		selectProgram("Used Vehicle - SNL");
		Thread.sleep(10000);
		event.clickfield("cssSelector", wme.table);
		Thread.sleep(2000);
		event.scrollDownUsingJSE();
		Thread.sleep(2000);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		driver.findElements(By.cssSelector(contract.textbox)).get(14).clear();
		jse.executeScript("arguments[0].click()", driver.findElement(By.cssSelector(cobuyerContract.coBuyer)));
		Thread.sleep(2000);
		event.scrollDown();
		Thread.sleep(2000);
		event.clickfield("xpath", nextButton);
		Thread.sleep(2000);
		jse.executeScript("window.scrollTo(0, 10000)");
		Thread.sleep(2000);
		Assert.assertTrue(verifyErrorMsgForCobuyer("Zip Code").isDisplayed());
		Thread.sleep(2000);
//	Assert.assertTrue(verifyErrorMsgForCobuyer("Last Name").isDisplayed());
		Thread.sleep(2000);
		Assert.assertTrue(verifyErrorMsgForCobuyer("Address").isDisplayed());
		Thread.sleep(2000);
		Assert.assertTrue(verifyErrorMsgForCobuyer("City").isDisplayed());
		Thread.sleep(2000);
		Assert.assertTrue(verifyErrorMsgForCobuyer("Phone Number").isDisplayed());
	}
	
	@Test(priority = 4)
	public void verifyContractCreationWithUniversalLenders_11939_12620_11940_11990()
			throws InterruptedException, ParseException {
		login.login(prop.getProperty("adminusername"), prop.getProperty("password"));
		verticalMenu.navigatetoimpersonate();
		impersonate.impersonateUser("Dealer", "29422");
		Thread.sleep(2000);
		verticalMenu.navigatetoLeftMenu("E-Rate", "Rate/Contract");
		Thread.sleep(2000);
		coBuyerContractwithMandatoryFields();
	}


	@AfterMethod(alwaysRun = true)
	public void close() throws InterruptedException {
		try {
			login.logout();
		} catch (Exception e) {
			if (event.getfield("mat-icon", "close").isDisplayed()) {
				event.getfield("mat-icon", "close").click();
			}
			login.logout();
		}
	}

}

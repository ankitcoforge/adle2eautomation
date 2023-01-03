package testsuite;

import java.util.HashMap;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageActions.EmployeePacksAction;
import pageActions.PricingPreerencesAction;
import pageActions.impersonateAction;
import pageActions.loginAction;
import pageActions.singleContractAction;
import pageActions.verticalMenuAction;
import pageObjects.PricingPreferencesPO;
import utils.utilityClass;

public class PricingPreferences_test extends PricingPreerencesAction {
	
	loginAction login = new loginAction();
	verticalMenuAction verticalMenu = new verticalMenuAction();
	
	utilityClass utils = new utilityClass();
	impersonateAction impersonate = new impersonateAction ();
	singleContractAction contract =new singleContractAction();
	EmployeePacksAction EmplPacks =new EmployeePacksAction();

	@BeforeClass(alwaysRun=true)
	public void login() throws InterruptedException {
		navigate();
		Assert.assertEquals(login.getTitle(), "AUL Corp.");
	}
	
	@Test(priority = 1)
	public void verifyPricingPreferencesPage_31666() throws Exception {
		login.login(prop.getProperty("dealerAutomation"), prop.getProperty("password"));
		Assert.assertEquals(getPortalTitle().getText(), "Welcome to your AUL ADL Portal!");
		Thread.sleep(2000);
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
		Thread.sleep(2000);
		Assert.assertTrue(utils.getTitle("Manage My Pricing Preferences").isDisplayed());
		Assert.assertTrue(utils.getfield("span", "New markup").isEnabled());
		HashMap<Integer, HashMap<String, String>> grid = EmplPacks.checkGridBodyDetailsTxt();
		getAllHeaderNames().contains("Program");
		getAllHeaderNames().contains("Program Code");
		getAllHeaderNames().contains("Prog Markup Eff.Date");
		getAllHeaderNames().contains(" Markup Type ");
		getAllHeaderNames().contains(" Markup By ");
		getAllHeaderNames().contains("Level");
		getAllHeaderNames().contains("Value");
		getAllHeaderNames().contains("Modified By");
		getAllHeaderNames().contains("Impersonated By");
		getAllHeaderNames().contains("Edit");
	}
	

	@Test(priority = 2)
	public void verifyProgramsInMarkupPage_31667() throws Exception {
		login.login(prop.getProperty("dealerAutomation"), prop.getProperty("password"));
		Assert.assertEquals(getPortalTitle().getText(), "Welcome to your AUL ADL Portal!");
		Thread.sleep(2000);
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
		Thread.sleep(2000);
		Assert.assertTrue(utils.getTitle("Manage My Pricing Preferences").isDisplayed());
		utils.getfield("span", "New markup").click();
		getDropDwnList().contains("United Auto Credit - UA3");
		getDropDwnList().contains("Used Vehicle - RNL");
		getDropDwnList().contains("First Reliance - Used Vehicle - FSL");
		getDropDwnList().contains("First Reliance-New Vehicle (SRD)");
		//DB validation
	}
	
	@Test(priority = 3)
	public void verifyPricingPreferencesPage_31668() throws Exception {
		login.login(prop.getProperty("dealerAutomation"), prop.getProperty("password"));
		Assert.assertEquals(getPortalTitle().getText(), "Welcome to your AUL ADL Portal!");
		Thread.sleep(2000);
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
		Thread.sleep(2000);
		Assert.assertTrue(utils.getTitle("Manage My Pricing Preferences").isDisplayed());
		utils.getfield("span", "New markup").click();
		Thread.sleep(3000);
		EmplPacks.getArrow().click();
		EmplPacks.selectProgram();
		Thread.sleep(10000);
//		String a = getMarkupTxts().get(0).getText();
//		System.out.println("txt isss-"+a);
//		Thread.sleep(3000);
		getBtnPercnt().get(1).click();
		Assert.assertTrue(getMarkupAmountPercentSign().getText().equals("%"),"% sign is shown if percent is selected");
		getBtnPercnt().get(0).click();
		Assert.assertTrue(getMarkupAmountDollarSign().getText().equals("attach_money"),"$ sign is shown if flat is selected");
		
	}
	
	@Test(priority = 4)
	public void verifyPricingPreferencesPage_31669() throws Exception {
		login.login(prop.getProperty("dealerAutomation"), prop.getProperty("password"));
		Assert.assertEquals(getPortalTitle().getText(), "Welcome to your AUL ADL Portal!");
		Thread.sleep(2000);
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Pricing Preferences");
		Thread.sleep(2000);
		Assert.assertTrue(utils.getTitle("Manage My Pricing Preferences").isDisplayed());
		utils.getfield("span", "New markup").click();
		Thread.sleep(3000);
		EmplPacks.getArrow().click();
		EmplPacks.selectProgram();
		Thread.sleep(10000);
		getRadioBtns().get(0).click();
	}
}

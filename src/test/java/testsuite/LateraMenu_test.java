package testsuite;

import java.util.ArrayList;

import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageActions.LateralMenuAction;
import pageActions.loginAction;
import pageActions.verticalMenuAction;
import utils.utilityClass;

public class LateraMenu_test extends LateralMenuAction {
	
	loginAction login = new loginAction();
	verticalMenuAction verticalMenu = new verticalMenuAction();
	utilityClass utils = new utilityClass();

	@BeforeMethod
	public void login() throws InterruptedException {
		navigate();
		Assert.assertEquals(login.getTitle(), "AUL Corp.");
	}

	@Test(priority = 1)
	public void verifyLateralMenuOptionsForAgent_6284() throws InterruptedException {
		login.login(prop.getProperty("agentusername"), prop.getProperty("agentpassword"));
		Assert.assertEquals(getTitle().getText(), "Welcome to your AUL ADL Portal!");
		String toolbox = getLateralMenuItems2().get(1).getText();
		ArrayList<String> list = new ArrayList<String>();
		for(int i=0; i<getLateralMenuItems1().size(); i++) {
			String[] menuItem = getLateralMenuItems1().get(i).getText().split("chevron_right");
			list.add(menuItem[i].trim());
			list.add(toolbox);
		}
		System.out.println(list);
			Assert.assertTrue(list.contains("E-Rate"));
			Assert.assertTrue(list.contains("Contracts"));
			Assert.assertTrue(list.contains("Reports"));
			Assert.assertTrue(list.contains("Dealer Settings"));
			Assert.assertTrue(list.contains("Agency Settings"));
			Assert.assertTrue(list.contains("Toolbox"));
			Assert.assertTrue(list.contains("Help"));
	}
	
	@Test(priority = 2)
	public void verifyERateOptionsAsAgent_6286() throws InterruptedException  {
		login.login(prop.getProperty("agentusername"), prop.getProperty("agentpassword"));
		Assert.assertEquals(getTitle().getText(), "Welcome to your AUL ADL Portal!");
		Assert.assertTrue(getLateralMenu().isDisplayed());
		verticalMenu.navigatetoLeftMainMenu("E-Rate");
		Assert.assertTrue(getLaterMenuSubItems().get(0).getText().contains("Rate/Contract"));
		Assert.assertTrue(getLaterMenuSubItems().get(1).getText().contains("Quote History"));
		verticalMenu.navigatetoLeftMenu("Rate/Contract");
		Thread.sleep(2000);
		Assert.assertTrue(getRateContractTitle().isDisplayed());
		verticalMenu.navigatetoLeftMenu("Quote History");
		Thread.sleep(2000);
		Assert.assertTrue(getQuoteHistoryTitle().isDisplayed());
	}

	@Test(priority = 3)
	public void verifyDashboardByDefaultForDealer_6287() throws InterruptedException  {
		login.login(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertEquals(getTitle().getText(), "Welcome to your AUL ADL Portal!");
		Assert.assertTrue(getLateralMenu().isDisplayed());
		Assert.assertEquals(getLateralMenuItems2().get(0).getText(),"Dashboard");
		String dashBoardHighlighter = getLateralMenuItems2().get(0).getCssValue("border-left-color");
		String dashBoardHighlighterColorInHexa=Color.fromString(dashBoardHighlighter).asHex();
		String expectedOrangeColorInHexa=prop.getProperty("darkOrangeInHexaForm");
		Assert.assertEquals(dashBoardHighlighterColorInHexa, expectedOrangeColorInHexa ,"Dashboard highlighted by default");
	}
	
	@Test(priority = 4)
	public void verifyMenuClosesByClickingSameOption_6329() throws InterruptedException  {
		login.login(prop.getProperty("agentusername"), prop.getProperty("agentpassword"));
		Assert.assertEquals(getTitle().getText(), "Welcome to your AUL ADL Portal!");
		Assert.assertTrue(getLateralMenu().isDisplayed());
		verticalMenu.navigatetoLeftMainMenu("E-Rate");
		Assert.assertEquals(getLaterMenuSubItems().size(), 2);
		Assert.assertTrue(getLaterMenuSubItems().get(0).getText().contains("Rate/Contract"));
		Assert.assertTrue(getLaterMenuSubItems().get(1).getText().contains("Quote History"));
		verticalMenu.navigatetoLeftMainMenu("E-Rate");
		Assert.assertEquals(getLaterMenuSubItems().size(),0);
	}

	@Test(priority = 5)
	public void verifyMenuClosesByClickingDiffOption_6330() throws InterruptedException  {
		login.login(prop.getProperty("agentusername"), prop.getProperty("agentpassword"));
		Assert.assertEquals(getTitle().getText(), "Welcome to your AUL ADL Portal!");
		Assert.assertTrue(getLateralMenu().isDisplayed());
		verticalMenu.navigatetoLeftMainMenu("E-Rate");
		Assert.assertEquals(getLaterMenuSubItems().size(), 2);
		Assert.assertTrue(getLaterMenuSubItems().get(0).getText().contains("Rate/Contract"));
		Assert.assertTrue(getLaterMenuSubItems().get(1).getText().contains("Quote History"));
		verticalMenu.navigatetoLeftMainMenu("Contracts");
		String[] eRateArrowAftr = getMenu("button", "E-Rate").getText().split("E-Rate");
		String eRateArrowTxtAftr = eRateArrowAftr[1].trim();
		Assert.assertEquals(eRateArrowTxtAftr,"chevron_right","Options are closed");
		Assert.assertEquals(getLaterMenuSubItems().size(), 1);
		Assert.assertTrue(getLaterMenuSubItems().get(0).getText().contains("Contract Search"));
	}
	
	@Test(priority = 6)
	public void verifyMenuOptionHighlightedWhenOpened_6332() throws InterruptedException  {
		login.login(prop.getProperty("agentusername"), prop.getProperty("agentpassword"));
		Assert.assertEquals(getTitle().getText(), "Welcome to your AUL ADL Portal!");
		 
		 String dashBoardHighlighter = getLateralMenuItems2().get(0).getCssValue("border-left-color");
		 String dashBoardHighlighterColorInHexa=Color.fromString(dashBoardHighlighter).asHex();
		 String expectedOrangeColorInHexa=prop.getProperty("darkOrangeInHexaForm");
		 Assert.assertEquals(dashBoardHighlighterColorInHexa, expectedOrangeColorInHexa ,"Dashboard highlighted by default");
		 
		 verticalMenu.navigatetoLeftMainMenu("E-Rate");
		 String color = getMenu("button", "E-Rate").getCssValue("background-color");
		 String eRateColorInHexa=Color.fromString(color).asHex();
		 String expectedColorInHexa=prop.getProperty("whiteColorInHexaForm");
		 Assert.assertEquals(eRateColorInHexa, expectedColorInHexa);
	}
	

	@Test(priority = 7)
	public void verifyMenuElements_6333() throws InterruptedException  {
		login.login(prop.getProperty("agentusername"), prop.getProperty("agentpassword"));
		Assert.assertEquals(getTitle().getText(), "Welcome to your AUL ADL Portal!");
		 String dashBoardHighlighter = getLateralMenuItems2().get(0).getCssValue("border-left-color");
		 String dashBoardHighlighterColorInHexa=Color.fromString(dashBoardHighlighter).asHex();
		 String expectedOrangeColorInHexa=prop.getProperty("darkOrangeInHexaForm");
		 Assert.assertEquals(dashBoardHighlighterColorInHexa, expectedOrangeColorInHexa ,"Dashboard highlighted by default");
		 Assert.assertTrue(getAULlogo().isDisplayed());
		 String toolbox = getLateralMenuItems2().get(1).getText();
			ArrayList<String> list = new ArrayList<String>();
			for(int i=0; i<getLateralMenuItems1().size(); i++) {
				String[] menuItem = getLateralMenuItems1().get(i).getText().split("chevron_right");
				list.add(menuItem[0].trim());
				list.add(toolbox);
			}
			System.out.println(list);
				Assert.assertTrue(list.contains("E-Rate"));
				Assert.assertTrue(list.contains("Contracts"));
				Assert.assertTrue(list.contains("Reports"));
				Assert.assertTrue(list.contains("Dealer Settings"));
				Assert.assertTrue(list.contains("Agency Settings"));
				Assert.assertTrue(list.contains("Toolbox"));
				Assert.assertTrue(list.contains("Help"));
		}
		
	@Test(priority = 8)
	public void verify3rdLevelMenu_6334() throws InterruptedException  {
		login.login(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertEquals(getTitle().getText(), "Welcome to your AUL ADL Portal!");
		String dashBoardHighlighter = getLateralMenuItems2().get(0).getCssValue("border-left-color");
		 String dashBoardHighlighterColorInHexa=Color.fromString(dashBoardHighlighter).asHex();
		 String expectedOrangeColorInHexa=prop.getProperty("darkOrangeInHexaForm");
		 Assert.assertEquals(dashBoardHighlighterColorInHexa, expectedOrangeColorInHexa ,"Dashboard highlighted by default");
		 verticalMenu.navigatetoLeftMainMenu("My Settings");
		 String[] mySettingsArrow = getMenu("button", "My Settings").getText().split("My Settings");
		 String mySettingsArrowTxt = mySettingsArrow[1].trim();
		 Assert.assertEquals(mySettingsArrowTxt,"expand_more","Options are opened");
		 utils.scrollDown();
		 getMenu("button","Preferences");
		 String[] preferencesArrow = getThirdSubMenuItems().get(0).getText().split("Preferences");
		 String preferencesArrowTxt = preferencesArrow[1].trim();
		 Assert.assertEquals(preferencesArrowTxt,"chevron_right","Options are closed by default");
	}
	
	@Test(priority = 9)
	public void verifyLateralMenuOptionsForDealer_6347() throws InterruptedException {
		login.login(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertEquals(getTitle().getText(), "Welcome to your AUL ADL Portal!");
		String toolbox = getLateralMenuItems2().get(1).getText();
		String dashboard = getLateralMenuItems2().get(0).getText();
		ArrayList<String> list = new ArrayList<String>();
		for(int i=0; i<getLateralMenuItems1().size(); i++) {
			String[] menuItem = getLateralMenuItems1().get(i).getText().split("chevron_right");
			list.add(menuItem[0].trim());
			list.add(toolbox);
			list.add(dashboard);
		}
		System.out.println(list);
		    Assert.assertTrue(list.contains("Dashboard"));
			Assert.assertTrue(list.contains("E-Rate"));
			Assert.assertTrue(list.contains("Contracts"));
			Assert.assertTrue(list.contains("Cancellations"));
			Assert.assertTrue(list.contains("Reports"));
			Assert.assertTrue(list.contains("My Settings"));
			Assert.assertTrue(list.contains("Toolbox"));
			Assert.assertTrue(list.contains("Help"));
	}
	
	@Test(priority = 10)
	public void verifyErateOptionsForDealer_6348() throws InterruptedException {
		login.login(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertEquals(getTitle().getText(), "Welcome to your AUL ADL Portal!");
		Assert.assertTrue(getLateralMenu().isDisplayed());
		verticalMenu.navigatetoLeftMainMenu("E-Rate");
		Assert.assertTrue(getLaterMenuSubItems().get(0).getText().contains("Rate/Contract"));
		Assert.assertTrue(getLaterMenuSubItems().get(1).getText().contains("Quote History"));
	}
	
	@Test(priority = 11)
	public void verifyErateOptionPagesForDealer_6349() throws InterruptedException {
		login.login(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertEquals(getTitle().getText(), "Welcome to your AUL ADL Portal!");
		Assert.assertTrue(getLateralMenu().isDisplayed());
		verticalMenu.navigatetoLeftMainMenu("E-Rate");
		Assert.assertTrue(getLaterMenuSubItems().get(0).getText().contains("Rate/Contract"));
		Assert.assertTrue(getLaterMenuSubItems().get(1).getText().contains("Quote History"));
		verticalMenu.navigatetoLeftMenu("Rate/Contract");
		Thread.sleep(2000);
		Assert.assertTrue(getRateContractTitle().isDisplayed());
		Assert.assertTrue(driver.getCurrentUrl().contains("/rate/rate-contract"));
		verticalMenu.navigatetoLeftMenu("Quote History");
		Thread.sleep(2000);
		Assert.assertTrue(getQuoteHistoryTitle().isDisplayed());
		Assert.assertTrue(driver.getCurrentUrl().contains("/rate/quote-history"));
	}
	
	@Test(priority = 12)
	public void verifyPrimaryLevelMenuCollapseByDoubleClickForDealer_6351() throws InterruptedException {
		login.login(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertEquals(getTitle().getText(), "Welcome to your AUL ADL Portal!");
		Assert.assertTrue(getLateralMenu().isDisplayed());
		verticalMenu.navigatetoLeftMainMenu("E-Rate");
		Assert.assertEquals(getLaterMenuSubItems().size(), 2);
		Assert.assertTrue(getLaterMenuSubItems().get(0).getText().contains("Rate/Contract"));
		Assert.assertTrue(getLaterMenuSubItems().get(1).getText().contains("Quote History"));
		verticalMenu.navigatetoLeftMainMenu("E-Rate");
		Assert.assertEquals(getLaterMenuSubItems().size(), 0);
	}
	
	@Test(priority = 13)
	public void verifyMenuClosesByClickingDiffOptionForDealer_6353() throws InterruptedException {
		login.login(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertEquals(getTitle().getText(), "Welcome to your AUL ADL Portal!");
		Assert.assertTrue(getLateralMenu().isDisplayed());
		verticalMenu.navigatetoLeftMainMenu("E-Rate");
		String[] eRateArrowBefore = getMenu("button", "E-Rate").getText().split("E-Rate");
		String eRateArrowTxtBefore = eRateArrowBefore[1].trim();
		Assert.assertEquals(eRateArrowTxtBefore,"expand_more","Options are opened");
		Assert.assertEquals(getLaterMenuSubItems().size(), 2);
		Assert.assertTrue(getLaterMenuSubItems().get(0).getText().contains("Rate/Contract"));
		Assert.assertTrue(getLaterMenuSubItems().get(1).getText().contains("Quote History"));
		verticalMenu.navigatetoLeftMainMenu("Contracts");
		String[] eRateArrowAftr = getMenu("button", "E-Rate").getText().split("E-Rate");
		String eRateArrowTxtAftr = eRateArrowAftr[1].trim();
		Assert.assertEquals(eRateArrowTxtAftr,"chevron_right","Options are closed");
		Assert.assertEquals(getLaterMenuSubItems().size(), 6);
	}
	
	@Test(priority = 14)
	public void verifyMenuEelementsAsDealer_6354() throws InterruptedException {
		login.login(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertEquals(getTitle().getText(), "Welcome to your AUL ADL Portal!");
		 String dashBoardHighlighter = getLateralMenuItems2().get(0).getCssValue("border-left-color");
		 String dashBoardHighlighterColorInHexa=Color.fromString(dashBoardHighlighter).asHex();
		 String expectedOrangeColorInHexa=prop.getProperty("darkOrangeInHexaForm");
		 Assert.assertEquals(dashBoardHighlighterColorInHexa, expectedOrangeColorInHexa ,"Dashboard highlighted by default");
		 Assert.assertTrue(getAULlogo().isDisplayed());
		 Assert.assertTrue(getLateralMenu().isDisplayed());
		}
	
	@Test(priority = 15)
	public void verifyPrimaryMenuHighlightedWhenClickedForDealer_6355() throws InterruptedException {
		login.login(prop.getProperty("agentusername"), prop.getProperty("agentpassword"));
		Assert.assertEquals(getTitle().getText(), "Welcome to your AUL ADL Portal!");
		 verticalMenu.navigatetoLeftMainMenu("E-Rate");
		 String color = getMenu("button", "E-Rate").getCssValue("background-color");
		 String eRateColorInHexa=Color.fromString(color).asHex();
		 String expectedColorInHexa=prop.getProperty("whiteColorInHexaForm");
		 Assert.assertEquals(eRateColorInHexa, expectedColorInHexa);
	}
	
	@Test(priority = 16)
	public void verify3rdLevelOptionClosedForDealer_6356() throws InterruptedException {
		login.login(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertEquals(getTitle().getText(), "Welcome to your AUL ADL Portal!");
		 verticalMenu.navigatetoLeftMainMenu("Contracts");
		 String[] contractsArrow = getMenu("button", "Contracts").getText().split("Contracts");
		 String contractsArrowTxt = contractsArrow[1].trim();
		 Assert.assertEquals(contractsArrowTxt,"expand_more","Options are opened");
		 Assert.assertTrue(getLaterMenuSubItems().get(0).getText().contains("Contract Search"));
		 Assert.assertTrue(getLaterMenuSubItems().get(2).getText().contains("Remit AUL"));
		 String contractSearchTxt = getMenu("a", "Contract Search").getText();
		 Assert.assertFalse(contractSearchTxt.contains("chevron_right"),"options are closed by default");
		 String remitAULTxt = getMenu("a", "Remit AUL").getText();
		 Assert.assertFalse(remitAULTxt.contains("chevron_right"),"options are closed by default");
	}
	
	@Test(priority = 17)
	public void verifyMenuOptionClosedByDefaultForDealer_6357() throws InterruptedException {
		login.login(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertEquals(getTitle().getText(), "Welcome to your AUL ADL Portal!");
		 String dashBoardHighlighter = getLateralMenuItems2().get(0).getCssValue("border-left-color");
		 String dashBoardHighlighterColorInHexa=Color.fromString(dashBoardHighlighter).asHex();
		 String expectedOrangeColorInHexa=prop.getProperty("darkOrangeInHexaForm");
		 Assert.assertEquals(dashBoardHighlighterColorInHexa, expectedOrangeColorInHexa ,"Dashboard highlighted by default");
		 String[] eRateArrow = getMenu("button", "E-Rate").getText().split("E-Rate");
		 String eRateArrowTxt = eRateArrow[1].trim();
		 Assert.assertEquals(eRateArrowTxt,"chevron_right","Options are closed and not expanded");
		 String[] contractsArrw = getMenu("button", "Contracts").getText().split("Contracts");
		 String contractsArrwTxt = contractsArrw[1].trim();
		 Assert.assertEquals(contractsArrwTxt,"chevron_right","Options are closed and not expanded");
		 String[] cancellationsArrw = getMenu("button", "Cancellations").getText().split("Cancellations");
		 String cancellationsArrwTxt = cancellationsArrw[1].trim();
		 Assert.assertEquals(cancellationsArrwTxt,"chevron_right","Options are closed and not expanded");
		 String[] reportsArrw = getMenu("button", "Reports").getText().split("Reports");
		 String reportsArrwTxt = reportsArrw[1].trim();
		 Assert.assertEquals(reportsArrwTxt,"chevron_right","Options are closed and not expanded");
		 String[] mySettingsArrw = getMenu("button", "My Settings").getText().split("My Settings");
		 String mySettingsArrwTxt = mySettingsArrw[1].trim();
		 Assert.assertEquals(mySettingsArrwTxt,"chevron_right","Options are closed and not expanded");
		 String toolbox = getMenu("a", "Toolbox").getText();
		 Assert.assertFalse(toolbox.contains("chevron_right"),"options are closed by default");
		 String[] helpArrw = getMenu("button", "Help").getText().split("Help");
		 String helpArrwTxt = helpArrw[1].trim();
		 Assert.assertEquals(helpArrwTxt,"chevron_right","Options are closed and not expanded");
	}
		 
	@Test(priority = 18)
	public void verifyCencellationOptionsForDealer_6362() throws InterruptedException {
		login.login(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertEquals(getTitle().getText(), "Welcome to your AUL ADL Portal!");
		Assert.assertTrue(getLateralMenu().isDisplayed());
		verticalMenu.navigatetoLeftMainMenu("Cancellations");
		Assert.assertTrue(getLaterMenuSubItems().get(0).getText().contains("Cancellation Quote"));
		Assert.assertTrue(getLaterMenuSubItems().get(1).getText().contains("Cancellation History"));
	}
	
	@Test(priority = 19)
	public void verifyCencellationOptionPagesForDealer_6363() throws InterruptedException {
		login.login(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertEquals(getTitle().getText(), "Welcome to your AUL ADL Portal!");
		Assert.assertTrue(getLateralMenu().isDisplayed());
		verticalMenu.navigatetoLeftMainMenu("Cancellations");
		Assert.assertTrue(getLaterMenuSubItems().get(0).getText().contains("Cancellation Quote"));
		Assert.assertTrue(getLaterMenuSubItems().get(1).getText().contains("Cancellation History"));
		verticalMenu.navigatetoLeftMenu("Cancellation Quote");
		Thread.sleep(2000);
		Assert.assertTrue(getCancellationQuoteTitle().isDisplayed());
		Assert.assertTrue(driver.getCurrentUrl().contains("/cancellations/cancel-quote"));
		verticalMenu.navigatetoLeftMenu("Cancellation History");
		Thread.sleep(2000);
		Assert.assertTrue(getCancellationHistoryTitle().isDisplayed());
		Assert.assertTrue(driver.getCurrentUrl().contains("/cancellations/cancellation-history"));
	}
	
	@Test(priority = 20)
	public void verifDashboardHighlightedForLender_6375() throws InterruptedException {
		login.login(prop.getProperty("lenderusername"), prop.getProperty("lenderpassword"));
		Assert.assertEquals(getTitle().getText(), "Welcome to your AUL ADL Portal!");
		Assert.assertEquals(getLateralMenuItems2().get(0).getText(),"Dashboard");
		String dashBoardHighlighter = getLateralMenuItems2().get(0).getCssValue("border-left-color");
		String dashBoardHighlighterColorInHexa=Color.fromString(dashBoardHighlighter).asHex();
		String expectedOrangeColorInHexa=prop.getProperty("darkOrangeInHexaForm");
		Assert.assertEquals(dashBoardHighlighterColorInHexa, expectedOrangeColorInHexa ,"Dashboard highlighted by default");
	}
	

	@Test(priority = 21)
	public void verifDashboardHighlightedForLender_6375() throws InterruptedException {
		login.login(prop.getProperty("lenderusername"), prop.getProperty("lenderpassword"));
		Assert.assertEquals(getTitle().getText(), "Welcome to your AUL ADL Portal!");
	
	@AfterMethod
	public void close() throws InterruptedException {
		login.logout();
	}
}
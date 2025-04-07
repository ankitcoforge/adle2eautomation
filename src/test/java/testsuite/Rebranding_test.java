package testsuite;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageActions.ContractSearchPageAction;
import pageActions.RemitAULAction;
import pageActions.WebMileageExceptionAction;
import pageActions.bannnerAction;
import pageActions.impersonateAction;
import pageActions.loginAction;
import pageActions.verticalMenuAction;
import utils.utilityClass;

/* PBI 32606 */
public class Rebranding_test extends loginAction {

	utilityClass utils = new utilityClass();
	loginAction login = new loginAction();
	verticalMenuAction verticalMenu = new verticalMenuAction();
	impersonateAction impersonate = new impersonateAction ();
	bannnerAction dashboard = new bannnerAction();
	ContractSearchPageAction contractSearchPage=new ContractSearchPageAction();
	RemitAULAction remitAULAction= new RemitAULAction();
	WebMileageExceptionAction wme = new WebMileageExceptionAction();
	
	@BeforeClass(alwaysRun = true)
	public void login() throws InterruptedException {
		navigate();
		Assert.assertEquals(login.getTitle(), "Protective");
	}

	@Test(priority = 1)
	public void verifyLoginPageColorAndTxtValidations() throws InterruptedException {
		Assert.assertTrue(getProtectiveLogo().getAttribute("src").contains("img/Protective-logo"));
//		utils.validateColor(getProtectiveLogo(), "color", "darkblueInHexaForm");
		utils.validateColor(utils.element("cssselector", UN), "color", "blackColorInHexaForm2");
		Assert.assertTrue(getProtectiveLoginPageTxt().getText().contains("AUL is a part of"));
		utils.validateColor(getProtectiveLoginPageTxt(), "color", "indigoBlueInHexaForm");
		Assert.assertTrue(getProtectiveLoginPageTxt().getText().contains("Protective Asset Protection"));
//		Assert.assertTrue(getProtectiveLoginPageTxt2().getText().contains(
//				"For 60 years, Protective Asset Protection has provided F&I solutions to automotive, marine, powersports and recreational vehicle dealers throughout the U.S."));
		Assert.assertTrue(getAgreeProtectivePrivacyPolicyTxt().getText()
				.contains("By clicking \"Login\", you agree to Protective's Privacy Policy"));
		getPrivacyPolicyLink().click();
//		utils.wait(5000);
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		Assert.assertTrue(getProtectiveLogoInPrivacyPolicyPage().getAttribute("alt").equals("Protective Life Logo"));
		driver.switchTo().window(tabs.get(0));
		utils.element("cssselector", UN).sendKeys(prop.getProperty("dealerAutomation"));
		utils.scrollDownUsingJSE(500);
		utils.element("cssselector", loginBtn).click();
		utils.getfield("a", "Forgot your password?").click();
		utils.validateColor(getProtectiveLogo(), "color", "indigoBlueInHexaForm");
		System.out.println("txt---" + getProtectiveLogoInForgotPasswordPage().getAttribute("src"));
		Assert.assertTrue(getProtectiveLogoInForgotPasswordPage().getAttribute("src").contains("Protective-logo"));
		//added the below steps to perorm logout option in after method
		driver.navigate().back();
		utils.element("cssselector", PW).sendKeys(prop.getProperty("password"));
		utils.element("cssselector", loginBtn).click();
		utils.element("cssselector", UN).sendKeys(prop.getProperty("dealerAutomation"));
		utils.element("cssselector", loginBtn).click();
		utils.wait(5000);
	}
	
	@Test(priority = 2)
	public void verifyMenuBarColorFontDashboardWarningBannerAndDeleteHighlightColorAndTextColor_38672_38673_38670_38671() throws InterruptedException {
		login.login(prop.getProperty("dealerAutomation"), prop.getProperty("password"));
		//doubt
//		utils.validateColor(getProtectiveLogoinLandingPage(), "color", "");
		Assert.assertTrue(getProtectiveLogoinLandingPage().getCssValue("font-family").contains("calibri"));
		utils.validateColor(getMenuBarInLandingPage(), "background-color", "indigoBlueInHexaForm");
		//warning banner
		utils.validateColor(dashboard.getAdlBannner(), "background-color", "lightBlueColorInHexaForm");
		utils.validateColor(utils.getfield("b", "ADL Portal"), "color" ,"blackColorInHexaForm2");
		
		verticalMenu.navigatetoLeftMainMenu("Contracts");
		Assert.assertTrue(utils.getfield("button", "Contracts").getCssValue("font-family").contains("calibri"));
		utils.validateColor(utils.getfield("button", "Contracts"), "background-color", "whiteColorInHexaForm");
	    //delete highlight
		verticalMenu.navigatetoLeftMenu("Contract Search");
		contractSearchPage.selectTimeFrameDropdown("Previous 4 Years");
		contractSearchPage.selectStatusCheckBoxInGrid(1).click();
		utils.wait(1000);
		utils.validateColor(contractSearchPage.getDeleteHightlight(), "background-color", "lightBlueColorInHexaForm2");
		utils.validateColor(contractSearchPage.getDeleteHightlight(), "color", "blackColorInHexaForm2");
	}
	
	@Test(priority = 3)
	public void verifyTitleCaseInImpersonatePage_38675_38690() throws InterruptedException {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		Assert.assertTrue(utils.getfield("b", "Protective Asset Protection").isDisplayed());
		verticalMenu.navigatetoimpersonate();
		impersonate.getUsers("Agent", "393");
		String newUser=utils.getfield("span", " + New User ").getText();
		String[] newStrng = newUser.split(" ");
		for(int j=1;j<newStrng.length;j++) {
		String txt = newStrng[j];
		char startingLetter = txt.charAt(0);
		System.out.println("Uppercase-"+startingLetter);
		Assert.assertTrue(Character.isUpperCase(startingLetter));
		for (int i = 1; i < txt.toCharArray().length; i++) {
			char nxtLetters = txt.charAt(i);
			System.out.println("Lowercase-"+nxtLetters);
			Assert.assertTrue(Character.isLowerCase(nxtLetters));
		}
		}
	}
	
	@Test(priority = 4)
	public void verifyTitleCaseInNewUserRegistrationPage_38690() throws InterruptedException {
		login.login(prop.getProperty("dealerAutomation"), prop.getProperty("password"));
		verticalMenu.navigatetoLeftMenu("My Settings", "Issue New User Registration");
		String newUser=utils.getfield("span", " + New User ").getText();
		String[] newStrng = newUser.split(" ");
		for(int j=1;j<newStrng.length;j++) {
		String txt = newStrng[j];
		char startingLetter = txt.charAt(0);
		System.out.println("Uppercase-"+startingLetter);
		Assert.assertTrue(Character.isUpperCase(startingLetter));
		for (int i = 1; i < txt.toCharArray().length; i++) {
			char nxtLetters = txt.charAt(i);
			System.out.println("Lowercase-"+nxtLetters);
			Assert.assertTrue(Character.isLowerCase(nxtLetters));
		}
		}
	}
	
	@Test(priority = 5)
	public void verifyTitleCaseForExportPDFandExportXlsAndPhoneNoInDashboard_38690_38691() throws InterruptedException {
		login.login(prop.getProperty("dealerAutomation"), prop.getProperty("password"));
//		Assert.assertTrue(utils.element("xpath", phnNoInLandingPage).getText().contains("-"));
		verticalMenu.navigatetoLeftMenu("Contracts", "Remit Contracts to Protective");
		String exportPdf=utils.getfield("button", "Export PDF").getText();
		String[] exportPdfNew = exportPdf.split(" ");
		String txt = exportPdfNew[0];
		char startingLetter = txt.charAt(0);
		System.out.println("Uppercase-"+startingLetter);
		Assert.assertTrue(Character.isUpperCase(startingLetter));
		for (int i = 1; i <txt.toCharArray().length;i++) {
			char nxtLetters = txt.charAt(i)	;
			System.out.println("Lowercase-"+nxtLetters);
			Assert.assertTrue(Character.isLowerCase(nxtLetters));
		}
		//PDF Capital letter validation
		String PDFtxt= exportPdfNew[1];
		for(int i=0;i<PDFtxt.toCharArray().length;i++) {
		char AllLetters=PDFtxt.charAt(i);
		System.out.println("Uppercase-"+AllLetters);
			Assert.assertTrue(Character.isUpperCase(AllLetters));
		}
		
		
		String exportXls=utils.getfield("button", "Export XLS").getText();
		String[] exportXlsNew = exportXls.split(" ");
		String txtExportXls = exportXlsNew[0];
		char startingLetterexportXls = txtExportXls.charAt(0);
		System.out.println("Uppercase-"+startingLetterexportXls);
		Assert.assertTrue(Character.isUpperCase(startingLetterexportXls));
		for (int i = 1; i < txtExportXls.toCharArray().length; i++) {
			char nxtLetters = txtExportXls.charAt(i);
			System.out.println("Lowercase-"+nxtLetters);
			Assert.assertTrue(Character.isLowerCase(nxtLetters));
		}
		
		//XLX Capital letter validation
				String XLXtxt= exportXlsNew[1];
				for(int i=0;i<XLXtxt.toCharArray().length;i++) {
				char AllLetters=XLXtxt.charAt(i);
				System.out.println("Uppercase-"+AllLetters);
					Assert.assertTrue(Character.isUpperCase(AllLetters));
				}
	}
		@Test(priority = 6)
		public void verifyAllLinksAreInIndigoBlueAndTextIsTurnedToBlack_38693_38692() throws InterruptedException {
			login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
			verticalMenu.navigatetoimpersonate();
			impersonate.getUsers("Agent", "393");
			impersonate.selectStatusAsCompleted();
			HashMap<Integer, HashMap<String, WebElement>> editDelLock = impersonate.EditDelLockLinkForColorValidation();
		for(int i=1;i<impersonate.getRows().size()-1;i++) {
			WebElement editLink = editDelLock.get(i+1).get("Edit");
			WebElement deleteLink = editDelLock.get(i+1).get("Delete");
			WebElement lockedOutLink = editDelLock.get(i+1).get("Locked Out");
			WebElement impersonateLink = editDelLock.get(i+1).get("Impersonate");
		utils.validateColor(editLink, "color", "indigoBlueInHexaForm");
		utils.validateColor(deleteLink, "color", "indigoBlueInHexaForm");
		utils.validateColor(lockedOutLink, "color", "indigoBlueInHexaForm");
		utils.validateColor(impersonateLink, "color", "indigoBlueInHexaForm");
		}
		//black headers validation
		for(int i=1;i<impersonate.getAllHeadersAsElements().size();i++) {
		 WebElement headers = impersonate.getAllHeadersAsElements().get(i);
		 utils.validateColor(headers, "color", "blackColorInHexaForm2");
		}
		}

@Test(priority = 7)
public void verifySpacesForBeforeAndAftrSlash_38694() throws InterruptedException {
	login.login(prop.getProperty("agentAutomation"), prop.getProperty("password"));
	verticalMenu.navigatetoLeftMenu("Dealer Settings", "Manage Dealers");
	Assert.assertTrue(utils.getfield("label", "Role ID / Account Name").getText().contains(" / "));
}

@Test(priority = 8)
public void verifyCancelLinkInContractSearchPage_38676() throws InterruptedException {
	login.login(prop.getProperty("dealerAutomation"), prop.getProperty("password"));
	verticalMenu.navigatetoLeftMenu("Contracts", "Contract Search");
	contractSearchPage.selectTimeFrameDropdown("Previous 4 Years");
	utils.scrollDownUsingJSE(150);
	contractSearchPage.filterStatus("Active");
	utils.scrollDownUsingJSE(300);
	utils.validateColor(contractSearchPage.getCancelLink().get(1), "color", "indigoBlueInHexaForm");
}

@Test(priority = 9)
public void verifyRemitContractsMdgBoxPaymentDetailsBlurbTxt_38677_38678() throws InterruptedException {
	login.login(prop.getProperty("dealerAutomation"), prop.getProperty("password"));
	verticalMenu.navigatetoLeftMenu("Contracts", "Remit Contracts to Protective");
	utils.validateColor(remitAULAction.getMsgBox(), "background-color", "goldColorInHexaForm");
	login.logout();
	login.login(prop.getProperty("dealerForPaymentDetails"), prop.getProperty("password"));
	verticalMenu.navigatetoLeftMenu("Contracts", "Remit Contracts to Protective");
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].click();", remitAULAction.getSelectStatusCheckBoxInGrid(1));
	remitAULAction.getPaymentDetailsTab().click();
	Thread.sleep(1000);
	//doubt below
	Assert.assertTrue(remitAULAction.getPaymentDetailsChkBxTxt().getText().contains("I am a duly authorized signer on the financial institution account on the ACH Agreement, and authorize all of the above as evidenced by my signature below."));
}

@Test(priority = 10)
public void verifyGapCoverageMsg_38680() throws InterruptedException, ParseException {
	login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
	verticalMenu.navigatetoimpersonate();
	impersonate.impersonateUser("Dealer", "79990");
	verticalMenu.navigatetoLeftMenu("E-Rate"," Rate / Contract ");
	wme.getProducts("5FNRL6H27NB019645", "100");
	utils.scrollDownUsingJSE();
	Assert.assertTrue(utils.getfield("h3", "You are not currently signed up with a Protective GAP Program").isDisplayed());
}

//all toast msgs validated in Emppacks page 

@AfterMethod(alwaysRun = true)
public void close() throws InterruptedException {
	try {
		login.logout();
	} catch (Exception e) {
		login.logout();
	}
}

}
	
	



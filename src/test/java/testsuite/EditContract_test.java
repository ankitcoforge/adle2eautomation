package testsuite;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageActions.ContractSearchPageAction;
import pageActions.EditContractAction;
import pageActions.loginAction;
import pageActions.singleContractAction;
import pageActions.verticalMenuAction;
import utils.utilityClass;

public class EditContract_test extends EditContractAction {
	
	loginAction login = new loginAction();
	verticalMenuAction verticalMenu = new verticalMenuAction();
	utilityClass utils = new utilityClass();
	ContractSearchPageAction contractSearchPage=new ContractSearchPageAction();
	singleContractAction singleContract=new singleContractAction();
	
	@BeforeMethod
	public void login() throws InterruptedException {
		navigate();
		Assert.assertEquals(login.getTitle(), "AUL Corp.");
	}

	@Test(priority = 1)
	public void verifyEditContractTitlePage_11620() throws InterruptedException {
		login.login(prop.getProperty("username11"), prop.getProperty("password"));
		Assert.assertEquals(getTitle().getText(), "Welcome to your AUL ADL Portal!");
	    verticalMenu.navigatetoLeftMenu("Contracts", "Contract Search");
	    Thread.sleep(1000);
	    Assert.assertTrue((getContractSearchPagetitle()).isDisplayed());
	    utils.scrollDown();
	    HashMap<Integer, HashMap<String, String>> allTableData = contractSearchPage.checkGridBodyDetails();
	    contractSearchPage.getSelectStatus().click();
	    contractSearchPage.getEnteredStatusChkbox().click();
	    String contractNumber = allTableData.get(1).get("Contract");
		utils.scrollDown();
	    contractSearchPage.getSearchBoxesInGrid().get("Contract").sendKeys(contractNumber);
	    Thread.sleep(1000);
	    HashMap<Integer, HashMap<String, String>> allTableData2 = contractSearchPage.checkGridBodyDetails();
		String contractNumber2 = allTableData2.get(1).get("Contract");
	    if(contractNumber.equals(contractNumber2)) {
	    contractSearchPage.selectStatusCheckBoxInGrid(1).click();
	    contractSearchPage.getEditLink(1).click();
	    }
	    Assert.assertTrue(getEditContractPagetitle().isDisplayed());
	}
	
	@Test(priority = 2)
	public void verifyElementsInEditContractPage_11621() throws InterruptedException {
		login.login(prop.getProperty("username11"), prop.getProperty("password"));
		Assert.assertEquals(getTitle().getText(), "Welcome to your AUL ADL Portal!");
	    verticalMenu.navigatetoLeftMenu("Contracts", "Contract Search");
	    Thread.sleep(1000);
	    Assert.assertTrue((getContractSearchPagetitle()).isDisplayed());
	    utils.scrollDown();
	    HashMap<Integer, HashMap<String, String>> allTableData = contractSearchPage.checkGridBodyDetails();
	    contractSearchPage.getSelectStatus().click();
	    contractSearchPage.getEnteredStatusChkbox().click();
	    String contractNumber = allTableData.get(1).get("Contract");
		utils.scrollDown();
	    contractSearchPage.getSearchBoxesInGrid().get("Contract").sendKeys(contractNumber);
	    Thread.sleep(1000);
	    HashMap<Integer, HashMap<String, String>> allTableData2 = contractSearchPage.checkGridBodyDetails();
		String contractNumber2 = allTableData2.get(1).get("Contract");
	    if(contractNumber.equals(contractNumber2)) {
	    contractSearchPage.selectStatusCheckBoxInGrid(1).click();
	    contractSearchPage.getEditLink(1).click();
	    }
	    Assert.assertTrue(getEditContractPagetitle().isDisplayed());
	    Assert.assertTrue(getLienholderTxtField().getAttribute("type").equals("text"));
	    Assert.assertTrue(getContarctInfoTxtFields1().get(0).getAttribute("maxlength").equals("16"),"Dealer No Field is verified");
	    Assert.assertTrue(getContarctInfoTxtFields1().get(1).getAttribute("type").equals("text"),"vehicle purchase Field is verified");
	    Assert.assertTrue(getContarctInfoTxtFields2().get(1).getAttribute("type").equals("text"),"Contract Retail Price Field is verified");
	    Assert.assertTrue(getCoustomerInfoFields().get(0).getAttribute("maxlength").equals("40"),"First Name Field is verified");
	    Assert.assertTrue(getCoustomerInfoFields().get(1).getAttribute("maxlength").equals("40"),"Last Name Field is verified");
	    Assert.assertTrue(getCoustomerInfoFields().get(2).getAttribute("maxlength").equals("50"),"Address Field is verified");
	    Assert.assertTrue(getCoustomerInfoFields().get(3).getAttribute("type").equals("text"),"Zip code Field is verified");
	    Assert.assertTrue(getCoustomerInfoFields().get(4).getAttribute("maxlength").equals("30"),"City Field is verified");
	    Assert.assertTrue(getCoustomerInfoFields().get(5).getAttribute("maxlength").equals("32"),"Email Field is verified");
	    Assert.assertTrue(getCoustomerInfoFields().get(6).getAttribute("maxlength").equals("15"),"Phone Number Field is verified");
	    JavascriptExecutor jse = (JavascriptExecutor)driver;
	    jse.executeScript("arguments[0].scrollIntoView()", getCobuyerChkbox()); 
	    getCoBuyerChkboxField().click();
	    Assert.assertTrue(getCoustomerInfoFields().get(7).getAttribute("maxlength").equals("40"),"Co-Buyer First Name Field is verified");
	    Assert.assertTrue(getCoustomerInfoFields().get(8).getAttribute("maxlength").equals("40"),"Co-Buyer Last Name Field is verified");
	    Assert.assertTrue(getCoustomerInfoFields().get(9).getAttribute("maxlength").equals("50"),"Co-Buyer Address Field is verified");
	    Assert.assertTrue(getCoustomerInfoFields().get(10).getAttribute("type").equals("text"),"Co-Buyer Zip code Field is verified");
	    Assert.assertTrue(getCoustomerInfoFields().get(11).getAttribute("maxlength").equals("30"),"Co-Buyer City Field is verified");
	    Assert.assertTrue(getCoustomerInfoFields().get(12).getAttribute("maxlength").equals("32"),"Co-Buyer Email Field is verified");
	    Assert.assertTrue(getCoustomerInfoFields().get(13).getAttribute("maxlength").equals("15"),"Co-Buyer Phone Number Field is verified");
	}
	
	
	@Test(priority = 3)
	public void verifyURLInEditContractPage_11622() throws InterruptedException {
		login.login(prop.getProperty("username1"), prop.getProperty("password"));
		Assert.assertEquals(getTitle().getText(), "Welcome to your AUL ADL Portal!");
	    verticalMenu.navigatetoLeftMenu("Contracts", "Contract Search");
	    Thread.sleep(1000);
	    Assert.assertTrue((getContractSearchPagetitle()).isDisplayed());
	    utils.scrollDown();
	    HashMap<Integer, HashMap<String, String>> allTableData = contractSearchPage.checkGridBodyDetails();
	    contractSearchPage.getSelectStatus().click();
	    contractSearchPage.getEnteredStatusChkbox().click();
	    String contractNumber = allTableData.get(1).get("Contract");
		utils.scrollDown();
	    contractSearchPage.getSearchBoxesInGrid().get("Contract").sendKeys(contractNumber);
	    Thread.sleep(1000);
	    HashMap<Integer, HashMap<String, String>> allTableData2 = contractSearchPage.checkGridBodyDetails();
		String contractNumber2 = allTableData2.get(1).get("Contract");
	    if(contractNumber.equals(contractNumber2)) {
	    contractSearchPage.selectStatusCheckBoxInGrid(1).click();
	    contractSearchPage.getEditLink(1).click();
	    }
	    Assert.assertTrue(getEditContractPagetitle().isDisplayed());
	    Assert.assertTrue(driver.getCurrentUrl().contains("https://qa.adl.aulcorp.com/portal/contracts/edit-contract"));
	}
	
	@Test(priority = 4)
	public void verifyNavigationUsingKeyboard_11625() throws InterruptedException {
		login.login(prop.getProperty("username1"), prop.getProperty("password"));
		Assert.assertEquals(getTitle().getText(), "Welcome to your AUL ADL Portal!");
	    verticalMenu.navigatetoLeftMenu("Contracts", "Contract Search");
	    Thread.sleep(1000);
	    Assert.assertTrue((getContractSearchPagetitle()).isDisplayed());
	    utils.scrollDown();
	    HashMap<Integer, HashMap<String, String>> allTableData = contractSearchPage.checkGridBodyDetails();
	    contractSearchPage.getSelectStatus().click();
	    contractSearchPage.getEnteredStatusChkbox().click();
	    String contractNumber = allTableData.get(1).get("Contract");
		utils.scrollDown();
	    contractSearchPage.getSearchBoxesInGrid().get("Contract").sendKeys(contractNumber);
	    Thread.sleep(1000);
	    HashMap<Integer, HashMap<String, String>> allTableData2 = contractSearchPage.checkGridBodyDetails();
		String contractNumber2 = allTableData2.get(1).get("Contract");
	    if(contractNumber.equals(contractNumber2)) {
	    contractSearchPage.selectStatusCheckBoxInGrid(1).click();
	    contractSearchPage.getEditLink(1).click();
	    }
	    Assert.assertTrue(getEditContractPagetitle().isDisplayed());
	    getCoustomerInfoFields().get(0).sendKeys(Keys.TAB);
	    String expectedBlueColorInHexaLastName = prop.getProperty("blueColorInHexaForm");
		String borderColorOfElementLastName = coustomerInfoHighlighter().get(1).getCssValue("border-color");
		String ActualcolorInHexaformatLastName = Color.fromString(borderColorOfElementLastName).asHex();
		Assert.assertEquals(ActualcolorInHexaformatLastName, expectedBlueColorInHexaLastName);
		
		getCoustomerInfoFields().get(1).sendKeys(Keys.TAB);
	    String expectedBlueColorAddress = prop.getProperty("blueColorInHexaForm");
		String borderColorOfElementAddress = coustomerInfoHighlighter().get(2).getCssValue("border-color");
		String ActualcolorInHexaformatAddress = Color.fromString(borderColorOfElementAddress).asHex();
		Assert.assertEquals(ActualcolorInHexaformatAddress, expectedBlueColorAddress);
		
		getCoustomerInfoFields().get(2).sendKeys(Keys.SHIFT,Keys.TAB);
		Assert.assertEquals(ActualcolorInHexaformatLastName, expectedBlueColorInHexaLastName);
		
		getCoustomerInfoFields().get(1).sendKeys(Keys.SHIFT,Keys.TAB);
	    String expectedBlueColorFirstName = prop.getProperty("blueColorInHexaForm");
		String borderColorOfElementFirstName = coustomerInfoHighlighter().get(0).getCssValue("border-color");
		String ActualcolorInHexaformatFirstName = Color.fromString(borderColorOfElementFirstName).asHex();
		Assert.assertEquals(ActualcolorInHexaformatFirstName, expectedBlueColorFirstName);
	}
	

	
	@Test(priority = 5)
	public void verifyEnabledCloseBtnInEditContractPage_11626() throws InterruptedException {
		login.login(prop.getProperty("username1"), prop.getProperty("password"));
		Assert.assertEquals(getTitle().getText(), "Welcome to your AUL ADL Portal!");
	    verticalMenu.navigatetoLeftMenu("Contracts", "Contract Search");
	    Thread.sleep(1000);
	    Assert.assertTrue((getContractSearchPagetitle()).isDisplayed());
	    utils.scrollDown();
	    HashMap<Integer, HashMap<String, String>> allTableData = contractSearchPage.checkGridBodyDetails();
	    contractSearchPage.getSelectStatus().click();
	    contractSearchPage.getEnteredStatusChkbox().click();
	    String contractNumber = allTableData.get(1).get("Contract");
		utils.scrollDown();
	    contractSearchPage.getSearchBoxesInGrid().get("Contract").sendKeys(contractNumber);
	    Thread.sleep(1000);
	    HashMap<Integer, HashMap<String, String>> allTableData2 = contractSearchPage.checkGridBodyDetails();
		String contractNumber2 = allTableData2.get(1).get("Contract");
	    if(contractNumber.equals(contractNumber2)) {
	    contractSearchPage.selectStatusCheckBoxInGrid(1).click();
	    contractSearchPage.getEditLink(1).click();
	    }
	    Assert.assertTrue(getEditContractPagetitle().isDisplayed());
	    Assert.assertTrue(getBtnCancel().isEnabled());
	}
	
	@Test(priority = 6)
	public void verifyEnabledSaveBtnInEditContractPage_11627() throws InterruptedException {
		login.login(prop.getProperty("username1"), prop.getProperty("password"));
		Assert.assertEquals(getTitle().getText(), "Welcome to your AUL ADL Portal!");
	    verticalMenu.navigatetoLeftMenu("Contracts", "Contract Search");
	    Thread.sleep(1000);
	    Assert.assertTrue((getContractSearchPagetitle()).isDisplayed());
	    utils.scrollDown();
	    HashMap<Integer, HashMap<String, String>> allTableData = contractSearchPage.checkGridBodyDetails();
	    contractSearchPage.getSelectStatus().click();
	    contractSearchPage.getEnteredStatusChkbox().click();
	    String contractNumber = allTableData.get(1).get("Contract");
		utils.scrollDown();
	    contractSearchPage.getSearchBoxesInGrid().get("Contract").sendKeys(contractNumber);
	    Thread.sleep(1000);
	    HashMap<Integer, HashMap<String, String>> allTableData2 = contractSearchPage.checkGridBodyDetails();
		String contractNumber2 = allTableData2.get(1).get("Contract");
	    if(contractNumber.equals(contractNumber2)) {
	    contractSearchPage.selectStatusCheckBoxInGrid(1).click();
	    contractSearchPage.getEditLink(1).click();
	    }
	    Assert.assertTrue(getEditContractPagetitle().isDisplayed());
	    Assert.assertTrue(getBtnSave().isEnabled());
	}
	
	@Test(priority = 7)
	public void verifyCobuyerFieldNotRequiredForEditContract_11630() throws InterruptedException {
		login.login(prop.getProperty("username1"), prop.getProperty("password"));
		Assert.assertEquals(getTitle().getText(), "Welcome to your AUL ADL Portal!");
	    verticalMenu.navigatetoLeftMenu("Contracts", "Contract Search");
	    Thread.sleep(1000);
	    Assert.assertTrue((getContractSearchPagetitle()).isDisplayed());
	    utils.scrollDown();
	    HashMap<Integer, HashMap<String, String>> allTableData = contractSearchPage.checkGridBodyDetails();
	    contractSearchPage.getSelectStatus().click();
	    contractSearchPage.getEnteredStatusChkbox().click();
	    String contractNumber = allTableData.get(2).get("Contract");
		utils.scrollDown();
	    contractSearchPage.getSearchBoxesInGrid().get("Contract").sendKeys(contractNumber);
	    Thread.sleep(1000);
	    HashMap<Integer, HashMap<String, String>> allTableData2 = contractSearchPage.checkGridBodyDetails();
		String contractNumber2 = allTableData2.get(1).get("Contract");
	    if(contractNumber.equals(contractNumber2)) {
	    contractSearchPage.selectStatusCheckBoxInGrid(1).click();
	    contractSearchPage.getEditLink(1).click();
	    }
	    Assert.assertTrue(getEditContractPagetitle().isDisplayed());
	    getCoustomerInfoFields().get(5).clear();
	    getCoustomerInfoFields().get(5).sendKeys("abc@gmal.com");
	    getCoustomerInfoFields().get(6).clear();
	    getCoustomerInfoFields().get(6).sendKeys("0000000000");
	    getBtnSave().click();
	    getDriver().switchTo().defaultContent();
	    Assert.assertTrue(getContractSubmittedSuccessTxt().isDisplayed());
	}
	
	@Test(priority = 8)
	public void verifyCobuyerInfoIsLoaded_11631() throws InterruptedException {
		login.login(prop.getProperty("username1"), prop.getProperty("password"));
		Assert.assertEquals(getTitle().getText(), "Welcome to your AUL ADL Portal!");
	    verticalMenu.navigatetoLeftMenu("Contracts", "Contract Search");
	    Thread.sleep(1000);
	    Assert.assertTrue((getContractSearchPagetitle()).isDisplayed());
	    utils.scrollDown();
	    HashMap<Integer, HashMap<String, String>> allTableData = contractSearchPage.checkGridBodyDetails();
	    contractSearchPage.getSelectStatus().click();
	    contractSearchPage.getEnteredStatusChkbox().click();
	    String contractNumber = allTableData.get(1).get("Contract");
		utils.scrollDown();
	    contractSearchPage.getSearchBoxesInGrid().get("Contract").sendKeys(contractNumber);
	    Thread.sleep(1000);
	    HashMap<Integer, HashMap<String, String>> allTableData2 = contractSearchPage.checkGridBodyDetails();
		String contractNumber2 = allTableData2.get(1).get("Contract");
	    if(contractNumber.equals(contractNumber2)) {
	    contractSearchPage.selectStatusCheckBoxInGrid(1).click();
	    contractSearchPage.getEditLink(1).click();
	    }
	    Assert.assertTrue(getEditContractPagetitle().isDisplayed());
	    JavascriptExecutor jse = (JavascriptExecutor)driver;
	    jse.executeScript("arguments[0].scrollIntoView()", getCobuyerChkbox()); 
	    getCoBuyerChkboxField().click();
	    Assert.assertTrue(getCoustomerInfoFields().get(0).getAttribute("maxlength").equals("40"),"Co-Buyer First Name Field is verified");
	    Assert.assertTrue(getCoustomerInfoFields().get(1).getAttribute("maxlength").equals("40"),"Co-Buyer Last Name Field is verified");
	    Assert.assertTrue(getCoustomerInfoFields().get(2).getAttribute("maxlength").equals("50"),"Co-Buyer Address Field is verified");
	    Assert.assertTrue(getCoustomerInfoFields().get(3).getAttribute("type").equals("text"),"Co-Buyer Zip code Field is verified");
	    Assert.assertTrue(getCoustomerInfoFields().get(4).getAttribute("maxlength").equals("30"),"Co-Buyer City Field is verified");
	    Assert.assertTrue(getCoustomerInfoFields().get(5).getAttribute("maxlength").equals("32"),"Co-Buyer Email Field is verified");
	    Assert.assertTrue(getCoustomerInfoFields().get(6).getAttribute("maxlength").equals("15"),"Co-Buyer Phone Number Field is verified");
	}
	
	@Test(priority = 9)
	public void verifyCobuyerInfoIsNotLoaded_11632() throws InterruptedException {
		login.login(prop.getProperty("username1"), prop.getProperty("password"));
		Assert.assertEquals(getTitle().getText(), "Welcome to your AUL ADL Portal!");
	    verticalMenu.navigatetoLeftMenu("Contracts", "Contract Search");
	    Thread.sleep(1000);
	    Assert.assertTrue((getContractSearchPagetitle()).isDisplayed());
	    utils.scrollDown();
	    HashMap<Integer, HashMap<String, String>> allTableData = contractSearchPage.checkGridBodyDetails();
	    contractSearchPage.getSelectStatus().click();
	    contractSearchPage.getEnteredStatusChkbox().click();
	    String contractNumber = allTableData.get(1).get("Contract");
		utils.scrollDown();
	    contractSearchPage.getSearchBoxesInGrid().get("Contract").sendKeys(contractNumber);
	    Thread.sleep(1000);
	    HashMap<Integer, HashMap<String, String>> allTableData2 = contractSearchPage.checkGridBodyDetails();
		String contractNumber2 = allTableData2.get(1).get("Contract");
	    if(contractNumber.equals(contractNumber2)) {
	    contractSearchPage.selectStatusCheckBoxInGrid(1).click();
	    contractSearchPage.getEditLink(1).click();
	    }
	    Assert.assertTrue(getEditContractPagetitle().isDisplayed());
	    Assert.assertFalse(getCobuyerChkbox().isSelected());
	}
	
	@Test(priority = 10)
	public void verifyCoustmerInfoElementsLoadedInEditContractPage_11633() throws InterruptedException {
		login.login(prop.getProperty("username1"), prop.getProperty("password"));
		Assert.assertEquals(getTitle().getText(), "Welcome to your AUL ADL Portal!");
	    verticalMenu.navigatetoLeftMenu("Contracts", "Contract Search");
	    Thread.sleep(1000);
	    Assert.assertTrue((getContractSearchPagetitle()).isDisplayed());
	    utils.scrollDown();
	    HashMap<Integer, HashMap<String, String>> allTableData = contractSearchPage.checkGridBodyDetails();
	    contractSearchPage.getSelectStatus().click();
	    contractSearchPage.getEnteredStatusChkbox().click();
	    String contractNumber = allTableData.get(1).get("Contract");
		utils.scrollDown();
	    contractSearchPage.getSearchBoxesInGrid().get("Contract").sendKeys(contractNumber);
	    Thread.sleep(1000);
	    HashMap<Integer, HashMap<String, String>> allTableData2 = contractSearchPage.checkGridBodyDetails();
		String contractNumber2 = allTableData2.get(1).get("Contract");
	    if(contractNumber.equals(contractNumber2)) {
	    contractSearchPage.selectStatusCheckBoxInGrid(1).click();
	    contractSearchPage.getEditLink(1).click();
	    }
	    Assert.assertTrue(getEditContractPagetitle().isDisplayed());
	    Assert.assertTrue(getLienholderTxtField().getAttribute("type").equals("text"));
	    Assert.assertTrue(getContarctInfoTxtFields1().get(0).getAttribute("maxlength").equals("16"),"Dealer No Field is verified");
	    Assert.assertTrue(getContarctInfoTxtFields1().get(1).getAttribute("type").equals("text"),"vehicle purchase Field is verified");
	    Assert.assertTrue(getContarctInfoTxtFields2().get(1).getAttribute("type").equals("text"),"Contract Retail Price Field is verified");
	    Assert.assertTrue(getCoustomerInfoFields().get(0).getAttribute("maxlength").equals("40"),"First Name Field is verified");
	    Assert.assertTrue(getCoustomerInfoFields().get(1).getAttribute("maxlength").equals("40"),"Last Name Field is verified");
	    Assert.assertTrue(getCoustomerInfoFields().get(2).getAttribute("maxlength").equals("50"),"Address Field is verified");
	    Assert.assertTrue(getCoustomerInfoFields().get(3).getAttribute("type").equals("text"),"Zip code Field is verified");
	    Assert.assertTrue(getCoustomerInfoFields().get(4).getAttribute("maxlength").equals("30"),"City Field is verified");
	    Assert.assertTrue(getCoustomerInfoFields().get(5).getAttribute("maxlength").equals("32"),"Email Field is verified");
	    Assert.assertTrue(getCoustomerInfoFields().get(6).getAttribute("maxlength").equals("15"),"Phone Number Field is verified");
	}
	
	@Test(priority = 11)
	public void verifyEditFunctionalityByUpdatingCobuyerandCustomer_11638_12595_15513_15517_15518_15519_15520() throws Exception {
		login.login(prop.getProperty("username1"), prop.getProperty("password"));
		Assert.assertEquals(getTitle().getText(), "Welcome to your AUL ADL Portal!");
	    verticalMenu.navigatetoLeftMenu("Contracts", "Contract Search");
	    Thread.sleep(1000);
	    Assert.assertTrue((getContractSearchPagetitle()).isDisplayed());
	    utils.scrollDown();
	    HashMap<Integer, HashMap<String, String>> allTableData = contractSearchPage.checkGridBodyDetails();
	    contractSearchPage.filterStatus("Entered");
	    String contractNumber = allTableData.get(1).get("Contract");
		utils.scrollDown();
	    contractSearchPage.getSearchBoxesInGrid().get("Contract").sendKeys(contractNumber);
	    Thread.sleep(1000);
	    HashMap<Integer, HashMap<String, String>> allTableData2 = contractSearchPage.checkGridBodyDetails();
		String contractNumber2 = allTableData2.get(1).get("Contract");
	    if(contractNumber.equals(contractNumber2)) {
	    contractSearchPage.selectStatusCheckBoxInGrid(1).click();
	    contractSearchPage.getEditLink(1).click();
	    }
	    Assert.assertTrue(getEditContractPagetitle().isDisplayed());
	    getLienholderTxtField().clear();
	    getLienholderTxtField().sendKeys("a");
	    Thread.sleep(2000);
	    String lienholderEneterdValue = getLeinholderList().get(0).getText();
	    getLeinholderList().get(0).click();
	    Assert.assertEquals(getLienholderTxtField().getAttribute("value"), lienholderEneterdValue);
	    
	    String dealNo = "34159";
	    getContarctInfoTxtFields1().get(0).clear();
	    getContarctInfoTxtFields1().get(0).sendKeys(dealNo);
	    Assert.assertEquals(getContarctInfoTxtFields1().get(0).getAttribute("value"),dealNo);
	    
	    String vehiclePurchasePrice = "100";
	    getContarctInfoTxtFields1().get(0).sendKeys(Keys.TAB);
	    getVehiclePurchaseTxtfield().sendKeys(Keys.BACK_SPACE);
	    getVehiclePurchaseTxtfield().sendKeys(Keys.BACK_SPACE);
	    getVehiclePurchaseTxtfield().sendKeys(Keys.BACK_SPACE);
	    getVehiclePurchaseTxtfield().sendKeys(Keys.BACK_SPACE);
	    getVehiclePurchaseTxtfield().sendKeys(Keys.BACK_SPACE);
	    getVehiclePurchaseTxtfield().sendKeys(Keys.BACK_SPACE);
	    getVehiclePurchaseTxtfield().sendKeys(vehiclePurchasePrice);
	    Assert.assertEquals(getVehiclePurchaseTxtfield().getAttribute("value"),vehiclePurchasePrice);
	    Thread.sleep(0);
	    
	    String contractRetailPrice = "10";
	    getVehiclePurchaseTxtfield().sendKeys(Keys.TAB);
	    getContactRetailPriceTxtField().sendKeys(Keys.BACK_SPACE);
	    getContactRetailPriceTxtField().sendKeys(Keys.BACK_SPACE);
	    getContactRetailPriceTxtField().sendKeys(Keys.BACK_SPACE);
	    getContactRetailPriceTxtField().sendKeys(Keys.BACK_SPACE);
	    getContactRetailPriceTxtField().sendKeys(Keys.BACK_SPACE);
	    getContactRetailPriceTxtField().sendKeys(Keys.BACK_SPACE);
	    getContactRetailPriceTxtField().sendKeys(contractRetailPrice);
	    Assert.assertEquals(getContactRetailPriceTxtField().getAttribute("value"),contractRetailPrice);
	    
	    String firstName = "Test";
	    getCoustomerInfoFields().get(0).clear();
	    getCoustomerInfoFields().get(0).sendKeys(firstName);
	    Assert.assertEquals(getCoustomerInfoFields().get(0).getAttribute("value"),firstName);
	    String lastName= "one";
	    getCoustomerInfoFields().get(1).clear();
	    getCoustomerInfoFields().get(1).sendKeys(lastName);
	    Assert.assertEquals(getCoustomerInfoFields().get(1).getAttribute("value"),lastName);
	    String address = "Texas";
	    getCoustomerInfoFields().get(2).clear();
	    getCoustomerInfoFields().get(2).sendKeys(address);
	    Assert.assertEquals(getCoustomerInfoFields().get(2).getAttribute("value"),address);
	    String  zipCode= "36666";
	    getCoustomerInfoFields().get(3).clear();
	    getCoustomerInfoFields().get(3).sendKeys(zipCode);
	    Assert.assertEquals(getCoustomerInfoFields().get(3).getAttribute("value"),zipCode);
	    String  city= "Dallas";
	    getCoustomerInfoFields().get(4).clear();
	    getCoustomerInfoFields().get(4).sendKeys(city);
	    Assert.assertEquals(getCoustomerInfoFields().get(4).getAttribute("value"),city);
	    String  email= "abc@gmail.com";
	    getCoustomerInfoFields().get(5).clear();
	    getCoustomerInfoFields().get(5).sendKeys(email);
	    Assert.assertEquals(getCoustomerInfoFields().get(5).getAttribute("value"),email);
	    String  phno= "0000000000";
	    String phnNoInFormat="(000) 000-0000";
	    getCoustomerInfoFields().get(6).clear();
	    getCoustomerInfoFields().get(6).sendKeys(phno);
	    Assert.assertEquals(getCoustomerInfoFields().get(6).getAttribute("value"),phnNoInFormat);
	    if(getCobuyerChkbox().getAttribute("aria-checked").equals("false"))
	    {
	    	getCoBuyerChkboxField().click();
	    }
	    String cobuyerFirstName = "Test1";
	    getCoustomerInfoFields().get(7).clear();
	    getCoustomerInfoFields().get(7).sendKeys(cobuyerFirstName);
	    Assert.assertEquals(getCoustomerInfoFields().get(7).getAttribute("value"),cobuyerFirstName);
	    String cobuyerLastName = "one1";
	    getCoustomerInfoFields().get(8).clear();
	    getCoustomerInfoFields().get(8).sendKeys(cobuyerLastName);
	    Assert.assertEquals(getCoustomerInfoFields().get(8).getAttribute("value"),cobuyerLastName);
	    String cobuyerAddress = "Texas1";
	    getCoustomerInfoFields().get(9).clear();
	    getCoustomerInfoFields().get(9).sendKeys(cobuyerAddress);
	    Assert.assertEquals(getCoustomerInfoFields().get(9).getAttribute("value"),cobuyerAddress);
	    String cobuyerZipCode = "36666";
	    getCoustomerInfoFields().get(10).clear();
	    getCoustomerInfoFields().get(10).sendKeys(cobuyerZipCode);
	    Assert.assertEquals(getCoustomerInfoFields().get(10).getAttribute("value"),cobuyerZipCode);
	    String cobuyerCity = "Dallas1";
	    getCoustomerInfoFields().get(11).clear();
	    getCoustomerInfoFields().get(11).sendKeys(cobuyerCity);
	    Assert.assertEquals(getCoustomerInfoFields().get(11).getAttribute("value"),cobuyerCity);
	    String cobuyerEmail = "def@gmail.com";
	    getCoustomerInfoFields().get(12).clear();
	    getCoustomerInfoFields().get(12).sendKeys(cobuyerEmail);
	    Assert.assertEquals(getCoustomerInfoFields().get(12).getAttribute("value"),cobuyerEmail);
	    String cobuyerPhnNo = "1112223333";
	    String cobuyerPhnNoInFormat = "(111) 222-3333";
	    getCoustomerInfoFields().get(13).clear();
	    getCoustomerInfoFields().get(13).sendKeys(cobuyerPhnNo);
	    Assert.assertEquals(getCoustomerInfoFields().get(13).getAttribute("value"),cobuyerPhnNoInFormat);
	    utils.scrollDown();
	    getBtnSave().click();
	    getDriver().switchTo().defaultContent();
	    Assert.assertTrue(getContractSubmittedSuccessTxt().isDisplayed());
	    getGoToContractsPageLink().click();
	    for (int i = 1; i <= getRowLoc().size(); i++) {
			String contract = allTableData.get(i).get("Contract");
			  if(contract.equals(contractNumber))
			  {
				 contractSearchPage.selectStatusCheckBoxInGrid(i).click();
				 contractSearchPage.getEditLink(i).click();
				 break;
				}
	    }	 
	    utils.scrollDown();
	    Assert.assertTrue(getLienholderTxtField().getAttribute("value").equalsIgnoreCase(lienholderEneterdValue));
	    Assert.assertTrue(getContarctInfoTxtFields1().get(0).getAttribute("value").equalsIgnoreCase(dealNo));
	    Assert.assertTrue(getCoustomerInfoFields().get(0).getAttribute("value").equalsIgnoreCase(firstName));
	    Assert.assertTrue(getCoustomerInfoFields().get(3).getAttribute("value").equalsIgnoreCase(zipCode));
	    Assert.assertTrue(getCoustomerInfoFields().get(6).getAttribute("value").equalsIgnoreCase(phnNoInFormat));
	    Assert.assertEquals(getCoustomerInfoFields().get(7).getAttribute("value"),cobuyerFirstName);
	    Assert.assertEquals(getCoustomerInfoFields().get(11).getAttribute("value"),cobuyerCity);
	    Assert.assertEquals(getCoustomerInfoFields().get(13).getAttribute("value"),cobuyerPhnNoInFormat);
	    
	    Assert.assertTrue(getDataFromDB(contractNumber).get(1).get("FIRST_NAME").equalsIgnoreCase(firstName));
	    Assert.assertTrue(getDataFromDB(contractNumber).get(1).get("ZIP").equalsIgnoreCase(zipCode));
	    Assert.assertTrue(getDataFromDB(contractNumber).get(1).get("PHONE").equalsIgnoreCase(phno));
	    Assert.assertTrue(getDataFromDB(contractNumber).get(1).get("COOWNER_FIRSTNAME").equalsIgnoreCase(cobuyerFirstName));
	    Assert.assertTrue(getDataFromDB(contractNumber).get(1).get("COOWNER_CITY").equalsIgnoreCase(cobuyerCity));
	    Assert.assertTrue(getDataFromDB(contractNumber).get(1).get("COOWNER_PHONE").equalsIgnoreCase(cobuyerPhnNo));
	}

	@Test(priority = 12)
	public void verifyEditFunctionalityByUpdatingCustomerInfo_11639() throws Exception {
		login.login(prop.getProperty("username1"), prop.getProperty("password"));
		Assert.assertEquals(getTitle().getText(), "Welcome to your AUL ADL Portal!");
	    verticalMenu.navigatetoLeftMenu("Contracts", "Contract Search");
	    Thread.sleep(1000);
	    Assert.assertTrue((getContractSearchPagetitle()).isDisplayed());
	    utils.scrollDown();
	    HashMap<Integer, HashMap<String, String>> allTableData = contractSearchPage.checkGridBodyDetails();
	    contractSearchPage.filterStatus("Entered");
	    String contractNumber = allTableData.get(1).get("Contract");
		utils.scrollDown();
	    contractSearchPage.getSearchBoxesInGrid().get("Contract").sendKeys(contractNumber);
	    Thread.sleep(1000);
	    HashMap<Integer, HashMap<String, String>> allTableData2 = contractSearchPage.checkGridBodyDetails();
		String contractNumber2 = allTableData2.get(1).get("Contract");
	    if(contractNumber.equals(contractNumber2)) {
	    contractSearchPage.selectStatusCheckBoxInGrid(1).click();
	    contractSearchPage.getEditLink(1).click();
	    }
	    Assert.assertTrue(getEditContractPagetitle().isDisplayed());
	    getLienholderTxtField().clear();
	    getLienholderTxtField().sendKeys("a");
	    Thread.sleep(2000);
	    String eneterdValue = getLeinholderList().get(0).getText();
	    getLeinholderList().get(0).click();
	    Assert.assertEquals(getLienholderTxtField().getAttribute("value"), eneterdValue);
	    
	    String dealNo = "34159";
	    getContarctInfoTxtFields1().get(0).clear();
	    getContarctInfoTxtFields1().get(0).sendKeys(dealNo);
	    Assert.assertEquals(getContarctInfoTxtFields1().get(0).getAttribute("value"),dealNo);
	    
	    String vehiclePurchasePrice = "100";
	    getContarctInfoTxtFields1().get(0).sendKeys(Keys.TAB);
	    getVehiclePurchaseTxtfield().sendKeys(Keys.BACK_SPACE);
	    getVehiclePurchaseTxtfield().sendKeys(Keys.BACK_SPACE);
	    getVehiclePurchaseTxtfield().sendKeys(Keys.BACK_SPACE);
	    getVehiclePurchaseTxtfield().sendKeys(Keys.BACK_SPACE);
	    getVehiclePurchaseTxtfield().sendKeys(Keys.BACK_SPACE);
	    getVehiclePurchaseTxtfield().sendKeys(Keys.BACK_SPACE);
	    getVehiclePurchaseTxtfield().sendKeys(vehiclePurchasePrice);
	    Assert.assertEquals(getVehiclePurchaseTxtfield().getAttribute("value"),vehiclePurchasePrice);
	    Thread.sleep(0);
	    
	    String contractRetailPrice = "10";
	    getVehiclePurchaseTxtfield().sendKeys(Keys.TAB);
	    getContactRetailPriceTxtField().sendKeys(Keys.BACK_SPACE);
	    getContactRetailPriceTxtField().sendKeys(Keys.BACK_SPACE);
	    getContactRetailPriceTxtField().sendKeys(Keys.BACK_SPACE);
	    getContactRetailPriceTxtField().sendKeys(Keys.BACK_SPACE);
	    getContactRetailPriceTxtField().sendKeys(Keys.BACK_SPACE);
	    getContactRetailPriceTxtField().sendKeys(Keys.BACK_SPACE);
	    getContactRetailPriceTxtField().sendKeys(contractRetailPrice);
	    Assert.assertEquals(getContactRetailPriceTxtField().getAttribute("value"),contractRetailPrice);
	    
	    String firstName = "Test";
	    getCoustomerInfoFields().get(0).clear();
	    getCoustomerInfoFields().get(0).sendKeys(firstName);
	    Assert.assertEquals(getCoustomerInfoFields().get(0).getAttribute("value"),firstName);
	    String lastName= "one";
	    getCoustomerInfoFields().get(1).clear();
	    getCoustomerInfoFields().get(1).sendKeys(lastName);
	    Assert.assertEquals(getCoustomerInfoFields().get(1).getAttribute("value"),lastName);
	    String address = "Texas";
	    getCoustomerInfoFields().get(2).clear();
	    getCoustomerInfoFields().get(2).sendKeys(address);
	    Assert.assertEquals(getCoustomerInfoFields().get(2).getAttribute("value"),address);
	    String  zipCode= "36666";
	    getCoustomerInfoFields().get(3).clear();
	    getCoustomerInfoFields().get(3).sendKeys(zipCode);
	    Assert.assertEquals(getCoustomerInfoFields().get(3).getAttribute("value"),zipCode);
	    String  city= "Dallas";
	    getCoustomerInfoFields().get(4).clear();
	    getCoustomerInfoFields().get(4).sendKeys(city);
	    Assert.assertEquals(getCoustomerInfoFields().get(4).getAttribute("value"),city);
	    String  email= "abc@gmail.com";
	    getCoustomerInfoFields().get(5).clear();
	    getCoustomerInfoFields().get(5).sendKeys(email);
	    Assert.assertEquals(getCoustomerInfoFields().get(5).getAttribute("value"),email);
	    String  phno= "0000000000";
	    String phnNoInFormat="(000) 000-0000";
	    getCoustomerInfoFields().get(6).clear();
	    getCoustomerInfoFields().get(6).sendKeys(phno);
	    Assert.assertEquals(getCoustomerInfoFields().get(6).getAttribute("value"),phnNoInFormat);
	    getBtnSave().click();
	    getDriver().switchTo().defaultContent();
	    Assert.assertTrue(getContractSubmittedSuccessTxt().isDisplayed());
	    getGoToContractsPageLink().click();
	    for (int i = 1; i <= getRowLoc().size(); i++) {
			String contract = allTableData.get(i).get("Contract");
			  if(contract.equals(contractNumber))
			  {
				 contractSearchPage.selectStatusCheckBoxInGrid(i).click();
				 contractSearchPage.getEditLink(i).click();
				 break;
				}
	    }	 
	    utils.scrollDown();
	    Assert.assertTrue(getContarctInfoTxtFields1().get(0).getAttribute("value").equalsIgnoreCase(dealNo));
	    Assert.assertTrue(getCoustomerInfoFields().get(0).getAttribute("value").equalsIgnoreCase(firstName));
	    Assert.assertTrue(getCoustomerInfoFields().get(3).getAttribute("value").equalsIgnoreCase(zipCode));
	    Assert.assertTrue(getCoustomerInfoFields().get(6).getAttribute("value").equalsIgnoreCase(phnNoInFormat));
	    
	    Assert.assertTrue(getDataFromDB(contractNumber).get(1).get("FIRST_NAME").equalsIgnoreCase(firstName));
	    Assert.assertTrue(getDataFromDB(contractNumber).get(1).get("ZIP").equalsIgnoreCase(zipCode));
	    Assert.assertTrue(getDataFromDB(contractNumber).get(1).get("PHONE").equalsIgnoreCase(phno));
	}
	
	@Test(priority = 13)
	public void verifyEditFunctionalityByUpdatingCoBuyerInfo_11640() throws Exception {
		login.login(prop.getProperty("username1"), prop.getProperty("password"));
		Assert.assertEquals(getTitle().getText(), "Welcome to your AUL ADL Portal!");
	    verticalMenu.navigatetoLeftMenu("Contracts", "Contract Search");
	    Thread.sleep(1000);
	    Assert.assertTrue((getContractSearchPagetitle()).isDisplayed());
	    utils.scrollDown();
	    HashMap<Integer, HashMap<String, String>> allTableData = contractSearchPage.checkGridBodyDetails();
	    contractSearchPage.filterStatus("Entered");
	    String contractNumber = allTableData.get(1).get("Contract");
		utils.scrollDown();
	    contractSearchPage.getSearchBoxesInGrid().get("Contract").sendKeys(contractNumber);
	    Thread.sleep(1000);
	    HashMap<Integer, HashMap<String, String>> allTableData2 = contractSearchPage.checkGridBodyDetails();
		String contractNumber2 = allTableData2.get(1).get("Contract");
	    if(contractNumber.equals(contractNumber2)) {
	    contractSearchPage.selectStatusCheckBoxInGrid(1).click();
	    contractSearchPage.getEditLink(1).click();
	    }
	    Assert.assertTrue(getEditContractPagetitle().isDisplayed());
	    if(getCobuyerChkbox().getAttribute("aria-checked").equals("false"))
	    {
	    	getCoBuyerChkboxField().click();
	    }
	    String cobuyerFirstName = "Test1";
	    getCoustomerInfoFields().get(7).clear();
	    getCoustomerInfoFields().get(7).sendKeys(cobuyerFirstName);
	    Assert.assertEquals(getCoustomerInfoFields().get(7).getAttribute("value"),cobuyerFirstName);
	    String cobuyerLastName = "one1";
	    getCoustomerInfoFields().get(8).clear();
	    getCoustomerInfoFields().get(8).sendKeys(cobuyerLastName);
	    Assert.assertEquals(getCoustomerInfoFields().get(8).getAttribute("value"),cobuyerLastName);
	    String cobuyerAddress = "Texas1";
	    getCoustomerInfoFields().get(9).clear();
	    getCoustomerInfoFields().get(9).sendKeys(cobuyerAddress);
	    Assert.assertEquals(getCoustomerInfoFields().get(9).getAttribute("value"),cobuyerAddress);
	    String cobuyerZipCode = "36666";
	    getCoustomerInfoFields().get(10).clear();
	    getCoustomerInfoFields().get(10).sendKeys(cobuyerZipCode);
	    Assert.assertEquals(getCoustomerInfoFields().get(10).getAttribute("value"),cobuyerZipCode);
	    String cobuyerCity = "Dallas1";
	    getCoustomerInfoFields().get(11).clear();
	    getCoustomerInfoFields().get(11).sendKeys(cobuyerCity);
	    Assert.assertEquals(getCoustomerInfoFields().get(11).getAttribute("value"),cobuyerCity);
	    String cobuyerEmail = "def@gmail.com";
	    getCoustomerInfoFields().get(12).clear();
	    getCoustomerInfoFields().get(12).sendKeys(cobuyerEmail);
	    Assert.assertEquals(getCoustomerInfoFields().get(12).getAttribute("value"),cobuyerEmail);
	    String cobuyerPhnNo = "1112223333";
	    String cobuyerPhnNoInFormat = "(111) 222-3333";
	    getCoustomerInfoFields().get(13).clear();
	    getCoustomerInfoFields().get(13).sendKeys(cobuyerPhnNo);
	    Assert.assertEquals(getCoustomerInfoFields().get(13).getAttribute("value"),cobuyerPhnNoInFormat);
	    utils.scrollDown();
	    getBtnSave().click();
	    getDriver().switchTo().defaultContent();
	    Assert.assertTrue(getContractSubmittedSuccessTxt().isDisplayed());
	    getGoToContractsPageLink().click();
	    for (int i = 1; i <= getRowLoc().size(); i++) {
			String contract = allTableData.get(i).get("Contract");
			  if(contract.equals(contractNumber))
			  {
				 contractSearchPage.selectStatusCheckBoxInGrid(i).click();
				 contractSearchPage.getEditLink(i).click();
				 break;
				}
	    }	 
	    utils.scrollDown();
	    Assert.assertEquals(getCoustomerInfoFields().get(7).getAttribute("value"),cobuyerFirstName);
	    Assert.assertEquals(getCoustomerInfoFields().get(11).getAttribute("value"),cobuyerCity);
	    Assert.assertEquals(getCoustomerInfoFields().get(13).getAttribute("value"),cobuyerPhnNoInFormat);
	    
	    Assert.assertTrue(getDataFromDB(contractNumber).get(1).get("COOWNER_FIRSTNAME").equalsIgnoreCase(cobuyerFirstName));
	    Assert.assertTrue(getDataFromDB(contractNumber).get(1).get("COOWNER_CITY").equalsIgnoreCase(cobuyerCity));
	    Assert.assertTrue(getDataFromDB(contractNumber).get(1).get("COOWNER_PHONE").equalsIgnoreCase(cobuyerPhnNo));
	}
	
	@Test(priority = 14)
	public void verifyLienholderTypeAheadFunctionalityInBList_11675_15370() throws Exception {
		login.login(prop.getProperty("username1"), prop.getProperty("password"));
		Assert.assertEquals(getTitle().getText(), "Welcome to your AUL ADL Portal!");
		verticalMenu.navigatetoContract();
		singleContract.singleContract("Bank of America");
	    verticalMenu.navigatetoLeftMenu("Contracts", "Contract Search");
	    Thread.sleep(1000);
	    Assert.assertTrue((getContractSearchPagetitle()).isDisplayed());
	    utils.scrollDown();
	    HashMap<Integer, HashMap<String, String>> allTableData = contractSearchPage.checkGridBodyDetails();
	    contractSearchPage.getSelectStatus().click();
	    contractSearchPage.getEnteredStatusChkbox().click();
	    String contractNumber = allTableData.get(1).get("Contract");
		utils.scrollDown();
	    contractSearchPage.getSearchBoxesInGrid().get("Contract").sendKeys(contractNumber);
	    Thread.sleep(1000);
	    HashMap<Integer, HashMap<String, String>> allTableData2 = contractSearchPage.checkGridBodyDetails();
		String contractNumber2 = allTableData2.get(1).get("Contract");
	    if(contractNumber.equals(contractNumber2)) {
	    contractSearchPage.selectStatusCheckBoxInGrid(1).click();
	    contractSearchPage.getEditLink(1).click();
	    }
	    Assert.assertTrue(getEditContractPagetitle().isDisplayed());
	    getLienholderTxtField().clear();
	    getLienholderTxtField().sendKeys("Bank");
	    Thread.sleep(2000);
	    Assert.assertTrue(getLienholderTxtField().getAttribute("value").equalsIgnoreCase("Bank"));
	    for(int i=0;i<5;i++)
	    {
	    getLeinholderList().get(i).toString().startsWith("Bank");
	    }
	}
	
	@Test(priority = 15)
	public void verifyLienholderOptionSelectionInBList_11676() throws Exception {
		login.login(prop.getProperty("username1"), prop.getProperty("password"));
		Assert.assertEquals(getTitle().getText(), "Welcome to your AUL ADL Portal!");
	    verticalMenu.navigatetoLeftMenu("Contracts", "Contract Search");
	    Thread.sleep(1000);
	    Assert.assertTrue((getContractSearchPagetitle()).isDisplayed());
	    utils.scrollDown();
	    HashMap<Integer, HashMap<String, String>> allTableData = contractSearchPage.checkGridBodyDetails();
	    contractSearchPage.getSelectStatus().click();
	    contractSearchPage.getEnteredStatusChkbox().click();
	    String contractNumber = allTableData.get(1).get("Contract");
		utils.scrollDown();
	    contractSearchPage.getSearchBoxesInGrid().get("Contract").sendKeys(contractNumber);
	    Thread.sleep(1000);
	    HashMap<Integer, HashMap<String, String>> allTableData2 = contractSearchPage.checkGridBodyDetails();
		String contractNumber2 = allTableData2.get(1).get("Contract");
	    if(contractNumber.equals(contractNumber2)) {
	    contractSearchPage.selectStatusCheckBoxInGrid(1).click();
	    contractSearchPage.getEditLink(1).click();
	    }
	    Assert.assertTrue(getEditContractPagetitle().isDisplayed());
	    getLienholderTxtField().clear();
	    getLienholderTxtField().sendKeys("Bank");
	    Thread.sleep(2000);
	    Assert.assertTrue(getLienholderTxtField().getAttribute("value").equalsIgnoreCase("Bank"));
	    for(int i=0;i<5;i++)
	    {
	    getLeinholderList().get(i).toString().startsWith("Bank");
	    }
	    String selectedLienholder = getLeinholderList().get(1).getText();
	    getLeinholderList().get(1).click();
	    Assert.assertTrue(getLienholderTxtField().getAttribute("value").equalsIgnoreCase(selectedLienholder));
	}
	
	@Test(priority = 16)
	public void verifyLienholderNavigationWithKeyboardInBList_11677_15372() throws Exception {
		login.login(prop.getProperty("username1"), prop.getProperty("password"));
		Assert.assertEquals(getTitle().getText(), "Welcome to your AUL ADL Portal!");
	    verticalMenu.navigatetoLeftMenu("Contracts", "Contract Search");
	    Thread.sleep(1000);
	    Assert.assertTrue((getContractSearchPagetitle()).isDisplayed());
	    utils.scrollDown();
	    HashMap<Integer, HashMap<String, String>> allTableData = contractSearchPage.checkGridBodyDetails();
	    contractSearchPage.getSelectStatus().click();
	    contractSearchPage.getEnteredStatusChkbox().click();
	    String contractNumber = allTableData.get(1).get("Contract");
		utils.scrollDown();
	    contractSearchPage.getSearchBoxesInGrid().get("Contract").sendKeys(contractNumber);
	    Thread.sleep(1000);
	    HashMap<Integer, HashMap<String, String>> allTableData2 = contractSearchPage.checkGridBodyDetails();
		String contractNumber2 = allTableData2.get(1).get("Contract");
	    if(contractNumber.equals(contractNumber2)) {
	    contractSearchPage.selectStatusCheckBoxInGrid(1).click();
	    contractSearchPage.getEditLink(1).click();
	    }
	    Assert.assertTrue(getEditContractPagetitle().isDisplayed());
	    getLienholderTxtField().clear();
	    getLienholderTxtField().sendKeys("Bank");
	    Thread.sleep(2000);
	    Assert.assertTrue(getLienholderTxtField().getAttribute("value").equalsIgnoreCase("Bank"));
	    for(int i=0;i<5;i++)
	    {
	    getLeinholderList().get(i).toString().startsWith("Bank");
	    }
	    getLienholderTxtField().sendKeys(Keys.ARROW_DOWN);
		getLienholderTxtField().sendKeys(Keys.ARROW_DOWN);
		getLienholderTxtField().sendKeys(Keys.ARROW_UP);
//		String borderColorOfElement = getLienholderlistwithBackground().get(0).getCssValue("background-color");
//		String ActualcolorInHexaformat = Color.fromString(borderColorOfElement).asHex();
//		System.out.println("color is:"+ActualcolorInHexaformat);
	}


	@Test(priority = 17)
	public void verifyLienholderOptionselectionWithKeyboardInBlist_11678() throws Exception {
		login.login(prop.getProperty("username1"), prop.getProperty("password"));
		Assert.assertEquals(getTitle().getText(), "Welcome to your AUL ADL Portal!");
	    verticalMenu.navigatetoLeftMenu("Contracts", "Contract Search");
	    Thread.sleep(1000);
	    Assert.assertTrue((getContractSearchPagetitle()).isDisplayed());
	    utils.scrollDown();
	    HashMap<Integer, HashMap<String, String>> allTableData = contractSearchPage.checkGridBodyDetails();
	    contractSearchPage.getSelectStatus().click();
	    contractSearchPage.getEnteredStatusChkbox().click();
	    String contractNumber = allTableData.get(1).get("Contract");
		utils.scrollDown();
	    contractSearchPage.getSearchBoxesInGrid().get("Contract").sendKeys(contractNumber);
	    Thread.sleep(1000);
	    HashMap<Integer, HashMap<String, String>> allTableData2 = contractSearchPage.checkGridBodyDetails();
		String contractNumber2 = allTableData2.get(1).get("Contract");
	    if(contractNumber.equals(contractNumber2)) {
	    contractSearchPage.selectStatusCheckBoxInGrid(1).click();
	    contractSearchPage.getEditLink(1).click();
	    }
	    Assert.assertTrue(getEditContractPagetitle().isDisplayed());
	    getLienholderTxtField().clear();
	    getLienholderTxtField().sendKeys("Bank");
	    Thread.sleep(2000);
	    Assert.assertTrue(getLienholderTxtField().getAttribute("value").equalsIgnoreCase("Bank"));
	    for(int i=0;i<5;i++)
	    {
	    getLeinholderList().get(i).toString().startsWith("Bank");
	    }
	    String eneterdValue = getLeinholderList().get(0).getText();
	    getLienholderTxtField().sendKeys(Keys.ARROW_DOWN);
	    getLienholderTxtField().sendKeys(Keys.ARROW_DOWN);
	    getLienholderTxtField().sendKeys(Keys.ARROW_UP,Keys.ENTER);
	    Assert.assertEquals(getLienholderTxtField().getAttribute("value"), eneterdValue);
	}
	
	@Test(priority = 18)
	public void verifyInvalidMsgOnLienholderForInvalidTxt_11757() throws Exception {
		login.login(prop.getProperty("username1"), prop.getProperty("password"));
		Assert.assertEquals(getTitle().getText(), "Welcome to your AUL ADL Portal!");
	    verticalMenu.navigatetoLeftMenu("Contracts", "Contract Search");
	    Thread.sleep(1000);
	    Assert.assertTrue((getContractSearchPagetitle()).isDisplayed());
	    utils.scrollDown();
	    HashMap<Integer, HashMap<String, String>> allTableData = contractSearchPage.checkGridBodyDetails();
	    contractSearchPage.getSelectStatus().click();
	    contractSearchPage.getEnteredStatusChkbox().click();
	    String contractNumber = allTableData.get(1).get("Contract");
		utils.scrollDown();
	    contractSearchPage.getSearchBoxesInGrid().get("Contract").sendKeys(contractNumber);
	    Thread.sleep(1000);
	    HashMap<Integer, HashMap<String, String>> allTableData2 = contractSearchPage.checkGridBodyDetails();
		String contractNumber2 = allTableData2.get(1).get("Contract");
	    if(contractNumber.equals(contractNumber2)) {
	    contractSearchPage.selectStatusCheckBoxInGrid(1).click();
	    contractSearchPage.getEditLink(1).click();
	    }
	    Assert.assertTrue(getEditContractPagetitle().isDisplayed());
	    getLienholderTxtField().clear();
	    getLienholderTxtField().sendKeys("@!#");
	    getBtnSave().click();
	    Assert.assertTrue(getInvalidLienholderTxt().isDisplayed());
	}
	
	
	@Test(priority = 19)
	public void verifyLienholderdeletionInBlist_11758() throws Exception {
		login.login(prop.getProperty("username1"), prop.getProperty("password"));
		Assert.assertEquals(getTitle().getText(), "Welcome to your AUL ADL Portal!");
	    verticalMenu.navigatetoLeftMenu("Contracts", "Contract Search");
	    Thread.sleep(1000);
	    Assert.assertTrue((getContractSearchPagetitle()).isDisplayed());
	    utils.scrollDown();
	    HashMap<Integer, HashMap<String, String>> allTableData = contractSearchPage.checkGridBodyDetails();
	    contractSearchPage.getSelectStatus().click();
	    contractSearchPage.getEnteredStatusChkbox().click();
	    String contractNumber = allTableData.get(1).get("Contract");
		utils.scrollDown();
	    contractSearchPage.getSearchBoxesInGrid().get("Contract").sendKeys(contractNumber);
	    Thread.sleep(1000);
	    HashMap<Integer, HashMap<String, String>> allTableData2 = contractSearchPage.checkGridBodyDetails();
		String contractNumber2 = allTableData2.get(1).get("Contract");
	    if(contractNumber.equals(contractNumber2)) {
	    contractSearchPage.selectStatusCheckBoxInGrid(1).click();
	    contractSearchPage.getEditLink(1).click();
	    }
	    Assert.assertTrue(getEditContractPagetitle().isDisplayed());
	    getLienholderTxtField().clear();
	    getLienholderTxtField().sendKeys("Bank");
	    Thread.sleep(2000);
	    Assert.assertTrue(getLienholderTxtField().getAttribute("value").equalsIgnoreCase("Bank"));
	    for(int i=0;i<5;i++)
	    {
	    getLeinholderList().get(i).toString().startsWith("Bank");
	    }
	    String eneterdValue = getLeinholderList().get(0).getText();
	    getLienholderTxtField().sendKeys(Keys.ARROW_DOWN);
	    getLienholderTxtField().sendKeys(Keys.ARROW_DOWN);
	    getLienholderTxtField().sendKeys(Keys.ARROW_UP,Keys.ENTER);
	    Assert.assertEquals(getLienholderTxtField().getAttribute("value"), eneterdValue);
	    getLienholderTxtField().clear();
	    Assert.assertTrue(getLienholderTxtField().getAttribute("value").isEmpty());
	}
	
	
	@Test(priority = 20)
	public void verifyLienholderOptionselectionInBlist_12583() throws Exception {
		login.login(prop.getProperty("username1"), prop.getProperty("password"));
		Assert.assertEquals(getTitle().getText(), "Welcome to your AUL ADL Portal!");
	    verticalMenu.navigatetoLeftMenu("Contracts", "Contract Search");
	    Thread.sleep(1000);
	    Assert.assertTrue((getContractSearchPagetitle()).isDisplayed());
	    utils.scrollDown();
	    HashMap<Integer, HashMap<String, String>> allTableData = contractSearchPage.checkGridBodyDetails();
	    contractSearchPage.getSelectStatus().click();
	    contractSearchPage.getEnteredStatusChkbox().click();
	    String contractNumber = allTableData.get(1).get("Contract");
		utils.scrollDown();
	    contractSearchPage.getSearchBoxesInGrid().get("Contract").sendKeys(contractNumber);
	    Thread.sleep(1000);
	    HashMap<Integer, HashMap<String, String>> allTableData2 = contractSearchPage.checkGridBodyDetails();
		String contractNumber2 = allTableData2.get(1).get("Contract");
	    if(contractNumber.equals(contractNumber2)) {
	    contractSearchPage.selectStatusCheckBoxInGrid(1).click();
	    contractSearchPage.getEditLink(1).click();
	    }
	    Assert.assertTrue(getEditContractPagetitle().isDisplayed());
	    getLienholderTxtField().clear();
	    getLienholderTxtField().sendKeys("Bank");
	    Thread.sleep(2000);
	    Assert.assertTrue(getLienholderTxtField().getAttribute("value").equalsIgnoreCase("Bank"));
	    for(int i=0;i<5;i++)
	    {
	    getLeinholderList().get(i).toString().startsWith("Bank");
	    }
	    String eneterdValue = getLeinholderList().get(0).getText();
	    getLeinholderList().get(0).click();
	    Assert.assertEquals(getLienholderTxtField().getAttribute("value"), eneterdValue);
	}
	
	@Test(priority = 21)
	public void verifyLienholderOptionselectionWithKeyboardInBlist_12585() throws Exception {
		login.login(prop.getProperty("username1"), prop.getProperty("password"));
		Assert.assertEquals(getTitle().getText(), "Welcome to your AUL ADL Portal!");
	    verticalMenu.navigatetoLeftMenu("Contracts", "Contract Search");
	    Thread.sleep(1000);
	    Assert.assertTrue((getContractSearchPagetitle()).isDisplayed());
	    utils.scrollDown();
	    HashMap<Integer, HashMap<String, String>> allTableData = contractSearchPage.checkGridBodyDetails();
	    contractSearchPage.getSelectStatus().click();
	    contractSearchPage.getEnteredStatusChkbox().click();                                                                                                      
	    String contractNumber = allTableData.get(1).get("Contract");
		utils.scrollDown();
	    contractSearchPage.getSearchBoxesInGrid().get("Contract").sendKeys(contractNumber);
	    Thread.sleep(1000);
	    HashMap<Integer, HashMap<String, String>> allTableData2 = contractSearchPage.checkGridBodyDetails();
		String contractNumber2 = allTableData2.get(1).get("Contract");
	    if(contractNumber.equals(contractNumber2)) {
	    //contractSearchPage.selectStatusCheckBoxInGrid(1).click();
	    contractSearchPage.getEditLink(1).click();
	    }
	    Assert.assertTrue(getEditContractPagetitle().isDisplayed());
	    getLienholderTxtField().clear();
	    getLienholderTxtField().sendKeys("Bank");
	    Thread.sleep(2000);
	    Assert.assertTrue(getLienholderTxtField().getAttribute("value").equalsIgnoreCase("Bank"));
	    for(int i=0;i<5;i++)
	    {
	    getLeinholderList().get(i).toString().startsWith("Bank");
	    }
	    String eneterdValue = getLeinholderList().get(0).getText();
	    getLienholderTxtField().sendKeys(Keys.ARROW_DOWN);
	    getLienholderTxtField().sendKeys(Keys.ARROW_DOWN);
	    getLienholderTxtField().sendKeys(Keys.ARROW_UP,Keys.ENTER);
	    Assert.assertEquals(getLienholderTxtField().getAttribute("value"), eneterdValue);
	}
	
	   
	    @Test(priority = 22)
		public void verifyInvalidMsgOnLienholderWithInvalidCharacter_12590() throws Exception {
			login.login(prop.getProperty("username1"), prop.getProperty("password"));
			Assert.assertEquals(getTitle().getText(), "Welcome to your AUL ADL Portal!");
		    verticalMenu.navigatetoLeftMenu("Contracts", "Contract Search");
		    Thread.sleep(1000);
		    Assert.assertTrue((getContractSearchPagetitle()).isDisplayed());
		    utils.scrollDown();
		    HashMap<Integer, HashMap<String, String>> allTableData = contractSearchPage.checkGridBodyDetails();
		    contractSearchPage.getSelectStatus().click();
		    contractSearchPage.getEnteredStatusChkbox().click();
		    String contractNumber = allTableData.get(1).get("Contract");
			utils.scrollDown();
		    contractSearchPage.getSearchBoxesInGrid().get("Contract").sendKeys(contractNumber);
		    Thread.sleep(1000);
		    HashMap<Integer, HashMap<String, String>> allTableData2 = contractSearchPage.checkGridBodyDetails();
			String contractNumber2 = allTableData2.get(1).get("Contract");
		    if(contractNumber.equals(contractNumber2)) {
		    contractSearchPage.selectStatusCheckBoxInGrid(1).click();
		    contractSearchPage.getEditLink(1).click();
		    }
		    Assert.assertTrue(getEditContractPagetitle().isDisplayed());
		    getLienholderTxtField().clear();
		    getLienholderTxtField().sendKeys("@");
		    getBtnSave().click();
		    Assert.assertTrue(getInvalidLienholderTxt().isDisplayed());
		}
		
	    @Test(priority = 23)
		public void verifyBListLienholderDoesntConvertAListLienholder_12594_12610_12587() throws Exception {
	    	login.login(prop.getProperty("username1"), prop.getProperty("password"));
			Assert.assertEquals(getTitle().getText(), "Welcome to your AUL ADL Portal!");
			verticalMenu.navigatetoContract();
			singleContract.singleContract("Bank of America");
		    verticalMenu.navigatetoLeftMenu("Contracts", "Contract Search");
		    Thread.sleep(1000);
		    Assert.assertTrue((getContractSearchPagetitle()).isDisplayed());
		    utils.scrollDown();
		    HashMap<Integer, HashMap<String, String>> allTableData = contractSearchPage.checkGridBodyDetails();
		    contractSearchPage.getSelectStatus().click();
		    contractSearchPage.getEnteredStatusChkbox().click();
		    String contractNumber = allTableData.get(1).get("Contract");
			utils.scrollDown();
		    contractSearchPage.getSearchBoxesInGrid().get("Contract").sendKeys(contractNumber);
		    Thread.sleep(1000);
		    HashMap<Integer, HashMap<String, String>> allTableData2 = contractSearchPage.checkGridBodyDetails();
			String contractNumber2 = allTableData2.get(1).get("Contract");
		    if(contractNumber.equals(contractNumber2)) {
		    contractSearchPage.selectStatusCheckBoxInGrid(1).click();
		    contractSearchPage.getEditLink(1).click();
		    }
		    Assert.assertTrue(getEditContractPagetitle().isDisplayed());
		    getLienholderTxtField().clear();
		    getLienholderTxtField().sendKeys("Bank");
		    Thread.sleep(2000);
		    Assert.assertTrue(getLienholderTxtField().getAttribute("value").equalsIgnoreCase("Bank"));
		    for(int i=0;i<5;i++)
		    {
		    getLeinholderList().get(i).toString().startsWith("Bank");
		    }
		    getLienholderTxtField().clear();
		    getLienholderTxtField().sendKeys("SPP");
		    getCoustomerInfoFields().get(5).clear();
		    getCoustomerInfoFields().get(5).sendKeys("abc@gmail.com");
		    getCoustomerInfoFields().get(6).clear();
		    getCoustomerInfoFields().get(6).sendKeys("0000000000");
		    utils.scrollDown();
		    getBtnSave().click();
		    utils.scrollUp();
		    Thread.sleep(1000);
		    Assert.assertTrue(getInvalidLienholderTxt().isDisplayed());
		    getLienholderTxtField().clear();
		    getLienholderTxtField().sendKeys("Bank of America");
		    Thread.sleep(3000);
		    String eneterdValue = getLeinholderList().get(0).getText();
		    getLeinholderList().get(0).click();
		    Assert.assertEquals(getLienholderTxtField().getAttribute("value"),eneterdValue);
		    utils.scrollDown();
		    getBtnSave().click();
		    getDriver().switchTo().defaultContent();
		    Assert.assertTrue(getContractSubmittedSuccessTxt().isDisplayed());
		    getGoToContractsPageLink().click();
		    for (int i = 1; i <= getRowLoc().size(); i++) {
				String contract = allTableData.get(i).get("Contract");
				  if(contract.equals(contractNumber))
				  {
					 contractSearchPage.selectStatusCheckBoxInGrid(i).click();
					 contractSearchPage.getEditLink(i).click();
					 break;
					}
		    }	 
		    utils.scrollDown();
		    Assert.assertTrue(getLienholderTxtField().getAttribute("value").equalsIgnoreCase(eneterdValue));
		}

	    @Test(priority = 24)
		public void verifyLienHolderEmptyAndIsntWantToSelectAList_12597_12613_15382_15437() throws Exception {
	    	login.login(prop.getProperty("username1"), prop.getProperty("password"));
			Assert.assertEquals(getTitle().getText(), "Welcome to your AUL ADL Portal!");
			verticalMenu.navigatetoContract();
			singleContract.singleContract();
		    verticalMenu.navigatetoLeftMenu("Contracts", "Contract Search");
		    Thread.sleep(1000);
		    Assert.assertTrue((getContractSearchPagetitle()).isDisplayed());
		    utils.scrollDown();
		    HashMap<Integer, HashMap<String, String>> allTableData = contractSearchPage.checkGridBodyDetails();
		    contractSearchPage.getSelectStatus().click();
		    contractSearchPage.getEnteredStatusChkbox().click();
		    String contractNumber = allTableData.get(1).get("Contract");
			utils.scrollDown();
		    contractSearchPage.getSearchBoxesInGrid().get("Contract").sendKeys(contractNumber);
		    Thread.sleep(1000);
		    HashMap<Integer, HashMap<String, String>> allTableData2 = contractSearchPage.checkGridBodyDetails();
			String contractNumber2 = allTableData2.get(1).get("Contract");
		    if(contractNumber.equals(contractNumber2)) {
		    contractSearchPage.selectStatusCheckBoxInGrid(1).click();
		    contractSearchPage.getEditLink(1).click();
		    }
		    Assert.assertTrue(getEditContractPagetitle().isDisplayed());
		    getLienholderTxtField().clear();
		    getLienholderTxtField().sendKeys("SPP");
		    getCoustomerInfoFields().get(5).clear();
		    getCoustomerInfoFields().get(5).sendKeys("abc@gmail.com");
		    getCoustomerInfoFields().get(6).clear();
		    getCoustomerInfoFields().get(6).sendKeys("0000000000");
		    utils.scrollDown();
		    getBtnSave().click();
		    utils.scrollUp();
		    Thread.sleep(1000);
		    Assert.assertTrue(getInvalidLienholderTxt().isDisplayed());
		    getLienholderTxtField().clear();
		    getLienholderTxtField().sendKeys("Bank");
		    Thread.sleep(2000);
		    Assert.assertTrue(getLienholderTxtField().getAttribute("value").equalsIgnoreCase("Bank"));
		    for(int i=0;i<5;i++)
		    {
		    getLeinholderList().get(i).toString().startsWith("Bank");
		    }
		    String eneterdValue = getLeinholderList().get(0).getText();
		    getLeinholderList().get(0).click();
		    Assert.assertEquals(getLienholderTxtField().getAttribute("value"), eneterdValue);
	    }
	    
	    @Test(priority = 25)
	    public void verifyContractInfoSectionLoadsValidValues_15362() throws Exception {
	    	login.login(prop.getProperty("username1"), prop.getProperty("password"));
			Assert.assertEquals(getTitle().getText(), "Welcome to your AUL ADL Portal!");
			verticalMenu.navigatetoContract();
			singleContract.singleContract();
		    verticalMenu.navigatetoLeftMenu("Contracts", "Contract Search");
		    Thread.sleep(1000);
		    Assert.assertTrue((getContractSearchPagetitle()).isDisplayed());
		    utils.scrollDown();
		    HashMap<Integer, HashMap<String, String>> allTableData = contractSearchPage.checkGridBodyDetails();
		    contractSearchPage.filterStatus("Entered");
		    String contractNumber = allTableData.get(1).get("Contract");
			utils.scrollDown();
		    contractSearchPage.getSearchBoxesInGrid().get("Contract").sendKeys(contractNumber);
		    Thread.sleep(1000);
		    HashMap<Integer, HashMap<String, String>> allTableData2 = contractSearchPage.checkGridBodyDetails();
			String contractNumber2 = allTableData2.get(1).get("Contract");
		    if(contractNumber.equals(contractNumber2)) {
		    contractSearchPage.selectStatusCheckBoxInGrid(1).click();
		    contractSearchPage.getEditLink(1).click();
		    }
		    Assert.assertTrue(getEditContractPagetitle().isDisplayed());
		    Thread.sleep(10000);
		    String dealNo = prop.getProperty("roleid");
		    getContarctInfoTxtFields1().get(0).clear();
		    getContarctInfoTxtFields1().get(0).sendKeys(dealNo);
		    Assert.assertEquals(getContarctInfoTxtFields1().get(0).getAttribute("value"),dealNo);
		    getContarctInfoTxtFields1().get(0).sendKeys(Keys.TAB);
		    Assert.assertEquals(getVehiclePurchaseTxtfield().getAttribute("value"),"10,000.00");
		    Thread.sleep(0);
		    getVehiclePurchaseTxtfield().sendKeys(Keys.TAB);
		    Assert.assertEquals(getContactRetailPriceTxtField().getAttribute("value"),"210.00");
	    }
	    
	    @Test(priority = 26)
		public void verifyLienHolderFieldUnderStaticInfoSection_15368() throws Exception {
	    	login.login(prop.getProperty("username1"), prop.getProperty("password"));
			Assert.assertEquals(getTitle().getText(), "Welcome to your AUL ADL Portal!");
			verticalMenu.navigatetoContract();
			singleContract.singleContract();
		    verticalMenu.navigatetoLeftMenu("Contracts", "Contract Search");
		    Thread.sleep(1000);
		    Assert.assertTrue((getContractSearchPagetitle()).isDisplayed());
		    utils.scrollDown();
		    HashMap<Integer, HashMap<String, String>> allTableData = contractSearchPage.checkGridBodyDetails();
		    contractSearchPage.getSelectStatus().click();
		    contractSearchPage.getEnteredStatusChkbox().click();
		    String contractNumber = allTableData.get(1).get("Contract");
			utils.scrollDown();
		    contractSearchPage.getSearchBoxesInGrid().get("Contract").sendKeys(contractNumber);
		    Thread.sleep(1000);
		    HashMap<Integer, HashMap<String, String>> allTableData2 = contractSearchPage.checkGridBodyDetails();
			String contractNumber2 = allTableData2.get(1).get("Contract");
		    if(contractNumber.equals(contractNumber2)) {
		    contractSearchPage.selectStatusCheckBoxInGrid(1).click();
		    contractSearchPage.getEditLink(1).click();
		    }
		    Assert.assertTrue(getNotOnTheListLink().isDisplayed());
	    }
	    
	        @Test(priority = 27)
	  		public void verifyLienHolderEditFuctionality_15375() throws Exception {
	  	    	login.login(prop.getProperty("username1"), prop.getProperty("password"));
	  			Assert.assertEquals(getTitle().getText(), "Welcome to your AUL ADL Portal!");
	  		    verticalMenu.navigatetoLeftMenu("Contracts", "Contract Search");
	  		    Thread.sleep(1000);
	  		    Assert.assertTrue((getContractSearchPagetitle()).isDisplayed());
	  		    utils.scrollDown();
	  		    HashMap<Integer, HashMap<String, String>> allTableData = contractSearchPage.checkGridBodyDetails();
	  		    contractSearchPage.getSelectStatus().click();
	  		    contractSearchPage.getEnteredStatusChkbox().click();
	  		    String contractNumber = allTableData.get(1).get("Contract");
	  			utils.scrollDown();
	  		    contractSearchPage.getSearchBoxesInGrid().get("Contract").sendKeys(contractNumber);
	  		    Thread.sleep(1000);
	  		    HashMap<Integer, HashMap<String, String>> allTableData2 = contractSearchPage.checkGridBodyDetails();
	  			String contractNumber2 = allTableData2.get(1).get("Contract");
	  		    if(contractNumber.equals(contractNumber2)) {
	  		    contractSearchPage.selectStatusCheckBoxInGrid(1).click();
	  		    contractSearchPage.getEditLink(1).click();
	  		    }
	  		   getLienholderTxtField().clear();
	  	       getLienholderTxtField().sendKeys("Bank of America");
	  	       Thread.sleep(2000);
	  	       String eneterdValue = getLeinholderList().get(0).getText();
	  	       getLeinholderList().get(0).click();
	  	       Assert.assertEquals(getLienholderTxtField().getAttribute("value"), eneterdValue);
	  	       getBtnSave().click();
	  	       Assert.assertTrue(getDataFromDB(contractNumber).get(1).get("LIENHOLDER").equalsIgnoreCase(eneterdValue));
	  	    }
	  		
	        @Test(priority = 28)
	  		public void verifyLienHolderAfterSelectingNotOnTheLink_15379_15396_15436() throws Exception {
	        	login.login(prop.getProperty("username1"), prop.getProperty("password"));
	    		Assert.assertEquals(getTitle().getText(), "Welcome to your AUL ADL Portal!");
	    		verticalMenu.navigatetoContract();
	    		singleContract.singleContract();
	    	    verticalMenu.navigatetoLeftMenu("Contracts", "Contract Search");
	  		    Thread.sleep(1000);
	  		    Assert.assertTrue((getContractSearchPagetitle()).isDisplayed());
	  		    utils.scrollDown();
	  		    HashMap<Integer, HashMap<String, String>> allTableData = contractSearchPage.checkGridBodyDetails();
	  		    contractSearchPage.getSelectStatus().click();
	  		    contractSearchPage.getEnteredStatusChkbox().click();
	  		    String contractNumber = allTableData.get(1).get("Contract");
	  			utils.scrollDown();
	  		    contractSearchPage.getSearchBoxesInGrid().get("Contract").sendKeys(contractNumber);
	  		    Thread.sleep(1000);
	  		    HashMap<Integer, HashMap<String, String>> allTableData2 = contractSearchPage.checkGridBodyDetails();
	  			String contractNumber2 = allTableData2.get(1).get("Contract");
	  		    if(contractNumber.equals(contractNumber2)) {
	  		    contractSearchPage.selectStatusCheckBoxInGrid(1).click();
	  		    contractSearchPage.getEditLink(1).click();
	  		    }
	  		   Thread.sleep(2000);
	  		   Assert.assertTrue(getLienholderTxtField().isDisplayed());
	  		   getLienholderTxtField().click();
	  		   Assert.assertTrue(getLienholderTxtField().getAttribute("placeholder").equals("Type & Select a Lienholder"));
	  		   getNotOnTheListLink().isDisplayed();
	  		   getNotOnTheListLink().click();
	  		   Thread.sleep(2000);
	  		   getLienholderTxtFieldForNotOnTheLink().clear();
	  		   getLienholderTxtFieldForNotOnTheLink().sendKeys("@!#$");
	  	       Assert.assertEquals(getLienholderTxtFieldForNotOnTheLink().getAttribute("value"),"@!#$" );
	  	       Assert.assertTrue(getShowLienholderListLink().isDisplayed());
	  	       Assert.assertTrue(getLeinholderList().size() == 0);
	  	       getBtnSave().click();
	 	       getDriver().switchTo().defaultContent();
	 	       Assert.assertTrue(getContractSubmittedSuccessTxt().isDisplayed(),"System allows the character");
	        }
	        
	        @Test(priority = 29)
	  		public void verifySaveCancelAndPageRedirection_15510_15511_15512() throws Exception {
	  	    	login.login(prop.getProperty("username1"), prop.getProperty("password"));
	  			Assert.assertEquals(getTitle().getText(), "Welcome to your AUL ADL Portal!");
	  		    verticalMenu.navigatetoLeftMenu("Contracts", "Contract Search");
	  		    Thread.sleep(1000);
	  		    Assert.assertTrue((getContractSearchPagetitle()).isDisplayed());
	  		    utils.scrollDown();
	  		    HashMap<Integer, HashMap<String, String>> allTableData = contractSearchPage.checkGridBodyDetails();
	  		    contractSearchPage.getSelectStatus().click();
	  		    contractSearchPage.getEnteredStatusChkbox().click();
	  		    String contractNumber = allTableData.get(1).get("Contract");
	  			utils.scrollDown();
	  		    contractSearchPage.getSearchBoxesInGrid().get("Contract").sendKeys(contractNumber);
	  		    Thread.sleep(1000);
	  		    HashMap<Integer, HashMap<String, String>> allTableData2 = contractSearchPage.checkGridBodyDetails();
	  			String contractNumber2 = allTableData2.get(1).get("Contract");
	  		    if(contractNumber.equals(contractNumber2)) {
	  		    contractSearchPage.selectStatusCheckBoxInGrid(1).click();
	  		    contractSearchPage.getEditLink(1).click();
	  		    }
	  		    Assert.assertTrue(getEditContractPagetitle().isDisplayed());
	  		    Assert.assertTrue(getBtnSave().isDisplayed());
	  		    Assert.assertTrue(getBtnCancel().isDisplayed());
	  		    getBtnCancel().click();
	  		    Thread.sleep(2000);
	  		    Assert.assertTrue((getContractSearchPagetitle()).isDisplayed());
	        }
	        
//	        @Test(priority = 30)
//	  		public void verify() throws Exception {
//	  	    	login.login(prop.getProperty("username1"), prop.getProperty("password"));
//	  			Assert.assertEquals(getTitle().getText(), "Welcome to your AUL ADL Portal!");
//	  		    verticalMenu.navigatetoLeftMenu("Contracts", "Contract Search");
//	  		    Thread.sleep(1000);
//	  		    Assert.assertTrue((getContractSearchPagetitle()).isDisplayed());
//	  		    utils.scrollDown();
//	  		    HashMap<Integer, HashMap<String, String>> allTableData = contractSearchPage.checkGridBodyDetails();
//	  		    contractSearchPage.getSelectStatus().click();
//	  		    contractSearchPage.getEnteredStatusChkbox().click();
//	  		    String contractNumber = allTableData.get(1).get("Contract");
//	  			utils.scrollDown();
//	  		    contractSearchPage.getSearchBoxesInGrid().get("Contract").sendKeys(contractNumber);
//	  		    Thread.sleep(1000);
//	  		    HashMap<Integer, HashMap<String, String>> allTableData2 = contractSearchPage.checkGridBodyDetails();
//	  			String contractNumber2 = allTableData2.get(1).get("Contract");
//	  		    if(contractNumber.equals(contractNumber2)) {
//	  		    contractSearchPage.selectStatusCheckBoxInGrid(1).click();
//	  		    contractSearchPage.getEditLink(1).click();
//	  		    }
//	  		    Assert.assertTrue(getEditContractPagetitle().isDisplayed());
//	  		   
//	        }
	  		
	  	    
	@AfterMethod
	public void close() throws InterruptedException {
		login.logout();
	}


}
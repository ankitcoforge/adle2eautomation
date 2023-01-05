package testsuite;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageActions.EmployeePacksAction;
import pageActions.impersonateAction;
import pageActions.loginAction;
import pageActions.singleContractAction;
import pageActions.verticalMenuAction;
import pageObjects.impersonatepo;
import utils.utilityClass;

public class EmployeePacks_test extends EmployeePacksAction{
	loginAction login = new loginAction();
	verticalMenuAction verticalMenu = new verticalMenuAction();
	
	utilityClass utils = new utilityClass();
	impersonateAction impersonate = new impersonateAction ();
	singleContractAction contract =new singleContractAction();

	@BeforeClass(alwaysRun=true)
	public void login() throws InterruptedException {
		navigate();
		Assert.assertEquals(login.getTitle(), "AUL Corp.");
	}
	
	@Test(priority = 1)
	public void verifyNewPackPopupOpened_31999() throws Exception {
		login.login(prop.getProperty("dealerAutomation"), prop.getProperty("password"));
		Assert.assertEquals(getPortalTitle().getText(), "Welcome to your AUL ADL Portal!");
		Thread.sleep(2000);
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Dealer Packs");
		Thread.sleep(2000);
		Assert.assertTrue(getDealerPacksPageTitle().isDisplayed());
		getBtnNewPack().click();
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(getPopup()));
		getBtnCloseForPopup().click();
	}
	
	@Test(priority = 2)
	public void verifyNewPackCreation_32000() throws Exception {
		login.login(prop.getProperty("dealerAutomation"), prop.getProperty("password"));
		Assert.assertEquals(getPortalTitle().getText(), "Welcome to your AUL ADL Portal!");
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Dealer Packs");
		Thread.sleep(2000);
		Assert.assertTrue(getDealerPacksPageTitle().isDisplayed());
		getBtnNewPack().click();
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(getPopup()));
	    getArrow().click();
		selectProgram();
		getPackAmount().sendKeys("100");
		getBtnSave().click();
		Thread.sleep(2000);
		Assert.assertTrue(getSuccessMsg().isDisplayed());
	}
	
	@Test(priority = 3)
	public void verifyEditFunctionality_32001() throws Exception {
		login.login(prop.getProperty("dealerAutomation"), prop.getProperty("password"));
		Assert.assertEquals(getPortalTitle().getText(), "Welcome to your AUL ADL Portal!");
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Dealer Packs");
		Thread.sleep(2000);
		Assert.assertTrue(getDealerPacksPageTitle().isDisplayed());
		if(getRows().size()>1) {
		HashMap<Integer, HashMap<String, WebElement>> allTableData = checkGridBodyDetails();
		HashMap<Integer, HashMap<String, String>> allTableDataTxt = checkGridBodyDetailsTxt();
		Thread.sleep(2000);
		allTableData.get(1).get("Edit").click();
        Thread.sleep(2000);
        getPackAmount().clear();
		String packAmountEdited = "10";
		getPackAmount().sendKeys(packAmountEdited);
		getBtnSave().click();
		Thread.sleep(5000);
	     verticalMenu.navigatetoLeftMenu("Dashboard");
	     Thread.sleep(2000);
	     verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Dealer Packs");
	     Thread.sleep(10000);
		 String packAmountInGrid = allTableDataTxt.get(1).get("Pack Amount");
		NumberFormat format = NumberFormat.getCurrencyInstance();
		Number number = format.parse(packAmountInGrid);
		String packAmountInGridValue = number.toString();
		Assert.assertTrue(packAmountEdited.equals(packAmountInGridValue));
		}
	}
	
	@Test(priority = 4)
	public void verifySearchBoxes_32002() throws Exception {
		login.login(prop.getProperty("dealerAutomation"), prop.getProperty("password"));
		Assert.assertEquals(getPortalTitle().getText(), "Welcome to your AUL ADL Portal!");
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Dealer Packs");
		Thread.sleep(2000);
		Assert.assertTrue(getDealerPacksPageTitle().isDisplayed());
		
		HashMap<Integer, HashMap<String, WebElement>> allTableData = checkGridBodyDetails();
		HashMap<Integer, HashMap<String, String>> allTableDataTxt = checkGridBodyDetailsTxt();
		String[] programFirstLetter =allTableData.get(1).get("Program").getText().split("");
		getSearchBoxesInGrid().get("Program").sendKeys(programFirstLetter[0]);
		Thread.sleep(2000);
			String elementTxt = allTableDataTxt.get(1).get("Program");
			Assert.assertTrue(elementTxt.startsWith(programFirstLetter[0]));
		getSearchBoxesInGrid().get("Program").sendKeys(Keys.BACK_SPACE);
		Thread.sleep(2000);
	
		String packAmountInGrid = allTableDataTxt.get(1).get("Pack Amount");
		NumberFormat format = NumberFormat.getCurrencyInstance();
		Number number = format.parse(packAmountInGrid);
		String packAmountValue = number.toString();

		getSearchBoxesFromPackAmount().get("Pack Amount").sendKeys(packAmountValue);
		Thread.sleep(2000);
			String elementTxt1 = allTableDataTxt.get(1).get("Pack Amount");
			Assert.assertTrue(elementTxt1.equals(packAmountInGrid));
		
		getSearchBoxesFromPackAmount().get("Pack Amount").clear();
		Thread.sleep(2000);
		
		String[] programCodeFirstLetter =allTableDataTxt.get(1).get("Program Code").split("");
		getSearchBoxesInGrid().get("Program Code").sendKeys(programCodeFirstLetter[0]);
		Thread.sleep(2000);
			String elementTxtProgramCode = allTableDataTxt.get(1).get("Program Code");
			Assert.assertTrue(elementTxtProgramCode.startsWith(programCodeFirstLetter[0]));
		getSearchBoxesInGrid().get("Program Code").sendKeys(Keys.BACK_SPACE);
		Thread.sleep(2000);
		
		String[] modifiedByFirstLetter =allTableDataTxt.get(1).get("Modified By").split("");
		getSearchBoxesFromPackAmount().get("Modified By").sendKeys(modifiedByFirstLetter[0]);
		Thread.sleep(2000);
		for (int i = 1; i <= getRows().size(); i++) {
			String elementTxtModifiedByFirstLetter = allTableDataTxt.get(1).get("Modified By");
			Assert.assertTrue(elementTxtModifiedByFirstLetter.startsWith(modifiedByFirstLetter[0]));
		}
		getSearchBoxesFromPackAmount().get("Modified By").sendKeys(Keys.BACK_SPACE);
		Thread.sleep(2000);
	}

	
	
	@Test(priority = 5)
	public void verifyDealerPackImpactsContractCreationPage_32013() throws Exception {
		login.login(prop.getProperty("dealerAutomation"), prop.getProperty("password"));
		Assert.assertEquals(getPortalTitle().getText(), "Welcome to your AUL ADL Portal!");
		verticalMenu.navigatetoContract();
		
		String programCode = prop.getProperty("dealerProgramCode");
		String program = prop.getProperty("dealerProgram");
		
		String priceTobeEnteredInStringFormat = "100";
		 Integer vehiclePriceBefore = getVehiclePrice(programCode);
		System.out.println("vehicle Price before------"+vehiclePriceBefore);
		verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Dealer Packs");
		Thread.sleep(2000);
		int priceTobeEntered =Integer.parseInt(priceTobeEnteredInStringFormat);
		if(getRows().size()>1) {
		HashMap<Integer, HashMap<String, WebElement>> allTableData = checkGridBodyDetails();
		HashMap<Integer, HashMap<String, String>> allTableData1 = checkGridBodyDetailsTxt();
	    System.out.println("map2 is"+allTableData1);
		ArrayList<String> list = new ArrayList<String>();
		for(int i=1; i<=getRows().size(); i++) {
			String menuItem = allTableData1.get(i).get("Program Code");
			list.add(menuItem);
		}
		System.out.print("list is"+list);
		for(int i=1;i<getRows().size();i++) {
		if(list.contains(programCode))
		{
			allTableData.get(i).get("Edit").click();
	        editPack(program,priceTobeEnteredInStringFormat);
	        driver.navigate().refresh();
	        verticalMenu.navigatetoContract();
		}
		else if(!list.contains(programCode)){
			createNewPack(program,priceTobeEnteredInStringFormat);
			verticalMenu.navigatetoContract();
		}	
		}
		}
		else {
			createNewPack(program,priceTobeEnteredInStringFormat);
			verticalMenu.navigatetoContract();
		}
	    Thread.sleep(5000);
	    System.out.println("hellooooooo");
		//verticalMenu.navigatetoContract();
		 Integer vehiclePriceBeforeAfter = getVehiclePrice(programCode);
			System.out.println("vehicle Price after------"+vehiclePriceBeforeAfter);
			vehiclePriceBeforeAfter = vehiclePriceBefore + priceTobeEntered;
	}	
		
	
		@Test(priority = 6)
		public void verifyLenderPackImpactsContractCreationPage_32014() throws Exception {
			login.login(prop.getProperty("adminusername"), prop.getProperty("password"));
			Assert.assertEquals(getPortalTitle().getText(), "Welcome to your AUL ADL Portal!");
			verticalMenu.navigatetoimpersonate();
			impersonate.impersonateUser("Lender", "3641");
			Thread.sleep(5000);
			verticalMenu.navigatetoContract();
			contract.getSelectDealerTogenerateContract("#1 Auto Liquidators LLC");
			String programCode = prop.getProperty("lenderProgramCode");
			String program = prop.getProperty("lenderProgramCode");
			 Integer vehiclePriceBefore = getVehiclePriceForLender(programCode);
			System.out.println("vehicle Price before------"+vehiclePriceBefore);
			verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Lender Packs");
			Thread.sleep(2000);
			String priceTobeEnteredInStringFormat = "100";
			int priceTobeEntered =Integer.parseInt(priceTobeEnteredInStringFormat);
			if(getRows().size()>1) {
			HashMap<Integer, HashMap<String, WebElement>> allTableData = checkGridBodyDetails();
			HashMap<Integer, HashMap<String, String>> allTableData1 = checkGridBodyDetailsTxt();
		    System.out.println("map2 is"+allTableData1);
			ArrayList<String> list = new ArrayList<String>();
			for(int i=1; i<=getRows().size(); i++) {
				String menuItem = allTableData1.get(i).get("Program Code");
				list.add(menuItem);
			}
			System.out.print("list is"+list);
			for(int i=1;i<getRows().size();i++) {
			if(list.contains(programCode))
			{
				allTableData.get(i).get("Edit").click();
		        editPack(programCode,priceTobeEnteredInStringFormat);
			}
			else if(!list.contains(programCode)){
				createNewPack(program,priceTobeEnteredInStringFormat);
			}	
			}
			}
			else {
				createNewPack(program,priceTobeEnteredInStringFormat);
			}
		    Thread.sleep(5000);
			verticalMenu.navigatetoContract();
			 Integer vehiclePriceBeforeAfter = getVehiclePriceForLender(programCode);
			System.out.println("vehicle Price after------"+vehiclePriceBeforeAfter);
			vehiclePriceBeforeAfter = vehiclePriceBefore + priceTobeEntered;
		}
		
		@Test(priority = 7)
		public void verifyDealerPackImpactsContractCreationPageThroughAgentLogin_32015() throws Exception {
			login.login(prop.getProperty("agentAutomation"), prop.getProperty("password"));
			Assert.assertEquals(getPortalTitle().getText(), "Welcome to your AUL ADL Portal!");
			Thread.sleep(5000);
			String programCode = prop.getProperty("agentProgramCode");
			String program = prop.getProperty("agentProgram");
			
			verticalMenu.navigatetoContract();
			contract.getSelectDealerTogenerateContract("Angel Motors Inc");
			 Integer vehiclePriceBefore = getVehiclePrice(programCode);
			
			System.out.println("vehicle Price before------"+vehiclePriceBefore);
			 Thread.sleep(2000);
			verticalMenu.navigatetoLeftMenu("Dealer Settings", "Manage My Dealer Packs");
			selectDealerName("Angel Motors Inc");
			Thread.sleep(2000);
			String priceTobeEnteredInStringFormat = "100";
			int priceTobeEntered =Integer.parseInt(priceTobeEnteredInStringFormat);
			if(getRows().size()>1) {
			HashMap<Integer, HashMap<String, WebElement>> allTableData = checkGridBodyDetails();
			HashMap<Integer, HashMap<String, String>> allTableData1 = checkGridBodyDetailsTxt();
		    System.out.println("map2 is"+allTableData1);
			ArrayList<String> list = new ArrayList<String>();
			for(int i=1; i<=getRows().size(); i++) {
				String menuItem = allTableData1.get(i).get("Program Code");
				list.add(menuItem);
			}
			System.out.print("list is"+list);
			for(int i=1;i<getRows().size();i++) {
			if(list.contains(programCode))
			{
				allTableData.get(i).get("Edit").click();
		        editPack(program,priceTobeEnteredInStringFormat);
		        verticalMenu.navigatetoContract();
			}
			else if(!list.contains(programCode)){
				createNewPack(program,priceTobeEnteredInStringFormat);
				verticalMenu.navigatetoContract();
			}	
			}
			}
			else {
				createNewPack(programCode,priceTobeEnteredInStringFormat);
				verticalMenu.navigatetoContract();
			}
		    Thread.sleep(5000);
			
			 Integer vehiclePriceBeforeAfter = getVehiclePrice(programCode);
				System.out.println("vehicle Price after------"+vehiclePriceBeforeAfter);
				vehiclePriceBeforeAfter = vehiclePriceBefore + priceTobeEntered;	
		}
		
		@Test(priority = 8)
		public void verifyDealerPackImpactsContractCreationPageThroughSubAgentLogin_32116() throws Exception {
			login.login(prop.getProperty("subagentAutomation"), prop.getProperty("password"));
			Assert.assertEquals(getPortalTitle().getText(), "Welcome to your AUL ADL Portal!");
			Thread.sleep(5000);
			String programCode = prop.getProperty("agentProgramCode");
			String program = prop.getProperty("agentProgram");
			
			verticalMenu.navigatetoContract();
			contract.getSelectDealerTogenerateContract("Angel Motors Inc");
			 Integer vehiclePriceBefore = getVehiclePrice(programCode);
			
			System.out.println("vehicle Price before------"+vehiclePriceBefore);
			 Thread.sleep(2000);
			verticalMenu.navigatetoLeftMenu("Dealer Settings", "Manage My Dealer Packs");
			selectDealerName("Angel Motors Inc");
			Thread.sleep(2000);
			String priceTobeEnteredInStringFormat = "100";
			int priceTobeEntered =Integer.parseInt(priceTobeEnteredInStringFormat);
			if(getRows().size()>1) {
			HashMap<Integer, HashMap<String, WebElement>> allTableData = checkGridBodyDetails();
			HashMap<Integer, HashMap<String, String>> allTableData1 = checkGridBodyDetailsTxt();
		    System.out.println("map2 is"+allTableData1);
			ArrayList<String> list = new ArrayList<String>();
			for(int i=1; i<=getRows().size(); i++) {
				String menuItem = allTableData1.get(i).get("Program Code");
				list.add(menuItem);
			}
			System.out.print("list is"+list);
			for(int i=1;i<getRows().size();i++) {
			if(list.contains(programCode))
			{
				allTableData.get(i).get("Edit").click();
		        editPack(program,priceTobeEnteredInStringFormat);
		        verticalMenu.navigatetoContract();
			}
			else if(!list.contains(programCode)){
				createNewPack(program,priceTobeEnteredInStringFormat);
				verticalMenu.navigatetoContract();
			}	
			}
			}
			else {
				createNewPack(programCode,priceTobeEnteredInStringFormat);
				verticalMenu.navigatetoContract();
			}
		    Thread.sleep(5000);
			 Integer vehiclePriceBeforeAfter = getVehiclePrice(programCode);
				System.out.println("vehicle Price after------"+vehiclePriceBeforeAfter);
				vehiclePriceBeforeAfter = vehiclePriceBefore + priceTobeEntered;	
		}
		
		@Test(priority = 9)
		public void verifyDeleteFunctionality_32003() throws Exception {
			login.login(prop.getProperty("dealerAutomation"), prop.getProperty("password"));
			Assert.assertEquals(getPortalTitle().getText(), "Welcome to your AUL ADL Portal!");
			verticalMenu.navigatetoLeftMenu("My Settings", "Manage My Dealer Packs");
			Thread.sleep(2000);
			Assert.assertTrue(getDealerPacksPageTitle().isDisplayed());
			HashMap<Integer, HashMap<String, String>> allTableDataTxt = checkGridBodyDetailsTxt();
			Thread.sleep(2000);
			String programCode =allTableDataTxt.get(1).get("Program Code");
			System.out.println("code is--------"+programCode);
			getSelectCheckBoxes().get(0).click();
			getDeleteLink().click();
			getBtnYes().click();
			Thread.sleep(2000);
			driver.navigate().refresh();
			Thread.sleep(2000);
			HashMap<Integer, HashMap<String, String>> allTableDataTxtNew = checkGridBodyDetailsTxt();
			if(!((getRows().size()) == 0))
			{
		    Assert.assertFalse(allTableDataTxtNew.get(1).get("Program Code").equals(programCode));;
		   }

		}

	
	 @AfterMethod(alwaysRun=true)
	    public void close() throws InterruptedException {
	        login.logout();
	    }
	 
	 


}
package pageActions;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import pageObjects.LateralMenupo;
import utils.utilityClass;

public class LateralMenuAction extends LateralMenupo{
	
	utilityClass utils = new utilityClass();
	loginAction login = new loginAction();
	verticalMenuAction verticalMenu = new verticalMenuAction();
	impersonateAction impersonate = new impersonateAction ();
	PermissionsAction permissions=new PermissionsAction();
	
	 public WebElement getTitle() {
		 WebElement welcomeTitle=driver.findElement(By.xpath(title));	
		 return welcomeTitle;
	 }
	 
	 public WebElement getLateralMenu() {
		 WebElement latMenu=driver.findElement(By.cssSelector(lateralMenu));	
		 return latMenu;
	 }
	 public List<WebElement> getLateralMenuItems1 () {
		  List<WebElement> menuItems = driver.findElements(By.cssSelector(lateralMenuItems1));	
		 return menuItems;
	 }
	 
	 public List<WebElement> getLateralMenuItems2 () {
		  List<WebElement> menuItems = driver.findElements(By.cssSelector(lateralMenuItems2));	
		 return menuItems;
	 }
	 
	 public List<WebElement> getLaterMenuSubItems () {
		  List<WebElement> subItems = driver.findElements(By.cssSelector(laterMenuSubItems));	
		 return subItems;
	 }
	 
	 public List<WebElement> getThirdSubMenuItems () {
		  List<WebElement> superSubItems = driver.findElements(By.cssSelector(thirdSubMenuItems));	
		 return superSubItems;
	 }
	 
		public WebElement getRateContractTitle() {
			 WebElement rateContract=driver.findElement(By.xpath(rateContractTitle));	
			 return rateContract;
		 }
		
		public WebElement getQuoteHistoryTitle() {
			 WebElement quoteHistory=driver.findElement(By.xpath(quoteHistoryTitle));	
			 return quoteHistory;
		 }
		
		public WebElement getCancellationQuoteTitle() {
			 WebElement quote=driver.findElement(By.xpath(cancellationQuoteTitle));	
			 return quote;
		 }
		
		public WebElement getCancellationHistoryTitle() {
			 WebElement history=driver.findElement(By.xpath(cancellationHistoryTitle));	
			 return history;
		 }
		
		public WebElement getMenu(String a, String name) {
	 		
	 		String d = "//"+a+"[contains(text(),'" + name +"')]";

	 		return(driver.findElement(By.xpath(d)));
	 	}
		
		public WebElement getAULlogo() {
			 WebElement logo=driver.findElement(By.xpath(aulLogo));	
			 return logo;
		 }
		
		public WebElement getcontractSearchPageTitle() {
			 WebElement contractSearch=driver.findElement(By.xpath(contractSearchTitle));	
			 return contractSearch;
		 }
		
		public WebElement getDashboardTitle() {
			 WebElement dashboardTitleInPage=driver.findElement(By.xpath(dashboardTitle));	
			 return dashboardTitleInPage;
		 }
		
		public WebElement getGenerateQuoteTxt() {
			 WebElement generateQuoteTitle=driver.findElement(By.xpath(generateQuoteTxt));	
			 return generateQuoteTitle;
		 }
		
		public void verifyContentInPDfForLateralMenuOptions(String url, String program) {
			//specify the url of the pdf file
			try {
				String pdfContent = readPdfContent(url);
					Assert.assertTrue(pdfContent.contains(program));
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		
		
		
		public WebElement getNewuserBtn() {
			 WebElement newuser=driver.findElement(By.xpath(newuserBtn));	
			 return newuser;
		 }
		
		 public WebElement getNewExceptionBtn() {
			 WebElement newException=driver.findElement(By.xpath(newExceptionBtn));	
			 return newException;
		 }
		
		public WebElement getNewuserPopupHeader() {
			 WebElement newuser=driver.findElement(By.xpath(newuserPopupHeader));	
			 return newuser;
		 }
		
		public WebElement getNewUserBtnClose() {
			 WebElement newuser=driver.findElement(By.xpath(newuserBtnClose));	
			 return newuser;
		 }
		
		public WebElement getDashboardPageReports(String subheading) throws InterruptedException {
			driver.switchTo().activeElement();
			WebElement ele = utils.getfield("h4", subheading);
            return ele;
		}
		
		public void getDefaultpermissionForDealerEmp() throws InterruptedException {
			login.login(prop.getProperty("dealerAutomation"), prop.getProperty("password"));
			Thread.sleep(3000);
			verticalMenu.navigatetoLeftMenu("My Settings", "Issue New User Registration");
			Thread.sleep(2000);
			Assert.assertTrue(utils.getTitle("Issue New User Registration").isDisplayed());
			String dealerEmp = prop.getProperty("dealerempAutomation");
			utils.inputfield("cssselector", permissions.txtFieldNewUserRegistration, dealerEmp);
			Thread.sleep(2000);
			utils.clickfield("xpath", permissions.editBtn);
			Thread.sleep(1000);
			utils.clickfield("xpath", permissions.permissionsDropdownInPopup);
			//permissions.getPermissionListInPopup().get(12).click();
			if (permissions.getSelectAllCheckBoxInPopup().getAttribute("aria-checked").equals("false")) {
				permissions.getSelectAllCheckBoxInPopup().click();
			}
			utils.clickfield("xpath", permissions.saveBtn);
			Thread.sleep(5000);
			login.logout();
			Thread.sleep(10000);
		}
public void getDefaultpermissionForsubAgent() throws InterruptedException {
	login.login(prop.getProperty("agentAutomation"), prop.getProperty("password"));
	Thread.sleep(3000);
	verticalMenu.navigatetoLeftMenu("Agency Settings", "Manage Users");
	Thread.sleep(2000);
	String subAgent = prop.getProperty("subagentAutomation");
	utils.inputfield("cssselector", permissions.txtFieldNewUserRegistration, subAgent);
	Thread.sleep(2000);
	utils.clickfield("xpath", permissions.editBtn);
	Thread.sleep(1000);
	utils.clickfield("xpath", permissions.permissionsDropdownInAgentPopup);
	if (permissions.getSelectAllCheckBoxInPopup().getAttribute("aria-checked").equals("false")) {
		permissions.getSelectAllCheckBoxInPopup().click();
	}
	Assert.assertTrue((permissions.getSelectAllCheckBoxInPopup().getAttribute("aria-checked").equals("true")));
	utils.clickfield("xpath", permissions.saveBtn);
	Thread.sleep(5000);
	login.logout();
	Thread.sleep(10000);
	
			
		}
public void getDefaultpermissionForLenderEmp() throws InterruptedException {
	login.login(prop.getProperty("lenderAutomation"), prop.getProperty("password"));
	Thread.sleep(3000);
	verticalMenu.navigatetoLeftMenu("Lender Settings", "Manage Agency Users");
	Thread.sleep(2000);
	String lenderEmp = prop.getProperty("lenderempAutomation");
	utils.inputfield("cssselector", permissions.txtFieldNewUserRegistration, lenderEmp);
	Thread.sleep(5000);
	utils.clickfield("xpath", permissions.editBtn);
	Thread.sleep(2000);
	utils.clickfield("xpath", permissions.permissionsDropdownInAgentPopup);
	permissions.getPermissionListInPopup().get(12).click();
	if (permissions.getSelectAllCheckBoxInPopup().getAttribute("aria-checked").equals("false")) {
		permissions.getSelectAllCheckBoxInPopup().click();
	}
	utils.clickfield("xpath", permissions.updateBtn);
	Thread.sleep(5000);
	login.logout();
	Thread.sleep(5000);
}
public void getDefaultpermissionForDealerGrpEmp() throws InterruptedException {
	login.login(prop.getProperty("dealergrpAutomation"), prop.getProperty("password"));
	Thread.sleep(3000);
	verticalMenu.navigatetoLeftMenu("My Settings", "Issue New User Registration");
	Thread.sleep(2000);
	String dealergrpempAutomation = prop.getProperty("dealergrpempAutomation");
	utils.inputfield("cssselector", permissions.txtFieldNewUserRegistration, dealergrpempAutomation);
	Thread.sleep(2000);
	utils.clickfield("xpath", permissions.editBtn);
	Thread.sleep(2000);
	utils.clickfield("xpath", permissions.permissionsDropdownInAgentPopup);
	permissions.getPermissionListInPopup().get(12).click();
	if (permissions.getSelectAllCheckBoxInPopup().getAttribute("aria-checked").equals("false")) {
		permissions.getSelectAllCheckBoxInPopup().click();
	}
	utils.clickfield("xpath", permissions.saveBtn);
	Thread.sleep(5000);
	login.logout();
	Thread.sleep(5000);
}
		
		
}

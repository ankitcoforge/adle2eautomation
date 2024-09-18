package testsuite;

import java.util.ArrayList;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageActions.PacksPassthroughAction;
import pageActions.impersonateAction;
import pageActions.loginAction;
import pageActions.verticalMenuAction;
import utils.XmlDataReader;
import utils.utilityClass;

/* 36299*/
/* Total no: of Tc's- 33 */
public class PackPassthroughPermissionModal_test extends PacksPassthroughAction{
	loginAction login = new loginAction();
	verticalMenuAction verticalMenu = new verticalMenuAction();
	utilityClass utils = new utilityClass();
	impersonateAction impersonate = new impersonateAction ();
	XmlDataReader UtilsDataReader = new XmlDataReader("UtilsData");
	Permissions_test permissions=new Permissions_test();

	@BeforeMethod(alwaysRun = true)
	public void login() throws InterruptedException {
		navigate();
		Assert.assertEquals(login.getTitle(), "Protective");
	}

	
	@Test(priority = 1)
	public void verifyShowPackPassThroughONandOFFfuctionalityForDealer_36871_36841_36835_36852_36838() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		verticalMenu.navigatetoimpersonate();
		impersonate.getUsers("Dealer", "28771");
		utils.element("xpath", impersonate.registrationStatusArrowForSort).click();
		utils.wait(5000);
		for (int i=0;i<impersonate.getPackPassthroughBtn().size(); i++) {
		if(!impersonate.getPackPassthroughBtn().get(i).getAttribute("Class").equals("button button__checked")) {
		impersonate.getPackPassthroughBtn().get(i).click();
		utils.waitTillElementIsClickableByWebEle(getArrowInshowpackModel());
		Assert.assertTrue(utils.getfield("h3", "Dealer Passthrough Permissions").isDisplayed());
		Assert.assertTrue(utils.getfield("span", "User").isDisplayed());
		Assert.assertTrue(utils.getfield("label", "My Dealer Passthrough").isDisplayed());
		Assert.assertTrue(permissions.getSaveBtn().getAttribute("disabled").equals("true"));
		getArrowInshowpackModel().click();
		permissions.getSelectCheckBoxInPopup().get(1).click();
		permissions.getSaveBtn().click();
		utils.wait(5000);
		impersonate.getPackPassthroughBtn().get(i).click();
		utils.getfield("span", "Continue")	.click();
		utils.wait(5000);
		impersonate.getImpersonateList().get(i).click();
		utils.wait(5000);
		verticalMenu.navigatetoLeftMainMenu("Report");
		ArrayList<String> list = new ArrayList<String>();
		for(int j=0; j<verticalMenu.getLaterMenuSubItems().size(); j++) {
			 String menuItem = verticalMenu.getLaterMenuSubItems().get(j).getText();
			list.add(menuItem);
		}
		System.out.println("list is--"+list);
		Assert.assertFalse(list.contains("My Dealer Passthrough"));
		break;
		}
		}
	}
	

	@Test(priority = 2)
	public void verifyShowPackPassThroughONandOFFfuctionalityForLender_36876_36842_36836_36854_36839() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		verticalMenu.navigatetoimpersonate();
		impersonate.getUsers("Lender", "3641");
		utils.element("xpath", impersonate.registrationStatusArrowForSort).click();
		utils.wait(5000);
		for (int i=0;i<impersonate.getPackPassthroughBtn().size(); i++) {
		if(!impersonate.getPackPassthroughBtn().get(i).getAttribute("Class").equals("button button__checked")) {
		impersonate.getPackPassthroughBtn().get(i).click();
		utils.waitTillElementIsClickableByWebEle(getArrowInshowpackModel());
		Assert.assertTrue(utils.getfield("h3", "Lender Passthrough Permissions").isDisplayed());
		Assert.assertTrue(utils.getfield("span", "User").isDisplayed());
		Assert.assertTrue(utils.getfield("label", "My Lender Passthrough").isDisplayed());
		Assert.assertTrue(permissions.getSaveBtn().getAttribute("disabled").equals("true"));
		getArrowInshowpackModel().click();
		permissions.getSelectCheckBoxInPopup().get(0).click();
		permissions.getSaveBtn().click();
		utils.wait(5000);
		impersonate.getPackPassthroughBtn().get(i).click();
		utils.getfield("span", "Continue")	.click();
		utils.wait(5000);
		impersonate.getImpersonateList().get(i).click();
		utils.wait(5000);
		verticalMenu.navigatetoLeftMainMenu("Report");
		ArrayList<String> list = new ArrayList<String>();
		for(int j=0; j<verticalMenu.getLaterMenuSubItems().size(); j++) {
			 String menuItem = verticalMenu.getLaterMenuSubItems().get(j).getText();
			list.add(menuItem);
		}
		System.out.println("list is--"+list);
		Assert.assertFalse(list.contains("My Lender Passthrough"));
		break;
		}
		}
	}

	
	@Test(priority = 3)
	public void verifyShowPackPassThroughONandOFFfuctionalityForAgent_36866_36840_36834_36844_36837() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		verticalMenu.navigatetoimpersonate();
		impersonate.getUsers("Agent", "393");
		utils.element("xpath", impersonate.registrationStatusArrowForSort).click();
		utils.wait(5000);
		for (int i=0;i<impersonate.getPackPassthroughBtn().size(); i++) {
		if(!impersonate.getPackPassthroughBtn().get(i).getAttribute("Class").equals("button button__checked")) {
		impersonate.getPackPassthroughBtn().get(i).click();
		utils.wait(10000);
		utils.waitTillElementIsClickableByWebEle(getArrowInshowpackModel());
		Assert.assertTrue(utils.getfield("h3", "My Agent Pack Permissions").isDisplayed());
		Assert.assertTrue(utils.getfield("span", "User").isDisplayed());
		Assert.assertTrue(utils.getfield("label", "My Agent Pack").isDisplayed());
		Assert.assertTrue(permissions.getSaveBtn().getAttribute("disabled").equals("true"));
		getArrowInshowpackModel().click();
		permissions.getSelectCheckBoxInPopup().get(1).click();
		permissions.getSaveBtn().click();
		utils.wait(5000);
		impersonate.getPackPassthroughBtn().get(i).click();
		utils.getfield("span", "Continue")	.click();
		utils.wait(5000);
		impersonate.getImpersonateList().get(i).click();
		utils.wait(30000);
		verticalMenu.navigatetoLeftMainMenu("Report");
		ArrayList<String> list = new ArrayList<String>();
		for(int j=0; j<verticalMenu.getLaterMenuSubItems().size(); j++) {
			 String menuItem = verticalMenu.getLaterMenuSubItems().get(j).getText();
			list.add(menuItem);
		}
		System.out.println("list is--"+list);
		Assert.assertFalse(list.contains("My Agent Pack"));
		break;
		}
		}
	}
	
	@Test(priority = 4)
	public void verifyUserCanSelectOneOrMoreDealerPacksForDealerRole_36848() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		verticalMenu.navigatetoimpersonate();
		impersonate.getUsers("Dealer", "28771");
		utils.element("xpath", impersonate.registrationStatusArrowForSort).click();
		utils.wait(5000);
		for (int i=0;i<impersonate.getPackPassthroughBtn().size(); i++) {
		if(!impersonate.getPackPassthroughBtn().get(i).getAttribute("Class").equals("button button__checked")) {
		impersonate.getPackPassthroughBtn().get(i).click();
		utils.waitTillElementIsClickableByWebEle(getArrowInshowpackModel());
		getArrowInshowpackModel().click();
		permissions.getSelectCheckBoxInPopup().get(1).click();
		permissions.getSaveBtn().click();
		utils.wait(5000);
		impersonate.getPackPassthroughBtn().get(i).click();
		utils.getfield("span", "Continue")	.click();
		utils.wait(5000);
		//selecting more than 1
			impersonate.getPackPassthroughBtn().get(i).click();
			utils.waitTillElementIsClickableByWebEle(getArrowInshowpackModel());
			getArrowInshowpackModel().click();
			permissions.getSelectCheckBoxInPopup().get(0).click();
			permissions.getSelectCheckBoxInPopup().get(1).click();
			permissions.getSaveBtn().click();
			utils.wait(5000);
			impersonate.getPackPassthroughBtn().get(i).click();
			utils.getfield("span", "Continue")	.click();
			utils.wait(5000);
			//selecting all
			impersonate.getPackPassthroughBtn().get(i).click();
			utils.waitTillElementIsClickableByWebEle(getArrowInshowpackModel());
			getArrowInshowpackModel().click();
			permissions.getSelectAllCheckBoxInPopup().click();
			permissions.getSaveBtn().click();
			utils.wait(5000);
			impersonate.getPackPassthroughBtn().get(i).click();
			utils.getfield("span", "Continue")	.click();
			utils.wait(5000);
		break;
		}
		}
	}

	@Test(priority = 5)
	public void verifyUserCanSelectOneOrMoreDealerPacksForAgentRole_36843() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		verticalMenu.navigatetoimpersonate();
		impersonate.getUsers("Agent", "393");
		utils.element("xpath", impersonate.registrationStatusArrowForSort).click();
		utils.wait(5000);
		for (int i=0;i<impersonate.getPackPassthroughBtn().size(); i++) {
		if(!impersonate.getPackPassthroughBtn().get(i).getAttribute("Class").equals("button button__checked")) {
		impersonate.getPackPassthroughBtn().get(i).click();
		utils.waitTillElementIsClickableByWebEle(getArrowInshowpackModel());
		getArrowInshowpackModel().click();
		permissions.getSelectCheckBoxInPopup().get(1).click();
		permissions.getSaveBtn().click();
		utils.wait(5000);
		impersonate.getPackPassthroughBtn().get(i).click();
		utils.getfield("span", "Continue")	.click();
		utils.wait(5000);
		//selecting more than 1
			impersonate.getPackPassthroughBtn().get(i).click();
			utils.waitTillElementIsClickableByWebEle(getArrowInshowpackModel());
			getArrowInshowpackModel().click();
			permissions.getSelectCheckBoxInPopup().get(0).click();
			permissions.getSelectCheckBoxInPopup().get(1).click();
			permissions.getSaveBtn().click();
			utils.wait(5000);
			impersonate.getPackPassthroughBtn().get(i).click();
			utils.getfield("span", "Continue")	.click();
			utils.wait(5000);
			//selecting all
			impersonate.getPackPassthroughBtn().get(i).click();
			utils.waitTillElementIsClickableByWebEle(getArrowInshowpackModel());
			getArrowInshowpackModel().click();
			permissions.getSelectAllCheckBoxInPopup().click();
			permissions.getSaveBtn().click();
			utils.wait(5000);
			impersonate.getPackPassthroughBtn().get(i).click();
			utils.getfield("span", "Continue")	.click();
			utils.wait(5000);
		break;
		}
		}
	}

	@Test(priority = 6)
	public void verifyCancelAndClosebuttonForshowPackModelDealerRole_36869_36867_36870_36868() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		verticalMenu.navigatetoimpersonate();
		impersonate.getUsers("Dealer", "28771");
		utils.element("xpath", impersonate.registrationStatusArrowForSort).click();
		utils.wait(5000);
		for (int i=0;i<impersonate.getPackPassthroughBtn().size(); i++) {
		if(!impersonate.getPackPassthroughBtn().get(i).getAttribute("Class").equals("button button__checked")) {
		impersonate.getPackPassthroughBtn().get(i).click();
		utils.waitTillElementIsClickableByWebEle(getArrowInshowpackModel());
		permissions.getCancelBtn().click();
		Assert.assertFalse(impersonate.getPackPassthroughBtn().get(i).getAttribute("Class").equals("button button__checked"));
		utils.wait(5000);
		impersonate.getPackPassthroughBtn().get(i).click();
		utils.waitTillElementIsClickableByWebEle(getArrowInshowpackModel());
		permissions.getCloseBtn().click();
		Assert.assertFalse(impersonate.getPackPassthroughBtn().get(i).getAttribute("Class").equals("button button__checked"));
		utils.wait(5000);
		impersonate.getImpersonateList().get(i).click();
		utils.wait(5000);
		verticalMenu.navigatetoLeftMainMenu("Report");
		ArrayList<String> list = new ArrayList<String>();
		for(int j=0; j<verticalMenu.getLaterMenuSubItems().size(); j++) {
			 String menuItem = verticalMenu.getLaterMenuSubItems().get(j).getText();
			list.add(menuItem);
		}
		System.out.println("list is--"+list);
		Assert.assertFalse(list.contains("My Dealer Passthrough"));
		break;
		}
		}
	}
	
	@Test(priority = 7)
	public void verifyCancelAndClosebuttonForshowPackModelLenderRole_36874_36872_36875_36873() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		verticalMenu.navigatetoimpersonate();
		impersonate.getUsers("Lender", "3614");
		utils.element("xpath", impersonate.registrationStatusArrowForSort).click();
		utils.wait(5000);
		for (int i=0;i<impersonate.getPackPassthroughBtn().size(); i++) {
		if(!impersonate.getPackPassthroughBtn().get(i).getAttribute("Class").equals("button button__checked")) {
		impersonate.getPackPassthroughBtn().get(i).click();
		utils.waitTillElementIsClickableByWebEle(getArrowInshowpackModel());
		permissions.getCloseBtn().click();
		Assert.assertFalse(impersonate.getPackPassthroughBtn().get(i).getAttribute("Class").equals("button button__checked"));
		utils.wait(5000);
		impersonate.getPackPassthroughBtn().get(i).click();
		utils.waitTillElementIsClickableByWebEle(getArrowInshowpackModel());
		permissions.getCancelBtn().click();
		Assert.assertFalse(impersonate.getPackPassthroughBtn().get(i).getAttribute("Class").equals("button button__checked"));
		utils.wait(5000);
		impersonate.getImpersonateList().get(i).click();
		utils.wait(5000);
		verticalMenu.navigatetoLeftMainMenu("Report");
		ArrayList<String> list = new ArrayList<String>();
		for(int j=0; j<verticalMenu.getLaterMenuSubItems().size(); j++) {
			 String menuItem = verticalMenu.getLaterMenuSubItems().get(j).getText();
			list.add(menuItem);
		}
		System.out.println("list is--"+list);
		Assert.assertFalse(list.contains("My Dealer Passthrough"));
		break;
		}
		}
	}


	@Test(priority = 8)
	public void verifyCancelAndClosebuttonForshowPackModelAgentRole_36863_36861_36864_36862() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		verticalMenu.navigatetoimpersonate();
		impersonate.getUsers("Agent", "393");
		utils.element("xpath", impersonate.registrationStatusArrowForSort).click();
		utils.wait(5000);
		for (int i=0;i<impersonate.getPackPassthroughBtn().size(); i++) {
		if(!impersonate.getPackPassthroughBtn().get(i).getAttribute("Class").equals("button button__checked")) {
		impersonate.getPackPassthroughBtn().get(i).click();
		utils.waitTillElementIsClickableByWebEle(getArrowInshowpackModel());
		permissions.getCloseBtn().click();
		Assert.assertFalse(impersonate.getPackPassthroughBtn().get(i).getAttribute("Class").equals("button button__checked"));
		utils.wait(5000);
		impersonate.getPackPassthroughBtn().get(i).click();
		utils.waitTillElementIsClickableByWebEle(getArrowInshowpackModel());
		permissions.getCancelBtn().click();
		Assert.assertFalse(impersonate.getPackPassthroughBtn().get(i).getAttribute("Class").equals("button button__checked"));
		utils.wait(5000);
		impersonate.getImpersonateList().get(i).click();
		utils.wait(30000);
		verticalMenu.navigatetoLeftMainMenu("Report");
		ArrayList<String> list = new ArrayList<String>();
		for(int j=0; j<verticalMenu.getLaterMenuSubItems().size(); j++) {
			 String menuItem = verticalMenu.getLaterMenuSubItems().get(j).getText();
			list.add(menuItem);
		}
		System.out.println("list is--"+list);
		Assert.assertFalse(list.contains("My Dealer Passthrough"));
		break;
		}
		}
	}
	
	@Test(priority = 9)
	public void verifyPackAccountsSavedInImprsntPageAreShownInDealerpassthroughUI_36853_36855() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		verticalMenu.navigatetoimpersonate();
		impersonate.getUsers("Dealer", "28771");
		utils.element("xpath", impersonate.registrationStatusArrowForSort).click();
		utils.wait(5000);
		for (int i=0;i<impersonate.getPackPassthroughBtn().size(); i++) {
		if(!impersonate.getPackPassthroughBtn().get(i).getAttribute("Class").equals("button button__checked")) {
		impersonate.getPackPassthroughBtn().get(i).click();
		utils.waitTillElementIsClickableByWebEle(getArrowInshowpackModel());
		Assert.assertTrue(utils.getfield("h3", "Dealer Passthrough Permissions").isDisplayed());
		Assert.assertTrue(utils.getfield("span", "User").isDisplayed());
		Assert.assertTrue(utils.getfield("label", "My Dealer Passthrough").isDisplayed());
		Assert.assertTrue(permissions.getSaveBtn().getAttribute("disabled").equals("true"));
		getArrowInshowpackModel().click();
		permissions.getSelectCheckBoxInPopup().get(0).click();
		String selectedPackAccountInImpersonatePage = getpackOptionsInPopup().get(0).getText();
		permissions.getSaveBtn().click();
		utils.wait(5000);
		impersonate.getImpersonateList().get(i).click();
		utils.wait(5000);
		verticalMenu.navigatetoLeftMenu("Report","My Dealer Passthrough");
		selectAccountInMydealerPassthroughPage().click();
		String optionDisplayedMydealerPassthrouhUI = dropdownAccountOptionsInPassthroughPage().get(0).getText();
		Assert.assertTrue(selectedPackAccountInImpersonatePage.equals(optionDisplayedMydealerPassthrouhUI));
		break;
		}
		}
	}
	
	@Test(priority = 10)
	public void verifyPackAccountsSavedInImprsntPageAreShownInLenderpassthroughUI_36859() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		verticalMenu.navigatetoimpersonate();
		impersonate.getUsers("Lender", "3641");
		utils.element("xpath", impersonate.registrationStatusArrowForSort).click();
		utils.wait(5000);
		for (int i=0;i<impersonate.getPackPassthroughBtn().size(); i++) {
		if(!impersonate.getPackPassthroughBtn().get(i).getAttribute("Class").equals("button button__checked")) {
		impersonate.getPackPassthroughBtn().get(i).click();
		utils.waitTillElementIsClickableByWebEle(getArrowInshowpackModel());
		Assert.assertTrue(utils.getfield("h3", "Lender Passthrough Permissions").isDisplayed());
		Assert.assertTrue(utils.getfield("span", "User").isDisplayed());
		Assert.assertTrue(utils.getfield("label", "My Lender Passthrough").isDisplayed());
		Assert.assertTrue(permissions.getSaveBtn().getAttribute("disabled").equals("true"));
		getArrowInshowpackModel().click();
		permissions.getSelectCheckBoxInPopup().get(0).click();
		String selectedPackAccountInImpersonatePage = getpackOptionsInPopup().get(0).getText();
		permissions.getSaveBtn().click();
		utils.wait(5000);
		impersonate.getImpersonateList().get(i).click();
		utils.wait(5000);
		verticalMenu.navigatetoLeftMenu("Report","My Lender Passthrough");
		selectAccountInMyLenderPassthroughPage().click();
		String optionDisplayedMydealerPassthrouhUI = dropdownAccountOptionsInPassthroughPage().get(0).getText();
		Assert.assertTrue(selectedPackAccountInImpersonatePage.equals(optionDisplayedMydealerPassthrouhUI));
		break;
		}
		}

	}
	
	@Test(priority = 11)
	public void verifyPackAccountsSavedInImprsntPageAreShownInMyAgentPacksUI_36845() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		verticalMenu.navigatetoimpersonate();
		impersonate.getUsers("Agent", "393");
		utils.element("xpath", impersonate.registrationStatusArrowForSort).click();
		utils.wait(5000);
		for (int i=0;i<impersonate.getPackPassthroughBtn().size(); i++) {
		if(!impersonate.getPackPassthroughBtn().get(i).getAttribute("Class").equals("button button__checked")) {
		impersonate.getPackPassthroughBtn().get(i).click();
		utils.waitTillElementIsClickableByWebEle(getArrowInshowpackModel());
		Assert.assertTrue(utils.getfield("h3", "My Agent Pack Permissions").isDisplayed());
		Assert.assertTrue(utils.getfield("span", "User").isDisplayed());
		Assert.assertTrue(utils.getfield("label", "My Agent Pack").isDisplayed());
		Assert.assertTrue(permissions.getSaveBtn().getAttribute("disabled").equals("true"));
		getArrowInshowpackModel().click();
		permissions.getSelectCheckBoxInPopup().get(0).click();
		String selectedPackAccountInImpersonatePage = getpackOptionsInPopup().get(0).getText();
		permissions.getSaveBtn().click();
		utils.wait(5000);
		impersonate.getImpersonateList().get(i).click();
		utils.wait(5000);
		verticalMenu.navigatetoLeftMenu("Report","My Agent Pack");
		selectAccountInMyMyAgentPacksPage().click();
		String optionDisplayedMydealerPassthrouhUI = dropdownAccountOptionsInPassthroughPage().get(0).getText();
		Assert.assertTrue(selectedPackAccountInImpersonatePage.equals(optionDisplayedMydealerPassthrouhUI));
		break;
		}
		}
	}
	
	@AfterMethod(alwaysRun = true)
	public void close() throws InterruptedException {
		try {
			login.logout();
		} catch (Exception e) {
//			if (utils.getfield("mat-icon", "close").isDisplayed()) {
//				utils.getfield("mat-icon", "close").click();
//			}
//			login.logout();
		}
	}


}
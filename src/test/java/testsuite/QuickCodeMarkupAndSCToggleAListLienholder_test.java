package testsuite;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageActions.AssignDealerToSubAgentAction;
import pageActions.LateralMenuAction;
import pageActions.ManageUserPageAction;
import pageActions.QuickCodeMarkupAListLienholderAction;
import pageActions.loginAction;
import pageActions.singleContractAction;
import pageActions.verticalMenuAction;
import utils.XmlDataReader;
import utils.utilityClass;

public class QuickCodeMarkupAndSCToggleAListLienholder_test extends QuickCodeMarkupAListLienholderAction{
	
	loginAction login = new loginAction();
	verticalMenuAction verticalMenu = new verticalMenuAction();
	LateralMenuAction lateralMenu = new LateralMenuAction();
	utilityClass utils = new utilityClass();
	Impersonate_test impersonate = new Impersonate_test();
	singleContractAction contract =new singleContractAction();
	ManageUserPageAction ManageUserPage=new ManageUserPageAction();
	Packs_test packs=new Packs_test();
	XmlDataReader UtilsDataReader=new XmlDataReader("UtilsData");
	AssignDealerToSubAgentAction assignDealerToSubAgent = new AssignDealerToSubAgentAction();
	//fetching data
	public String SPP=UtilsDataReader.getXMLData("lienholderSPP");
	public String ABB=UtilsDataReader.getXMLData("lienholderABB");
	String unitedAutoCredit=UtilsDataReader.getXMLData("lienholderUnitedAutoCredit");
	String unitedFinance=UtilsDataReader.getXMLData("lienholderUnitedFinance");
	String unitedBank=UtilsDataReader.getXMLData("lienholderUnitedBank");
	String TOC=UtilsDataReader.getXMLData("lienholderTOC");
	String programCodeUA3=UtilsDataReader.getXMLData("programCodeUA3");
	String programCodeASL=UtilsDataReader.getXMLData("programCodeASL");
	String programCodeRAW=UtilsDataReader.getXMLData("programCodeRAW");
	String programCodeSentinel=UtilsDataReader.getXMLData("programCodeSentinel");
	
	
	@BeforeClass(alwaysRun=true)
	public void login() throws InterruptedException {
//		navigate();
		Assert.assertEquals(login.getTitle(), "Protective");
	}
	
	@Test(priority = 1)
	public void verifyQuickCodeMarkupAndSCToggleIsDisabledForDealer_35256_35286() throws Exception {
		login.login(prop.getProperty("dealerAutomation"), prop.getProperty("password"));
		verticalMenu.navigatetoLeftMenu("E-Rate", "Rate / Contract");
		selectLienholder(SPP);
		Assert.assertTrue(utils.element("xpath", quickCode).isEnabled());
		utils.element("xpath", lienholder).clear();
		selectLienholder(unitedAutoCredit);
		Assert.assertFalse(utils.element("xpath", quickCode).isEnabled());
		EnterMileageVINAndSelectProgram(unitedAutoCredit);
		Assert.assertFalse(utils.element("xpath", SCtogglebar).isEnabled());
	}
	
	@Test(priority = 2)
	public void verifyQuickCodeMarkupAndSCToggleIsDisabledForDealerEmpRole_35257_35294() throws Exception {
		lateralMenu.getDefaultpermissionForDealerEmp();
		login.login(prop.getProperty("dealerempAutomation"), prop.getProperty("password"));
//		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
//		verticalMenu.navigatetoimpersonate();
//		impersonate.impersonateUser("DealerEmp", "22723");
		verticalMenu.navigatetoLeftMenu("E-Rate", "Rate / Contract");
		selectLienholder(unitedAutoCredit);
		Assert.assertTrue(utils.element("xpath", elementsInRateContractPage,3).getText().equals("Quick Code"));
		Assert.assertFalse(utils.element("xpath", quickCode).isEnabled());
		EnterMileageVINAndSelectProgram(unitedAutoCredit);
		Assert.assertFalse(utils.element("xpath", SCtogglebar).isEnabled());
	}
	
	
	@Test(priority = 3)
	public void verifyQuickCodeMarkupAndSCToggleIsDisabledForLenderRole_35260_35288() throws Exception {
		login.login(prop.getProperty("lenderAutomation"), prop.getProperty("password"));
		verticalMenu.navigatetoLeftMenu("E-Rate", "Rate / Contract");
		contract.getSelectDealerTogenerateContract(UtilsDataReader.getXMLData("dealer"));
		Assert.assertFalse(utils.element("xpath", elementsInRateContractPage,3).getText().equals("Quick Code"));
		EnterMileageVINAndSelectProgramForLender(unitedAutoCredit);
		Assert.assertFalse(utils.element("xpath", SCtogglebar).isEnabled());
	}
	
	@Test(priority = 4)
	public void verifyQuickCodeMarkupAndSCToggleIsDisabledForLenderEmpRole_35261_35289() throws Exception {
		login.login(prop.getProperty("lenderempAutomation"), prop.getProperty("password"));
		verticalMenu.navigatetoLeftMenu("E-Rate", "Rate / Contract");
		utils.waitTillElementIsClickable(contract.selectDealerTogenerateContract);
		contract.getSelectDealerTogenerateContract(UtilsDataReader.getXMLData("dealer"));
		Assert.assertFalse(utils.element("xpath", elementsInRateContractPage,3).getText().equals("Quick Code"));
		EnterMileageVINAndSelectProgramForLender(unitedAutoCredit);
		Assert.assertFalse(utils.element("xpath", SCtogglebar).isEnabled());
	}
	
	@Test(priority = 5)
	public void verifyQuickCodeMarkupIsDisabledForAgentImpersonatedDealer_35262_35290() throws Exception {
		login.login(prop.getProperty("agentAutomation"), prop.getProperty("password"));
		verticalMenu.navigatetoLeftMenu("Dealer Settings", "Manage Dealers");
		ManageUserPage.selectDealerInmanageUserPage("38226");
		utils.clickfield("xpath", impersonate.tableFirstRow);
		utils.waituntillPageIsloaded();
		verticalMenu.navigatetoLeftMenu("E-Rate", "Rate / Contract");
		selectLienholder(unitedFinance);
		Assert.assertTrue(utils.element("xpath", elementsInRateContractPage,3).getText().equals("Quick Code"));
		Assert.assertFalse(utils.element("xpath", quickCode).isEnabled());
		EnterMileageVINAndSelectProgram(unitedFinance);
		Assert.assertFalse(utils.element("xpath", SCtogglebar).isEnabled());
		
	}
	
	//bug raised
	@Test(priority = 6)
	public void verifyQuickCodeMarkupAndSCToggleIsDisabledForAgentImpersonatedDealerEmp_35263_35291() throws Exception {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		verticalMenu.navigatetoimpersonate();
		impersonate.impersonateUser("Agent", "110");
		verticalMenu.navigatetoLeftMenu("Dealer Settings", "Manage Dealers");
		ManageUserPage.selectDealerInmanageUserPage("38226");
		packs.selectRoleTypeAndStatusCompleted("DealerEmp");
		utils.clickfield("xpath", impersonate.tableFirstRow);
		utils.waituntillPageIsloaded();
		verticalMenu.navigatetoLeftMenu("E-Rate", "Rate / Contract");
		selectLienholder(SPP);
		Assert.assertTrue(utils.element("xpath", quickCode).isEnabled());
		utils.element("xpath", lienholder).clear();
		selectLienholder(unitedFinance);
		Assert.assertFalse(utils.element("xpath", quickCode).isEnabled());
		EnterMileageVINAndSelectProgram(unitedFinance);
		Assert.assertFalse(utils.element("xpath", SCtogglebar).isEnabled());
	}
	
	@Test(priority = 7)
	public void verifyQuickCodeMarkupAndSCToggleIsDisabledForSubgentImpersonatedDealer_35264_35292() throws Exception {
//		login.login(prop.getProperty("aulSubagent"), prop.getProperty("password"));
//		closePopup();
		assignDealerToSubAgent.assignDealersToSubAgent("Agent", "110", prop.getProperty("subagentAutomation"));
		login.login(prop.getProperty("subagentAutomation"), prop.getProperty("password"));
		verticalMenu.navigatetoLeftMenu("Dealer Settings", "Manage Dealers");
		ManageUserPage.selectDealerInmanageUserPage("38226");
		packs.selectRoleTypeAndStatusCompleted("Dealer");
		utils.clickfield("xpath", impersonate.tableFirstRow);
        utils.wait(10000);
		verticalMenu.navigatetoLeftMenu("E-Rate", "Rate / Contract");
		selectLienholder(SPP);
		Assert.assertTrue(utils.element("xpath", quickCode).isEnabled());
		utils.element("xpath", lienholder).clear();
		selectLienholder(unitedFinance);
		Assert.assertFalse(utils.element("xpath", quickCode).isEnabled());
		EnterMileageVINAndSelectProgram(unitedFinance);
		Assert.assertFalse(utils.element("xpath", SCtogglebar).isEnabled());
	}
	
	@Test(priority = 8)
	public void verifyQuickCodeMarkupAndSCToggleIsDisabledForSubAgentImpersonatedDealerEmp_35265_35293() throws Exception {
		assignDealerToSubAgent.assignDealersToSubAgent("Agent", "110", prop.getProperty("subagentAutomation"));
		login.login(prop.getProperty("subagentAutomation"), prop.getProperty("password"));
		verticalMenu.navigatetoLeftMenu("Dealer Settings", "Manage Dealers");
		ManageUserPage.selectDealerInmanageUserPage("38226");
		packs.selectRoleTypeAndStatusCompleted("DealerEmp");
		utils.clickfield("xpath", impersonate.tableFirstRow);
		utils.wait(10000);
		verticalMenu.navigatetoLeftMenu("E-Rate", "Rate / Contract");
		selectLienholder(SPP);
		Assert.assertTrue(utils.element("xpath", quickCode).isEnabled());
		utils.element("xpath", lienholder).clear();
		selectLienholder(unitedFinance);
		Assert.assertFalse(utils.element("xpath", quickCode).isEnabled());
		EnterMileageVINAndSelectProgram(unitedFinance);
		Assert.assertFalse(utils.element("xpath", SCtogglebar).isEnabled());
	}
	
	@Test(priority = 9)
	public void verifyEditFunctinalityAndSCToggleFromAListToBList_35307_35304() throws Exception {
		login.login(prop.getProperty("dealerAutomation"), prop.getProperty("password"));
		verticalMenu.navigatetoLeftMenu("E-Rate", "Rate / Contract");
		selectLienholder(unitedAutoCredit);
		Assert.assertFalse("Quick code for A-List",utils.element("xpath", quickCode).isEnabled());
		EnterMileageVINAndSelectProgram(programCodeUA3);
		Assert.assertFalse(utils.element("xpath", SCtogglebar).isEnabled());
		Thread.sleep(2000);
		utils.waitTillElementIsVisible(editSearch);
		utils.element("xpath", editSearch).click();
		utils.element("xpath", lienholder).clear();
		selectLienholder(unitedBank);
		Assert.assertTrue("Quick code for B-List",utils.element("xpath", quickCode).isEnabled());
		EnterMileageVINAndSelectProgram(programCodeRAW);
		Assert.assertTrue(utils.element("xpath", SCtogglebar).isEnabled());
	}
	
	@Test(priority = 10)
	public void verifyEditFunctinalityAndSCToggleFromBListToAList_35309_35305() throws Exception {
		login.login(prop.getProperty("dealerAutomation"), prop.getProperty("password"));
		verticalMenu.navigatetoLeftMenu("E-Rate", "Rate / Contract");
		selectLienholder(unitedBank);
		Assert.assertTrue("Quick code for B-List",utils.element("xpath", quickCode).isEnabled());
		EnterMileageVINAndSelectProgram(programCodeRAW);
		Assert.assertTrue(utils.element("xpath", SCtogglebar).isEnabled());
		Thread.sleep(2000);
		utils.waitTillElementIsVisible(editSearch);
		utils.element("xpath", editSearch).click();
		utils.element("xpath", lienholder).clear();
		selectLienholder(unitedAutoCredit);
		Assert.assertFalse("Quick code for A-List",utils.element("xpath", quickCode).isEnabled());
		EnterMileageVINAndSelectProgram(programCodeUA3);
		Assert.assertFalse(utils.element("xpath", SCtogglebar).isEnabled());
	}
	
//	/* TC 11 nd 12 failed as there is no dealer grp id and impersonated as dealer having alist partner*/
//	@Test(priority = 11)
//	public void verifyQuickCodeMarkupAndSCToggleIsDisabledForDealerGrpRole_35258_35295() throws Exception {
//		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
//		verticalMenu.navigatetoimpersonate();
////		impersonate.impersonateUser("DealerGroup", "91482");
//		impersonate.impersonateUser("DealerGroup", "23976");
//		verticalMenu.navigatetoLeftMenu("E-Rate", "Rate / Contract");
//		contract.getSelectDealerTogenerateContract(UtilsDataReader.getXMLData("dealer4"));
////		selectLienholder(TOC);
//		selectLienholder(ABB);
//		Assert.assertFalse(utils.element("xpath", quickCode).isEnabled());
////		EnterMileageVINAndSelectProgram(programCodeSentinel);
//		EnterMileageVINAndSelectProgram(ABB);
//		Assert.assertFalse(utils.element("xpath", SCtogglebar).isEnabled());
//	}
//	
//	@Test(priority = 12)
//	public void verifyQuickCodeMarkupAndSCToggleIsDisabledForDealerGrpEmpRole_35259_35287() throws Exception {
//		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
//		verticalMenu.navigatetoimpersonate();
////		impersonate.impersonateUser("DealerGrpEmp", "91482");
//		impersonate.impersonateUser("DealerGroup", "23976");
//		verticalMenu.navigatetoLeftMenu("E-Rate", "Rate / Contract");
//		contract.getSelectDealerTogenerateContract(UtilsDataReader.getXMLData("dealer4"));
//		selectLienholder(TOC);
////		selectLienholder(ABB);
//		Assert.assertFalse(utils.element("xpath", quickCode).isEnabled());
////		EnterMileageVINAndSelectProgram(programCodeSentinel);
//		EnterMileageVINAndSelectProgram(ABB);
//		Assert.assertFalse(utils.element("xpath", SCtogglebar).isEnabled());
//	}
	
	@AfterMethod(alwaysRun = true)
	public void close() throws InterruptedException {
		try {
			login.logout();
		} catch (Exception e) {
			if (utils.getfield("mat-icon", "close").isDisplayed()) {
				utils.getfield("mat-icon", "close").click();
			}
			login.logout();
		}
	}

	
}

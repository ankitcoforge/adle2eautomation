package testsuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;


import pageActions.loginAction;
import pageActions.toolBoxAction;
import pageActions.verticalMenuAction;
@Listeners(utils.listnerlogs.class)
public class ToolBox_New  extends toolBoxAction {

	loginAction lo = new loginAction();
	verticalMenuAction vo = new verticalMenuAction();

	/*************
	 * login to the application
	 * 
	 * @throws InterruptedException
	 *********************/
	@BeforeClass
	public void login() {

		navigate();

	}

	@DataProvider(name = "Login_details")
	public Object[][] loginOnRoleType() {

		return new Object[][] { { prop.getProperty("lenderAutomation"), prop.getProperty("password"), "Lender" }};
		//,{ prop.getProperty("agentAutomation"), prop.getProperty("password"), "Agent" },{prop.getProperty("lenderAutomation"), prop.getProperty("password"), "Lender" }};
	}

	@Test(priority = 1, dataProvider = "Login_details")
	public void VerifyTabAndPDFForms(String username, String password, String roleType) throws InterruptedException {

		lo.login(username, password);

		List<String> formsTab = null;

		vo.navigatetoLeftMenu("Toolbox");

		Assert.assertEquals(toolboxLocation(), "Toolbox");

		Assert.assertEquals(verifyTitle(), "Toolbox");

		sleepWaitFunction(2000);

		if (roleType == "Agent") {

			List<String> AgentformsTab = new ArrayList<String>();

			AgentformsTab.add(TBAgentTab);
			AgentformsTab.add(TBFormsLibraryTab);
			AgentformsTab.add(TBMarketingMaterialTab);
			AgentformsTab.add(TBPaymentPlanPartnersTab);

			formsTab = AgentformsTab;

		} else if(roleType == "Dealer"){

			List<String> DealerformsTab = new ArrayList<String>();

			DealerformsTab.add(TBDealerTab);
			DealerformsTab.add(TBFormsLibraryTab);
			DealerformsTab.add(TBMarketingMaterialTab);
			DealerformsTab.add(TBPaymentPlanPartnersTab);

			formsTab = DealerformsTab;
			
		}else if(roleType == "Lender") {
			List<String> lenderformsTab = new ArrayList<String>();

			lenderformsTab.add(TBLenderTab);
			lenderformsTab.add(TBFormsLibraryTab);
			lenderformsTab.add(TBMarketingMaterialTab);

			formsTab = lenderformsTab;
		}

			int sizeForm = formsTab.size();

			for (int i = 0; i < sizeForm; i++) {

				sleepWaitFunction(2000);

				WebElement element = driver.findElement(By.xpath(formsTab.get(i)));

				if (element.isDisplayed()) {

					String FormName = driver.findElement(By.xpath(formsTab.get(i))).getText();
					System.out.println("FormNames-----"+FormName);

					switch (FormName) {

					case "Dealer Toolbox":

						clickAction(formsTab.get(i));
						verifyForms(formsTab.get(i), roleType);

						break;
						
					case "Agent Toolbox":

						clickAction(formsTab.get(i));
						verifyForms(formsTab.get(i), roleType);

						break;
						
					case "Lender Company Toolbox":

						clickAction(formsTab.get(i));
						verifyForms(formsTab.get(i), roleType);

						break;

					case "Forms Library":

						clickAction(formsTab.get(i));
						verifyForms(formsTab.get(i), roleType);

						break;

					case "Marketing Material":

						clickAction(formsTab.get(i));
						verifyForms(formsTab.get(i), roleType);

						break;

					case "Payment Plan Partners":

						clickAction(formsTab.get(i));
						verifyForms(formsTab.get(i), roleType);

						break;

					}
				}
			}
		
		sleepWaitFunction(4000);
try {
		lo.logout();}
catch (Exception e) {
	
}

	}



}


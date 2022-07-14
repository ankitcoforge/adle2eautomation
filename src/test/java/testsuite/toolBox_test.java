package testsuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.FileUtils;

import pageActions.loginAction;
import pageActions.toolBoxAction;
import pageActions.verticalMenuAction;
@Listeners(utils.listnerlogs.class)
public class toolBox_test extends toolBoxAction {

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

		return new Object[][] { { "Dealer7032823", "4558600", "Dealer" }, { "Agent110", "Since1996", "Agent" } };
	}

	@Test(priority = 1, dataProvider = "Login_details")
	public void VerifyTabAndPDFForms(String username, String password, String roleType) throws InterruptedException {

		lo.login(username, password);

		List<String> formsTab;

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

		} else {

			List<String> DealerformsTab = new ArrayList<String>();

			DealerformsTab.add(TBDealerTab);
			DealerformsTab.add(TBFormsLibraryTab);
			DealerformsTab.add(TBMarketingMaterialTab);
			DealerformsTab.add(TBPaymentPlanPartnersTab);

			formsTab = DealerformsTab;
		}

			int sizeForm = formsTab.size();

			for (int i = 0; i < sizeForm; i++) {

				sleepWaitFunction(2000);

				WebElement element = driver.findElement(By.xpath(formsTab.get(i)));

				if (element.isDisplayed()) {

					String FormName = driver.findElement(By.xpath(formsTab.get(i))).getText();

					switch (FormName) {

					case "Dealer Toolbox":

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

		lo.logout();

	}



}

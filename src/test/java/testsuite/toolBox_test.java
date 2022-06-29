package testsuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import pageActions.loginAction;
import pageActions.toolBoxAction;
import pageActions.verticalMenuAction;

public class toolBox_test extends toolBoxAction {

	loginAction lo = new loginAction();
	verticalMenuAction vo = new verticalMenuAction();

	/*************
	 * login to the application
	 * 
	 * @throws InterruptedException
	 *********************/
	@BeforeClass
	public void login() throws InterruptedException {

		navigate();
		lo.login(prop.getProperty("username"),prop.getProperty("password"));
		vo.navigatetoLeftMenu("Toolbox");

	}

	@Test(priority = 1)
	public void verifyToolBoxLocation() {

		Assert.assertEquals(toolboxLocation(), "Toolbox");
	}
	@Test(priority = 2)
	public void verifyToolBoxTitle() {


		Assert.assertEquals(verifyTitle(), "Toolbox");

	}

	@Test(priority = 3)
	public void VerifyTabAndPDFForms() {
		

		sleepWaitFunction(2000);

		String[] formsTab = { TBDealerTab, TBFormsLibraryTab, TBMarketingMaterialTab, TBPaymentPlanPartnersTab };

		int sizeForm = formsTab.length;

		for (int i = 0; i < sizeForm; i++) {

			sleepWaitFunction(2000);

			WebElement element = driver.findElement(By.xpath(formsTab[i]));

			if (element.isDisplayed()) {

				String FormName = driver.findElement(By.xpath(formsTab[i])).getText();
//				System.out.println(FormName);

				switch (FormName) {

				case "Dealer Toolbox":

					clickAction(formsTab[i]);
					verifyForms(formsTab[i]);

					break;

				case "Forms Library":
					
					clickAction(formsTab[i]);
					verifyForms(formsTab[i]);

					break;

				case "Marketing Material":

					clickAction(formsTab[i]);
					verifyForms(formsTab[i]);

					break;
					
				case "Payment Plan Partners":

					clickAction(formsTab[i]);
					verifyForms(formsTab[i]);

					break;

				}
			}
		}

		sleepWaitFunction(1500);
		
		
	}

	/***************
	 * logout to the application
	 * 
	 * @throws InterruptedException
	 ********************/
	@AfterClass
	public void close() throws InterruptedException {

		lo.logout();

	}

}

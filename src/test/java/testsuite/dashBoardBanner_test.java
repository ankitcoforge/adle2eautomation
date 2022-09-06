package testsuite;

import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageActions.bannnerAction;
import pageActions.loginAction;
import pageActions.welcomeAction;
import utils.utilityClass;
@Listeners(utils.listnerlogs.class)


public class dashBoardBanner_test extends bannnerAction {

	loginAction la = new loginAction();
	welcomeAction wa = new welcomeAction();
	utilityClass event = new utilityClass();

	@BeforeClass
	public void login() throws InterruptedException {

		navigate();

	}

	/************* login to the application *********************/
	@Test(priority = 1)
	public void loggedBannerEnabled() throws InterruptedException {

		try {
			la.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
			driver.get(prop.getProperty("messageSetup"));
			driver.switchTo().defaultContent();
			event.clickfield("cssSelector", bannerTab, 1);
			Assert.assertEquals(event.text("cssSelector", activeTabText), "Dashboard Banner");
			selectEnabled();
			String textSetUp = dashBoardtextSpanArea();
			clickSubmit();
			la.logout();
			navigate();
			la.login(prop.getProperty("username"), prop.getProperty("password"));
			driver.switchTo().defaultContent();
			Assert.assertTrue(textSetUp.contains(dashBoardBannerElement().getText()));
		} catch (Exception e) {

		} finally {
			la.logout();
		}
	}

	@Test(priority = 2)
	public void loggedBannerDisabled() throws InterruptedException {

		try {
			la.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
			driver.get(prop.getProperty("messageSetup"));
			driver.switchTo().defaultContent();
			event.clickfield("cssSelector", bannerTab, 1);
			Assert.assertEquals(event.text("cssSelector", activeTabText), "Dashboard Banner");
			selectDisabled();
			String textSetUp = dashBoardtextSpanArea();
			clickSubmit();
			la.logout();
			navigate();
			la.login(prop.getProperty("username"), prop.getProperty("password"));
			System.out.println(dashBoardBannerElement().getText());
			Assert.assertFalse(textSetUp.contains(dashBoardBannerElement().getText()));
		} catch (Exception e) {

		} finally {
			la.logout();
		}
	}

	@Test(priority = 3)
	public void loggedBannerNoHyperlink() throws InterruptedException {

		try {
			la.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
			driver.get(prop.getProperty("messageSetup"));
			driver.switchTo().defaultContent();
			event.clickfield("cssSelector", bannerTab, 1);
			Assert.assertEquals(event.text("cssSelector", activeTabText), "Dashboard Banner");
			selectEnabled();
			String textSetUp = dashBoardtextSpanArea();
			clickSubmit();
			la.logout();
			navigate();
			la.login(prop.getProperty("username"), prop.getProperty("password"));
			driver.switchTo().defaultContent();
			Assert.assertTrue(textSetUp.contains(dashBoardBannerElement().getText()));
			dashBoardBannerElement().click();
			Set browser = driver.getWindowHandles();
			Assert.assertEquals(browser.size(), 1);
		} catch (Exception e) {

		} finally {
			la.logout();
		}
	}
}
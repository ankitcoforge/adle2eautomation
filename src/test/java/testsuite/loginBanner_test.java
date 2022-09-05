package testsuite;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageActions.bannnerAction;
import pageActions.loginAction;
import pageActions.welcomeAction;
import utils.utilityClass;
@Listeners(utils.listnerlogs.class)
public class loginBanner_test extends bannnerAction {

	
	loginAction la = new loginAction();
	welcomeAction wa = new welcomeAction();
	utilityClass event = new utilityClass();
	
	/*************login to the application
	 * @throws InterruptedException *********************/
	@BeforeClass
	public void login() throws InterruptedException {
		
		navigate();
		
	}
	
	/*************login to the application*********************/
	@Test
    public void loggedBannerEnabled() throws InterruptedException {
		
		la.login(prop.getProperty("adminusername"),prop.getProperty("adminpassword"));
		driver.get(prop.getProperty("messageSetup"));
		driver.switchTo().defaultContent();
		Assert.assertEquals(event.text("cssSelector", bannerText,0), "Login Banner");
		selectEnabled();
		String textSetUp = textSpanArea();
		clickSubmit();
		la.logout();
		navigate();
		Assert.assertEquals(bannerElement().getText(), textSetUp);
	}
	
	@Test
    public void loggedBannerDisabled() throws InterruptedException {
		
		la.login(prop.getProperty("adminusername"),prop.getProperty("adminpassword"));
		driver.get(prop.getProperty("messageSetup"));
		driver.switchTo().defaultContent();
		Assert.assertEquals(event.text("cssSelector", bannerText,0), "Login Banner");
		selectDisabled();
		String textSetUp = textSpanArea();
		clickSubmit();
		la.logout();
		navigate();
		Assert.assertEquals(wa.imageShown(), true);
	}
	
	@Test
	  public void loggedBannerNoHyperlink() throws InterruptedException {
			
			la.login(prop.getProperty("adminusername"),prop.getProperty("adminpassword"));
			driver.get(prop.getProperty("messageSetup"));
			driver.switchTo().defaultContent();
			Assert.assertEquals(event.text("cssSelector", bannerText,0), "Login Banner");
			selectEnabled();
			String textSetUp = textSpanArea();
			clickSubmit();
			la.logout();
			navigate();
			Assert.assertEquals(bannerElement().getText(), textSetUp);
			bannerElement().click();
			Set browser = driver.getWindowHandles();
			Assert.assertEquals(browser.size(), 1);
		}
	
}

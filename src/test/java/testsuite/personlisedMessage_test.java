package testsuite;

import java.util.ArrayList;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageActions.loginAction;
import pageActions.messageSetupAction;
import utils.utilityClass;

@Listeners(utils.listnerlogs.class)

public class personlisedMessage_test extends messageSetupAction {

	loginAction la = new loginAction();
	utilityClass event = new utilityClass();

	/*************
	 * login to the application
	 * 
	 * @throws InterruptedException
	 *********************/
	@BeforeClass
	public void login() throws InterruptedException {

		navigate();
		la.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		driver.get(prop.getProperty("messageSetup"));
		driver.switchTo().defaultContent();
	}

	/************* login to the application *********************/
	@Test(priority = 1)
	public void messageSetUp_14676_14680_14816() throws InterruptedException {

		Assert.assertEquals(heading(), "Message Setup");
		ArrayList<String> b = new ArrayList();
		b.addAll(Arrays.asList("Scheduled", "Enabled", "Disabled"));
		Assert.assertEquals(radioButtonLabel(), b);
		Assert.assertTrue(driver.findElement(By.id(bold)).isDisplayed());
		Assert.assertTrue(driver.findElement(By.id(italic)).isDisplayed());
		Assert.assertTrue(driver.findElement(By.id(underline)).isDisplayed());
		Assert.assertTrue(driver.findElement(By.id(link)).isDisplayed());
		Assert.assertTrue(driver.findElement(By.id(unlink)).isDisplayed());
		event.clickfield("cssSelector", bannerTab, 1);
		Assert.assertEquals(radioButtonLabel(), b);
		Assert.assertTrue(driver.findElement(By.id(bold)).isDisplayed());
		Assert.assertTrue(driver.findElement(By.id(italic)).isDisplayed());
		Assert.assertTrue(driver.findElement(By.id(underline)).isDisplayed());
		Assert.assertTrue(driver.findElement(By.id(link)).isDisplayed());
		Assert.assertTrue(driver.findElement(By.id(unlink)).isDisplayed());
	}

//	@Test(priority = 2)
//	public void messageSetUpStyle_14773_14774() throws InterruptedException {
//
//		Assert.assertTrue(boldletter().contains("abc"));
//		Assert.assertTrue(boldletter().contains("abc"));
//		Assert.assertTrue(driver.findElement(By.cssSelector(textAreaWhole)).isDisplayed());
//		driver.navigate().refresh();
//	}

	@Test(priority = 3)
	public void text_14797_14798() {

		String savedtext = event.text("cssSelector", "div.angular-editor-textarea[contenteditable=\"true\"]");
		event.clickfield("cssSelector", bannerTab, 1);
		Assert.assertEquals(event.text("cssSelector", activeTabText), "Dashboard Banner");
		event.clickfield("cssSelector", bannerTab, 0);
		Assert.assertEquals(event.text("cssSelector", activeTabText), "Login Banner");
		String navigatetext = event.text("cssSelector", "div.angular-editor-textarea[contenteditable=\"true\"]");
		Assert.assertEquals(navigatetext, savedtext);
	}

	@Test(priority = 4)
	public void dashBoardtext_14817() {

		event.clickfield("cssSelector", bannerTab, 1);
		Assert.assertEquals(event.text("cssSelector", activeTabText), "Dashboard Banner");
		String savedtext = event.text("cssSelector", "div.angular-editor-textarea[contenteditable=\"true\"]");
		event.clickfield("cssSelector", bannerTab, 0);
		Assert.assertEquals(event.text("cssSelector", activeTabText), "Login Banner");
		event.clickfield("cssSelector", bannerTab, 1);
		String navigatetext = event.text("cssSelector", "div.angular-editor-textarea[contenteditable=\"true\"]");
		Assert.assertEquals(navigatetext, savedtext);
	}

	@AfterClass
	public void close() throws InterruptedException {

		la.logout();
	}

}

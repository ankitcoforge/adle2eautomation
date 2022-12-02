package testsuite;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Sleeper;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageActions.quoteHistoryAction;
import pageActions.loginAction;
import pageActions.verticalMenuAction;
@Listeners(utils.listnerlogs.class)
public class quoteHistory_test extends quoteHistoryAction {

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

		return new Object[][] { { "Dealer7032823", "Test@1234" } };
	}

	@Test(priority = 1, dataProvider = "Login_details")
	public void VerifyQuoteHistoryTable(String username, String password) throws InterruptedException {

		lo.login(username, password);

		vo.navigatetoLeftMenu("E-Rate", "Quote History");

		verifyTitle();

		verifyElementPresence();

		verifyDeleteFunctionalityConfirmationMessage();

		int NumberOfRecord = recordCount();

		if (NumberOfRecord == 0) {

			System.out.println("Records are not Present");

		} else {

			verifySearchRecord(prop.getProperty("SearchType"), prop.getProperty("SearchData"));

			Thread.sleep(4000);

			int afterSearchCount = recordCount();

			for (int i = 0; i < afterSearchCount; i++) {

			}

		}

		verifyEditLink();

		Thread.sleep(4000);

		lo.logout();
	}

}

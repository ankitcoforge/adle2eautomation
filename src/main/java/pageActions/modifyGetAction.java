package pageActions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;

import pageObjects.contractpo;
import utils.Randomizer;
import utils.utilityClass;

public class modifyGetAction extends contractpo{
	
	utilityClass event = new utilityClass();
	createContractAction co = new createContractAction();
	loginAction lo = new loginAction();
	Randomizer randomizer = new Randomizer();
	verticalMenuAction vo = new verticalMenuAction();

	
	
	public void modifyGetRate() throws InterruptedException {
		
		lo.login(prop.getProperty("username1"), prop.getProperty("password"));
		vo.navigatetoLeftMenu("E-Rate", "Rate/Contract");
		event.inputfield("cssSelector", textbox, "Single", 0);
		event.inputfield("cssSelector", textbox, "Test", 1);
		event.clickfield("xpath", getProducts);
		event.inputfield("cssSelector", textbox, randomizer.getMilage(), 5);
		event.clickfield("xpath", getProducts);
		event.inputfield("cssSelector", textbox, "5J6RW2H89NA004619", 6);
		event.clickfield("xpath", getProducts);
		co.programSelect("Used Vehicle - SNL");
		event.clickfield("cssSelector", table, 0);
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0, 2500)");
		event.clickfield("cssSelector", gapCheckbox);
		Assert.assertEquals(getGapRateButton(), "Get GAP Rate");
		
	}

public int requiredCount() {
		
		return driver.findElements(By.cssSelector(required)).size();
	}
}

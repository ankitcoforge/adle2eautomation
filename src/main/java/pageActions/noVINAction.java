package pageActions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import pageObjects.contractpo;
import utils.Randomizer;
import utils.utilityClass;

public class noVINAction extends contractpo{

	utilityClass event = new utilityClass();
	loginAction lo = new loginAction();
	verticalMenuAction vo = new verticalMenuAction();
	Randomizer randomizer = new Randomizer();
	generateContractAction gc = new generateContractAction();
	createContractAction co = new createContractAction();
	
	public void selectCheckboxNoVin() {
		
		event.clickfield("xpath", noVIN);
	}
	
	public void contractNoVin() throws InterruptedException {
	lo.login(prop.getProperty("username1"), prop.getProperty("password"));
	vo.navigatetoLeftMenu("E-Rate", "Rate/Contract");
	event.inputfield("cssSelector", textbox, "Single", 0);
	Assert.assertEquals(driver.findElement(By.cssSelector(fieldbyLabelName("First Name"))).getAttribute("maxlength"), "40");
	event.inputfield("cssSelector", textbox, "Test", 1);
	Assert.assertEquals(driver.findElement(By.cssSelector(fieldbyLabelName("Last Name"))).getAttribute("maxlength"), "40");
	event.clickfield("xpath", getProducts);
	Assert.assertEquals(requiredCount(),2);
	event.inputfield("cssSelector", textbox, randomizer.getMilage(), 5);
	event.clickfield("xpath", getProducts);
	Assert.assertEquals(requiredCount(),1);
	selectCheckboxNoVin();
	event.inputfield("cssSelector", make, "Honda");
	driver.findElement(By.cssSelector(make)).sendKeys(Keys.ARROW_DOWN);
	driver.findElement(By.cssSelector(make)).sendKeys(Keys.ENTER);
	event.clickfield("xpath", getProducts);
	co.programSelect("Used Vehicle - SNL");
	event.clickfield("cssSelector", table, 0);
	Assert.assertEquals(event.element("cssSelector", slideToggle).getAttribute("tooltiptext"), "Show Cost");
	JavascriptExecutor js = ((JavascriptExecutor) driver);
	js.executeScript("window.scrollTo(0, 2500)");
	event.clickfield("cssSelector", noSurcharges);
	Assert.assertTrue(driver.findElement(By.cssSelector(labelDealNumber)).isDisplayed());
	Assert.assertEquals(driver.findElement(By.cssSelector(fieldbyLabelName("Deal Number"))).getAttribute("maxlength"), "16");
	//Assert.assertEquals(driver.findElement(By.cssSelector(fieldbyLabelName("Vehicle Purchase Price"))).getAttribute("maxlength"), "16");
	System.out.println(event.element("cssSelector", contractNo).getDomProperty("value"));
	Assert.assertTrue((event.element("cssSelector", contractNo)).getDomProperty("value").contains("SNL"));
	Assert.assertTrue(driver.findElement(By.cssSelector(labelVPP)).isDisplayed());
	//Assert.assertEquals(driver.findElement(By.cssSelector(fieldbyLabelName("Contract Retail Price"))).getAttribute("maxlength"), "16");
	Assert.assertTrue(driver.findElement(By.cssSelector(labelCRP)).isDisplayed());
	event.clickfield("xpath", generateContract);
	Assert.assertEquals(requiredCount(),5);
	event.inputfield("cssSelector", contract, "10000", 0);
	event.clickfield("cssSelector", overideContractNoCheckbox);
	Assert.assertEquals(driver.findElement(By.xpath(saveQuoteButton)).getAttribute("disabled"), "true");
	Assert.assertEquals(driver.findElement(By.xpath(printQuoteButton)).getAttribute("disabled"), "true");
	event.clickfield("xpath", generateContract);
	Assert.assertEquals(requiredCount(),5);
	event.clickfield("cssSelector", overideContractNoCheckbox);
	Assert.assertEquals(fieldlength(), "10");
	List<WebElement> a = driver.findElements(By.cssSelector(inServiceDate));
	if (a.size() == 1) {
		String a1 = driver.findElement(By.cssSelector(inServicefield))
				.getAttribute("class");
		if (!(a1.contains("disabled"))) {
			driver.findElement(By.cssSelector(inServiceDateTextBox)).click();
			System.out.println("td[aria-label='" + getDate() + "']");
			driver.findElement(By.cssSelector("td[aria-label='" + getDate() + "']")).click();
		}

	}
	Assert.assertEquals(addGapLabel(), "Add GAP");
	event.clickfield("xpath", generateContract);
	Assert.assertEquals(requiredCount(),4);
	driver.findElement(By.cssSelector(fieldbyLabelName("Zip Code"))).clear();
	event.inputfield("cssSelector", fieldbyLabelName("Zip Code"), "20130");
	event.clickfield("xpath", generateContract);
	Assert.assertEquals(requiredCount(),3);
    event.clearfield("cssSelector", fieldbyLabelName("Address"));
	event.inputfield("cssSelector", fieldbyLabelName("Address"), "Address");
	Thread.sleep(2000);
	event.clickfield("xpath", generateContract);
	Assert.assertEquals(requiredCount(),1);
	event.clearfield("cssSelector", phone);
	event.inputfield("cssSelector", phone, "1234567890");
	event.clickfield("xpath", generateContract);
	getDriver().findElement(By.xpath(gc.generateContractHeading)).isDisplayed();
	Thread.sleep(2000);
	event.clickfield("cssSelector", gc.checkbox, 0);
	event.clickfield("cssSelector", gc.checkbox, 1);
	event.clickfield("xpath", gc.genrateContractButton);
	Thread.sleep(10000);
	String text1 = event.text("cssSelector", successMessage);
	Assert.assertEquals(text1, "You have successfully generated a contract!");
	event.clickfield("xpath", newQuotelink);
	lo.logout();
}
public int requiredCount() {
		
		return driver.findElements(By.cssSelector(required)).size();
	}
}

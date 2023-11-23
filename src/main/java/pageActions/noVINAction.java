package pageActions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
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
	WebElement revealed = driver.findElement(By.cssSelector(year));
    Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    wait.until(d -> revealed.isEnabled());
    event.clickfield("cssSelector", year);
    driver.findElement(By.cssSelector(year)).sendKeys(Keys.ARROW_DOWN);
    driver.findElement(By.cssSelector(year)).sendKeys(Keys.ARROW_DOWN);
	driver.findElement(By.cssSelector(year)).sendKeys(Keys.ENTER);
	WebElement making = driver.findElement(By.cssSelector(make));
    wait.until(d -> making.isEnabled());
	event.clickfield("cssSelector", make);
//	event.inputfield("cssSelector", make, "Honda");
	driver.findElement(By.cssSelector(make)).sendKeys(Keys.ARROW_DOWN);
	driver.findElement(By.cssSelector(make)).sendKeys(Keys.ARROW_DOWN);
	driver.findElement(By.cssSelector(make)).sendKeys(Keys.ENTER);
	WebElement modelling = driver.findElement(By.cssSelector(model));
    wait.until(d -> modelling.isEnabled());
	event.clickfield("cssSelector", model);
	driver.findElement(By.cssSelector(model)).sendKeys(Keys.ARROW_DOWN);
	driver.findElement(By.cssSelector(model)).sendKeys(Keys.ARROW_DOWN);
	driver.findElement(By.cssSelector(model)).sendKeys(Keys.ENTER);
	WebElement fuel = driver.findElement(By.cssSelector(engine));
    wait.until(d -> fuel.isEnabled());
	event.clickfield("cssSelector", engine);
	driver.findElement(By.cssSelector(engine)).sendKeys(Keys.ARROW_DOWN);
	driver.findElement(By.cssSelector(engine)).sendKeys(Keys.ARROW_DOWN);
	driver.findElement(By.cssSelector(engine)).sendKeys(Keys.ENTER);
	event.clickfield("xpath", getProducts);
	co.programSelect("Service Drive - SDF");
	event.clickfield("cssSelector", table, 0);
	Assert.assertEquals(event.element("cssSelector", slideToggle).getAttribute("tooltiptext"), "Show Cost");
	JavascriptExecutor js = ((JavascriptExecutor) driver);
	js.executeScript("window.scrollTo(0, 2500)");
	event.clickfield("cssSelector", noSurcharges);
	Assert.assertTrue(driver.findElement(By.cssSelector(labelDealNumber)).isDisplayed());
	Assert.assertEquals(driver.findElement(By.cssSelector(fieldbyLabelName("Deal Number"))).getAttribute("maxlength"), "16");
	//Assert.assertEquals(driver.findElement(By.cssSelector(fieldbyLabelName("Vehicle Purchase Price"))).getAttribute("maxlength"), "16");
	System.out.println(event.element("cssSelector", contractNo).getDomProperty("value"));
	Assert.assertTrue((event.element("cssSelector", contractNo)).getDomProperty("value").contains("SDF"));
	Assert.assertTrue(driver.findElement(By.cssSelector(labelVPP)).isDisplayed());
	//Assert.assertEquals(driver.findElement(By.cssSelector(fieldbyLabelName("Contract Retail Price"))).getAttribute("maxlength"), "16");
	Assert.assertTrue(driver.findElement(By.cssSelector(labelCRP)).isDisplayed());
	event.inputfield("cssSelector", contract, "10000", 0);
	//event.clickfield("cssSelector", overideContractNoCheckbox);
	//Assert.assertEquals(driver.findElement(By.xpath(generateContract)).getAttribute("disabled"), "true");
	//Assert.assertEquals(driver.findElement(By.xpath(printQuoteButton)).getAttribute("disabled"), "true");;
	inserviceDate();
	driver.findElement(By.cssSelector(fieldbyLabelName("Zip Code"))).clear();
	event.inputfield("cssSelector", fieldbyLabelName("Zip Code"), "20130");
    event.clearfield("cssSelector", fieldbyLabelName("Address"));
	event.inputfield("cssSelector", fieldbyLabelName("Address"), "Address");
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

package pageActions;

import java.text.NumberFormat;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import pageObjects.contractpo;
import utils.CalenderUtils;
import utils.Randomizer;
import utils.utilityClass;

public class singleContractAction extends contractpo {

	utilityClass event = new utilityClass();
	generateContractAction gc = new generateContractAction();
	createContractAction co = new createContractAction();
	loginAction lo = new loginAction();
	Randomizer randomizer = new Randomizer();
	CalenderUtils calenderUtils = new CalenderUtils();
	verticalMenuAction vo = new verticalMenuAction();

	/************************
	 * Create contract
	 * 
	 * @throws InterruptedException
	 ****************************************/
	public String singleContract() throws InterruptedException {
		String contractNumber = null;
		try {
			event.inputfield("cssSelector", textbox, "Single", 0);
			event.inputfield("cssSelector", textbox, "Test", 1);
			event.inputfield("cssSelector", textbox, "125001", 5);
			event.inputfield("cssSelector", textbox, "1FM5K8GC2NGA00557", 6);
			co.programSelect("Limited Warranty");
        	event.inputfield("cssSelector", textbox, "1251", 5);
			event.inputfield("cssSelector", textbox, "1FM5K8GC2NGA00557", 6);
			event.inputfield("cssSelector", textbox, randomizer.getMilage(), 5);
			event.clickfield("xpath", getProducts);
			co.programSelect("Essentials");
			event.clickfield("cssSelector", table, 0);
			event.inputfield("cssSelector", textbox, "22723", 7);
			selectOptionSurcharge();
			event.inputfield("cssSelector", contract, "10000", 0);
			contractNumber = driver.findElement(By.cssSelector(contractNo)).getDomProperty("value");
			System.out.println("Contract Number is:" + contractNumber);
			inserviceDate();
//			Assert.assertEquals(addGapLabel(), "Add GAP");
			event.clearfield("cssSelector", Zipcode);
			event.inputfield("cssSelector",Zipcode, "20130");
			event.clearfield("cssSelector", Address);
			event.inputfield("cssSelector",  Address, "Address");
			event.clearfield("cssSelector",  Email);
			event.inputfield("cssSelector",  Email, "test@gmail.com");
			//Assert.assertEquals(addGapLabel(), "Add GAP");
			event.clickfield("xpath", businessUse);
			driver.findElements(By.cssSelector(textbox)).get(14).clear();
			event.inputfield("cssSelector", textbox, "20130", 14);
			driver.findElements(By.cssSelector(textbox)).get(13).clear();
			event.inputfield("cssSelector", textbox, "Address", 13);
			driver.findElements(By.cssSelector(textbox)).get(16).clear();
			event.inputfield("cssSelector", textbox, "test@gmail.com", 16);
			Thread.sleep(2000);
			event.clearfield("cssSelector", phone);
			event.inputfield("cssSelector", phone, "1234567890");
			Thread.sleep(2000);
			event.clickfield("xpath", generateContract);
			Thread.sleep(2000);
			getDriver().findElement(By.xpath(gc.generateContractHeading)).isDisplayed();
			Thread.sleep(2000);
			event.clickfield("cssSelector", gc.checkbox, 0);
			event.clickfield("cssSelector", gc.checkbox, 1);
			event.clickfield("xpath", gc.genrateContractButton);
			WebElement element = new WebDriverWait(driver, Duration.ofSeconds(9)).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(successMessage)));
			Assert.assertEquals(element.getText(), "You have successfully generated a contract!");
			event.clickfield("cssSelector", newQuotelink);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return contractNumber;
	}

	public void singleContract(String listb) throws InterruptedException {

		event.inputfield("cssSelector", textbox, "Single", 0);
		event.inputfield("cssSelector", textbox, "Test", 1);
		event.inputfield("cssSelector", textbox, listb, 2);
		event.clickfield("cssSelector", "[role=listbox] > [role=option]");
		event.inputfield("cssSelector", textbox, "125001", 5);
		event.inputfield("cssSelector", textbox, "1FM5K8GC2NGA00557", 6);
		event.inputfield("cssSelector", textbox, "1234", 5);
//		event.inputfield("cssSelector", textbox, "5J6RW2H89NA004619", 6);
		event.inputfield("cssSelector", textbox, "1HGCY2F55PA001395", 6);
		event.clickfield("xpath", getProducts);
		co.programSelect("Limited Warranty");
		event.clickfield("cssSelector", table, 0);
		event.inputfield("cssSelector", contract, "10000", 0);

		selectOptionSurcharge();
		inserviceDate();
//		Assert.assertEquals(addGapLabel(), "Add GAP");
		event.clearfield("cssSelector", "[label='Zip Code'] >div >div:nth-child(2) >input");
//		event.inputfield("cssSelector", "[label='Zip Code'] >div >div:nth-child(2) >input", "20130");
		event.clearfield("cssSelector",  "[label='Address'] >div >div:nth-child(2) >input");
//		event.inputfield("cssSelector",  "[label='Address'] >div >div:nth-child(2) >input", "Address");
		event.clearfield("cssSelector",  "[label='Email'] >div >div:nth-child(2) >input");
//		event.inputfield("cssSelector",  "[label='Email'] >div >div:nth-child(2) >input", "test@gmail.com");
		event.clickfield("xpath", generateContract);
		getDriver().findElement(By.xpath(gc.generateContractHeading)).isDisplayed();
		Thread.sleep(1000);
		event.clickfield("cssSelector", gc.checkbox, 0);
		event.clickfield("cssSelector", gc.checkbox, 1);
		event.clickfield("xpath", gc.genrateContractButton);
		WebElement element = new WebDriverWait(driver, Duration.ofSeconds(9)).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(successMessage)));
		Assert.assertEquals(element.getText(), "You have successfully generated a contract!");
		event.clickfield("cssSelector", newQuotelink);
	}

	public void getSelectDealerTogenerateContract(String dealer) throws InterruptedException {
		WebElement ele = driver.findElement(By.xpath(selectDealerTogenerateContract));
		ele.click();
		ele.sendKeys(dealer);
		ele.sendKeys(Keys.ARROW_DOWN);
		ele.sendKeys(Keys.ENTER);
		getBtnSignIn().click();
		Thread.sleep(2000);
	}

	public String singleContractForLender(String dealer) throws InterruptedException {
		getSelectDealerTogenerateContract(dealer);
		event.inputfield("cssSelector", textbox, "Single", 0);
		event.inputfield("cssSelector", textbox, "Test", 1);
		event.inputfield("cssSelector", textbox, "100", 4);
		event.inputfield("cssSelector", textbox, "1FM5K8GC2NGA00557", 5);
		event.clickfield("xpath", getProducts);
		String programCode = prop.getProperty("lenderProgramCode");
		co.programSelect(programCode);
		event.clickfield("cssSelector", table, 0);
		Thread.sleep(2000);
		event.scrollDown();
		event.inputfield("cssSelector", textbox, "22723", 7);
		event.inputfield("cssSelector", contract, "10000", 0);
		selectOptionSurcharge();
		String contractNumber = driver.findElement(By.cssSelector(contractNo)).getDomProperty("value");
		System.out.println("Contract Number is:" + contractNumber);
        inserviceDate();
		// Assert.assertEquals(contractNew.addGapLabel(), "Add GAP");
        event.clearfield("cssSelector", "[label='Zip Code'] >div >div:nth-child(2) >input");
		event.inputfield("cssSelector", "[label='Zip Code'] >div >div:nth-child(2) >input", "20130");
		event.clearfield("cssSelector",  "[label='Address'] >div >div:nth-child(2) >input");
		event.inputfield("cssSelector",  "[label='Address'] >div >div:nth-child(2) >input", "Address");
		event.clearfield("cssSelector",  "[label='Email'] >div >div:nth-child(2) >input");
		event.inputfield("cssSelector",  "[label='Email'] >div >div:nth-child(2) >input", "test@gmail.com");
		Thread.sleep(2000);
		event.clearfield("cssSelector", phone);
		event.inputfield("cssSelector", phone, "1234567890");
		event.clickfield("xpath", generateContract);
		getDriver().findElement(By.xpath(gc.generateContractHeading)).isDisplayed();
		Thread.sleep(2000);
		event.clickfield("cssSelector", gc.checkbox, 0);
		event.clickfield("cssSelector", gc.checkbox, 1);
		event.clickfield("xpath", gc.genrateContractButton);
		WebElement element = new WebDriverWait(driver, Duration.ofSeconds(9)).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(successMessage)));
		Assert.assertEquals(element.getText(), "You have successfully generated a contract!");
		event.clickfield("cssSelector", newQuotelink);
		return contractNumber;
	}

	public void inflatoryPrice(String[] inputArray) throws Exception {
		
		driver.navigate().refresh();
		lo.login("shreya.agarwal@protective.com", prop.getProperty("password"));
		vo.navigatetoLeftMenu("E-Rate", "Rate/Contract");
		HashMap<String, String> searchData1 = new HashMap<String, String>();
		searchData1 = contractData(inputArray);
		String contractNumber = null;
		System.out.println(searchData1.get("program"));
		String mileage = randomizer.getMilage();
		event.inputfield("cssSelector", textbox, "Single", 0);
		event.inputfield("cssSelector", textbox, "Test", 1);
		event.inputfield("cssSelector", textbox, mileage, 5);
		event.inputfield("cssSelector", textbox, "1FM5K8GC2NGA00557", 6);
		event.clickfield("xpath", getProducts);
		co.programSelect(searchData1.get("program"));
		event.clickfield("cssSelector", table, 0);
		String before = event.text("cssSelector", table, 0);
		event.clickfield("cssSelector", "div.actions__submit > button");
		event.clickfield("cssSelector",
				"[class=\"mat-focus-indicator suffix suffix--clickable mat-icon-button mat-button-base mat-accent calendar ng-star-inserted\"]");
		calenderUtils.selectDate("May/14/2023", "MMM/dd/yyyy");
		event.clickfield("xpath", getProducts);
		try {
			co.programSelect(searchData1.get("program"));
		} catch (StaleElementReferenceException e) {
			co.programSelect(searchData1.get("program"));
		}
		event.clickfield("cssSelector", table, 0);
		String after = event.text("cssSelector", table, 0);
		System.out.println(before);
		System.out.println(after);
		String beforeprice = before.replace("$", "").replace(",", "");
		String afterprice = after.replace("$", "").replace(",", "");
		int pricebefore = Integer.parseInt(beforeprice);
		int priceafter = Integer.parseInt(afterprice);
	    Boolean pricehike = priceafter < pricebefore;
	    Assert.assertTrue(pricehike);
        lo.logout();
	}
	
	
public void inflatoryLenderPrice(String[] inputArray) throws Exception {
		
	    driver.navigate().refresh();
		lo.login("vivek.singla@protective.com", prop.getProperty("password"));
		vo.navigatetoLeftMenu("E-Rate", "Rate/Contract");
		driver.findElement(By.cssSelector("input[placeholder ='Type or Select Dealer Name']")).click();
		dealerList("TestDealer_15apr2023");
		Thread.sleep(20000);
		HashMap<String, String> searchData1 = new HashMap<String, String>();
		searchData1 = contractData(inputArray);
		String contractNumber = null;
		System.out.println(searchData1.get("program"));
		String mileage = randomizer.getMilage();
		event.inputfield("cssSelector", textbox, "Single", 0);
		event.inputfield("cssSelector", textbox, "Test", 1);
		event.inputfield("cssSelector", textbox, "12345", 5);
		event.inputfield("cssSelector", textbox, "1FM5K8GC2NGA00557", 6);
		event.clickfield("xpath", getProducts);
		co.programSelect(searchData1.get("program"));
		event.clickfield("cssSelector", table, 0);
		String before = event.text("cssSelector", table, 0);
		event.clickfield("cssSelector", "div.actions__submit > button");
		event.clickfield("cssSelector",
				"[class=\"mat-focus-indicator suffix suffix--clickable mat-icon-button mat-button-base mat-accent calendar ng-star-inserted\"]");
		calenderUtils.selectDate("May/14/2023", "MMM/dd/yyyy");
		event.clickfield("xpath", getProducts);
		try {
			co.programSelect(searchData1.get("program"));
		} catch (StaleElementReferenceException e) {
			co.programSelect(searchData1.get("program"));
		}
		event.clickfield("cssSelector", table, 0);
		String after = event.text("cssSelector", table, 0);
		System.out.println(before);
		System.out.println(after);
		String beforeprice = before.replace("$", "").replace(",", "");
		String afterprice = after.replace("$", "").replace(",", "");
		int pricebefore = Integer.parseInt(beforeprice);
		int priceafter = Integer.parseInt(afterprice);
	    Boolean pricehike = priceafter < pricebefore;
	    Assert.assertTrue(pricehike);
        lo.logout();
	}
}

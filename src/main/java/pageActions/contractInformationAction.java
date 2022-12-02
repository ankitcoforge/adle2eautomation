package pageActions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import pageObjects.contractpo;
import utils.Randomizer;
import utils.utilityClass;

public class contractInformationAction extends contractpo {

	utilityClass event = new utilityClass();
	generateContractAction gc = new generateContractAction();
	createContractAction co = new createContractAction();
	loginAction lo = new loginAction();
	Randomizer randomizer = new Randomizer();
	verticalMenuAction vo = new verticalMenuAction();

	public void contractValidation() throws InterruptedException {

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
		event.inputfield("cssSelector", textbox, "5J6RW2H89NA004619", 6);
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
	
	public void upSellProduct() throws InterruptedException {

		lo.login(prop.getProperty("username1"), prop.getProperty("password"));
		vo.navigatetoLeftMenu("E-Rate", "Rate/Contract");
		event.inputfield("cssSelector", textbox, "Single", 0);
		event.inputfield("cssSelector", textbox, "Test", 1);
		event.clickfield("xpath", getProducts);
		Assert.assertEquals(requiredCount(),2);
		event.inputfield("cssSelector", textbox, randomizer.getMilage(), 5);
		event.clickfield("xpath", getProducts);
		Assert.assertEquals(requiredCount(),1);
		event.inputfield("cssSelector", textbox, "5J6RW2H89NA004619", 6);
		event.clickfield("xpath", getProducts);
		co.programSelect("Absolute Lifetime Wrap");
		Assert.assertEquals(event.text("cssSelector", warningLabel), "An (ALW) Absolute Lifetime Powertrain Warranty is required to view and select rates for (ALP) Absolute Lifetime Wrap.");
		lo.logout();
	}
	
	public void showToggle() throws InterruptedException {

		lo.login(prop.getProperty("username1"), prop.getProperty("password"));
		vo.navigatetoLeftMenu("E-Rate", "Rate/Contract");
		event.inputfield("cssSelector", textbox, "Single", 0);
		event.inputfield("cssSelector", textbox, "Test", 1);
		event.clickfield("xpath", getProducts);
		Assert.assertEquals(requiredCount(),2);
		event.inputfield("cssSelector", textbox, randomizer.getMilage(), 5);
		event.clickfield("xpath", getProducts);
		Assert.assertEquals(requiredCount(),1);
		event.inputfield("cssSelector", textbox, "5J6RW2H89NA004619", 6);
		event.clickfield("xpath", getProducts);
		co.programSelect("Essentials");
		String price = event.text("cssSelector", table, 0);
		String price2 = price.replace("$", "");
		int total  = Integer.parseInt(price2);
		Assert.assertEquals(event.text("cssSelector", headerMarkUp), "F0");
		event.clickfield("xpath", editProducts);
		event.inputfield("cssSelector", fieldbyLabelName("Quick Code"), "400");
		event.clickfield("xpath", getProducts);
		@SuppressWarnings("deprecation")
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".information__makeModelYear")));
		Thread.sleep(5000);
		co.programSelect("Essentials");
		String price1 = event.text("cssSelector", table, 0);
		String price3= price1.replace("$", "");
		int total1  = Integer.parseInt(price3);
		Assert.assertEquals(total+400, total1);
		Assert.assertEquals(event.text("cssSelector", headerMarkUp), "F400");
		lo.logout();
	}
	

	
	
	
	public void cobuyerContractValidation() throws InterruptedException {

		lo.login(prop.getProperty("username1"), prop.getProperty("password"));
		vo.navigatetoLeftMenu("E-Rate", "Rate/Contract");
		event.inputfield("cssSelector", textbox, "Single", 0);
		event.inputfield("cssSelector", textbox, "Test", 1);
		event.clickfield("xpath", getProducts);
		Assert.assertEquals(requiredCount(),2);
		event.inputfield("cssSelector", textbox, randomizer.getMilage(), 5);
		event.clickfield("xpath", getProducts);
		Assert.assertEquals(requiredCount(),1);
		event.inputfield("cssSelector", textbox, "5J6RW2H89NA004619", 6);
		event.clickfield("xpath", getProducts);
		co.programSelect("Used Vehicle - SNL");
		event.clickfield("cssSelector", table, 0);
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0, 2500)");
		event.clickfield("cssSelector", noSurcharges);
		event.clickfield("xpath", generateContract);
		Assert.assertEquals(requiredCount(),5);
		event.inputfield("cssSelector", contract, "10000", 0);
		event.clickfield("cssSelector", overideContractNoCheckbox);
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
		event.clickfield("xpath", generateContract);
		Assert.assertEquals(requiredCount(),1);
		event.clearfield("cssSelector", phone);
		event.inputfield("cssSelector", phone, "1234567890");
		Thread.sleep(4000);
		driver.findElement(By.cssSelector(coBuyer)).isDisplayed();
		event.clickfield("cssSelector", ".customer__hascobuyer >adl-checkbox > div > mat-checkbox >label> div");
		event.clickfield("xpath", generateContract);
		Assert.assertEquals(requiredCount(),5);
		event.inputfield("cssSelector", fieldbyLabelName("First Name"), "CoBuyerFirstName",2);
		event.inputfield("cssSelector", fieldbyLabelName("Last Name"), "CoBuyerLastName",2);
		event.clickfield("xpath", generateContract);
		Assert.assertEquals(requiredCount(),4);
		event.inputfield("cssSelector", fieldbyLabelName("Zip Code"), "20301", 1);
		event.clickfield("xpath", generateContract);
		Assert.assertEquals(requiredCount(),3);
		event.inputfield("cssSelector", fieldbyLabelName("Address"), "Address Co Buyer" , 1);
		event.clickfield("xpath", generateContract);
		Assert.assertEquals(requiredCount(),1);
		event.clearfield("cssSelector", fieldbyLabelName("Phone Number"),1);
		event.inputfield("cssSelector", fieldbyLabelName("Phone Number"),"1234567890",1);
		event.clickfield("xpath", generateContract);
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

	
	
	public void sppContractValidation() throws InterruptedException {

		lo.login(prop.getProperty("username1"), prop.getProperty("password"));
		vo.navigatetoLeftMenu("E-Rate", "Rate/Contract");
		event.inputfield("cssSelector", textbox, "Single", 0);
		event.inputfield("cssSelector", textbox, "Test", 1);
		event.inputfield("cssSelector", textbox, "SPP", 2);
		event.clickfield("cssSelector", "[role=listbox] > [role=option]");
		event.inputfield("cssSelector", textbox, "1234", 5);
		event.inputfield("cssSelector", textbox, "5J6RW2H89NA004619", 6);
		event.clickfield("xpath", getProducts);
		co.programSelect("Service Drive - SDF");
		event.clickfield("cssSelector", table, 0);
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0, 2500)");
		event.clickfield("cssSelector", overideContractNoCheckbox);
		event.clickfield("cssSelector", sppNext);
		Assert.assertEquals(requiredCount(),6);
		event.clickfield("cssSelector", overideContractNoCheckbox);
		event.inputfield("cssSelector", contract, "10000", 0);
		List <WebElement> a = driver.findElements(By.cssSelector(inServiceDate));
		if(a.size() == 1) {
			String a1  = driver.findElement(By.cssSelector(inServicefield)).getAttribute("class");
			if(!(a1.contains("disabled"))) {
				driver.findElement(By.cssSelector(inServiceDateTextBox)).click();
				System.out.println("td[aria-label='" + getDate() + "']");
				driver.findElement(By.cssSelector("td[aria-label='" + getDate() + "']")).click();
			}
			
		}
		driver.findElement(By.cssSelector(fieldbyLabelName("Zip Code"))).clear();
	    event.clearfield("cssSelector", fieldbyLabelName("Address"));
	    event.clearfield("cssSelector", phone);
	    event.clickfield("cssSelector", sppNext);
		Assert.assertEquals(requiredCount(),4);
		event.inputfield("cssSelector", fieldbyLabelName("Zip Code"), "20130");
		event.clickfield("cssSelector", sppNext);
		Assert.assertEquals(requiredCount(),3);
		driver.findElement(By.cssSelector(coBuyer)).isDisplayed();
		event.clickfield("cssSelector", ".customer__hascobuyer >adl-checkbox > div > mat-checkbox >label> div");
		event.clickfield("cssSelector", sppNext);
		Assert.assertEquals(requiredCount(),7);
		event.inputfield("cssSelector", fieldbyLabelName("First Name"), "CoBuyerFirstName",2);
		event.inputfield("cssSelector", fieldbyLabelName("Last Name"), "CoBuyerLastName",2);
		event.clickfield("cssSelector", sppNext);
		Assert.assertEquals(requiredCount(),6);
		event.inputfield("cssSelector", fieldbyLabelName("Zip Code"), "20301", 1);
		event.clickfield("cssSelector", sppNext);
		Assert.assertEquals(requiredCount(),5);
		event.inputfield("cssSelector", fieldbyLabelName("Address"), "Address Co Buyer" , 1);
		event.clickfield("cssSelector", sppNext);
		Assert.assertEquals(requiredCount(),3);
		lo.logout();
		}

	
	public int requiredCount() {
		
		return driver.findElements(By.cssSelector(required)).size();
	}
}

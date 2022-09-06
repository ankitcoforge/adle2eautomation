package pageActions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
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
		lo.logout();
		}

	
	public int requiredCount() {
		
		return driver.findElements(By.cssSelector(required)).size();
	}
}

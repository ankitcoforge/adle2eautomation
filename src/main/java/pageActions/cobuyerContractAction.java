package pageActions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import pageObjects.EditContractpo;
import pageObjects.contractpo;
import utils.utilityClass;

public class cobuyerContractAction extends contractpo{
	
	utilityClass event = new utilityClass();
    generateContractAction gc = new generateContractAction();
    createContractAction co = new createContractAction();
    utilityClass utils = new utilityClass();

	/************************Create contract 
	 * @throws InterruptedException ****************************************/
	public String coBuyerContract() throws InterruptedException {
		String contractNumber = null;
		try {
		event.inputfield("cssSelector", textbox, "Single", 0);
		event.inputfield("cssSelector", textbox, "Test", 1);
		event.inputfield("cssSelector", textbox, "125001", 5);
		event.inputfield("cssSelector", textbox, "5J6RW2H89NA004619", 6);
		event.clickfield("cssSelector", ".actions__submit >button");
		co.programSelect("Used Vehicle - SNL");
		event.clickfield("cssSelector", table, 0);
		event.inputfield("cssSelector", contract, "10000", 0);
		contractNumber = driver.findElement(By.cssSelector(contractNo)).getDomProperty("value");
		selectOptionSurcharge();
		inserviceDate();
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click()", driver.findElement(By.cssSelector(coBuyer)));
		Thread.sleep(2000);
		utils.scrollDown();
		event.inputfield("cssSelector", fieldbyLabelName("First Name"), "CoBuyerFirstName",2);
		event.inputfield("cssSelector", fieldbyLabelName("Last Name"), "CoBuyerLasttName",2);
		event.inputfield("cssSelector", fieldbyLabelName("Zip Code"), "20301", 1);
		event.inputfield("cssSelector", fieldbyLabelName("Address"), "Address Co Buyer" , 1);
		event.inputfield("cssSelector", fieldbyLabelName("Email"), "cobuyer@gmail.com" , 1);
		Thread.sleep(2000);
		event.clearfield("cssSelector", fieldbyLabelName("Phone Number"),1);
		event.inputfield("cssSelector", fieldbyLabelName("Phone Number"),"1234567890",1);
		Thread.sleep(10000);
		event.clickfield("xpath", generateContract);
		getDriver().findElement(By.xpath(gc.generateContractHeading)).isDisplayed();
		Thread.sleep(2000);
		event.clickfield("cssSelector", gc.checkbox, 0);
		event.clickfield("cssSelector", gc.checkbox, 1);
		event.clickfield("xpath", gc.genrateContractButton);
		WebElement element = new WebDriverWait(driver, Duration.ofSeconds(9)).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(successMessage)));
		Assert.assertEquals(element.getText(), "You have successfully generated a contract!");
		event.clickfield("cssSelector", newQuotelink);
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Test Case failed ");
			e.getCause();
			Assert.fail();
		}
		return contractNumber;
		
	}

	public String coBuyerContractwithMandatoryFields() throws InterruptedException {
		String contractNumber = null;
		try {
		event.inputfield("cssSelector", textbox, "Test", 1);
		event.inputfield("cssSelector", textbox, "1234", 5);
		event.inputfield("cssSelector", textbox, "5J6RW2H89NA004619", 6);
		event.clickfield("cssSelector", ".actions__submit >button");
		co.programSelect("Limited Warranty");
		event.clickfield("cssSelector", table, 0);
		selectOptionSurcharge();
		event.inputfield("cssSelector", contract, "10000", 0);
		contractNumber = driver.findElement(By.cssSelector(contractNo)).getDomProperty("value");
		System.out.println("Contract Number is:"+contractNumber);
		inserviceDate();
		//Assert.assertEquals(addGapLabel(), "Add GAP");
		driver.findElements(By.cssSelector(textbox)).get(14).clear();
		event.inputfield("cssSelector", textbox, "20130", 14);
		driver.findElements(By.cssSelector(textbox)).get(13).clear();
		event.inputfield("cssSelector", textbox, "Address", 13);
		Thread.sleep(2000);
		event.clearfield("cssSelector", phone);
		event.inputfield("cssSelector", phone, "1234567890");
		 JavascriptExecutor jse = (JavascriptExecutor)driver;
		    jse.executeScript("arguments[0].click()", driver.findElement(By.cssSelector(coBuyer))); 
		    Thread.sleep(2000);
		    utils.scrollDown();
		event.inputfield("cssSelector", fieldbyLabelName("Last Name"), "CoBuyerLasttName",2);
		event.inputfield("cssSelector", fieldbyLabelName("Zip Code"), "20301", 1);
		event.inputfield("cssSelector", fieldbyLabelName("Address"), "Address Co Buyer" , 1);
		Thread.sleep(2000);
		event.clearfield("cssSelector", fieldbyLabelName("Phone Number"),1);
		event.inputfield("cssSelector", fieldbyLabelName("Phone Number"),"1234567890",1);
		Thread.sleep(10000);
		event.clickfield("xpath", generateContract);
		getDriver().findElement(By.xpath(gc.generateContractHeading)).isDisplayed();
		Thread.sleep(2000);
		event.clickfield("cssSelector", gc.checkbox, 0);
		event.clickfield("cssSelector", gc.checkbox, 1);
		event.clickfield("xpath", gc.genrateContractButton);
		Thread.sleep(5000);
		String text1 = event.text("cssSelector", successMessage);
		Assert.assertEquals(text1, "You have successfully generated a contract!");
		event.clickfield("xpath", newQuotelink);
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Test Case failed ");
			e.getCause();
			Assert.fail();
		}
		return contractNumber;
		
	}

}

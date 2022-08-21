package pageActions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import pageObjects.contractpo;
import utils.utilityClass;

public class leaseContractAction extends contractpo {

	utilityClass event = new utilityClass();
	generateContractAction gc = new generateContractAction();
	createContractAction co = new createContractAction();

	public void leaseContract() throws InterruptedException {

		event.inputfield("cssSelector", textbox, "Single", 0);
		event.inputfield("cssSelector", textbox, "Test", 1);
		event.inputfield("cssSelector", textbox, "1234", 5);
		event.inputfield("cssSelector", textbox, "5J6RW2H89NA004619", 6);
		event.clickfield("xpath", getProducts);
		co.programSelect("Absolute Reserve Care Lease");
		Assert.assertEquals(driver.findElements(By.cssSelector("adl-lease-term >div >div> span")).get(0).getText(),
				"Lease Term Months:");
		Assert.assertEquals(driver.findElements(By.cssSelector("adl-lease-term >div >div> span")).get(1).getText(),
				"Lease Term Miles:");
		driver.findElement(By.cssSelector("adl-select[placeholder=\"Select Months\"]>ng-select")).click();
		driver.findElement(By.cssSelector(".ng-dropdown-panel-items > div > div")).click();
		driver.findElement(By.cssSelector("adl-select[placeholder=\"Select Miles\"]>ng-select")).click();
		driver.findElement(By.cssSelector(".ng-dropdown-panel-items > div > div")).click();
		Assert.assertEquals(driver.findElement(By.cssSelector("adl-warning-message >div > p>span")).getText(),
				"Please select the rate in the table.");
		event.clickfield("cssSelector", table, 0);
		event.inputfield("cssSelector", contract, "10000", 0);
		List<WebElement> a = driver.findElements(By.cssSelector(inServiceDate));
//		if (a.size() == 1) {
//			String a1 = driver.findElement(By.cssSelector("adl-text-input[label='In-Service Date'] >div  >div + div"))
//					.getAttribute("class");
//			if (!(a1.contains("disabled"))) {
//				driver.findElement(By.cssSelector(inServiceDateTextBox)).click();
//				System.out.println("td[aria-label='" + getDate() + "']");
//				driver.findElement(By.cssSelector("td[aria-label='" + getDate() + "']")).click();
//			}
//
//		}
		driver.findElements(By.cssSelector(textbox)).get(14).clear();
		event.inputfield("cssSelector", textbox, "20130", 14);
		driver.findElements(By.cssSelector(textbox)).get(13).clear();
		event.inputfield("cssSelector", textbox, "Address", 13);
		Thread.sleep(2000);
		event.clearfield("cssSelector", phone);
		event.inputfield("cssSelector", phone, "1234567890");
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
}

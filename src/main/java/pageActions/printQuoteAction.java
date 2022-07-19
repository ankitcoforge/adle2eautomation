package pageActions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;

import pageObjects.contractpo;
import utils.utilityClass;
@Listeners(utils.listnerlogs.class)

public class printQuoteAction extends contractpo{
	
    utilityClass event = new utilityClass();
    generateContractAction gc = new generateContractAction();
    createContractAction co = new createContractAction();
    
    String savequote = "//span[contains(text(),'Print Quote')]";

	/************************Create contract 
	 * @throws InterruptedException ****************************************/
	public void printQuote() throws InterruptedException {

		
		try {
		event.inputfield("cssSelector", textbox, "Single", 0);
		event.inputfield("cssSelector", textbox, "Test", 1);
		event.inputfield("cssSelector", textbox, "1234", 5);
		event.inputfield("cssSelector", textbox, "5J6RW2H89NA004619", 6);
		event.clickfield("xpath", getProducts);
		co.programSelect("Limited Warranty - OCW");
		event.clickfield("cssSelector", table, 0);
		event.inputfield("cssSelector", contract, "10000", 0);
		List <WebElement> a = driver.findElements(By.cssSelector(inServiceDate));
		if(a.size() == 1) {
			String a1  = driver.findElement(By.cssSelector("adl-text-input[label='In-Service Date'] >div  >div + div")).getAttribute("class");
			if(!(a1.contains("disabled"))) {
				driver.findElement(By.cssSelector(inServiceDateTextBox)).click();
				System.out.println("td[aria-label='" + getDate() + "']");
				driver.findElement(By.cssSelector("td[aria-label='" + getDate() + "']")).click();
			}
			
		}
		driver.findElements(By.cssSelector(textbox)).get(14).clear();
		event.inputfield("cssSelector", textbox, "20130", 14);
		driver.findElements(By.cssSelector(textbox)).get(13).clear();
		event.inputfield("cssSelector", textbox, "Address", 13);
		Thread.sleep(2000);
		event.clearfield("cssSelector", phone);
		event.inputfield("cssSelector", phone, "1234567890");
		event.clickfield("xpath", savequote);
		Thread.sleep(5000);
		String text1 = event.text("cssSelector", successMessage);
		Assert.assertEquals(text1, "Your Quote has been successfully saved!");
		event.clickfield("xpath", newQuotelink);
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Test Case failed ");
			e.getCause();
			Assert.fail();
		}
	}
}

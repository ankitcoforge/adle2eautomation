package pageActions;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pageObjects.cancellationQuotespo;
import utils.utilityClass;

public class cancellationQuotesAction extends cancellationQuotespo {

	utilityClass event = new utilityClass();

	public String validationMessage(String a) {

		event.inputfield("cssSelector", vinTextbox, a);
		event.clickfield("cssSelector", submit);
		return event.text("cssSelector", validationMessage1);

	}

	public String validationMessageLastName(String a) {

		event.inputfield("cssSelector", nameTextbox, a);
		event.clickfield("cssSelector", submit);
		return event.text("cssSelector", validationMessage1);

	}

	public String validationMessage() {

		event.clickfield("cssSelector", submit);
		return event.text("cssSelector", validationMessage1);

	}

	public String getFrontText() {

		return event.text("cssSelector", frontText);
	}

	
	public WebElement getCancelMileageInput() {

		return event.element("xpath", cancelMileageInput);
	}

	public String nameMaxLength() {

		return driver.findElement(By.cssSelector(nameTextbox)).getAttribute("maxlength");
	}

	public String contractMaxLength() {

		return driver.findElement(By.cssSelector(contractTextbox)).getAttribute("maxlength");
	}

	public String vinMaxLength() {

		return driver.findElement(By.cssSelector(vinTextbox)).getAttribute("maxlength");
	}

	public WebElement submitButton() {

		return event.element("cssSelector", submit);
	}

	public void searchdata(String field, String value) throws InterruptedException {

		if (field == "Contract") {

			event.inputfield("cssSelector", contractTextbox, value);
			event.clickfield("cssSelector", submit);
			Thread.sleep(5000);
		}
		else if (field == "Last_Name") {
			event.inputfield("cssSelector", nameTextbox, value);
			event.clickfield("cssSelector", submit);
			Thread.sleep(5000);
		}
		else if (field == "VIN") {
			
			System.out.println(value);
			int len = value.length();
			String newVin = value.substring(len -6, len);
			event.inputfield("cssSelector", vinTextbox , newVin);
			event.clickfield("cssSelector", submit);
			Thread.sleep(5000);
		}

	}

	public String recordText() throws InterruptedException {

		Thread.sleep(3000);
		driver.findElement(By.cssSelector("p-paginator >div > span")).getText();
		return driver.findElement(By.cssSelector("p-paginator >div > span")).getText();
	}
	
	public WebElement quoteLink() {
		return event.element("cssSelector", quoteLink);
	}
	public WebElement getQuoteBtn() {

		return event.element("xpath", quoteBtn);
	}
	
	public WebElement getCheckBox() {

		return event.element("xpath", checkBox);
	}
	
	public WebElement getEditBtn() {

		return event.element("xpath", editBtn);
	}
	
	public WebElement getCancelContractBtn() {

		return event.element("xpath", cancelContractBtn);
	}
	
	public WebElement getCompleteCancellationBtn() {

		return event.element("xpath", completeCancellationBtn);
	}
	
	
	public WebElement getBackBtn() {

		return event.element("xpath", backBtn);
	}
	
	public WebElement getContractTextbox() {

		return event.element("cssSelector", contractTextbox);
	}
	
	public WebElement getQuoteErrorMsg() {

		return event.element("xpath", quoteError);
	}
	
	public WebElement getCancellationErrorMsg() {

		return event.element("xpath", cancellationError);
	}
	
	public WebElement getCloseBtn() {

		return event.element("xpath", closeBtn);
	}
	
	public List<WebElement> errorElements() {
	List<WebElement> elements = driver.findElements(By.xpath(elementsInError));
	return elements;
	}
	
	public WebElement getCancelBtn() {

		return event.element("xpath", cancelBtn);
	}
	
	public void openCancellationModelBox() {
		quoteLink().click();
	}
	
	public void waitForThePageToLoad() throws InterruptedException {
		Thread.sleep(10000);
	}
	
	public HashMap<Integer,HashMap<String, String>> tabledata (){
		
		HashMap<Integer, HashMap<String, String>> tableMap = new HashMap<Integer, HashMap<String, String>>();
		int counter = 1;
		HashMap<String, String> map = new HashMap<String, String> ();
		int len = driver.findElements(By.xpath("//th")).size();
		System.out.println(len);
		for(int i =0; i<len -1; i++) {
			int k =0;
			driver.findElements(By.xpath("//th")).get(0).getText();
			map.put(driver.findElements(By.xpath("//th")).get(i).getText(), driver.findElements(By.xpath("//td//span[2]")).get(i).getText());
			k++;
			tableMap.put(counter, map);
		}
		
		
		return tableMap;
		
	}

}

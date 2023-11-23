package pageActions;

import java.util.HashMap;

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
		} else if (field == "Last_Name" || field == "CUSTOMER_LAST" ) {
			event.inputfield("cssSelector", nameTextbox, value);
			event.clickfield("cssSelector", submit);
			Thread.sleep(5000);
		} else if (field == "VIN") {

			int len = value.length();
			String newVin = value.substring(len - 6, len);
			System.out.println(newVin);
			event.inputfield("cssSelector", vinTextbox, newVin);
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

		return event.element("cssSelector", quote);
	}

	public void openCancellationModelBox() {

		quoteLink().click();

	}

	public WebElement modelBoxOverlay() throws InterruptedException {

		Thread.sleep(3000);
		return event.element("cssSelector", modelBox);
	}

	public String getContractNumber() {

		String cn = event.text("cssSelector", contractNumber1);
		String[] cancelContractNumber = cn.split(": ");
		return cancelContractNumber[1];
	}

	public String cancelLabelText() {

		return event.text("cssSelector", cancelLabel);
	}

	public String datefield() {

		return event.text("cssSelector", cancelDate);
	}

	public String validateInitiatedByValue() {

		String selectedValue = new String();
		for (int i = 0; i < driver.findElements(By.cssSelector(initiatedBy)).size(); i++) {
			if (driver.findElements(By.cssSelector(initiatedBy)).get(i).getAttribute("class")
					.contains("mat-radio-checked")) {
				selectedValue = driver.findElements(By.cssSelector(initiatedByLabel)).get(i).getText();
			}

		}

		return selectedValue;
	}

	public String validateCancelReasonValue() {

		String selectedValue = new String();
		for (int i = 0; i < driver.findElements(By.cssSelector(cancelReason)).size(); i++) {
			System.out.println(driver.findElements(By.cssSelector(cancelReasonLabel)).get(i).getText());
			if (driver.findElements(By.cssSelector(cancelReason)).get(i).getAttribute("class")
					.contains("mat-radio-checked")) {
				selectedValue = driver.findElements(By.cssSelector(cancelReasonLabel)).get(i).getText();
			}

		}

		return selectedValue;
	}
	
	public String disclaimerMessage() {
		
		return event.text("cssSelector", disclaimer);
	}
	
	public String emptyResult() {
		
		return event.text("cssSelector", tableText);
	}

	public String validationMessage1(String value) {

		event.clearfield("cssSelector", value);
		event.clickfield("cssSelector", quoteButton);
		return event.text("cssSelector", validationMessage, 0);
	}

	public String validatefield(String value) {

		return event.text("cssSelector", value);
	}

	public void fillCancelMileage(String value) {

		int num = Integer.parseInt(value);
		num = num - 1;
		System.out.println(num);
		String a = String.valueOf(num);
		event.inputfield("cssSelector", mileage, a);
		event.clickfield("cssSelector", quoteButton);
	}

	public String printQuote() {

		return event.text("cssSelector", printGenerateQuote, 0);
	}

	public String genarateQuote() {

		return event.text("cssSelector", printGenerateQuote, 1);
	}
	
	public void quotePDF() {
		
		event.clickfield("cssSelector", printGenerateQuote, 0);
	}
	
	public void cancelQuote() {

		event.clickfield("cssSelector", printGenerateQuote, 1);
	}
	

	public HashMap<Integer, HashMap<String, String>> tabledata() {

		HashMap<Integer, HashMap<String, String>> tableMap = new HashMap<Integer, HashMap<String, String>>();
		int counter = 1;
		HashMap<String, String> map = new HashMap<String, String>();
		int len = driver.findElements(By.xpath("//th")).size();
		for (int i = 0; i < len - 1; i++) {
			int k = 0;
			driver.findElements(By.xpath("//th")).get(0).getText();
			map.put(driver.findElements(By.xpath("//th")).get(i).getText(),
					driver.findElements(By.xpath("//td//span[2]")).get(i).getText());
			k++;
			tableMap.put(counter, map);
		}
		return tableMap;

	}

}

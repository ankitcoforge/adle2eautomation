package pageActions;

import java.text.NumberFormat;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import pageObjects.PricingPreferencesPO;
import utils.utilityClass;

public class PricingPreerencesAction extends PricingPreferencesPO{
	loginAction login = new loginAction();
	verticalMenuAction verticalMenu = new verticalMenuAction();
	
	utilityClass utils = new utilityClass();
	impersonateAction impersonate = new impersonateAction ();
	singleContractAction contractNew =new singleContractAction();
	generateContractAction gc = new generateContractAction();
	
	 public WebElement getPortalTitle() {
		 WebElement welcomeTitle=driver.findElement(By.xpath(portalTitle));	
		 return welcomeTitle;
	 }
	 
	 public List<String> getAllHeaderNames() {
		 List<String> allHeaderNames = utils.getTextValuesForObject("cssSelector", headerLoc);
         return allHeaderNames;
	 }
	 
	 public List<WebElement> getDropDwnList() throws InterruptedException {
			 List<WebElement> list = getDriver().findElements(By.xpath(roleDropdownList));
			 for(int i=1;i<list.size();i++) {
					String text = list.get(i).getText();
					System.out.println("Progms list is--"+text);
			 }
			 return list;
		}
	 
//	 public List<WebElement> getRadioBtns() {
//		 List<WebElement> radioBtns = getDriver().findElements(By.xpath(markupRadioBtn));
//         return radioBtns;
//	 }
	 
	 
	 public WebElement getMarkupAmountDollarSign() {
		 WebElement amountSign=driver.findElement(By.xpath(markupAmountDollarSign));	
		 return amountSign;
	 }
	 
	 public WebElement getMarkupAmountPercentSign() {
		 WebElement amountSign=driver.findElement(By.xpath(markupAmountPercentSign));	
		 return amountSign;
	 }
	 
	 public List<WebElement> getMarkupTxts() {
		 List<WebElement> amountSign=driver.findElements(By.xpath(markupTxts));	
		 return amountSign;
	 }
	 
	 public List<WebElement> getBtnsmarkup() {
		 List<WebElement> markupbtns=driver.findElements(By.cssSelector(btnsmarkup));	
		 return markupbtns;
	 }
	 
	 public List<WebElement> getMarkupAmountTxtFld() {
		 List<WebElement> markupAmountTxtFlds=driver.findElements(By.xpath(markupAmountTxtFld));	
		 return markupAmountTxtFlds;
	 }
	 
	 public WebElement getSelectAllCheckBox() {
		 WebElement selectAll=driver.findElement(By.cssSelector(selectAllCheckBox));	
		 return selectAll;
	 }
	 
	 public String singleContract() throws InterruptedException {
		 Thread.sleep(2000);
		 
			utils.clickfield("cssSelector", table, 0);
			Thread.sleep(5000);
			utils.scrollDown();
			utils.inputfield("cssSelector", textbox, "22723", 7);
			utils.inputfield("cssSelector", contract, "10000", 0);
			utils.clickfield("xpath", businessUse);
			String contractNumber = driver.findElement(By.cssSelector(contractNo)).getDomProperty("value");
			System.out.println("Contract Number is:"+contractNumber);
			
			List <WebElement> a = driver.findElements(By.cssSelector(contractNew.inServiceDate));
			if(a.size() == 1) {
				String a1  = driver.findElement(By.cssSelector(contractNew.inServicefield)).getAttribute("class");
				if(!(a1.contains("disabled"))) {
					driver.findElement(By.cssSelector(contractNew.inServiceDateTextBox)).click();
					driver.findElement(By.cssSelector("td[aria-label='" + getDate() + "']")).click();
				}
				
			}
			//Assert.assertEquals(contractNew.addGapLabel(), "Add GAP");

			driver.findElements(By.cssSelector(pincode)).get(0).clear();
			utils.inputfield("cssSelector", pincode, "20130", 0);
			driver.findElements(By.cssSelector(address)).get(0).clear();
			utils.inputfield("cssSelector", address, "Address", 0);
			driver.findElements(By.cssSelector(email)).get(0).clear();
			utils.inputfield("cssSelector", email, "test@gmail.com", 0);
			Thread.sleep(2000);
			utils.clearfield("cssSelector", contractNew.phone);
			utils.inputfield("cssSelector", contractNew.phone, "1234567890");
			utils.clickfield("xpath", contractNew.generateContract);
			getDriver().findElement(By.xpath(gc.generateContractHeading)).isDisplayed();
			Thread.sleep(2000);
			utils.clickfield("cssSelector", gc.checkbox, 0);
			utils.clickfield("cssSelector", gc.checkbox, 1);
			utils.clickfield("xpath", gc.genrateContractButton);
			Thread.sleep(10000);
			String text1 = utils.text("cssSelector", contractNew.successMessage);
			Assert.assertEquals(text1, "You have successfully generated a contract!");
			utils.clickfield("xpath", contractNew.newQuotelink);
			return contractNumber;
			}
	 

}

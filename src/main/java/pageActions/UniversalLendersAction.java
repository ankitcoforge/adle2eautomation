package pageActions;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import pageObjects.UniversalLendersPO;
import utils.utilityClass;

public class UniversalLendersAction extends UniversalLendersPO{
	
	utilityClass utils = new utilityClass();
	WebMileageExceptionAction wme= new WebMileageExceptionAction();
	cobuyerContractAction cobuyerContract = new cobuyerContractAction();
	createContractAction contract = new createContractAction();
	 generateContractAction gc = new generateContractAction();
	 EditContractAction EditContractAction=new EditContractAction();
	 singleContractAction singleContractAction=new singleContractAction();
	
	
	 public void getProducts(String VIN, String Mileage) throws ParseException, InterruptedException {
		 utils.inputfield("cssSelector", wme.textbox, "Single", 0);
		 utils.inputfield("cssSelector", wme.textbox, "Test", 1);
		 utils.inputfield("cssSelector", wme.textbox, "Universal Lenders LLC", 2);
		 selectDropDown();
		 utils.inputfield("cssSelector", wme.textbox, Mileage, 5);
		 utils.inputfield("cssSelector", wme.textbox, VIN, 6);
		 utils.clickfield("xpath", wme.getProducts);
		 Thread.sleep(10000);
		 }
	 
	 public void selectDropDown() throws InterruptedException {
		 Thread.sleep(1000);
		 List<WebElement> list = getDriver().findElements(By.xpath(roleDropdownList));
		 
	    for(int i=0;i<list.size();i++) {
			list.get(i).click();
			break;
		}
	 }
	 
	 public List<WebElement> getRadioBtnsForPrograms() {
		  List<WebElement> radioButtons = driver.findElements(By.xpath(radioButtonForPrograms));	
		 return radioButtons;
	 }
	 
	 public WebElement getTotalTxt() {
		  WebElement radioButtons = driver.findElement(By.xpath(totalTxt));	
		 return radioButtons;
	 }
	 
	 public WebElement getTotalValue() {
		 WebElement radioButtons = driver.findElement(By.xpath(totalValue));	
		 return radioButtons;
	 }
	 public WebElement getRetailPrice() {
		 WebElement radioButtons = driver.findElement(By.xpath(retailPrice));	
		 return radioButtons;
	 }
	 public WebElement getTax() {
		 WebElement radioButtons = driver.findElement(By.xpath(tax));	
		 return radioButtons;
	 }
	 
	 public void selectProgram(String programName) {

			getDriver().findElement(By.xpath(programfirstname + programName + programlastname)).isDisplayed();
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("arguments[0].click()",getDriver().findElement(By.xpath(programfirstname + programName + programlastname + "/preceding-sibling::div")));
			//getDriver().findElement(By.xpath(programfirstname + programName + programlastname + "/preceding-sibling::div"))
				//	.click();
		}
	 
	 public WebElement verifyErrorMsg(String txt) {
		 WebElement ele = getDriver().findElement(By.xpath("//label[contains(text(),'" + txt + "')]/../../div[3]/adl-form-error/div/span"));
		 return ele;
	 }
	 
			 public WebElement verifyErrorMsgForCobuyer(String txt) {
				 WebElement ele = getDriver().findElement(By.xpath("(//label[contains(text(),'" + txt + "')]/../../div[3]/adl-form-error/div/span)[2]"));
				 return ele;
			 }

		public String coBuyerContractwithMandatoryFields() throws InterruptedException {
			String contractNumber = null;
			try {
			utils.inputfield("cssSelector", wme.textbox, "Test", 1);
			utils.inputfield("cssSelector", wme.textbox, "1234", 5);
			utils.inputfield("cssSelector", wme.textbox, "Universal Lenders LLC", 2);
			selectDropDown();
			utils.inputfield("cssSelector", wme.textbox, "5J6RW2H89NA004619", 6);
			utils.clickfield("xpath", singleContractAction.getProducts);
			utils.scrollDownUsingJSE();
			contract.programSelect("Absolute Certified Warranty");
			utils.clickfield("cssSelector", singleContractAction.table, 0);
			utils.inputfield("cssSelector", singleContractAction.textbox, "22723", 7);
			utils.inputfield("cssSelector", singleContractAction.contract, "10000", 0);
			contractNumber = driver.findElement(By.cssSelector(singleContractAction.contractNo)).getDomProperty("value");
			System.out.println("Contract Number is:" + contractNumber);
			utils.scrollDownUsingJSE();
			Thread.sleep(2000);
			driver.findElements(By.cssSelector(contract.textbox)).get(14).clear();
			utils.inputfield("cssSelector", contract.textbox, "20130", 14);
			driver.findElements(By.cssSelector(contract.textbox)).get(13).clear();
			utils.inputfield("cssSelector", contract.textbox, "Address", 13);
			Thread.sleep(2000);
			utils.clearfield("cssSelector", contract.phone);
			utils.inputfield("cssSelector", contract.phone, "1234567");
			 JavascriptExecutor jse = (JavascriptExecutor)driver;
			    jse.executeScript("arguments[0].click()", driver.findElement(By.cssSelector(cobuyerContract.coBuyer))); 
			    Thread.sleep(2000);
			    utils.scrollDown();
			    utils.inputfield("cssSelector", cobuyerContract.fieldbyLabelName("Last Name"), "CoBuyerLasttName",2);
			utils.inputfield("cssSelector", cobuyerContract.fieldbyLabelName("Zip Code"), "20301", 1);
			utils.inputfield("cssSelector", cobuyerContract.fieldbyLabelName("Address"), "Address Co Buyer" , 1);
			Thread.sleep(2000);
			utils.clearfield("cssSelector", cobuyerContract.fieldbyLabelName("Phone Number"),1);
			utils.inputfield("cssSelector", cobuyerContract.fieldbyLabelName("Phone Number"),"1234567890",1);
			Thread.sleep(10000);
			Assert.assertTrue(utils.getfield("xpath", nextButton).isEnabled(),"Next button is enabled");
			utils.clickfield("xpath", nextButton);
			Thread.sleep(2000);
			Assert.assertTrue(getRetailPrice().isDisplayed());
			Assert.assertTrue(getTax().isDisplayed());
			utils.clickfield("xpath", cobuyerContract.generateContract);
			Thread.sleep(2000);
			getDriver().findElement(By.xpath(gc.generateContractHeading)).isDisplayed();
			utils.clickfield("cssSelector", gc.checkbox, 0);
			utils.clickfield("cssSelector", gc.checkbox, 1);
			utils.clickfield("xpath", gc.genrateContractButton);
			Thread.sleep(5000);
			String text1 = utils.text("cssSelector", cobuyerContract.successMessage);
			Assert.assertEquals(text1, "You have successfully generated a contract!");
			utils.clickfield("xpath", cobuyerContract.newQuotelink);
			}
			catch(Exception e) {
				e.printStackTrace();
				System.out.println("Test Case failed ");
//				e.getCause();
//				Assert.fail();
			}
			return contractNumber;
			
		}
	 

}


















package pageActions;

import java.text.ParseException;

import org.openqa.selenium.Keys;

import pageObjects.QuickCodeMarkupAListLienholderPO;
import utils.XmlDataReader;
import utils.utilityClass;

public class QuickCodeMarkupAListLienholderAction extends QuickCodeMarkupAListLienholderPO {

	utilityClass utils = new utilityClass();
	createContractAction co = new createContractAction();

	public void selectLienholder(String lienholdr) throws InterruptedException {
		utils.element("xpath", lienholder).sendKeys(lienholdr);
//		utils.waitTillElementIsVisible(partner);
		Thread.sleep(2000);
		utils.element("xpath", lienholder).sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
	}
	
	public void closePopup() throws InterruptedException {
			if (utils.getfield("mat-icon", "close").isDisplayed()) {
				utils.getfield("mat-icon", "close").click();
			}
	}
	
	 public void EnterMileageVINAndSelectProgram(String vehicleProgram) throws ParseException {
		 utils.inputfield("cssSelector", textbox, "100", 5);
		 utils.inputfield("cssSelector", textbox, "3KPC24A65LE098830", 6);
		 utils.clickfield("xpath", getProducts);
		 co.programSelect(vehicleProgram);
	 }
	 
	 public void EnterMileageVINAndSelectProgramForLender(String vehicleProgram) throws ParseException {
		 utils.inputfield("cssSelector", textbox, "100", 4);
		 utils.inputfield("cssSelector", textbox, "3KPC24A65LE098830", 5);
		 utils.clickfield("xpath", getProducts);
		 co.programSelect(vehicleProgram);
	 }

}

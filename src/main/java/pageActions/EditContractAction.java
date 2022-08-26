package pageActions;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pageObjects.EditContractpo;
import utils.Database_Connectivity;
import utils.utilityClass;

public class EditContractAction extends EditContractpo {
	
	utilityClass utils= new utilityClass();
	Database_Connectivity dc = new Database_Connectivity();

	 public WebElement getTitle() {
		 WebElement welcomeTitle=driver.findElement(By.xpath(ADLwelcometitle));	
		 return welcomeTitle;
	 }
	 
	 public WebElement getContractSearchPagetitle() {
		 WebElement contractSearchtitle=driver.findElement(By.xpath(contractSearchPagetitle));	
		 return contractSearchtitle;
	 }
	 
	 public WebElement getEditContractPagetitle() {
		 WebElement editContractTitle=driver.findElement(By.xpath(editContractPagetitle));	
		 return editContractTitle;
	 }
	 

	 public WebElement getBtnCancel() {
		 WebElement cancelBtn=driver.findElement(By.xpath(btnCancel));	
		 return cancelBtn;
	 }
	 

	 public WebElement getBtnSave() {
		 WebElement saveBtn=driver.findElement(By.xpath(btnSave));	
		 return saveBtn;
	 }
	 
	 public WebElement getLienholderTxtField() {
		 WebElement lienholder=driver.findElement(By.xpath(lienholderTxtField));	
		 return lienholder;
	 }
	 
	 
	 public List<WebElement> getLeinholderList() {
		 List<WebElement> leinholderList = driver.findElements(By.cssSelector(lienholderlist));	
		 return leinholderList;
	 }
	 
	 public List<WebElement> getLienholderlistwithBackground() {
		 List<WebElement> leinholderList = driver.findElements(By.cssSelector(lienholderlistwithBackground));	
		 return leinholderList;
	 }
	 
	 public List<WebElement> getContarctInfoTxtFields1() {
		  List<WebElement> contarctInfo = driver.findElements(By.xpath(contarctInfoTxtFields1));	
		 return contarctInfo;
	 }
	 
	 public List<WebElement> getContarctInfoTxtFields2() {
		 List<WebElement> contarctInfo=driver.findElements(By.xpath(contarctInfoTxtFields2));	
		 return contarctInfo;
	 }
	 
	 public WebElement getCobuyerChkbox() {
		 WebElement coBuyerCheckbox=driver.findElement(By.xpath(coBuyerChkbox));	
		 return coBuyerCheckbox;
	 }
	 
	 public WebElement getCoBuyerChkboxField() {
		 WebElement coBuyerCheckbox=driver.findElement(By.xpath(coBuyerChkboxField));	
		 return coBuyerCheckbox;
	 }
	 
	 public WebElement getVehiclePurchaseTxtfield() {
		 WebElement vehiclePurchaseTxtfield=driver.findElement(By.cssSelector(vehiclePurchaseTxtField));	
		 return vehiclePurchaseTxtfield;
	 }
	 
	 public WebElement getContactRetailPriceTxtField() {
		 WebElement contactRetailPriceTxt=driver.findElement(By.cssSelector(contactRetailPriceTxtField));	
		 return contactRetailPriceTxt;
	 }
	 
	 public List<WebElement> getCoustomerInfoFields() {
		 List<WebElement> coustomerInfoField=driver.findElements(By.xpath(coustomerInfoTxtFields));	
		 return coustomerInfoField;
	 }
	 
	 public List<WebElement> coustomerInfoHighlighter() {
		 List<WebElement> coustomerInfo=driver.findElements(By.xpath(coustomerInfoHighlighter));	
		 return coustomerInfo;
	 }
	 
	 public WebElement getContractSubmittedSuccessTxt() {
		 WebElement contractSubmittedTxt=driver.findElement(By.xpath(contractSubmittedSuccessTxt));	
		 return contractSubmittedTxt;
	 }
	 
	 public WebElement getGoToContractsPageLink() {
		 WebElement goToContractsPageLnk=driver.findElement(By.xpath(goToContractsPageLink));	
		 return goToContractsPageLnk;
	 }
	 
	 public List<String> getRowLoc() {
		 List<String> rowLoactor = utils.getTextValuesForObject("cssSelector", rowLoc);
         return rowLoactor;
	 }
	 
	 
	 public WebElement getInvalidLienholderTxt() {
		 WebElement invalidLienholder=driver.findElement(By.xpath(invalidLienholderTxt));	
		 return invalidLienholder;
	 }
	 
			public HashMap<Integer, HashMap<String, String>> getDataFromDB(String contactNum) throws Exception  {
			HashMap<Integer, HashMap<String, String>> dbMap = new HashMap<Integer, HashMap<String, String>>();
			try {
				dc.aulDBConnect();
				ResultSet rs = dc.stmt.executeQuery(
						"Select *  from [dbo].[WEB_CONTRACTS] as wc inner join [dbo].[web_contracts_extended] as we on wc.id =we.web_contracts_id where wc.CERT = '" + contactNum + "';");
				dbMap = dc.returnAllData(rs);
				return dbMap;
			} catch (Exception e) {
				throw e;
			} finally {
				dc.closeConnection();
			}
			
		}
	 
}

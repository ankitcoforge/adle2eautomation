package pageActions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import pageObjects.AssigningLenderPassthroughToAgentCorpPO;
import utils.utilityClass;

public class AssigningLenderPassthroughToAgentCorpAction extends AssigningLenderPassthroughToAgentCorpPO{

	utilityClass utils= new utilityClass();

	 public WebElement getManageAgencyBtn(int row) throws InterruptedException {
			String specificRowLoc = "table>tbody>tr:nth-of-type(" + row + ")";
			String specificRowColLoc = "td:nth-of-type(8)>adl-table-cells>div>div:nth-of-type(1)>i";
			WebElement  element = utils.element("cssSelector", specificRowLoc + ">" + specificRowColLoc);
            return element;
}
	 
	 public void selectRoleID(String accountName) throws InterruptedException {
		 utils.element("xpath", roleId).sendKeys(accountName);
			List<WebElement> list = getDriver().findElements(By.xpath(roleDropdownListForAccountName));
			list.get(0).click();
	 }
	 
	 public void getAssignLenders() throws InterruptedException {
		 List<WebElement> list = utils.getElementsList("xpath", checkBox);
		 List<WebElement> listStatus = utils.getElementsList("xpath", checkBoxStatus);
		 for (int i = 0; i < list.size(); i++) {
			 if(listStatus.get(i).getAttribute("aria-checked").equals("false")){
				 list.get(i).click();
				 utils.element("xpath", saveBtn).click();
				 Thread.sleep(2000);
			 }
			 else {
				 utils.element("xpath", cancelBtn).click();
				 Thread.sleep(2000); 
			 }
		 }
		 
		
	 }
	 
	 public void getAssignMoreThanOneLender(String accountName,String accountName2) throws InterruptedException {
		 utils.element("xpath", roleId).sendKeys(accountName);
			List<WebElement> list1 = getDriver().findElements(By.xpath(roleDropdownListForAccountName));
			list1.get(0).click();
		 List<WebElement> list = utils.getElementsList("xpath", checkBox);
		 List<WebElement> listStatus = utils.getElementsList("xpath", checkBoxStatus);
			 if(listStatus.get(0).getAttribute("aria-checked").equals("false")){
				 list.get(0).click();
		 }
			 utils.element("xpath", roleId).clear();
			 utils.element("xpath", roleId).sendKeys(accountName2);
				List<WebElement> list2 = getDriver().findElements(By.xpath(roleDropdownListForAccountName));
				list2.get(0).click();
			 List<WebElement> list3 = utils.getElementsList("xpath", checkBox);
			 List<WebElement> listStatus1 = utils.getElementsList("xpath", checkBoxStatus);
				 if(listStatus1.get(0).getAttribute("aria-checked").equals("false")){
					 list3.get(0).click();
			 }
				 utils.element("xpath", saveBtn).click();
				 Thread.sleep(2000);	 
	 }
	 
	 public void removeAssignedLenders() throws InterruptedException {
		 List<WebElement> list = utils.getElementsList("xpath", checkBox);
		 if(list.size()>0) {
		 for (int i = 0; i < list.size(); i++) {
		 list.get(i).click();
		 }
		 utils.element("xpath", removeLink).click();
//		 utils.element("xpath", saveBtn).click();
		 }
		 Thread.sleep(2000);
	 }
	 
		public WebElement getBtnSignIn() {
			WebElement ele = driver.findElement(By.xpath(btnSignIn));	
			 return ele; 
		 }

	 public void getSelectLenderLenderPassthroughTogenerateContract(String dealer) throws InterruptedException {
			WebElement ele = driver.findElement(By.xpath(selectAgentName));
			ele.click();
			ele.sendKeys(dealer);
			ele.sendKeys(Keys.ARROW_DOWN);
			ele.sendKeys(Keys.ENTER);
			Thread.sleep(2000);
			getBtnSignIn().click();
			Thread.sleep(2000);
		}
	

}

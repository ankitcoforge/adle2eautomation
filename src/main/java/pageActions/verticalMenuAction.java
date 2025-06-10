package pageActions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import pageObjects.verticalMenupo;
import utils.baseClass;
import utils.utilityClass;

public class verticalMenuAction extends verticalMenupo{

	utilityClass event = new utilityClass();
	
	
	
	/***************************Navigate to Contract page
	 * @throws InterruptedException *******************************/
	public void navigatetoContract() throws InterruptedException {

		Thread.sleep(5000);
		driver.switchTo().activeElement();
		event.clickfield("xpath", erate);
		event.clickfield("xpath", contract);
		Thread.sleep(2000);

	}
	
	/***************************Navigate to Contract page
	 * @throws InterruptedException *******************************/
	public void navigatetoimpersonate() throws InterruptedException {

		Thread.sleep(4000);
		driver.switchTo().activeElement();
		event.clickfield("xpath", accountManagement);
		event.clickfield("xpath", impersonate);
		Thread.sleep(2000);

	}
	
	
	public void navigatetoLeftMenu(String heading, String subheading) throws InterruptedException {
		Thread.sleep(6000);
		driver.switchTo().activeElement();
		event.getfield("button", heading).click();
		event.getfield("a", subheading).click();
		Thread.sleep(2000);

	}
	
	public void navigatetoLeftMenu(String subheading) throws InterruptedException {
		Thread.sleep(6000);
		driver.switchTo().activeElement();
		event.getfield("a", subheading).click();
		Thread.sleep(2000);

	}

	public void navigatetoLeftMainMenu(String heading) throws InterruptedException {
		Thread.sleep(6000);
		driver.switchTo().activeElement();
		event.getfield("button", heading).click();
		Thread.sleep(5000);
	}
	
	public String getTitle() {
		return (event.text("cssSelector", "header > div >h3"));
	}
	
	public void navigateToMileageAndAgeException() throws InterruptedException {
		Thread.sleep(4000);
		driver.switchTo().activeElement();
		event.clickfield("xpath", accountManagement);
		event.clickfield("xpath", milaegeAndAgeExceptions);
		Thread.sleep(4000);
	}
	
	 public List<WebElement> getLaterMenuSubItems () {
		  List<WebElement> subItems = driver.findElements(By.cssSelector(laterMenuSubItems));	
		 return subItems;
	 }
	
//	public void navigatetoimpersonateFromRightTop() throws InterruptedException {
//		event.clickfield("xpath", arrowbtnAtRightTop);
//		Thread.sleep(2000);
//		driver.switchTo().activeElement();
//		System.out.println("list is"+getArrowOptionsList().get(1).getText());
//		
//		Thread.sleep(4000);
//		//event.clickfield("xpath", impersonateAtRightTop);
//	}
//	
//	 public List<WebElement> getArrowOptionsList() {
//		  List<WebElement> list = driver.findElements(By.xpath(arrowOptionsList));	
//		 return list; 
//	 }
	
	 public List<WebElement> getLateralMenuItems1 () {
		  List<WebElement> menuItems = driver.findElements(By.cssSelector(lateralMenuItems1));	
		 return menuItems;
	 }
	 
	 public List<WebElement> getLateralMenuItems2 () {
		  List<WebElement> menuItems = driver.findElements(By.cssSelector(lateralMenuItems2));	
		 return menuItems;
	 }
	 
	 public void verifyLateralmenuMainItemsForAgentSubAgent() {
			String toolbox = getLateralMenuItems2().get(1).getText();
			String dashboard = getLateralMenuItems2().get(0).getText();
			ArrayList<String> list = new ArrayList<String>();
			for(int i=0; i<getLateralMenuItems1().size(); i++) {
				String[] menuItem = getLateralMenuItems1().get(i).getText().split("chevron_right");
				list.add(menuItem[0].trim());
				list.add(toolbox);
				list.add(dashboard);
			}
			
			System.out.println(list);
			  Assert.assertTrue(list.contains("Dashboard"));
				Assert.assertTrue(list.contains("E-Rate"));
				Assert.assertTrue(list.contains("Contracts"));
				Assert.assertTrue(list.contains("Report"));
				Assert.assertTrue(list.contains("Dealer Settings"));
				Assert.assertTrue(list.contains("Agency Settings"));
				Assert.assertTrue(list.contains("Toolbox"));
				Assert.assertTrue(list.contains("Help"));
		}
	 
	 public void verifyLateralmenuMainItemsForDealerDealerEmpDealerGrpEmp() {
			String toolbox = getLateralMenuItems2().get(1).getText();
			String dashboard = getLateralMenuItems2().get(0).getText();
			ArrayList<String> list = new ArrayList<String>();
			for(int i=0; i<getLateralMenuItems1().size(); i++) {
				String[] menuItem = getLateralMenuItems1().get(i).getText().split("chevron_right");
				list.add(menuItem[0].trim());
				list.add(toolbox);
				list.add(dashboard);
			}
			
			System.out.println(list);
			  Assert.assertTrue(list.contains("Dashboard"));
				Assert.assertTrue(list.contains("E-Rate"));
				Assert.assertTrue(list.contains("Contracts"));
				Assert.assertTrue(list.contains("Cancellations"));
				Assert.assertTrue(list.contains("Report"));
				Assert.assertTrue(list.contains("My Settings"));
				Assert.assertTrue(list.contains("Toolbox"));
				Assert.assertTrue(list.contains("Help"));
		}
}


package pageActions;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pageObjects.contractpo;
import utils.utilityClass;

public class erateAction extends contractpo{
	
	 utilityClass event = new utilityClass();
	 
	 public boolean qc() {
		 return driver.findElement(By.cssSelector(qc)).isDisplayed();
	 }
	 
	 public boolean noVin() {
		 return driver.findElement(By.cssSelector(noVin)).isDisplayed();
	 }
	 
	 public boolean state() {
		 return driver.findElement(By.cssSelector(state)).isDisplayed();
	 }
	 
	 public boolean mandatory() {
		 return driver.findElement(By.cssSelector(mandatoryState)).isDisplayed();
	 }
	 
	 public boolean dropdown() {
		 return driver.findElement(By.className(dropdownState)).isDisplayed();
	 }
	 
	 public boolean businessUse() {
		 return driver.findElement(By.cssSelector(businessUseCheckbox)).isDisplayed();
	 }
	 
	 public int programListed() {
		 event.inputfield("cssSelector", vinTextbox,"5XYZUDLB7DG006717");
		 event.inputfield("cssSelector", mileage, "1234");
		 event.clickfield("cssSelector", getProductsButton );
		 List<WebElement> program = driver.findElements(By.cssSelector(programCheckbox));
		 return program.size();
	 }
}

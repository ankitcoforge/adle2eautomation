package pageActions;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pageObjects.contractpo;
import utils.utilityClass;

public class erateAction extends contractpo{
	
	 utilityClass event = new utilityClass();
	 
	 public boolean qc() {
		 return driver.findElement(By.cssSelector("adl-text-input[label='Quick Code']")).isDisplayed();
	 }
	 
	 public boolean noVin() {
		 return driver.findElement(By.cssSelector("adl-checkbox[label=\"No VIN\"]")).isDisplayed();
	 }
	 
	 public boolean state() {
		 return driver.findElement(By.cssSelector("adl-select[label=\"State\"]")).isDisplayed();
	 }
	 
	 public boolean mandatory() {
		 return driver.findElement(By.cssSelector("adl-select[label=\"State\"] >div > label >span")).isDisplayed();
	 }
	 
	 public boolean dropdown() {
		 return driver.findElement(By.className("ng-select-container")).isDisplayed();
	 }
	 
	 public boolean businessUse() {
		 return driver.findElement(By.cssSelector("adl-checkbox[label=\"Business Use\"] >div >mat-checkbox > label >div >input[type=\"checkbox\"]")).isDisplayed();
	 }
	 
	 public int programListed() {
		 driver.findElement(By.cssSelector("adl-text-input[label=\"VIN\"] >div >div >input")).sendKeys("5XYZUDLB7DG006717");
		 driver.findElement(By.cssSelector("adl-text-input[label=\"Mileage\"] >div >div >input")).sendKeys("1234");
		 driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
		 List<WebElement> program = driver.findElements(By.cssSelector("div[class=\"programs__checkboxes col-12 grid ng-star-inserted\"] >adl-checkbox"));
		 return program.size();
	 }
}

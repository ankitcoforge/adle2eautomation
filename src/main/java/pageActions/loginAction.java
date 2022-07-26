package pageActions;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import pageObjects.impersonatepo;
import pageObjects.loginpo;
import utils.utilityClass;

public class loginAction extends loginpo {
	
	utilityClass event = new utilityClass();
	impersonatepo io = new impersonatepo ();
	
	/****** Title of the webpage ******/
	public String getTitle() {

		return (driver.getTitle());
    }
	
	/***********************Login to ADL page 
	 * @throws InterruptedException *****************************************/
	public String login(String username, String password) throws InterruptedException {
		
		driver.findElement(By.cssSelector("input[placeholder=\"Enter your username\"]")).isDisplayed();
		driver.findElement(By.cssSelector("input[placeholder=\"Enter your username\"]")).sendKeys(username);
		driver.findElement(By.cssSelector("input[placeholder=\"Enter your password\"]")).isDisplayed();
	    driver.findElement(By.cssSelector("input[placeholder=\"Enter your password\"]")).sendKeys(password);
	    driver.findElement(By.cssSelector("button[type='submit']")).click();
	    driver.findElement(By.cssSelector("[class=\"title-bar\"] >h3")).isDisplayed();
		String header1 = driver.findElement(By.cssSelector("[class=\"title-bar\"] >h3")).getText();
		return header1;
	}
	

	/***********************Login to ADL page 
	 * @throws InterruptedException *****************************************/
	public String loginValidation() throws InterruptedException {
		
		driver.findElement(By.cssSelector("input[placeholder=\"Enter your username\"]")).isDisplayed();
		driver.findElement(By.cssSelector("input[placeholder=\"Enter your password\"]")).isDisplayed();
	    driver.findElement(By.cssSelector("button[type='submit']")).click();
	    driver.findElement(By.cssSelector("adl-form-error > div > span")).isDisplayed();
		String header1 = driver.findElement(By.cssSelector("adl-form-error > div > span")).getText();
		return header1;
	}
	
	/***********************Login to ADL page 
	 * @throws InterruptedException *****************************************/
	public String loginValidation(String username) throws InterruptedException {
		
		driver.findElement(By.cssSelector("input[placeholder=\"Enter your username\"]")).isDisplayed();
		driver.findElement(By.cssSelector("input[placeholder=\"Enter your username\"]")).sendKeys(username);
		driver.findElement(By.cssSelector("input[placeholder=\"Enter your password\"]")).isDisplayed();
	    driver.findElement(By.cssSelector("button[type='submit']")).click();
	    driver.findElement(By.cssSelector("adl-form-error > div > span")).isDisplayed();
		String header1 = driver.findElement(By.cssSelector("adl-form-error > div > span")).getText();
		return header1;
	}
	
	/***********************Login to ADL page 
	 * @throws InterruptedException *****************************************/
	public String loginValidation(String username, String password) throws InterruptedException {
		
		driver.findElement(By.cssSelector("input[placeholder=\"Enter your username\"]")).isDisplayed();
		driver.findElement(By.cssSelector("input[placeholder=\"Enter your username\"]")).sendKeys(username);
		driver.findElement(By.cssSelector("input[placeholder=\"Enter your password\"]")).isDisplayed();
		driver.findElement(By.cssSelector("input[placeholder=\"Enter your password\"]")).sendKeys(password);
	    driver.findElement(By.cssSelector("button[type='submit']")).click();
	    driver.findElement(By.cssSelector("adl-form-error > div > span")).isDisplayed();
		String header1 = driver.findElement(By.cssSelector("adl-form-error > div > span")).getText();
		return header1;
	}
	
	
	
	
	/***********************Login to ADL page 
	 * @throws InterruptedException *****************************************/
	public String login(String username, String password, String roleType) {
		
		event.inputfield("xpath", userpass, username, 0);
		event.inputfield("xpath", userpass, password, 1);
		event.clickfield("xpath", submit, 1);
		event.clickfield("xpath", "//button[contains(text(),'Reports')]");
		event.clickfield("xpath", "//a[contains(text(),'Impersonate')]");
		driver.switchTo().frame(1);
		Select objSelect =new Select(driver.findElement(By.id("ctl00_mainContent_DropDownListRoleType")));
		objSelect.selectByVisibleText(roleType);
        driver.switchTo().defaultContent();
        driver.switchTo().frame(1);
		driver.findElement(By.cssSelector("#cnt table #container table tbody tr input")).click();
		event.inputfield("cssselector","#cnt table #container table tbody tr input","28771");
		event.clickfield("id", "ctl00_mainContent_ButtonGetUsers");
		event.clickfield("id", "ctl00_mainContent_ASPxGridViewUsers_cell0_11_ASPxButtonImpersonate");
		driver.switchTo().defaultContent();
		driver.switchTo().parentFrame();
		String header1 = event.text("xpath", header, 0);
		return header1;
	}

	
		/************************Logout of ADL page
		 * @throws InterruptedException ***************************************/
	public void logout() throws InterruptedException{
		
		Thread.sleep(9000);
		driver.switchTo().defaultContent();
		driver.findElement(By.cssSelector(io.logoutArrow)).isDisplayed();
		driver.findElement(By.cssSelector(io.logoutArrow)).click();
		event.clickfield("xpath", logout);
	}

}

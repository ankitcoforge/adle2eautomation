package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.devtools.v85.browser.Browser;
import org.openqa.selenium.support.ui.Select;

import utils.baseClass;
import utils.utilityClass;

public class loginpo extends baseClass{
	
	/*************page object for login page is declared ********************/
	public String header = "[class=\"title-bar\"] >h3";
	public String arrowButton = "header > div > div > button > mat-icon";
	public String logout = "//button[contains(text(),'Logout')]";
	public String userpass = "//input";
	public String submit ="//button";
	
}

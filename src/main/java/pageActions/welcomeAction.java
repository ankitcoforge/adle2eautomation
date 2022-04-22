package pageActions;

import org.openqa.selenium.WebElement;

import pageObjects.welcomepo;
import utils.utilityClass;

public class welcomeAction extends welcomepo{


	utilityClass uc = new utilityClass();

	public String eclaim() {

		uc.element("cssSelector", eclaimText).isDisplayed();
		return (uc.element("cssSelector", eclaimText).getAttribute("link"));
	}

	public String rememberPassText() {

		uc.element("cssSelector", rememberPassword).isDisplayed();
		return (uc.element("cssSelector", rememberPassword).getText());
	}

	public String rememberPassDisplay() {

		uc.element("cssSelector", display).isDisplayed();
		return (uc.element("cssSelector", display).getAttribute("Style"));
	}


	public String privacyPolicyLink() {

		uc.element("cssSelector", privacyPolicy).isDisplayed();
		return (uc.element("cssSelector", privacyPolicy).getText());
	}
	
	public String welcomeTextLink() {

		uc.element("cssSelector", welcomeText).isDisplayed();
		return (uc.element("cssSelector", welcomeText).getText());
	}
	
	public String gapPortalLink() {

		uc.element("cssSelector", gapText).isDisplayed();
		
		return (uc.element("cssSelector", gapText).getAttribute("link"));
	}
	
	public String forgotPasswordLink() {
		
		uc.element("cssSelector", forgotPassword).isDisplayed();
		return (uc.element("cssSelector", forgetPasswordText).getText());
	}
	
	public boolean imageShown() {
		return (uc.element("cssSelector",image).isDisplayed());
	}




}

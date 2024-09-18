package pageActions;

import org.openqa.selenium.WebElement;

import pageObjects.welcomepo;
import utils.utilityClass;

public class welcomeAction extends welcomepo{


	utilityClass uc = new utilityClass();

	public String eclaim() throws InterruptedException {

		uc.element("cssSelector", eclaimText).isDisplayed();
		return (uc.element("cssSelector", eclaimText).getAttribute("link"));
	}

	public String rememberPassText() throws InterruptedException {

		uc.element("cssSelector", rememberPassword).isDisplayed();
		return (uc.element("cssSelector", rememberPassword).getText());
	}

	public String rememberPassDisplay() throws InterruptedException {

		uc.element("cssSelector", display).isDisplayed();
		return (uc.element("cssSelector", display).getAttribute("Style"));
	}


	public String privacyPolicyLink() throws InterruptedException {

		uc.element("cssSelector", privacyPolicy).isDisplayed();
		return (uc.element("cssSelector", privacyPolicy).getText());
	}
	
	public String welcomeTextLink() throws InterruptedException {

		uc.element("cssSelector", welcomeText).isDisplayed();
		return (uc.element("cssSelector", welcomeText).getText());
	}
	
	public String gapPortalLink() throws InterruptedException {

		uc.element("cssSelector", gapText).isDisplayed();
		
		return (uc.element("cssSelector", gapText).getAttribute("link"));
	}
	
	public String forgotPasswordLink() throws InterruptedException {
		
		uc.element("cssSelector", forgotPassword).isDisplayed();
		return (uc.element("cssSelector", forgetPasswordText).getText());
	}
	
	public boolean imageShown() throws InterruptedException {
		return (uc.element("cssSelector",image).isDisplayed());
	}

	public String logo() {
		uc.clickfield("cssSelector", aul);
		return(driver.getCurrentUrl());
	}
	
	public String resetPasswordlogo() throws InterruptedException {

		uc.element("cssSelector", forgotPassword).isDisplayed();
		uc.clickfield("cssSelector", forgetPasswordText);
		uc.clickfield("cssSelector", aul);
		return(driver.getCurrentUrl());
	}



}

package pageActions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import pageObjects.bannerpo;
import utils.utilityClass;

public class bannnerAction extends bannerpo {

	utilityClass event = new utilityClass();

	public String disabledBanner() {
		return event.text("cssSelector",
				"mat-radio-button[class='mat-radio-button mat-radio-checked mat-accent'] > label > div[class=\"mat-radio-label-content']");
	}

	public WebElement bannerElement() {

		return event.element("cssSelector", banner);
	}
	
	public WebElement dashBoardBannerElement() {

		return event.element("cssSelector", dashBoardBanner,0);
	}

	public String textSpanArea() {

		return event.text("cssSelector", textArea);
	}

	public String dashBoardtextSpanArea() {

		return event.text("cssSelector", dashboardTextArea);
	}

	public void clickSubmit() {

		event.clickfield("cssSelector", submit);
	}

	public void selectEnabled() {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",
				driver.findElements(By.cssSelector("adl-radio-button input[type=radio]")).get(1));
	}

	public void selectDisabled() {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",
				driver.findElements(By.cssSelector("adl-radio-button input[type=radio]")).get(2));
	}
}

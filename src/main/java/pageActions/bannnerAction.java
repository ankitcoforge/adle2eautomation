package pageActions;

import org.openqa.selenium.By;

import pageObjects.bannerpo;
import utils.utilityClass;

public class bannnerAction extends bannerpo{
	
	utilityClass event = new utilityClass();
	

	public String disabledBanner () {
		return event.text("cssSelector", "mat-radio-button[class='mat-radio-button mat-radio-checked mat-accent'] > label > div[class=\"mat-radio-label-content']");
	}
	

}

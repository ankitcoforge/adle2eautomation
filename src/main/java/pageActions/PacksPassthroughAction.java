package pageActions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pageObjects.PacksPassthroughPO;

public class PacksPassthroughAction extends PacksPassthroughPO {

	public WebElement getArrowInshowpackModel() {
		WebElement ele = driver.findElement(By.xpath(arrowInshowpackModel));
		return ele;
	}
	
	public List<WebElement> getpackOptionsInPopup() {
		  List<WebElement> ele = driver.findElements(By.xpath(packOtionsInpopup));	
		 return ele;
	 }
	
	public WebElement selectAccountInMydealerPassthroughPage() {
		WebElement ele = driver.findElement(By.xpath(selectAccountInMydealerPassthroughPage));
		return ele;
	}
	
	public WebElement selectAccountInMyLenderPassthroughPage() {
		WebElement ele = driver.findElement(By.xpath(selectAccountInMyLenderPassthroughPage));
		return ele;
	}
	
	public WebElement selectAccountInMyMyAgentPacksPage() {
		WebElement ele = driver.findElement(By.xpath(selectAccountInMyMyAgentPacksPage));
		return ele;
	}
	
	public List<WebElement> dropdownAccountOptionsInPassthroughPage() {
		  List<WebElement> ele = driver.findElements(By.xpath(dealerAgentpackOptions));	
		 return ele;
	 }

	
}

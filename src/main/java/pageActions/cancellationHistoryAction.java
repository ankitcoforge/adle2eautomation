package pageActions;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pageObjects.cancellationHistorypo;
import utils.utilityClass;

public class cancellationHistoryAction extends cancellationHistorypo{
	
	utilityClass event = new utilityClass();

	public List <WebElement> header() {
		
		List <WebElement> tableheader = driver.findElements(By.xpath("//th"));
		return tableheader;
	}
	
	public String description() {
		
		return event.text("cssSelector", ".cancellation-history-description >p");
	}
	
	public String defaultPage() {
		
		return event.text("cssSelector", ".ui-dropdown-label-container >span");
	}
}

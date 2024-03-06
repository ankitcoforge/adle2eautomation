package pageActions;



import java.util.HashMap;
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
	
	public HashMap<String, WebElement> getSearchBoxesInGrid() {
		HashMap<String, WebElement> map = new HashMap<String, WebElement>();
		List<String> allHeaderNames = event.getTextValuesForObject("cssSelector", headerLoc);
		List<WebElement> searchBoxesInGrid = driver.findElements(By.cssSelector(searchBoxesBelowHeadersInGrid));
		for (int j = 2; j <= 4; j++) {
			map.put(allHeaderNames.get(j), searchBoxesInGrid.get(j-1));
		}
		return map;
	}
}

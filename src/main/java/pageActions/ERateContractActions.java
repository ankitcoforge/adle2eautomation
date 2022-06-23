package pageActions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pageObjects.ERateContractpo;
import utils.utilityClass;

public class ERateContractActions extends ERateContractpo {
	
	utilityClass event = new utilityClass();
	
	
public int requiredfieldCount(){
		
		int count=0;
		
		List<WebElement> mandatoryFields = driver.findElements(By.xpath("//span[contains(text(),\"Required\")]"));
		
		return mandatoryFields.size();
	}

}

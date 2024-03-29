package pageActions;

import org.openqa.selenium.By;
import org.testng.Assert;

import pageObjects.generateContractpo;
import utils.utilityClass;

public class generateContractAction extends generateContractpo {
	
	utilityClass event = new utilityClass();
	
	public void generateContractPopUp(String code, String name){
	
		String gcButton = driver.findElement(By.cssSelector(gcButtonattr)).getAttribute("disabled");
		Assert.assertEquals(gcButton, "true");
		String popUp = driver.findElement(By.cssSelector(gcModelBox)).getAttribute("style");
		Assert.assertEquals(popUp, "pointer-events: auto; width: 628px; position: static;");
		Assert.assertEquals(driver.findElement(By.cssSelector(".review_contract__information__program > label")).getText(), code);
		Assert.assertEquals(driver.findElement(By.cssSelector(".review_contract__information__program__name")).getText(), name);
		
	}
	
     public void selectGenerateContract() {
		
		event.clickfield("cssSelector", checkbox, 0);
		event.clickfield("cssSelector", checkbox, 1);
		event.clickfield("xpath", genrateContractButton);
	}
	
	

}

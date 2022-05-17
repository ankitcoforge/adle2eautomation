package pageActions;

import org.openqa.selenium.By;
import org.testng.Assert;

import pageObjects.generateContractpo;

public class generateContractAction extends generateContractpo {
	
	
	public void generateContractPopUp(){
		
		
		System.out.println(driver.findElement(By.cssSelector(gcModelBox)).getAttribute("style"));
		String a = driver.findElement(By.cssSelector(gcModelBox)).getAttribute("style");
		Assert.assertEquals(a, "pointer-events: auto; width: 628px; position: static;");
		
	}

}

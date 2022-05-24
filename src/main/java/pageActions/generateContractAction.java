package pageActions;

import org.openqa.selenium.By;
import org.testng.Assert;

import pageObjects.generateContractpo;

public class generateContractAction extends generateContractpo {
	
	
	public void generateContractPopUp(String code, String name, String total){
	
		String popUp = driver.findElement(By.cssSelector(gcModelBox)).getAttribute("style");
		Assert.assertEquals(popUp, "pointer-events: auto; width: 628px; position: static;");
		Assert.assertEquals(driver.findElement(By.cssSelector(".review_contract__information__program > label")).getText(), code);
		Assert.assertEquals(driver.findElement(By.cssSelector(".review_contract__information__program__name")).getText(), name);
		//Assert.assertEquals(driver.findElement(By.cssSelector(".review_contract__information__program__total")).getText(), total);
	}
	
	

}

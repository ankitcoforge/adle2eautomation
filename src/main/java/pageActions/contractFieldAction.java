package pageActions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import pageObjects.contractpo;
import utils.Randomizer;

public class contractFieldAction extends contractpo{

	loginAction lo = new loginAction();
	Randomizer randomizer = new Randomizer();
	verticalMenuAction vo = new verticalMenuAction();

	public String lienholderAttribute() throws InterruptedException {
		
		lo.login(prop.getProperty("username1"), prop.getProperty("password"));
		vo.navigatetoLeftMenu("E-Rate", "Rate/Contract");
		return driver.findElement(By.cssSelector(lienHolder)).getAttribute("type");
	}
	
	public int typeLienholder() throws InterruptedException {
		
		driver.findElement(By.cssSelector(lienHolder)).sendKeys("America F");
		Thread.sleep(4000);
		return length(lienholderOption);
	}
	
	public void keyMovement() throws InterruptedException {
		
		driver.findElement(By.cssSelector(lienHolder)).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.cssSelector(lienHolder)).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.cssSelector(lienHolder)).sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(4000);
		driver.findElement(By.cssSelector(lienHolder)).sendKeys(Keys.ARROW_UP);
		driver.findElement(By.cssSelector(lienHolder)).sendKeys(Keys.ARROW_UP);
	}
	
	public String partnerSuffix() {
		
		driver.findElement(By.cssSelector(lienHolder)).clear();
		driver.findElement(By.cssSelector(lienHolder)).sendKeys("SPP");
		return driver.findElement(By.cssSelector(partner)).getText();
	}
	
}

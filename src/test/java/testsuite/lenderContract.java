package testsuite;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageActions.cobuyerContractAction;
import pageActions.createContractAction;
import pageActions.leaseContractAction;
import pageActions.loginAction;
import pageActions.singleContractAction;
import pageActions.verticalMenuAction;

public class lenderContract extends createContractAction{
	
	loginAction lo = new loginAction();
	verticalMenuAction vo = new verticalMenuAction();
	singleContractAction sa = new singleContractAction();
	
	@BeforeClass
	public void login() throws InterruptedException {

		
		navigate();
		lo.login(prop.getProperty("lenderAutomation"), prop.getProperty("password"));
		vo.navigatetoLeftMenu("E-Rate", "Rate/Contract");
		driver.findElement(By.cssSelector("input[placeholder ='Type or Select Dealer Name']")).click();
		driver.findElement(By.cssSelector("input[placeholder ='Type or Select Dealer Name']")).sendKeys("Abc Motors");
		dealerList("Abc Motors");

	}
	
	@Test(priority = 1, dataProvider = "lendertest")
	public void singleContractlender(String[] inputArray) throws Exception {

		createlenderContract(inputArray);

	}

	@AfterClass
	public void close() throws InterruptedException {

		lo.logout();
	}
}

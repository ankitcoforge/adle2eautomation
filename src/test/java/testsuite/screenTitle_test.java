package testsuite;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageActions.loginAction;
import pageActions.verticalMenuAction;
import pageObjects.verticalMenupo;
@Listeners(utils.listnerlogs.class)
public class screenTitle_test extends verticalMenupo{
	
	
	@DataProvider(name="Dealer")
    public Object[][] getData() {
        return new Object[][] {
        	
        	{"E-Rate","Rate/Contract"},
        	{"E-Rate","Quote History"},
        	{"Contracts","Contract Search"},
        	{"Contracts","SPP"},
        	{"Cancellations", "Cancellation Quote"},
        	{"Cancellations", "Cancellation History"},
        	{"Reports", "My Account Statements"},
        	{"Reports", "Early Claims"},
        	{"Reports", "Cancellations"},
        	{"Reports", "Claims History"},
        	{"Reports", "Actuarials"}
        	
        };
    }
	
	
	@DataProvider(name="Agent")
    public Object[][] getData1() {
        return new Object[][] {
        	
        	{"E-Rate","Rate/Contract"},
        	{"E-Rate","Quote History"},
        	{"Contracts","Contract Search"},
        	{"Reports", "My Account Statements"},
        	{"Reports", "Early Claims"},
        	{"Reports", "Cancellations"},
        	{"Reports", "Claims History"},
        	{"Reports", "Actuarials"},
        	{"Reports", "Agent Sales Report"},
        	{"Dealer Settings", "Impersonate"},
        	
        	
        };
    }
	

	
	loginAction lo = new loginAction();
	verticalMenuAction vo = new verticalMenuAction();
	
	/*************login to the application
	 * @throws InterruptedException *********************/
	@BeforeClass
	public void login() throws InterruptedException {
		
		navigate();
		
	}
	
	/*****************Title test case***************/
	@Test(priority = 1, dataProvider = "Dealer")
    public void screenTitle(String heading, String subheading) throws InterruptedException {

		lo.login(prop.getProperty("username"),prop.getProperty("password"));
		vo.navigatetoLeftMenu(heading, subheading);
		Assert.assertEquals(vo.getTitle(), subheading);
		lo.logout();
		   
	}
	
	@Test(priority = 2, dataProvider = "Agent")
    public void screenAgentTitle(String heading, String subheading) throws InterruptedException {

		lo.login(prop.getProperty("agentusername"),prop.getProperty("agentpassword"));
		vo.navigatetoLeftMenu(heading, subheading);
		Assert.assertEquals(vo.getTitle(), subheading);
		lo.logout();
		   
	}
	
	/***************logout to the application
	 * @throws InterruptedException ********************/
	@AfterClass
	public void close() throws InterruptedException {
 
		//lo.logout();
	}
}



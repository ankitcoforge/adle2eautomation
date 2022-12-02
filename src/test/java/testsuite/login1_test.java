package testsuite;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageActions.loginAction;
import utils.baseClass;
@Listeners(utils.listnerlogs.class)
public class login1_test extends baseClass {
	
	
	@DataProvider(name="login1")
    public Object[][] getData() {
        return new Object[][] {
        	
        	{prop.getProperty("username"),prop.getProperty("password")},
        	{prop.getProperty("agentusername"),prop.getProperty("agentpassword")},
        	{prop.getProperty("adminusername"),prop.getProperty("adminpassword")}
        	
        	
        };
    }
	
	loginAction la = new loginAction();
	
	/**********Opening the ADL application******************/
	@Test(priority =1)
	public void welcomePage() {
		
		navigate();
		Assert.assertEquals(la.getTitle(), "AUL Corp.");	
	
	}
	
	/*************login to the application*********************/
	@Test (priority = 2, dataProvider = "login1")
    public void loggedIn(String user, String pass) throws InterruptedException {
		
		navigate();
		String header = la.login(user, pass);
		Assert.assertEquals(header, "Dashboard");
		driver.get(prop.getProperty("messageSetup"));
		Assert.assertEquals(header, "Dashboard");
		la.logout();
		
	}
	
	/***************logout to the application********************/
	

}

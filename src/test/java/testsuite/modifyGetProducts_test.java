package testsuite;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageActions.loginAction;
import pageActions.modifyGetAction;
import pageActions.verticalMenuAction;

public class modifyGetProducts_test extends modifyGetAction{

	
	loginAction lo = new loginAction();
	verticalMenuAction vo = new verticalMenuAction();
	
	
	@BeforeClass
	public void login() throws InterruptedException {

		navigate();

	}

	@Test(priority = 1)
	public void modifyGetProduct() throws InterruptedException {

		modifyGetRate();
	}

	@AfterClass
	public void close() throws InterruptedException {

		
	}

}

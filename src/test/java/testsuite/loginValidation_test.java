package testsuite;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageActions.loginAction;
import utils.baseClass;
@Listeners(utils.listnerlogs.class)
public class loginValidation_test extends baseClass {

	loginAction la = new loginAction();

	@Test 
	public void emptyLogin() throws InterruptedException {

		navigate();
		Assert.assertEquals(la.getTitle(), "AUL Corp.");
		String validation  = la.loginValidation();
		Assert.assertEquals(validation, "Required");
	}
	
	@Test
	public void emptyLoginPassword() throws InterruptedException {

		navigate();
		Assert.assertEquals(la.getTitle(), "AUL Corp.");
		String validation  = la.loginValidation(prop.getProperty("username"));
		Assert.assertEquals(validation, "Required");
	}
	
	
	@Test
	public void emptyLoginUsername() throws InterruptedException {

		navigate();
		Assert.assertEquals(la.getTitle(), "AUL Corp.");
		String validation  = la.loginValidation(prop.getProperty("password"));
		Assert.assertEquals(validation, "Required");
	}
	
	@Test
	public void incorrectCredential() throws InterruptedException {

		navigate();
		Assert.assertEquals(la.getTitle(), "AUL Corp.");
		String validation  = la.loginValidation(prop.getProperty("incorrectusername"),prop.getProperty("incorrectpassword"));
		Assert.assertEquals(validation, "Invalid username or password. Please try again.");
	}
	
	@Test
	public void incorrectusernameCredential() throws InterruptedException {

		navigate();
		Assert.assertEquals(la.getTitle(), "AUL Corp.");
		String validation  = la.loginValidation(prop.getProperty("incorrectusername"),prop.getProperty("password"));
		Assert.assertEquals(validation, "Invalid username or password. Please try again.");
	}
	
	@Test
	public void incorrectpasswordCredential() throws InterruptedException {

		navigate();
		Assert.assertEquals(la.getTitle(), "AUL Corp.");
		String validation  = la.loginValidation(prop.getProperty("username"),prop.getProperty("incorrectpassword"));
		Assert.assertEquals(validation, "Invalid username or password. Please try again.");
	}



}

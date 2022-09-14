package testsuite;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageActions.contractFieldAction;
import pageActions.loginAction;
import pageActions.verticalMenuAction;
import utils.utilityClass;

public class lineholderField_test extends contractFieldAction{
	
	loginAction lo = new loginAction();
	verticalMenuAction vo = new verticalMenuAction();
	utilityClass event = new utilityClass();
	
	
	@BeforeClass
	public void login() throws InterruptedException {

		navigate();

	}

	@Test
	public void lienholderField_10478_10480_10481_10482_10482_10485() throws InterruptedException {

		Assert.assertEquals(lienholderAttribute(), "text");
		Assert.assertEquals(typeLienholder(),5);
		keyMovement();
		Assert.assertEquals(partnerSuffix(), "Partner");
		Assert.assertEquals(event.text("cssSelector", notInTheList), "Not on the list");
	}

}

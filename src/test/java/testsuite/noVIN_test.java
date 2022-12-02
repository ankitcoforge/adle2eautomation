package testsuite;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageActions.noVINAction;

public class noVIN_test extends noVINAction{

	@BeforeClass
	public void login() throws InterruptedException {

		navigate();

	}

	@Test(priority = 1)
	public void contractInformation() throws InterruptedException {

		contractNoVin();

	}
}

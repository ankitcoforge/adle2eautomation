package testsuite;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageActions.loginAction;
import utils.utilityClass;

/* PBI 32606 */
public class AULtoProtectiveChange_test extends loginAction {

	utilityClass utils = new utilityClass();

	@Test(priority = 1)
	public void LoginPage() throws InterruptedException {
		navigate();
		Assert.assertTrue(getProtectiveLogo().getAttribute("src").contains("img/Protective-logo"));
		Assert.assertTrue(getProtectiveLoginPageTxt().getText().contains("AUL is a part of"));
		Assert.assertTrue(getProtectiveLoginPageTxt().getText().contains("Protective Asset Protection"));
		Assert.assertTrue(getProtectiveLoginPageTxt2().getText().contains(
				"For 60 years, Protective Asset Protection has provided F&I solutions to automotive, marine, powersports and recreational vehicle dealers throughout the U.S."));
		Assert.assertTrue(getAgreeProtectivePrivacyPolicyTxt().getText()
				.contains("By clicking \"Login\", you agree to Protective's Privacy Policy"));
		getPrivacyPolicyLink().click();
//		utils.wait(5000);
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		Assert.assertTrue(getProtectiveLogoInPrivacyPolicyPage().getAttribute("alt").equals("Protective Life Logo"));
		driver.switchTo().window(tabs.get(0));
		utils.getfield("a", "Forgot password?").click();
		System.out.println("txt---" + getProtectiveLogoInForgotPasswordPage().getAttribute("src"));
		Assert.assertTrue(getProtectiveLogoInForgotPasswordPage().getAttribute("src").contains("Protective-logo"));
	}

}

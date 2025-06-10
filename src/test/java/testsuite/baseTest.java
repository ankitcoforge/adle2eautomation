package testsuite;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;

import com.relevantcodes.extentreports.ExtentReports;

import pageActions.welcomeAction;
import pageObjects.welcomepo;
import utils.baseClass;
import utils.utilityClass;

@Listeners(utils.listnerlogs.class)
public class baseTest extends welcomeAction {

	baseClass b = new baseClass();

	@BeforeClass
	public void welcome() {

		navigate();
	}

	@Test(priority =1)
	public void VerifyeClaimsPortalforRepairFacilitieslink_27228_27231_27261() throws InterruptedException{

		Assert.assertEquals(eclaim(),"https://eclaims.aulcorp.com" );

	}

	@Test(priority =2)
	public void VerifyRememberMyPasswordLocation_27214() throws InterruptedException{
		
		Assert.assertEquals(rememberPassDisplay(),"display: none;");
		Assert.assertEquals(rememberPassText(),"Remember my username");

	}

	@Test(priority =3)
	public void VerifyLocationPrivacyPolicyLink_27224_27239_27254() throws InterruptedException {
		
		Assert.assertEquals(privacyPolicyLink(),"By clicking \"Login\", you agree to Protective's Privacy Policy");		
	}

	@Test(priority =4)
	public void VerifyWelcomeTextOnTheADLUILoginPage_27248_27244_27110() throws InterruptedException {
		
		Assert.assertEquals(welcomeTextLink(),"For 60 years, Protective Asset Protection has provided F&I solutions to automotive, marine, powersports and recreational vehicle dealers throughout the U.S.");

	}

	@Test(priority =5)
	public void VerifyGAPPortallinkfunctionality_27233_27259_27229 () throws InterruptedException {
		
		Assert.assertEquals(gapPortalLink(), "https://dashboard.classictrak.com/aul/consumer");
		
	}


	@Test(priority =6)	
	public void VerifyForgotPassword_Loginastext_27238_27254_27220_27255_27237_27166 () throws InterruptedException {

		Assert.assertEquals(forgotPasswordLink(), "Or Login as:");
		
	}

	@Test(priority =7)
	public void Verify_image_on_the_right_side_of_the_login_page_27225 () throws InterruptedException {
		
		Assert.assertEquals(imageShown(), true);
	}
	
	@Test(priority = 8)
	public void verify_aul_logo_7078() {
		
		Assert.assertEquals(logo(), "https://mo.adl.aulcorp.com/login");
		
	}
	
	@Test(priority = 9)
	public void verify_aul_logo_resetpassword_7080() throws InterruptedException {
		
		
		Assert.assertEquals(resetPasswordlogo(), "https://mo.adl.aulcorp.com/login");
		
	}



}



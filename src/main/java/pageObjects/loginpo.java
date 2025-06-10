package pageObjects;


import utils.baseClass;

public class loginpo extends baseClass{
	
	/*************page object for login page is declared ********************/
	public String header = "[class=\"title-bar\"] >h3";
	public String arrowButton = "header > div > div > button > mat-icon";
	public String logout = "//button[contains(text(),'Logout')]";
	public String userpass = "//input";
	public String submit ="//button";
	public String protectiveLogo = "//img[contains(@src,'img/Protective-logo')]";
	public String protectiveLoginPageTxt1="//adl-login/h2/span/b";
//	public String protectiveLoginPageTxt2="//adl-login/h2/span/b/br";
	public String protectiveLoginPageTxt2="//adl-login/h2/h1/span";
	public String agreeProtectivePrivacyPolicyTxt="//p[contains(text(),'you agree to Protective')]";
	public String privacyPolicyLink = "//p[contains(text(),'you agree to Protective')]/a";
	public String protectiveLogoInPrivacyPolicyPage = "//a[@title='Protective Life']/img";
	public String protectiveLogoInForgotPasswordPage = "//header/a/img";
	public String protectiveLogoinLandingPage = "//img[contains(@src,'img/Protective')]";
	public String menuBarInLandingPage = "adl-nav-menu>div";
	public String phnNoInLandingPage = "(//b[text()='Protective Asset Protection']/../b)[3]";
	
	
	//new login through otp
	public String UN ="input[placeholder='Enter your email']";
	public String loginBtn ="button[type='submit']";
	public String PW ="input[placeholder='Password']";
	public String emailAddress ="input[placeholder='Email Address']";
	public String sendVerificationCodeBtn ="button[aria-label='Send verification code']";
	public String sendCodeBtnMobile ="button[id='sendCode']";
	public String verificationcodeFld ="input[aria-label='Verification code']";
	public String verificationcodeFldForMobileNo ="input[id='verificationCode']";
	public String verifyCodeBtn ="button[aria-label='Verify code']";
	public String verifyCodeBtnMobile ="button[id='verifyCode']";
	public String continueBtn ="button[aria-label='Continue']";
	public String title = "//b[text()='Welcome to your Protective ADL Portal!']";
}


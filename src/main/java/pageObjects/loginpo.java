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
}


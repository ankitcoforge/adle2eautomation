package pageObjects;


import utils.baseClass;

public class NewLoginPO extends baseClass{
	public String UN ="input[placeholder='Enter your username']";
	public String loginBtn ="button[type='submit']";
	public String PW ="input[placeholder='Password']";
	public String sendVerificationCodeBtn ="button[aria-label='Send verification code']";
	public String verificationcodeFld ="input[aria-label='Verification code']";
	public String verifyCodeBtn ="button[aria-label='Verify code']";
	public String continueBtn ="button[aria-label='Continue']";
	public String logout = "//button[contains(text(),'Logout')]";
	public String title = "//b[text()='Welcome to your Protective ADL Portal!']";
	

}

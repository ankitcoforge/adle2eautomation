//package testsuite;
//
//import java.io.IOException;
//import java.util.Date;
//
//import org.openqa.selenium.By;
//import org.testng.Assert;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//import com.mailosaur.MailosaurClient;
//import com.mailosaur.MailosaurException;
//import com.mailosaur.models.Message;
//import com.mailosaur.models.MessageListParams;
//import com.mailosaur.models.MessageListResult;
//import com.mailosaur.models.MessageSearchParams;
//import com.mailosaur.models.SearchCriteria;
//
//import pageActions.NewLoginAction;
//import pageActions.loginAction;
//import pageActions.verticalMenuAction;
//import pageObjects.impersonatepo;
//import utils.utilityClass;
//
//public class Mailosaur_test extends NewLoginAction {
//
//	loginAction login = new loginAction();
//	verticalMenuAction verticalMenu = new verticalMenuAction();
//	utilityClass utils = new utilityClass();
//	impersonatepo io = new impersonatepo();
//
//	@BeforeClass(alwaysRun = true)
//	public void login() throws InterruptedException {
//		navigate();
//		Assert.assertEquals(login.getTitle(), "Protective");
//	}
//
//	@Test(invocationCount = 100)
//	public void login(String username,String password) throws InterruptedException, IOException, MailosaurException {
//		utils.element("cssSelector", UN).sendKeys(username);
//		utils.element("cssSelector", loginBtn).click();
//		utils.element("cssSelector", PW).sendKeys(password);
//		utils.element("cssSelector", loginBtn).click();
//		utils.element("cssSelector", sendVerificationCodeBtn).click();
//		utils.wait(10000);
//		String code = getVerificationCode();
//		utils.element("cssSelector", verificationcodeFld).sendKeys(code);
//		utils.wait(2000);
//		utils.element("cssSelector", verifyCodeBtn).click();
//		utils.wait(2000);
//		utils.element("cssSelector", continueBtn).click();
//		utils.wait(2000);
//		Assert.assertEquals(utils.element("xpath", title).getText(), "Welcome to your Protective ADL Portal!");
//	}
//
//	@Test
//	public String getVerificationCode() throws IOException, MailosaurException, InterruptedException {
//		String apiKey = "4tqZUgZADuKd4jYMpEOqEn0IFNvPDRww";
//		String serverId = "rb0ynmfd";
//		String serverDomain = "rb0ynmfd.mailosaur.net";
//		
//		MailosaurClient mailosaur = new MailosaurClient(apiKey);
//    
//		MessageSearchParams params = new MessageSearchParams();
//		params.withServer(serverId);
//
//		SearchCriteria criteria = new SearchCriteria();
//		criteria.withSentTo("hair-handsome@" + serverDomain);
//
//		Message message = mailosaur.messages().get(params, criteria);
//		Assert.assertNotNull(message);
//		
//		
//		// details 
//		System.out.println("subject of mail--" + message.subject());
//		System.out.println("email To address--" + message.to().get(0).email());
////		System.out.println("email From address" + message.from().get(0).email());
//
//		// codes
//		System.out.println("total codes-" + message.html().codes().size());
//		System.out.println("code-" + message.html().codes().get(0).value());
//		String code = message.html().codes().get(0).value();
//
//		// links
////    System.out.println("total links-"+message.html().links().size());
////    System.out.println("link-"+  message.html().links().get(0).href());
//		return code;
//	}
//
//	@AfterMethod(alwaysRun = true)
//	public void close() throws InterruptedException {
//		login.logout();
//	}
//}

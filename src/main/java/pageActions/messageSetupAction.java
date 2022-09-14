package pageActions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;

import junit.framework.Assert;
import pageObjects.bannerpo;
import utils.utilityClass;

public class messageSetupAction extends bannerpo {

	utilityClass event = new utilityClass();

	public List<String> radioButtonLabel() {
		ArrayList a = new ArrayList();
		for (int i = 0; i < driver.findElements(By.cssSelector(radioButton)).size(); i++) {
			a.add(event.text("cssSelector", radioButton, i));
		}
		return a;

	}

	public String boldletter() throws InterruptedException {

		event.clickfield("xpath", "//button[@id=\"bold-\"]");
		Assert.assertEquals(driver.findElement(By.id(bold)).getAttribute("class"), "angular-editor-button active");
		Thread.sleep(6000);
		event.inputfield("cssSelector", textAreaWhole, "abc");
		System.out.println(event.text("cssSelector", "div.angular-editor-textarea > b"));
		return event.text("cssSelector", "div.angular-editor-textarea > b");
	}
	
	public String underline() throws InterruptedException {

		event.clickfield("cssSelector", "i.fa-underline");
		Assert.assertEquals(driver.findElement(By.id(underline)).getAttribute("class"), "angular-editor-button active");
		Thread.sleep(1000);
		event.inputfield("cssSelector", textAreaWhole, "xyz");
		System.out.println(event.text("cssSelector", "div.angular-editor-textarea > b > i > u"));
		return event.text("cssSelector", "div.angular-editor-textarea > b > i > u");
	}
	
	public String heading() {
		
		return event.text("cssSelector", messageSetupHeading);
	}

}

package pageActions;

import java.text.NumberFormat;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import pageObjects.contractpo;
import utils.Randomizer;
import utils.utilityClass;

public class singleContractAction extends contractpo {

	utilityClass event = new utilityClass();
	generateContractAction gc = new generateContractAction();
	createContractAction co = new createContractAction();
	loginAction lo = new loginAction();
	Randomizer randomizer = new Randomizer();

	/************************
	 * Create contract
	 * 
	 * @throws InterruptedException
	 ****************************************/
	public String singleContract() throws InterruptedException {
		String contractNumber = null;
		try {
			event.inputfield("cssSelector", textbox, "Single", 0);
			event.inputfield("cssSelector", textbox, "Test", 1);
			event.inputfield("cssSelector", textbox, randomizer.getMilage(), 5);
			event.inputfield("cssSelector", textbox, "1HGCV1F12NA002615", 6);
			event.clickfield("xpath", getProducts);
			co.programSelect("New Vehicle");
			event.clickfield("cssSelector", table, 0);
			event.inputfield("cssSelector", textbox, "22723", 7);
			event.inputfield("cssSelector", contract, "10000", 0);
			contractNumber = driver.findElement(By.cssSelector(contractNo)).getDomProperty("value");
			System.out.println("Contract Number is:" + contractNumber);

			List<WebElement> a = driver.findElements(By.cssSelector(inServiceDate));
			if (a.size() == 1) {
				String a1 = driver.findElement(By.cssSelector(inServicefield)).getAttribute("class");
				if (!(a1.contains("disabled"))) {
					driver.findElement(By.cssSelector(inServiceDateTextBox)).click();
					driver.findElement(By.cssSelector("td[aria-label='" + getDate() + "']")).click();
				}

			}

			//Assert.assertEquals(addGapLabel(), "Add GAP");
			event.clickfield("xpath", businessUse);
			driver.findElements(By.cssSelector(textbox)).get(14).clear();
			event.inputfield("cssSelector", textbox, "20130", 14);
			driver.findElements(By.cssSelector(textbox)).get(13).clear();
			event.inputfield("cssSelector", textbox, "Address", 13);
			driver.findElements(By.cssSelector(textbox)).get(16).clear();
			event.inputfield("cssSelector", textbox, "test@gmail.com", 16);
			Thread.sleep(2000);
			event.clearfield("cssSelector", phone);
			event.inputfield("cssSelector", phone, "1234567890");
			Thread.sleep(2000);
			event.clickfield("xpath", generateContract);
			Thread.sleep(2000);
			getDriver().findElement(By.xpath(gc.generateContractHeading)).isDisplayed();
			Thread.sleep(2000);
			event.clickfield("cssSelector", gc.checkbox, 0);
			event.clickfield("cssSelector", gc.checkbox, 1);
			event.clickfield("xpath", gc.genrateContractButton);
			Thread.sleep(10000);
			String text1 = event.text("cssSelector", successMessage);
			Assert.assertEquals(text1, "You have successfully generated a contract!");
			event.clickfield("xpath", newQuotelink);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return contractNumber;
	}

	public void singleContract(String listb) throws InterruptedException {

		event.inputfield("cssSelector", textbox, "Single", 0);
		event.inputfield("cssSelector", textbox, "Test", 1);
		event.inputfield("cssSelector", textbox, listb, 2);
		event.clickfield("cssSelector", "[role=listbox] > [role=option]");
		event.inputfield("cssSelector", textbox, "1234", 5);
//		event.inputfield("cssSelector", textbox, "5J6RW2H89NA004619", 6);
		event.inputfield("cssSelector", textbox, "1HGCY2F55PA001395", 6);
		event.clickfield("xpath", getProducts);
		co.programSelect(" Limited Warranty");
		event.clickfield("cssSelector", table, 0);
		event.inputfield("cssSelector", contract, "10000", 0);
		List<WebElement> a = driver.findElements(By.cssSelector(inServiceDate));
		if (a.size() == 1) {
			String a1 = driver.findElement(By.cssSelector(inServicefield)).getAttribute("class");
			if (!(a1.contains("disabled"))) {
				driver.findElement(By.cssSelector(inServiceDateTextBox)).click();
				System.out.println("td[aria-label='" + getDate() + "']");
				driver.findElement(By.cssSelector("td[aria-label='" + getDate() + "']")).click();
			}

		}
		//Assert.assertEquals(addGapLabel(), "Add GAP");
		driver.findElements(By.cssSelector(textbox)).get(14).clear();
		event.inputfield("cssSelector", textbox, "20130", 14);
		driver.findElements(By.cssSelector(textbox)).get(13).clear();
		event.inputfield("cssSelector", textbox, "Address", 13);
		Thread.sleep(2000);
		event.clearfield("cssSelector", phone);
		event.inputfield("cssSelector", phone, "1234567890");
		event.clickfield("xpath", generateContract);
		getDriver().findElement(By.xpath(gc.generateContractHeading)).isDisplayed();
		Thread.sleep(2000);
		event.clickfield("cssSelector", gc.checkbox, 0);
		event.clickfield("cssSelector", gc.checkbox, 1);
		event.clickfield("xpath", gc.genrateContractButton);
		Thread.sleep(5000);
		String text1 = event.text("cssSelector", successMessage);
		Assert.assertEquals(text1, "You have successfully generated a contract!");
		event.clickfield("xpath", newQuotelink);
	}

	public void getSelectDealerTogenerateContract(String dealer) throws InterruptedException {
		WebElement ele = driver.findElement(By.xpath(selectDealerTogenerateContract));
		ele.click();
		ele.sendKeys(dealer);
		ele.sendKeys(Keys.ARROW_DOWN);
		ele.sendKeys(Keys.ENTER);
		getBtnSignIn().click();
		Thread.sleep(2000);
	}
	
	

	public String singleContractForLender(String dealer) throws InterruptedException {
		getSelectDealerTogenerateContract(dealer);
		 event.inputfield("cssSelector", textbox, "Single", 0);
		 event.inputfield("cssSelector", textbox, "Test", 1);
		 event.inputfield("cssSelector", textbox, "100", 4);
		 event.inputfield("cssSelector", textbox, "5J6RW2H89NA004619", 5);
		 event.clickfield("xpath", getProducts);
		 String programCode = prop.getProperty("lenderProgramCode");
		 co.programSelect(programCode);
//		 String txt = utils.text("cssSelector", table, 0);
//		 NumberFormat format = NumberFormat.getCurrencyInstance();
//			Number number = format.parse(txt);
//			String packAmount = number.toString();
//		 Integer txtInInteger= Integer.parseInt(packAmount);
		 
		 event.clickfield("cssSelector", table, 0);
		Thread.sleep(5000);
		event.scrollDown();
		event.inputfield("cssSelector", textbox, "22723", 7);
		event.inputfield("cssSelector", contract, "10000", 0);
		Thread.sleep(1000);
		// utils.clickfield("xpath", liftkit);
		event.clickfield("xpath", businessUse);
		String contractNumber = driver.findElement(By.cssSelector(contractNo)).getDomProperty("value");
		System.out.println("Contract Number is:" + contractNumber);

		List<WebElement> a = driver.findElements(By.cssSelector(inServiceDate));
		if (a.size() == 1) {
			String a1 = driver.findElement(By.cssSelector(inServicefield)).getAttribute("class");
			if (!(a1.contains("disabled"))) {
				driver.findElement(By.cssSelector(inServiceDateTextBox)).click();
				driver.findElement(By.cssSelector("td[aria-label='" + getDate() + "']")).click();
			}

		}
		// Assert.assertEquals(contractNew.addGapLabel(), "Add GAP");
		driver.findElements(By.cssSelector(pincode)).get(0).clear();
		event.inputfield("cssSelector", pincode, "20130", 0);
		driver.findElements(By.xpath(address)).get(0).clear();
		event.inputfield("xpath", address, "Address", 0);
		driver.findElements(By.cssSelector(email)).get(0).clear();
		event.inputfield("cssSelector", email, "test@gmail.com", 0);
		Thread.sleep(2000);
		event.clearfield("cssSelector", phone);
		event.inputfield("cssSelector", phone, "1234567890");
		event.clickfield("xpath", generateContract);
		getDriver().findElement(By.xpath(gc.generateContractHeading)).isDisplayed();
		Thread.sleep(2000);
		event.clickfield("cssSelector", gc.checkbox, 0);
		event.clickfield("cssSelector", gc.checkbox, 1);
		event.clickfield("xpath", gc.genrateContractButton);
		Thread.sleep(10000);
		String text1 = event.text("cssSelector", successMessage);
		Assert.assertEquals(text1, "You have successfully generated a contract!");
		event.clickfield("xpath", newQuotelink);
		return contractNumber;
	}
}

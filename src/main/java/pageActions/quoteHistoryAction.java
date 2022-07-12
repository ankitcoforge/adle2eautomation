package pageActions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import pageObjects.quoteHistorypo;

public class quoteHistoryAction extends quoteHistorypo {

	public int recordCount() {

		int count = 0;

		WebElement countElement = driver.findElement(By.xpath(QHNumberOfCounts));

		boolean flag = countElement.isDisplayed();

		if (flag == true) {

			String text = countElement.getText();

			String val[] = text.split(" ");

			count = Integer.parseInt(val[3]);
		}
		return count;
	}

	public void waitFunction() {

	}

	public void verifySearchRecord(String searchcriteria, String searchValue) throws InterruptedException {

		switch (searchcriteria) {

		case "ContractNumber":
			driver.findElement(By.xpath(QHContractNumberSearchBox)).sendKeys(searchValue);
			verifySearchValue(searchcriteria, searchValue);
			driver.findElement(By.xpath(QHContractNumberSearchBox)).clear();
			Thread.sleep(4000);
			break;

		case "Program":

			driver.findElement(By.xpath(QHProgramSearchBox)).sendKeys(searchValue);
			verifySearchValue(searchcriteria, searchValue);
			driver.findElement(By.xpath(QHProgramSearchBox)).clear();
			Thread.sleep(4000);
			break;

		case "Coverage":
			driver.findElement(By.xpath(QHCoverageSearchBox)).sendKeys(searchValue);

			verifySearchValue(searchcriteria, searchValue);
			driver.findElement(By.xpath(QHCoverageSearchBox)).clear();
			Thread.sleep(4000);
			break;

		case "Mileage":
			driver.findElement(By.xpath(QHMileageSearchBox)).sendKeys(searchValue);
			verifySearchValue(searchcriteria, searchValue);
			driver.findElement(By.xpath(QHMileageSearchBox)).clear();
			Thread.sleep(4000);
			break;

		case "Make":
			driver.findElement(By.xpath(QHMakeSearchBox)).sendKeys(searchValue);
			verifySearchValue(searchcriteria, searchValue);
			driver.findElement(By.xpath(QHMakeSearchBox)).clear();
			Thread.sleep(4000);
			break;

		case "Model":
			driver.findElement(By.xpath(QHModelSearchBox)).sendKeys(searchValue);
			verifySearchValue(searchcriteria, searchValue);
			driver.findElement(By.xpath(QHModelSearchBox)).clear();
			Thread.sleep(4000);
			break;

		case "TotalPrice":
			driver.findElement(By.xpath(QHTotalPriceSerachBox)).sendKeys(searchValue);
			verifySearchValue(searchcriteria, searchValue);
			driver.findElement(By.xpath(QHTotalPriceSerachBox)).clear();
			Thread.sleep(4000);
			break;

		case "FirstName":
			driver.findElement(By.xpath(QHFirstNameSearchBox)).sendKeys(searchValue);
			verifySearchValue(searchcriteria, searchValue);
			driver.findElement(By.xpath(QHFirstNameSearchBox)).clear();
			Thread.sleep(4000);
			break;

		case "LastName":
			driver.findElement(By.xpath(QHLastNameSearchBox)).sendKeys(searchValue);
			verifySearchValue(searchcriteria, searchValue);
			driver.findElement(By.xpath(QHLastNameSearchBox)).clear();
			Thread.sleep(4000);
			break;

		case "QuoteDate":
			driver.findElement(By.xpath(QHQuoteDateSearchBox)).sendKeys(searchValue);
			verifySearchValue(searchcriteria, searchValue);
			driver.findElement(By.xpath(QHQuoteDateSearchBox)).clear();
			Thread.sleep(4000);
			break;

		case "CreateBy":
			driver.findElement(By.xpath(QHCreatedBySearchBox)).sendKeys(searchValue);
			verifySearchValue(searchcriteria, searchValue);
			driver.findElement(By.xpath(QHCreatedBySearchBox)).clear();
			Thread.sleep(4000);
			break;
		}
	}

	public void verifyElementPresence() throws InterruptedException {

		List<String> QHTotalElement = new ArrayList<String>();

		QHTotalElement.add(QHContractNumber);
		QHTotalElement.add(QHCoverage);
		QHTotalElement.add(QHCreatedBy);
		QHTotalElement.add(QHPageLeftButton);
		QHTotalElement.add(QHPageRightButton);
		QHTotalElement.add(QHPageExtremeLeftButton);
		QHTotalElement.add(QPageHExtremeRightButton);
		QHTotalElement.add(QHNumberOfCounts);
		QHTotalElement.add(QHProgram);
		QHTotalElement.add(QHMilegae);
		QHTotalElement.add(QHMake);
		QHTotalElement.add(QHModel);
		QHTotalElement.add(QHTotalPrice);
		QHTotalElement.add(QHFirstName);
		QHTotalElement.add(QHLastName);
		QHTotalElement.add(QHQuoteDate);
		QHTotalElement.add(QHEdit);
		QHTotalElement.add(QHDelete);
		QHTotalElement.add(QHQuote);
		QHTotalElement.add(QHUniversalSearch);
		QHTotalElement.add(QHUniversalClearFilter);

		for (int i = 0; i < QHTotalElement.size(); i++) {

			Thread.sleep(2000);

			boolean flag = driver.findElement(By.xpath(QHTotalElement.get(i))).isDisplayed();

			Assert.assertEquals(flag, true);

			if (flag != true) {

				System.out.println("Element is not Present : " + QHTotalElement.get(i));
			}

		}

	}

	public void verifyTitle() {

		String titleNameActual = driver.findElement(By.xpath(QHTitle)).getText();

		Assert.assertEquals(titleNameActual, "Quote History");

	}

	public void verifyDeleteFunctionalityConfirmationMessage() throws InterruptedException {

		boolean flag1, flag2, flag3, flag4;
		String ConfirmationMessage, ContractNumber;
		Thread.sleep(4000);

		verifySearchRecord(prop.getProperty("SearchType"), prop.getProperty("SearchData"));

		ContractNumber = driver.findElement(By.xpath("//*[@id=\"quote_history_table\"]/tbody/tr[1]/td[1]")).getText();

		driver.findElement(By.xpath("//*[@id=\"quote_history_table\"]/tbody/tr[1]/td[13]")).click();
		driver.switchTo().activeElement();

		Thread.sleep(4000);

		flag1 = driver.findElement(By.xpath(QHConfirmationMessageWindowYes)).isDisplayed();
		Assert.assertTrue(flag1);
		flag2 = driver.findElement(By.xpath(QHConfirmationMessageWindowNo)).isDisplayed();
		Assert.assertTrue(flag2);

		ConfirmationMessage = "Are you sure you want to delete quote " + ContractNumber + " ?";

		flag3 = driver.findElement(By.xpath("//*[contains(text(),\"" + ConfirmationMessage + "\")]")).isDisplayed();

		Assert.assertTrue(flag3);

		flag4 = driver.findElement(By.xpath(QHConfirmationMessageClose)).isDisplayed();
		Assert.assertTrue(flag4);

		driver.findElement(By.xpath(QHConfirmationMessageClose)).click();

		driver.findElement(By.xpath(QHProgramSearchBox)).clear();

	}

	public void verifyEditLink() throws InterruptedException {

		verifySearchRecord(prop.getProperty("SearchType"), prop.getProperty("SearchData"));

		driver.findElement(By.xpath("//*[@id=\"quote_history_table\"]/tbody/tr[1]/td[12]")).click();

		String redirectedTitleName = driver.findElement(By.xpath("//div[@class=\"title-bar\"]//child::h3")).getText();

		Assert.assertEquals(redirectedTitleName, "Rate/Contract");
	}

	public void verifySearchValue(String searchCriteria, String SerachValue) throws InterruptedException {

		String ActualValue;

		HashMap<String, Integer> QuoteHistoryWebTableResult = new HashMap<String, Integer>();

		QuoteHistoryWebTableResult.put("ContractNumber", 1);
		QuoteHistoryWebTableResult.put("Program", 2);
		QuoteHistoryWebTableResult.put("Coverage", 3);
		QuoteHistoryWebTableResult.put("Mileage", 4);
		QuoteHistoryWebTableResult.put("Make", 5);
		QuoteHistoryWebTableResult.put("Model", 6);
		QuoteHistoryWebTableResult.put("TotalPrice", 7);
		QuoteHistoryWebTableResult.put("FirstName", 8);
		QuoteHistoryWebTableResult.put("LastName", 9);
		QuoteHistoryWebTableResult.put("QuoteDate", 10);
		QuoteHistoryWebTableResult.put("CreateBy", 11);

		for (Map.Entry mapElement : QuoteHistoryWebTableResult.entrySet()) {
			int value = 0;

			if (searchCriteria.equals((String) mapElement.getKey())) {

				value = ((int) mapElement.getValue());

				Thread.sleep(4000);

				int recordNumber = recordCount();

				for (int i = 1; i <= recordNumber; i++) {

					Thread.sleep(4000);

					String beforeXpath, afterXpath, middleXpath, actualXpath;
					beforeXpath = "//*[@id=\"quote_history_table\"]/tbody/tr[";
					middleXpath = "]/td[";
					afterXpath = "]/adl-table-cells/div/span[2]";

					actualXpath = beforeXpath + i + middleXpath + value + afterXpath;

					ActualValue = driver.findElement(By.xpath(actualXpath)).getText();

					Assert.assertEquals(ActualValue, SerachValue);

				}

			}

		}
	}
}

package pageActions;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pageObjects.contractpo;
import utils.utilityClass;

public class createContractAction extends contractpo {

    utilityClass event = new utilityClass();
    generateContractAction gc = new generateContractAction();
    loginAction lo = new loginAction();
    verticalMenuAction vo = new verticalMenuAction();

    /************************
     * Create contract
     ****************************************/
    @SuppressWarnings("deprecation")
    public void createContract(String[] inputArray) throws InterruptedException {
        HashMap<String, String> searchData1 = contractData(inputArray);
        event.inputfield("cssSelector", firstName, searchData1.get("Firstname"));
        event.inputfield("cssSelector", lastName, searchData1.get("Lastname"));
        event.inputfield("cssSelector", mileage, searchData1.get("Mileage"));
        event.inputfield("cssSelector", vinTextbox, searchData1.get("Vin"));
        event.clickfield("xpath", getProducts);
        getDriver().findElement(By.cssSelector(editProducts)).isEnabled();
        programSelect(searchData1.get("program"));
        event.scrollDown();
        event.clickfield("cssSelector", table, 0);
        event.scrollDown();
        event.inputfield("cssSelector", contract, "10000");
        selectOptionSurcharge();
        inserviceDate();
        event.clickfield("xpath", generateContract);
        waitForElementVisible(By.xpath(gc.generateContractHeading), 5);
        gc.selectGenerateContract();
        WebElement element = waitForElementVisible(By.cssSelector(successMessage), 9);
        Assert.assertEquals(element.getText(), "You have successfully generated a contract!");
        event.clickfield("cssSelector", newQuotelink);
    }

    @SuppressWarnings("deprecation")
    public void createlenderContract(String[] inputArray) throws InterruptedException {
        // try {
        //     HashMap<String, String> searchData1 = contractData(inputArray);
        //     event.inputfield("cssSelector", textbox, searchData1.get("Firstname"), 0);
        //     event.inputfield("cssSelector", textbox, searchData1.get("Lastname"), 1);
        //     event.inputfield("cssSelector", textbox, searchData1.get("Mileage"), 5);
        //     event.inputfield("cssSelector", textbox, searchData1.get("Vin"), 6);
        //     event.clickfield("xpath", getProducts);
        //     programSelect(searchData1.get("program"));
        //     event.clickfield("cssSelector", table, 0);
        //     String[] program = getProgramHeader().split(" ");
        //     String programCode = program[0];
        //     String programName = program[1];
        //     event.inputfield("cssSelector", contract, "10000", 0);
        //     selectOptionSurcharge();
        //     inserviceDate();
        //     filladdress();
        //     waitForElementVisible(By.xpath(gc.generateContractHeading), 5);
        //     if ("one".equals(searchData1.get("GenerateContract"))) {
        //         gc.generateContractPopUp(programCode, programName);
        //     }
        //     gc.selectGenerateContract();
        //     WebElement element = waitForElementVisible(By.cssSelector(successMessage), 9);
        //     Assert.assertEquals(element.getText(), "You have successfully generated a contract!");
        //     event.clickfield("cssSelector", newQuotelink);
        // } catch (ElementNotInteractableException e) {
        //     e.printStackTrace();
        //     Assert.fail();
        //     lo.logout();
        //     lo.login("shreya.agarwal@protective.com", prop.getProperty("password"));
        // }
    }

    public void programSelect(String programName) {
        WebElement programElement = getDriver().findElement(By.xpath(programfirstname + programName + programlastname));
        programElement.isDisplayed();
        getDriver().findElement(By.xpath(programfirstname + programName + programlastname + "/preceding-sibling::div")).click();
    }

    public boolean calculatePrice() {
        String covPrice = event.text("xpath", table, 1);
        String price = covPrice.substring(1);
        String totalPrice = event.text("cssSelector", total);
        String[] calPrice = totalPrice.split("\\W+");
        // Always returns false, consider revising logic if needed
        return false;
    }

    public void createContractWithUniversalLenders(String[] inputArray) throws InterruptedException {
        try {
            HashMap<String, String> searchData1 = contractData(inputArray);
            event.inputfield("cssSelector", textbox, searchData1.get("Firstname"), 0);
            event.inputfield("cssSelector", textbox, searchData1.get("Lastname"), 1);
            event.inputfield("cssSelector", textbox, "Universal Lenders LLC", 2);
            event.inputfield("cssSelector", textbox, searchData1.get("Mileage"), 5);
            event.inputfield("cssSelector", textbox, searchData1.get("Vin"), 6);
            event.clickfield("xpath", getProducts);
            JavascriptExecutor js = ((JavascriptExecutor) driver);
            programSelect(searchData1.get("program"));
            if (searchData1.get("program").contains("Absolute Reserve Care Lease")) {
                js.executeScript("window.scrollTo(0, 2200)");
                Assert.assertEquals(driver.findElements(By.cssSelector("adl-lease-term >div >div> span")).get(0).getText(), "Lease Term Months:");
                Assert.assertEquals(driver.findElements(By.cssSelector("adl-lease-term >div >div> span")).get(1).getText(), "Lease Term Miles:");
                driver.findElement(By.cssSelector("adl-select[placeholder=\"Select Months\"]>ng-select")).click();
                driver.findElement(By.cssSelector(".ng-dropdown-panel-items > div > div")).click();
                driver.findElement(By.cssSelector("adl-select[placeholder=\"Select Miles\"]>ng-select")).click();
                driver.findElement(By.cssSelector(".ng-dropdown-panel-items > div > div")).click();
                Assert.assertEquals(warningTextMesssage(), "Please select the rate in the table.");
            }
            event.clickfield("cssSelector", table, 0);
            String[] program = getProgramHeader(" � ").split(" � ");
            String programCode = program[0];
            String programName = program[1];
            event.inputfield("cssSelector", contract, "10000", 0);
            if (!(searchData1.get("program").contains("Limited Warranty") ||
                  searchData1.get("program").contains("Absolute Reserve Care Lease") ||
                  searchData1.get("program").contains("Absolute Lifetime Powertrain Warranty") ||
                  searchData1.get("program").contains("Absolute Certified Warranty"))) {
                event.clickfield("xpath", businessUse);
            }
            List<WebElement> a = driver.findElements(By.cssSelector(inServiceDate));
            if (a.size() == 1) {
                String a1 = driver.findElement(By.cssSelector(inServicefield)).getAttribute("class");
                if (!a1.contains("disabled")) {
                    driver.findElement(By.cssSelector(inServiceDateTextBox)).click();
                    driver.findElement(By.cssSelector("td[aria-label='" + getDate() + "']")).click();
                }
            }
            Assert.assertEquals(addGapLabel(), "Add GAP");
            js.executeScript("window.scrollTo(0, 2500)");
            driver.findElements(By.cssSelector(textbox)).get(14).clear();
            event.inputfield("cssSelector", textbox, "20130", 14);
            driver.findElements(By.cssSelector(textbox)).get(13).clear();
            event.inputfield("cssSelector", textbox, "Address", 13);
            Thread.sleep(2000);
            event.clearfield("cssSelector", phone);
            event.inputfield("cssSelector", phone, "1234567890");
            event.clickfield("xpath", generateContract);
            waitForElementVisible(By.xpath(gc.generateContractHeading), 5);
            Thread.sleep(2000);
            if ("one".equals(searchData1.get("GenerateContract"))) {
                gc.generateContractPopUp(programCode, programName);
            }
            event.clickfield("cssSelector", gc.checkbox, 0);
            event.clickfield("cssSelector", gc.checkbox, 1);
            event.clickfield("xpath", gc.genrateContractButton);
            Thread.sleep(5000);
            String text1 = event.text("cssSelector", successMessage);
            Assert.assertEquals(text1, "You have successfully generated a contract!");
            event.clickfield("xpath", newQuotelink);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    // Helper method to wait for element visibility
    private WebElement waitForElementVisible(By locator, int seconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(seconds)).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // Helper method to get program header text, with optional delimiter
    private String getProgramHeader() {
        return event.text("cssSelector", programNameCode);
    }
    private String getProgramHeader(String delimiter) {
        return event.text("cssSelector", programNameCode);
    }
}

package utils;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.HashMap;
import java.util.Properties;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import javax.imageio.ImageIO;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;



public class baseClass {

	public static WebDriver driver;
	public static Properties prop;

	@BeforeSuite
	public void beforeSuite(ITestContext context) {

		init();
	}

	@BeforeTest
	public void beforTestMethod(ITestContext context) {

		getDriver();
	}

	@AfterTest
	public void afterTestMethod(ITestContext context) {

		driver.close();

	}

	@AfterSuite
	public void afterSuite(ITestContext context) {

		driver = null;
	}

	public void init() {
		// init the prop file
		if (prop == null) {
			prop = new Properties();
			try {
				FileInputStream fs = new FileInputStream(System.getProperty("user.dir") + "//config.properties");
				prop.load(fs);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/********************
	 * Method to get current web driver
	 *******************************************************/

	@SuppressWarnings("deprecation")
	public static WebDriver getDriver() {
		String browserName = prop.getProperty("browser");
		if (driver == null) {
			driver = createDriver(browserName);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}
		return driver;

	}

	/********************
	 * Method to create web driver
	 *******************************************************/
	private static WebDriver createDriver(String browser) {

		if (browser.equals("Mozilla")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "//geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browser.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//chromedriver.exe");
			//HashMap<String, String> mobileEmulation = new HashMap();
			//mobileEmulation.put("deviceName", "Nexus 5");
			//ChromeOptions chromeOptions = new ChromeOptions();
			//chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
			HashMap<String,Object> chromePrefs = new HashMap<String, Object>();
			chromePrefs.put("plugins.always_open_pdf_externally", true);
			chromePrefs.put("download.default_directory", System.getProperty("user.dir") + "\\PDF");
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", chromePrefs);
			driver = new ChromeDriver(options);
		} else if (browser.equals("IE")) {
			//Setting system properties of InternetExplorerDriver
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "//IEDriverServer.exe"); 
			//Creating an object of InternetExplorerDriver
		    driver=new InternetExplorerDriver();
		}
		return driver;
	}

	/**********
	 * Open the test environment
	 * 
	 * @return
	 ***********/
	public static void navigate() {

		driver.get(prop.getProperty("urlKey"));
	}

	/*********** Verify header of the webpage ***********/
	public String verifyheader(String Header) {
		String header = driver.findElement(By.tagName(prop.getProperty(Header))).getText();
		return (header);
	}

	/************************
	 * Read XLSX data from excel file
	 *************************/
	@SuppressWarnings("resource")
	@DataProvider(name = "test1")
	public Object[][] getExcelData() {
		//// read data from data provider excel and append in string array
		Object[][] excelData = null;
		try {
			//// read file
			FileInputStream fs = new FileInputStream(System.getProperty("user.dir") + "//Testing.xlsx");
			//// get workbook based on sheet
			XSSFWorkbook wb = new XSSFWorkbook(fs);
			//// get excel sheet
			Sheet sh = wb.getSheet("Test");
			//// no of rows
			int totalNoOfRows = sh.getLastRowNum() - sh.getFirstRowNum();
			excelData = new Object[totalNoOfRows][1];
			//// no of columns
			int totalNoOfColumn = sh.getRow(0).getLastCellNum();
			//// iterate through rows and columns
			for (int i = 1; i <= totalNoOfRows; i++) {
				String[] data = new String[totalNoOfColumn];
				Row row = sh.getRow(i);
				for (int j = 0; j < totalNoOfColumn; j++) {
					String abc = "";
					try {
						CellType cellType = row.getCell(j).getCellType();
						//// Switch case to convert excel data to excel
						switch (cellType.toString().toLowerCase()) {
						case "string":
							abc = row.getCell(j).getStringCellValue();
							break;
						case "blank":
							abc = row.getCell(j).getStringCellValue();
							break;
						case "numeric":
							abc = Double.toString(row.getCell(j).getNumericCellValue());
							break;
						default:
							abc = row.getCell(j).getStringCellValue();
						}
					} catch (Exception e) {
						abc = "";
					}
					//// appened data in string array
					data[j] = abc;
				}
				excelData[i - 1][0] = data;
			}
		} catch (Exception e) {
			//// do nothing

		}

		return excelData;
	}

	/************************
	 * Contract data read from XLSX to Hashmap
	 *************************/
	public HashMap<String, String> contractData(String[] inputArray) {
		HashMap<String, String> searchData = new HashMap<String, String>();
		for (int i = 0; i < inputArray.length; i++) {
			//// Switch Case to Transform Data
			switch (i) {
			case 0:
				searchData.put("Firstname", inputArray[i]);
				break;
			case 1:
				searchData.put("Lastname", inputArray[i]);
				break;
			case 2:
				searchData.put("Vin", inputArray[i]);
				break;
			case 3:
				searchData.put("Mileage", inputArray[i]);
				break;
			case 4:
				searchData.put("program", inputArray[i]);
				break;
			case 5: 
				searchData.put("Surcharge", inputArray[i]);
				break;
			case 6:
				searchData.put("GenerateContract", inputArray[i]);
				break;
			default:
				searchData.put("NoData", inputArray[i]);
				break;
			}
		}
		return searchData;
	}
	
	/************************
	 * Read XLSX data from excel file
	 *************************/
	@SuppressWarnings("resource")
	@DataProvider(name = "test2")
	public Object[][] getExcelData1() {
		//// read data from data provider excel and append in string array
		Object[][] excelData = null;
		try {
			//// read file
			FileInputStream fs = new FileInputStream(System.getProperty("user.dir") + "//Testing.xlsx");
			//// get workbook based on sheet
			XSSFWorkbook wb = new XSSFWorkbook(fs);
			//// get excel sheet
			Sheet sh = wb.getSheet("Two_program");
			//// no of rows
			int totalNoOfRows = sh.getLastRowNum() - sh.getFirstRowNum();
			excelData = new Object[totalNoOfRows][1];
			//// no of columns
			int totalNoOfColumn = sh.getRow(0).getLastCellNum();
			//// iterate through rows and columns
			for (int i = 1; i <= totalNoOfRows; i++) {
				String[] data = new String[totalNoOfColumn];
				Row row = sh.getRow(i);
				for (int j = 0; j < totalNoOfColumn; j++) {
					String abc = "";
					try {
						CellType cellType = row.getCell(j).getCellType();
						//// Switch case to convert excel data to excel
						switch (cellType.toString().toLowerCase()) {
						case "string":
							abc = row.getCell(j).getStringCellValue();
							break;
						case "blank":
							abc = row.getCell(j).getStringCellValue();
							break;
						case "numeric":
							abc = Double.toString(row.getCell(j).getNumericCellValue());
							break;
						default:
							abc = row.getCell(j).getStringCellValue();
						}
					} catch (Exception e) {
						abc = "";
					}
					//// appened data in string array
					data[j] = abc;
				}
				excelData[i - 1][0] = data;
			}
		} catch (Exception e) {
			//// do nothing

		}

		return excelData;
	}
	
	
	 /* Contract data read from XLSX to Hashmap
	 *************************/
	public HashMap<String, String> twoContractData(String[] inputArray) {
		HashMap<String, String> searchData = new HashMap<String, String>();
		for (int i = 0; i < inputArray.length; i++) {
			//// Switch Case to Transform Data
			switch (i) {
			case 0:
				searchData.put("Firstname", inputArray[i]);
				break;
			case 1:
				searchData.put("Lastname", inputArray[i]);
				break;
			case 2:
				searchData.put("Vin", inputArray[i]);
				break;
			case 3:
				searchData.put("Mileage", inputArray[i]);
				break;
			case 4:
				searchData.put("programs", inputArray[i]);
				break;
			case 5:
				searchData.put("program2", inputArray[i]);
				break;
			case 6: 
				searchData.put("Surcharge", inputArray[i]);
				break;
			case 7:
				searchData.put("GenerateContract", inputArray[i]);
				break;
			default:
				searchData.put("NoData", inputArray[i]);
				break;
			}
		}
		return searchData;
	}

}

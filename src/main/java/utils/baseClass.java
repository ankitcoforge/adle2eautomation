package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
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
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;

import com.google.common.io.Files;



public class baseClass extends pdfUtils{

	public static WebDriver driver;
	public static Properties prop;
	/** Static variable ssPath - screenshot folder location */
	public static String screenshotPath = "";
	/**
	 * Static variable screenShota - list of all screenshots associated with single
	 * test
	 */
	public static List<String> screenShots;
	

	@BeforeSuite
	public void beforeSuite(ITestContext context) {

		init();
		File directory = new File(System.getProperty("user.dir") + "\\PDF");
		try {
			FileUtils.cleanDirectory(directory);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@BeforeTest
	public void beforTestMethod(ITestContext context) {
		
		String path1 = System.getProperty("user.dir");
		System.out.println(path1);
		createscreenshotfolder(path1);
		getDriver();
		navigate();
		
	}

//	@AfterMethod(alwaysRun = true)
//	public void teardown(ITestContext context){
//		String testName = context.getName();
//		System.out.println(testName);
//		takeScreenshot(testName);
//	}
	
	
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
				FileInputStream fs = new FileInputStream(System.getProperty("user.dir") + "//config_qainternal.properties");
				prop.load(fs);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Creates the report screenshot folder inside report folder under
	 * createReportFolder
	 */
	public void createscreenshotfolder(String path) {
		//// screenshot folder to be created in current runing directory
		//// generate time stamp for unique path and name
		
		String screenshotFolder = "screenshots";
		screenshotPath = path + "\\" + screenshotFolder;
		File file = new File(screenshotPath);
		//// check if directory exist
		if (!file.exists()) {
			file.mkdir();
		}
	}

	/********************
	 * Method to get current web driver
	 *******************************************************/

	@SuppressWarnings("deprecation")
	public static WebDriver getDriver() {
		String browserName = prop.getProperty("browser");
		String mobile = prop.getProperty("mobile");
		if (driver == null) {
			driver = createDriver(browserName, mobile);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}
		return driver;

	}

	/********************
	 * Method to create web driver
	 * @param mobile 
	 *******************************************************/
	private static WebDriver createDriver(String browser, String mobile) {

		if (browser.equals("Mozilla")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "//geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browser.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//chromedriver.exe");
			if (mobile.equals("true")) {
				HashMap<String, String> mobileEmulation = new HashMap();
				mobileEmulation.put("deviceName", "iPhone 12 Pro");
				ChromeOptions chromeOptions = new ChromeOptions();
				chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
				HashMap<String,Object> chromePrefs = new HashMap<String, Object>();
				chromePrefs.put("plugins.always_open_pdf_externally", true);
				chromePrefs.put("download.default_directory", System.getProperty("user.dir") + "\\PDF");
//				ChromeOptions options = new ChromeOptions();
//				options.setExperimentalOption("prefs", chromeOptions);
				chromeOptions.addArguments("--remote-allow-origins=*");
				driver = new ChromeDriver(chromeOptions);
			}
			else {
				HashMap<String,Object> chromePrefs = new HashMap<String, Object>();
				chromePrefs.put("plugins.always_open_pdf_externally", true);
				chromePrefs.put("profile.default_content_settings.popups", 0);
				chromePrefs.put("download.default_directory", System.getProperty("user.dir") + "\\PDF");
				ChromeOptions options = new ChromeOptions();
				options.setExperimentalOption("prefs", chromePrefs);
				options.addArguments("--remote-allow-origins=*");
				driver = new ChromeDriver(options);
			}
			
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
	 * Read XLSX data from excel file
	 *************************/
	@SuppressWarnings("resource")
	@DataProvider(name = "lendertest")
	public Object[][] getExcelData2() {
		//// read data from data provider excel and append in string array
		Object[][] excelData = null;
		try {
			//// read file
			FileInputStream fs = new FileInputStream(System.getProperty("user.dir") + "//Testing.xlsx");
			//// get workbook based on sheet
			XSSFWorkbook wb = new XSSFWorkbook(fs);
			//// get excel sheet
			Sheet sh = wb.getSheet("lender");
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
	
	/* Return today date*/
	public String getDate() {
        Calendar calendar = Calendar.getInstance();
        String month = calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault());
        int day = calendar.get(calendar.DAY_OF_MONTH);
        int year = calendar.get(calendar.YEAR);
        return(month+" "+day+","+" "+year);
    }
	
	/**
	 * Common function to take screenshot
	 */
	public void takeScreenshot(String testname, File path) {
		try { //// runtime get time of execution
			String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
			
			//// file path
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String abc = path + "\\" + testname + timeStamp + ".png";
			FileUtils.copyFile(scrFile, new File(abc), false);
			// addWaterMarkOnImages("TC01", new File(abc), new File(abc));
			//// attach file in path
			screenShots.add(abc);
			
			
		} catch (Exception e) { // TODO: handle exception
		}
	}
	
	public HashSet <String> isFileDownloaded(String downloadPath, String fileName) {

	    String pathnames[] = null;
	    File dir = new File(downloadPath);
	 // Populates the array with names of files and directories
        pathnames = dir.list();
        // For each pathname in the pathnames array
        HashSet <String> a = new HashSet<> ();
        
        for (String pathname : pathnames) {
            // Print the names of files and directories
            a.add(pathname);
        }
       
        return a;
    }
	
	

}

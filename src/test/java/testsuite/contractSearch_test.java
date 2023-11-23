package testsuite;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.Color;
import org.testng.Assert;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageActions.ContractSearchPageAction;
import pageActions.LateralMenuAction;
import pageActions.loginAction;
import pageActions.verticalMenuAction;
import utils.utilityClass;
@Listeners(utils.listnerlogs.class)

public class contractSearch_test extends ContractSearchPageAction{

		loginAction login = new loginAction();
		verticalMenuAction verticalMenu = new verticalMenuAction();
		utilityClass utils = new utilityClass();

		@BeforeClass
		public void login() throws InterruptedException {
			navigate();
			Assert.assertEquals(login.getTitle(), "AUL Corp.");
			login.login(prop.getProperty("username1"), prop.getProperty("password"));
			verticalMenu.navigatetoLeftMenu("Contracts","Contract Search");
		}
		

		
		@Test
        public void pageredirection_15087_15228_15229_20716_21114() throws InterruptedException {
			
			
			filterStatus("Entered");
			for(int i =0; i<editReContractlink().size(); i++ ) {
				Assert.assertEquals(editReContractlink().get(i), "Edit");
			}
<<<<<<< Updated upstream
		    Assert.assertEquals(editContracturl(), "https://qa2.adl.aulcorp.com/portal/contracts/edit-contract");
		    driver.navigate().back();
		}
		
		@Test
		public void headerVerification_20969_20761_21279() throws InterruptedException {
			
//			verticalMenu.navigatetoLeftMenu("Contracts","Contract Search");
			ArrayList list = new ArrayList<> ();
			list.addAll(Arrays.asList("","Select", "Status", "Remit Date", "CC Reward ID", "Contract", "VIN", "Program", "Lienholder", "Last Name", "Sale Date", "Processed Date", "Retail Price", "AUL Cost", "Cert Form", "Remit Form","" ,"" ,"" ));
		    Assert.assertEquals(tableHeader(),list);
		    Assert.assertEquals(dropDownValue(), "Customize");
	         
		}
		
		@Test
        public void reContractLink_20719_21141_21143_21257_21286() throws InterruptedException {
			
//			verticalMenu.navigatetoLeftMenu("Contracts","Contract Search");
			Assert.assertEquals(calenderLabel().get(0).getText(), "From");
			Assert.assertEquals(calenderLabel().get(1).getText(), "To");
			Assert.assertEquals(datefield().get(0).getAttribute("readonly"), "true");
			Assert.assertEquals(datefield().get(1).getAttribute("readonly"), "true");
			filterStatus("Entered");
			for(int i =0; i<reContractlink().size(); i++ ) {
				Assert.assertEquals(reContractlink().get(i), "Re-Contract");
			}
		    Assert.assertEquals(reContracturl(), "https://qa2.adl.aulcorp.com/portal/rate/rate-contract");
		    driver.navigate().back();
		}
				
		@Test
		public void programSorting_21165() throws InterruptedException {

			List l = new ArrayList();
			l = sortColumn(8);
			Collections.sort(l);
			System.out.println(l);
			System.out.println(sortColumn(8));
			Assert.assertEquals(sortColumn(8),l);
			
		}
		
		@Test
		public void initialSorting_21281_21233() {
			
			List firstlist = new ArrayList();
			firstlist = columnlist(6);
			filterStatus("Entered");
			clearFilter().click();
			List laterlist = new ArrayList();
			laterlist = columnlist(6);
			Assert.assertEquals(laterlist, firstlist);
		}
=======
		    Assert.assertEquals(editContracturl(), "https://qa.adl.aulcorp.com/portal/contracts/edit-contract");
		    driver.navigate().back();
		}
		
//		@Test
//		public void headerVerification_20969_20761_21279() throws InterruptedException {
//			
//			ArrayList list = new ArrayList<> ();
//			list.addAll(Arrays.asList("","Select", "Status", "Remit Date", "CC Reward ID", "Contract", "VIN", "Program", "Lienholder", "Last Name", "Sale Date", "Processed Date", "Retail Price", "AUL Cost", "Cert Form", "Remit Form","" ,"" ,"" ));
//		    Assert.assertEquals(tableHeader(),list);
//		    Assert.assertEquals(dropDownValue(), "Customize");
//	         
//		}
>>>>>>> Stashed changes
		
//		@Test
//        public void reContractLink_20719_21141_21143_21257_21286() throws InterruptedException {
//			
//			Assert.assertEquals(calenderLabel().get(0).getText(), "From");
//			Assert.assertEquals(calenderLabel().get(1).getText(), "To");
//			Assert.assertEquals(datefield().get(0).getAttribute("readonly"), "true");
//			Assert.assertEquals(datefield().get(1).getAttribute("readonly"), "true");
//			filterStatus("Entered");
//			for(int i =0; i<reContractlink().size(); i++ ) {
//				Assert.assertEquals(reContractlink().get(i), "Re-Contract");
//			}
//		    Assert.assertEquals(reContracturl(), "https://qa.adl.aulcorp.com/portal/rate/rate-contract");
//		    driver.navigate().back();
//		}
//				
//		@Test
//		public void programSorting_21165() throws InterruptedException {
//
//			List l = new ArrayList();
//			l = sortColumn(8);
//			Collections.sort(l);
//			System.out.println(l);
//			System.out.println(sortColumn(8));
//			Assert.assertEquals(sortColumn(8),l);
//			
//		}
//		
//		@Test(enabled = false)
//		public void initialSorting_21281_21233() {
//			
//			List firstlist = new ArrayList();
//			firstlist = columnlist(6);
//			filterStatus("Entered");
//			clearFilter().click();
//			List laterlist = new ArrayList();
//			laterlist = columnlist(6);
//			Assert.assertEquals(laterlist, firstlist);
//		}
//		
//		@Test
//		public void lastnameSorting_21166() throws InterruptedException {
//
//			List l = new ArrayList();
//			l = sortColumn(10);
//			Collections.sort(l);
//			System.out.println(l);
//			System.out.println(sortColumn(10));
//			Assert.assertEquals(sortColumn(10),l);
//			
//		}
		
//
//		@Test
//		public void retailcostSorting_21169() throws InterruptedException {
//
//			List l = new ArrayList();
//			l = sortpriceColumn(13);
//			Collections.sort(l);
//			Assert.assertEquals(sortpriceColumn(13),l);
//			
//		}

//		@Test
//		public void sortStyling_21169_21175_21176_21181_21182() throws InterruptedException {
//
//			String actualColor = Color.fromString(colorAttribute(13)).asHex();
//			Assert.assertEquals(actualColor, prop.get("darkOrangeInHexaForm"));
//			String actualColor1 = Color.fromString(colorAttribute(14)).asHex();
//			Assert.assertEquals(actualColor1, prop.get("darkOrangeInHexaForm"));
//			String actualColor2 = Color.fromString(colorAttribute(10)).asHex();
//			Assert.assertEquals(actualColor2, prop.get("darkOrangeInHexaForm"));
//			String actualColor3 = Color.fromString(colorAttribute(4)).asHex();
//			Assert.assertEquals(actualColor3, prop.get("darkOrangeInHexaForm"));
//			String actualColor4 = Color.fromString(colorAttribute(8)).asHex();
//			Assert.assertEquals(actualColor4, prop.get("darkOrangeInHexaForm"));
//			
//		}

		
		
//		@Test
//		public void aulcostSorting_21170() throws InterruptedException {
//
//			List l = new ArrayList();
//			l = sortpriceColumn(14);
//			Collections.sort(l);
//			Assert.assertEquals(sortpriceColumn(14),l);
//			
//		}
		
		
<<<<<<< Updated upstream
		@Test
		public void contractSorting_21171() throws InterruptedException {

			List l = new ArrayList();
			l = reversesortColumn(6);
			Collections.sort(l);
			l.sort(Collections.reverseOrder());
			System.out.println(l);
			System.out.println(reversesortColumn(6));
			Assert.assertEquals(reversesortColumn(6),l);
			
		}
		
		@Test
		public void vinSorting_21172() throws InterruptedException {

			List l = new ArrayList();
			l = reversesortColumn(7);
			Collections.sort(l);
			l.sort(Collections.reverseOrder());
			Assert.assertEquals(reversesortColumn(7),l);		
		}

		@Test
		public void editReContractHeader_20723_20718() throws InterruptedException {
			
//			verticalMenu.navigatetoLeftMenu("Contracts","Contract Search");
		    Assert.assertFalse(tableHeader().equals("Re-Contract"));
		    Assert.assertFalse(tableHeader().equals("Edit"));
		      
		}
		
		
		@Test
		public void expandContract_21098_21100() throws InterruptedException {
		
			expandRecord();
			Assert.assertTrue(driver.findElement(By.cssSelector("td >.tr-expansible__container")).isDisplayed());
			ArrayList heading =  new ArrayList<>(Arrays.asList(
					"Year:", "Make:", "Model:", "Odometer Miles:", "Coverage:", "Remit No.:", "Class:", "Deductible:", "Disappearing Deductible:", "In-Service Date:", "Created By:", "Term:", "One Ton:", "Turbo:", "Seals & Gaskets:", "Four-All Wheel Drive:", "Diesel:", "Warranty Remaining:", "Lift Kit:", "Business Use:"));
			Assert.assertEquals(details(), heading);
			collapseRecord();
		}
		

		@Test
		public void expandTwoContract_21106() throws InterruptedException {
			

			expandTwoRecord();
			Assert.assertTrue(driver.findElements(By.cssSelector("td >.tr-expansible__container")).get(0).isDisplayed());
			Assert.assertTrue(driver.findElements(By.cssSelector("td >.tr-expansible__container")).get(1).isDisplayed());
			collapseTwoRecord();
		}
		
		@Test
		public void delete_21111_21120_21121_21122_21131_21132_21133_21145_21146() throws InterruptedException {
			
             Assert.assertEquals(deleteLink().getText(), "Delete");
             Assert.assertTrue(deleteAttribute().getAttribute("class").contains("toolbar__delete--disabled"));
             filterStatus("Entered");
             selectCheckbox(2);
             Assert.assertTrue(deleteAttribute().getAttribute("class").contains("toolbar__delete"));
             Assert.assertEquals(itemsSelected(), "1 item(s) selected");
             clickDelete();
             Assert.assertEquals(modelBoxYes().getText(), "Yes");
             Assert.assertEquals(modelBoxNo().getText(), "No");
             Assert.assertEquals(modelBoxText().getText(), "Are you sure you want to delete this 1 contract?");
             modelBoxClose().click();
             Assert.assertEquals(itemsSelected(), "1 item(s) selected");
             clickDelete();
             modelBoxNo().click();
             Assert.assertEquals(itemsSelected(), "1 item(s) selected");
             Assert.assertEquals(mainHeading(), 
            		 "The following table below displays all the contracts within the selected date parameters above. You can search for information related to any of the contracts below. Example: Dealer Name, last 6 of VIN, Make, Model, Lienholder.");
		}

		
		@Test
		public void recordNumber_20731_20736_21270_21278() throws InterruptedException {
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			//Scroll down till the bottom of the page
			js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		    String count = utils.text("cssSelector", showRecord);
		    Assert.assertTrue(count.startsWith("Showing"));
		    Assert.assertTrue(count.endsWith("records"));
		    int length = driver.findElements(By.xpath(row)).size();
		    String a[] = count.split(" ");
		    int j = a.length;
		    int i = Integer.parseInt(a[j-2]);
            if(i<=25) {
            	
            	Assert.assertEquals(length, i);
            }
            else {
            	Assert.assertEquals(length,25);
            }
		      
		}
		
		@Test
	    public void downloadPDFFile_21192_21194_21195_21196_21197_21199_21200() throws InterruptedException {
	    	
			HashSet<String> b = new HashSet<>();
			b = isFileDownloaded(System.getProperty("user.dir") + "\\PDF", ".pdf");
			downloadPDF();
			Assert.assertTrue(driver.findElement(By.cssSelector(".toast-success")).isDisplayed());
			Thread.sleep(3000);
			HashSet<String> a1 = new HashSet<>();
			a1 = isFileDownloaded(System.getProperty("user.dir") + "\\PDF", ".pdf");
			a1.removeAll(b);
			Assert.assertEquals(a1.toString(), filenameFormat(30,"pdf"));
			String pdfUrl = "file:///" +  System.getProperty("user.dir") + "\\PDF\\" + a1.toString().replaceAll("\\,|\\[|\\]|\\s", "");
			String pdfUrl1 = pdfUrl.replace("\\", "/");
			verifyContentInPDf(pdfUrl1, statefirstRow());
			verifyContentInPDf(pdfUrl1, contractfirstRow());
			String statelastRow = driver.findElement(By.xpath(xpathLastrow("3"))).getText();
			String contractlastRow = driver.findElement(By.xpath(xpathLastrow("6"))).getText();
			verifyContentInPDf(pdfUrl1, statelastRow);
			verifyContentInPDf(pdfUrl1, contractlastRow);
	    }
		
		@Test
		public void downloadCert() {
			
			certfirstRow();
			Assert.assertTrue(driver.findElement(By.cssSelector(".toast-success")).getText().contains( "Please note - Your file will be shown at the bottom of the browser and will be automatically saved into your Downloads folder."));
			Assert.assertTrue(driver.findElement(By.cssSelector(".toast-success")).getText().contains( "If your form does not display in a new window, please check your browser settings and turn off the pop-up blocker if it is on."));
			
		}
		
		@Test
	    public void downloadXLSFile_21204_21206() throws InterruptedException {
	    	
			HashSet<String> b = new HashSet<>();
			b = isFileDownloaded(System.getProperty("user.dir") + "\\PDF", ".xlsx");
			downloadXLS();
			Assert.assertTrue(driver.findElement(By.cssSelector(".toast-success")).isDisplayed());
			Thread.sleep(3000);
			HashSet<String> a1 = new HashSet<>();
			a1 = isFileDownloaded(System.getProperty("user.dir") + "\\PDF", ".xlsx");
			a1.removeAll(b);
			Assert.assertEquals(a1.toString(), filenameFormat(30, "xlsx"));
	    }
		
		@Test
	    public void searchBar_21228_21240_21269() throws InterruptedException {
	    	
			Assert.assertEquals(searchbar().getAttribute("placeholder"), "Search");
			Assert.assertEquals(searchbar().getAttribute("maxlength"), "50");
			searchbar().sendKeys("$%^#");
			Assert.assertEquals(noResult(), "There are no records to display");
			clearFilter().click();
			searchbar().sendKeys(contractfirstRow());
			Thread.sleep(5000);
			Assert.assertEquals(length(), 1);
			clearFilter().click();
			filterStatus(statefirstRow());
			Thread.sleep(5000);
			int k = length();
			clearFilter().click();
			searchbar().sendKeys(statefirstRow());
			Thread.sleep(5000);
			Assert.assertEquals(length(), k);
	    }
		
		@Test
		 public void searchBarVin_21241() throws InterruptedException {
		    	
				clearFilter().click();
				searchbar().sendKeys(vinfirstRow());
				Thread.sleep(5000);
				List a = columnlist(7);
				for(int i=0;i <a.size(); i++) {
					Assert.assertEquals(a.get(i), vinfirstRow());
				}
		    }
		
		
		
		@Test
		 public void searchBarProgram_21242() throws InterruptedException {
		    	
				clearFilter().click();
				searchbar().sendKeys(programfirstRow());
				Thread.sleep(5000);
				List a = columnlist(8);
				for(int i=0;i <a.size(); i++) {
					Assert.assertEquals(a.get(i), programfirstRow());
				}
		    }
		
		
		@Test
		 public void searchBarLastname_21243() throws InterruptedException {
		    	
				clearFilter().click();
				searchbar().sendKeys(lastnamefirstRow());
				Thread.sleep(5000);
				List a = columnlist(10);
				for(int i=0;i <a.size(); i++) {
					Assert.assertTrue(a.get(i).toString().contains(lastnamefirstRow()));
				}
		    }
		
		@Test
		 public void searchBarSaleDate_21244() throws InterruptedException {
		    	
				clearFilter().click();
				searchbar().sendKeys(saledatefirstRow());
				Thread.sleep(5000);
				List a = columnlist(11);
				for(int i=0;i <a.size(); i++) {
					Assert.assertEquals(a.get(i), saledatefirstRow());
				}
		    }
		
		@Test
		 public void searchBarMake_21249() throws InterruptedException {
		    	
				clearFilter().click();
				expandRecord();
				searchbar().sendKeys(make());
				Thread.sleep(5000);
				int l = length();
			    Assert.assertTrue(l >=1);
				
		    }
		
		@Test
		 public void searchBarModel_21250() throws InterruptedException {
		    	
				clearFilter().click();
				expandRecord();
				searchbar().sendKeys(model());
				Thread.sleep(5000);
				int l = length();
			    Assert.assertTrue(l >=1);
				
		    }

		
		@Test
		 public void searchBarRetailPrice_21246() throws InterruptedException {
		    	
				clearFilter().click();
				searchbar().sendKeys(retaildatefirstRow());
				Thread.sleep(5000);
				List a = columnlist(13);
				for(int i=0;i <a.size(); i++) {
					Assert.assertTrue(a.get(i).toString().contains(retaildatefirstRow()));
				}
		    }
		
		@Test
		 public void searchBarAULCost_21247() throws InterruptedException {
		    	
				clearFilter().click();
				searchbar().sendKeys(aulcostfirstRow());
				Thread.sleep(5000);
				List a = columnlist(14);
				for(int i=0;i <a.size(); i++) {
					Assert.assertTrue(a.get(i).toString().contains(aulcostfirstRow()));
				}
		    }
		
		@Test
		public void defaultRecordNumber_20733_20732() throws InterruptedException {
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			//Scroll down till the bottom of the page
			js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		    String count = utils.text("cssSelector", defaultNumber);
		    Assert.assertEquals(count, "25");
		    utils.clickfield("cssSelector", dropdownButton);
		    ArrayList a = new ArrayList();
		    int length = driver.findElements(By.cssSelector(dropdownOptions)).size();
		    for(int i =0; i< length; i++) {
		    	a.add(driver.findElements(By.cssSelector(dropdownOptions)).get(i).getText());
		    }
		      ArrayList b = new ArrayList();
		      b.add("25");
		      b.add("50");
		      b.add("100");
		      Assert.assertEquals(a,b);
		    }		
		
=======
//		@Test
//		public void contractSorting_21171() throws InterruptedException {
//
//			List l = new ArrayList();
//			l = reversesortColumn(6);
//			Collections.sort(l);
//			l.sort(Collections.reverseOrder());
//			System.out.println(l);
//			System.out.println(reversesortColumn(6));
//			Assert.assertEquals(reversesortColumn(6),l);
//			
//		}
//		
//		@Test
//		public void vinSorting_21172() throws InterruptedException {
//
//			List l = new ArrayList();
//			l = reversesortColumn(7);
//			Collections.sort(l);
//			l.sort(Collections.reverseOrder());
//			Assert.assertEquals(reversesortColumn(7),l);		
//		}
//
//		@Test
//		public void editReContractHeader_20723_20718() throws InterruptedException {
//			
////			verticalMenu.navigatetoLeftMenu("Contracts","Contract Search");
//		    Assert.assertFalse(tableHeader().equals("Re-Contract"));
//		    Assert.assertFalse(tableHeader().equals("Edit"));
//		      
//		}
//		
//		
//		@Test
//		public void expandContract_21098_21100() throws InterruptedException {
//		
//			expandRecord();
//			Assert.assertTrue(driver.findElement(By.cssSelector("td >.tr-expansible__container")).isDisplayed());
//			ArrayList heading =  new ArrayList<>(Arrays.asList(
//					"Year:", "Make:", "Model:", "Odometer Miles:", "Coverage:", "Remit No.:", "Class:", "Deductible:", "Disappearing Deductible:", "In-Service Date:", "Created By:", "Term:", "One Ton:", "Turbo:", "Seals & Gaskets:", "Four-All Wheel Drive:", "Diesel:", "Warranty Remaining:", "Lift Kit/Tire Mods:", "Business Use:"));
//			Assert.assertEquals(details(), heading);
//			collapseRecord();
//		}
//		
//
//		@Test
//		public void expandTwoContract_21106() throws InterruptedException {
//			
//
//			expandTwoRecord();
//			Assert.assertTrue(driver.findElements(By.cssSelector("td >.tr-expansible__container")).get(0).isDisplayed());
//			Assert.assertTrue(driver.findElements(By.cssSelector("td >.tr-expansible__container")).get(1).isDisplayed());
//			collapseTwoRecord();
//		}
//		
//		@Test
//		public void delete_21111_21120_21121_21122_21131_21132_21133_21145_21146() throws InterruptedException {
//			
//             Assert.assertEquals(deleteLink().getText(), "Delete");
//             Assert.assertTrue(deleteAttribute().getAttribute("class").contains("toolbar__delete--disabled"));
//             filterStatus("Entered");
//             selectCheckbox(2);
//             Assert.assertTrue(deleteAttribute().getAttribute("class").contains("toolbar__delete"));
//             Assert.assertEquals(itemsSelected(), "1 item(s) selected");
//             clickDelete();
//             Assert.assertEquals(modelBoxYes().getText(), "Yes");
//             Assert.assertEquals(modelBoxNo().getText(), "No");
//             Assert.assertEquals(modelBoxText().getText(), "Are you sure you want to delete this 1 contract?");
//             modelBoxClose().click();
//             Assert.assertEquals(itemsSelected(), "1 item(s) selected");
//             clickDelete();
//             modelBoxNo().click();
//             Assert.assertEquals(itemsSelected(), "1 item(s) selected");
//             Assert.assertEquals(mainHeading(), 
//            		 "The following table below displays all the contracts within the selected date parameters above. You can search for information related to any of the contracts below. Example: Dealer Name, last 6 of VIN, Make, Model, Lienholder.");
//		}
//
//		
//		@Test
//		public void recordNumber_20731_20736_21270_21278() throws InterruptedException {
//			
//			JavascriptExecutor js = (JavascriptExecutor) driver;
//			//Scroll down till the bottom of the page
//			js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
//		    String count = utils.text("cssSelector", showRecord);
//		    Assert.assertTrue(count.startsWith("Showing"));
//		    Assert.assertTrue(count.endsWith("records"));
//		    int length = driver.findElements(By.xpath(row)).size();
//		    String a[] = count.split(" ");
//		    int j = a.length;
//		    int i = Integer.parseInt(a[j-2]);
//            if(i<=25) {
//            	
//            	Assert.assertEquals(length, i);
//            }
//            else {
//            	Assert.assertEquals(length,25);
//            }
//		      
//		}
//		
//		@Test
//	    public void downloadPDFFile_21192_21194_21195_21196_21197_21199_21200() throws InterruptedException {
//	    	
//			HashSet<String> b = new HashSet<>();
//			b = isFileDownloaded(System.getProperty("user.dir") + "\\PDF", ".pdf");
//			downloadPDF();
//			Assert.assertTrue(driver.findElement(By.cssSelector(".toast-success")).isDisplayed());
//			Thread.sleep(3000);
//			HashSet<String> a1 = new HashSet<>();
//			a1 = isFileDownloaded(System.getProperty("user.dir") + "\\PDF", ".pdf");
//			a1.removeAll(b);
//			Assert.assertEquals(a1.toString(), filenameFormat(30,"pdf"));
//			String pdfUrl = "file:///" +  System.getProperty("user.dir") + "\\PDF\\" + a1.toString().replaceAll("\\,|\\[|\\]|\\s", "");
//			String pdfUrl1 = pdfUrl.replace("\\", "/");
//			verifyContentInPDf(pdfUrl1, statefirstRow());
//			verifyContentInPDf(pdfUrl1, contractfirstRow());
//			String statelastRow = driver.findElement(By.xpath(xpathLastrow("3"))).getText();
//			String contractlastRow = driver.findElement(By.xpath(xpathLastrow("6"))).getText();
//			verifyContentInPDf(pdfUrl1, statelastRow);
//			verifyContentInPDf(pdfUrl1, contractlastRow);
//	    }
//		
//		@Test
//		public void downloadCert() {
//			
//			certfirstRow();
//			Assert.assertTrue(driver.findElement(By.cssSelector(".toast-success")).getText().contains( "Please note - Your file will be shown at the bottom of the browser and will be automatically saved into your Downloads folder."));
//			Assert.assertTrue(driver.findElement(By.cssSelector(".toast-success")).getText().contains( "If your form does not display in a new window, please check your browser settings and turn off the pop-up blocker if it is on."));
//			
//		}
//		
//		@Test
//	    public void downloadXLSFile_21204_21206() throws InterruptedException {
//	    	
//			HashSet<String> b = new HashSet<>();
//			b = isFileDownloaded(System.getProperty("user.dir") + "\\PDF", ".xlsx");
//			downloadXLS();
//			Assert.assertTrue(driver.findElement(By.cssSelector(".toast-success")).isDisplayed());
//			Thread.sleep(3000);
//			HashSet<String> a1 = new HashSet<>();
//			a1 = isFileDownloaded(System.getProperty("user.dir") + "\\PDF", ".xlsx");
//			a1.removeAll(b);
//			Assert.assertEquals(a1.toString(), filenameFormat(30, "xlsx"));
//	    }
//		
//		@Test
//	    public void searchBar_21228_21240_21269() throws InterruptedException {
//	    	
//			Assert.assertEquals(searchbar().getAttribute("placeholder"), "Search");
//			Assert.assertEquals(searchbar().getAttribute("maxlength"), "50");
//			searchbar().sendKeys("$%^#");
//			Assert.assertEquals(noResult(), "There are no records to display");
//			clearFilter().click();
//			searchbar().sendKeys(contractfirstRow());
//			Thread.sleep(5000);
//			Assert.assertEquals(length(), 1);
//			clearFilter().click();
//			filterStatus(statefirstRow());
//			Thread.sleep(5000);
//			int k = length();
//			clearFilter().click();
//			searchbar().sendKeys(statefirstRow());
//			Thread.sleep(5000);
//			Assert.assertEquals(length(), k);
//	    }
//		
//		@Test
//		 public void searchBarVin_21241() throws InterruptedException {
//		    	
//				clearFilter().click();
//				searchbar().sendKeys(vinfirstRow());
//				Thread.sleep(5000);
//				List a = columnlist(7);
//				for(int i=0;i <a.size(); i++) {
//					Assert.assertEquals(a.get(i), vinfirstRow());
//				}
//		    }
//		
//		
//		
//		@Test
//		 public void searchBarProgram_21242() throws InterruptedException {
//		    	
//				clearFilter().click();
//				searchbar().sendKeys(programfirstRow());
//				Thread.sleep(5000);
//				List a = columnlist(8);
//				for(int i=0;i <a.size(); i++) {
//					Assert.assertEquals(a.get(i), programfirstRow());
//				}
//		    }
//		
//		
//		@Test
//		 public void searchBarLastname_21243() throws InterruptedException {
//		    	
//				clearFilter().click();
//				searchbar().sendKeys(lastnamefirstRow());
//				Thread.sleep(5000);
//				List a = columnlist(10);
//				for(int i=0;i <a.size(); i++) {
//					Assert.assertTrue(a.get(i).toString().contains(lastnamefirstRow()));
//				}
//		    }
//		
//		@Test
//		 public void searchBarSaleDate_21244() throws InterruptedException {
//		    	
//				clearFilter().click();
//				searchbar().sendKeys(saledatefirstRow());
//				Thread.sleep(5000);
//				List a = columnlist(11);
//				for(int i=0;i <a.size(); i++) {
//					Assert.assertEquals(a.get(i), saledatefirstRow());
//				}
//		    }
//		
//		@Test
//		 public void searchBarMake_21249() throws InterruptedException {
//		    	
//				clearFilter().click();
//				expandRecord();
//				searchbar().sendKeys(make());
//				Thread.sleep(5000);
//				int l = length();
//			    Assert.assertTrue(l >=1);
//				
//		    }
//		
//		@Test
//		 public void searchBarModel_21250() throws InterruptedException {
//		    	
//				clearFilter().click();
//				expandRecord();
//				searchbar().sendKeys(model());
//				Thread.sleep(5000);
//				int l = length();
//			    Assert.assertTrue(l >=1);
//				
//		    }
//
//		
//		@Test
//		 public void searchBarRetailPrice_21246() throws InterruptedException {
//		    	
//				clearFilter().click();
//				searchbar().sendKeys(retaildatefirstRow());
//				Thread.sleep(5000);
//				List a = columnlist(13);
//				for(int i=0;i <a.size(); i++) {
//					Assert.assertTrue(a.get(i).toString().contains(retaildatefirstRow()));
//				}
//		    }
//		
//		@Test
//		 public void searchBarAULCost_21247() throws InterruptedException {
//		    	
//				clearFilter().click();
//				searchbar().sendKeys(aulcostfirstRow());
//				Thread.sleep(5000);
//				List a = columnlist(14);
//				for(int i=0;i <a.size(); i++) {
//					Assert.assertTrue(a.get(i).toString().contains(aulcostfirstRow()));
//				}
//		    }
//		
//		@Test
//		public void defaultRecordNumber_20733_20732() throws InterruptedException {
//			
//			JavascriptExecutor js = (JavascriptExecutor) driver;
//			//Scroll down till the bottom of the page
//			js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
//		    String count = utils.text("cssSelector", defaultNumber);
//		    Assert.assertEquals(count, "25");
//		    utils.clickfield("cssSelector", dropdownButton);
//		    ArrayList a = new ArrayList();
//		    int length = driver.findElements(By.cssSelector(dropdownOptions)).size();
//		    for(int i =0; i< length; i++) {
//		    	a.add(driver.findElements(By.cssSelector(dropdownOptions)).get(i).getText());
//		    }
//		      ArrayList b = new ArrayList();
//		      b.add("25");
//		      b.add("50");
//		      b.add("100");
//		      Assert.assertEquals(a,b);
//		    }		
//		
>>>>>>> Stashed changes
		
		/***************logout to the application
		 * @throws InterruptedException ********************/
		@AfterClass
		public void close() throws InterruptedException {
	 
		        login.logout();
		    }
			
}

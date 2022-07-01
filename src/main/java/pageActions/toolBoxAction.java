package pageActions;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.NoSuchElementException;
import java.util.Set;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Sleeper;
import org.testng.Assert;

import pageObjects.toolBoxpo;
import utils.utilityClass;

public class toolBoxAction extends toolBoxpo {

	utilityClass event = new utilityClass();

	public String verifyTitle() {

		sleepWaitFunction(2000);
		return (event.text("xpath", TBTitle));

	}

	public String toolboxLocation() {

		sleepWaitFunction(4000);
		return (event.text("xpath", "//*[contains(text(),'Help')]//preceding::a[contains(text(),'Toolbox')]"));
	}

	public void clickAction(String element) {

		driver.findElement(By.xpath(element)).click();
	}

	public void sleepWaitFunction(int time) {

		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void verifyForms(String element1, String roleType) {

		clickAction(element1);

		String FormTabName = driver.findElement(By.xpath(element1)).getText();
		try {
			VerifyPDF(FormTabName, roleType);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		clickAction(element1);
	}

	public void DownloadPDF(String PDFForm) {

		driver.findElement(By.xpath(PDFForm)).click();
		sleepWaitFunction(5000);

	}

	public boolean isFileDownloaded(String downloadPath, String fileName) throws IOException {
		File dir = new File(downloadPath);
		File[] dirContents = dir.listFiles();
		String url = "file:///" + downloadPath + "\\" + fileName;

		for (int i = 0; i < dirContents.length; i++) {
			if (dirContents[i].getName().equals(fileName)) {

				sleepWaitFunction(5000);

				readPdfContent(url);
				dirContents[i].delete();

				System.out.println(dirContents[i]);

				return true;
			}
		}
		return false;
	}

	public void VerifyPDF(String FormName, String roleType) throws IOException {

		int NoOfForms = 0;

		Set<String> setOfKey1;

		String PDFName;
		WebElement PDFFile;

		switch (FormName) {
		
		case "Agent Toolbox":

			LinkedHashMap<String, String> AgentToolBoxFormName = new LinkedHashMap<String, String>();

			AgentToolBoxFormName.put(TBAulCorpContactListPDF, "AUL_Contact_List.pdf");

			Set<String> setOfKey = AgentToolBoxFormName.keySet();

			for (String key : setOfKey) {

				PDFName = driver.findElement(By.xpath(key)).getText();

				PDFFile = driver.findElement(By.xpath(key));

				if (PDFFile.isDisplayed()) {

					DownloadPDF(key);
					sleepWaitFunction(4000);

					try {
						isFileDownloaded(System.getProperty("user.dir") + "\\PDF", AgentToolBoxFormName.get(key));
					} catch (Exception e) {
						// TODO Auto-generated catch block
						System.out.println(e);
					}

				}
				sleepWaitFunction(2000);
			}

			break;

		case "Dealer Toolbox":

			LinkedHashMap<String, String> DealerToolBoxFormName = new LinkedHashMap<String, String>();

			DealerToolBoxFormName.put(TBAulCorpContactListPDF, "AUL_Contact_List.pdf");

			Set<String> setOfKey4 = DealerToolBoxFormName.keySet();

			for (String key : setOfKey4) {

				PDFName = driver.findElement(By.xpath(key)).getText();

				PDFFile = driver.findElement(By.xpath(key));

				if (PDFFile.isDisplayed()) {

					DownloadPDF(key);
					sleepWaitFunction(4000);

					try {
						isFileDownloaded(System.getProperty("user.dir") + "\\PDF", DealerToolBoxFormName.get(key));
					} catch (Exception e) {
						// TODO Auto-generated catch block
						System.out.println(e);
					}

				}
				sleepWaitFunction(2000);
			}

			break;

		case "Forms Library":

			LinkedHashMap<String, String> RoleTypeToolBox;

			LinkedHashMap<String, String> DealerToolBoxFormName1 = new LinkedHashMap<String, String>();
			LinkedHashMap<String, String> AgentToolBoxFormName1 = new LinkedHashMap<String, String>();

			DealerToolBoxFormName1.put(TBContractCancellationFormPDF, "Contract_Cancellation_Form.pdf");
			DealerToolBoxFormName1.put(TBContractRemittanceReportPDF, "Contract_Remittance_Report.pdf");
			DealerToolBoxFormName1.put(TBContractRenewalGuidelinesPDF, "Contract_Renewal_Guidelines.pdf");
			DealerToolBoxFormName1.put(TBContractTransferFormsPDF, "Contract_Transfer_Form.pdf");
			DealerToolBoxFormName1.put(TBContractUpgradeFormPDF, "Contract_Upgrade_Form.pdf");
			DealerToolBoxFormName1.put(TBServiceDepartmentGuidelinesPDF, "Service_Department_Guidelines.pdf");
			DealerToolBoxFormName1.put(TBVehicleInspectionReport, "Vehicle_Inspection_Sheet.pdf");

			AgentToolBoxFormName1.put(TBContractCancellationFormPDF, "Contract_Cancellation_Form.pdf");
			AgentToolBoxFormName1.put(TBContractRemittanceReportPDF, "Contract_Remittance_Report.pdf");
			AgentToolBoxFormName1.put(TBContractRenewalGuidelinesPDF, "Contract_Renewal_Guidelines.pdf");
			AgentToolBoxFormName1.put(TBContractTransferFormsPDF, "Contract_Transfer_Form.pdf");
			AgentToolBoxFormName1.put(TBContractUpgradeFormPDF, "Contract_Upgrade_Form.pdf");
			AgentToolBoxFormName1.put(TBServiceDepartmentGuidelinesPDF, "Service_Department_Guidelines.pdf");
			AgentToolBoxFormName1.put(TBVehicleInspectionReport, "Vehicle_Inspection_Sheet.pdf");

			AgentToolBoxFormName1.put(TBACHAgreementForm, "ACH_Agreement.pdf");
			AgentToolBoxFormName1.put(TBAULGAPLenderAgreementPacketForm, "AUL_GAP_Lender_Agreement_Packet.pdf");
			AgentToolBoxFormName1.put(TBChecklistWithAccountManagementForm,
					"Checklist_with_Account_Mangement_Form.pdf");
			AgentToolBoxFormName1.put(TBClassicTrakAncillaryDealerAgreement,
					"ClassicTrak_Ancillary_Dealer_Agreement.pdf");
			AgentToolBoxFormName1.put(TBCreditCardRewardsAgreementPacket, "Credit_Card_Rewards_Agreement_Packet.pdf");
			AgentToolBoxFormName1.put(TBDealerAgreementPacket, "Dealer_Agreement_Packet.pdf");
			AgentToolBoxFormName1.put(TBDealerPassThroughAgreement, "Dealer_Pass_Through_Agreement.pdf");

			AgentToolBoxFormName1.put(TBEssentialsAddendum, "Essentials_Addendum.pdf");
			AgentToolBoxFormName1.put(TBFloridaDealerAgreementPacket, "Florida_Dealer_Agreement_Packet.pdf");
			AgentToolBoxFormName1.put(TBLimitedWarrantyDealerAgreement, "Limited_Warranty_Dealer_Agreement.pdf");
			AgentToolBoxFormName1.put(TBPowertrainProgramAddendum, "Powertrain_Program_Addendum.pdf");

			if (roleType == "Agent") {

				RoleTypeToolBox = AgentToolBoxFormName1;
				setOfKey1 = AgentToolBoxFormName1.keySet();

			} else {

				RoleTypeToolBox = DealerToolBoxFormName1;
				setOfKey1 = DealerToolBoxFormName1.keySet();

			}

			for (String key1 : setOfKey1) {

				boolean flag = false;

				PDFFile = driver.findElement(By.xpath(key1));

				sleepWaitFunction(4000);

				flag = driver.findElement(By.xpath(key1)).isDisplayed();

				
				Assert.assertEquals(flag, true, RoleTypeToolBox.get(key1) + " is not displayed.");

				if (flag) {

					PDFName = driver.findElement(By.xpath(key1)).getText();

					DownloadPDF(key1);

					boolean fileDownloadflag = isFileDownloaded(System.getProperty("user.dir") + "\\PDF",
							RoleTypeToolBox.get(key1));

					Assert.assertEquals(fileDownloadflag, true, RoleTypeToolBox.get(key1) + "File is not Present.");

				}
				sleepWaitFunction(4000);


			}

			break;

		case "Marketing Material":

			LinkedHashMap<String, String> RoleTypeToolBox2;

			LinkedHashMap<String, String> DealerToolBoxFormName2 = new LinkedHashMap<String, String>();
			LinkedHashMap<String, String> AgentToolBoxFormName2 = new LinkedHashMap<String, String>();

			DealerToolBoxFormName2.put(TBActivationReportAndDashboardJobAidReport,
					"Activations_Report_and_Dashboard_job_Aid.pdf");
			DealerToolBoxFormName2.put(TBCancellationRmitAndUnremitJobAidReport,
					"Cancellations_Remit_and_Unremit_Job_Aid.pdf");
			DealerToolBoxFormName2.put(TBContractSearchJobAidReport, "Contract_Search_Job_Aid.pdf");
			DealerToolBoxFormName2.put(TBEarlyClaimsJobAidReport, "Early_Claims_Job_Aid.pdf");
			DealerToolBoxFormName2.put(TBMyAccountStatementAndActurialStatementsJobAidReport,
					"My_Account_Statement_Actuarial_Statements_Job_Aid.pdf");
			DealerToolBoxFormName2.put(TBUnpaidContractTrainingManualForm, "Unpaid_Contracts_Training_Manual.pdf");
			DealerToolBoxFormName2.put(TBAUNContractForm, "AUN-E-Contract.pdf");
			DealerToolBoxFormName2.put(TBES2ContractForm, "ES2-E-Contract.pdf");
			DealerToolBoxFormName2.put(TBFI2ContractForm, "FI2-E-Contract.pdf");
			DealerToolBoxFormName2.put(TBLimitedWarrantyForm, "Limited_Warranty_E-Contract.pdf");
			DealerToolBoxFormName2.put(TBNSEContractForm, "NSE-E-Contract.pdf");
			DealerToolBoxFormName2.put(TBPTPContractForm, "PTP-E-Contract.pdf");
			DealerToolBoxFormName2.put(TBSNIContractForm, "SNI-E-Contract.pdf");
			DealerToolBoxFormName2.put(TBSNLContractForm, "SNL-E-Contract.pdf");
			DealerToolBoxFormName2.put(TBES2SPContractForm, "ES2_SP_E-Contract.pdf");
			DealerToolBoxFormName2.put(TBFI2SPContractForm, "FI2_SP_E-Contract.pdf");
			DealerToolBoxFormName2.put(TBTrademarkLicenseAgreementAndStyleGuide,
					"Trademark_License_Agreement_and_Style_Guide.pdf");

			AgentToolBoxFormName2.put(TBActivationReportAndDashboardJobAidReport,
					"Activations_Report_and_Dashboard_job_Aid.pdf");
			AgentToolBoxFormName2.put(TBCancellationRmitAndUnremitJobAidReport,
					"Cancellations_Remit_and_Unremit_Job_Aid.pdf");
			AgentToolBoxFormName2.put(TBContractSearchJobAidReport, "Contract_Search_Job_Aid.pdf");
			AgentToolBoxFormName2.put(TBEarlyClaimsJobAidReport, "Early_Claims_Job_Aid.pdf");
			AgentToolBoxFormName2.put(TBMyAccountStatementAndActurialStatementsJobAidReport,
					"My_Account_Statement_Actuarial_Statements_Job_Aid.pdf");
			AgentToolBoxFormName2.put(TBUnpaidContractTrainingManualForm, "Unpaid_Contracts_Training_Manual.pdf");
			AgentToolBoxFormName2.put(TBAUNContractForm, "AUN-E-Contract.pdf");
			AgentToolBoxFormName2.put(TBES2ContractForm, "ES2-E-Contract.pdf");
			AgentToolBoxFormName2.put(TBFI2ContractForm, "FI2-E-Contract.pdf");
			AgentToolBoxFormName2.put(TBLimitedWarrantyForm, "Limited_Warranty_E-Contract.pdf");
			AgentToolBoxFormName2.put(TBNSEContractForm, "NSE-E-Contract.pdf");
			AgentToolBoxFormName2.put(TBPTPContractForm, "PTP-E-Contract.pdf");
			AgentToolBoxFormName2.put(TBSNIContractForm, "SNI-E-Contract.pdf");
			AgentToolBoxFormName2.put(TBSNLContractForm, "SNL-E-Contract.pdf");
			AgentToolBoxFormName2.put(TBES2SPContractForm, "ES2_SP_E-Contract.pdf");
			AgentToolBoxFormName2.put(TBFI2SPContractForm, "FI2_SP_E-Contract.pdf");
			AgentToolBoxFormName2.put(TBTrademarkLicenseAgreementAndStyleGuide,
					"Trademark_License_Agreement_and_Style_Guide.pdf");

			if (roleType == "Agent") {

				RoleTypeToolBox2 = AgentToolBoxFormName2;
				setOfKey1 = AgentToolBoxFormName2.keySet();

			} else {

				RoleTypeToolBox2 = DealerToolBoxFormName2;
				setOfKey1 = DealerToolBoxFormName2.keySet();

			}
			
			for (String key1 : setOfKey1) {

				boolean flag = false;



				PDFFile = driver.findElement(By.xpath(key1));

				sleepWaitFunction(4000);

				flag = driver.findElement(By.xpath(key1)).isDisplayed();

				
				Assert.assertEquals(flag, true, RoleTypeToolBox2.get(key1) + " is not displayed.");

				if (flag) {

					PDFName = driver.findElement(By.xpath(key1)).getText();

					DownloadPDF(key1);

					boolean fileDownloadflag = isFileDownloaded(System.getProperty("user.dir") + "\\PDF",
							RoleTypeToolBox2.get(key1));

					Assert.assertEquals(fileDownloadflag, true, RoleTypeToolBox2.get(key1) + "File is not Present.");

				}
				sleepWaitFunction(4000);
				windowScroll();


			}
		

			break;

		case "Payment Plan Partners":
			
			LinkedHashMap<String, String> RoleTypeToolBox3;

			LinkedHashMap<String, String> DealerToolBoxFormName3 = new LinkedHashMap<String, String>();
			LinkedHashMap<String, String> AgentToolBoxFormName3 = new LinkedHashMap<String, String>();

			DealerToolBoxFormName3.put(TBSPPProcedureGuide, "SPP_TrManual.pdf");
			DealerToolBoxFormName3.put(TBZEROPlanProgramAccountingOfficeTraining,
					"ZERO_Plan_Program_Accounting_Office_Training.pdf");
			DealerToolBoxFormName3.put(TBZEROPlanProgramDealerTraining, "ZERO_Plan_Program_Dealer_Training.pdf");
			DealerToolBoxFormName3.put(TBZEROPlanProgramOverview, "Zero_Plan_Program_Overview.pdf");
			DealerToolBoxFormName3.put(TBZEROPlanProgramRetailerOverview, "ZERO_Plan_Program_Retailer_Overview.pdf");

			AgentToolBoxFormName3.put(TBSPPProcedureGuide, "SPP_TrManual.pdf");
			AgentToolBoxFormName3.put(TBZEROPlanProgramAccountingOfficeTraining,
					"ZERO_Plan_Program_Accounting_Office_Training.pdf");
			AgentToolBoxFormName3.put(TBZEROPlanProgramDealerTraining, "ZERO_Plan_Program_Dealer_Training.pdf");
			AgentToolBoxFormName3.put(TBZEROPlanProgramOverview, "Zero_Plan_Program_Overview.pdf");
			AgentToolBoxFormName3.put(TBZEROPlanProgramRetailerOverview, "ZERO_Plan_Program_Retailer_Overview.pdf");

//			DealerToolBoxFormName3.put(TBSPPDealerAgreement, "SPP_Dealer_Agreement.pdf");
//			DealerToolBoxFormName3.put(TBSPPWebTrainingManual, "SPP_TrManual.pdf");
//			DealerToolBoxFormName3.put(TBEnrollmentPacketFranchiseNew, "SPP_TrManual.pdf");
//			DealerToolBoxFormName3.put(TBEnrollmentPacketIndependentUsed, "Enrollment_Packet_Independent_Used.pdf");
//			DealerToolBoxFormName3.put(TBZEROPlanProgramAgentTraining, "ZERO_Plan_Program_Agent_Training.pdf");
			
			if (roleType == "Agent") {

				RoleTypeToolBox3 = AgentToolBoxFormName3;
				setOfKey1 = AgentToolBoxFormName3.keySet();

			} else {

				RoleTypeToolBox3 = DealerToolBoxFormName3;
				setOfKey1 = DealerToolBoxFormName3.keySet();

			}
			
			for (String key1 : setOfKey1) {

				boolean flag = false;

//				try {

				PDFFile = driver.findElement(By.xpath(key1));

				sleepWaitFunction(4000);

				flag = driver.findElement(By.xpath(key1)).isDisplayed();

				
				Assert.assertEquals(flag, true, RoleTypeToolBox3.get(key1) + " is not displayed.");

				if (flag) {

					PDFName = driver.findElement(By.xpath(key1)).getText();

					DownloadPDF(key1);

					boolean fileDownloadflag = isFileDownloaded(System.getProperty("user.dir") + "\\PDF",
							RoleTypeToolBox3.get(key1));

					Assert.assertEquals(fileDownloadflag, true, RoleTypeToolBox3.get(key1) + "File is not Present.");

				}
				sleepWaitFunction(4000);


			}

			break;
		}

	}

	public static String readPdfContent(String url) throws IOException {

		URL pdfUrl = new URL(url);
		InputStream in = pdfUrl.openStream();
		BufferedInputStream bf = new BufferedInputStream(in);
		PDDocument doc = PDDocument.load(bf);
		int numberOfPages = getPageCount(doc);
		System.out.println("The total number of pages " + numberOfPages);
		String content = new PDFTextStripper().getText(doc);
		doc.close();

		return content;
	}

	public static int getPageCount(PDDocument doc) {

		int pageCount = doc.getNumberOfPages();
		return pageCount;

	}

	public void windowScroll() {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,400)", "");

	}

}

package pageObjects;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import utils.baseClass;

public class toolBoxpo extends baseClass {

	public String TBTitle = "//h3[contains(text(),\"Toolbox\")]";
	public String toolBoxLocation = "//*[contains(text(),'Help')]//preceding::a[contains(text(),'Toolbox')]";
	public String TBDealerPDF1 = "//a[contains(text(),\"AUL Corp Contact List\")]";
	public String TBDealerTab = "//*[contains(text(),\" Dealer Toolbox \")]";
	public String TBAgentTab ="//*[contains(text(),\" Agent Toolbox \")]";
	public String TBFormsLibraryTab = "//span[contains(text(),'Forms Library')]";
	public String TBMarketingMaterialTab = "//*[contains(text(),' Marketing Material ')]";
	public String TBPaymentPlanPartnersTab = "//*[contains(text(),\" Payment Plan Partners \")]";
	public String TBAulCorpContactListPDF = "//a[contains(text(),\"AUL Corp Contact List\")]";
	public String TBContractCancellationFormPDF = "//a[contains(text(),\"Contract Cancellation Forms\")]";
	public String TBContractRemittanceReportPDF = "//a[contains(text(),\"Contract Remittance Report\")]";
	public String TBContractRenewalGuidelinesPDF = "//a[contains(text(),\"Contract Renewal Guidelines\")]";
	public String TBContractTransferFormsPDF = "//a[contains(text(),\"Contract Transfer Forms\")]";
	public String TBContractUpgradeFormPDF = "//a[contains(text(),\"Contract Upgrade Form\")]";
	public String TBServiceDepartmentGuidelinesPDF = "//a[contains(text(),\"Service Department Guidelines\")]";
	public String TBVehicleInspectionReport = "//a[contains(text(),\"Vehicle Inspection Report\")]";
	
	//Marketing Material
	public String TBActivationReportAndDashboardJobAidReport = "//a[contains(text(),\"Activations Report and Dashboard Job Aid\")]";
	public String TBCancellationRmitAndUnremitJobAidReport = "//a[contains(text(),\"Cancellations, Remit, and Unremit Job Aid\")]";
	public String TBContractSearchJobAidReport = "//a[contains(text(),\"Contract Search Job Aid\")]";
	public String TBEarlyClaimsJobAidReport = "//a[contains(text(),\"Early Claims Job Aid\")]";
	public String TBMyAccountStatementAndActurialStatementsJobAidReport = "//a[contains(text(),\"My Account Statement & Actuarial Statements Job Aid\")]";
	public String TBUnpaidContractTrainingManualForm = "//a[contains(text(),\"Unpaid Contracts Training Manual\")]";
	public String TBAUNContractForm = "//a[contains(text(),\"AUN Contract\")]";
	public String TBES2ContractForm = "//a[contains(text(),\"ES2 Contract\")]";
	public String TBFI2ContractForm = "//a[contains(text(),\"FI2 Contract\")]";
	public String TBLimitedWarrantyForm = "//a[contains(text(),\"Limited Warranty\")]";
	public String TBNSEContractForm = "//a[contains(text(),\"NSE Contract\")]";
	public String TBPTPContractForm = "//a[contains(text(),\"PTP Contract\")]";
	public String TBSNIContractForm = "//a[contains(text(),\"SNI Contract\")]";
	public String TBSNLContractForm = "//a[contains(text(),\"SNL Contract\")]";
	public String TBES2SPContractForm = "//a[contains(text(),\"ES2 SP Contract\")]";
	public String TBFI2SPContractForm = "//a[contains(text(),\"FI2 SP Contract\")]";
	public String TBTrademarkLicenseAgreementAndStyleGuide = "//a[contains(text(),\"Trademark License Agreement and Style Guide\")]";
	
	
	public String TBSPPProcedureGuide = "//a[contains(text(),\"SPP Procedure Guide\")]";
	public String TBZEROPlanProgramAccountingOfficeTraining = "//a[contains(text(),\"ZERO Plan Program Accounting Office Training\")]";
	public String TBZEROPlanProgramDealerTraining = "//a[contains(text(),\"ZERO Plan Program Dealer Training\")]";
	public String TBZEROPlanProgramOverview = "//a[contains(text(),\"ZERO Plan Program Overview\")]";
	public String TBZEROPlanProgramRetailerOverview = "//a[contains(text(),\"ZERO Plan Program Retailer Overview\")]";
	
//	Agent Forms Library
	public String TBACHAgreementForm = "//a[contains(text(),\"ACH Agreement\")]";
	public String TBAULGAPLenderAgreementPacketForm = "//a[contains(text(),\"AUL GAP - Lender Agreement Packet \")]";
	public String TBChecklistWithAccountManagementForm = "//a[contains(text(),\"Checklist with Account Management Form (AMF)\")]";
	public String TBClassicTrakAncillaryDealerAgreement = "//a[contains(text(),\"ClassicTrak Ancillary Dealer Agreement\")]";
	public String TBCreditCardRewardsAgreementPacket = "//a[contains(text(),\"Credit Card Rewards Agreement Packet\")]";
	public String TBDealerAgreementPacket = "//a[contains(text(),\"Credit Card Rewards Agreement Packet\")]//following::a[contains(text(),\"Dealer Agreement Packet\")][1]";
	public String TBDealerPassThroughAgreement = "//a[contains(text(),\"Dealer Pass-Through Agreement\")]";
	public String TBEssentialsAddendum = "//a[contains(text(),\"Essentials Addendum\")]";
	public String TBFloridaDealerAgreementPacket = "//a[contains(text(),\"Florida Dealer Agreement Packet\")]";
	public String TBLimitedWarrantyDealerAgreement = "//a[contains(text(),\"Limited Warranty Dealer Agreement\")]";
	public String TBPowertrainProgramAddendum = "//a[contains(text(),\"Powertrain Program Addendum\")]";
	
//	Agent Payment Plan Partners
	public String TBSPPDealerAgreement = "//a[contains(text(),\"SPP Dealer Agreement\")]";
	public String TBSPPWebTrainingManual = "//a[contains(text(),\"SPP Web Training Manual\")]";
	public String TBEnrollmentPacketFranchiseNew = "//a[contains(text(),\"Enrollment Packet – Franchise New\")]";
	public String TBEnrollmentPacketIndependentUsed = "//a[contains(text(),\"Enrollment Packet – Independent Used\")]";
	public String TBZEROPlanProgramAgentTraining = "//a[contains(text(),\"ZERO Plan Program Agent Training\")]";
	
//	public String TB = "";
//	public String TB = "";
//	public String TB = "";
//	public String TB = "";
//	public String TB = "";
//	public String TB = "";


}

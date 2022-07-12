package pageObjects;

import utils.baseClass;

public class quoteHistorypo extends baseClass {

	public String QHPageLeftButton = "//span[@class=\"ui-paginator-icon pi pi-caret-left\"]";
	public String QHPageRightButton = "//*[@class=\"ui-paginator-icon pi pi-caret-right\"]";
	public String QHPageExtremeLeftButton = "//*[@class=\"ui-paginator-icon pi pi-step-backward\"]";
	public String QPageHExtremeRightButton = "//*[@class=\"ui-paginator-icon pi pi-step-forward\"]";
	public String QHNumberOfCounts = "//*[starts-with(text(),\"Showing\")]";
	public String QHContractNumber = "//th[contains(text(),\" Contract Number \")]";
	public String QHProgram = "//th[contains(text(),\" Program \")]";
	public String QHCoverage = "//th[contains(text(),\" Coverage \")]";
	public String QHMilegae = "//th[contains(text(),\" Mileage \")]";
	public String QHMake = "//th[contains(text(),\" Make \")]";
	public String QHModel = "//th[contains(text(),\" Model \")]";
	public String QHTotalPrice = "//th[contains(text(),\" Total Price \")]";
	public String QHFirstName = "//th[contains(text(),\" First Name \")]";
	public String QHLastName = "//th[contains(text(),\" Last Name \")]";
	public String QHQuoteDate = "//th[contains(text(),\" Quote Date \")]";
	public String QHCreatedBy = "//th[contains(text(),\" Created By \")]";
	public String QHEdit = "//th[contains(text(),\" Edit \")]";
	public String QHDelete = "//th[contains(text(),\" Delete \")]";
	public String QHQuote = "//th[contains(text(),\" Quote \")]";
	public String QHUniversalSearch="//input[@placeholder=\"Search\"]";
	public String QHUniversalClearFilter = "//span[@class=\"clear-filters\"]";
	
	public String QHTitle = "//*[@class=\"title-bar\"]//child::h3";
	
	public String QHConfirmationMessage ="//span[@class=\"simple-confirmation\"]";
	public String QHConfirmationMessageWindowYes ="//span[contains(text(),\"Yes\")]";
	public String QHConfirmationMessageWindowNo ="//span[contains(text(),\"No\")]";
	public String QHConfirmationMessageClose = "//button[@aria-label=\"Close\"]";
	
	
	public String QHContractNumberSearchBox = "//*[@id=\"quote_history_table\"]/thead/adl-table-header/tr[2]/td[1]/div/div/input";
	public String QHProgramSearchBox ="//*[@id=\"quote_history_table\"]/thead/adl-table-header/tr[2]/td[2]/div/div/input";
	public String QHCoverageSearchBox ="//*[@id=\"quote_history_table\"]/thead/adl-table-header/tr[2]/td[3]/div/div/input";
	public String QHMileageSearchBox ="//*[@id=\"quote_history_table\"]/thead/adl-table-header/tr[2]/td[4]/div/div/input";
	public String QHMakeSearchBox ="//*[@id=\"quote_history_table\"]/thead/adl-table-header/tr[2]/td[5]/div/div/input";
	public String QHModelSearchBox ="//*[@id=\"quote_history_table\"]/thead/adl-table-header/tr[2]/td[6]/div/div/input";
	public String QHFirstNameSearchBox ="//*[@id=\"quote_history_table\"]/thead/adl-table-header/tr[2]/td[8]/div/div/input";
	public String QHLastNameSearchBox ="//*[@id=\"quote_history_table\"]/thead/adl-table-header/tr[2]/td[9]/div/div/input";
	public String QHQuoteDateSearchBox ="//*[@id=\"quote_history_table\"]/thead/adl-table-header/tr[2]/td[10]/div/div/input";
	public String QHCreatedBySearchBox ="//*[@id=\"quote_history_table\"]/thead/adl-table-header/tr[2]/td[11]/div/div/input";
	public String QHTotalPriceSerachBox ="//*[@id=\"quote_history_table\"]/thead/adl-table-header/tr[2]/td[7]/div/div/input";
	
}

package pageObjects;

import utils.baseClass;

public class UpsellPo extends baseClass{
	public String portalTitle = "//b[text()='Welcome to your AUL ADL Portal!']";
	public String textbox = "adl-text-input > div > div.text-field__input.secure > input";
	public String getProducts = "//span[contains(text(),'Get Products')]";
	public String programArrow = "(//span[@class='ng-arrow-wrapper'])[1]";
	public String upsellProgramArrow = "(//span[@class='ng-arrow-wrapper'])[2]";
	public String warningLabel="//span[@class='warning__label']";
	public String programTable="adl-rates-table > table >tbody > tr:nth-child(1) > td:nth-child(2)";
	public String programTableNew="(//adl-rates-table/table/tbody/tr[1]/td[2])[2]";
	public String upsellProgramTable="(//adl-rates-table/table/tbody/tr[1]/td[2])[1]";
			
	
	// grid
		public String headerLoc = "thead > adl-table-header > tr:nth-child(1) > th[role='columnheader']";
		public String rowLoc = "table>tbody>tr";
		public String searchBoxesBelowHeadersInGrid = "thead > adl-table-header > tr:nth-child(2) > td>div>div>input";
		public String selectAllCheckBox = "thead > adl-table-header > tr:nth-child(2) > td>div>div>mat-checkbox>label>div";
		public String selectCheckBoxAttribute="td:nth-of-type(1)>adl-table-cells>div>mat-checkbox>label>div>input";
		public String selectCheckBox="td:nth-of-type(1)>adl-table-cells>div>mat-checkbox>label>div";
		
}

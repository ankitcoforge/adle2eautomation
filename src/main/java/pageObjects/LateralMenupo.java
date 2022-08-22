package pageObjects;

import utils.baseClass;

public class LateralMenupo extends baseClass{
	
	public String title = "//b[text()='Welcome to your AUL ADL Portal!']";
	public String lateralMenu = "mat-tree.mat-tree";
	public String lateralMenuItems1 = "mat-tree>mat-nested-tree-node>li>button";
	public String lateralMenuItems2 = "mat-tree>mat-nested-tree-node>li>a";
	public String laterMenuSubItems = "mat-nested-tree-node[aria-expanded='true']>li>ul>mat-nested-tree-node>li>a";
	public String thirdSubMenuItems = "mat-nested-tree-node[aria-expanded='true']>li>ul>mat-nested-tree-node>li>button";
	public String rateContractTitle = "//h3[text()='Rate/Contract']";
	public String quoteHistoryTitle = "//h3[text()='Quote History']";
	public String aulLogo = "//img[@alt='AUL Logo']";
	public String cancellationQuoteTitle = "//h3[text()='Cancellation Quote']";
	public String cancellationHistoryTitle = "//h3[text()='Cancellation History']";
	public String contractSearchTitle = "//h3[text()='Contract Search']";
	public String dashboardTitle = "//h3[text()='Dashboard']";
	public String generateQuoteTxt = "//h3[text()='To Generate a Quote Sign In as a Dealer']";
}

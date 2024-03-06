package pageObjects;

import utils.baseClass;

public class verticalMenupo extends baseClass {
	
	/*************page object for vertical menu is declared ********************/
	public String erate = "//button[contains(text(),'E-Rate')]";
	public String contract = "//a[contains(text(),'Rate/Contract')]";
	public String quoteSearch = "//a[contains(text(),'Quote History')]";
	public String contracts = "//button[contains(text(),'Contract')]";
	public String contractSearch = "//a[contains(text(),'Contract Search')]";
	public String impersonate = "//a[contains(text(),'Impersonate')]";
	public String reports = "//button[contains(text(),'Report')]";
	public String accountManagement = "//button[contains(text(),'Account Management')]";
	public String milaegeAndAgeExceptions = "//a[contains(text(),'Mileage & Age Exceptions')]";
	public String arrowbtnAtRightTop = "//mat-icon[@class='mat-icon notranslate dropdown__icon material-icons mat-icon-no-color']";
	public String impersonateAtRightTop = "(//ul[@class='ng-tns-c306-36']/li)[1]";
	public String arrowOptionsList = "//ul[@class='ng-tns-c306-36']/li/button";
	public String laterMenuSubItems = "mat-nested-tree-node[aria-expanded='true']>li>ul>mat-nested-tree-node>li>a";
	public String lateralMenuItems1 = "mat-tree>mat-nested-tree-node>li>button";
	public String lateralMenuItems2 = "mat-tree>mat-nested-tree-node>li>a";
	 		

}

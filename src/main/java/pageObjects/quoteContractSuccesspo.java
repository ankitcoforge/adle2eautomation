package pageObjects;

import utils.baseClass;

public class quoteContractSuccesspo extends baseClass{
	
	public String close = "span > mat-icon[role='img']";
	public String viewPrintQuote = ".notification__container__actions > button > span";
	public String goToQuotePage = ".notification__container__actions > a:nth-child(2)";
	public String startNewQuote = "div.notification__container__actions > a:nth-child(3)";

}

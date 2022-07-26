package pageActions;

import pageObjects.quoteContractSuccesspo;
import utils.utilityClass;

public class quoteContractSuccessAction extends quoteContractSuccesspo{
	
	utilityClass event = new utilityClass();
	
	public String closeButton() {
		return event.text("cssSelector", close);
	}
	
	public String viewPrintButton() {
		return event.text("cssSelector", viewPrintQuote);
	}
	
	public String goToQuotePagelink() {
		return event.text("cssSelector", goToQuotePage);
	}
	
	public String startNewQuotelink() {
		return event.text("cssSelector", startNewQuote);
	}


}

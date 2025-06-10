package pageObjects;

import utils.baseClass;

public class AssigningLenderPassthroughToAgentCorpPO extends baseClass{
	public String roleId ="(//input[@placeholder='Please enter the Role ID / Account Name'])[2]";
	public String checkBox ="//label[@class='mat-checkbox-layout']/div";
	public String checkBoxStatus ="//label[@class='mat-checkbox-layout']/div/input";
	public String saveBtn ="//span[text()='Save']";
	public String cancelBtn ="//span[text()='Cancel']";
	public String roleDropdownListForAccountName = "//span[@class='mat-option-text']";
	public String removeLink = "//a[text()='Remove']";
	public String selectAgentName = "//input[contains(@placeholder,'Select or Type Agent')]";
	public String btnSignIn = "//span[text()=' Sign In ']";
}


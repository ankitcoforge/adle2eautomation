package pageObjects;

import utils.baseClass;

public class ManageUserPo extends baseClass{
	public String selectDealerNamearrow = "//mat-icon[text()='arrow_drop_down']";
	public String enterRole = "//input[contains(@placeholder,'Please enter the Role')]";
	public String roleDropdownListForDealer = "//mat-option[@role='option']/span/span";
	public String selectAllLink = "//div[@role='checkbox']";
	public String registrationStatusArrow = "(//span[contains(@class,'pi pi-chevron-down')])[2]";
	public String roleTypeStatusArrow = "(//span[contains(@class,'pi pi-chevron-down')])[1]";
	public String completedCheckbox = "//li[@aria-label='Completed']/div/div";
	public String registrationStatusArrowNewUserPage = "(//span[contains(@class,'pi pi-chevron-down')])[1]";
	public String submitNewUserRegistrationPage = "button[type='submit']";
	public String saveBtn = "//span[text()='Save']";
	public String closeInPermPopup = "//a[@tabindex='0']/span";
	public String permissionsArrow = "//label[text()='Permissions']/../p-multiselect/div/div[3]/span";
	//new user popup
	public String roleDropdownList = "//div[@class='scrollable-content']/div";
	public String roleDropdownListForAccountName = "//span[@class='mat-option-text']";
	public String roleDropdownForAccountName = "//input[@placeholder='Account Name']/..";
	public String email = "//adl-text-input[@label='Email']/div/div/input";
	public String submit = "//button[@form='ngFormNewUserRegistration']";

}

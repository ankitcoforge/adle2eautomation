package pageObjects;

import utils.baseClass;

public class NewUserRegistrationPo extends baseClass {
	public String roleDropdown = "//ng-select[@role='listbox']";
	public String roleDropdownInAccountManagementPage = "(//ng-select[@role='listbox'])[1]";
	public String roleDropdownForAccountName = "//input[@placeholder='Account Name']/..";
	public String roleIdInAccountManagementPage = "//div[text()='Please enter the Role ID / Account Name']/../div[2]/input";
	public String roleDropdownList = "//div[@class='scrollable-content']/div";
	public String roleDropdownListForAccountName = "//span[@class='mat-option-text']";
	public String roleDropdownListForDealer = "//mat-option[@role='option']/span/span";
	public String enterRole = "//input[contains(@placeholder,'Please enter the Role')]";
	public String newUserbtn = "//span[contains(text(),'+ New user')]";
	public String email = "//adl-text-input[@label='Email']/div/div/input";
	public String submit = "//button[@form='ngFormNewUserRegistration']";
	public String cancel = "//mat-dialog-content/div[2]/button[2]";
	public String username = "//p[text()='Username']";
	public String permissionsArrow = "//label[text()='Permissions']/../p-multiselect/div/div[3]/span";
	public String permissionsCheckedAndUnchecked = "//div[@class='cdk-virtual-scroll-content-wrapper']/p-multiselectitem/li";
	public String permissionsCheckbox = "//div[@class='cdk-virtual-scroll-content-wrapper']/p-multiselectitem/li/div/div";
	public String firstandLastName = "adl-text-input > div > div.text-field__input.secure > input";
	public String passwordField = " adl-text-input > div > div.text-field__input.public.text-field__input--suffix > input";
	public String submitNewUserRegistrationPage = "button[type='submit']";
	public String urlToRegister = " table > tbody > tr > td [style =\"border-radius: 2px;\"] > a";
	public String closeInPermPopup = "//a[@tabindex='0']/span";
	public String registrationStatusArrow = "(//span[contains(@class,'pi pi-chevron-down')])[2]";
	public String completedCheckbox = "//li[@aria-label='Completed']/div/div";
	public String registrationStatusArrowNewUserPage = "(//span[contains(@class,'pi pi-chevron-down')])[1]";
	public String delInGetEmail = "a.delete";
	public String closeAdd = "dismiss-button";
}

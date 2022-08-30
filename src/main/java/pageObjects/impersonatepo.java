package pageObjects;

import utils.baseClass;

public class impersonatepo extends baseClass{
	
	public String role1 = "ctl00_mainContent_TextBoxRoleIdentifier";
	public String roleDropdown = "ctl00_mainContent_DropDownListRoleType";
    public String roleId = "#cnt table #container table tbody tr input";
    public String button = "ctl00_mainContent_ButtonGetUsers";
    public String tableFirstRow = "ctl00_mainContent_ASPxGridViewUsers_cell0_11_ASPxButtonImpersonate";
    public String logoutArrow  = "adl-header > header > div > div > button > mat-icon";
    public String impersonate = "div [role='menu'] > div > ul >li >button";
    public String logout = "//button[text()='Logout']";
    
	
	
}

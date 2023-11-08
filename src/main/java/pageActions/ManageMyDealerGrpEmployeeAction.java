package pageActions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import pageObjects.ManageMyDealerGrpEmployeePO;
import utils.utilityClass;

public class ManageMyDealerGrpEmployeeAction extends ManageMyDealerGrpEmployeePO{
	
	utilityClass utils = new utilityClass();
	
	public void selectUser(String user) {
		utils.element("xpath", selectUserDropdown).click();
		 List<WebElement> list = getDriver().findElements(By.xpath(roleDropdownList));
	    for(int i=0;i<list.size();i++) {
		String text = list.get(i).getText();
		System.out.println("Progms list is--"+text);
		if(text.contains(user))
		{
			list.get(i).click();
			break;
		}
	 }
	}

	public ArrayList<String> permissionsSelected() {
		List<WebElement> permissionsList = utils.getElementsList("xpath", permissions);
		ArrayList<String> list = new ArrayList<>();
		String selectedPermission = null;
		for (int i=0;i<permissionsList.size();i++) {
			if(utils.getElementsList("xpath", checkbox).get(i).isSelected()) {
				 selectedPermission=permissionsList.get(i).getText();
				 list.add(selectedPermission);
			}
		}
		Collections.sort(list);
		System.out.println("permissions selected List--"+list);
		return list;
	}
	
	public ArrayList<String> permissionsUnselected() {
		List<WebElement> permissionsList = utils.getElementsList("xpath", permissions);
		ArrayList<String> list = new ArrayList<>();
		String unselectedPermission = null;
		for (int i=0;i<permissionsList.size();i++) {
			if(!utils.getElementsList("xpath", checkbox).get(i).isSelected()) {
				 unselectedPermission=permissionsList.get(i).getText();
				 list.add(unselectedPermission);
			}
		}
		Collections.sort(list);
		System.out.println("permissions unselected List--"+list);
		return list;
	}
	
	public ArrayList<String> AllPermissions() {
		List<WebElement> permissionsList = utils.getElementsList("xpath", permissions);
		ArrayList<String> list = new ArrayList<>();
		for (int i=0;i<permissionsList.size();i++) {
			String permission = permissionsList.get(i).getText();
			list.add(permission);
		}
		System.out.println("All permissions List--"+list);
		return list;
}
	
	public WebElement permissionCheckbox(String permissionName) {
	WebElement checkbox=driver.findElement(By.xpath("//span[text()='"+permissionName+"']/../../../../td/adl-table-cells//input/.."));
	return checkbox;
	}
	
	public WebElement permissionCheckboxStatus(String permissionName) {
		WebElement checkbox=driver.findElement(By.xpath("//span[text()='"+permissionName+"']/../../../../td/adl-table-cells//input"));
		return checkbox;
		}
	
	public void deSelectedSelectAllChkBx() {
	WebElement selectAllCheckBoxstat = utils.element("xpath", selectAllCheckBoxstatus);
	if(selectAllCheckBoxstat.isSelected()) {
		utils.element("xpath", selectAllCheckBox).click();
		}
		else {
			utils.element("xpath", selectAllCheckBox).click();
			utils.element("xpath", selectAllCheckBox).click();
		}
		Assert.assertFalse(selectAllCheckBoxstat.isSelected());
	}
	
	public void selectedSelectAllChkbx() {
	WebElement selectAllCheckBoxstat = utils.element("xpath", selectAllCheckBoxstatus);
	if(!selectAllCheckBoxstat.isSelected()) {
	utils.element("xpath", selectAllCheckBox).click();
	}
	else {
		utils.element("xpath", selectAllCheckBox).click();
		utils.element("xpath", selectAllCheckBox).click();
	}
	Assert.assertTrue(selectAllCheckBoxstat.isSelected());
	}
}



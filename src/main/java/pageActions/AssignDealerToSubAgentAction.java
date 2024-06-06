package pageActions;

import java.util.List;

import org.openqa.selenium.WebElement;

import pageObjects.AssignDealerToSubagentPO;
import utils.utilityClass;

public class AssignDealerToSubAgentAction extends AssignDealerToSubagentPO{
	utilityClass utils = new utilityClass();
	loginAction login = new loginAction();
	verticalMenuAction verticalMenu = new verticalMenuAction();
	impersonateAction impersonate = new impersonateAction ();
	PermissionsAction permissions=new PermissionsAction();
	
	public void assignDealersToSubAgent(String role,String roleId,String subAgent) throws InterruptedException {
		login.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		verticalMenu.navigatetoimpersonate();
		impersonate.impersonateUser(role, roleId);
		verticalMenu.navigatetoLeftMenu("Agency Settings", "Assign Dealers to Sub-Agents");
		selectSubAgentInSubagentDropDown(subAgent);
		utils.element("xpath",arrowForwardInassignDealerToSubagentPage).click();
		utils.wait(500);
		utils.element("xpath",addDealer).click();
		utils.waitTillElementIsClickable(selectDealerArrow);
		utils.element("xpath",selectDealerArrow).click();
		if (permissions.getSelectAllCheckBoxInPopup().isEnabled()) {
			permissions.getSelectAllCheckBoxInPopup().click();
		}
		utils.element("xpath",btnClose).click();
		if (utils.element("xpath", permissions.saveBtn).isEnabled()){
		utils.clickfield("xpath", permissions.saveBtn);
		}
		else {
			utils.clickfield("xpath", permissions.cancelBtn);	
		}
		Thread.sleep(100);
		login.logout();
		Thread.sleep(100);
	}

	public void selectSubAgentInSubagentDropDown(String dealer) throws InterruptedException {
		utils.element("xpath", inputTypeOrSelectSubAgent).sendKeys(dealer);
//		utils.waitTillElementIsVisible(selectSubagentArrow);
//		utils.element("xpath",selectSubagentArrow).click();
		List<WebElement> subagentOptionsList = utils.getElementsList("xpath", subAgentOptions);
		for(int i=0;i<subagentOptionsList.size();i++) {
			if(subagentOptionsList.get(i).getText().equalsIgnoreCase(dealer)) {
				subagentOptionsList.get(i).click();
			}
		}
		utils.wait(1000);
	}

}

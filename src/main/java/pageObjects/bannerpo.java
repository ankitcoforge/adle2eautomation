package pageObjects;

import org.openqa.selenium.By;

import utils.baseClass;

public class bannerpo extends baseClass {
	
	public String disabled = "mat-radio-button[class='mat-radio-button mat-radio-checked mat-accent'] > label > div[class='mat-radio-label-content']";
	public String banner = ".banner-container > div > span";
	public String textArea = "div.angular-editor-textarea>span";
	public String submit = "button[type='submit']";
	public String bannerTab = "div.message-tabs__tab";
	public String bannerText = "div.message-tabs__tab >h5";
	public String activeTabText = "div.tab--active > div >h5";
	public String dashboardTextArea = "div.angular-editor-textarea >div>span";
    public String dashBoardBanner = "div.banner-container > div > div >span";
	
}

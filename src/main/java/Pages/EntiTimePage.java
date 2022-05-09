package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseFolder.DriverScript;

public class EntiTimePage extends DriverScript {
	
//****************Locators**********************
	@FindBy(id="logoutLink") WebElement linklogout;
	@FindBy(xpath="//a[@class='userProfileLink username ']") WebElement loggedinUser;
	
	public EntiTimePage(){
		//initDriver();
		PageFactory.initElements(driver, this);
	}
	
	
//***************Methods*****************************
	
	public String getEnterTimePageTitle() {
		return driver.getTitle();
	}
	
}

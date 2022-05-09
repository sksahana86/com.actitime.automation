package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import BaseFolder.DriverScript;

public class LoginPage extends DriverScript{
	
	public LoginPage() {
	//initDriver();
	PageFactory.initElements(driver, this);
	}
	
//**********Locators Starts from Here**********************
	
@FindBy(id="username") WebElement tbUsername;
@FindBy(name="pwd") WebElement tbPassword;
@FindBy(xpath="//div[text()='Login ']") WebElement btnlogin;
@FindBy(xpath="//div[@class='atLogoImg']") WebElement actitimeLogo;


//*********Page Methods starts from Here ********************
	
	public String getPagetitle() {
		
		return driver.getTitle();
	}
	
	public boolean verifyActitimeLogo() {
		return actitimeLogo.isDisplayed();
	}
	
	public void enterUserName(String Username) {
		
		try {
			tbUsername.clear();
			tbUsername.sendKeys(Username);
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void enterPassword(String password) {
		try {
		tbPassword.clear();
		tbPassword.sendKeys(password);
		Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void clickLogin() {
		try {
		btnlogin.click();
		Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}

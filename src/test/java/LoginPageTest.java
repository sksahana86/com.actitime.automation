import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import BaseFolder.DriverScript;
import Pages.LoginPage;

public class LoginPageTest extends DriverScript{
	
	LoginPage lp;
	@BeforeMethod
	public void setup() {
		initDriver();
		lp=new LoginPage();
	}
	
	@AfterMethod
	public void TearDown() {
	quitBrowser();
	}
	
	@Test(priority=3)
	public void verifyActitimeTitle() throws InterruptedException {
		
		String Title=lp.getPagetitle();
		System.out.println("Title : "+Title);
		Assert.assertTrue(Title.contains("Login"));
		
		
	}
	@Test(priority=2)
	public void verifyActitimeLogo() throws InterruptedException {
		
		
		Boolean IslogoDisplayed=lp.verifyActitimeLogo();
		Assert.assertTrue(IslogoDisplayed);
		
		
	}
	@Test(priority=1, dataProvider="ActiData")
	public void testLogin(String username, String password) {
		try {
		Thread.sleep(5000);
		lp.enterUserName(username);
		lp.enterPassword(password);
		lp.clickLogin();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@DataProvider(name="ActiData")
	public Object[][] testData(){
		CommonLib.ExcelLib xl=new CommonLib.ExcelLib("./actestdata/TestDataLogin.xlsx");
		int rowCount=xl.getRowCount(0);
		Object[][] data =new Object[rowCount][2];
		for(int i=0; i<rowCount;i++) {
			data[i][0] = xl.getCellData(0, i, 0);
			data[i][1] = xl.getCellData(0, i, 1);	
		}
		return data;
		
	}
	
}

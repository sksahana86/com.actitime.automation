import org.junit.Assert;
import org.testng.annotations.Test;

import BaseFolder.DriverScript;
import Pages.EntiTimePage;
import Pages.LoginPage;

public class EnterTimePagetests extends DriverScript {
	@Test
	public void TestEnterPageTitle() {
		initDriver();
		LoginPage lp= new LoginPage();
		EntiTimePage ep=new EntiTimePage();
		lp.enterUserName("trainee");
		lp.enterPassword("trainee");
		lp.clickLogin();
		String epPageTitle=ep.getEnterTimePageTitle();
		System.out.println("***** "+epPageTitle);
		Assert.assertTrue("Enter Time Page Title", epPageTitle.contains("Enter "));
		quitBrowser();
	}
}

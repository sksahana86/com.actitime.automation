package BaseFolder;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class DriverScript {

	Properties prop;
	public static WebDriver driver;
	
	public DriverScript(){
		try {
		File fl = new File("./acconfig/config.properties");
		FileInputStream fis = new FileInputStream(fl);
		prop=new Properties();
		prop.load(fis);
		}
		catch(Exception e) {
			System.out.println("Exception Occured : "+e.getMessage());
		}
	}
	
	public void initDriver() {
		try {
		String browser=prop.getProperty("Browsertype");
		System.out.println("Browser launched : "+browser);
		
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./acbrowsers/chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "./acbrowsers/geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", "./acbrowsers/msedgedriver.exe");
			driver=new EdgeDriver();
		}
		else {
			throw new Exception("Invalid Browser type.. Please change the driver type in Cofig File");
		}
		String url=prop.getProperty("devURL");
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		Thread.sleep(5000);
		
		}
		catch (Exception e) {
			System.out.println("Exception Occured : "+e.getMessage());
		}
	}
	
	public void quitBrowser() {
		driver.quit();
	}
}

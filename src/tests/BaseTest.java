package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import utilities.CommonVariables;
import utilities.ConfigManager;
import utilities.StartDriver;

public class BaseTest {
	public static WebDriver driver;
	
	@BeforeSuite
	public void beforeSuite()
	{
		
	}
	@BeforeClass
	public void beforeClass()
	{
		try {
			ConfigManager.setProperties();
			driver = new StartDriver().startDriver(ConfigManager.getProperties().getProperty("browser"));
			driver.get(ConfigManager.getProperties().getProperty("url"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@BeforeTest
	public void beforeTest()
	{
		
	}
	
	@AfterTest
	public void afterTest()
	{
		
	}
	
	@AfterClass
	public void afterClass()
	{
		
	}
	
	@AfterSuite
	public void afterSuite()
	{
		
	}

}

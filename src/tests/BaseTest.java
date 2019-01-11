package tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import utilities.ConfigManager;
import utilities.StartDriver;

public class BaseTest {
	
	@BeforeSuite
	public void beforeSuite()
	{
		
	}
	@BeforeClass
	public void beforeClass()
	{
		try {
			ConfigManager.setProperties();
			new StartDriver().startDriver(ConfigManager.getProperties().getProperty("browser"));
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

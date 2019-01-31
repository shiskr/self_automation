package tests;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import pages.ArticlePage;
import pages.SearchPage;
import utilities.ConfigManager;
import utilities.StartDriver;

public class BaseTest {

	static Logger logger = Logger.getLogger(BaseTest.class.getName());

	public static WebDriver driver;
	SearchPage searchPage;
	ArticlePage articlePage;

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
			searchPage = new SearchPage(driver);
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
		driver.quit();
	}

	@AfterSuite
	public void afterSuite()
	{

	}

}

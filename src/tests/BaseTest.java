package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import pages.ArticlePage;
import pages.FacilityPage;
import pages.HomePage;
import pages.JoinFormPage;
import pages.LocationsPage;
import pages.LoginPage;
import pages.RegistrationBridgePage;
import pages.SearchPage;
import pages.WelcomePage;
import utilities.ConfigManager;
import utilities.StartDriver;

public class BaseTest {

	//	static Logger logger = Logger.getLogger(BaseTest.class.getName());

	ExtentReports extent;
	ExtentTest logger;
	public static WebDriver driver;
	SearchPage searchPage;
	ArticlePage articlePage;
	WelcomePage welcomePage;
	LoginPage loginPage;
	HomePage homePage;
	LocationsPage locationPage;
	FacilityPage facilityPage;
	JoinFormPage joinFormPage;
	RegistrationBridgePage registrationBridgePage;

	@BeforeSuite
	public void beforeSuite()
	{
		ConfigManager.setProperties();
	}
	@BeforeClass
	public void beforeClass()
	{
		
	}

	@BeforeTest
	public void beforeTest()
	{
		try {
			extent = new ExtentReports(System.getProperty("user.dir")+"/test-output/emailable-report.html", true);
			ConfigManager.setProperties();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@AfterTest
	public void afterTest()
	{
		driver.quit();
	}
	
	@BeforeMethod
	public void beforeMethod()
	{
		try {
			driver = new StartDriver().startDriver(ConfigManager.getProperties().getProperty("browser"));
			driver.get(ConfigManager.getProperties().getProperty("url"));
			welcomePage = new WelcomePage(driver);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@AfterMethod
	public void afterMethod()
	{
		driver.quit();
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

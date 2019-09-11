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
import org.openqa.selenium.Proxy;
import org.apache.log4j.Logger;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import net.continuumsecurity.proxy.ScanningProxy;
import pages.FacilityPage;
import pages.HomePage;
import pages.JoinFormPage;
import pages.LocationsPage;
import pages.LoginPage;
import pages.RegistrationBridgePage;
import pages.WelcomePage;
import pages.ArticlePage;
import pages.SearchPage;
import utilities.ConfigManager;
import utilities.StartDriver;
import net.continuumsecurity.proxy.Spider;
import net.continuumsecurity.proxy.ZAProxyScanner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

import java.util.ArrayList;
import java.util.List;
import org.zaproxy.clientapi.core.Alert;

public class BaseTest {

	static Logger logger = Logger.getLogger(BaseTest.class.getName());

	ExtentReports extent;
	ExtentTest extentTest;
	public static WebDriver driver;
	WelcomePage welcomePage;
	LoginPage loginPage;
	HomePage homePage;
	LocationsPage locationPage;
	FacilityPage facilityPage;
	JoinFormPage joinFormPage;
	SearchPage searchPage;
	ArticlePage articlePage;
	RegistrationBridgePage registrationBridgePage;
	private static final String ZAP_PROXYHOST = "localhost";
	private static final int ZAP_PROXYPORT = 8098;
	private static final String ZAP_APIKEY = null;
	private final static String MEDIUM = "MEDIUM";
	private final static String HIGH = "HIGH";
	public ScanningProxy zapScanner;
	private Spider zapSpider;
	private final static String[] policyNames = 
		{"directory-browsing","cross-site-scripting",
				"sql-injection","path-traversal","remote-file-inclusion",
				"server-side-include","script-active-scan-rules",
				"server-side-code-injection","external-redirect",
		"crlf-injection"};
	int currentScanID;

	private static Proxy createZapProxyConfiguration() {
		Proxy proxy = new Proxy();
		proxy.setHttpProxy(ZAP_PROXYHOST + ":" + ZAP_PROXYPORT);
		proxy.setSslProxy(ZAP_PROXYHOST + ":" + ZAP_PROXYPORT);
		return proxy;
	}


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
		zapScanner = new ZAProxyScanner(ZAP_PROXYHOST, ZAP_PROXYPORT, ZAP_APIKEY);
		// Start new session
		zapScanner.clear();
		logger.info("Started a new session: Scanner");
		// Create ZAP API client
		zapSpider=(Spider) zapScanner;
		logger.info("Created client to ZAP API");
		ConfigManager.setProperties();
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
			driver = new StartDriver().startDriver(ConfigManager.getProperties().getProperty("browser"), createZapProxyConfiguration());
			driver.get(ConfigManager.getProperties().getProperty("url"));
//			welcomePage = new WelcomePage(driver);
			searchPage = new SearchPage(driver);
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

	public List<Alert> filterAlerts(List<Alert> alerts)
	{
		List<Alert> filteredAlerts = new ArrayList<Alert>();
		for (Alert alert : alerts)
		{
			// Filtering based on Risk: High and Confidence: Not Low
			if (alert.getRisk().equals(Alert.Risk.High) && alert.getConfidence() != Alert.Confidence.Low)
				filteredAlerts.add(alert);
		}
		return filteredAlerts;
	}
	/*
	 * Method to specify the strength for the ZAP Scanner as High, Medium, or Low
	 */
	public void setAlert_AttackStrength()
	{
		for (String ZapPolicyName : policyNames)
		{
			String ids = activateZapPolicy(ZapPolicyName);
			for (String id : ids.split(",")) {
				zapScanner.setScannerAlertThreshold(id,MEDIUM);
				zapScanner.setScannerAttackStrength(id,HIGH);
			}
		}
	}

	private String activateZapPolicy(String policyName)
	{
		String scannerIds = null;
		// Compare the security policies and specify scannerIds (these scannerIds are standard)
		switch (policyName.toLowerCase()) {
		case "directory-browsing":
			scannerIds = "0";
			break;
		case "cross-site-scripting":
			scannerIds = "40012,40014,40016,40017";
			break;
		case "sql-injection":
			scannerIds = "40018";
			break;
		case "path-traversal":
			scannerIds = "6";
			break;
		case "remote-file-inclusion":
			scannerIds = "7";
			break;
		case "server-side-include":
			scannerIds = "40009";
			break;
		case "script-active-scan-rules":
			scannerIds = "50000";
			break;
		case "server-side-code-injection":
			scannerIds = "90019";
			break;
		case "remote-os-command-injection":
			scannerIds = "90020";
			break;
		case "external-redirect":
			scannerIds = "20019";
			break;
		case "crlf-injection":
			scannerIds = "40003";
			break;
		case "source-code-disclosure":
			scannerIds = "42,10045,20017";
			break;
		case "shell-shock":
			scannerIds = "10048";
			break;
		case "remote-code-execution":
			scannerIds = "20018";
			break;
		case "ldap-injection":
			scannerIds = "40015";
			break;
		case "xpath-injection":
			scannerIds = "90021";
			break;
		case "xml-external-entity":
			scannerIds = "90023";
			break;
		case "padding-oracle":
			scannerIds = "90024";
			break;
		case "el-injection":
			scannerIds = "90025";
			break;
		case "insecure-http-methods":
			scannerIds = "90028";
			break;
		case "parameter-pollution":
			scannerIds = "20014";
			break;
		default : throw new RuntimeException("No policy found for: "+policyName);
		}
		zapScanner.setEnableScanners(scannerIds, true);
		return scannerIds;
	}

	public void spiderWithZap()
	{
		logger.info("Spidering started");
		// Configure spider settings
		//        zapSpider.excludeFromSpider(WebSiteNavigation.LOGOUT_URL);
		zapSpider.setThreadCount(5);
		zapSpider.setMaxDepth(5);
		zapSpider.setPostForms(false);
		// Execute the ZAP spider
		zapSpider.spider(ConfigManager.getProperties().getProperty("url"));
		int currentSpiderID = zapSpider.getLastSpiderScanId();
		int progressPercent  = 0;
		while (progressPercent < 100) {
			progressPercent = zapSpider.getSpiderProgress(currentSpiderID);
			logger.info("Spider is " + progressPercent + "% complete.");
			try
			{
				Thread.sleep(1000);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		// Log the found URLs after spider
		for (String url : zapSpider.getSpiderResults(currentSpiderID)) {
			logger.info("Found URL after spider: "+url);
		}
		logger.info("Spidering ended");
	}
	/*
	 * Method to execute scan and log the progress
	 */
	public void scanWithZap()
	{
		logger.info("Scanning started");
		// Execute the ZAP scanner
		zapScanner.scan(ConfigManager.getProperties().getProperty("url"));
		int currentScanId = zapScanner.getLastScannerScanId();
		int progressPercent  = 0;
		while (progressPercent < 100) {
			progressPercent = zapScanner.getScanProgress(currentScanId);
			logger.info("Scan is " + progressPercent + "% complete.");
			try
			{
				Thread.sleep(1000);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		logger.info("Scanning ended");
	}
	
	public void owaspScan()
	{
		logger.info("Started spidering");
        spiderWithZap();
        logger.info("Ended spidering");
        setAlert_AttackStrength();
        zapScanner.setEnablePassiveScan(true);
        // Using ZAP Scanner
        logger.info("Started scanning");
        scanWithZap();
        List<Alert> generatedAlerts = filterAlerts(zapScanner.getAlerts());
        for (Alert alert : generatedAlerts)
        {
            logger.info("Alert: "+alert.getAlert()+" at URL: "+alert.getUrl()+" Parameter: "+alert.getParam()+" CWE ID: "+alert.getCweId());
        }
        assertThat(generatedAlerts.size(), equalTo(0));
        logger.info("Ended scanning");
	}

}

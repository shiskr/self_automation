package utilities;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StartDriver {

	static Logger logger = Logger.getLogger(StartDriver.class.getName());

	static WebDriver driver;
	static ChromeOptions chromeOptions;
	static FirefoxOptions firefoxOptions;
	static String osname = System.getProperty("os.name");

	public WebDriver startDriver(String browser)
	{
		switch(browser)
		{
		case "chrome":
			chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("disable-infobars");
			//
			//			// Hide the automation toolbar warning
			chromeOptions.addArguments("test-type");
			//			// disabling popup on browser
			chromeOptions.addArguments("disable-popup-blocking");
			//			// starting browser in maximized screen
			chromeOptions.addArguments("--start-maximized");

			// System.setProperty("webdriver.chrome.driver", chromeDriverPath);
			// using webdrivermanager there is no need to keep path of drivers
			WebDriverManager.chromedriver().setup();

			// newest process
			ChromeDriverService service = new ChromeDriverService.Builder()
					//					.usingDriverExecutable(new File(chromeDriverPath))
					.usingAnyFreePort()
					.build();
			driver = new ChromeDriver(service, chromeOptions);
			break;

		case "firefox":
			DesiredCapabilities firefoxDC = DesiredCapabilities.firefox();
			firefoxOptions = new FirefoxOptions(firefoxDC);
			firefoxDC.setCapability("acceptInsecureCerts", true); 

			WebDriverManager.firefoxdriver().setup();
			firefoxOptions.merge(firefoxDC);
			driver = new FirefoxDriver(firefoxOptions);

			break;

		case "safari":
			driver = new SafariDriver();
			break;

		default:
			System.out.println("None of the DeviceType Case Matched");
			return null;
		}
		return driver;
	}

}

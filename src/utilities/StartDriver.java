package utilities;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;

public class StartDriver {

	static WebDriver driver;
	static ChromeOptions chromeOptions;
	static FirefoxOptions firefoxOptions;
	//	DesiredCapabilities chromeDC;
	static String osname = System.getProperty("os.name");

	public WebDriver startDriver(String browser)
	{
		switch(browser)
		{
		case "chrome":
			String chromeDriverPath = "";
			DesiredCapabilities chromeDC = DesiredCapabilities.chrome();
			chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("disable-infobars");
			//
			//			// Hide the automation toolbar warning
			chromeOptions.addArguments("test-type");
			//			// disabling popup on browser
			chromeOptions.addArguments("disable-popup-blocking");
			//			// starting browser in maximized screen
			chromeOptions.addArguments("--start-maximized");
			chromeDC.setCapability("takesScreenshot", true);
			chromeDC.setCapability("handlesAlerts", true);
			chromeDC.setCapability("browserTimeout", 9000000);
			chromeDC.setCapability(ChromeOptions.CAPABILITY, chromeOptions);

			if(osname.toLowerCase().contains("mac"))
			{
				chromeDriverPath = System.getProperty("user.dir") + "/resources/chromedriver";
			}
			else if(osname.toLowerCase().contains("windows"))
			{
				chromeDriverPath = System.getProperty("user.dir") + "/resources/chromedriver.exe";
			}
			else if(osname.toLowerCase().contains("linux"))
			{
				chromeDriverPath = System.getProperty("user.dir") + "/resources/chromedriver";
			}
			System.setProperty("webdriver.chrome.driver", chromeDriverPath);

			// legacy process
			//			driver = new ChromeDriver(chromeDC);

			//			 new process
			//						ChromeDriverService service = new ChromeDriverService.Builder()
			//								.usingDriverExecutable(new File(chromeDriverPath))
			//								.usingAnyFreePort()
			//								.build();
			//						driver = new ChromeDriver(service, chromeDC);


			// newest process
			ChromeDriverService service = new ChromeDriverService.Builder()
					.usingDriverExecutable(new File(chromeDriverPath))
					.usingAnyFreePort()
					.build();
			chromeOptions.merge(chromeDC);    
			driver = new ChromeDriver(service, chromeOptions);
			System.out.println(driver);

			break;

		case "firefox":
			String firefoxDriverPath = "";
			DesiredCapabilities firefoxDC = DesiredCapabilities.firefox();
			firefoxOptions = new FirefoxOptions(firefoxDC);
			firefoxDC.setCapability("acceptInsecureCerts", true); 
			if(osname.toLowerCase().contains("mac"))
			{
				firefoxDriverPath = System.getProperty("user.dir") + "/resources/geckodriver";
			}
			else if(osname.toLowerCase().contains("windows"))
			{
				firefoxDriverPath = System.getProperty("user.dir") + "/resources/geckodriver.exe";
			}
			else if(osname.toLowerCase().contains("linux"))
			{
				firefoxDriverPath = System.getProperty("user.dir") + "/resources/geckodriver";
			}

			System.setProperty("webdriver.gecko.driver", firefoxDriverPath);
			firefoxOptions.merge(firefoxDC);
			driver = new FirefoxDriver(firefoxOptions);

			break;

		case "safari":
			driver = new SafariDriver();
			break;

		case "android":

			break;

		case "ios":

			break;

		default:
			System.out.println("None of the DeviceType Case Matched");
			return null;

		}

		return driver;


	}

}

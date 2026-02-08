package utilities;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

public class StartDriver {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	public static WebDriver startDriver(String browser) {

		switch (browser.toLowerCase()) {

			case "chrome":
				ChromeOptions chromeOptions = new ChromeOptions();
				chromeOptions.addArguments("--start-maximized");
				chromeOptions.addArguments("--disable-notifications");
				chromeOptions.addArguments("--remote-allow-origins=*");
				driver.set(new ChromeDriver(chromeOptions));
				break;

			case "firefox":
				FirefoxOptions firefoxOptions = new FirefoxOptions();
				firefoxOptions.addArguments("--width=1920");
				firefoxOptions.addArguments("--height=1080");
				driver.set(new FirefoxDriver(firefoxOptions));
				break;

			case "safari":
				SafariOptions safariOptions = new SafariOptions();
				driver.set(new SafariDriver(safariOptions));
				break;

			default:
				throw new IllegalArgumentException(
						"Invalid browser value: " + browser +
								". Supported: chrome | firefox | safari");
		}

		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		return getDriver();
	}

	public static WebDriver getDriver() {
		return driver.get();
	}

	public static void quitDriver() {
		if (driver.get() != null) {
			driver.get().quit();
			driver.remove();
		}
	}
}
package utilities;

import org.openqa.selenium.WebDriver;

public class CommonVariables {

	public static ThreadLocal<WebDriver> commonDriver = new ThreadLocal<WebDriver>();

	public static WebDriver getDriver()
	{
		return commonDriver.get();
	}

	public static void setDriver(WebDriver driver)
	{
		commonDriver.set(driver);
	}

}

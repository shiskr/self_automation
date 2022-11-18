package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class StartDriver {

    static WebDriver driver;

    public WebDriver startDriver(String browser)
    {
        switch(browser)
        {
            case "chrome":
                driver = new ChromeDriver();
                break;

            case "firefox":
                driver = new FirefoxDriver();
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

package pages;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import objectRepository.BasePage_OR;

public class BasePage extends BasePage_OR{

	static Logger logger = Logger.getLogger(BasePage.class.getName());

	public WebDriverWait implicitWait = new WebDriverWait(driver, 30);
	
	public static Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
	        .withTimeout(Duration.ofSeconds(100))
	        .pollingEvery(Duration.ofSeconds(10))
	        .ignoring(NoSuchElementException.class);
	
//	public static FluentWait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
//            .withTimeout(50, TimeUnit.SECONDS)
//            .pollingEvery(10, TimeUnit.MILLISECONDS)
//            .ignoring(NoSuchElementException.class);

	public BasePage(WebDriver driver) {
		super(driver);
	}
	
	protected static WebElement findElementByWait(WebDriver driver, final By locator) {

	    return fluentWait.until(new Function<WebDriver, WebElement>() {
	        public WebElement apply(WebDriver webDriver) {
	            return driver.findElement(locator);
	        }
	    });
	}
}

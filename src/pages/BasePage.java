package pages;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import objectRepository.BasePage_OR;

public class BasePage extends BasePage_OR{

	static Logger logger = Logger.getLogger(BasePage.class.getName());

	public WebDriverWait implicitWait = new WebDriverWait(driver, 30);
	
	public Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
	        .withTimeout(Duration.ofSeconds(50))
	        .pollingEvery(Duration.ofMillis(100))
	        .ignoring(NoSuchElementException.class);

	public BasePage(WebDriver driver) {
		super(driver);
	}
}

package pages;

import java.time.Duration;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import objectRepository.BasePage_OR;

public class BasePage extends BasePage_OR{


	protected WebDriverWait Wait = new WebDriverWait(driver, 10);

	public Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
			.withTimeout(Duration.ofSeconds(1000))
			.pollingEvery(Duration.ofSeconds(5))
			.ignoring(NoSuchElementException.class);

	public BasePage(WebDriver driver) {
		super(driver);
	}
}

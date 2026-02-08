package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import objectRepository.BasePage_OR;

import java.time.Duration;

public class BasePage extends BasePage_OR{

	protected WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

	public BasePage(WebDriver driver) {
		super(driver);
	}
}

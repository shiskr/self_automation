package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import objectRepository.BasePage_OR;

public class BasePage extends BasePage_OR{

	static Logger logger = Logger.getLogger(BasePage.class.getName());

	protected WebDriverWait wait = new WebDriverWait(driver, 30);

	public BasePage(WebDriver driver) {
		super(driver);
	}
}

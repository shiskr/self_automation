package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasePage_OR {


	public static WebDriver driver;

	public BasePage_OR(WebDriver driver) {
		BasePage_OR.driver = driver;
	}

	@FindBy(xpath="//div[@class='hidden spinner center']")
	public WebElement loader;
}

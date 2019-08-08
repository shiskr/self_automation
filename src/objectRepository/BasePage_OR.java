package objectRepository;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class BasePage_OR {

	static Logger logger = Logger.getLogger(BasePage_OR.class.getName());

	public static WebDriver driver;

	public BasePage_OR(WebDriver driver) {
		this.driver = driver;
		this.driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        this.driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	}
}

package pages;

import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import objectRepository.WelcomePage_OR;

public class WelcomePage extends WelcomePage_OR{

	public WelcomePage(WebDriver driver) throws InterruptedException {
		super(driver);
		PageFactory.initElements(driver, this);

		WebElement foo = fluentWait.until(
				new Function<WebDriver, WebElement>() {
					public WebElement apply(WebDriver driver) {
						return driver.findElement(By.xpath("//header[@class='header-desktop']//div[@id='navbarLinks']//span[contains(text(),'Locations')]"));
					}
				}
				);
		if (foo==null)
		{
			return;
		}
	}

	public LoginPage clickLogin() {
		loginButton.click();
		return new LoginPage(driver);
	}

	public LocationsPage clickLocationsLink() throws InterruptedException {
		WebElement foo = fluentWait.until(
				new Function<WebDriver, WebElement>() {
					public WebElement apply(WebDriver driver) {
						return driver.findElement(By.xpath("//header[@class='header-desktop']//div[@id='navbarLinks']//span[contains(text(),'Locations')]"));
					}
				}
				);
		foo.click();
		return new LocationsPage(driver);

	}

}

package pages;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import objectRepository.WelcomePage_OR;

public class WelcomePage extends WelcomePage_OR{

	public WelcomePage(WebDriver driver) throws InterruptedException {
		super(driver);
		PageFactory.initElements(driver, this);
		//		wait.until(ExpectedConditions.visibilityOf(locationsButton));
		//		wait.until(ExpectedConditions.elementToBeClickable(locationsButton));
		//		Thread.sleep(100);

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

	public LoginPage clickLogin()
	{
		WebElement foo = fluentWait.until(
				new Function<WebDriver, WebElement>() {
					public WebElement apply(WebDriver driver) {
						return driver.findElement(By.xpath("//header[@class='header-desktop']//nav[@class='nav-wrapper desktop']//p[@class='account-nav']"));
					}
				}
				);
		if (foo==null)
		{
			return null;
		}
		loginButton.click();
		return new LoginPage(driver);
	}

	public LocationsPage clickLocationsLink() throws InterruptedException {
//		implicitWait.until(ExpectedConditions.visibilityOf(locationsButton));

		WebElement foo = fluentWait.until(
				new Function<WebDriver, WebElement>() {
					public WebElement apply(WebDriver driver) {
						return driver.findElement(By.xpath("//header[@class='header-desktop']//div[@id='navbarLinks']//span[contains(text(),'Locations')]"));
					}
				}
				);
		if (foo==null)
		{
			return null;
		}
		foo.click();
		locationsButton.click();
		return new LocationsPage(driver);

	}

}

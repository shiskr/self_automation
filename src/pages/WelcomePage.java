package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import objectRepository.WelcomePage_OR;

public class WelcomePage extends WelcomePage_OR{

	public WelcomePage(WebDriver driver) throws InterruptedException {
		super(driver);
		PageFactory.initElements(driver, this);
		wait.until(ExpectedConditions.visibilityOf(locationsButton));
		wait.until(ExpectedConditions.elementToBeClickable(locationsButton));
		Thread.sleep(100);
	}

	public LoginPage clickLogin()
	{
		loginButton.click();
		return new LoginPage(driver);
	}

	//	public LoginPage clickLogin(String name)
	//	{
	//		loginButton.click();
	//		return new LoginPage(driver);
	//	}

	public LocationsPage clickLocationsLink() throws InterruptedException {
		locationsButton.click();
		return new LocationsPage(driver);

	}

}

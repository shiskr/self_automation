package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import objectRepository.HomePage_OR;

public class HomePage extends HomePage_OR{

	public HomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		wait.until(ExpectedConditions.visibilityOf(profilePicture));
	}
	
	public boolean verifyLogoutLink()
	{
//		if(logoutButton.isDisplayed())
//		{
//			return true;
//		}
//		return false;
		
		return logoutButton.isDisplayed();
	}
}

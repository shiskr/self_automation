package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pages.BasePage;

public class WelcomePage_OR extends BasePage{

	public WelcomePage_OR(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//header[@class='header-desktop']//nav[@class='nav-wrapper desktop']//div[@class='nav-logo']")
	public WebElement logo;
	
	@FindBy(xpath="//header[@class='header-desktop']//nav[@class='nav-wrapper desktop']//p[@class='account-nav']")
	public WebElement loginButton;
	
	@FindBy(xpath="//header[@class='header-desktop']//div[@id='navbarLinks']//span[contains(text(),'Join now')]")
	public WebElement joinNowButton;
	
	@FindBy(xpath="//header[@class='header-desktop']//div[@id='navbarLinks']//span[contains(text(),'Locations')]")
	public WebElement locationsButton;

}

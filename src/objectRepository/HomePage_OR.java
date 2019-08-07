package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pages.BasePage;

public class HomePage_OR extends BasePage{
	
	public HomePage_OR(WebDriver driver) {
		super(driver);
	}

	@FindBy(id="ycuwerbcetwy")
	public WebElement randomElement;
	
	@FindBy(xpath="//img[@class='img-responsive rounded-circle ']")
	public WebElement profilePicture;
	
	@FindBy(xpath="//i[@class='icon-logout text-red-light']")
	public WebElement logoutButton;

}

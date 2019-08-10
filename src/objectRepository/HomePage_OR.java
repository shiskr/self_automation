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
	
	@FindBy(xpath="//button[@class='btn btn-link']")
	public WebElement logoutButton;
	
	@FindBy(xpath="//div[@class='modal fade welcome-popup show']//button[contains(text(),'Skip')]")
	public WebElement skipBtn;
	
	@FindBy(xpath="//span[contains(text(),'Member Info')]")
	public WebElement memberInfoTab;
	
	@FindBy(xpath="//input[@id='currentPassword']")
	public WebElement currentPasswordEl;
	
	@FindBy(xpath="//input[@id='newPassword']")
	public WebElement newPasswordEl;
	
	@FindBy(xpath="//input[@id='confirmPassword']")
	public WebElement confirmPasswordEl;
	
	@FindBy(xpath="//button[contains(text(),'Change Password')]")
	public WebElement changePasswordEl;
	
	@FindBy(xpath="//h3[contains(text(),'Success')]")
	public WebElement successEl;
	
	
	
	
	
	
}

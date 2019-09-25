package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pages.BasePage;

public class LoginPage_OR extends BasePage{

	public LoginPage_OR(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//div[@class='login-inner']//button")
	public WebElement loginButton;
	
	@FindBy(id="email")
	public WebElement emailTextBox;
	
	@FindBy(id="password")
	public WebElement passwordTextBox;

}

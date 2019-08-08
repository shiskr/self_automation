package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pages.BasePage;

public class RegistrationBridgePage_OR extends BasePage{

	public RegistrationBridgePage_OR(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//b[contains(text(),'WELCOME')]")
	public WebElement welcomeEl;
	
	@FindBy(id="email")
	public WebElement emailFieldEl;

}

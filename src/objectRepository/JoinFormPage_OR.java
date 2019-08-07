package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pages.BasePage;

public class JoinFormPage_OR extends BasePage{

	public JoinFormPage_OR(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//input[@id='mat-input-0']")
	public WebElement firstNameEl;
	
	@FindBy(xpath="//input[@id='mat-input-1']")
	public WebElement lastNameEl;

}

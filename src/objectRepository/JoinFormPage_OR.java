package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pages.BasePage;

public class JoinFormPage_OR extends BasePage{

	public JoinFormPage_OR(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//h2[contains(text(), 'JOIN')]")
	public WebElement JoinEl;

	@FindBy(xpath="//input[@id='mat-input-0']")
	public WebElement firstNameEl;

	@FindBy(xpath="//input[@id='mat-input-1']")
	public WebElement lastNameEl;

	@FindBy(xpath="//input[@id='mat-input-2']")
	public WebElement addressEl;

	@FindBy(xpath="//input[@id='mat-input-3']")
	public WebElement apartmentEl;

	@FindBy(xpath="//input[@id='mat-input-4']")
	public WebElement cityEl;

	@FindBy(xpath="//mat-select[@id='state']")
	public WebElement stateEl;

	@FindBy(xpath="//input[@id='mat-input-5']")
	public WebElement zipEl;

	@FindBy(xpath="//input[@id='mat-input-6']")
	public WebElement phoneEl;

	@FindBy(xpath="//input[@id='mat-input-7']")
	public WebElement emailEl;

	@FindBy(xpath="//input[@id='mat-input-8']")
	public WebElement confirmEmailEl;

	@FindBy(xpath="//input[@id='mat-input-9']")
	public WebElement dateOfBirthEl;

	@FindBy(xpath="//mat-select[@id='mat-select-1']")
	public WebElement genderEl;

	@FindBy(xpath="//input[@id='mat-checkbox-1']")
	public WebElement agree1El;

	@FindBy(xpath="//span[contains(text(),'Next')]")
	public WebElement next1El;

	@FindBy(xpath="//input[@id='mat-input-14']")
	public WebElement nameOnCardEl;

	@FindBy(xpath="//input[@id='mat-input-15']")
	public WebElement cardNumberEl;

	@FindBy(xpath="//mat-select[@id='mat-select-3']")
	public WebElement monthEl;

	@FindBy(xpath="//mat-select[@id='mat-select-4']")
	public WebElement yearEl;

	@FindBy(xpath="//input[@id='mat-input-16']")
	public WebElement securityCodeEl;

	@FindBy(xpath="//input[@id='mat-checkbox-2-input']")
	public WebElement agree2El;
	
	@FindBy(xpath="//span[contains(text(),'Purchase')]")
	public WebElement purchaseEl;
	

	


}

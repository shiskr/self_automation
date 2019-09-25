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
	
	@FindBy(xpath="//button[contains(text(),'got it')]")
	public WebElement gotIt;
	
	@FindBy(xpath="//div[@class='col-lg-6 col-md-12 col-sm-12 ml-auto d-none d-md-block']//button[contains(text(),'Edit Info')]")
	public WebElement editInfoBtn;
	
	@FindBy(id="basicAddressStreetLine1")
	public WebElement streetAddressTextBox;
	
	@FindBy(id="basicAddressStreetLine2")
	public WebElement streetAddressApptTextBox2;
	
	@FindBy(id="basicAddressCity")
	public WebElement streetAddressCityTextBox;
	
	@FindBy(id="basicAddressState")
	public WebElement streetAddressState;
	
	@FindBy(id="basicAddressZip")
	public WebElement streetAddressZipTextBox;
	
	@FindBy(id="basicPhone")
	public WebElement phoneTextBox;
	
	@FindBy(id="basic-gender")
	public WebElement genderEl;
	
	@FindBy(id="basicDateOfBirth")
	public WebElement dobEl;
	
	@FindBy(xpath="//div[@class='col-lg-6 col-md-12 col-sm-12 ml-auto d-none d-md-block']//button[contains(text(),'Save Changes')]")
	public WebElement saveChangesBtn;
	
	@FindBy(id="toastLabel")
	public WebElement thankYouLabel;
	
}

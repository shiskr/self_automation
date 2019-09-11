package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import objectRepository.HomePage_OR;

public class HomePage extends HomePage_OR{

	public HomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		wait.until(ExpectedConditions.visibilityOf(profilePicture));
	}
	
	public LoginPage clickLogoutLink()
	{
		wait.until(ExpectedConditions.elementToBeClickable(logoutButton));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", logoutButton);
		return new LoginPage(driver);
	}
	
	public HomePage clickSkipBtn()
	{
		wait.until(ExpectedConditions.elementToBeClickable(skipBtn));
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", skipBtn);
		
		return new HomePage(driver);
	}

	public void clickMemberInfoTab() {
		wait.until(ExpectedConditions.elementToBeClickable(memberInfoTab));
		memberInfoTab.click();
	}

	public void enterCurrentPassword(String password) {
		wait.until(ExpectedConditions.elementToBeClickable(currentPasswordEl));
		currentPasswordEl.sendKeys(password);
	}

	public void enterNewPasswords(String password) {
		newPasswordEl.sendKeys(password);
		confirmPasswordEl.sendKeys(password);
	}

	public void clickChangePassword() {
		changePasswordEl.click();
	}

	public void verifySuccess() {
		wait.until(ExpectedConditions.visibilityOf(successEl));
		Assert.assertTrue(successEl.isDisplayed());
	}

	public void clickGotIt() {
		wait.until(ExpectedConditions.visibilityOf(gotIt));
		gotIt.click();
	}

	public void changeAddress(String newaddress) {
		streetAddressTextBox.clear();
		streetAddressTextBox.sendKeys(newaddress);
	}

	public void changeApartment(String newapartment) {
		streetAddressApptTextBox2.clear();
		streetAddressApptTextBox2.sendKeys(newapartment);
	}

	public void changeCity(String newcity) {
		streetAddressCityTextBox.clear();
		streetAddressCityTextBox.sendKeys(newcity);
	}

	public void changeState(String newstate) {
		streetAddressState.sendKeys(newstate);
	}

	public void changeZip(String newzip) {
		streetAddressZipTextBox.clear();
		streetAddressZipTextBox.sendKeys(newzip);
	}

	public void changePhone(String newphone) {
		phoneTextBox.clear();
		phoneTextBox.sendKeys(newphone);
	}

	public void changeGender(String newgender) {
		genderEl.sendKeys(newgender);
	}

	public void clickEditInfo() {
		wait.until(ExpectedConditions.visibilityOf(editInfoBtn));
		editInfoBtn.click();
	}

	public void clickSaveChanges() {
		saveChangesBtn.click();
	}

	public void verifyThankYou() {
		wait.until(ExpectedConditions.visibilityOf(thankYouLabel));
		Assert.assertTrue(thankYouLabel.isDisplayed());;
	}
}

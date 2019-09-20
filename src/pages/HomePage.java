package pages;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

import objectRepository.HomePage_OR;

public class HomePage extends HomePage_OR{

	public HomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
//		wait.until(ExpectedConditions.visibilityOf(profilePicture));
		

		    WebElement foo = fluentWait.until(
		        new Function<WebDriver, WebElement>() {
		            public WebElement apply(WebDriver driver) {
		                return driver.findElement(By.xpath("//img[@class='img-responsive rounded-circle ']"));
		            }
		        }
		    );
		    if (foo==null)
		    {
		    	return;
		    }
	}

	public LoginPage clickLogoutLink()
	{
		implicitWait.until(ExpectedConditions.elementToBeClickable(logoutButton));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", logoutButton);
		return new LoginPage(driver);
	}

	public HomePage clickSkipBtn()
	{
		implicitWait.until(ExpectedConditions.elementToBeClickable(skipBtn));

		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", skipBtn);

		return new HomePage(driver);
	}

	public HomePage clickMemberInfoTab() {
		implicitWait.until(ExpectedConditions.elementToBeClickable(memberInfoTab));
		memberInfoTab.click();
		return new HomePage(driver);
	}

	public void enterCurrentPassword(String password) {
		implicitWait.until(ExpectedConditions.elementToBeClickable(currentPasswordEl));
		currentPasswordEl.sendKeys(password);
	}

	public void enterNewPasswords(String password) {
		newPasswordEl.sendKeys(password);
		confirmPasswordEl.sendKeys(password);
	}

	public HomePage clickChangePassword() {
		changePasswordEl.click();
		return new HomePage(driver);
	}

	public void verifySuccess() {
		implicitWait.until(ExpectedConditions.visibilityOf(successEl));
		Assert.assertTrue(successEl.isDisplayed());
	}

	public HomePage clickGotIt() {
		implicitWait.until(ExpectedConditions.visibilityOf(gotIt));
		gotIt.click();
		return new HomePage(driver);
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

	public HomePage clickEditInfo() {
		implicitWait.until(ExpectedConditions.visibilityOf(editInfoBtn));
		editInfoBtn.click();
		return new HomePage(driver);
	}

	public void clickSaveChanges() {
		saveChangesBtn.click();
	}

	public void verifyThankYou() {
		implicitWait.until(ExpectedConditions.visibilityOf(thankYouLabel));
		Assert.assertTrue(thankYouLabel.isDisplayed());
	}
}

package pages;

import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import objectRepository.HomePage_OR;

public class HomePage extends HomePage_OR{

	public HomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);

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
		Wait.until(ExpectedConditions.elementToBeClickable(logoutButton));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", logoutButton);
		return new LoginPage(driver);
	}

	public HomePage clickSkipBtn()
	{
		Wait.until(ExpectedConditions.invisibilityOf(loader));
		Wait.until(ExpectedConditions.elementToBeClickable(skipBtn));

		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", skipBtn);

		return new HomePage(driver);
	}

	public HomePage clickMemberInfoTab() {
		WebElement foo = fluentWait.until(
				new Function<WebDriver, WebElement>() {
					public WebElement apply(WebDriver driver) {
						return driver.findElement(By.xpath("//span[contains(text(),'Member Info')]"));
					}
				}
				);

		foo.click();
		return new HomePage(driver);
	}

	public void enterCurrentPassword(String password) {
		Wait.until(ExpectedConditions.invisibilityOf(loader));
		Wait.until(ExpectedConditions.elementToBeClickable(currentPasswordEl));
		currentPasswordEl.sendKeys(password);
	}

	public void enterNewPasswords(String password) {
		newPasswordEl.sendKeys(password);
		confirmPasswordEl.sendKeys(password);
	}

	public HomePage clickChangePassword() {
		Wait.until(ExpectedConditions.visibilityOf(changePasswordEl));
		Wait.until(ExpectedConditions.invisibilityOf(loader));
		changePasswordEl.click();
		return new HomePage(driver);
	}

	public void verifySuccess() {
		Wait.until(ExpectedConditions.visibilityOf(successEl));
		Assert.assertTrue(successEl.isDisplayed());
	}

	public HomePage clickGotIt() {
		Wait.until(ExpectedConditions.visibilityOf(gotIt));
		gotIt.click();
		return new HomePage(driver);
	}

	public void changeAddress(String newaddress) {
		Wait.until(ExpectedConditions.invisibilityOf(loader));
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
		Wait.until(ExpectedConditions.visibilityOf(editInfoBtn));
		editInfoBtn.click();
		return new HomePage(driver);
	}

	public HomePage clickSaveChanges() {
		Wait.until(ExpectedConditions.invisibilityOf(loader));
		Wait.until(ExpectedConditions.elementToBeClickable(saveChangesBtn));
		saveChangesBtn.click();
		return new HomePage(driver);
	}

	public void verifyThankYou() {
		Wait.until(ExpectedConditions.visibilityOf(thankYouLabel));
		Assert.assertTrue(thankYouLabel.isDisplayed());
	}
}

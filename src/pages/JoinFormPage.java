package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import objectRepository.JoinFormPage_OR;
import utilities.ConfigManager;

public class JoinFormPage extends JoinFormPage_OR{

	public JoinFormPage(WebDriver driver) throws InterruptedException {
		super(driver);
		PageFactory.initElements(driver, this);
		Thread.sleep(100);
		wait.until(ExpectedConditions.elementToBeClickable(next1El));
		wait.until(ExpectedConditions.visibilityOf(firstNameEl));
	}

	public void enterMemberDetails() {
		enterFirstName(ConfigManager.getProperties().getProperty("firstName"));
		enterLastName(ConfigManager.getProperties().getProperty("lastName"));
		enterAddress(ConfigManager.getProperties().getProperty("address"));
		enterAppt(ConfigManager.getProperties().getProperty("apartment"));
		enterCity(ConfigManager.getProperties().getProperty("city"));
		selectState("NY");
		enterZip(ConfigManager.getProperties().getProperty("zip"));
		enterPhone(ConfigManager.getProperties().getProperty("phone"));
		enterEmail(ConfigManager.getProperties().getProperty("email"));
		enterConfirmEmail(ConfigManager.getProperties().getProperty("email"));
		enterDOB(ConfigManager.getProperties().getProperty("dateofbirth"));
		selectGender(ConfigManager.getProperties().getProperty("gender"));
		wait.until(ExpectedConditions.elementToBeClickable(next1El));
		clickNext1();
		clickNext1();
	}

	private void clickNext1() {
		next1El.click();
	}

	private void clickCheckBox() {
		agree1El.click();
	}

	private void selectGender(String gender) {
		genderEl.sendKeys(gender);
	}

	private void enterDOB(String DOB) {
		dateOfBirthEl.sendKeys(DOB);
	}

	private void enterEmail(String email) {
		emailEl.sendKeys(email);
	}

	private void enterPhone(String phone) {
		phoneEl.sendKeys(phone);
	}

	private void enterConfirmEmail(String email) {
		confirmEmailEl.sendKeys(email);
	}

	private void selectState(String state) {
		stateEl.sendKeys(state);
	}

	private void enterZip(String zip) {
		zipEl.sendKeys(zip);
	}

	private void enterAppt(String apartment) {
		apartmentEl.sendKeys(apartment);
	}

	private void enterCity(String city) {
		cityEl.sendKeys(city);
	}

	private void enterLastName(String lastName) {
		lastNameEl.sendKeys(lastName);
	}

	private void enterAddress(String address) {
		addressEl.sendKeys(address);
	}

	private void enterFirstName(String firstName) {
		firstNameEl.sendKeys(firstName);		
	}

	public RegistrationBridgePage enterMemberPaymentDetails() throws InterruptedException {
		nameOnCardEl.sendKeys(ConfigManager.getProperties().getProperty("nameoncard"));
		cardNumberEl.sendKeys(ConfigManager.getProperties().getProperty("cardnumber"));
		monthEl.sendKeys(ConfigManager.getProperties().getProperty("month"));
		yearEl.sendKeys(ConfigManager.getProperties().getProperty("year"));
		securityCodeEl.sendKeys(ConfigManager.getProperties().getProperty("securitycode"));
//		wait.until(ExpectedConditions.elementToBeClickable(agree2El));
		clickIagree(agree2El);
		purchaseEl.click();
		return new RegistrationBridgePage(driver);
	}

	private void clickIagree(WebElement agree2El) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("document.getElementById('mat-checkbox-2-input').click();");
	}

}

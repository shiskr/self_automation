package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import objectRepository.LoginPage_OR;

public class LoginPage extends LoginPage_OR{

	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		wait.until(ExpectedConditions.visibilityOf(loginButton));
	}

	public void enterEmail(String email) {
		emailTextBox.sendKeys(email);
	}

	public void enterPassword(String password) {
		passwordTextBox.sendKeys(password);
	}

	public HomePage clickLogin() {
		loginButton.click();
		return new HomePage(driver);
	}

}

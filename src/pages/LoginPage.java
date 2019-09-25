package pages;

import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import objectRepository.LoginPage_OR;

public class LoginPage extends LoginPage_OR{

	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);

		WebElement foo = fluentWait.until(
				new Function<WebDriver, WebElement>() {
					public WebElement apply(WebDriver driver) {
						return driver.findElement(By.xpath("//div[@class='login-inner']//button"));
					}
				}
				);
		if (foo==null)
		{
			return;
		}
	}

	public void enterEmail(String email) {
		emailTextBox.sendKeys(email);
		emailTextBox.click();
	}

	public void enterPassword(String password) {
		passwordTextBox.sendKeys(password);
	}

	public HomePage clickLogin() {
		loginButton.click();
		return new HomePage(driver);
	}

}

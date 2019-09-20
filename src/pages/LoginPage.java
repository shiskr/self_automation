package pages;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import objectRepository.LoginPage_OR;

public class LoginPage extends LoginPage_OR{
	public static LoginPage loginPage;

	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
//		wait.until(ExpectedConditions.visibilityOf(loginButton));
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
		        .withTimeout(Duration.ofSeconds(30))
		        .pollingEvery(Duration.ofMillis(100))
		        .ignoring(NoSuchElementException.class);

		    WebElement foo = wait.until(
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
	}

	public void enterPassword(String password) {
		passwordTextBox.sendKeys(password);
	}

	public HomePage clickLogin() {
		loginButton.click();
		return new HomePage(driver);
	}

}

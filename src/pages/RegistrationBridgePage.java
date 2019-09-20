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
import org.testng.Assert;

import objectRepository.RegistrationBridgePage_OR;
import utilities.ConfigManager;

public class RegistrationBridgePage extends RegistrationBridgePage_OR{

	public RegistrationBridgePage(WebDriver driver) throws InterruptedException {
		super(driver);
		PageFactory.initElements(driver, this);
//		Thread.sleep(10000);
//		wait.until(ExpectedConditions.visibilityOf(welcomeEl));
		

		    WebElement foo = fluentWait.until(
		        new Function<WebDriver, WebElement>() {
		            public WebElement apply(WebDriver driver) {
		                return driver.findElement(By.xpath("//b[contains(text(),'WELCOME')]"));
		            }
		        }
		    );
		    if (foo==null)
		    {
		    	return;
		    }
	}

	public void verifyEmail() {
		String email = driver.findElement(By.cssSelector("#email")).getAttribute("value");
		Assert.assertTrue(email.equals(ConfigManager.getProperties().getProperty("email")));
	}

	public void enterPasswords() {
		password.sendKeys(ConfigManager.getProperties().getProperty("newPassword"));
		confirmPassword.sendKeys(ConfigManager.getProperties().getProperty("newPassword"));
	}

	public HomePage clickCreateAccount() {
		createAccountBtn.click();
		return new HomePage(driver);
	}

}

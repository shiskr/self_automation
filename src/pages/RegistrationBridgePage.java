package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import objectRepository.RegistrationBridgePage_OR;
import utilities.ConfigManager;

public class RegistrationBridgePage extends RegistrationBridgePage_OR{

	public RegistrationBridgePage(WebDriver driver) throws InterruptedException {
		super(driver);
		PageFactory.initElements(driver, this);
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(welcomeEl));
	}

	public void verifyEmail() {
		String email = driver.findElement(By.cssSelector("#email")).getAttribute("value");
		Assert.assertTrue(email.equals(ConfigManager.getProperties().getProperty("email")));
	}

	public void enterPasswords(String property) {
		
	}

}

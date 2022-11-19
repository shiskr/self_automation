package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class WelcomePage_OR extends BasePage{
	protected static WebDriver driver;
	public WelcomePage_OR(WebDriver driver) {
		super(driver);
		this.driver = driver;
		// TODO Auto-generated constructor stub
	}
	public WebElement searchBtn = driver.findElement(By.id("search_button_homepage"));
	public WebElement searchField = driver.findElement(By.id("search_form_input_homepage"));

}

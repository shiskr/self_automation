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

import objectRepository.FacilityPage_OR;

public class FacilityPage extends FacilityPage_OR{

	public FacilityPage(WebDriver driver) throws InterruptedException {
		super(driver);
		PageFactory.initElements(driver, this);
		//		Thread.sleep(10000);
		//		wait.until(ExpectedConditions.visibilityOf(headerTitle));



		WebElement foo = fluentWait.until(
				new Function<WebDriver, WebElement>() {
					public WebElement apply(WebDriver driver) {
						return driver.findElement(By.xpath("//div[@class='intro__header']//h1[contains(text(),'Blink 125th')]"));
					}
				}
				);
		if (foo==null)
		{
			return;
		}
	}

	public JoinFormPage clickGreyClickHere() throws InterruptedException {
		greyClickHere.click();
		return new JoinFormPage(driver);
	}

	public JoinFormPage clickBlueClickHere() throws InterruptedException {


		WebElement foo = fluentWait.until(
				new Function<WebDriver, WebElement>() {
					public WebElement apply(WebDriver driver) {
						return driver.findElement(By.xpath("//p[contains(text(),'Blue')]/ancestor::div[@class='club-plan-header']/following-sibling::div[@class='club-plan-inner']//ins[contains(text(),'Click Here')]"));
					}
				}
				);
		if (foo==null)
		{
			return null;
		}

		foo.click();
		return new JoinFormPage(driver);
	}

}

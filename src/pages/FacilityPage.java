package pages;

import java.util.function.Function;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import objectRepository.FacilityPage_OR;

public class FacilityPage extends FacilityPage_OR{

	static Logger logger = Logger.getLogger(FacilityPage.class.getName());

	public FacilityPage(WebDriver driver) throws InterruptedException {
		super(driver);
		PageFactory.initElements(driver, this);
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
		foo.click();
		return new JoinFormPage(driver);
	}

}

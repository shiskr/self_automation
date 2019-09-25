package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import objectRepository.Locations_OR;

import java.util.function.Function;

public class LocationsPage extends Locations_OR{

	public LocationsPage(WebDriver driver) throws InterruptedException {
		super(driver);
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
		WebElement foo = fluentWait.until(
				new Function<WebDriver, WebElement>() {
					public WebElement apply(WebDriver driver) {
						return driver.findElement(By.xpath("//a[@class='facility area__item']//h3[contains(text(),'Blink 125th')]"));
					}
				}
		);
		if (foo == null) {

			return;
		}

	}


	public FacilityPage clickFacility() throws InterruptedException {
		Wait.until(ExpectedConditions.invisibilityOf(loader));
		WebElement foo = fluentWait.until(
				new Function<WebDriver, WebElement>() {
					public WebElement apply(WebDriver driver) {
						return driver.findElement(By.xpath("//a[@class='facility area__item']//h3[contains(text(),'Blink 125th')]"));
					}
				}
		);

		foo.click();
		return new FacilityPage(driver);
	}

	public void getFacilityNames() {
		for(WebElement facility:facilities)
		{
			System.out.println(facility.getText());
		}

	}

}

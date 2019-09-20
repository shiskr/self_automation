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

import objectRepository.Locations_OR;

public class LocationsPage extends Locations_OR{

	public LocationsPage(WebDriver driver) throws InterruptedException {
		super(driver);
		PageFactory.initElements(driver, this);
		Thread.sleep(10000);
//		wait.until(ExpectedConditions.visibilityOf(headerTitle));
		
		    WebElement foo = fluentWait.until(
		        new Function<WebDriver, WebElement>() {
		            public WebElement apply(WebDriver driver) {
		                return driver.findElement(By.xpath("//h3[contains(text(),'STEP 1')]"));
		            }
		        }
		    );
		    if (foo==null)
		    {
		    	return;
		    }
	}

	public FacilityPage clickFacility() throws InterruptedException {
		facility125.click();
		return new FacilityPage(driver);
	}

	public void getFacilityNames() {
		for(WebElement facility:facilities)
		{
			System.out.println(facility.getText());
		}
		
	}

}

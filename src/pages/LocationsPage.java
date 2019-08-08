package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import objectRepository.Locations_OR;

public class LocationsPage extends Locations_OR{

	public LocationsPage(WebDriver driver) throws InterruptedException {
		super(driver);
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
		Thread.sleep(10000);
		wait.until(ExpectedConditions.visibilityOf(headerTitle));
	}

	public FacilityPage clickFacility() throws InterruptedException {
		facility125.click();
		return new FacilityPage(driver);
	}

}

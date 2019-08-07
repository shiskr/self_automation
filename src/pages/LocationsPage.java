package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import objectRepository.Locations_OR;

public class LocationsPage extends Locations_OR{

	public LocationsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
		wait.until(ExpectedConditions.visibilityOf(headerTitle));
	}

	public FacilityPage clickFacility() {
		facility125.click();
		return new FacilityPage(driver);
	}

}

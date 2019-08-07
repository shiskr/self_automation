package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import objectRepository.FacilityPage_OR;

public class FacilityPage extends FacilityPage_OR{

	public FacilityPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		wait.until(ExpectedConditions.visibilityOf(headerTitle));
	}

	public JoinFormPage clickGreyClickHere() {
		greyClickHere.click();
		return new JoinFormPage(driver);
	}
	
	
}

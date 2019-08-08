package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import objectRepository.FacilityPage_OR;

public class FacilityPage extends FacilityPage_OR{

	public FacilityPage(WebDriver driver) throws InterruptedException {
		super(driver);
		PageFactory.initElements(driver, this);
		Thread.sleep(10000);
		wait.until(ExpectedConditions.visibilityOf(headerTitle));
	}

	public JoinFormPage clickGreyClickHere() throws InterruptedException {
		greyClickHere.click();
		return new JoinFormPage(driver);
	}
	
	
}

package pages;

import org.openqa.selenium.WebDriver;

import objectRepository.JoinFormPage_OR;
import utilities.ConfigManager;

public class JoinFormPage extends JoinFormPage_OR{

	public JoinFormPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void enterMemberDetails() {
		enterFirstName(ConfigManager.getProperties().getProperty("firstName"));
		enterLastName(ConfigManager.getProperties().getProperty("lastName"));
		enterAddress(ConfigManager.getProperties().getProperty("address"));
		enterAppt(ConfigManager.getProperties().getProperty("apartment"));
		enterCity(ConfigManager.getProperties().getProperty("city"));
		selectState("NY");
		enterZip(10001);
		enterPhone();
		enterEmail(ConfigManager.getProperties().getProperty("email"));
		enterConfirmEmail(ConfigManager.getProperties().getProperty("email"));
		enterDOB("08/07/2001");
		selectGender(1);
	}

	private void selectGender(int i) {
		
	}

	private void enterDOB(String string) {
		
	}

	private void enterEmail(String string) {
		
	}

	private void enterPhone() {
		
	}

	private void enterConfirmEmail(String string) {
		
	}

	private void selectState(String string) {
		
	}

	private void enterZip(int i) {
		
	}

	private void enterAppt(String string) {
		
	}

	private void enterCity(String string) {
		
	}

	private void enterLastName(String lastName) {
		lastNameEl.sendKeys(lastName);
	}

	private void enterAddress(String string) {
		
	}

	private void enterFirstName(String firstName) {
		firstNameEl.sendKeys(firstName);		
	}

}

package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import objectRepository.WelcomePage_OR;

public class WelcomePage extends WelcomePage_OR {

	static Logger logger = Logger.getLogger(WelcomePage.class.getName());

	public WelcomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);

		// this loop is used if the searchField is not visible, else it reloads the page
		for (int i=0; i < 3; i++) {
			if(wait.until(ExpectedConditions.visibilityOf(searchBtn)) != null)
			{
				if (searchField.isDisplayed()) {
					break;
				}
				else
				{
					driver.navigate().refresh();
				}
			}
		}
	}

	public void clickSearch()
	{
		logger.info("Clicking on Search Button");
		searchBtn.click();
	}

	public  void enterTextSearchField(String keyword)
	{
		logger.info("Sending text to Search Field" + keyword);
		searchField.clear();
		searchField.sendKeys(keyword);
	}

	public void hitSearch(String keyword)
	{
		logger.info("Sending text to Search Field" + keyword);
		searchField.clear();
		searchField.sendKeys(keyword);
		searchBtn.click();
	}

}

package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import objectRepository.SearchPage_OR;

public class SearchPage extends SearchPage_OR{

	static Logger logger = Logger.getLogger(SearchPage.class.getName());

	public SearchPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);

		// this loop is used if the searchField is not visible, else it reloads the page
		for (int i=0; i < 3; i++) {
			if(wait.until(ExpectedConditions.visibilityOf(adCloseIcon)) != null)
			{
				if(adCloseIcon.isDisplayed())
				{
					adCloseIcon.click();
				}
			}
		}
		for (int i=0; i < 3; i++) {
			if(wait.until(ExpectedConditions.visibilityOf(searchField)) != null)
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
		searchField.clear();
		searchField.sendKeys(keyword);
		searchBtn.click();
	}

	public boolean verifyNoResults() {
		logger.info("Verifying if No Results Label is displayed");
		wait.until(ExpectedConditions.visibilityOf(noSearchLabel));
		return noSearchLabel.isDisplayed();
	}

	public boolean verifyAutosuggest()
	{
		logger.info("Verifying number of Autosuggest options displayed");
		wait.until(ExpectedConditions.visibilityOfAllElements(autoSuggestList));
		return (autoSuggestList.size()==5);
	}

	public boolean verifySearchResults()
	{
		logger.info("Verifying Search Results");
		wait.until(ExpectedConditions.visibilityOfAllElements(searchResult));
		return (searchResult.size()>0);
	}

	public ArticlePage clickAutoSuggest(Integer index)
	{
		wait.until(ExpectedConditions.visibilityOfAllElements(autoSuggestList));
		autoSuggestList.get(0).click();
		return new ArticlePage(driver);
	}

	public ArticlePage clickSearchResult(Integer index)
	{
		wait.until(ExpectedConditions.visibilityOfAllElements(searchResult));
		searchResult.get(1).click();
		return new ArticlePage(driver);
	}
}

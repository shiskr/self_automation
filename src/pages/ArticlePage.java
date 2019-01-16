package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import objectRepository.ArticlePage_OR;

public class ArticlePage extends ArticlePage_OR{

	static Logger logger = Logger.getLogger(SearchPage.class.getName());

	public ArticlePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		wait.until(ExpectedConditions.visibilityOf(articleTitle));
	}

	public SearchPage navigateBack()
	{
		driver.navigate().back();
		return new SearchPage(driver);
	}

}

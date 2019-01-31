package objectRepository;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pages.BasePage;

public class ArticlePage_OR extends BasePage{
	
	static Logger logger = Logger.getLogger(ArticlePage_OR.class.getName());

	public ArticlePage_OR(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath="//div[@class]/preceding-sibling::h1[@class][not(@title)]")
	public WebElement articleTitle;

}

package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pages.BasePage;

public class ArticlePage_OR extends BasePage{

	public ArticlePage_OR(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath="//div[@class]/preceding-sibling::h1[@class][not(@title)]")
	public WebElement articleTitle;

}

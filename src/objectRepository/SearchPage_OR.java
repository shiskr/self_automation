package objectRepository;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pages.BasePage;

public class SearchPage_OR extends BasePage{

	static Logger logger = Logger.getLogger(SearchPage_OR.class.getName());

	protected static WebDriver driver;

	public SearchPage_OR(WebDriver driver) {
		super(driver);
		this.driver = driver;
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath="//*[name()='svg']/parent::i/parent::span/parent::span/parent::button")
	public WebElement searchBtn;

	@FindBy(xpath="//div/child::span/preceding-sibling::input")
	public WebElement searchField;

	@FindBy(xpath="//input[not(@id)][@placeholder]/following-sibling::span")
	public WebElement clearSearchFieldBtn;

	@FindBy(xpath="//h1[contains(text(),'No search results')]")
	public WebElement noSearchLabel;

	@FindBy(xpath="//li/span/following-sibling::a[@class][@href]")
	public List<WebElement> autoSuggestList;

	@FindBy(xpath="//h1/parent::div/preceding-sibling::img/parent::div")
	public List<WebElement> searchResult;
	
	@FindBy(xpath="//a[@id='bx-close-inside-1010323']")
	public WebElement adCloseIcon;
}

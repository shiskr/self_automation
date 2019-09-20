package objectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pages.BasePage;

public class Locations_OR extends BasePage{

	public Locations_OR(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//h3[contains(text(),'STEP 1')]")
	public WebElement headerTitle;
	
	@FindBy(xpath="//a[@class='facility area__item']//h3[contains(text(),'Blink 125th')]")
	public WebElement facility125;
	
	@FindBy(xpath="//div[@class='desktop-visible']//h3[@class='facility__header']")
	public List<WebElement> facilities;

}

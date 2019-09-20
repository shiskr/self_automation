package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pages.BasePage;

public class FacilityPage_OR extends BasePage{

	public FacilityPage_OR(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//div[@class='intro__header']//h1[contains(text(),'Blink 125th')]")
	public WebElement headerTitle;
	
	@FindBy(xpath="//p[contains(text(),'Gray')]/ancestor::div[@class='club-plan-header']/following-sibling::div[@class='club-plan-inner']//ins[contains(text(),'Click Here')]")
	public WebElement greyClickHere;
	
	
	@FindBy(xpath="//p[contains(text(),'Blue')]/ancestor::div[@class='club-plan-header']/following-sibling::div[@class='club-plan-inner']//ins[contains(text(),'Click Here')]")
	public WebElement blueClickHere;
	
	
}

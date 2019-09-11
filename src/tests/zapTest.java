package tests;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

public class zapTest extends BaseTest{

	static Logger logger = Logger.getLogger(zapTest.class.getName());

	@Test(enabled=true)
	public void noResultFound()
	{
		try {
			searchPage.hitSearch("new");
			owaspScan();
			spiderWithZap();
			scanWithZap();
			articlePage = searchPage.clickSearchResult(1);
			if(articlePage!=null)
			{
				System.out.println("veriySearchResultClick : Test Run Successfully");
				owaspScan();
				spiderWithZap();
				scanWithZap();
			}

			searchPage = articlePage.navigateBack();
			if(searchPage!=null)
			{
				owaspScan();
				spiderWithZap();
				scanWithZap();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}



}

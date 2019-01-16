package tests;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

public class TestSearchScenarios extends BaseTest{

	static Logger logger = Logger.getLogger(TestSearchScenarios.class.getName());

	@Test(enabled=true)
	public void noResultFound()
	{
		try {
			//entering random text 'ieucit' to check for "No Result Found"
			searchPage.hitSearch("ieucit");
			if (searchPage.verifyNoResults()) {
				System.out.println("noResultFound : Test Ran Successfully");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	

	@Test(enabled=true)
	public void veriyAutosuggestOptions()
	{
		try {
			//entering valid search keyword to check for Auto Suggestions
			searchPage.enterTextSearchField("new");
			if (searchPage.verifyAutosuggest()) {
				System.out.println("veriyAutosuggestOptions : Test Ran Successfully");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(enabled=true)
	public void veriySearchResults()
	{
		try {
			//entering valid search keyword to check for Search Results
			searchPage.hitSearch("news");
			if (searchPage.verifySearchResults()) {
				System.out.println("veriySearchResults : Test Ran Successfully");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(enabled=true)
	public void verifyAutoSuggestClick()
	{
		try {
			searchPage.enterTextSearchField("new");
			articlePage = searchPage.clickAutoSuggest(1);
			if(articlePage!=null)
			{
				System.out.println("veriyAutoSuggestClick : Test Run Successfully");
			}
			searchPage = articlePage.navigateBack();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(enabled=true)
	public void verifySearchResultClick()
	{
		try {
			searchPage.hitSearch("new");
			articlePage = searchPage.clickSearchResult(1);
			if(articlePage!=null)
			{
				System.out.println("veriySearchResultClick : Test Run Successfully");
			}
			searchPage = articlePage.navigateBack();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

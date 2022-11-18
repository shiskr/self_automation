package tests;

import org.testng.annotations.Test;

public class SearchTest extends BaseTest{
	
	@Test(enabled=true)
	public void test1()
	{
		try {
			welcomePage.hitSearch("ieucit");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

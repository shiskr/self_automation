package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.FacilityPage;

public class Test1 extends BaseTest{
	
//	@DataProvider(name = "userinfo")
//	public static Object[][] catalog()
//	{
//		return new Object[][]
//				{
//			{"english", 1, "erjtv", 23423, "2d2c3"},
//			{"french", 2, "w4rcwre", 234, "2c234"}
//				};
//	}
//	
//	@DataProvider(name = "Catalog2")
//	public static Object[][] catalog2()
//	{
//		return new Object[][]
//				{
//			{"english", 1},
//			{"french", 2}
//				};
//	}

	@Test(enabled=false)
	public void LoginScenario()
	{
		loginPage = welcomePage.clickLogin();
		loginPage.enterEmail("testgreen20190507webprod@mailinator.com");
		loginPage.enterPassword("Test@1234");
		homePage = loginPage.clickLogin();
		homePage.verifyLogoutLink();
	}
	
	@Test(enabled=true)
	public void PurchaseScenario()
	{
		locationPage = welcomePage.clickLocationsLink();
		facilityPage = locationPage.clickFacility();
		joinFormPage = facilityPage.clickGreyClickHere();
		joinFormPage.enterMemberDetails();
	}
	
//	@Test
//	public void membershipPurchase()
//	{
//		welcomePage.clickLocationsLink();
//	}
	
	
}

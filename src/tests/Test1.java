package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import utilities.ConfigManager;

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

	@Test(enabled=false)
	public void LoginScenario()
	{
		loginPage = welcomePage.clickLogin();
		loginPage.enterEmail("testgreen20190507webprod@mailinator.com");
		loginPage.enterPassword("Test@1234");
		homePage = loginPage.clickLogin();
		homePage.clickLogoutLink();
	}

	@Test(enabled=true)
	public void PurchaseScenario() throws InterruptedException
	{
		locationPage = welcomePage.clickLocationsLink();
		facilityPage = locationPage.clickFacility();
		joinFormPage = facilityPage.clickBlueClickHere();
		joinFormPage.enterMemberDetails();
		registrationBridgePage = joinFormPage.enterMemberPaymentDetails();
		registrationBridgePage.verifyEmail();
		registrationBridgePage.enterPasswords();
		homePage = registrationBridgePage.clickCreateAccount();
		homePage = homePage.clickSkipBtn();
		loginPage = homePage.clickLogoutLink();
	}

	@Test(enabled=false)
	public void PTPurchase()
	{
		
	}

	@Test(dependsOnMethods= {"PurchaseScenario"})
	public void passwordChange()
	{
		loginPage.enterEmail(ConfigManager.getProperties().getProperty("email"));
		loginPage.enterPassword(ConfigManager.getProperties().getProperty("newPassword"));
		homePage = loginPage.clickLogin();
		homePage.clickMemberInfoTab();
		homePage.enterCurrentPassword(ConfigManager.getProperties().getProperty("newPassword"));
		homePage.enterNewPasswords(ConfigManager.getProperties().getProperty("password"));
		homePage.clickChangePassword();
		homePage.verifySuccess();
		
	}

	@Test(enabled=false)
	public void membershipDetailsUpdate()
	{
		
	}



}

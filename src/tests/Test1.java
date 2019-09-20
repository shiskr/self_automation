package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utilities.ConfigManager;

public class Test1 extends BaseTest{

	@DataProvider(name = "userinfo")
	public static Object[][] catalog()
	{
		return new Object[][]
				{
			{"testgray201908_38@mailinator.com", "xeurgnfu"},
				};
	}

	@Test(enabled=true, groups="memberlogin", dataProvider="userinfo")
	public void LoginScenario(String email, String password)
	{
		loginPage = welcomePage.clickLogin();
		loginPage.enterEmail(email);
		loginPage.enterPassword(password);
		homePage = loginPage.clickLogin();
		loginPage = homePage.clickLogoutLink();
		if(loginPage!=null)
		{
			System.out.println("Login Page appears");
		}
	}

	@Test(enabled=true, groups="membershippurchase")
	public void PurchaseScenario() throws InterruptedException
	{
		locationPage = welcomePage.clickLocationsLink();
		facilityPage = locationPage.clickFacility();
		joinFormPage = facilityPage.clickBlueClickHere();
		joinFormPage = joinFormPage.enterMemberDetails();
		registrationBridgePage = joinFormPage.enterMemberPaymentDetails();
		registrationBridgePage.verifyEmail();
		registrationBridgePage.enterPasswords();
		homePage = registrationBridgePage.clickCreateAccount();
		homePage = homePage.clickSkipBtn();
		loginPage = homePage.clickLogoutLink();
	}

	@Test(groups="memberpasswordchange", dependsOnMethods= {"PurchaseScenario"})
	public void passwordChange()
	{
		loginPage = welcomePage.clickLogin();
		loginPage.enterEmail(ConfigManager.getProperties().getProperty("email"));
		loginPage.enterPassword(ConfigManager.getProperties().getProperty("newPassword"));
		homePage = loginPage.clickLogin();
		homePage = homePage.clickMemberInfoTab();
		homePage.enterCurrentPassword(ConfigManager.getProperties().getProperty("newPassword"));
		homePage.enterNewPasswords(ConfigManager.getProperties().getProperty("password"));
		homePage = homePage.clickChangePassword();
		homePage.verifySuccess();
		homePage = homePage.clickGotIt();
	}

	@Test(enabled=true, groups="memberdetailsupdate", dependsOnMethods= {"PurchaseScenario"})
	public void memberDetailsUpdate()
	{
		loginPage = welcomePage.clickLogin();
		loginPage.enterEmail(ConfigManager.getProperties().getProperty("email"));
		loginPage.enterPassword(ConfigManager.getProperties().getProperty("newPassword"));
		homePage = loginPage.clickLogin();
		homePage = homePage.clickMemberInfoTab();
		homePage = homePage.clickEditInfo();
		homePage.changeAddress(ConfigManager.getProperties().getProperty("newaddress"));
		homePage.changeApartment(ConfigManager.getProperties().getProperty("newapartment"));
		homePage.changeCity(ConfigManager.getProperties().getProperty("newcity"));
		homePage.changeState(ConfigManager.getProperties().getProperty("newstate"));
		homePage.changeZip(ConfigManager.getProperties().getProperty("newzip"));
		homePage.changePhone(ConfigManager.getProperties().getProperty("newphone"));
		homePage.changeGender(ConfigManager.getProperties().getProperty("newgender"));
		homePage.clickSaveChanges();
		homePage.verifyThankYou();
	}
	
	@Test(enabled=true)
	public void getfacilitiesNames() throws InterruptedException
	{
		locationPage = welcomePage.clickLocationsLink();
		locationPage.getFacilityNames();
		
	}


}

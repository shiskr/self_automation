package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class
Test1 extends BaseTest{
	
	@Test(enabled=true)
	public void test1()
	{
//		if(driver.findElement(By.linkText("Register")) != null)
//				{
//			driver.findElement(By.linkText("Register")).click();
//				}
		driver.findElement(By.id("username")).sendKeys("student");
		driver.findElement(By.id("password")).sendKeys("Password123");
		driver.findElement(By.id("submit")).click();
	}
}

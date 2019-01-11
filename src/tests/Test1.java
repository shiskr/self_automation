package tests;

import org.testng.annotations.Test;

public class Test1 extends BaseTest{
	
	@Test(enabled=true)
	public void test1()
	{
		System.out.println("running webdriver manager");
	}
}

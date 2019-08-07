package utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReportsGenerator implements ITestListener{

	protected static ExtentReports extentReports; // ExtentReports: By using this class we set the path where our reports need to generate.
	protected static ExtentTest extentTest; // ExtentTest: By using this class we could generate the logs in the report.
	
	public void onTestStart(ITestResult result) {
		System.out.println("on test start");
		extentTest = extentReports.startTest(result.getMethod().getMethodName());
		extentTest.log(LogStatus.INFO, result.getMethod().getMethodName() + "test is started");
	}
	
	public void onTestSuccess(ITestResult result) {
		System.out.println("on test success");
		extentTest.log(LogStatus.PASS, result.getMethod().getMethodName() + "test is passed");
	}
	
	public void onTestFailure(ITestResult result) {
		System.out.println("on test failure");
		extentTest.log(LogStatus.FAIL, result.getMethod().getMethodName() + "test is failed");
		extentTest.log(LogStatus.FAIL, result.getMethod().getMethodName() + "test is failed", result.getThrowable().getMessage());
	}
	
	public void onTestSkipped(ITestResult result) {
		System.out.println("on test skipped");
		extentTest.log(LogStatus.SKIP, result.getMethod().getMethodName() + "test is skipped");
	}
	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("on test sucess within percentage");
	}
	
	public void onStart(ITestContext context) {
		System.out.println("on start");
		extentReports = new ExtentReports(System.getProperty("user.dir")+"//reports/"+new SimpleDateFormat("yyyy-MM-dd hh-mm").format(new Date()) + "_self_automation_reports.html");
		extentReports
         .addSystemInfo("Host Name", "kumar shishir")
         .addSystemInfo("Environment", "Test")
         .addSystemInfo("User Name", "Self Team");
		extentReports.loadConfig(new File(System.getProperty("user.dir")+"//resources/extent-config.xml"));
	}
	
	public void onFinish(ITestContext context) {
		System.out.println("on finish");
		extentReports.endTest(extentTest);
		extentReports.flush();
	}

}

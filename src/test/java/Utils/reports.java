package Utils;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class reports implements ITestListener {

	public ExtentSparkReporter extentReport;
	public ExtentReports Extent;
	public ExtentTest Test;

	Date currentDate = new Date();
	String datePattern = "EEE MMM dd HH:mm:ss z yyyy"; // Example: Wed Feb 26 08:58:09 IST 2025
	SimpleDateFormat sdf = new SimpleDateFormat(datePattern);
	String currentDateTime = sdf.format(new Date());

	// Replace illegal characters in the filename
	String sanitizedDateTime = currentDateTime.replaceAll("[<>:\"/\\|?*]", "_"); // Replace any illegal characters with
																					// "_"

	public void onStart(ITestContext context) {
		extentReport = new ExtentSparkReporter(
				System.getProperty("user.dir") + "\\reports\\Extenreport" + sanitizedDateTime + ".html");

		Extent = new ExtentReports();

		Extent.attachReporter(extentReport);
		Extent.setSystemInfo("Browser", "chrome");
		Extent.setSystemInfo("platform", "Windows");
		Extent.setSystemInfo("Author", "Loknath");

	}

	public void onTestSuccess(ITestResult result) {

		Test = Extent.createTest(result.getName());
		Test.log(Status.PASS, "Testcase Succesfully passed" + result.getName());

	}

	public void onTestFailure(ITestResult result) {
		Test = Extent.createTest(result.getName());
		Test.log(Status.FAIL, "Testcase Failed " + result.getName());

		Test.log(Status.FAIL, "Testcase is failed......." + result.getThrowable());

	}

	public void onTestSkipped(ITestResult result) {
		Test = Extent.createTest(result.getName());
		Test.log(Status.SKIP, "Testcase Is Skipped" + result.getName());
	}

	public void onFinish(ITestContext context) {

		Extent.flush();

	}

}

package Appium.ExtentReport;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import org.openqa.selenium.chrome.ChromeDriver;

public class ExtentReport {

	ExtentReports extent;

	@BeforeTest
	public void config() {
		String path = System.getProperty("user.dir") + "\\reports\\index.html";
		ExtentSparkReporter ex = new ExtentSparkReporter(path);
		ex.config().setReportName("Web Automation Report");
		ex.config().setDocumentTitle("Title Name");

		extent = new ExtentReports();
		extent.attachReporter(ex);
		extent.setSystemInfo("Tester", "Dinesh Parate");
	}

	@Test
	public void initialCode() {

		extent.createTest("initial Test");
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Dinesh.P\\Downloads\\DriverVersion-104\\chromedriver_win32\\chromedriver.exe");

		// provide the method to automate code.
		WebDriver driver = new ChromeDriver();

		driver.get("https://afourtech.com/");
		System.out.println(driver.getTitle());
		driver.close();
		extent.flush();

	}
}

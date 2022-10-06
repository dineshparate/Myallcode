package Appium.appiumframewrokdesign.testData;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.BeforeClass;

import com.fasterxml.jackson.databind.annotation.JsonAppend.Prop;
import com.google.common.collect.ImmutableMap;

import Appium.appiumframewokdesign.pageobject.android.Formpage;
import Appium.appiumframewokdesign.utils.AppiumUtils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class AndroidBaseTest extends AppiumUtils{
	protected UiAutomator2Options options;
	protected AppiumDriverLocalService service;
	public AndroidDriver driver;
	protected Formpage form;
	
	@BeforeClass(alwaysRun = true)
	public void start() throws IOException {
		
		Properties properties=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Appium\\appiumframewokdesign\\resources\\data.properties");
		properties.load(fis);
		
		String url=System.getProperty("Url")!=null?System.getProperty("Url"):properties.getProperty("Url");
		String devicename=properties.getProperty("AndroidDeviceName");
		options = new UiAutomator2Options();
		options.setDeviceName(devicename);
		// Used chrome driver 91 version
		options.setChromedriverExecutable("C:\\Users\\Dinesh.P\\Downloads\\chromedriver_win32-91Version\\chromedriver.exe");
		// options.setApp("D:\\AppiumMobileAutomation\\LearnAppium\\src\\test\\java\\resources\\ApiDemos-debug.apk");
		options.setApp("D:\\AppiumMobileAutomation\\appiumdesignframework\\src\\test\\java\\resources\\General-Store.apk");

		// AndroidDriver create the object of class

		driver = new AndroidDriver(new URL(url), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 form=new Formpage(driver);

	}


	/*
	 * @AfterClass public void tearDown() { driver.quit(); }
	 */
}

package testData;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class BaseTest {
	UiAutomator2Options options;
	protected AndroidDriver driver;

	@BeforeClass(alwaysRun = true)
	public void start() throws MalformedURLException {
		//options = new UiAutomator2Options();
		//options.setDeviceName("Pixel 4 XL API 31");
		//Used chrome driver 91 version
		//options.setChromedriverExecutable("C:\\Users\\Dinesh.P\\Downloads\\chromedriver_win32\\chromedriver.exe");
		//options.setApp("D:\\AppiumMobileAutomation\\GoogleTaskTodoList\\src\\test\\java\\resources\\google-Tasks.apk");	
		// AndroidDriver create the object of class
		
		

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Pixel 4 XL API 31");
        capabilities.setCapability("platformVersion", "12.0");
        capabilities.setCapability("app", "D:\\AppiumMobileAutomation\\GoogleTaskTodoList\\src\\test\\java\\resources\\google-Tasks.apk");
        capabilities.setCapability("automationName", "UiAutomator2");
        
	        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}

	

	/*@AfterClass
	public void tearDown() {
		driver.quit();
	}*/

}

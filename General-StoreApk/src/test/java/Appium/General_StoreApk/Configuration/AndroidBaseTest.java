package Appium.General_StoreApk.Configuration;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
	
	public class AndroidBaseTest {
		UiAutomator2Options options;
		protected AndroidDriver driver;

		@BeforeClass(alwaysRun = true)
		public void start() throws MalformedURLException {
			
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability("platformName", "Android");
	        capabilities.setCapability("deviceName", "Pixel 4 XL API 31");
	        capabilities.setCapability("platformVersion", "12.0");
	        capabilities.setCapability("app", "D:\\AppiumMobileAutomation\\General-StoreApk\\src\\test\\java\\resources\\General-Store.apk");
	        capabilities.setCapability("automationName", "UiAutomator2");
	        
		        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
		        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
		}
		
}

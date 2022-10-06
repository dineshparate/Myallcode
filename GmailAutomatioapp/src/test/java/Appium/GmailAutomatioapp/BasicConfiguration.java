package Appium.GmailAutomatioapp;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class BasicConfiguration {

	AndroidDriver driver; 
	DesiredCapabilities capabilities = new DesiredCapabilities();

	@BeforeClass(alwaysRun = true)
	public void init() throws MalformedURLException {

		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("deviceName", "Pixel 4 XL API 31 2");
		//capabilities.setCapability(CapabilityType.BROWSER_NAME, "Chrome");
		capabilities.setCapability("platformVersion", "12.0");
		capabilities.setCapability("appPackage", " com.google.android.gm");
		capabilities.setCapability("appActivity", "com.google.android.gm.welcome.WelcomeTourActivity");
		capabilities.setCapability("automationName", "UiAutomator2");
		//appActivity
		 driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}
}
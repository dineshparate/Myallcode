package appium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AppiumBasic extends BaseTest {
	@Test
	public void firsttest() throws MalformedURLException, InterruptedException {
		
		  /*AppiumDriverLocalService service = new AppiumServiceBuilder()
		  .withAppiumJS(new File(
		  "C:\\Users\\Dinesh.P\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"
		  )) .withIPAddress("127.0.0.1").usingPort(4723).build(); service.start();*/

		
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\'3. Preference dependencies\']")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("android:id/checkbox")).click();
		driver.findElement(By.xpath("(//android.widget.RelativeLayout) [2]")).click();
		driver.findElement(By.id("android:id/edit")).sendKeys("Dinesh");
		driver.findElement(By.id("android:id/button1")).click();
	}
	
	
}
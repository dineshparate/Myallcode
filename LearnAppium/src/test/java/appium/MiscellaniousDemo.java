package appium;

import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.ScreenOrientation;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.nativekey.AndroidKey;

public class MiscellaniousDemo extends BaseTest {

	@Test
	public void rotateMode() throws InterruptedException
	{
		//io.appium.android.apis.preference.PreferenceDependencies - activity name
		
		Activity activity=new Activity("io.appium.android.apis", "io.appium.android.apis.preference.PreferenceDependencies");
		driver.startActivity(activity);
		/*driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\'3. Preference dependencies\']")).click();
		Thread.sleep(1000);*/
		
		driver.findElement(By.id("android:id/checkbox")).click();
		DeviceRotation landscape=new DeviceRotation(0, 0, 90);
		//driver.rotate(landscape);
		//driver.rotate(ScreenOrientation.PORTRAIT);
		driver.findElement(By.xpath("(//android.widget.RelativeLayout) [2]")).click();
		driver.setClipboardText("Dinesh");
		//driver.findElement(By.id("android:id/edit")).sendKeys("Dinesh");
		driver.findElement(By.id("android:id/edit")).sendKeys(driver.getClipboardText());
		driver.findElement(By.id("android:id/button1")).click();
		Thread.sleep(3000);
		driver.navigate().back();
	}
	
}

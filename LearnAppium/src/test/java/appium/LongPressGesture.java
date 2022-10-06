package appium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class LongPressGesture extends BaseTest {
	@Test
	public void gestureexample() throws InterruptedException {
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\'Expandable Lists\']")).click();
		driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
		// 1. Custom Adapter
		WebElement ele = driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
		// ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",
		// ImmutableMap.of(
		// "elementId",((RemoteWebElement) ele).getId(),"duration",10000));
		longkeypressed(ele);
		String name=driver.findElement(By.id("android:id/title")).getText();
		Assert.assertEquals(name, "Sample menu");
		Assert.assertTrue(driver.findElement(By.id("android:id/title")).isDisplayed());
		System.out.println(name);
		Thread.sleep(1000);
	}
}

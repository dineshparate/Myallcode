package appium;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class AssignmentDemo extends BaseTest {

	@Test
	public void swipeDemo() {
		driver.findElement(AppiumBy.accessibilityId("App")).click();
		driver.findElement(AppiumBy.accessibilityId("Alert Dialogs")).click();
		// firstlink();
		// listDialog();//android.widget.CheckedTextView
		
		
	}

	public void listDialog() {
		driver.findElement(By.xpath("//android.widget.Button[@content-desc='List dialog']")).click();
		String str = driver.findElement(By.xpath("//android.widget.TextView[@text='Command one']")).getText();
		driver.findElement(By.xpath("//android.widget.TextView[@text='Command one']")).click();
		System.out.println(str);
	}

	public void firstlink() {
		driver.findElement(By.xpath("//android.widget.Button [1]")).click();
		String str = driver.findElement(By.id("android:id/alertTitle")).getText();
		System.out.println(str);
		Assert.assertTrue(driver.findElement(By.id("android:id/alertTitle")).isDisplayed());
		driver.findElement(By.id("android:id/button2")).click();
	}
	public void choiceList()
	{
		driver.findElement(AppiumBy.accessibilityId("Single choice list")).click();
		driver.findElement(By.xpath("//android.widget.CheckedTextView [2]")).click();
		driver.findElement(By.id("android:id/button2")).click();
	}
}

package appium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class SwipeGesture extends BaseTest {
	@Test
	public void swipeDemo() {
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
		//// android.widget.TextView[@content-desc="1. Photos"]

		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"1. Photos\"]")).click();
		// WebElement
		// ele=driver.findElement(AppiumBy.id("io.appium.android.apis:id/gallery"));

		Assert.assertEquals(driver.findElement(By.xpath("//android.widget.ImageView [1]")).getAttribute("focusable"),
				"true");
		WebElement ele = driver.findElement(By.xpath("//android.widget.ImageView [1]"));

		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) ele).getId(), "direction", "left", "percent", 0.75));
		Assert.assertEquals(driver.findElement(By.xpath("//android.widget.ImageView [1]")).getAttribute("focusable"),
				"false");

	}

}

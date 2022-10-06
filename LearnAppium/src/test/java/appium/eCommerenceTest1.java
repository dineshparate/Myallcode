package appium;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class eCommerenceTest1 extends BaseTest
{
	@Test
	public void fillForm() throws InterruptedException
	{
		driver.findElement(By.id("android:id/text1")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"India\"));"));
		driver.findElement(By.xpath("//android.widget.TextView[@text='India']")).click();
		//driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Dinesh Parate");
		driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
		driver.findElement(By.xpath("//android.widget.Button")).click();
		Thread.sleep(3000);
		//Toast message logic
		String toastmsg=driver.findElement(By.xpath("//android.widget.Toast")).getAttribute("name");
		Assert.assertEquals(toastmsg, "Please enter your name");
		System.out.println(toastmsg);
	}
}

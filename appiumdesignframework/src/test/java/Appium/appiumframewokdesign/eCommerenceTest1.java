package Appium.appiumframewokdesign;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Appium.appiumframewrokdesign.testData.AndroidBaseTest;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;

public class eCommerenceTest1 extends AndroidBaseTest
{
	@BeforeMethod(alwaysRun=true)
	public void homePage()
	{
		//This line of code is used to directly move our choice page
		//Required App package and Activity Package
		Activity activity = new Activity("com.androidsample.generalstore", "com.androidsample.generalstore.MainActivity");
		driver.startActivity(activity);
	}
	@Test(groups= {"Smoke"})
	public void FillForm_ErrorMessage() throws InterruptedException
	{
		driver.findElement(By.id("android:id/text1")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
		driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
		//driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Dinesh Parate");
		driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
		driver.findElement(By.xpath("//android.widget.Button")).click();
		Thread.sleep(3000);
		//Toast message logic
		String toastmsg=driver.findElement(By.xpath("//android.widget.Toast")).getAttribute("name");
		Assert.assertEquals(toastmsg, "Please enter your name");
		System.out.println(toastmsg);
	}
	@Test (groups= {"Smoke"})
	public void FillForm_PositiveFlow() throws InterruptedException
	{
		driver.findElement(By.id("android:id/text1")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
		driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Dinesh Parate");
		driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
		driver.findElement(By.xpath("//android.widget.Button")).click();
		Thread.sleep(3000);
		//Toast message logic
		//String toastmsg=driver.findElement(By.xpath("//android.widget.Toast [1]")).getAttribute("name");
		//Assert.assertEquals(toastmsg, "Please enter your name");
		//System.out.println(toastmsg);
		
		Assert.assertTrue(driver.findElements(By.xpath("//android.widget.Toast [1]")).size()<1);
	}
	
	
}

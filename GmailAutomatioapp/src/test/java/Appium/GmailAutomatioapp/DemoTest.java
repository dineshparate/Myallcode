package Appium.GmailAutomatioapp;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.functions.ExpectedCondition;

public class DemoTest extends BasicConfiguration {

	String selectmail = "dineshparate25@gmail.com";

	public void addmail(String selectmail) throws InterruptedException {
		driver.findElement(By.id("com.google.android.gm:id/setup_addresses_add_another")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='Google']")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		Thread.sleep(25000);
		Set<String> contexts = driver.getContextHandles();
		for (String contextName : contexts) {
			System.out.println(contextName);
		}
		driver.context("NATIVE_APP");

		// waitforElementToAppear();
		driver.findElement(By.xpath("//android.widget.EditText[@resource-id='identifierId']"))
				.sendKeys("dineshparate61@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.widget.Button[@text='Next']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(
				"//android.view.View[@resource-id='password']/android.view.View/android.view.View/android.widget.EditText"))
				.sendKeys("G00gle@123");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.widget.Button[@text='Next']")).click();
		// android.widget.Button[@text='Next']
	}

	public void selectmail(String selectmail) {

	}

	public void takeToGmail() throws InterruptedException {
		driver.findElement(By.id("com.google.android.gm:id/action_done")).click();
		if (driver.findElement(By.id("android:id/message")).isDisplayed()) {
			driver.findElement(By.xpath("//android.widget.Button[@text='OK']")).click();
			addmail(selectmail);
		}

	}

	@Test
	public void sendMail() {
		try {
			driver.findElement(AppiumBy.id("com.google.android.gm:id/welcome_tour_got_it")).click();
			takeToGmail();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
//com.google.android.gm:id/welcome_tour_got_it
}

package appium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class MobileBrowserTest extends BrowserBaseTest{
	
	@Test
	public void mobilebrowsertest() throws InterruptedException
	{
//		driver.get("https://google.com");
//		driver.findElement(By.name("q")).sendKeys("Dinesh Parate");
//		Thread.sleep(2000);
//		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.xpath("//span[@class='navbar-toggler-icon']")).click();
		driver.findElement(By.xpath("//a[@routerlink='/products']")).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		driver.findElement(By.xpath("//a[normalize-space()='Devops']")).click();
		
	}
}

package appium;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class eCommerenceTest3 extends BaseTest {

	@Test
	public void validateAddtoCart() throws InterruptedException {
		driver.findElement(By.id("android:id/text1")).click();
		driver.findElement(
				AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
		driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Dinesh Parate");
		driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
		driver.findElement(By.xpath("//android.widget.Button")).click();
		driver.findElement(AppiumBy
				.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Jordan 6 Rings\"));"));
		// for product page logic
		driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
		driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();

		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();

		// wait until another page not occur
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.attributeContains(
				driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));
		
		List<WebElement> list =driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
		int no=list.size();
		double sum=0;
		for(int i=0;i<no;i++)
		{
			String price=list.get(i).getText();
			double price1=Double.parseDouble(price.substring(1));
			sum=sum+price1;
		}
		String Tprice=driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		double Tprice1=Double.parseDouble(Tprice.substring(1));
		System.out.println(sum+ " "+Tprice1);
		Assert.assertEquals(sum, Tprice1);
		
		WebElement ele=driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
		longkeypressed(ele);
		driver.findElement(By.id("android:id/button1")).click();
		driver.findElement(By.className("android.widget.CheckBox")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
		
		Thread.sleep(5000);
		Set<String> contexts=driver.getContextHandles();
		
		for(String contextName:contexts)
		{
			System.out.println(contextName);
		}
				
		
	}
}
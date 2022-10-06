package Appium.appiumframewokdesign;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Appium.appiumframewokdesign.pageobject.android.CartPage;
import Appium.appiumframewokdesign.pageobject.android.Formpage;
import Appium.appiumframewokdesign.pageobject.android.ProductCatlogue;
import Appium.appiumframewrokdesign.testData.AndroidBaseTest;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class eCommerce_tc_4_Hybrid extends AndroidBaseTest {

	@Test(dataProvider = "getData")
	public void FillForm(HashMap<String,String>  input) throws InterruptedException {

		form.setNamefield(input.get("name"));
		driver.hideKeyboard();
		form.setGender(input.get("gender"));
		form.setCountryName(input.get("country"));
		ProductCatlogue productcatlogue = form.submitForm();
		
		productcatlogue.addItemToCartByIndex(0);
		productcatlogue.addItemToCartByIndex(0);
	
		//CartPage cartPage = productcatlogue.gotoCartPage();
		CartPage cartPage=new CartPage(driver);

		cartPage.waitforElementToAppear(driver);
		double totalSum = cartPage.getProductsSum();
		double displayFormattedSum = cartPage.getTotalAmountDisplayed();
		AssertJUnit.assertEquals(totalSum, displayFormattedSum);
		cartPage.acceptTermsConditions();
		cartPage.submitOrder();
		
		
		Thread.sleep(6000);
		Set<String> contexts = driver.getContextHandles();
		for (String contextName : contexts) {
			System.out.println(contextName);
		}
		Thread.sleep(2000);
		driver.context("WEBVIEW_com.androidsample.generalstore"); // chrome driver
		Thread.sleep(2000);
		driver.findElement(By.name("q")).sendKeys("rahul shetty academy");
		Thread.sleep(2000);
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.context("NATIVE_APP");
	
	}
	@BeforeMethod
	public void homePage()
	{
		//This line of code is used to directly move our choice page
		//Required App package and Activity Package
		Activity activity = new Activity("com.androidsample.generalstore", "com.androidsample.generalstore.MainActivity");
		driver.startActivity(activity);
	}
	@DataProvider
	public Object[][] getData() throws IOException
	{
		List<HashMap<String, String>> data=getJsonData("D:\\AppiumMobileAutomation\\appiumdesignframework\\src\\test\\java\\Appium\\appiumframewrokdesign\\testData\\eCommerence.json");
		//return new Object[][] {{"Dinesh Parate","male","Argentina"},{"xyz","female","Argentina"}};
		return new Object[][] { {data.get(0)},{data.get(1)} };
	}

}

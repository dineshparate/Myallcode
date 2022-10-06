package General_store.Test;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import Appium.General_StoreApk.Configuration.AndroidBaseTest;
import General_Store.Pageobject.CartPage;
//import Appium.General_StoreApk.Configuration.AndroidBaseTest.BaseTest;
import General_Store.Pageobject.FormPage;
import General_Store.Pageobject.ProductPage;
import io.appium.java_client.AppiumBy;

//import Appium.appiumframewokdesign.pageobject.android.ProductCatlogue;

public class DemoTest extends AndroidBaseTest {
	@Test
	public void formPage() throws InterruptedException {
		FormPage form = new FormPage(driver);
		form.setNamefield("Dinesh Parate");
		driver.hideKeyboard();
		form.setGender("Male");
		form.setCountryName("Argentina");
		form.submitForm();
		form.scrollToText("PG 3");
		ProductPage productcatlogue = new ProductPage(driver);
		productcatlogue.addItemToCartByIndex(0);
		productcatlogue.addItemToCartByIndex(0);
		CartPage cartPage=new CartPage(driver);
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		cartPage.waitforElementToAppear(driver);
		
		double totalSum = cartPage.getProductsSum();
		double displayFormattedSum = cartPage.getTotalAmountDisplayed();
		AssertJUnit.assertEquals(totalSum, displayFormattedSum);
		cartPage.acceptTermsConditions();
		cartPage.submitOrder();
		

	}
}

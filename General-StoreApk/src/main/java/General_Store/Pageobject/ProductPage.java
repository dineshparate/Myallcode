package General_Store.Pageobject;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

//import Appium.appiumframewokdesign.pageobject.android.CartPage;
//import Appium.appiumframewokdesign.utils.AndroidActions;
import General_Store.Utils.AndroidAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProductPage extends AndroidAction {

	AndroidDriver driver;
	@AndroidFindBy(xpath="//android.widget.TextView[@text='ADD TO CART']")
	private List<WebElement> addtoCartButton;

	@AndroidFindBy(id="com.androidsample.generalstore:id/appbar_btn_cart")
	private WebElement cart;

	public ProductPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	public void addItemToCartByIndex(int i) throws InterruptedException {
		System.out.println(addtoCartButton.size());
		Thread.sleep(2000);
		addtoCartButton.get(i).click();
	}
	public void gotoCartPage() throws InterruptedException {
		cart.click();
		Thread.sleep(2000);
		//return new CartPage(driver);
	}
}

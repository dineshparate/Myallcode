package General_Store.Pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import General_Store.Utils.AndroidAction;
//import Appium.appiumframewokdesign.pageobject.android.ProductCatlogue;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FormPage extends AndroidAction{

	
	AndroidDriver  driver;
	public FormPage(AndroidDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	//driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Rahul Shetty");
   @AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
   private WebElement namefield;
   //driver.findElement(By.id("com.androidsample.generalstore:id/nameField"))
   
   @AndroidFindBy(xpath ="//android.widget.RadioButton[@text='Female']")
   private WebElement femalefield;
   
   @AndroidFindBy(xpath ="//android.widget.RadioButton[@text='Male']")
   private WebElement malefield;
   
   @AndroidFindBy(id="android:id/text1")
   private WebElement countrySelection;
   
   @AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
   private WebElement ShopButton;
   
   public void setNamefield(String name)
   {
	   namefield.sendKeys(name);
   }
   public void setGender(String gender)
   {
	   if(gender.contains("female"))
		   femalefield.click();
	   else
		   malefield.click();
   }
   public void setCountryName(String country)
   {
	   countrySelection.click();
	   scrollToText(country);
		driver.findElement(By.xpath("//android.widget.TextView[@text='"+country+"']")).click();	   
   }
   public void submitForm()
   {
	   ShopButton.click();
	  //return new ProductCatlogue(driver);
   }
}

package Appium.TodoList.PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ToDoListOperation {
	AndroidDriver driver;

	public ToDoListOperation(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text='Create new list']")
	public WebElement createnewlist;

	@AndroidFindBy(id = "com.google.android.apps.tasks:id/welcome_get_started")
	public WebElement clickgetstartbutton;

	@AndroidFindBy(accessibility = "Switch task lists or account")
	public WebElement clicklisticon;

	@AndroidFindBy(id = "com.google.android.apps.tasks:id/edit_list_title")
	public WebElement enterlistname;

	@AndroidFindBy(id = "com.google.android.apps.tasks:id/done_button")
	public WebElement clickDonebutton;

	// @AndroidFindBy(xpath =
	// "//android.support.v7.widget.LinearLayoutCompat/android.widget.CheckedTextView[@resource-id='com.google.android.apps.tasks:id/design_menu_item_text']")
	// public List<WebElement> tasklist;

	@AndroidFindBy(id = "com.google.android.apps.tasks:id/action_more_options")
	public WebElement moreoptions;

	public void renameList(String text, String newText) throws InterruptedException {
		// clicklisticon.click();
		try {
			if (text.equalsIgnoreCase("Starred")) {
				System.out.println("No such list present");
				Thread.sleep(3000);

			} else {
				driver.findElement(AppiumBy.androidUIAutomator(
						"new UiScrollable(new UiSelector().resourceId(\"com.google.android.apps.tasks:id/tabs\")).setAsHorizontalList().scrollIntoView("
								+ "new UiSelector().description(\"" + text + "\"))"));
				driver.findElement(AppiumBy.accessibilityId(text)).click();
				driver.findElement(AppiumBy.accessibilityId("More options")).click();
				driver.findElement(By.id("com.google.android.apps.tasks:id/rename_list_option")).click();
				driver.findElement(By.id("com.google.android.apps.tasks:id/edit_list_title")).sendKeys(newText);
				driver.findElement(By.id("com.google.android.apps.tasks:id/done_button")).click();
				Thread.sleep(3000);
			}
		} catch (Exception e) {
			System.out.println("No such list present");
			Thread.sleep(3000);
		}

	}

	public void clickgetstartedbutton() {
		clickgetstartbutton.click();

	}

	public void createnewlist(String listname) throws InterruptedException {
		clicklisticon.click();
		createnewlist.click();
		enterlistname.sendKeys(listname);
		clickDonebutton.click();
		Thread.sleep(3000);
	}

	public void deleteList(String text) throws InterruptedException {
		try {
			if (text.equalsIgnoreCase("Starred")) {
				System.out.println("No such list present");
				Thread.sleep(3000);

			} else {
				driver.findElement(AppiumBy.androidUIAutomator(
						"new UiScrollable(new UiSelector().resourceId(\"com.google.android.apps.tasks:id/tabs\")).setAsHorizontalList().scrollIntoView("
								+ "new UiSelector().description(\"" + text + "\"))"));
				driver.findElement(AppiumBy.accessibilityId(text)).click();
				driver.findElement(AppiumBy.accessibilityId("More options")).click();
				Thread.sleep(3000);
				WebElement deleteoption = driver
						.findElement(By.id("com.google.android.apps.tasks:id/delete_list_option_title"));
				Thread.sleep(3000);

				if (deleteoption.isEnabled()) {
					deleteoption.click();
				} else {
					System.out.println("List is not deleted");
				}
			}
		} catch (Exception e) {
			System.out.println("No such list present or delete option is disabled");
			Thread.sleep(3000);
		}
	}
	
	
	
}

package Appium.TodoList.PageObject;

import java.awt.Dimension;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import org.testng.collections.Objects;

import com.google.common.collect.ImmutableList;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class TaskListOperation extends ToDoListOperation {

	AndroidDriver driver;

	public TaskListOperation(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc='Create new task']")
	public WebElement clicknewtaskicon;

	@AndroidFindBy(id = "com.google.android.apps.tasks:id/add_task_title")
	public WebElement newtask;

	@AndroidFindBy(id = "com.google.android.apps.tasks:id/add_task_done")
	public WebElement savebutton;

	public void selectlist(String text) {
		try {

			driver.findElement(AppiumBy.androidUIAutomator(
					"new UiScrollable(new UiSelector().resourceId(\"com.google.android.apps.tasks:id/tabs\")).setAsHorizontalList().scrollIntoView("
							+ "new UiSelector().description(\"" + text + "\"))"));
			driver.findElement(AppiumBy.accessibilityId(text)).click();

		} catch (Exception e) {
			System.out.println("No such list present");
		}
	}

	public void createtask(String selectlisttext, String createlisttext) throws InterruptedException {
		selectlist(selectlisttext);
		clicknewtaskicon.click();
		Thread.sleep(2000);
		newtask.sendKeys(createlisttext);
		Thread.sleep(2000);
		savebutton.click();
		Thread.sleep(5000);
	}

	public void deleteallcompletedtask(String selectlisttext) throws InterruptedException {
		try {
			selectlist(selectlisttext);
			driver.findElement(AppiumBy.accessibilityId("More options")).click();
			if (driver.findElement(By.id("com.google.android.apps.tasks:id/delete_all_completed_tasks_option"))
					.isDisplayed()) {
				Thread.sleep(2000);
				driver.findElement(By.id("com.google.android.apps.tasks:id/delete_all_completed_tasks_option")).click();
				driver.findElement(By.id("android:id/button1")).click();
				Thread.sleep(5000);
			}
		} catch (Exception e) {
			driver.navigate().back();
			System.out.println("deleteallcompletedtask option is not visible");
		}
	}

	public void completedTask(String ListName, String taskname) {
		try {
			selectlist(ListName);

			driver.findElement(AppiumBy.accessibilityId(taskname)).click();
			driver.findElement(By.id("com.google.android.apps.tasks:id/edit_task_complete_button")).click();
		} catch (Exception e) {
			System.out.println("Element not found");
		}
	}

}

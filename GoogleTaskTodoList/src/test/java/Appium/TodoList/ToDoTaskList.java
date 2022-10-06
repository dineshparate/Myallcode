package Appium.TodoList;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Appium.TodoList.PageObject.ScrollDown;
import Appium.TodoList.PageObject.TaskListOperation;
import Appium.TodoList.PageObject.ToDoListOperation;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import testData.BaseTest;

public class ToDoTaskList extends BaseTest {

	@BeforeMethod
	public void configure() {
		//Activity activity = new Activity("com.google.android.apps.tasks",
			//	"com.google.android.apps.tasks.ui.TaskListsActivity");
		//driver.startActivity(activity);
				TaskListOperation operation = new TaskListOperation(driver);
	}

	@Test
	public void CreateTask() throws InterruptedException {
		TaskListOperation operation = new TaskListOperation(driver);
		operation.clickgetstartedbutton();
		operation.createtask("DemoList", "Create Automation Script");
	}

	@Test(priority=1)
	public void taskoperation() throws InterruptedException {
		
		TaskListOperation operation = new TaskListOperation(driver);
		operation.completedTask("My Tasks","Day7Task");
		
	}

	@Test(priority=2)
	public void deleteallCompletedTask() throws InterruptedException {
		TaskListOperation operation = new TaskListOperation(driver);
		operation.deleteallcompletedtask("My Tasks");
	}

	
}

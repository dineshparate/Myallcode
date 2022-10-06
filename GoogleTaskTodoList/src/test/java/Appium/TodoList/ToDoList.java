package Appium.TodoList;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Appium.TodoList.PageObject.ToDoListOperation;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import testData.BaseTest;

public class ToDoList extends BaseTest{
	ToDoListOperation operation;
	@BeforeMethod
	public void configure() {
		// com.google.android.apps.tasks
		// com.google.android.apps.tasks.ui.TaskListsActivity
//		Activity activity=new Activity("com.google.android.apps.tasks","com.google.android.apps.tasks.ui.TaskListsActivity");
//		driver.startActivity(activity);
		 operation=new ToDoListOperation(driver);
	}
	
	@Test
	public void CreateNewList() throws InterruptedException
	{	
		ToDoListOperation operation=new ToDoListOperation(driver);
		operation.clickgetstartedbutton();
		operation.createnewlist("FirstDay");
		Thread.sleep(4000);
	}
	@Test(priority=1)
	public void RenameList() throws InterruptedException
	{
		
		operation.renameList("FirstDay","NewTasklist");
		
	}
	
	@Test(priority=2)
	public void DeleteList() throws InterruptedException
	{
		//		ToDoListOperation operation=new ToDoListOperation(driver);
		Thread.sleep(4000);
		operation.deleteList("NewTasklist");
		Thread.sleep(4000);
	}
}

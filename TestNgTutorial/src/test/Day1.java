package test;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Day1 {

	@Test
	public void demo() {
		System.out.println("Hello");
	}
	@Test(groups= {"Smoke"})
	public void demo1()
	{
		System.out.println("Bye");
	}
	@BeforeSuite
	public void demo2()
	{
		System.out.println("Thank You");

	}
	@AfterSuite
	public void demo3()
	{
		System.out.println("Thank You");

	}
}

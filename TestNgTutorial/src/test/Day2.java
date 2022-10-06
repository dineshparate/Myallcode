package test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Day2 {

	@BeforeMethod
	public void demo() {
		System.out.println("HelloGood");
	}
	
	@Test(groups= {"Smoke"})
	public void demo1() {
		System.out.println("HelloBye");
	}

	@Test
	public void demo2() {
		System.out.println("HelloByeData");
	}

}

package test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Day4 {
	@Test(groups= {"Smoke"})
	public void WebloginHomeLoan() {
		System.out.println("login Web Home");
	}

	@Test
	public void MobileloginHomeLoan() {
		System.out.println("login Mobile Home");
	}

	@Test
	public void AppiumloginHomeLoan() {
		System.out.println("login Appium Home");
	}

}

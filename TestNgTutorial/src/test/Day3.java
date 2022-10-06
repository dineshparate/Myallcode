package test;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

public class Day3 {

	@Test(groups= {"Smoke"})
	public void WebloginCar() {
		System.out.println("login Web Car");
	}
	
	@Parameters({"URL","APIKEY/username"})
	@Test
	public void APIMobileloginCar(String urlname,String keyname) {
		System.out.println("login APIMobile Car");
		System.out.println(urlname);
		System.out.println(keyname);
	}
	@Test
	public void APIWebloginCar() {
		System.out.println("login APIWeb Car");
	}
	@Test
	public void APIAppiumloginCar() {
		System.out.println("login APIAppium Car");
	}

	@Test
	public void AppiumloginCar() {
		System.out.println("login Appium Car");
	}

}

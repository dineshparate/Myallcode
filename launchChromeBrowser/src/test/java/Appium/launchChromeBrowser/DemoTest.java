package Appium.launchChromeBrowser;

import org.testng.annotations.Test;

public class DemoTest extends BasicConfiguration{

	
	@Test
	public void launchCrome() throws InterruptedException
	{
		Thread.sleep(4000);
		driver.get("https://afourtech.com/");
	}
}

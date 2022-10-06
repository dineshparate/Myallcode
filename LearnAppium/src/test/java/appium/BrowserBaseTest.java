package appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class BrowserBaseTest {
	UiAutomator2Options options;
	AndroidDriver driver;

	@BeforeClass
	public void start() throws MalformedURLException {

		options = new UiAutomator2Options();
		options.setDeviceName("Pixel 4 XL API 31");
		options.setChromedriverExecutable("C:\\Users\\Dinesh.P\\Downloads\\chromedriver_win32\\chromedriver.exe");
		//options.setCapability();
		options.setCapability("browserName", "Chrome");
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	/*@AfterClass
	public void tearDown() {
		driver.quit();
	}*/
}

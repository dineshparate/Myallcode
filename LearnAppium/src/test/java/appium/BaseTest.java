package appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class BaseTest {

	UiAutomator2Options options;
	AndroidDriver driver;

	@BeforeClass
	public void start() throws MalformedURLException {
		options = new UiAutomator2Options();
		options.setDeviceName("Pixel 4 XL API 31");
		//Used chrome driver 91 version
		options.setChromedriverExecutable("C:\\Users\\Dinesh.P\\Downloads\\chromedriver_win32\\chromedriver.exe");
		options.setApp("D:\\AppiumMobileAutomation\\LearnAppium\\src\\test\\java\\resources\\ApiDemos-debug.apk");
		//options.setApp("D:\\AppiumMobileAutomation\\LearnAppium\\src\\test\\java\\resources\\General-Store.apk");
		
		// AndroidDriver create the object of class

		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}

	public void longkeypressed(WebElement ele) {
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",
				 ImmutableMap.of(
				"elementId",((RemoteWebElement) ele).getId(),"duration",10000));
	}

	/*@AfterClass
	public void tearDown() {
		driver.quit();
	}*/

}

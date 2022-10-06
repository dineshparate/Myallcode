package Appium.TodoList.PageObject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class ScrollDown extends TaskListOperation {

	AndroidDriver driver;

	public ScrollDown(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	public void scrollDown() {
		Dimension dimension = driver.manage().window().getSize();
		int scrollStart = (int) (dimension.getHeight() * 0.5);
		int scrollEnd = (int) (dimension.getHeight() * 0.2);

		new TouchAction(driver).press(PointOption.point(0, scrollStart))
				.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(5))).moveTo(PointOption.point(0, scrollEnd))
				.release().perform();
	}

	public boolean selectedtask(String Text) {

		boolean flag = false;
		try {
			TaskListOperation operation = new TaskListOperation(driver);
			operation.selectlist(Text);
			List<WebElement> elements = driver
					.findElements(AppiumBy.id("com.google.android.apps.tasks:id/task_item_layout"));

			while (true) {
				for (WebElement el : elements) {
					System.out.println(el.getAttribute("content-desc"));
					if (el.getAttribute("content-desc").equals("Di")) {
						flag = true;
						break;
					}
				}
				if (flag)
					break;
				else
					scrollDown();
			}

		} catch (Exception e) {
			List<WebElement> elements = driver
					.findElements(AppiumBy.id("com.google.android.apps.tasks:id/task_item_layout"));

			while (true) {
				for (WebElement el : elements) {
					System.out.println(el.getAttribute("content-desc"));
					if (el.getAttribute("content-desc").equals("Di")) {
						flag = true;
						break;
					}
				}
				if (flag)
					break;
				else
					scrollDown();
			}
		}
		return flag;
	}
	
	/*
	 * public void completedtask(String selectlisttext, String deletetasktext)
	 * throws InterruptedException { selectlist(selectlisttext); try {
	 * Thread.sleep(2000); driver.findElement(AppiumBy
	 * .xpath("//android.widget.FrameLayout[@content-desc='Create Automation Script']/android.view.ViewGroup"
	 * )) .click(); Thread.sleep(2000); driver.findElement(By.id(
	 * "com.google.android.apps.tasks:id/edit_task_complete_button")).click();
	 * Thread.sleep(2000);
	 * 
	 * } catch (Exception e) { e.printStackTrace(); } }
	 */

	/*
	 * public void scroll(double start_xd, double start_yd, double end_xd, double
	 * end_yd) throws InterruptedException {
	 * 
	 * org.openqa.selenium.Dimension dimension = driver.manage().window().getSize();
	 * int start_x = (int) (dimension.width * start_xd); int start_y = (int)
	 * (dimension.width * start_yd);
	 * 
	 * int end_x = (int) (dimension.width * end_xd); int end_y = (int)
	 * (dimension.width * end_yd);
	 * 
	 * TouchAction touchAction = new TouchAction(driver);
	 * touchAction.press(PointOption.point(start_x, start_y))
	 * .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2))).moveTo(
	 * PointOption.point(end_x, end_y)) .release().perform(); Thread.sleep(3000); }
	 * 
	 * public void Completedtask(String selectlisttext, String deletetasktext)
	 * throws InterruptedException {
	 * 
	 * try { selectlist(selectlisttext); List<WebElement> elements =
	 * driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/tasks_list")
	 * )
	 * .findElements(AppiumBy.id("com.google.android.apps.tasks:id/task_item_layout"
	 * )); boolean flag = false; do { for (WebElement e : elements) {
	 * System.out.println(e.getAttribute("content-desc"));
	 * System.out.println(deletetasktext); if
	 * (e.getAttribute("content-desc").equalsIgnoreCase(deletetasktext)) { flag =
	 * true; break; } } if (!flag) { scroll(0.5, 0.8, 0.5, 0.2); } } while (!flag);
	 * driver.findElement(By .xpath("//android.widget.FrameLayout[@content-desc=" +
	 * deletetasktext + "]")) .click(); driver.findElement(By.id(
	 * "com.google.android.apps.tasks:id/edit_task_complete_button")).click(); }
	 * catch (Exception e) { System.out.println("No element found"); } }
	 */
	//

	/*
	 * String direction = "UP"; double percentdistance = 0.5;
	 * 
	 * for (int i = 0; i <= 25; i++) { System.out.println(i); if
	 * (driver.findElement(By.xpath(
	 * "//android.widget.FrameLayout[@content-desc=\"Di\"]")).isDisplayed()) {
	 * return true; } int deviceHeight =
	 * driver.manage().window().getSize().getHeight(); int deviceWidth =
	 * driver.manage().window().getSize().getWidth(); Point midPoint = new
	 * Point((int) (deviceWidth * 0.5), (int) (deviceHeight * 0.5)); int top =
	 * midPoint.y - (int) ((deviceHeight * percentdistance) * 0.5); int bottom =
	 * midPoint.y + (int) ((deviceHeight * percentdistance) * 0.5); int left =
	 * midPoint.x - (int) ((deviceWidth * percentdistance) * 0.5); int right =
	 * midPoint.x + (int) ((deviceWidth * percentdistance) * 0.5); Duration
	 * SCROLL_DUR = Duration.ofMillis(1000); if (direction.equalsIgnoreCase("UP")) {
	 * mSwipe(new Point(midPoint.x, top), new Point(midPoint.x, bottom),
	 * SCROLL_DUR); } else if (direction.equalsIgnoreCase("DOWN")) { mSwipe(new
	 * Point(midPoint.x, bottom), new Point(midPoint.x, top), SCROLL_DUR); } else if
	 * (direction.equalsIgnoreCase("LEFT")) { mSwipe(new Point(left, midPoint.y),
	 * new Point(right, midPoint.y), SCROLL_DUR); } else if
	 * (direction.equalsIgnoreCase("RIGHT")) { mSwipe(new Point(right, midPoint.y),
	 * new Point(left, midPoint.y), SCROLL_DUR); } } return false; }
	 * 
	 * // driver.findElement(AppiumBy.androidUIAutomator( // // "new
	 * UiScrollable(new // UiSelector().scrollable(true).resourceId(\
	 * "com.google.android.apps.tasks:id/tasks_list\")).scrollIntoView(new //
	 * UiSelector().resourceId(\
	 * "com.google.android.apps.tasks:id/task_item_layout\").description(\"Di\"))"
	 * // .click(); }
	 * 
	 * protected void mSwipe(Point start, Point end, Duration duration) {
	 * PointerInput input = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
	 * Sequence swipe = new Sequence(input, 0);
	 * swipe.addAction(input.createPointerMove(Duration.ZERO,
	 * PointerInput.Origin.viewport(), start.x, start.y));
	 * swipe.addAction(input.createPointerDown(PointerInput.MouseButton.LEFT.asArg()
	 * )); duration = duration.dividedBy(3);
	 * swipe.addAction(input.createPointerMove(duration,
	 * PointerInput.Origin.viewport(), end.x, end.y));
	 * swipe.addAction(input.createPointerUp(PointerInput.MouseButton.LEFT.asArg()))
	 * ; driver.perform(ImmutableList.of(swipe));
	 * 
	 * }
	 */
	
}

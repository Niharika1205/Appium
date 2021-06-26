package practise.AppiumBasics;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;

import org.openqa.selenium.WebElement;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import practise.AppiumFrame.Base;

import static java.time.Duration.ofSeconds;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class SwipeDemo extends Base {

	public static void main(String[] args) {
		AndroidDriver<AndroidElement> driver = capabilites("ApiDemoApp","emulator");
		
		driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
		driver.findElementByAndroidUIAutomator("text(\"Date Widgets\")").click();
		driver.findElementByAndroidUIAutomator("text(\"2. Inline\")").click();
		driver.findElementByXPath("//*[@content-desc='3']").click();
		WebElement fromEle = driver.findElementByXPath("//*[@content-desc='15']");
		WebElement toEle = driver.findElementByXPath("//*[@content-desc='45']");
		
		@SuppressWarnings("rawtypes")
		TouchAction t = new TouchAction(driver);
		t.longPress(longPressOptions().withElement(element(fromEle)).
				withDuration(ofSeconds(2))).moveTo(element(toEle)).release().perform();
		
	}
}

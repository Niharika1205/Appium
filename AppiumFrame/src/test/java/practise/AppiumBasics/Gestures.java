package practise.AppiumBasics;
import org.openqa.selenium.WebElement;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import practise.AppiumFrame.Base;

import static java.time.Duration.ofSeconds;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class Gestures extends Base{
	
	public static void main(String[] args) {
	AndroidDriver<AndroidElement> driver = capabilites("ApiDemoApp","emulator");
	driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
	@SuppressWarnings("rawtypes")
	TouchAction t = new TouchAction(driver);
	WebElement expandList = driver.findElementByXPath("//android.widget.TextView[@text='Expandable Lists']");
	t.tap(tapOptions().withElement(element(expandList))).perform();
	
	driver.findElementByXPath("//android.widget.TextView[@text='1. Custom Adapter']").click();
	WebElement peeps = driver.findElementByXPath("//android.widget.TextView[@text='People Names']");
	
	t.longPress(longPressOptions().withElement(element(peeps)).withDuration(ofSeconds(2))).release().perform();
	System.out.println(driver.findElementByXPath("//android.widget.TextView[@text='Sample menu']").isDisplayed());
	
	}
}

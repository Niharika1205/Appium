package practise.AppiumFrame;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

import org.openqa.selenium.WebElement;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Utilities {
	
	AndroidDriver<AndroidElement> driver;
	
	public Utilities (AndroidDriver<AndroidElement> driver){
		this.driver=driver;
	}

	public void scrollToText(String text) {
		driver.findElementByAndroidUIAutomator
		("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"));");
	}
	
	public void longPress(WebElement ele) {
		TouchAction t = new TouchAction(driver);
		t.longPress(longPressOptions().withElement(element(ele)).withDuration(ofSeconds(2))).release().perform();
	}
	
	public void tap(WebElement ele){
		TouchAction t = new TouchAction(driver);		
		t.tap(tapOptions().withElement(element(ele))).perform();
	}
}

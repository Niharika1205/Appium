package practise.AppiumBasics;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import practise.AppiumFrame.Base;

public class Scroll extends Base{	
	
	public static void main(String[] args) {
		AndroidDriver<AndroidElement> driver = capabilites("ApiDemoApp","emulator");
		driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
		//driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollIntoView(text(\"WebView\"))");
		
		driver.findElementByAndroidUIAutomator
		("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));");
	}

}

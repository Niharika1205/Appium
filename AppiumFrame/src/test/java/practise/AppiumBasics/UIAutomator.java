package practise.AppiumBasics;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import practise.AppiumFrame.Base;

public class UIAutomator extends Base{
	public static void main(String[] args){
		AndroidDriver<AndroidElement> driver = capabilites("ApiDemoApp", "emulator");
		
		driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
		System.out.println(driver.findElementsByAndroidUIAutomator("new UiSelector().clickable(true)").size());
	}
}

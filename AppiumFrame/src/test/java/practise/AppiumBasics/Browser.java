package practise.AppiumBasics;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import practise.AppiumFrame.Base;

public class Browser extends Base{

	public static void main(String[] args) {
		AndroidDriver<AndroidElement> driver = capabilitiesBrowser();
		driver.get("https://www.google.com/");
	}
}

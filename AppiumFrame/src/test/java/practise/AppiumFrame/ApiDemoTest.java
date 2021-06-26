package practise.AppiumFrame;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import static io.appium.java_client.touch.offset.ElementOption.element;

public class ApiDemoTest extends Base{
	
	@Test
	
		public void dragAndDropTest() {
		service = startServer();
		AndroidDriver<AndroidElement> driver = capabilites("ApiDemoApp","emulator");
		
		driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
		driver.findElementByAndroidUIAutomator("text(\"Drag and Drop\")").click();
		
		WebElement source = driver.findElementsByClassName("android.view.View").get(0);
		WebElement dest = driver.findElementsByClassName("android.view.View").get(1);
		
		@SuppressWarnings("rawtypes")
		TouchAction t = new TouchAction(driver);
		t.longPress(element(source)).moveTo(element(dest)).release().perform();
		service.stop();
	}

}

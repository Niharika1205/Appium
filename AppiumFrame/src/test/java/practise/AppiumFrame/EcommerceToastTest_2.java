package practise.AppiumFrame;
import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class EcommerceToastTest_2 extends Base{

	public static void main(String[] args) {
		AndroidDriver<AndroidElement> driver = capabilites("GeneralStoreApp","emulator");
		
		//driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Hello");
		//driver.hideKeyboard();
		driver.findElement(By.xpath("//*[@text='Female']")).click();
		driver.findElement(By.id("android:id/text1")).click();
		driver.findElementByAndroidUIAutomator
		("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));");
		driver.findElement(By.xpath("//*[@text='Argentina']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		String toastMsg = driver.findElement(By.xpath("//android.widget.Toast[1]")).getAttribute("name");
		System.out.print(toastMsg);
		
	}
}

package practise.AppiumBasics;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import practise.AppiumFrame.Base;

public class MobileBrowse extends Base{

	public static void main (String[] args) {
		AndroidDriver<AndroidElement> driver = capablitiesMobileWeb();
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector(".navbar-toggler")).click();
		driver.findElement(By.cssSelector("a[href*='products']")).click();
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scroll(0,1000)", "");	
		
		String text = driver.findElement(By.xpath("(//li[@class='list-group-item'])[3]/div/div/a")).getText();
		System.out.println(text);
	}
}

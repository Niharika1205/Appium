package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FormPage {

	public FormPage(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver) , this);
	}
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/nameField")
	public WebElement nameField;
	
	@AndroidFindBy(xpath = "//*[@text='Female']")
	private WebElement genderBtn;
	
	@AndroidFindBy(id = "android:id/text1")
	public WebElement txtField;
	
	@AndroidFindBy(xpath = "//*[@text='Argentina']")
	public WebElement countryDropDown;
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/btnLetsShop")
	public WebElement shopBtn;
	
	public WebElement getGenderBtn () {
		System.out.println("Use this if you need to log in a framework or you want to keep elements private");
		return genderBtn;
	}
}

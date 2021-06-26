package practise.AppiumFrame;
import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pageObjects.CheckoutPage;
import pageObjects.FormPage;
import pageObjects.ProductPage;

public class EcommerceTest_4 extends Base{

	@BeforeTest
	public void killAllNodes()
	{
		try {
			Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\killNodes.bat");
			Thread.sleep(6000);
			
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test(dataProvider = "ApiDemoData", dataProviderClass = TestData.class)
	public  void totalValidation(String input) throws InterruptedException {
		service = startServer();
		AndroidDriver<AndroidElement> driver = capabilites("GeneralStoreApp", "emulator");
		FormPage formPageObj = new FormPage(driver);
		formPageObj.nameField.sendKeys(input);
		driver.hideKeyboard();
		formPageObj.getGenderBtn().click();
		formPageObj.txtField.click();
		Utilities utilObj = new Utilities(driver);
		utilObj.scrollToText("Argentina");		
		formPageObj.countryDropDown.click();
		formPageObj.shopBtn.click();
		
		ProductPage prodObj = new ProductPage(driver);
		prodObj.productList.get(0).click();
		prodObj.productList.get(0).click();
		prodObj.cartBtn.click();
				
		Thread.sleep(5000);
		CheckoutPage checkObj = new CheckoutPage(driver);
		int count = checkObj.productList.size();
		Double sum = 0.0;
		for(int i=0; i<count; i++) {
			String price = checkObj.priceList.get(i).getText();
			double priceFin = getAmount(price);
			sum = sum + priceFin;
		}
		
		String totalPrice = checkObj.totalPrice.getText();
		double totalFinPrice = getAmount(totalPrice);
		
		System.out.println("Sum of total Price is :: " + sum);
		System.out.print("Total Price is :: " + totalFinPrice);
		
		//Mobile Gestures		
		
		utilObj.tap(checkObj.termsCheckbox);
		utilObj.longPress(checkObj.termsPopup);
		checkObj.closeBtn.click();
		checkObj.proceedBtn.click();
		//service.stop();
		stopServer();
	}
	
	public static double getAmount(String price) {
		price = price.substring(1);
		Double priceFin = Double.parseDouble(price);
		return priceFin;
	}
}

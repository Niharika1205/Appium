package practise.AppiumFrame;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.TakesScreenshot;

public class Base {
	
	public static AppiumDriverLocalService service;
	public static AndroidDriver<AndroidElement> driver = null;
	
	public static AppiumDriverLocalService startServer() {
		Boolean flag = checkIfServerIsRunning(4723);
		if (!flag) {
		service = AppiumDriverLocalService.buildDefaultService();
		service.start();
		}
		return service;
	}
	
	public static Boolean checkIfServerIsRunning(int port) {
		boolean isServerRunning = false;
		ServerSocket serverSocket;
		
		try { 
			serverSocket = new ServerSocket(port);
			serverSocket.close();
		} catch(IOException e) {
			isServerRunning = true;
		} finally {
			serverSocket = null;
		}
		return isServerRunning;
	}
	
	public static void stopServer() {
		boolean flag = checkIfServerIsRunning(4723);
		if (flag) {
			AppiumDriverLocalService service = AppiumDriverLocalService.buildDefaultService();
			service.stop();
		}
	}
	
	public static void startEmulator() {
		try {
			Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\startEmulator.bat");
			Thread.sleep(6000);
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}
	public static AndroidDriver<AndroidElement> capabilites(String appName, String device) {
		
		
		try {
			String basePath = System.getProperty("user.dir");
			FileInputStream fis = new FileInputStream(basePath + "\\src\\main\\java\\practise\\AppiumFrame\\global.properties");
			Properties prop = new Properties();
			prop.load(fis );
			
			File f = new File("src");
			File fs = new File(f, (String) prop.get(appName));
			DesiredCapabilities cap = new DesiredCapabilities();
			String deviceName = System.getProperty("deviceName");
					//(String) prop.get(device);
			if (device.equals("emulator")) {				
				startEmulator();
				cap.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
			} else if (device.equals("real")) {

				cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
			}
			cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");// new step
			cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
			cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 14);//wait time for elements
			
			driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		} catch (IOException e) {
			e.getMessage();
		}
		return driver;
	}

	public static AndroidDriver<AndroidElement> capabilitiesBrowser() {
		AndroidDriver<AndroidElement> driver = null;
		try {
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
			cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
			driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		} catch (MalformedURLException e) {
			e.getMessage();
		}
		return driver;
	}
	
	public static AndroidDriver<AndroidElement> capablitiesMobileWeb() {
		AndroidDriver<AndroidElement> driver = null;
		try {
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus 6 API 30");
			cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
			cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
			cap.setCapability("chromedriverExecutable", "C:\\Users\\nihar\\eclipse-workspace\\AppiumPrac\\src\\chromedriver.exe");
			driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
			
			
		} catch(MalformedURLException e) {
			e.getMessage();
		}
		return driver;
	}
	
	
	
	public static void getScreenshot(String fileName) {
		File scr =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scr, new File(System.getProperty("user.dir")+"//src//main//java//screenshots//"+ fileName + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

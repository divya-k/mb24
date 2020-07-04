package tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class BaseClass {
	
AppiumDriver<MobileElement> driver;
	
	@BeforeMethod
	public void setup() {
		
		DesiredCapabilities cap = new DesiredCapabilities();
		
		cap.setCapability("deviceName", "Pixel_XL");
		cap.setCapability("platformName", "Android");
		cap.setCapability("automationName", "UiAutomator2");
		cap.setCapability("noReset", "false");
		cap.setCapability("app", System.getProperty("user.dir") + "/src/test/resources/apps/original.apk");
		//cap.setCapability("appPackage", "com.amazon.mShop.android.shopping");
		//cap.setCapability("appActivity", "com.amazon.mShop.home.HomeActivity");
		
		
		try{
			driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), cap);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}catch(MalformedURLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}

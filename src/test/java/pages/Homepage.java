package pages;

import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class Homepage {

	AndroidDriver<MobileElement> driver;
	String searchBar = "com.amazon.mShop.android.shopping:id/rs_search_src_text";
	
	public Homepage(AppiumDriver<MobileElement> driver) {
		this.driver = (AndroidDriver<MobileElement>) driver;
	}
	
	
	// Enter the search text into the search bar and hit enter
	
	public void enterSearchText(String searchText) {
		driver.findElement(By.id(searchBar)).click();
		driver.findElement(By.id(searchBar)).sendKeys(searchText);
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		
	}
}

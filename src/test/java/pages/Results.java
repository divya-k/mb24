package pages;

import java.util.List;
import java.util.Set;

import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.touch.TouchActions;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Results {

	AndroidDriver<MobileElement> driver;
	String searchResults = "search";
	
	public Results(AppiumDriver<MobileElement> driver) {
		this.driver = (AndroidDriver<MobileElement>) driver;
	}
	
	
	// Taps on a random result on the result page
	
	public String tapOnAResult() {
		
		MobileElement el = driver.findElement(By.xpath("//android.view.View[@resource-id='" + searchResults + "']"));
		List<MobileElement> results = el.findElements(By.className("android.view.View"));
		int rand = (int)(Math.random() * 4);
		rand = ((rand+1) * 9) - 2;
		rand  = 17;
		el = results.get(rand);
		String productName = el.getText();
		el.click();
		return productName;
		
	}
}

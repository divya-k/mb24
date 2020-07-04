package pages;

import java.util.List;

import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class CartPage {

	AndroidDriver<MobileElement> driver;
	String checkout = "sc-mini-buy-box";
	String cart = "activeCartViewForm";
	String deleteButton = "a-autoid-2";
	
	
	public CartPage(AppiumDriver<MobileElement> driver) {
		this.driver = (AndroidDriver<MobileElement>) driver;
	}
	
	
	// Returns the name of the item that is present in the cart
	
	public String getCartItem() {
		MobileElement el = driver.findElement(By.xpath("//android.view.View[@resource-id='" + cart + "']"));
		List<MobileElement> els = el.findElements(By.className("android.view.View"));
		return els.get(3).getText();
	}
	
	// Removes the item from the cart
	
	public void deleteItem() {
		MobileElement el = driver.findElement(By.xpath("//android.view.View[@resource-id='" + deleteButton + "']"));
		el.findElementByClassName("android.widget.Button").click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	// Return true  if the Checkout button is displayed on the view, else returns false
	
	public boolean isCheckoutButtonPresent() {
		try{
			driver.findElement(By.xpath("//android.view.View[@resource-id='" + checkout + "']"));
			return true;
		} catch(Exception e) {
			return false;
		}
	}
}

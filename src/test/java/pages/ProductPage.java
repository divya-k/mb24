package pages;

import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;

public class ProductPage {

	AndroidDriver<MobileElement> driver;
	String buyButton = "buyNowCheckout";
	String addToCartButton = "add-to-cart-button";
	String productName = "title";
	String cart = "Basket";
	
	public ProductPage(AppiumDriver<MobileElement> driver) {
		this.driver = (AndroidDriver<MobileElement>) driver;
	}
	
	
	// Returns the name of the product that is displayed 
	
	public String getProductName() {
		return driver.findElement(By.xpath("//android.view.View[@resource-id='" + productName + "']")).getText();
	}
	
	
	// Brings the Buy Now button and Add to Cart button into the view by swiping up
	
	public void adjustView() {
		TouchAction action = new TouchAction(driver);
		action.press( PointOption.point(200, 800) );
		action.moveTo( PointOption.point(200, 400) );
		action.release();
		action.perform();
	}
	
	
	// Taps on the Buy Now button
	
	public void tapBuyButton() {		
		driver.findElementById(buyButton).click();;
	}
	
	
	// Tap on the Add to Cart button
	
	public void tapAddToCartButton() {
		driver.findElement(By.xpath("//android.widget.Button[@resource-id='" + addToCartButton + "']")).click();;
	}
	
	
	// Taps on the Basket icon to go to the Cart view
	
	public void goToCart() {
		driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='" + cart + "']")).click();
	}
}

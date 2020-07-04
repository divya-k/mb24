package pages;

import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class SignInPage {

	AndroidDriver<MobileElement> driver;
	String signInButton = "com.amazon.mShop.android.shopping:id/sign_in_button";
	String skipSignInButton = "com.amazon.mShop.android.shopping:id/skip_sign_in_button";
	String emailTextField = "ap_email_login";
	String passwordTextField = "ap_password";
	String continueButton = "continue";
	String signInSubmitButton = "signInSubmit";
	
	public SignInPage(AppiumDriver<MobileElement> driver) {
		this.driver = (AndroidDriver<MobileElement>) driver;
	}
	
	
	// Taps on the Sign-In button on the first view
	
	public void tapSignInButton() {
		driver.findElement(By.id(signInButton)).click();
	}
	
	
	// Taps on the skip Sign-In button on the first view
	
	public void tapSkipSignInButton() {
		driver.findElement(By.id(skipSignInButton)).click();
	}
	
	
	// Enter the email ID and the password in the relevant fields
	
	public void enterLoginDetails(String email, String password) {

		driver.findElement(By.xpath("//android.widget.EditText[@resource-id='" + emailTextField + "']")).sendKeys(email);
		tapContinueButton();
		driver.findElement(By.xpath("//android.widget.EditText[@resource-id='" + passwordTextField + "']")).sendKeys(password);
	}
	
	
	// Tap on the Continue button to go to the password view
	
	public void tapContinueButton() {
		driver.findElement(By.xpath("//android.widget.Button[@resource-id='" + continueButton + "']")).click();
	}
	
	
	// Tap on the Submit button to finalize the login process
	
	public void tapSubmitButton() {
		driver.findElement(By.xpath("//android.widget.Button[@resource-id='" + signInSubmitButton + "']")).click();
	}
}

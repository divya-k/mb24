package tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertFalse;

import pages.CartPage;
import pages.Homepage;
import pages.ProductPage;
import pages.SignInPage;
import pages.Results;

public class PurchaseTest extends BaseClass {

	@Test
	@Parameters({"username", "password", "searchText"})
	public void purchaseFlowTest(String username, String password, String searchText) {
		
		// Instantiate the pages that will be used in this test 
		
		Homepage homepageObj = new Homepage(driver);
		SignInPage signInPageObj = new SignInPage(driver);
		Results resultsObj = new Results(driver);
		ProductPage productObj = new ProductPage(driver);
		CartPage cartObj = new CartPage(driver);
		
		
		// Login to the app using the credentials passed by the testng XML file
		
		signInPageObj.tapSignInButton();
		signInPageObj.enterLoginDetails(username, password);
		signInPageObj.tapSubmitButton();
		
		
		// Search for the query passed by the testng XML file
		
		homepageObj.enterSearchText(searchText);
		
		
		// Tap on a random search result and save its name
		
		String productName = resultsObj.tapOnAResult();
		
		// Verify that the product name displayed on the product details page is same as the name
		// that was mentioned on the results page 
		
		assertTrue(productObj.getProductName().contains(productName));
		
		
		// Add the product to the cart and go to the cart view
		
		productObj.adjustView();
		productObj.tapAddToCartButton();
		productObj.goToCart();
		
		
		// Verify that the product is present in the cart and the Checkout button is present
		
		assertTrue(cartObj.isCheckoutButtonPresent());
		String str = cartObj.getCartItem();
		assertTrue(productName.contains(str.substring(0, str.length()-4)));
		
		
		// Remove the product item from the cart and verify that it is removed
		
		cartObj.deleteItem();
		assertFalse(cartObj.isCheckoutButtonPresent());
	}
}

package pageObjectsTakeAlot;

import org.openqa.selenium.By;
import org.testng.Reporter;

import frameWorkClasses.BasePage;

public class CartPage extends BasePage {
	
	//CheckCartEmpty
	public boolean checkEmptyCart() {
		String itemElement = "img[alt='Empty shopping cart']";
		if (driver.findElements(By.cssSelector(itemElement)).size() != 0) {
			System.out.println("Element exists");
			Reporter.log("Element exists " +itemElement);
			Reporter.log("Text is " + getElementText(By.cssSelector(itemElement)));
			return true;
		} else {
			System.out.println("Element does not exist");
			Reporter.log("Element does not exist " +itemElement);
			Reporter.log("Text is " + getElementText(By.cssSelector(itemElement)));
			return false;
		}
	}
	
	public boolean checkEmptyCartWithDisplayed() {
		String itemElement = "img[alt='Empty shopping cart']";
		Boolean Display = elementExists(By.cssSelector(itemElement));
		return Display;
	}
	
	//Ensure shopping cart is empty
	public boolean CheckCartTotalAmt(String CheckAmt) throws InterruptedException{
		String itemElement = ".cart-summary-module_cart-summary-items-cost_2gFl4 .currency-module_currency_29IIm";
		System.out.println(CheckAmt);
		if (getElementText(By.cssSelector(itemElement)).contains(CheckAmt))
		{
			Reporter.log("Amount Correct " + CheckAmt);
			Reporter.log("Amount is " + getElementText(By.cssSelector(itemElement)));
			return true;
		}
		Reporter.log("Amount is incorrect " + CheckAmt);
		Reporter.log("The amount is " + getElementText(By.cssSelector(itemElement)));
		return false;
		
	}
	
	//Change quantity
	public void SelectQuantity(String qunt) {
		selectDropDown(By.id("cart-item_undefined"), qunt);
		
	}
	
	//Checkout 
	
	//Delete item
	public void removeFromCart() {
		clickElement(By.cssSelector(".button.clear.remove-item"));
	}
}

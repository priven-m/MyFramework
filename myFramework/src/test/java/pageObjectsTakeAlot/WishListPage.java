package pageObjectsTakeAlot;

import org.openqa.selenium.By;
import org.testng.Reporter;

import frameWorkClasses.BasePage;

public class WishListPage extends BasePage {

	// Delete item
	public void removeFromWishList() {
		clickElement(By.cssSelector(
				".detail-item-module_item_1RcyR.item-72869404 > .grid-padding-x.grid-x svg[role='presentation']"));
	}

	// Check item exists
	public boolean checkitemExistsInWishList() {
		String itemElement = ".detail-item-module_product-anchor_13g49.product-anchor";
		Boolean Display = elementExists(By.cssSelector(itemElement));
		return Display;
	}

	// CheckCartEmpty
	public boolean checkEmptyWishList() {
		String itemElement = "img[alt='This list is empty']";
		if (driver.findElements(By.cssSelector(itemElement)).size() != 0) {
			System.out.println("Element exists");
			Reporter.log("Element exists " + itemElement);
			Reporter.log("Text is " + getElementText(By.cssSelector(itemElement)));
			return true;
		} else {
			System.out.println("Element does not exist");
			Reporter.log("Element does not exist " + itemElement);
			Reporter.log("Text is " + getElementText(By.cssSelector(itemElement)));
			return false;
		}
	}
}

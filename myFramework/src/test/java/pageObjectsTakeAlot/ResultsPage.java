package pageObjectsTakeAlot;

import org.openqa.selenium.By;
import org.testng.Reporter;

import frameWorkClasses.BasePage;

public class ResultsPage extends BasePage {

	// String variables for the products we are searching
	String DKNYcss = "div:nth-of-type(2) > .grid.search-product  .product-anchor.product-card-module_product-anchor_TUCBV";
	String RCTcss = "div:nth-of-type(1) > .grid.search-product  .product-anchor.product-card-module_product-anchor_TUCBV";
	String Asuscss = "div:nth-of-type(7) > .grid.search-product  .product-anchor.product-card-module_product-anchor_TUCBV";

	// after clicking the prodct, it will be opened in a new tab
	public void clickElementTextOfRCTItem() {
		clickElement(By.cssSelector(RCTcss));
	}

	// Get and sysout text of the product opened in a new window (RCTItem)
	public String getTextOfRCTItem() {
		String actualText = getElementText(By.cssSelector(".title-content-list a"));
		return actualText;
	}

	public void clickAddToCart() {
		clickElement(By.cssSelector(".buybox-actions-module_add-to-cart-cell_3fXyS [data-ref]"));
	}

	public void ClickGoToCart() {
		clickElement(By.cssSelector(".content-wrapper .checkout-now"));
	}

	public String CheckElementTextInCart() {
		String actualText = getElementText(By.cssSelector("a > .cart-item-module_item-title_1M9cq"));
		return actualText;
	}

	public int GetUnitPrice() {
		String unitPriceString = getElementText(By.cssSelector(".buybox-module_price_2YUFa > .currency.currency-module_currency_29IIm.plus"));
		String unitPrice = unitPriceString.replaceAll("\\D", "");
		//String unitPriceRstripped = unitPriceString.substring(2);
		//String unitPrice = unitPriceRstripped.replaceAll(",", "");
		int unitPriceInt = Integer.parseInt(unitPrice);
		return unitPriceInt;
	}

	// after clicking the prodct, it will be opened in a new tab
	public void clickElementTextOfDKNYItem() {
		clickElement(By.cssSelector(DKNYcss));
	}

	// Get and sysout text of the product opened in a new window (DKNYItem)
	public String getTextOfDKNYElement() {
		String actualText = getElementText(By.cssSelector(".title-content-list a"));
		return actualText;
	}
	
	// Asus Zenbook
	
	public void clickAsusZenbook() {
		clickElement(By.cssSelector(Asuscss));
	}
	public String getTextOfAsusItem() {
		String actualText = getElementText(By.cssSelector(".title-content-list a"));
		return actualText;
	}
	public void clickAddToList() {
		clickElement(By.cssSelector(".button.shade-gray.wishlist-button.wishlist-split-button-module_wishlist-button_36rqk > .wishlist-split-button-module_text_E0HQC"));
	}

	public void ClickGotToWishList() {
		clickElement(By.cssSelector(".icon-link.top-nav-module_wishlist-button_mIJ0_.wish > svg[role='presentation'] > path"));
	}

	
	


}


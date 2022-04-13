package pageObjectsTakeAlot;

import org.openqa.selenium.By;

import frameWorkClasses.BasePage;

public class ResultsPage extends BasePage{
	
	//String variables for the products we are searching
	String DKNYcss = "div:nth-of-type(2) > .grid.search-product  .product-anchor.product-card-module_product-anchor_TUCBV";
	String RCTcss = "div:nth-of-type(1) > .grid.search-product  .product-anchor.product-card-module_product-anchor_TUCBV";
	
	//after clicking the prodct, it will be opened in a new tab
	public void clickElementTextOfRCTItem() {
		clickElement(By.cssSelector(RCTcss));
	}
	
	//Get and sysout text of the product opened in a new window (RCTItem)
	public String getTextOfRCTItem() {
		String txt1 = getElementText(By.cssSelector(".title-content-list a"));
		System.out.println(txt1);
		return txt1;
	}
	
	//after clicking the prodct, it will be opened in a new tab
	public void clickElementTextOfDKNYItem() {
	clickElement(By.cssSelector(DKNYcss));
	}
	
	//Get and sysout text of the product opened in a new window (DKNYItem)
	public String getTextOfDKNYElement() {
		String txt1 = getElementText(By.cssSelector(".title-content-list a"));
		System.out.println(txt1);
		return txt1;
	}
	}

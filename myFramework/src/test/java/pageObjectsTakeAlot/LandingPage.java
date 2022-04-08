package pageObjectsTakeAlot;

import org.openqa.selenium.By;

import frameWorkClasses.BasePage;

public class LandingPage extends BasePage {

//	landPG.checkLandingPageNavigation();
	// landPG.selectItem(“DailyDeals”);
	// dealsPG.checkURL(“Takealot/deals”);
	// dealsPG.checkFirstItem(“PhillipAirFryer”);

	public boolean checkLandingPageNavigation() {
		return false;

	}

	public void clickSearchBar() {
		clickElement(By.cssSelector("input[name='search']"));
	}

	public void clickSearchButton() {
		clickElement(By.cssSelector("button[type='submit']"));
	}

	public void enterTextInSearchBar(String searchText) {
		enterText(By.name("search"), searchText);

	}

	public String checkElementTextOfFirstItem() {
		String text1 = getElementText(By.cssSelector(
				"div:nth-of-type(2) > .grid.search-product  .product-anchor.product-card-module_product-anchor_TUCBV.sponsored"));
		return text1;
	}

	public void clickElementTextOfFirstItem() {
		clickElement(By.cssSelector(
				"div:nth-of-type(2) > .grid.search-product  .product-anchor.product-card-module_product-anchor_TUCBV.sponsored"));
	}

	public boolean checkFirstItem(String checkFirstItem) {
		return false;
	}

	public void selectItem(String selectItem) {

	}

	// landPG.searchFor(“DKNY”);
	// landPG.clickOnSearch();
	// landPG.checkFirstItem(“DKNY”);

	public void searchFor(String searcFor) {

	}

}

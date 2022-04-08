package takeAlotTests;

import org.testng.annotations.Test;

import pageObjectsTakeAlot.BasePageTakeAlot;
import pageObjectsTakeAlot.CartPage;
import pageObjectsTakeAlot.CheckoutPage;
import pageObjectsTakeAlot.LandingPage;
import pageObjectsTakeAlot.LoginPage;

public class TestsTakeAlot {
	
	//Instantiate the Landing Page
	LandingPage lndPge = new LandingPage();
	
	//Instantiate the Login Page
	LoginPage lgnPge = new LoginPage();
	
	//Instantiate the Checkout Page
	CheckoutPage chktPge = new CheckoutPage();
	
	//Instantiate the Cart Page
	CartPage cartPge = new CartPage();
	
	//Instantiate the Cart Page
	BasePageTakeAlot basePageTA = new BasePageTakeAlot(); 

	@Test
	public void GIVEN_shopperIsOnLandingPage_WHEN_shopperEntersDKNUasSearchString_AND_shopperClicksTheSearchButton_THEN_DKNYBeDelicious() {
		basePageTA.goHome();
		lndPge.clickSearchBar();
		lndPge.enterTextInSearchBar("DKNY");
		lndPge.clickSearchButton();
		//System.out.println("Test passed " + lndPge.checkElementTextOfFirstItem());
		lndPge.clickElementTextOfFirstItem();
	/*2
	* GIVEN the shopper is on the landing page
	* WHEN he enters "DKNY" as the search string
	* WHEN clicks the search button
	* THEN "DKNY" is displayed as the first item in the grid
	* WHEN going to home page
	*/
		
	}
	
	@Test 
	 public void GIVEN_ShopperOnLandingPage_WHEN_selectDailyDeals_THEN_DailyScreenOpen_AND_PhillipsAirfryerFirstItemDislayed() {
		
		//  GIVEN
		//		Given the shopper is on the Landing page
		//	WHEN
		//		He selects daily deals
		//	THEN
		//		The Daily deals URL
		//	AND
		//		First displayed item is Phillips XXL Airfryer
		//
		//	GIVEN_ShopperOnLandingPage_WHEN_selectDailyDeals_THEN_DailyScreenOpen_AND_PhillipsAirfryerFirstItemDislayed(){
		//	landPG.checkLandingPageNavigation();
		//	landPG.selectItem(“DailyDeals”);
		//	dealsPG.checkURL(“Takealot/deals”);
		//	dealsPG.checkFirstItem(“PhillipAirFryer”);

	}
}

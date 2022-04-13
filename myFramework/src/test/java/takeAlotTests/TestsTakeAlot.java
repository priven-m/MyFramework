package takeAlotTests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjectsTakeAlot.BasePageTakeAlot;
import pageObjectsTakeAlot.CartPage;
import pageObjectsTakeAlot.CheckoutPage;
import pageObjectsTakeAlot.LandingPage;
import pageObjectsTakeAlot.LoginPage;
import pageObjectsTakeAlot.ResultsPage;

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
	BasePageTakeAlot basePgeTakeAlot = new BasePageTakeAlot(); 
	
	//instantiate
	ResultsPage resPge = new ResultsPage(); 

	@BeforeTest
	public void SetUp() {
		lndPge.ClickCookiesButton();
		//lndPge.ClickCookiesButton1();
	}
	
	@Test
	public void GIVEN_shopperIsOnLandingPage_WHEN_shopperEntersDKNUasSearchString_AND_shopperClicksTheSearchButton_THEN_DKNYBeDeliciousReturned() {
		//We ensure we are on the takealot homepage our landingpage
		basePgeTakeAlot.goHome();
		
		//From landing page we can use the methods in there to clicksearchbar, enterTextInSearchBar and ClickSearchButton
		lndPge.clickSearchBar();
		lndPge.enterTextInSearchBar("DKNY");
		lndPge.clickSearchButton();
		
		//Once SearchButtonIsClicked, we now look for the product in our ResultsPage and use methods in there.
		resPge.clickElementTextOfDKNYItem();
		resPge.SwitchToNewTab();
		resPge.getTextOfDKNYElement();
	}
	
	@Test 
	 public void GIVEN_ShopperOnLandingPage_WHEN_shopperEntersRCT3000VASasSearchString_AND_shopperClicksTheSearchButton_THEN_RCT3000upsReturned() {
		basePgeTakeAlot.goHome();
		lndPge.clickSearchBar();
		lndPge.enterTextInSearchBar("rct-3000vas");
		lndPge.clickSearchButton();
		resPge.clickElementTextOfRCTItem();
		resPge.SwitchToNewTab();
		resPge.getTextOfRCTItem();
	}
}

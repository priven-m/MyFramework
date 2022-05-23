 package takeAlotTests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import frameWorkClasses.BasePage;
import pageObjectsTakeAlot.BasePageTakeAlot;
import pageObjectsTakeAlot.CartPage;
import pageObjectsTakeAlot.CheckoutPage;
import pageObjectsTakeAlot.LandingPage;
import pageObjectsTakeAlot.LoginPage;
import pageObjectsTakeAlot.ResultsPage;
import pageObjectsTakeAlot.WishListPage;

public class TestsTakeAlot extends BasePage {

	// Instantiate the Landing Page
	LandingPage lndPge = new LandingPage();

	// Instantiate the Login Page
	LoginPage lgnPge = new LoginPage();

	// Instantiate the Checkout Page
	CheckoutPage chktPge = new CheckoutPage();

	// Instantiate the Cart Page
	CartPage cartPge = new CartPage();

	// Instantiate the Cart Page
	BasePageTakeAlot basePgeTakeAlot = new BasePageTakeAlot();

	// instantiate
	ResultsPage resPge = new ResultsPage();
	
	SoftAssert softAssertion = new SoftAssert();
	
	WishListPage wshlstPge = new WishListPage();

	@BeforeTest
	public void SetUp() {
		lndPge.ClickCookiesButton();
		//lndPge.quizPopUp();
	}
	
	@Test
	public void checkPDF() throws Exception {
		//variable to store where the pdf is 
		String pdfURL = "file:///C:/Users/User/Downloads/Intecon%20Allps-i.pdf";
		
		//check number of pages in the pdf
		//declare a variable for the expected number of pages
		int expectedNoPages = 1;
		
		//Read the contents of the pdf
		String pdfContent = lndPge.readPDFContent(pdfURL, expectedNoPages) ;
		
		//Assert that the pdf contains a certain text
		Assert.assertTrue(pdfContent.contains("MANDATE AND DEBIT ORDER AUTHORIZATION"));
	}

	@Test
	public void GIVEN_shopperIsOnLandingPage_WHEN_shopperEntersDKNYasSearchString_AND_shopperClicksTheSearchButton_THEN_DKNYBeDeliciousReturned() {
		String searchInput = "DKNY";
		String actualText;
		// We ensure we are on the takealot homepage our landingpage
		basePgeTakeAlot.goHome();

		// From landing page we can use the methods in there to clicksearchbar,
		// enterTextInSearchBar and ClickSearchButton
		lndPge.clickSearchBar();
		lndPge.enterTextInSearchBar(searchInput);
		lndPge.clickSearchButton();

		// Once SearchButtonIsClicked, we now look for the product in our ResultsPage
		// and use methods in there.
		resPge.clickElementTextOfDKNYItem();
		resPge.SwitchToNewTab();
		actualText = resPge.getTextOfDKNYElement();
		Reporter.log("The expected value is: " + searchInput);
		Reporter.log("The actaul value is: " + actualText);
		Assert.assertEquals(actualText, searchInput);
	}

	@Test
	public void GIVEN_ShopperOnLandingPage_WHEN_shopperEntersRCT3000VASasSearchString_AND_shopperClicksTheSearchButton_THEN_RCT3000upsReturned() {
		String searchInput = "rct-3000vas";

		basePgeTakeAlot.goHome();
		lndPge.clickSearchBar();
		lndPge.enterTextInSearchBar(searchInput);
		lndPge.clickSearchButton();
		resPge.clickElementTextOfRCTItem();
		resPge.SwitchToNewTab();
		//softAssertion.assertEquals("RCT","rct-3000vas","Soft assertion");
		//Assert.assertEquals(resPge.getTextOfRCTItem(), true);
		
		Reporter.log("The expected value is: " + searchInput);
		Reporter.log("The actual value is: " + resPge.getTextOfRCTItem());
		Assert.assertEquals(searchInput, resPge.getTextOfRCTItem());
		//softAssertion.assertAll("All soft assertions:");
		resPge.closeChildBrowserTab();
	}
	
	@Test
	public void GIVEN_RCTProduct_WHEN_shopperClicksAddToCart_AND_shopperCLicksGotToCart_THEN_ProductIsPrenetInCart() throws InterruptedException {
		String searchInput = "rct-3000vas";
		basePgeTakeAlot.goHome();
		lndPge.clickSearchBar();
		lndPge.enterTextInSearchBar(searchInput);
		lndPge.clickSearchButton();
		resPge.clickElementTextOfRCTItem();
		resPge.SwitchToNewTab();
		//int unitPrice = resPge.GetUnitPrice();
		//System.out.println(unitPrice*3);
		resPge.clickAddToCart();
		resPge.ClickGoToCart();
		Reporter.log("The product in cart is: " + resPge.CheckElementTextInCart());
		Assert.assertEquals(cartPge.CheckCartTotalAmt("R 4,987"), true);
		cartPge.SelectQuantity("2");
		cartPge.SelectQuantity("3");
		cartPge.SelectQuantity("4");
		Thread.sleep(1000);
		cartPge.removeFromCart();
		Assert.assertEquals(cartPge.checkEmptyCart(), true);
		resPge.closeChildBrowserTab();
	}
	@Test
	public void GIVEN_ShopperHasSearchedAsus_WHEN_ShopperIsOnResultsPage_AND_shopperClicksAsusZenBook_THEN_ShopperAddsAsusZenbookToList() throws InterruptedException {
		String searchInput = "asus";
		basePgeTakeAlot.goHome();
		lndPge.clickSearchBar();
		lndPge.enterTextInSearchBar(searchInput);
		lndPge.clickSearchButton();
		resPge.clickAsusZenbook();
		resPge.SwitchToNewTab();
		resPge.clickAddToList();
		resPge.ClickGotToWishList();
		Reporter.log("The product in cart is: " + wshlstPge.checkitemExistsInWishList());
		wshlstPge.removeFromWishList();
		Assert.assertEquals(wshlstPge.checkEmptyWishList(), true);
		resPge.closeChildBrowserTab();
	}
	//@AfterTest
	public void CleanUp() {
	cleanUp();
	}
}

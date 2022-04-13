package pageObjectsTakeAlot;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import frameWorkClasses.BasePage;

public class LandingPage extends BasePage {

	//String variable for the popup we found
	String cookieButton = ".button.cookies-banner-module_dismiss-button_24Z98";
	public void ClickCookiesButton() {
		if (ExpectedConditions.visibilityOfElementLocated(By.cssSelector(cookieButton)) != null)
			clickElement(By.cssSelector(cookieButton));
	}
	
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

	public boolean checkFirstItem(String checkFirstItem) {
		return false;
	}

	public void selectItem(String selectItem) {

	}

	public void searchFor(String searcFor) {

	}
}

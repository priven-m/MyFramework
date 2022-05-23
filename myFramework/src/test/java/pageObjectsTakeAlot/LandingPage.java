package pageObjectsTakeAlot;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import frameWorkClasses.BasePage;

public class LandingPage extends BasePage {

	public void ClickCookiesButton() {
		// String variable for the popup we found
		String cookieButton = ".button.cookies-banner-module_dismiss-button_24Z98";
		try {
		//if (ExpectedConditions.visibilityOfElementLocated(By.cssSelector(cookieButton)) != null)
			clickElement(By.cssSelector(cookieButton));}
		catch(Exception e) {
			System.out.println("cookie not there");
		}
	}

//	public void quizPopUp() {
//		String nextButton = "_hj-3HqTJ__styles__surveyActionButton";
//		try {
//			clickElement(By.className("_hj-2fsWS__styles__closeEndedOptionText"));
//			clickElement(By.className(nextButton));
//			clickElement(By.className(nextButton));
//			clickElement(By.className("_hj-3Y4y-__styles__closeButton"));
//		} catch (Exception e) {
//			System.out.println("survey not there");
//			e.printStackTrace();
//		}
//	}

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

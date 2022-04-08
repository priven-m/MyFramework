package pageObjectsTakeAlot;

import frameWorkClasses.BasePage;

public class BasePageTakeAlot extends BasePage{
	
	//Method: Navigate home
	public void goHome() {
		driver.get("https://www.takealot.com");
		waitForUrl(30, "takealot");
		
	}

}

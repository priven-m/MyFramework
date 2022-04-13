package frameWorkClasses;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	//Declare Webdriver
	public static WebDriver driver;
	
	//constructor
	public BasePage() {
		if (driver == null) {
			//Get Parameter values
			
			//String browser = getDataConfigPropeties("browser");
			//String URL = getDataConfigPropeties("systemUnderTest");
			//String pdriverDir = getDataConfigPropeties("driverdir");
			// String pdriverDirFireFox = getDataConfirgPropeties("driverdirFirefox");
			// String pdriverDirEdge = getDataConfirgPropeties("driverdirEdge");
			String browser = "chrome";
			String URL = "https://www.takealot.com/";
			String pdriverDir = "C:\\Selenium\\";
			
			//check if parameter passed as "chrome"
			if (browser.equalsIgnoreCase("chrome")) {
			//Set path to chromedriver.exe
			System.setProperty("webdriver.chrome.driver", pdriverDir + "chromedriver.exe");
			//create an instance of chrome
			driver = new ChromeDriver();
			driver.get(URL);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			}
			else if (browser.equalsIgnoreCase("firefox")) {
				//Set path to geckodriver.exe
				System.setProperty("webdriver.gecko.driver", pdriverDir+"geckodriver.exe");
				//create an instance of firefox
				driver = new FirefoxDriver();
				driver.get(URL);
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			}
			else if (browser.equalsIgnoreCase("edge")) {
				//Set path to MicrosoftWebDriver.exe
				System.setProperty("webdriver.edge.driver",pdriverDir+"MicrosoftWebDriver.exe");
				//create an instance of edge
				driver = new EdgeDriver();
				driver.get(URL);
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			}
	}
}
	
	//Method to read the config
	
	//Wait for elements
	public void waitForElement(int elementWait, By pLocator) {
	WebDriverWait wait = new WebDriverWait(driver, elementWait);
	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(pLocator));
	}
	
	//Wait for click
	public void waitforClick(int elementWait, By pLocator) {
	WebDriverWait wait = new WebDriverWait(driver, elementWait);
	wait.until(ExpectedConditions.elementToBeClickable(pLocator));
	}
	
	//Wait for Url
	public void waitForUrl(int elementWait, String urlContainer) {
	WebDriverWait wait = new WebDriverWait(driver, elementWait);
	wait.until(ExpectedConditions.urlContains(urlContainer));
	}
	
	//Get element text
	public String getElementText(By pLocator) {
	String elementText = getElement(pLocator).getText();
	return elementText;
	}

	//Click element
	public void clickElement(By pLocator) {
		waitforClick(30, pLocator);
		getElement(pLocator).click();
		
	}
	
	//Check if element exists
	
	//Get element
	public WebElement getElement(By pLocator) {
		waitforClick(30, pLocator);
		return driver.findElement(pLocator);
	}
	
	//Clean up
	
	//Enter text
	public void enterText(By pLocator, String searchText) {
		waitforClick(30, pLocator);
		driver.findElement(pLocator).sendKeys(searchText);
	}
	
	//Switch to window
	public void SwitchToNewTab() {
		//Selenium will check how many windows are currently open,
		//It will store the ID for both parent and child window
		Set<String> handles = driver.getWindowHandles();
		
		Iterator<String> it = handles.iterator(); // using the it object you can access the ID
		String parentWindow = it.next();
		String childWindow = it.next();
		driver.switchTo().window(childWindow); //Switch to new window by passing the ID of the child window
	}	
	
	public void SwitchToParent() {
		//Selenium will check how many windows are currently open,
		//It will store the ID for both parent and child window
		Set<String> handles = driver.getWindowHandles();
		
		Iterator<String> it = handles.iterator(); // using the it object you can access the ID
		String parentWindow = it.next();
		String childWindow = it.next();
		driver.switchTo().window(parentWindow); //Switch to new window by passing the ID of the child window
	}
	
	//Clear text
	
	//Select from drop-down
	
	//Close browser after tests
}

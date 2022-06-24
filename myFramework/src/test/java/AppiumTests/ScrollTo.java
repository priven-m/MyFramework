package AppiumTests;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import frameWorkClasses.AppiumBasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class ScrollTo extends AppiumBasePage{

	@Test
	public void scrollTo() throws MalformedURLException, InterruptedException {
		
		//create an instance of the driver object
		 AndroidDriver<AndroidElement> driver = capabilities();
		 
		//click the views menu item
		driver.findElementByXPath("//android.widget.TextView[@content-desc=\"Views\"]").click();
		
		//scroll down to the menu item called radio group
		//ths is  new locator strategty
		driver.findElementByAndroidUIAutomator("new UiScrollable(New UiSelector()).scrollIntoView(text(\"Radio Group\"));");
		
		//scroll down web view
		driver.findElementByAndroidUIAutomator("new UiScrollable(New UiSelector()).scrollIntoView(text(\"WebView\"));");
	}
}

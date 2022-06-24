package AppiumTests;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

import java.net.MalformedURLException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import frameWorkClasses.AppiumBasePage;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class LongPressGestures extends AppiumBasePage {

	@Test
	public void LongClickOnMenu() throws MalformedURLException {
		// create an instance of the driver object
		AndroidDriver<AndroidElement> driver = capabilities();

		// create an instance of the touchAction object
		TouchAction t = new TouchAction(driver);

		// click Views
		driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
		
		//click expandable lists
		driver.findElementByXPath("//android.widget.TextView[@content-desc=\"Expandable Lists\"]").click();
		
		//click custom adappter
		driver.findElementByXPath("//android.widget.TextView[@content-desc=\"1. Custom Adapter\"]").click();
		
		//get the locator for people names list
		WebElement PeopleNameList = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.ExpandableListView/android.widget.TextView[1]");
		
		//Long Click using the long press for 2 seconds to expand subMenu
		t.longPress(longPressOptions().withElement(element(PeopleNameList)).withDuration(ofSeconds(2))).release().perform();
		
		//Assert text returned from MenuItem
		WebElement returnedText = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.FrameLayout/android.widget.TextView");
		String rt = returnedText.getText();
		Assert.assertEquals(rt, "Sample menu");

	}

}

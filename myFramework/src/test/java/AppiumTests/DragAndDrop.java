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

public class DragAndDrop extends AppiumBasePage {

	@Test
	// create method
	public void dragNDropDemo() throws MalformedURLException {

		// create an instance of the driver object
		AndroidDriver<AndroidElement> driver = capabilities();

		// create an instance of the touchAction object
		TouchAction t = new TouchAction(driver);

		// click Views
		driver.findElementByAndroidUIAutomator("text(\"Views\")").click();

		// click drag and drop
		driver.findElementByAndroidUIAutomator("text(\"Drag and Drop\")").click();

		// drag from index 1 to index 2 and realease
		// example locator strategy to find an index
		// driver.findELementsByClassName("").get(0);
		// driver.findELementsByClassName("").get(1);

		// get the locator for the first circle
		WebElement firstElement = driver.findElementsByClassName("android.view.View").get(0);

		// find the locator for the second circle element
		WebElement secondElement = driver.findElementsByClassName("android.view.View").get(1);

		// use the touch action longpress method to drag the first circle to the next
		// circle
		t.longPress(longPressOptions().withElement(element(firstElement)).withDuration(ofSeconds(1))).
		moveTo(element(secondElement)).release().perform();
		
		//get the element for the txtBx
		//get text for the txtBx 
		//assert that it's equal to "dropped"
		WebElement returnedText = driver.findElementById("io.appium.android.apis:id/drag_result_text");
		String rt = returnedText.getText();
		Assert.assertEquals(rt, "Dropped!");
	}
}

package AppiumTests;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class ClockSwipes {
	@Test
	public void SwipeClock() throws MalformedURLException, InterruptedException {
		
		//create and instance of the file object
		File f = new File(".");
		File fs = new File(f, "ApiDemos-debug.apk");
		
		//create an instance of the capabilities object
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "PrivenEmulator");
		cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
		cap.setCapability("autoGrantPermissions", true);
		cap.setCapability("autoAcceptAlerts", true);
		cap.setCapability("autoDissmissAlerts", true);
		
		//Set the driver
		AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		
		//Crea an instance of the touchAction object
		TouchAction t = new TouchAction(driver);
	
		driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
		driver.findElementByAndroidUIAutomator("text(\"Date Widgets\")").click();
		driver.findElementByAndroidUIAutomator("text(\"2. Inline\")").click();
		
		WebElement firstElement = driver.findElementByXPath("//*[@content-desc='12']");
		WebElement secondElement = driver.findElementByXPath("//*[@content-desc='4']");
		t.longPress(longPressOptions().withElement(element(firstElement)).withDuration(ofSeconds(2))).
		moveTo(element(secondElement)).release().perform();
	}	
}


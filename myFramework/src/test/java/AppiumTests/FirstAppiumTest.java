package AppiumTests;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class FirstAppiumTest {
	
	@Test
	public void firstTest() throws MalformedURLException, InterruptedException {
		
		//create and instance of the file object
		File f = new File(".");
		File fs = new File(f, "ApiDemos-debug.apk");
		
		//create an instance of the capabilities object
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "PrivenEmulator");
		cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
		cap.setCapability("autoGrantPermissions", true);
		cap.setCapability("autoAcceptAlerts", true);
		cap.setCapability("autoDissmissAlerts", "true");
		
		//Set the driver
		AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		
		//click preferences
		driver.findElementByXPath("//android.widget.TextView[@content-desc='Preference']").click();
		
		//click preference dependencies
		driver.findElementByXPath("//android.widget.TextView[@content-desc='3. Preference dependencies']").click();
		
		//click the check box using the id selector
		driver.findElementById("android:id/checkbox").click();
		
		//click the wifi setting option using the relative xpath
		driver.findElementByXPath("//android.widget.LinearLayout[2]").click();
		
		//enter text into the inputBox
		driver.findElementById("android:id/edit").sendKeys("1234");
		
		//Click okay
		driver.findElementById("android:id/button1").click();

	}

}

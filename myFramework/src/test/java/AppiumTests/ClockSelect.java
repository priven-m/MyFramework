package AppiumTests;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class ClockSelect {
	@Test
	public void SelectTime() throws MalformedURLException, InterruptedException {
		
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
	
		driver.findElementByXPath("//android.widget.TextView[@content-desc='Views']").click();
		
		driver.findElementByXPath("//android.widget.TextView[@content-desc=\'Date Widgets\']").click();
		
		driver.findElementByXPath("//android.widget.TextView[@content-desc=\'2. Inline\']").click();
		
		driver.findElementByXPath("//android.widget.RadialTimePickerView.RadialPickerTouchHelper[@content-desc=\"1\"]").click();
		
		driver.findElementByXPath("//android.widget.RadialTimePickerView.RadialPickerTouchHelper[@content-desc=\"25\"]").click();
		
	}	
}

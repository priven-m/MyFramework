package frameWorkClasses;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class AppiumBasePage {
	
	public static AndroidDriver<AndroidElement>driver;
	
	public AndroidDriver<AndroidElement>capabilities() throws MalformedURLException{
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
			
			return driver;
	}
}

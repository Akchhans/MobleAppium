package AppiumClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class TestMultitouch {
	public static AndroidDriver<MobileElement> driver;

	public static void main(String[] args) throws MalformedURLException, InterruptedException {

	

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "Android");
		capabilities.setCapability("appPackage", "multitouchpro.tests");
		capabilities.setCapability("appActivity", ".Multitouch");
		
		
		driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

		driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);

		
		TouchAction action1 = new TouchAction(driver).tap(345, 475).waitAction(2000);
		TouchAction action2 = new TouchAction(driver).tap(742, 795).waitAction(2000);
		TouchAction action3 = new TouchAction(driver).tap(925, 980).waitAction(2000);

		new MultiTouchAction(driver).add(action1).add(action2).add(action3).perform();
		
		Thread.sleep(4000);
		driver.quit();
	}

}

package Pages.SonyDemo;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Appium {
    WebDriver driver;
    @Test
    public void appiumFirstTestCase() throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("platformName", "ANDROID");
        cap.setCapability("deviceName", "emulator-5554");
        cap.setCapability("appPackage", "com.tuhuynh.sdetproecommerce");
        cap.setCapability("appActivity", "host.exp.exponent.MainActivity");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723git/wd/hub"), cap);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
}

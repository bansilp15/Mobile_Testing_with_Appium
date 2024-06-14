package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.URL;

public class Start_New_Session {
    private static final String APP = "https://github.com/appium-pro/TheApp/releases/v1.12.0/TheApp.apk";
    private static final String APPIUM_SERVER = "http://localhost:4723/wd/hub";
    private AndroidDriver driver;
    @BeforeMethod(alwaysRun = true)
    public void setUp() throws Exception{
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "9");
        capabilities.setCapability("deviceName", "Pixel 3 API 28");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("app", APP);

        driver = new AndroidDriver(new URL(APPIUM_SERVER), capabilities);
    }

    @AfterMethod(alwaysRun = true)
    public void endSession() throws Exception{
        if (driver != null) {
            driver.quit();
        }
    }
}

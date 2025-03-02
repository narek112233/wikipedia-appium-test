package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.testng.AllureTestNg;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;
import utils.AppiumService;
import utils.ConfigReader;


import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

@Listeners({AllureTestNg.class})
public class DriverSetup {

    private static AppiumDriver driver;

    Properties properties = ConfigReader.loadConfig();

    @BeforeClass
    @Parameters({"deviceName","portNumber","udid"})
    public void setup(@Optional("emulator1")String deviceName, @Optional("4723")String portNumber, @Optional("127.0.0.1:5585")String udid) throws IOException {
        ThreadLocal<AppiumDriver> threadDriver = new ThreadLocal<>();
        AppiumService.startService(portNumber);
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(  "appium:deviceName", deviceName);
        caps.setCapability("appium:appPackage", properties.getProperty("appPackage"));
        caps.setCapability("appium:appActivity", properties.getProperty("appActivity"));
        caps.setCapability("appium:noReset", true);
        caps.setCapability("appium:fullReset", false);
        caps.setCapability("appium:automationName", "UiAutomator2");
        caps.setCapability("appium:udid", udid);
        String url = "http://127.0.0.1:"+portNumber;
//        String url = "http://127.0.0.1:"+portNumber+"/wd/hub";
//        String url = "http://127.0.0.1:4723/wd/hub";
        threadDriver.set(new AndroidDriver(new URL(url), caps));
        driver  = threadDriver.get();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }





    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    /**
     * kill all appium servers after tests
     *  for Windows use  Runtime.getRuntime().exec("taskkill /F /IM node.exe");
     *  for Mac/Linux use Runtime.getRuntime().exec("pkill -f appium"); // Mac/Linux
     *
     */
    @AfterSuite
    public void cleanup() {
        try {
            Runtime.getRuntime().exec("taskkill /F /IM node.exe");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static AppiumDriver getDriver() {
        return driver;
    }


}

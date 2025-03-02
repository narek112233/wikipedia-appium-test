package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

public class BasePage {
    protected AppiumDriver driver;

    public Waits waits;

    public BasePage(AppiumDriver driver) {
        this.driver = driver;
        waits = new Waits(driver);
    }

    protected boolean isElementVisible(WebElement elem) {
        return elem.isDisplayed();
    }

}

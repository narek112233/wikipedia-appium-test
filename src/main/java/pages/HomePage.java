package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class HomePage extends BasePage{
    private AppiumDriver driver;
    private By searchContainer = By.xpath("//android.widget.TextView[@text='Search Wikipedia']");

    public HomePage(AppiumDriver driver) {
        super(driver);
        this.driver = driver;
    }


    public boolean isHomeScreenDisplayed() {
        return isElementVisible(driver.findElement(searchContainer));
    }

    public void clickSearch() {
        driver.findElement(searchContainer).click();
    }
}

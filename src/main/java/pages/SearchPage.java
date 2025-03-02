package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SearchPage  extends BasePage{

    AppiumDriver driver;

    private final By searchInput = By.id("org.wikipedia:id/search_src_text");
    private final By searchResultListBy = By.id("org.wikipedia:id/search_results_list");
    private final By androidViewGroupBy = By.className("android.view.ViewGroup");

    private final By listItemTitleBy = By.xpath("//android.widget.TextView[@resource-id=\"org.wikipedia:id/page_list_item_title\"]");
    public SearchPage(AppiumDriver driver) {
        super(driver);
        this.driver = driver;
    }


    public void search(String query) {
        waits.waitForVisibility(searchInput);
        driver.findElement(searchInput).sendKeys(query);
    }

    public String getFirstResultText() {
        waits.waitForVisibility(searchResultListBy);
        WebElement searchResultFirstElement = driver.findElement(searchResultListBy).findElements(androidViewGroupBy).get(0).findElement(listItemTitleBy);
        return searchResultFirstElement.getText();
    }

    public void scrollInToLastVisibleArticle() throws InterruptedException {
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollForward()"));
        Thread.sleep(4000);
    }

    public void clickOnFirstResultArticle() throws InterruptedException {
        WebElement searchResultFirstElement = driver.findElement(searchResultListBy).findElements(androidViewGroupBy).get(0).findElement(listItemTitleBy);
        searchResultFirstElement.click();
        Thread.sleep(6000);
    }
}

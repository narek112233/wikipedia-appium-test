package pages;


import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class ArticlePage extends BasePage {

    public ArticlePage(AppiumDriver driver) {
        super(driver);
    }

    By webViewBy = By.xpath("//android.view.ViewGroup[@resource-id=\"org.wikipedia:id/page_contents_container\"]/android.webkit.WebView");
    public String getArticleName(){
        WebElement articleNameElement = driver.findElement(webViewBy).findElement(By.className("android.widget.TextView"));
        waits.waitToElementIsClickable(articleNameElement);
        return articleNameElement.getText();
    }

}

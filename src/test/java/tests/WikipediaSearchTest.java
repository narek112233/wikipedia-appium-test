package tests;

import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SearchPage;

public class WikipediaSearchTest extends DriverSetup {

    HomePage homePage;
    SearchPage searchPage;

    @Test
    @Description("Test Search Wikipedia")
    public void testSearchWikipedia() {
        homePage = new HomePage(getDriver());
        searchPage = new SearchPage(getDriver());

        Allure.step("Verify that the home screen is displayed correctly.");
        Assert.assertTrue(homePage.isHomeScreenDisplayed());

        Allure.step("Click on Search input");
        homePage.clickSearch();

        Allure.step("Search any text");
        searchPage.search("Selenium");

        Allure.step("Verify that search result contains searched text");
        String result = searchPage.getFirstResultText();
        Assert.assertTrue(result.toLowerCase().contains("selenium"));
    }
}

package tests;

import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ArticlePage;
import pages.HomePage;
import pages.SearchPage;

public class WikipediaScrollTest extends DriverSetup {

    HomePage homePage;
    SearchPage searchPage;
    ArticlePage articlePage;

    @Test
    @Description("Test Scroll functionality")
    public void testScrollThroughArticle() throws InterruptedException {
        homePage = new HomePage(getDriver());
        searchPage = new SearchPage(getDriver());
        articlePage = new ArticlePage(getDriver());

        Allure.step("Click on Search input");
        homePage.clickSearch();

        Allure.step("Search any text");
        searchPage.search("Selenium");


        Allure.step("Scroll in to last visible article");
        String firstResultText = searchPage.getFirstResultText();
        searchPage.scrollInToLastVisibleArticle();

        Allure.step("Verify that the first result text is not the same after scrolling.");
        String firstResultTextAfterScroll = searchPage.getFirstResultText();
        Assert.assertNotEquals(firstResultText, firstResultTextAfterScroll);

        Allure.step("Click on the first result Article");
        searchPage.clickOnFirstResultArticle();

        Allure.step("Verify that the Article name contains searched text");
        Assert.assertTrue(articlePage.getArticleName().toLowerCase().contains("selenium"));
    }
}

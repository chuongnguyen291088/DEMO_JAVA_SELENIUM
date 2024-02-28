package Steps.WebSteps;

import Core.Support.Waiter;
import Pages.MicrosoftDemo.HomePageMicrosoft;
import Pages.SonyDemo.SearchResultPage;
import Pages.SonyDemo.SonyCartPage;
import Pages.SonyDemo.SonyProfilePage;
import Utils.CommonUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class VerifySteps {
    /*
    String expression "\([^\"]*)\"
    */

    @Then("microsoft - verify that user login successfully and user information display correctly")
    public void verifyMicrosoftUserLoginSuccessfully() {
        HomePageMicrosoft homePage = new HomePageMicrosoft();
        Waiter.wait(3);
        Assert.assertTrue(homePage.isOnPage(), "[FAILED] Home page is not displayed ... ");

        homePage.clickOnSignInButton();
        Waiter.wait(3);
        String expectedName, expectedEmail, actualName, actualEmail;
        CommonUtil utils = new CommonUtil();
        expectedName = utils.getUserName();
        expectedEmail = utils.getUserEmail();

        actualName = homePage.getUserName();
        actualEmail = homePage.getUserEmail();

        Assert.assertEquals(actualName, expectedName, String.format("[FAILED] expected name is [%s] but found [%s]", expectedName, actualName));
        Assert.assertEquals(actualEmail, expectedEmail, String.format("[FAILED] expected email is [%s] but found [%s]", expectedEmail, expectedName));
    }

    @Then("sony - verify that user login successfully and user information display correctly")
    public void verifySonyUserLoginSuccessfully() {
        Waiter.wait(3);
        SonyProfilePage sonyProfilePage = new SonyProfilePage();
        Assert.assertTrue(sonyProfilePage.isOnPage(), "[FAILED] Profile page is not displayed ... ");

        String expectedName, expectedEmail, actualName, actualEmail;
        CommonUtil utils = new CommonUtil();
        expectedName = utils.getUserName();
        expectedEmail = utils.getUserEmail();

        actualName = sonyProfilePage.getUserName().replace("Tên: ", "");
        actualEmail = sonyProfilePage.getUserEmail().replace("Email: ", "");

        Assert.assertEquals(actualName, expectedName, String.format("[FAILED] expected name is [%s] but found [%s]", expectedName, actualName));
        Assert.assertEquals(actualEmail, expectedEmail, String.format("[FAILED] expected email is [%s] but found [%s]", expectedEmail, expectedName));
    }

    @Then("sony - verify that search result list contains {string}")
    public void verifySearchResultList(String condition) {
        SearchResultPage searchResultPage = new SearchResultPage();
        ArrayList<String> resultList = searchResultPage.getListItemName();
        for (int i = 0; i < resultList.size(); i++) {
            Assert.assertTrue(resultList.get(i).contains(condition),
                    String.format("Search result position [%s] does not contains search condition [%s]", i, condition));
        }
    }

    @Then("sony - verify that products below display(s) into cart")
    public void verifyProductDisplaysIntoCart(List<String> items) {
        Waiter.wait(3);
        SonyCartPage sonyCartPage = new SonyCartPage();
        for (String item: items) {
            Waiter.wait(1);
            Assert.assertTrue(sonyCartPage.isProductDisplayedIntoCart(item),
                    String.format("Product [%s] does not display into cart", item));
        }
    }
}

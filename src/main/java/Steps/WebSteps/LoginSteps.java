package Steps.WebSteps;

import Core.Support.PropertyBuilder;
import Core.Support.Waiter;
import Pages.MicrosoftDemo.LoginByMicrosoftPageMicrosoft;
import Pages.SonyDemo.Popup.SonyAdvertisementPopup;
import Pages.SonyDemo.SonyHomePage;
import Pages.SonyDemo.SonyLogInPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class LoginSteps {
    @Given("^microsoft - user login with (valid|invalid) data$")
    public void loginWithMicrosoft(String condition) throws Exception {
        String email, password;
        LoginByMicrosoftPageMicrosoft loginByMicrosoftPage = new LoginByMicrosoftPageMicrosoft();
        switch (condition.toLowerCase()) {
            case "valid":
                email = PropertyBuilder.getEnvProperty().getProperty("login.email");
                password = PropertyBuilder.getEnvProperty().getProperty("login.password");
                break;
            case "invalid":
                email = PropertyBuilder.getEnvProperty().getProperty("login.email");
                password = "hX9iU7jCIO+9lRDroPcOVj2VKgHPZlU5MmWNa7D9PtQ=";
                break;
            default:
                throw new Exception("Unexpected value " + condition);
        }
        loginByMicrosoftPage.clickOnSignInButton();
        loginByMicrosoftPage.login(email, password);
    }

    @Given("^sony - user login with (valid|invalid) data$")
    public void loginWithSony(String condition) throws Exception {
        String email, password;
        SonyHomePage sonyHomePage = new SonyHomePage();
        sonyHomePage.waitForPageLoadComplete();
        sonyHomePage.acceptCookieIfItIsPossible();
        Waiter.wait(2);
        SonyAdvertisementPopup sonyAdvertisementPopup = new SonyAdvertisementPopup();
        sonyAdvertisementPopup.closePopupIfItPossible();
        sonyHomePage.clickOnSignInIcon();
        sonyHomePage.clickOnSignInButton();
        switch (condition.toLowerCase()) {
            case "valid":
                email = PropertyBuilder.getEnvProperty().getProperty("login.email");
                password = PropertyBuilder.getEnvProperty().getProperty("login.password");
                break;
            case "invalid":
                email = PropertyBuilder.getEnvProperty().getProperty("login.email");
                password = "hX9iU7jCIO+9lRDroPcOVj2VKgHPZlU5MmWNa7D9PtQ=";
                break;
            default:
                throw new Exception("Unexpected value " + condition);
        }
        SonyLogInPage sonyLogInPage = new SonyLogInPage();
        sonyLogInPage.waitForPageLoadComplete();
        sonyLogInPage.logIn(email, password);
    }
}

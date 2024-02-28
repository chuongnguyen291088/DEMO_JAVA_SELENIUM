package Pages.SonyDemo;

import Core.Support.Waiter;
import Pages.BasePage;
import WebElement.Button;
import WebElement.Textbox;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Wait;

public abstract class BaseSonyDemoPage extends BasePage {

    //locators
    private final String xpath_header = "//nav[contains(@class,'header')]";
    private final String xpath_signInIcon = xpath_header + "//*[@class='icon icon-user']/parent::a";
    private final String xpath_btnSignIn = xpath_header + "//div/a[@title='Sign In']";
    private final String xpath_btnAcceptCookie = "//button[@class='button_accept' and text()='Chấp nhận Cookie']";
    private final String xpath_btnSearch = "//a[@href='/search']";
    private final String xpath_txtBoxSearch = "//div/input[@type='search']";

    //elements
    private final Button signInIcon = new Button(By.xpath(xpath_signInIcon), "Sign In Icon");
    private final Button btnSignIn = new Button(By.xpath(xpath_btnSignIn), "Sign In");
    private final Button btnAcceptCookie = new Button(By.xpath(xpath_btnAcceptCookie), "Accept Cookie");
    private final Button btnSearch = new Button(By.xpath(xpath_btnSearch), "Search");
    private final Textbox txtSearch = new Textbox(By.xpath(xpath_txtBoxSearch), "Search");

    public BaseSonyDemoPage(By by, String name) {
        super(by, name);
    }

    public void clickOnSignInIcon() {
        try {
            signInIcon.waitForClickable();
            signInIcon.click();
        } catch (ElementClickInterceptedException e) {
            Waiter.wait(2);
            signInIcon.click();
        }
        waitForJSToComplete();
        Waiter.wait(1);
    }

    public void clickOnSignInButton() {
        btnSignIn.waitForClickable();
        btnSignIn.click();
        waitForJSToComplete();
        Waiter.wait(1);
    }

    public void acceptCookieIfItIsPossible() {
        Waiter.wait(1);
        if (btnAcceptCookie.isElementDisplay()) {
            btnAcceptCookie.waitForClickable();
            btnAcceptCookie.click();
            waitForJSToComplete();
        }
    }

    public void globalSearching(String condition) {
        Waiter.wait(1);
        btnSearch.waitForClickable();
        btnSearch.click();
        Waiter.wait(1);
        txtSearch.waitForElementToBeDisplay();
        txtSearch.sendClearText(condition);
        Waiter.wait(1);
        pressKey(Keys.ENTER);
    }
}

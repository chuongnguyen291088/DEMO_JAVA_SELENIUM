package Pages.MicrosoftDemo;

import Pages.BasePage;
import WebElement.Button;
import org.openqa.selenium.By;

public abstract class BaseMicrosoftDemoPage extends BasePage {

    //locators
    private final String xpath_btnSignIn = "//div[@role='presentation']";

    //elements
    private final Button btnSignIn = new Button(By.xpath(xpath_btnSignIn), "Sign In");

    public BaseMicrosoftDemoPage(By by, String name) {
        super(by, name);
    }

    public void clickOnSignInButton() {
        btnSignIn.waitForClickable();
        btnSignIn.click();
        waitForJSToComplete();
    }
}

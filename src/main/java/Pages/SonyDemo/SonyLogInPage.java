package Pages.SonyDemo;

import Core.Support.Waiter;
import Utils.Decoder;
import WebElement.Button;
import WebElement.Textbox;
import org.openqa.selenium.By;

public class SonyLogInPage extends BaseSonyDemoPage {

    private final static By by = new By.ByXPath("//div[contains(@class,'body-login-page')]");
    private final static String name = "Sony Log In";

    //locators
    private final String idEmail = "email";
    private final String idPassword = "password";
    private final String idLogIn = "next";

    //elements
    private final Textbox txtBoxEmail = new Textbox(By.id(idEmail), "Email");
    private final Textbox txtBoxPassword = new Textbox(By.id(idPassword), "Password");
    private final Button btnLogIn = new Button(By.id(idLogIn), "Log In");


    public SonyLogInPage() {
        super(by, name);
    }

    public void logIn(String email, String password) {
        Waiter.wait(3);
        txtBoxEmail.waitForElementToBeDisplay();
        txtBoxEmail.sendClearText(email);
        txtBoxPassword.sendClearText(Decoder.decrypt(password));
        btnLogIn.waitForClickable();
        btnLogIn.click();
        waitForJSToComplete();
    }
}

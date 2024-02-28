package Pages.MicrosoftDemo;

import Core.Support.Waiter;
import Pages.MicrosoftDemo.BaseMicrosoftDemoPage;
import Utils.Decoder;
import WebElement.Textbox;
import WebElement.Button;
import org.openqa.selenium.By;

public class LoginByMicrosoftPageMicrosoft extends BaseMicrosoftDemoPage {

    private static final By by = new By.ById("idSIButton9");
    private static final String name = "Microsoft Login";

    // locators
    private final String name_email = "loginfmt";
    private final String name_password = "passwd";
    private final String id_nextButtonAndLogin = "idSIButton9";
    private final String id_buttonBack = "idBtn_Back";
    private final String id_declineButton = "declineButton";

    // elements
    private final Textbox textBoxEmail = new Textbox(By.name(name_email), "Email");
    private final Textbox textBoxPassword = new Textbox(By.name(name_password), "Password");
    private final Button buttonNextOrLogin = new Button(By.id(id_nextButtonAndLogin), "Next or Login");
    private final Button buttonBack = new Button(By.id(id_buttonBack), "Back");
    private final Button buttonDeclineStaySignedIn = new Button(By.id(id_declineButton), "Decline");

    public LoginByMicrosoftPageMicrosoft() {
        super(by, name);
    }

    public void login(String email, String password) {
        textBoxEmail.waitForElementToBeDisplay();
        textBoxEmail.sendClearText(email);
        buttonNextOrLogin.waitForClickable();
        buttonNextOrLogin.click();
        textBoxPassword.waitForElementToBeDisplay();
        textBoxPassword.sendClearText(Decoder.decrypt(password));
        buttonNextOrLogin.waitForClickable();
        buttonNextOrLogin.click();
        Waiter.wait(3);
        declineStaySignedIn();
        clickOnBackIfRememberMePopupAppear();
        waitForJSToComplete();
    }

    private void clickOnBackIfRememberMePopupAppear() {
        if (buttonBack.isElementDisplay()) {
            buttonBack.waitForClickable();
            buttonBack.click();
            waitForJSToComplete();
        }
    }

    private void declineStaySignedIn() {
        if (buttonDeclineStaySignedIn.isElementDisplay()) {
            buttonDeclineStaySignedIn.waitForClickable();
            buttonDeclineStaySignedIn.click();
            waitForJSToComplete();
        }
    }
}

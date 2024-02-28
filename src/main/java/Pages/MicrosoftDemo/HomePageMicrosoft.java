package Pages.MicrosoftDemo;

import Pages.MicrosoftDemo.BaseMicrosoftDemoPage;
import WebElement.Label;
import org.openqa.selenium.By;

public class HomePageMicrosoft extends BaseMicrosoftDemoPage {

    private static final By by = By.xpath("//div[@role='presentation']/ancestor::button[not(@aria-label='Sign in to your account')]");
    private static final String name = "Home page";

    //locators
    private final String xpath_lblUserName = "//div[contains(@id,'currentAccount_primary')]";
    private final String xpath_lblUserEmail = "//div[contains(@id,'currentAccount_secondary')]";

    //elements
    private final Label lblUserName = new Label(By.xpath(xpath_lblUserName), "User name");
    private final Label lblUserEmail = new Label(By.xpath(xpath_lblUserEmail), "User email");

    public HomePageMicrosoft() {
        super(by, name);
    }

    public String getUserName() {
        return lblUserName.getText();
    }

    public String getUserEmail() {
        return lblUserEmail.getText();
    }
}

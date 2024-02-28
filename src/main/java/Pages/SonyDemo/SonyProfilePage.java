package Pages.SonyDemo;

import WebElement.Label;
import org.openqa.selenium.By;

public class SonyProfilePage extends BaseSonyDemoPage {

    private final static By by = new By.ByXPath("//h1[text()='Tài khoản']");
    private final static String name = "Sony Profile Page";

    //locators
    private final String xpath_lblUserName = "//div[@class='author']";
    private final String xpath_lblEmail = "//div[@class='email']";

    //elements
    private final Label lblUserName = new Label(By.xpath(xpath_lblUserName), "User Name");
    private final Label lblEmail = new Label(By.xpath(xpath_lblEmail), "Email");

    public SonyProfilePage() {
        super(by, name);
    }

    public String getUserName() {
        return lblUserName.getText();
    }

    public String getUserEmail() {
        return lblEmail.getText();
    }

}

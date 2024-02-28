package Pages.SonyDemo;

import org.openqa.selenium.By;

public class SonyHomePage extends BaseSonyDemoPage {

    private final static By by = new By.ByXPath("//main[@id='main']");
    private final static String name = "Sony Home Page";

    //locators

    //elements

    public SonyHomePage() {
        super(by, name);
    }

}

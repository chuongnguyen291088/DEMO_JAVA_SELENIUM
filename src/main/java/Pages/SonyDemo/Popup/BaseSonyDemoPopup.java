package Pages.SonyDemo.Popup;

import Core.Support.Waiter;
import Pages.SonyDemo.BaseSonyDemoPage;
import WebElement.Button;
import WebElement.Label;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoSuchElementException;

public abstract class BaseSonyDemoPopup extends BaseSonyDemoPage {

    //locators
    private final String xpath_btnClosePopup = "//a[@data-remodal-action='close']";

    //elements
    private final Button btnClosePopup = new Button(By.xpath(xpath_btnClosePopup), "Close");


    public BaseSonyDemoPopup(By by, String name) {
        super(by, name);
    }

    public void waitForPopupAppear() {
        Waiter.wait(1);
        Label locator = new Label(getPageLocator(), "Locator");
        try {
            locator.waitForElementToBeDisplay();
        } catch (Exception e) {
            locator.waitForElementToBeDisplay();
        }
        Waiter.wait(1);
    }

    public void waitForPopUpDisappear() {
        try {
            Waiter.waitForElementToBeDisappear(driver.findElement(super.getPageLocator()));
        } catch (NoSuchElementException e) {
            System.out.println("Popup already disappeared...");
        }
    }

    public void closePopup() {
        try {
            btnClosePopup.waitForClickable();
            btnClosePopup.click();
        } catch (ElementClickInterceptedException e) {
            Waiter.wait(2);
            btnClosePopup.click();
        }
        waitForJSToComplete();
    }
}

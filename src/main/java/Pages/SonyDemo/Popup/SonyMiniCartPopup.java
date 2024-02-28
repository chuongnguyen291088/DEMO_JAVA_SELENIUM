package Pages.SonyDemo.Popup;

import Core.Support.Waiter;
import WebElement.Button;
import org.openqa.selenium.By;

public class SonyMiniCartPopup extends BaseSonyDemoPopup {

    private static final By by = new By.ByXPath("//form[@action='/cart' and contains(@class,'mini-cart')]");
    private static final String name = "Sony Mini Cart Popup";

    //locators
    private final String xpath_btnContinueShopping = "//div[contains(@class,'close-minicart')]";
    private final String xpath_btnProceedWithPayment = "//div/a[@href='/cart']";

    //elements
    private final Button btnContinueShopping = new Button(By.xpath(xpath_btnContinueShopping), "Continue Shopping");
    private final Button btnProceedWithPayment = new Button(By.xpath(xpath_btnProceedWithPayment), "Proceed With Payment");

    public SonyMiniCartPopup() {
        super(by, name);
    }


    public void selectContinueShopping() {
        btnContinueShopping.waitForClickable();
        btnContinueShopping.click();
        waitForJSToComplete();
        Waiter.wait(1);
    }

    public void selectProceedWithPayment() {
        btnProceedWithPayment.waitForClickable();
        btnProceedWithPayment.click();
        waitForJSToComplete();
        Waiter.wait(1);
    }
}

package Pages.SonyDemo.Popup;

import org.openqa.selenium.By;

public class SonyAdvertisementPopup extends BaseSonyDemoPopup {

    private static final By by = new By.ByXPath("//div[contains(@class,'modal box')]");
    private static final String name = "Sony Advertisement Popup";

    public SonyAdvertisementPopup() {
        super(by, name);
    }

    public void closePopupIfItPossible() {
        SonyAdvertisementPopup sonyAdvertisementPopup = new SonyAdvertisementPopup();
        if (sonyAdvertisementPopup.isOnPage()) {
            closePopup();
            waitForPopUpDisappear();
        }
    }
}

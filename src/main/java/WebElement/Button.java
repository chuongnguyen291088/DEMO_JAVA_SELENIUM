package WebElement;

import Core.Support.Waiter;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Button extends BaseElement {
    private final static Logger LOGGER = Logger.getLogger(Button.class.getCanonicalName());

    private static String type = "Button";
    private int attempts = 0;
    private int time = 2;

    public Button(By by, String name) {
        super(by, type, name);
    }

    public void waitForClickable() {
        LOGGER.log(Level.INFO, String.format(">>>>> Waiting for [%s] name [%s] to be displayed", super.getElementType(), super.getElementName()));
        while (attempts < time) {
            try {
                Waiter.waitForElementToBeClickable(super.getElement());
                break;
            } catch (StaleElementReferenceException e) {
                e.getMessage();
            }
            attempts++;
        }
    }

    public boolean isButtonClickable() {
        return (getElement().isDisplayed() && getElement().isEnabled());
    }
}
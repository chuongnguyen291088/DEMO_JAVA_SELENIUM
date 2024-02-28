package WebElement;

import Core.Support.Waiter;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Textbox extends BaseElement {
    private final static Logger LOGGER = Logger.getLogger(Textbox.class.getCanonicalName());

    private static String type = "TextBox";
    private int attempts = 0;
    private int time = 2;

    public Textbox(By by, String name) {
        super(by, type, name);
    }

    public void sendClearText(String text) {
        while (attempts < time) {
            try {
                super.getElement().clear();
                Thread.sleep(500);
                super.getElement().sendKeys(text);
                break;
            } catch (StaleElementReferenceException | InterruptedException e) {
                e.printStackTrace();
            }
            attempts++;
        }
    }

    public void waitForTextToBePresent(String text) {
        Waiter.waitForTextPresent(super.getWebElement(), text);
    }

    public void sendClearTextViaJs(String text) {
        LOGGER.log(Level.INFO, String.format(">>>>> Click Stable on [%s] name [%s]", super.getElementType(), super.getElementName()));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript(String.format("arguments[0].setAttribute('value','%s');", text), driver.findElement(super.getBy()));
    }

    public void sendClearTextByKeyBoard(String name) {
        if (getOS() == OS.MAC) {
            super.getElement().sendKeys(Keys.chord(Keys.COMMAND, "a"), Keys.DELETE);
        } else if (getOS() == OS.WINDOWS) {
            super.getElement().sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
        } else {
            super.getElement().sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
        }
        Waiter.wait(1);
        super.getElement().sendKeys(name);
    }
}

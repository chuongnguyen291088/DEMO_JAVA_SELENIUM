package Pages;

import Core.Support.BaseEntities;
import Core.Support.Waiter;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class BasePage extends BaseEntities {
    private final static Logger LOGGER = Logger.getLogger(BasePage.class.getCanonicalName());

    private final String pageName;
    private final By pageLocator;

    public BasePage(By pageLocator, String pageName) {
        this.pageLocator = pageLocator;
        this.pageName = pageName;
    }

    public boolean isOnPage() {
        try {
            boolean result = driver.findElement(pageLocator).isDisplayed();
            if (result) {
                LOGGER.log(Level.INFO, ">>>>> Page " + pageName + " is opened");
            } else {
                LOGGER.log(Level.INFO, ">>>>> Page " + pageName + " is not opened");
            }
            return result;
        } catch (Exception e) {
            LOGGER.log(Level.INFO, String.format(">>>>> Not on Page [%s]", getPageName()));
            return false;
        }
    }

    public void scrollToTopOfPage() {
        ((JavascriptExecutor) driver)
                .executeScript("window.scrollTo(0, 0)");
    }

    public void scrollToBottomOfPage() {
        ((JavascriptExecutor) driver)
                .executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public void waitForJSToComplete() {
        Waiter.waitForJSToComplete();
    }

    public void waitForPageLoadComplete() {
        Waiter.waitForElementToBeDisplay(driver.findElement(pageLocator));
    }

    public String getPageName() {
        return this.pageName;
    }

    public By getPageLocator() {
        return this.pageLocator;
    }

    public void pressKey(Keys keys) {
        Actions action = new Actions(driver);
        action.sendKeys(keys).perform();
    }
}

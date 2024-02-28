package Core.Support;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchFrameException;

import java.util.ArrayList;

public class BrowserManager extends BaseEntities {
    private static BrowserManager instance;

    private BrowserManager() {}

    public static BrowserManager getInstance() {
        if (instance == null) {
            instance = new BrowserManager();
        }
        return instance;
    }

    public void navigateToUrl(String url) {
        driver.get(url);
    }

    public void switchToIFrame(int frameIndex) {
        driver.switchTo().frame(frameIndex);
    }

    public void switchToIFrame(By by) {
        final int time = 5;
        int i = 0;
        while (i < time) {
            try {
                driver.switchTo().frame(driver.findElement(by));
                break;
            } catch (NoSuchFrameException e) {
                BrowserManager.getInstance().refreshPage();
            }
            i++;
        }
    }

    public void switchToIFrame(String frameId) {
        driver.switchTo().frame(frameId);
    }

    public void backToParentFrame() {
        driver.switchTo().parentFrame();
    }

    public void switchToTab(int tabIndex) {
        ArrayList<String> tabs = new ArrayList<> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabIndex));
    }

    public void switchToParentTab() {
        ArrayList<String> tabs = new ArrayList<> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
    }

    public void refreshPage() {
        driver.navigate().refresh();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public void closeTab() {
        driver.close();
    }
}

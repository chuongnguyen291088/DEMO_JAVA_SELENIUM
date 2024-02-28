package Core.Support;

import Utils.FileUtils;
import Utils.Vars;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Hooks extends BaseEntities {
    private final static Logger LOGGER = Logger.getLogger(Hooks.class.getCanonicalName());

    @Before
    public void before(Scenario scenario) {
        PropertyBuilder.buildProperty();
        System.setProperty("https.protocols", "TLSv1.1");
        BaseEntities.setScenario(scenario);
    }

    @After
    public void after(Scenario scenario) {
        Vars.clearVarList();
        FileUtils.clearDataInDownload();
    }

    @Before("@selenium")
    public void beforeWeb(Scenario scenario) {
        LOGGER.log(Level.INFO, "###################### Start Scenario: " + scenario.getName() + " #########################################");
        BrowserFactory.initBrowser();
        try {
            BrowserManager.getInstance().navigateToUrl(PropertyBuilder.getEnvProperty().getProperty("base.url"));
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }

    @After("@selenium")
    public void afterWeb(Scenario scenario) {
        LOGGER.log(Level.INFO, "###################### End Scenario: " + scenario.getName() + " #########################################");
        if (scenario.isFailed()) {
            final byte[] screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenShot, "image/png", scenario.getName());
        }
        driver.quit();
    }
}

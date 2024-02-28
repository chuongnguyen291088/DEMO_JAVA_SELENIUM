package Core.Support;

import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;

public abstract class BaseEntities {
    protected static WebDriver driver;
    private static final String[] env = System.getProperty("env").split(",");
    private static final String headlessMode = System.getProperty("headless");

    private static final String[] validBrowser = new String[]{"CHROME", "FIREFOX", "SAFARI", "EDGE"};
    private static final String[] validEnv = new String[]{"QA_DEMO", "QA_PRE", "QA_PROD"};
    private static final String[] validLanguage = new String[]{"EN", "VN"};
    private static Scenario scenario;

    public static boolean isHeadless() {
        if (headlessMode == null || !headlessMode.equalsIgnoreCase("TRUE")) {
            return false;
        } else {
            return true;
        }
    }

    public static String getBrowser() throws Exception {
        String browser = env[0];
        if (Arrays.asList(validBrowser).contains(browser.toUpperCase())) {
            return browser;
        } else {
            throw new Exception("Invalid Browser, currently we only support: chrome, firefox ...");
        }
    }

    public static String getEnv() {
        String testEnv = env[1];
        if (Arrays.asList(validEnv).contains(testEnv.toUpperCase())) {
            return testEnv;
        } else {
            throw new IllegalStateException("Invalid Test environment, currently we only support: demo, preview, production ...");
        }
    }

    public static String getLanguage() throws Exception {
        String language = env[2];
        if (Arrays.asList(validLanguage).contains(language.toUpperCase())) {
            return language;
        } else {
            throw new Exception("Invalid language, currently we only support: en ...");
        }
    }

    public static int getLanguageIndex() {
        int langIndex = 0;
        try {
            switch (getLanguage()) {
                case "en":
                    langIndex = 0;
                    break;
                default:
                    langIndex = 1;
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return langIndex;
    }

    protected static OS getOS() {
        String os = System.getProperty("os.name");
        if (os.toLowerCase().contains("mac")) {
            return OS.MAC;
        } else {
            return OS.WINDOWS;
        }
    }

    public static int getPageLoadTimeOut() {
        return Integer.parseInt(PropertyBuilder.getTimeOutConfig().getProperty("page.load.time.out"));
    }

    public static int getImplicitTimeOut() {
        return Integer.parseInt(PropertyBuilder.getTimeOutConfig().getProperty("implicitly.time.out"));
    }

    public static int getElementTimeOut() {
        return Integer.parseInt(PropertyBuilder.getTimeOutConfig().getProperty("element.time.out"));
    }

    public static Scenario getScenario() {
        return scenario;
    }

    public static void setScenario(Scenario scenario) {
        BaseEntities.scenario = scenario;
    }

    protected enum OS {
        MAC,
        WINDOWS,
        LINUX
    }
}

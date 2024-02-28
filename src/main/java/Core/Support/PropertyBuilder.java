package Core.Support;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class PropertyBuilder {
    private static Properties properties;

    public static Properties getEnvProperty() {
        if (properties == null) {
            buildProperty();
        }
        return properties;
    }

    static void buildProperty() {
        properties = new Properties();
        try {
            BufferedReader ip = new BufferedReader(new InputStreamReader(Files.newInputStream(Paths.get(PathFinder.getPathToMainConfiguration())), StandardCharsets.UTF_8));
            properties.load(ip);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static Properties getTimeOutConfig() {
        Properties timeoutProperties = new Properties();
        try {
            BufferedReader ip = new BufferedReader(new InputStreamReader(Files.newInputStream(Paths.get(PathFinder.getPathToTimeOutConfiguration())), StandardCharsets.UTF_8));
            timeoutProperties.load(ip);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return timeoutProperties;
    }

    public static Properties getGmailConfig() {
        Properties timeoutProperties = new Properties();
        try {
            BufferedReader ip = new BufferedReader(new InputStreamReader(Files.newInputStream(Paths.get(PathFinder.getPathToGmailConfiguration())), StandardCharsets.UTF_8));
            timeoutProperties.load(ip);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return timeoutProperties;
    }
}

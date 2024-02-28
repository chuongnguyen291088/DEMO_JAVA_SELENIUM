package Core.Support;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

import static Constants.EnvironmentConstants.*;

public class PathFinder {
    private static String currentWorkingDirectory = System.getProperty("user.dir");
    private final static Logger LOGGER = Logger.getLogger(PathFinder.class.getCanonicalName());

    // Folder
    private static final String configFolderName = "config";
    private static final String UTILS = "Utils";
    private static final String DATA = "data";
    private static final String AVATARS = "avatars";
    private static final String TMP = "tmp";
    private static final String DOWNLOAD = "download";
    private static final String SIKULI = "sikuli_image";

    public static String getPathToMainConfiguration() throws Exception {
        String mainConfigurationFileName = new String();
        String env = BaseEntities.getEnv();
        if (env == null || env.equals("")) {
            env = ENV_QA_PREVIEW;
        }

        switch (env.toUpperCase()) {
            case ENV_QA_DEMO:
                LOGGER.log(Level.INFO, ">>>>> Running on QA AUTOMATION Instance - DEMO environment ...");
                mainConfigurationFileName = "qa_demo.properties";
                break;
            case ENV_QA_PREVIEW:
                LOGGER.log(Level.INFO, ">>>>> Running on QA AUTOMATION Instance - PREVIEW environment ...");
                mainConfigurationFileName = "qa_preview.properties";
                break;
            case ENV_QA_PRODUCTION:
                LOGGER.log(Level.INFO, ">>>>> Running on QA AUTOMATION Instance - PRODUCTION environment ...");
                mainConfigurationFileName = "qa_production.properties";
                break;
            default:
                throw new Exception("Invalid env ... ");
        }
        return currentWorkingDirectory + File.separator + configFolderName + File.separator + mainConfigurationFileName;
    }

    public static String getPathToTimeOutConfiguration() {
        return currentWorkingDirectory + File.separator + configFolderName + File.separator + "timeout.properties";
    }

    public static String getPathToGmailConfiguration() {
        return currentWorkingDirectory + File.separator + configFolderName + File.separator + "gmail.properties";
    }

    public static String getSecretKeyPath() {
        return currentWorkingDirectory + File.separator
                + "src" + File.separator + "main" + File.separator + "java" + File.separator
                + UTILS + File.separator + "key.txt";
    }

    public static String getAvatarsPath() {
        return currentWorkingDirectory + File.separator + DATA + File.separator + AVATARS + File.separator;
    }

    public static String getDataFolderPath() {
        return currentWorkingDirectory + File.separator + DATA + File.separator;
    }

    public static String getSikuliImageStorage() {
        return currentWorkingDirectory + File.separator + DATA + File.separator + SIKULI + File.separator;
    }

    public static String getDownloadFolderPath() {
        return getDataFolderPath() + DOWNLOAD;
    }

    public static String getTmpFolderPath() {
        return currentWorkingDirectory + File.separator + TMP + File.separator;
    }
}

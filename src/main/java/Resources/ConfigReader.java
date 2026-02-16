package Resources;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

    private static Properties prop;

    private static void load() {
        if (prop == null) {
            try (FileInputStream fis = new FileInputStream(
                    System.getProperty("user.dir")
                    + "/src/main/java/Resources/config.properties")) {
                prop = new Properties();
                prop.load(fis);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static String get(String key) {
        load();
        return prop.getProperty(key);
    }
}
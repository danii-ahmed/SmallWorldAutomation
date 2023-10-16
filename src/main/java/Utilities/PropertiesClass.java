package Utilities;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

@Slf4j
public class PropertiesClass {

    public static Properties getPropertyValue(String filename) {
        Properties properties = new Properties();
        try {
            File configExternalFile = new File(
                    System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator
                            + "resources" + File.separator + "Properties" + File.separator + filename + ".properties");
            if (configExternalFile.exists()) {
                properties.load(new FileInputStream(configExternalFile));
            } else {
                log.info("File Not found " + filename);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return properties;
    }

}

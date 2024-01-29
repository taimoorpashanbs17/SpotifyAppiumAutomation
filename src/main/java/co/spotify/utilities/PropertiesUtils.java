package co.spotify.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import static co.spotify.helpers.LogHelper.error;

public class PropertiesUtils {

    public static Properties readPropertyValueFromPropertyFile(String fileName){
        Properties properties = new Properties();
        FileInputStream fileInput;

        try {
            fileInput = new FileInputStream(fileName);
            properties.load(fileInput);
        } catch (IOException fileNotException) {
            error(fileNotException.getMessage());
        }
        return properties;
    }

    public static void writePropertyValueInPropertyFile(String fileName, String propertyName, String propertyValue)
            throws IOException {
        FileInputStream in = new FileInputStream(fileName);
        Properties props = new Properties();
        props.load(in);
        in.close();
        props.setProperty(propertyName, propertyValue);
        FileOutputStream out = new FileOutputStream(fileName);
        props.store(out, null);
        out.close();
    }
}

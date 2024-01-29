package co.spotify.constants;

import static co.spotify.utilities.PropertiesUtils.readPropertyValueFromPropertyFile;
import java.util.Properties;

import static co.spotify.helpers.PathHelper.getFile;

public class UserInformationConstants {
    static String userPropertiesFileName = "userInformation.properties";
    static String propertiesFilePath = getFile(userPropertiesFileName);
    static Properties properties = readPropertyValueFromPropertyFile(propertiesFilePath);
    public static final String DATE_OF_BIRTH = properties.getProperty("dateOfBirth");
    public static final String USER_FIRST_NAME = properties.getProperty("firstName");
    public static final String USER_LAST_NAME = properties.getProperty("lastName");
    public static final String PASSWORD = properties.getProperty("password");
    public static final String USER_EMAIL = properties.getProperty("registeredEmail");
    public static final String USER_GENDER = properties.getProperty("gender");
    public static final String LOGIN_USER_EMAIL = properties.getProperty("loginEmail");
}

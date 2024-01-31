package co.spotify;

import co.spotify.screens.SpotifyScreens;
import io.appium.java_client.Setting;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import static co.spotify.constants.StringConstants.*;
import static co.spotify.helpers.PathHelper.getFile;
import static co.spotify.utilities.PropertiesUtils.readPropertyValueFromPropertyFile;

import static co.spotify.helpers.LogHelper.warn;

public abstract class SpotifyTestBase {

    public static AndroidDriver androidDriver;


    public static void createAndroidDriver() {
        String configPropertiesFileName = "config.properties";
        String propertiesFilePath = getFile(configPropertiesFileName);
        Properties properties = readPropertyValueFromPropertyFile(propertiesFilePath);
        String apkFileName = (String) properties.get("apkFileName");
        String apkFilePath = getFile(apkFileName);
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("appium:automationName", "UiAutomator2");
        caps.setCapability("platformName", "Android");
        caps.setCapability("appium:app", apkFilePath);
        caps.setCapability("appium:deviceName", properties.getProperty("deviceUDID"));
        caps.setCapability("appium:appPackage", "com.spotify.music");
        caps.setCapability("appium:appActivity", "com.spotify.music.MainActivity");
        caps.setCapability("appium:autoGrantPermissions", false);
        caps.setCapability("appium:fullReset", true);

        try {
            androidDriver = new AndroidDriver(new URL(LOCAL_APPIUM_URL), caps);
            androidDriver.setSetting(Setting.WAIT_FOR_IDLE_TIMEOUT, 500);
        } catch (MalformedURLException e) {
            warn(e.getMessage());
        }

        SpotifyScreens.initializeAllPages();
    }

    public static AndroidDriver getAndroidDriver() {
        return androidDriver;
    }

    public static void quitAndroidDriver() {
        getAndroidDriver().quit();
    }

}

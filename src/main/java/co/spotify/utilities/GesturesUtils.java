package co.spotify.utilities;

import co.spotify.SpotifyTestBase;
import io.appium.java_client.AppiumBy;

public class GesturesUtils extends SpotifyTestBase {
    public static void androidScrollingTillTextFound(String textToFound){
            androidDriver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector())" +
                    ".scrollIntoView(new UiSelector().text(\"" + textToFound + "\"));"));
        }
    }

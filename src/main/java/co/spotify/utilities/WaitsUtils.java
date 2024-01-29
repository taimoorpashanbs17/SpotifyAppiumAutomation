package co.spotify.utilities;

import co.spotify.SpotifyTestBase;
import co.spotify.helpers.LogHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static co.spotify.constants.StringConstants.TIME_TO_WAIT;

import java.time.Duration;

public class WaitsUtils extends SpotifyTestBase {

    public static void waitForSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            LogHelper.warn(e.getMessage());
        }
    }

    public static void waitForElementPresence(By elementLocator) {
        try {
            WebDriverWait wait = new WebDriverWait(getAndroidDriver(), Duration.ofSeconds(TIME_TO_WAIT));
            wait.until(ExpectedConditions.presenceOfElementLocated(elementLocator));
        } catch (Exception e) {
            LogHelper.warn(e.getMessage());
        }

    }

    public static void waitForElementToBeClickable(By elementLocator) {
        try {
            WebDriverWait wait = new WebDriverWait(getAndroidDriver(), Duration.ofSeconds(TIME_TO_WAIT));
            wait.until(ExpectedConditions.elementToBeClickable(elementLocator));
        } catch (Exception e) {
            LogHelper.warn(e.getMessage());
        }
    }

    public static void waitForElementToBePresentAndClickable(By elementLocator) {
        waitForElementPresence(elementLocator);
        waitForElementToBeClickable(elementLocator);
    }

    public static void waitForElementToBeInvisible(By elementLocator) {
        try {
            WebDriverWait wait = new WebDriverWait(getAndroidDriver(), Duration.ofSeconds(TIME_TO_WAIT));
            wait.until(ExpectedConditions.invisibilityOfElementLocated(elementLocator));
        } catch (Exception e) {
            LogHelper.warn(e.getMessage());
        }
    }
}

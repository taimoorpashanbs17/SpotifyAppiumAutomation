package co.spotify.utilities;

import co.spotify.SpotifyTestBase;
import static co.spotify.helpers.LogHelper.info;
import static co.spotify.helpers.LogHelper.error;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.util.List;


public class ElementActionUtils extends SpotifyTestBase{
    public static void clickMobileElement(By elementLocator, String elementName) {
        try {
            getAndroidDriver().findElement(elementLocator).click();
            info("Clicked on "+elementName);

        } catch (NoSuchElementException e) {
            error("Unable to click on "+elementName+" due to "+e.getMessage());
        }
    }

    public static void clickMobileElementWithIndex(List<WebElement> listOfElement, Integer indexNumber, String elementName) {
        try {
            listOfElement.get(indexNumber).click();
            info("Clicked on "+elementName);

        } catch (NoSuchElementException e) {
            error("Unable to click on "+elementName+" due to "+e.getMessage());
        }
    }

    public static void sendTextToMobileElement(By elementLocator, String elementName, String textToEnter) {
        try {
            getAndroidDriver().findElement(elementLocator).sendKeys(textToEnter);
            info("Entered "+textToEnter+" on "+elementName+" input field");
        } catch (NoSuchElementException e) {
            error("Unable to Enter " + textToEnter + " on "
                    + elementName + " Field, due to "+e.getMessage());
        }
    }

    public static void clearMobileElementField(By elementLocator, String elementName) {
        try {
            getAndroidDriver().findElement(elementLocator).clear();
            info("Cleared on "+elementName);

        } catch (NoSuchElementException e) {
            error("Unable to click on "+elementName+" due to "+e.getMessage());
        }
    }

    public static void clearMobileElementWithIndex(List<WebElement> listOfElement, Integer indexNumber, String elementName) {
        try {
            listOfElement.get(indexNumber).clear();
            info("Cleared on "+elementName);

        } catch (NoSuchElementException e) {
            error("Unable to click on "+elementName+" due to "+e.getMessage());
        }
    }

    public static void sendTextToMobileElementWithIndex(List<WebElement> listOfElement, Integer indexNumber,
                                                        String textToEnter, String elementName) {
        try {
            listOfElement.get(indexNumber).sendKeys(textToEnter);
            info("Entered "+textToEnter+" on "+elementName+" input field");

        } catch (NoSuchElementException e) {
            error("Unable to click on "+elementName+" due to "+e.getMessage());
        }
    }

    public static String getMobileElementText(By elementLocator, String elementName) {
            String textValue = getAndroidDriver().findElement(elementLocator).getText();
            info("Getting Text of "+elementName);
        return textValue;
    }
}

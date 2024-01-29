package co.spotify.utilities;

import co.spotify.SpotifyTestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static co.spotify.helpers.LogHelper.error;
import static co.spotify.helpers.LogHelper.info;

public class AssertUtils extends SpotifyTestBase {
    public static void verifyMobileElementTextIs(By elementLocator, String elementName, String expectedText) {
        String actualText = getAndroidDriver().findElement(elementLocator).getText();
        if (actualText.equals(expectedText)) {
            info(expectedText + " on " + elementName + " field is showing.");
        } else {
            error("Text of " + elementName + " is not " + expectedText + " , actual text is " + actualText);
        }
    }

    public static void verifyMobileElementWithIndexTextIs(List<WebElement> listOfElement, Integer indexNumber,
                                                          String elementName, String expectedText) {
        String actualText = listOfElement.get(indexNumber).getText();
        if (actualText.equals(expectedText)) {
            info(expectedText + " on " + elementName + " field is showing.");
        } else {
            error("Text of " + elementName + " is not " + expectedText + " , actual text is " + actualText);
        }
    }

    public static void verifyMobileElementContainsText(WebElement webElement, String elementName,
                                                       String containedText) {
        String actualText = webElement.getText();
        if (actualText.contains(containedText)) {
            info(elementName + " does contains [" + containedText + "] Text");
        } else {
            error("Text of " + elementName + " does not contain " + containedText + " , " +
                    "actual text is " + actualText);
        }
    }

    public static void verifyText(String actualText, String expectedText) {
        if (actualText.equals(expectedText)) {
            info(expectedText + " is showing correctly.");
        } else {
            error(expectedText + " is wrong Text as "+actualText+" is Actual Text");
        }
    }
}
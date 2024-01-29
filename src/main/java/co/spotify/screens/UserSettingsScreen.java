package co.spotify.screens;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static co.spotify.utilities.WaitsUtils.waitForElementPresence;

import static co.spotify.helpers.BasicDataStructureHelper.getListOfElementText;
import static co.spotify.helpers.BasicDataStructureHelper.getIndexOfKeyFromList;

import static co.spotify.utilities.AssertUtils.verifyText;

import static co.spotify.utilities.GesturesUtils.androidScrollingTillTextFound;

import static co.spotify.utilities.WaitsUtils.waitForElementToBePresentAndClickable;
import static co.spotify.utilities.ElementActionUtils.clickMobileElement;

public class UserSettingsScreen extends SpotifyScreens{
    public UserSettingsScreen(AndroidDriver androidDriver){
        PageFactory.initElements(androidDriver, this);
    }

    private final By getTextValues = AppiumBy.className("android.widget.TextView");

    private final By logOutButton = AppiumBy.xpath(
            "//android.widget.TextView[@text='Log out']");

    private List<String> getListOfSettingsText(){
        waitForElementPresence(getTextValues);
        return getListOfElementText(androidDriver.findElements(getTextValues));
    }

    @Step("Verify User Email Address from 'Settings' Screen")
    public void verifyUserEmail(String userEmailAddress){
        List<String> listOfSettingsText = getListOfSettingsText();
        Integer getUserEmailIndex = getIndexOfKeyFromList(listOfSettingsText, "Email");
        String userEmailText = listOfSettingsText.get(getUserEmailIndex);
        verifyText(userEmailText, userEmailAddress);
    }

    @Step("Log out the current User")
    public void clickOnLogOutUser(){
        androidScrollingTillTextFound("Log out");
        waitForElementToBePresentAndClickable(logOutButton);
        clickMobileElement(logOutButton, "'Log out' button");
    }

}

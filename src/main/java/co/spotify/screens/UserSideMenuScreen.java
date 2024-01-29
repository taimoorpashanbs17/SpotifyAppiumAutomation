package co.spotify.screens;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import static co.spotify.utilities.WaitsUtils.waitForElementToBePresentAndClickable;

import static co.spotify.utilities.ElementActionUtils.clickMobileElement;

import static co.spotify.utilities.AssertUtils.verifyMobileElementTextIs;

public class UserSideMenuScreen {
    public UserSideMenuScreen(AndroidDriver androidDriver){
        PageFactory.initElements(androidDriver, this);
    }

    private final By settingAndPrivacyMenuButton = AppiumBy.xpath(
            "//android.widget.TextView[@text=\"Settings and privacy\"]");

    private final By loginUserName = AppiumBy.id("com.spotify.music:id/profile_row_sidedrawer_title");

    @Step("Click on 'Settings and Privacy' Button")
    public void clickOnSettingsAndPrivacyMenuButton(){
        waitForElementToBePresentAndClickable(settingAndPrivacyMenuButton);
        clickMobileElement(settingAndPrivacyMenuButton, "'Settings and Privacy' Menu Button");
    }

    @Step("Verify 'Username' from 'Side Menu' Screen")
    public void verifyUserName(String userName){
        waitForElementToBePresentAndClickable(loginUserName);
        verifyMobileElementTextIs(loginUserName, "'User Name' Text", userName);
    }

}

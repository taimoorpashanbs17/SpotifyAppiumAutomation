package co.spotify.screens;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import static co.spotify.utilities.WaitsUtils.waitForElementToBePresentAndClickable;

import static co.spotify.utilities.ElementActionUtils.clickMobileElement;

public class SideTabMenuScreen extends SpotifyScreens{
    public SideTabMenuScreen(AndroidDriver androidDriver){
        PageFactory.initElements(androidDriver, this);
    }

    private final By yourLibraryTabMenuButton = AppiumBy.id("com.spotify.music:id/your_library_tab");

    @Step("Click on 'Your Library' Tab Menu Button")
    public void clickOnYourLibraryTabMenuButton(){
        waitForElementToBePresentAndClickable(yourLibraryTabMenuButton);
        clickMobileElement(yourLibraryTabMenuButton, "'Your Library' Tab menu button");
    }

}

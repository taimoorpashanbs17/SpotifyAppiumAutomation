package co.spotify.screens;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static co.spotify.helpers.BasicDataStructureHelper.getListOfElementText;
import static co.spotify.utilities.AssertUtils.verifyElementIsDisplaying;
import static co.spotify.utilities.AssertUtils.verifyText;

import static co.spotify.utilities.WaitsUtils.waitForElementToBePresentAndClickable;

import static co.spotify.utilities.ElementActionUtils.clickMobileElement;

public class ArtistScreen extends SpotifyScreens{

    private final By textsWithInScreen = AppiumBy.className("android.widget.TextView");
    private final By followButton = AppiumBy.id("com.spotify.music:id/follow_button");
    public ArtistScreen(AndroidDriver androidDriver){
        PageFactory.initElements(androidDriver, this);
    }

    private List<String> getAllTextsWithInScreen(){
        List<WebElement> getAllTexts = getAndroidDriver().findElements(textsWithInScreen);
        return getListOfElementText(getAllTexts);
    }

    @Step("Verify Name of the artist")
    public void verifyArtistName(String artistName){
        String currentViewingArtistName = getAllTextsWithInScreen().get(6);
        verifyText(currentViewingArtistName, artistName);
    }

    @Step("Check Follow button is showing")
    public void verifyFollowingButtonDisplaying(){
        verifyElementIsDisplaying(followButton, "Follow Button");
    }

    @Step("Unfollow The Artist")
    public void unfollowTheArtist(){
        waitForElementToBePresentAndClickable(followButton);
        clickMobileElement(followButton, "Follow Button");
    }
}

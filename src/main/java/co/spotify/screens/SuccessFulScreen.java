package co.spotify.screens;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import static co.spotify.utilities.AssertUtils.verifyMobileElementWithIndexTextIs;

import static co.spotify.utilities.ElementActionUtils.clickMobileElement;
import static co.spotify.utilities.WaitsUtils.*;

import java.util.List;

public class SuccessFulScreen extends SpotifyScreens{
    public SuccessFulScreen(AndroidDriver androidDriver){
        PageFactory.initElements(androidDriver, this);
    }

    private final By successMessage = AppiumBy.className("android.widget.TextView");
    private final By startListeningNowButton = AppiumBy.id("com.spotify.music:id/primary_button");

    private List<WebElement> successMessagesList(){
        waitForElementToBeInvisible(successMessage);
        return getAndroidDriver().findElements(successMessage);
    }

    @Step("Verify Success Messages")
    public void verifySuccessOnBoardingMessage(String userPickMessage, String createdPlaylistMessage){
        List<WebElement> listOfSuccessMessages = successMessagesList();
        verifyMobileElementWithIndexTextIs(listOfSuccessMessages, 0, "Great Pick Lines",
                userPickMessage);
        verifyMobileElementWithIndexTextIs(listOfSuccessMessages, 1, "Created Playlist Lines",
                createdPlaylistMessage);
    }

    @Step("Click on 'Start Listening' Button")
    public void clickOnStartListeningButton(){
        waitForElementToBePresentAndClickable(startListeningNowButton);
        clickMobileElement(startListeningNowButton, "'Start Listening Now' button");
    }
}

package co.spotify.screens;

import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.AppiumBy;

import java.util.List;

import static co.spotify.utilities.WaitsUtils.waitForElementToBePresentAndClickable;

import static co.spotify.utilities.ElementActionUtils.clickMobileElementWithIndex;

public class LandingScreen extends SpotifyScreens {
    public LandingScreen(AndroidDriver androidDriver){
        PageFactory.initElements(androidDriver, this);
    }

    private final By landingScreenButtons = AppiumBy.className("android.widget.Button");

    private List<WebElement> getLoginButtons(){
        waitForElementToBePresentAndClickable(landingScreenButtons);
        return getAndroidDriver().findElements(landingScreenButtons);
    }

    @Step("Click on 'Sign Up Free' button")
    public void clickOnSignUpFreeButton(){
        clickMobileElementWithIndex(getLoginButtons(), 0, "'Sign Up Free' Button");
    }

    @Step("Click on 'Login' button")
    public void clickOnLoginButton(){
        clickMobileElementWithIndex(getLoginButtons(), 3, "'Log in' Button");
    }
}

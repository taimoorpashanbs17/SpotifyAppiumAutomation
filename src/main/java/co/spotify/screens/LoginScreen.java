package co.spotify.screens;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import static co.spotify.utilities.ElementActionUtils.sendTextToMobileElement;
import static co.spotify.utilities.ElementActionUtils.clickMobileElement;
import static co.spotify.utilities.ElementActionUtils.switchingToWebView;
import static co.spotify.utilities.ElementActionUtils.clearMobileElementField;

import static co.spotify.utilities.WaitsUtils.waitForElementToBePresentAndClickable;
import static co.spotify.utilities.WaitsUtils.waitForElementToBeClickable;
import static co.spotify.utilities.WaitsUtils.waitForElementToBeInvisible;



public class LoginScreen extends SpotifyScreens{
    public LoginScreen(AndroidDriver androidDriver){
        PageFactory.initElements(androidDriver, this);
    }

    private final By emailUserNameTextField = AppiumBy.id("com.spotify.music:id/username_text");

    private final By emailWebField = By.id("login-username");
    private final By passwordWebField = By.id("login-password");
    private final By loginWebButton = By.id("login-button");

    private final By passwordTextField = AppiumBy.id("com.spotify.music:id/password_text");
    private final By loginButton = AppiumBy.id("com.spotify.music:id/login_button");
    private final By loadingLoader = AppiumBy.accessibilityId("Loading");

    private void sendTextToTextField(By mobileElementField, String elementName, String textToEnter) throws InterruptedException {
        switchingToWebView();
        waitForElementToBePresentAndClickable(mobileElementField);
        clickMobileElement(mobileElementField, elementName);
        clearMobileElementField(mobileElementField, elementName);
        sendTextToMobileElement(mobileElementField, elementName, textToEnter);
    }

    @Step("Enter 'Email/UserName'")
    public void enterEmailUser(String emailUserName) throws InterruptedException {
        sendTextToTextField(emailWebField, "'Email/Username' field", emailUserName);
    }

    @Step("Enter 'Password'")
    public void enterPassword(String password) throws InterruptedException {
        sendTextToTextField(passwordWebField, "'Password' field", password);
    }

    @Step("Click on 'Login' button")
    public void clickOnLoginButton(){
        waitForElementToBeClickable(loginWebButton);
        clickMobileElement(loginWebButton, "'Login' Button");
    }

    @Step("Navigating to Home Screen")
    public void navigatingToHomeScreen(){
        waitForElementToBeInvisible(loadingLoader);
    }

}

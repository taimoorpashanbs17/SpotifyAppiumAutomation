package spotifyDemoTest;

import io.qameta.allure.*;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Properties;

import static co.spotify.constants.UserInformationConstants.DATE_OF_BIRTH;
import static co.spotify.constants.UserInformationConstants.USER_LAST_NAME;
import static co.spotify.constants.UserInformationConstants.USER_FIRST_NAME;
import static co.spotify.constants.UserInformationConstants.USER_EMAIL;
import static co.spotify.constants.UserInformationConstants.PASSWORD;
import static co.spotify.constants.UserInformationConstants.USER_GENDER;
import static co.spotify.constants.UserInformationConstants.LOGIN_USER_EMAIL;

import static co.spotify.constants.ArtistInformationConstants.FIRST_ARTIST;
import static co.spotify.constants.ArtistInformationConstants.SECOND_ARTIST;
import static co.spotify.constants.ArtistInformationConstants.THIRD_ARTIST;

import static co.spotify.constants.TextMessagesConstants.GREAT_PICKS_TEXT;
import static co.spotify.constants.TextMessagesConstants.CREATED_PLAYLIST_TEXT;

import static co.spotify.helpers.GenerateRandomValuesHelper.generateRandomEmail;

import static co.spotify.screens.SpotifyScreens.*;
import static co.spotify.helpers.PathHelper.getFile;
import static co.spotify.utilities.PropertiesUtils.readPropertyValueFromPropertyFile;
import static co.spotify.utilities.PropertiesUtils.writePropertyValueInPropertyFile;

@Epic("Spotify Demo Tests")
public class SpotifyRegistrationLoginTest extends BaseTest{

    @Test(priority = 1, testName = "Sign Up Free feature",
            description = "Create a new user, select three artists, start working")
    @Severity(SeverityLevel.CRITICAL)
    @Story("User creates his Accounts")
    public static void verifyUserRegistration() throws IOException {
        String artistPropertiesFileName = "userInformation.properties";
        String propertiesFilePath = getFile(artistPropertiesFileName);
        Properties properties = readPropertyValueFromPropertyFile(propertiesFilePath);
        generateRandomEmail();
        landingScreen.clickOnSignUpFreeButton();
        createNewAccountScreen.enterEmailAddress(USER_EMAIL);
        createNewAccountScreen.enterPassword(PASSWORD);
        createNewAccountScreen.enterDateOfBirth(DATE_OF_BIRTH);
        createNewAccountScreen.selectGender(USER_GENDER);
        createNewAccountScreen.enterNameOnWhatsYourNameField(USER_FIRST_NAME +" "+USER_LAST_NAME);
        createNewAccountScreen.doNotAcceptNotifications();
        pickThreeArtistsScreen.selectFirstArtist(FIRST_ARTIST);
        pickThreeArtistsScreen.selectOtherArtist(SECOND_ARTIST);
        pickThreeArtistsScreen.selectOtherArtist(THIRD_ARTIST);
        pickThreeArtistsScreen.clickOnDoneButton();
        successFulScreen.verifySuccessOnBoardingMessage(GREAT_PICKS_TEXT, CREATED_PLAYLIST_TEXT);
        successFulScreen.clickOnStartListeningButton();
        homeScreen.clickOnProfileButton();
        userSideMenuScreen.verifyUserName(USER_FIRST_NAME +" "+USER_LAST_NAME);
        userSideMenuScreen.clickOnSettingsAndPrivacyMenuButton();
        writePropertyValueInPropertyFile(propertiesFilePath, "loginEmail",
                properties.getProperty("registeredEmail"));
        userSettingsScreen.verifyUserEmail(USER_EMAIL);
    }

    @Test(priority = 2, testName = "Log In User",
            description = "Login user with valid and Authorize Email Credentials, then verify certain Information" +
                    "and log User out.")
    @Severity(SeverityLevel.CRITICAL)
    @Story("User logins with his Information")
    public static void verifyUserLoginAndItsInformation() {
        landingScreen.clickOnLoginButton();
        loginScreen.enterEmailUser(LOGIN_USER_EMAIL);
        loginScreen.enterPassword(PASSWORD);
        loginScreen.clickOnLoginButton();
        loginScreen.navigatingToHomeScreen();
        homeScreen.clickOnProfileButton();
        userSideMenuScreen.verifyUserName(USER_FIRST_NAME +" "+USER_LAST_NAME);
        userSideMenuScreen.clickOnSettingsAndPrivacyMenuButton();
        userSettingsScreen.verifyUserEmail(LOGIN_USER_EMAIL);
        userSettingsScreen.clickOnLogOutUser();
    }
}

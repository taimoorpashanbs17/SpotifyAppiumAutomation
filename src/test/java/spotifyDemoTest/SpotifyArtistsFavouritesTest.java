package spotifyDemoTest;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

import static co.spotify.constants.UserInformationConstants.*;
import static co.spotify.screens.SpotifyScreens.*;

import static co.spotify.constants.ArtistInformationConstants.*;

public class SpotifyArtistsFavouritesTest extends BaseTest{
    @Test(priority = 1, testName = "Check All Artist Selected Showing",
            description = "Login user with valid and Check All Artists which were selected, are displaying at 'Your Library'")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Check My Library")
    public static void verifyUserSelectedArtists() throws InterruptedException {
        landingScreen.clickOnLoginButton();
        loginScreen.enterEmailUser(LOGIN_USER_EMAIL);
        loginScreen.enterPassword(PASSWORD);
        loginScreen.clickOnLoginButton();
        homeScreen.clickOnMayBeLaterLink();
        loginScreen.navigatingToHomeScreen();
        sideTabMenuScreen.clickOnYourLibraryTabMenuButton();
        yourLibraryScreen.clickOnArtistOnlyButton();
        yourLibraryScreen.verifyYourLibraryShowingSelectedArtists();
    }


    @Test(priority = 2, testName = "Adding and Removing Artists and verifying on 'Your Library'",
            description = "Adding New Artists and verifying that it has been added and doing same step for removing it'")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Check My Library")
    public static void verifyAddingAndRemovingArtists() throws InterruptedException {
        landingScreen.clickOnLoginButton();
        loginScreen.enterEmailUser(LOGIN_USER_EMAIL);
        loginScreen.enterPassword(PASSWORD);
        loginScreen.clickOnLoginButton();
        homeScreen.clickOnMayBeLaterLink();
        loginScreen.navigatingToHomeScreen();
        sideTabMenuScreen.clickOnYourLibraryTabMenuButton();
        yourLibraryScreen.clickOnArtistOnlyButton();
        chooseYourArtistsScreen.selectArtistFromText(FOURTH_ARTIST);
        chooseYourArtistsScreen.clickOnDoneButton();
        yourLibraryScreen.verifyLatestArtistAdded(FOURTH_ARTIST);
        yourLibraryScreen.selectArtistFromArtistList(FOURTH_ARTIST);
        artistScreen.verifyArtistName(FOURTH_ARTIST);
        artistScreen.verifyFollowingButtonDisplaying();
        artistScreen.unfollowTheArtist();
    }


}

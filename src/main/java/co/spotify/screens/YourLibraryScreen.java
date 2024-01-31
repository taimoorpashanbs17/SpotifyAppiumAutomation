package co.spotify.screens;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

import static co.spotify.utilities.WaitsUtils.waitForElementToBePresentAndClickable;
import static co.spotify.utilities.WaitsUtils.waitForElementPresence;

import static co.spotify.utilities.ElementActionUtils.clickMobileElement;

import static co.spotify.helpers.BasicDataStructureHelper.getListOfElementText;
import static co.spotify.helpers.BasicDataStructureHelper.gettingListOfArtists;

import static co.spotify.utilities.AssertUtils.comparingTwoLists;
import static co.spotify.utilities.AssertUtils.verifyText;

import static co.spotify.constants.ArtistInformationConstants.*;


public class YourLibraryScreen extends SpotifyScreens{
    public YourLibraryScreen(AndroidDriver androidDriver){
        PageFactory.initElements(androidDriver, this);
    }

    private final By artistsOnlyButton = AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"Add artists, \"]");

    private final By textValuesWithinPage = AppiumBy.className("android.widget.TextView");

    @Step("Click on 'Artists' button")
    public void clickOnArtistOnlyButton(){
        waitForElementToBePresentAndClickable(artistsOnlyButton);
        clickMobileElement(artistsOnlyButton, "Artist Only Button");
    }

    private List<String> getListOfTextInYourLibraryScreen(){
        waitForElementPresence(textValuesWithinPage);
        return getListOfElementText(androidDriver.findElements(textValuesWithinPage));
    }

    private List<String> getListOfAllArtistInYourLibrary() {
        List<String> listOfAllTexts = getListOfTextInYourLibraryScreen();
        return gettingListOfArtists(listOfAllTexts);
    }

    private List<String> getListOfAddedArtists(){
        List<String> addedArtist = new ArrayList<>();
        addedArtist.add(FIRST_ARTIST);
        addedArtist.add(SECOND_ARTIST);
        addedArtist.add(THIRD_ARTIST);
        return addedArtist;
    }

    @Step("'Your Library' is showing 'Selected Artists'")
    public void verifyYourLibraryShowingSelectedArtists(){
        String successMessage = "'Your Library' is correct List";
        String warningMessage = "Some Artists are not showing on your 'Your Library'";
        List<String> yourLibraryArtistList = getListOfAllArtistInYourLibrary();
        List<String> addedArtistsList = getListOfAddedArtists();
        comparingTwoLists(addedArtistsList, yourLibraryArtistList, successMessage, warningMessage);
    }

    @Step("Check Latest Artist Added on 'Your Library'")
    public void verifyLatestArtistAdded(String artistName){
        waitForElementToBePresentAndClickable(artistsOnlyButton);
        List<String> yourLibraryArtistList = getListOfAllArtistInYourLibrary();
        String latestArtist = yourLibraryArtistList.get(0);
        verifyText(latestArtist, artistName);
    }

    @Step("Select Added Artist from 'Your Library'")
    public void selectArtistFromArtistList(String artistName){
        By selectedArtistLocator = By.xpath("//android.view.ViewGroup[@content-desc=\""+artistName+", Artist, \"]/android.widget.TextView[1]");
        waitForElementToBePresentAndClickable(selectedArtistLocator);
        clickMobileElement(selectedArtistLocator, "Clicked at "+artistName);
    }

}

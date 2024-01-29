package co.spotify.screens;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

import static co.spotify.constants.ArtistInformationConstants.FIRST_ARTIST;
import static co.spotify.constants.ArtistInformationConstants.SECOND_ARTIST;
import static co.spotify.constants.ArtistInformationConstants.THIRD_ARTIST;

import static co.spotify.utilities.WaitsUtils.waitForElementToBePresentAndClickable;
import static co.spotify.helpers.BasicDataStructureHelper.checkArtistNameDisplayingWithinList;

import static co.spotify.utilities.ElementActionUtils.getMobileElementText;
import static co.spotify.utilities.ElementActionUtils.clickMobileElement;

import static co.spotify.helpers.LogHelper.info;


public class HomeScreen {
    public HomeScreen(AndroidDriver androidDriver){
        PageFactory.initElements(androidDriver, this);
    }

    private final By onGoingSongArtistName = AppiumBy.id("com.spotify.music:id/track_info_view_subtitle");

    private final By userLogoButton = AppiumBy.id("com.spotify.music:id/faceheader_image");

    private final By mayBeLaterButton = AppiumBy.id("com.spotify.music:id/later_button");

    private List<String> getArtistList(){
        List<String> artistsList = new ArrayList<>();
        artistsList.add(FIRST_ARTIST);
        artistsList.add(SECOND_ARTIST);
        artistsList.add(THIRD_ARTIST);
        return artistsList;
    }

    @Step("Verify Artist Name with Ongoing Media")
    public void verifyOnGoingSongIsOffSelectedArtist(){
        List<String> artistLists = getArtistList();
        waitForElementToBePresentAndClickable(onGoingSongArtistName);
        String artistNameText = getMobileElementText(onGoingSongArtistName, "On Going Artist Link");
        System.out.println("artist name is "+artistNameText);
        System.out.println("List is "+artistLists);
        checkArtistNameDisplayingWithinList(artistLists, artistNameText);
    }

    @Step("Click on 'May be Later' Button")
    public void clickOnMayBeLaterLink(){
        try{
            waitForElementToBePresentAndClickable(mayBeLaterButton);
            clickMobileElement(mayBeLaterButton, "'May be later' Button");
        }
        catch (NoSuchElementException e){
            info(e.getMessage());
        }
    }

    @Step("Click on 'Profile' Button")
    public void clickOnProfileButton(){
        waitForElementToBePresentAndClickable(userLogoButton);
        clickMobileElement(userLogoButton, "User Login Button");
    }
}

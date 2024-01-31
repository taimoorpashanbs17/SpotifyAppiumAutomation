package co.spotify.screens;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.By;

import static co.spotify.utilities.WaitsUtils.waitForElementToBePresentAndClickable;
import static co.spotify.utilities.WaitsUtils.waitForElementToBeInvisible;

import static co.spotify.utilities.ElementActionUtils.sendTextToMobileElement;
import static co.spotify.utilities.ElementActionUtils.clickMobileElement;

import static co.spotify.utilities.GesturesUtils.androidScrollingTillTextFound;

public class ChooseYourArtistsScreen extends SpotifyScreens{
    public ChooseYourArtistsScreen(AndroidDriver androidDriver){
        PageFactory.initElements(androidDriver, this);
    }

    private final By searchField = AppiumBy.id("com.spotify.music:id/search_field_root");
    private final By queryField = AppiumBy.id("com.spotify.music:id/query");

    private final By doneButton = AppiumBy.id("com.spotify.music:id/actionButton");


    private void clickOnField(By elementField, String fieldName){
        waitForElementToBePresentAndClickable(elementField);
        clickMobileElement(elementField, fieldName);
    }

    public void selectArtistFromText(String artistName){
        waitForElementToBePresentAndClickable(doneButton);
        androidScrollingTillTextFound(artistName);
        String artistThumbNailXpath = "//android.widget.TextView[@text='"+artistName+"']";
        By artistLocator = AppiumBy.xpath(artistThumbNailXpath);
        waitForElementToBePresentAndClickable(artistLocator);
        clickMobileElement(artistLocator, artistName+" as a Artist selected");
    }



    @Step("Selecting First Artist")
    public void selectFirstArtist(String artistName){
        clickOnField(searchField, "Search Field");
        clickOnField(queryField, "Query Field");
        sendTextToMobileElement(queryField, "Query Field", artistName);
        String searchedSingerXpath = "//android.widget.TextView[@text='"+artistName+"']";
        By searchedSingerLocator = AppiumBy.xpath(searchedSingerXpath);
        waitForElementToBePresentAndClickable(searchedSingerLocator);
        clickOnField(searchedSingerLocator, artistName+" Link");
    }

    @Step("Selecting other two Artist")
    public void selectOtherArtist(String artistName){
        waitForElementToBeInvisible(queryField);
        clickOnField(searchField, "Search Field");
        clickOnField(queryField, "Query Field");
        sendTextToMobileElement(queryField, "Query Field", artistName);
        String searchedSingerXpath = "//android.widget.TextView[@text='"+artistName+"']";
        By searchedSingerLocator = AppiumBy.xpath(searchedSingerXpath);
        waitForElementToBePresentAndClickable(searchedSingerLocator);
        clickOnField(searchedSingerLocator, artistName+" Link");
    }

    @Step("Click on 'Done' Button")
    public void clickOnDoneButton(){
        waitForElementToBePresentAndClickable(doneButton);
        clickMobileElement(doneButton, "Done Button");
    }



}

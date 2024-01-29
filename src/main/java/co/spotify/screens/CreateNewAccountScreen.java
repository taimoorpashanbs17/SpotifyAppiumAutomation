package co.spotify.screens;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static co.spotify.utilities.WaitsUtils.waitForElementToBeClickable;
import static co.spotify.utilities.WaitsUtils.waitForElementToBePresentAndClickable;
import static co.spotify.utilities.WaitsUtils.waitForElementToBeInvisible;

import static co.spotify.utilities.ElementActionUtils.sendTextToMobileElement;
import static co.spotify.utilities.ElementActionUtils.sendTextToMobileElementWithIndex;
import static co.spotify.utilities.ElementActionUtils.clickMobileElement;
import static co.spotify.utilities.ElementActionUtils.clearMobileElementField;

import static co.spotify.utilities.ElementActionUtils.clickMobileElementWithIndex;
import static co.spotify.utilities.ElementActionUtils.clearMobileElementWithIndex;

public class CreateNewAccountScreen extends SpotifyScreens {
    public CreateNewAccountScreen(AndroidDriver androidDriver){
        PageFactory.initElements(androidDriver, this);
    }

    private final By emailAddressField = AppiumBy.id("com.spotify.music:id/email");
    private final By emailNextButton = AppiumBy.id("com.spotify.music:id/email_next_button");

    private final By passwordField = AppiumBy.id("com.spotify.music:id/input_password");

    private final By passwordNextButton = AppiumBy.id("com.spotify.music:id/password_next_button");

    private final By datePickerFields = AppiumBy.className("android.widget.EditText");
    private final By ageNextButton = AppiumBy.id("com.spotify.music:id/age_next_button");
    private final By loadingLoader = AppiumBy.accessibilityId("Loading");

    private final By whatsYourNameField = AppiumBy.id("com.spotify.music:id/name");
    private final By nameNextButton = AppiumBy.id("com.spotify.music:id/name_next_button");
    private final By declineNotificationsButton = AppiumBy.id("com.spotify.music:id/decline");

    private void clickNextButton(By nextButton, String elementName){
        waitForElementToBeClickable(nextButton);
        clickMobileElement(nextButton, elementName);
    }

    private List<WebElement> getDatePickerTextFields(){
        waitForElementToBePresentAndClickable(datePickerFields);
        return getAndroidDriver().findElements(datePickerFields);
    }

    private void enterValuesOnDate(Integer index, String textToEnter, String elementName){
        List<WebElement> datePickerFields = getDatePickerTextFields();
        clickMobileElementWithIndex(datePickerFields, index, elementName);
        clearMobileElementWithIndex(datePickerFields, index, elementName);
        sendTextToMobileElementWithIndex(datePickerFields, index, textToEnter, elementName);
    }

    @Step("Enter Email Address")
    public void enterEmailAddress(String emailAddress){
        waitForElementToBePresentAndClickable(emailAddressField);
        sendTextToMobileElement(emailAddressField, "Email Address Field", emailAddress);
        clickNextButton(emailNextButton, "'Email Next' Button");
    }

    @Step("Enter Password")
    public void enterPassword(String password){
        waitForElementToBePresentAndClickable(passwordField);
        sendTextToMobileElement(passwordField, "Password Field", password);
        clickNextButton(passwordNextButton, "'Password Next' Button");
    }

    @Step("Enter Date of Birth")
    public void enterDateOfBirth(String dateOfBirth){
        Integer month = 0;
        Integer date = 1;
        Integer year = 2;
        String dateText = dateOfBirth.substring(0, 2);
        String monthText = dateOfBirth.substring(3, 6);
        String yearText = dateOfBirth.substring(7, 11);
        enterValuesOnDate(month, monthText, "Month Text");
        enterValuesOnDate(date, dateText, "Date Text");
        enterValuesOnDate(year, yearText, "Year Text");
        clickMobileElementWithIndex(getDatePickerTextFields(), 0, "Month Text");
        clickNextButton(ageNextButton, "'Age Next' Button");
    }

    @Step("Select 'Male' as Gender")
    public void selectGender(String gender){
        String genderSelected = gender.toLowerCase();
        String genderLocator = "com.spotify.music:id/gender_button_"+genderSelected;
        By selectedGenderButton = AppiumBy.id(genderLocator);
        waitForElementToBePresentAndClickable(selectedGenderButton);
        clickNextButton(selectedGenderButton, genderSelected+" Gender Button");
    }

    @Step("Enter Name on 'What's Your name?' field")
    public void enterNameOnWhatsYourNameField(String name){
        waitForElementToBePresentAndClickable(whatsYourNameField);
        clickNextButton(whatsYourNameField, "'What's Your name?' field");
        clearMobileElementField(whatsYourNameField, "'What's Your name?' field");
        sendTextToMobileElement(whatsYourNameField, "'What's Your name?' field", name);
        clickNextButton(nameNextButton, "'Name' Next Button");
    }

    @Step("Don't Accept Notifications")
    public void doNotAcceptNotifications(){
        waitForElementToBeInvisible(loadingLoader);
        waitForElementToBePresentAndClickable(declineNotificationsButton);
        clickMobileElement(declineNotificationsButton, "Decline Notifications Button");
    }

}

package co.spotify.screens;
import co.spotify.SpotifyTestBase;


public class SpotifyScreens extends SpotifyTestBase {

    public static LandingScreen landingScreen;
    public static CreateNewAccountScreen createNewAccountScreen;
    public static PickThreeArtistsScreen pickThreeArtistsScreen;
    public static SuccessFulScreen successFulScreen;
    public static HomeScreen homeScreen;
    public static UserSideMenuScreen userSideMenuScreen;
    public static UserSettingsScreen userSettingsScreen;
    public static LoginScreen loginScreen;
    public static SideTabMenuScreen sideTabMenuScreen;

    public static void initializeAllPages(){
        landingScreen = new LandingScreen(getAndroidDriver());
        createNewAccountScreen = new CreateNewAccountScreen(getAndroidDriver());
        pickThreeArtistsScreen = new PickThreeArtistsScreen(getAndroidDriver());
        successFulScreen = new SuccessFulScreen(getAndroidDriver());
        homeScreen = new HomeScreen(getAndroidDriver());
        userSideMenuScreen = new UserSideMenuScreen(getAndroidDriver());
        userSettingsScreen = new UserSettingsScreen(getAndroidDriver());
        loginScreen = new LoginScreen(getAndroidDriver());
        sideTabMenuScreen = new SideTabMenuScreen(getAndroidDriver());
    }

}

package co.spotify.screens;
import co.spotify.SpotifyTestBase;


public class SpotifyScreens extends SpotifyTestBase {

    public static LandingScreen landingScreen;
    public static CreateNewAccountScreen createNewAccountScreen;
    public static ChooseYourArtistsScreen chooseYourArtistsScreen;
    public static SuccessFulScreen successFulScreen;
    public static HomeScreen homeScreen;
    public static UserSideMenuScreen userSideMenuScreen;
    public static UserSettingsScreen userSettingsScreen;
    public static LoginScreen loginScreen;
    public static SideTabMenuScreen sideTabMenuScreen;
    public static YourLibraryScreen yourLibraryScreen;
    public static ArtistScreen artistScreen;

    public static void initializeAllPages(){
        landingScreen = new LandingScreen(getAndroidDriver());
        createNewAccountScreen = new CreateNewAccountScreen(getAndroidDriver());
        chooseYourArtistsScreen = new ChooseYourArtistsScreen(getAndroidDriver());
        successFulScreen = new SuccessFulScreen(getAndroidDriver());
        homeScreen = new HomeScreen(getAndroidDriver());
        userSideMenuScreen = new UserSideMenuScreen(getAndroidDriver());
        userSettingsScreen = new UserSettingsScreen(getAndroidDriver());
        loginScreen = new LoginScreen(getAndroidDriver());
        sideTabMenuScreen = new SideTabMenuScreen(getAndroidDriver());
        yourLibraryScreen = new YourLibraryScreen(getAndroidDriver());
        artistScreen = new ArtistScreen(getAndroidDriver());
    }

}

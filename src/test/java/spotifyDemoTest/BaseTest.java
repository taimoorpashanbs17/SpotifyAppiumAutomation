package spotifyDemoTest;

import co.spotify.SpotifyTestBase;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest extends SpotifyTestBase {

    @BeforeMethod(alwaysRun = true)
    public void setup(){
        createAndroidDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        quitAndroidDriver();
    }

}

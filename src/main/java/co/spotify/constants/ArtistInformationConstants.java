package co.spotify.constants;

import java.util.Properties;

import static co.spotify.helpers.PathHelper.getFile;
import static co.spotify.utilities.PropertiesUtils.readPropertyValueFromPropertyFile;

public class ArtistInformationConstants {
    static String artistPropertiesFileName = "artistInformation.properties";
    static String propertiesFilePath = getFile(artistPropertiesFileName);
    static Properties properties = readPropertyValueFromPropertyFile(propertiesFilePath);

    public static final String FIRST_ARTIST = properties.getProperty("firstArtist");
    public static final String SECOND_ARTIST = properties.getProperty("secondArtist");
    public static final String THIRD_ARTIST = properties.getProperty("thirdArtist");
}

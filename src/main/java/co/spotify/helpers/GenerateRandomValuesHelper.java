package co.spotify.helpers;

import java.io.IOException;

import static co.spotify.constants.UserInformationConstants.USER_FIRST_NAME;
import static co.spotify.constants.UserInformationConstants.USER_LAST_NAME;

import static co.spotify.helpers.PathHelper.getFile;
import static co.spotify.utilities.PropertiesUtils.writePropertyValueInPropertyFile;

public class GenerateRandomValuesHelper {
    public static void generateRandomEmail() throws IOException {
        int n = 6;
        String alphaNumericString = "0123456789"
                + "abcdefghijklmnopqrstuvxyz";
        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {
            int index
                    = (int)(alphaNumericString.length()
                    * Math.random());
            sb.append(alphaNumericString
                    .charAt(index));
        }
        String randomString = sb.toString();
        String randomEmailAddress = USER_FIRST_NAME.toLowerCase()+"_"
                +USER_LAST_NAME.toLowerCase()+"_"+randomString+"@gmail.com";
        String artistPropertiesFileName = "userInformation.properties";
        String propertiesFilePath = getFile(artistPropertiesFileName);
        writePropertyValueInPropertyFile(propertiesFilePath, "registeredEmail", randomEmailAddress);
    }
}

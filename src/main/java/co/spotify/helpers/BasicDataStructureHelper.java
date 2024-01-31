package co.spotify.helpers;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BasicDataStructureHelper {
    public static List<String> createListFromSingerText(String artistText){
        return Stream.of(artistText.split(", ", -1))
                .collect(Collectors.toList());
    }

    public static boolean checkArtistNameDisplayingWithinList(List<String> listOfArtists, String artistName){
        List<String> listOfSingers = createListFromSingerText(artistName);
        listOfArtists.forEach(bigtext -> {
            listOfSingers.forEach(service -> {
                assert bigtext.contains(service);
            });
        });
        return false;
    }

    public static List<String> getListOfElementText(List<WebElement> listOfElements){
        List<String> listOfElementsValues = new ArrayList<>();
        for(WebElement el : listOfElements) {
            listOfElementsValues.add(el.getText());
        }
        return listOfElementsValues;
    }

    public static Integer getIndexOfKeyFromList(List<String> listOfElements, String keyName){
        return listOfElements.indexOf(keyName) + 1;
    }

    public static List<String> gettingListOfArtists(List<String> listProvided){
        int sizeOfList = listProvided.size();
        int lastIndexOfList = sizeOfList -1;
        listProvided.remove(lastIndexOfList);
        int indexTillDataRemoved = listProvided.indexOf("Artists") + 1;
        listProvided.subList(0, indexTillDataRemoved).clear();
        return listProvided;
    }
}
package utils;

import model.Media;

import java.util.Comparator;
import java.util.List;

public class SortingUtils {

    public static void sortByTitle(List<Media> list) {
        list.sort(Comparator.comparing(Media::getTitle));
    }

    public static void sortByDurationDesc(List<Media> list) {
        list.sort((a, b) -> Integer.compare(b.getDuration(), a.getDuration()));
    }
}





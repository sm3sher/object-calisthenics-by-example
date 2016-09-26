package pl.timbercode.books_and_bits.after.utils;

import java.util.ArrayList;
import java.util.List;

public class ListSorter {

    public static <T> List<T> sorted(List<T> elements) {
        List<T> sortedResults = new ArrayList<>();
        sortedResults.addAll(elements);
        sortedResults.sort(null);
        return sortedResults;
    }

}
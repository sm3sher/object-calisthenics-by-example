package pl.timbercode.books_and_bits.after.search;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import static pl.timbercode.books_and_bits.after.utils.ListSorter.sorted;

public class SearchResults<R extends SearchResult> implements Iterable<R> {

    private final List<R> collectedResults = new LinkedList<>();

    public void add(R resultToCollect) {
        collectedResults.add(resultToCollect);
    }

    @Override
    public Iterator<R> iterator() {
        return sorted(collectedResults).iterator();
    }

    public Stream<? extends SearchResult> stream() {
        return StreamSupport.stream(spliterator(), false);
    }

}
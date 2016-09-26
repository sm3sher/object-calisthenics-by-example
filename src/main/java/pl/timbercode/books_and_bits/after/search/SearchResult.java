package pl.timbercode.books_and_bits.after.search;

@SuppressWarnings("WeakerAccess")
public interface SearchResult<R extends SearchResult> extends Comparable<R> {

    String asText();

}
package pl.timbercode.books_and_bits.after.search;

import pl.timbercode.books_and_bits.after.ratings.RatedBook;

import static java.lang.String.format;

public class ByReaderSearchResult implements SearchResult<ByReaderSearchResult> {

    private final RatedBook ratedBook;

    public ByReaderSearchResult(RatedBook ratedBook) {
        this.ratedBook = ratedBook;
    }

    @Override
    public String asText() {
        return format(
                "%s [%s/%s]",
                ratedBook.title().asText(),
                ratedBook.ratingValue().asText(),
                ratedBook.ratingMaxAllowedValue().asText()
        );
    }

    @Override
    public int compareTo(ByReaderSearchResult otherResult) {
        if (ratedBook.hasTitleAlphabeticallyEarlierThan(otherResult.ratedBook)) {
            return 1;
        }
        if (otherResult.ratedBook.hasTitleAlphabeticallyEarlierThan(ratedBook)) {
            return -1;
        }
        return 0;
    }

}
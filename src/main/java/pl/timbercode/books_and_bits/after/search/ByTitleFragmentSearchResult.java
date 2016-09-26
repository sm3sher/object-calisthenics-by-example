package pl.timbercode.books_and_bits.after.search;

import pl.timbercode.books_and_bits.after.ratings.ReadersBookRating;

import static java.lang.String.format;

public class ByTitleFragmentSearchResult implements SearchResult<ByTitleFragmentSearchResult> {

    private final ReadersBookRating readersBookRating;

    public ByTitleFragmentSearchResult(ReadersBookRating readersBookRating) {
        this.readersBookRating = readersBookRating;
    }

    @Override
    public String asText() {
        return format(
                "%s: %s [%s/%s]",
                readersBookRating.readerName().asText(),
                readersBookRating.bookTitle().asText(),
                readersBookRating.ratingValue().asText(),
                readersBookRating.ratingMaxAllowedValue().asText()
        );
    }

    @Override
    public int compareTo(ByTitleFragmentSearchResult otherResult) {
        if (readersBookRating.hasRatingHigherThan(otherResult.readersBookRating)) {
            return -1;
        }
        if (otherResult.readersBookRating.hasRatingHigherThan(readersBookRating)) {
            return 1;
        }
        return 0;
    }

}
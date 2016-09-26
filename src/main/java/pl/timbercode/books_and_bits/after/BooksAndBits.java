package pl.timbercode.books_and_bits.after;

import pl.timbercode.books_and_bits.after.ratings.RatedBook;
import pl.timbercode.books_and_bits.after.ratings.ReadersBookRating;
import pl.timbercode.books_and_bits.after.ratings.ReadersBooksRatings;
import pl.timbercode.books_and_bits.after.readers.Reader;
import pl.timbercode.books_and_bits.after.search.ByReaderSearchResult;
import pl.timbercode.books_and_bits.after.search.ByTitleFragmentSearchResult;
import pl.timbercode.books_and_bits.after.search.MatchCondition;
import pl.timbercode.books_and_bits.after.search.SearchResults;

@SuppressWarnings("WeakerAccess")
class BooksAndBits {

    private final ReadersBooksRatings readersBooksRatings = new ReadersBooksRatings();

    void registerReader(Reader reader) {
        readersBooksRatings.addReader(reader);
    }

    public SearchResults<ByReaderSearchResult> booksReadBy(Reader reader) {
        SearchResults<ByReaderSearchResult> results = new SearchResults<>();
        readersBooksRatings.ratedBooksOf(reader)
                           .stream()
                           .map(ratedBook -> new ByReaderSearchResult(ratedBook))
                           .forEach(result -> results.add(result));
        return results;
    }

    public void addBookRating(Reader reader, RatedBook ratedBook) {
        readersBooksRatings.addRating(reader, ratedBook);
    }

    public SearchResults<ByTitleFragmentSearchResult> findBooksWithTitleMatching(MatchCondition<ReadersBookRating> matchCondition) {
        SearchResults<ByTitleFragmentSearchResult> results = new SearchResults<>();
        readersBooksRatings.allRatedBooks()
                           .stream()
                           .filter(readersRating -> matchCondition.isSatisfiedBy(readersRating))
                           .map(readersRating -> new ByTitleFragmentSearchResult(readersRating))
                           .forEach(result -> results.add(result));
        return results;
    }

}
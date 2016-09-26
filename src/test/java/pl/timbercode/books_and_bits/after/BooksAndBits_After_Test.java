package pl.timbercode.books_and_bits.after;

import pl.timbercode.books_and_bits.BooksAndBits_Test;
import pl.timbercode.books_and_bits.after.books.Book;
import pl.timbercode.books_and_bits.after.books.BookTitle;
import pl.timbercode.books_and_bits.after.ratings.CaseInsensitiveReadersBookRatingMatchByTitleCondition;
import pl.timbercode.books_and_bits.after.ratings.RatedBook;
import pl.timbercode.books_and_bits.after.ratings.Rating;
import pl.timbercode.books_and_bits.after.ratings.ReadersBookRating;
import pl.timbercode.books_and_bits.after.readers.Reader;
import pl.timbercode.books_and_bits.after.readers.ReaderNotFoundException;
import pl.timbercode.books_and_bits.after.search.BookTitleFragment;
import pl.timbercode.books_and_bits.after.search.MatchCondition;

import static java.util.stream.Collectors.toList;

public class BooksAndBits_After_Test extends BooksAndBits_Test {

    private final BooksAndBits booksAndBits = new BooksAndBits();

    @Override
    protected void registerReader(String readerName) {
        booksAndBits.registerReader(new Reader(readerName));
    }

    @Override
    protected Iterable<String> booksReadBy(String readerName) {
        return booksAndBits.booksReadBy(new Reader(readerName))
                           .stream()
                           .map(searchResult -> searchResult.asText())
                           .collect(toList());
    }

    @Override
    protected void addBookRating(String readerName, String bookTitleValue, int numberOfStars) {
        booksAndBits.addBookRating(
                new Reader(readerName),
                new RatedBook(
                        new Book(BookTitle.of(bookTitleValue)),
                        new Rating(numberOfStars)
                )
        );
    }

    @Override
    protected Iterable<String> findBooksWithTitleMatching(String bookTitleFragment) {
        MatchCondition<ReadersBookRating> matchCondition =
                new CaseInsensitiveReadersBookRatingMatchByTitleCondition(BookTitleFragment.of(bookTitleFragment));
        return booksAndBits.findBooksWithTitleMatching(matchCondition)
                           .stream()
                           .map(searchResult -> searchResult.asText())
                           .collect(toList());
    }

    @Override
    protected Class<? extends Throwable> readerNotFoundException() {
        return ReaderNotFoundException.class;
    }

}

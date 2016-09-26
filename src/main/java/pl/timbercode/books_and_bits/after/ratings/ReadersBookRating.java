package pl.timbercode.books_and_bits.after.ratings;

import pl.timbercode.books_and_bits.after.books.BookTitle;
import pl.timbercode.books_and_bits.after.readers.Reader;
import pl.timbercode.books_and_bits.after.readers.ReaderName;

public class ReadersBookRating {

    private final Reader reader;
    private final RatedBook ratedBook;

    ReadersBookRating(Reader reader, RatedBook ratedBook) {
        this.reader = reader;
        this.ratedBook = ratedBook;
    }

    public boolean hasRatingHigherThan(ReadersBookRating anotherReadersBookRating) {
        return ratedBook.hasRatingHigherThan(anotherReadersBookRating.ratedBook);
    }

    public ReaderName readerName() {
        return reader.name();
    }

    public BookTitle bookTitle() {
        return ratedBook.title();
    }

    public StarsNumber ratingValue() {
        return ratedBook.ratingValue();
    }

    public StarsNumber ratingMaxAllowedValue() {
        return ratedBook.ratingMaxAllowedValue();
    }

}
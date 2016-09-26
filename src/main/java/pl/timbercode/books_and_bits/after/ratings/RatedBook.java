package pl.timbercode.books_and_bits.after.ratings;

import pl.timbercode.books_and_bits.after.books.Book;
import pl.timbercode.books_and_bits.after.books.BookTitle;

public class RatedBook {

    private final Book book;
    private final Rating rating;

    public RatedBook(Book book, Rating rating) {
        this.book = book;
        this.rating = rating;
    }

    public boolean hasTitleAlphabeticallyEarlierThan(RatedBook anotherRatedBook) {
        return book.hasTitleAlphabeticallyEarlierThan(anotherRatedBook.book);
    }

    public BookTitle title() {
        return book.title();
    }

    public StarsNumber ratingValue() {
        return rating.numberOfStars();
    }

    public StarsNumber ratingMaxAllowedValue() {
        return Rating.MAX_NUMBER_OF_STARS_ALLOWED;
    }

    boolean hasRatingHigherThan(RatedBook anotherRatedBook) {
        return rating.isHigherThan(anotherRatedBook.rating);
    }

    boolean hasTitleDifferentThan(RatedBook anotherRatedBook) {
        return book.hasTitleDifferentThan(anotherRatedBook.book);
    }

}
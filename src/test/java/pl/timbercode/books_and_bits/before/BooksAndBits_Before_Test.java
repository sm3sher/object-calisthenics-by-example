package pl.timbercode.books_and_bits.before;

import pl.timbercode.books_and_bits.BooksAndBits_Test;

public class BooksAndBits_Before_Test extends BooksAndBits_Test {

    private final BooksAndBits booksAndBits = new BooksAndBits();

    @Override
    protected void registerReader(String reader) {
        booksAndBits.registerReader(reader);
    }

    @Override
    protected Iterable<String> booksReadBy(String reader) {
        return booksAndBits.getBooksOfReader(reader);
    }

    @Override
    protected void addBookRating(String reader, String book, int rating) {
        booksAndBits.addReaderBookRating(reader, book, rating);
    }

    @Override
    protected Iterable<String> findBooksWithTitleMatching(String bookTitleFragment) {
        return booksAndBits.findBooksAndRatings(bookTitleFragment);
    }

    @Override
    protected Class<? extends Throwable> readerNotFoundException() {
        return ReaderNotFoundException.class;
    }

}

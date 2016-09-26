package pl.timbercode.books_and_bits.after.books;

public class Book {

    private final BookTitle title;

    public Book(BookTitle title) {
        this.title = title;
    }

    public boolean hasTitleDifferentThan(Book bookToMatch) {
        return !title.equals(bookToMatch.title);
    }

    public boolean hasTitleAlphabeticallyEarlierThan(Book anotherBook) {
        return title.isAlphabeticallyEarlierThan(anotherBook.title);
    }

    public BookTitle title() {
        return title;
    }

}
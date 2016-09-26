package pl.timbercode.books_and_bits.after.books;

import pl.timbercode.books_and_bits.after.search.BookTitleFragment;

public class BookTitle {

    public static BookTitle of(String value) {
        return new BookTitle(value);
    }

    private final String value;

    private BookTitle(String value) {
        this.value = value;
    }

    boolean isAlphabeticallyEarlierThan(BookTitle anotherBookTitle) {
        return value.compareTo(anotherBookTitle.value) > 0;
    }

    public String asText() {
        return value;
    }

    BookTitle asLowerCase() {
        return new BookTitle(value.toLowerCase());
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        BookTitle that = (BookTitle) other;
        return this.value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    boolean containsFragment(BookTitleFragment titleFragment) {
        return titleFragment.isPartOf(value);
    }

}
package pl.timbercode.books_and_bits.after.search;

public class BookTitleFragment {

    private final String titleFragment;

    public static BookTitleFragment of(String value) {
        return new BookTitleFragment(value);
    }

    private BookTitleFragment(String titleFragment) {
        this.titleFragment = titleFragment;
    }

    public BookTitleFragment asLowerCase() {
        return new BookTitleFragment(titleFragment.toLowerCase());
    }

    public boolean isPartOf(String bookTitle) {
        return bookTitle.contains(titleFragment);
    }

}

package pl.timbercode.books_and_bits.before;

// FIXME Rule 9. No Getters/Setters/Properties
class Book implements Comparable<Book> {

    // FIXME Rule 3. Wrap All Primitives And Strings
    private String title;
    private int rating;

    public Book(String title, int rating) {
        this.title = title;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    // FIXME Rule 6. Don’t Abbreviate
    @Override
    public int compareTo(Book o) {
        return getTitle().compareTo(o.getTitle());
    }

}

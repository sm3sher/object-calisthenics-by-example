package pl.timbercode.books_and_bits.before;

// FIXME Rule 9. No Getters/Setters/Properties
class SearchResult implements Comparable<SearchResult> {

    // FIXME Rule 8. No Classes With More Than Two Instance Variables
    // FIXME Rule 3. Wrap All Primitives And Strings
    private String reader;
    private String bookTitle;
    private int rating;

    public SearchResult(String reader, String bookTitle, int rating) {
        this.reader = reader;
        this.bookTitle = bookTitle;
        this.rating = rating;
    }

    public String getReader() {
        return reader;
    }

    public void setReader(String reader) {
        this.reader = reader;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public int compareTo(SearchResult o) {
        return o.rating - rating;
    }

}

package pl.timbercode.books_and_bits.after.ratings;

public class StarsNumber {

    private final int numberOfStars;

    StarsNumber(int numberOfStars) {
        this.numberOfStars = numberOfStars;
    }

    public String asText() {
        return Integer.toString(numberOfStars);
    }

}
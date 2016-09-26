package pl.timbercode.books_and_bits.after.ratings;

public class Rating {

    static final StarsNumber MAX_NUMBER_OF_STARS_ALLOWED = new StarsNumber(5);

    private final int numberOfStars;

    public Rating(int numberOfStars) {
        this.numberOfStars = numberOfStars;
    }

    boolean isHigherThan(Rating anotherRating) {
        return numberOfStars > anotherRating.numberOfStars;
    }

    StarsNumber numberOfStars() {
        return new StarsNumber(numberOfStars);
    }

}
package pl.timbercode.books_and_bits.after.search;

public interface MatchCondition<T> {

    boolean isSatisfiedBy(T objectToMatch);

}
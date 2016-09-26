package pl.timbercode.books_and_bits.after.ratings;

import pl.timbercode.books_and_bits.after.books.CaseInsensitiveBookTitleMatchCondition;
import pl.timbercode.books_and_bits.after.search.BookTitleFragment;
import pl.timbercode.books_and_bits.after.search.MatchCondition;

public class CaseInsensitiveReadersBookRatingMatchByTitleCondition implements MatchCondition<ReadersBookRating> {

    private final CaseInsensitiveBookTitleMatchCondition bookTitleMatchCondition;

    public CaseInsensitiveReadersBookRatingMatchByTitleCondition(BookTitleFragment titleFragment) {
        bookTitleMatchCondition = new CaseInsensitiveBookTitleMatchCondition(titleFragment);
    }

    @Override
    public boolean isSatisfiedBy(ReadersBookRating readersBookRatingToMatch) {
        return bookTitleMatchCondition.isSatisfiedBy(readersBookRatingToMatch.bookTitle());
    }

}
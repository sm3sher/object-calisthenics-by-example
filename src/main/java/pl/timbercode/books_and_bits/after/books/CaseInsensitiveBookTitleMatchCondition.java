package pl.timbercode.books_and_bits.after.books;

import pl.timbercode.books_and_bits.after.search.BookTitleFragment;
import pl.timbercode.books_and_bits.after.search.MatchCondition;

public class CaseInsensitiveBookTitleMatchCondition implements MatchCondition<BookTitle> {

    private final BookTitleFragment titleFragment;

    public CaseInsensitiveBookTitleMatchCondition(BookTitleFragment titleFragment) {
        this.titleFragment = titleFragment;
    }

    @Override
    public boolean isSatisfiedBy(BookTitle bookTitleToMatch) {
        return bookTitleToMatch.asLowerCase()
                               .containsFragment(titleFragment.asLowerCase());
    }
}
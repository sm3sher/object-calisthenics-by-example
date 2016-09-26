package pl.timbercode.books_and_bits;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public abstract class BooksAndBits_Test {

    @Test
    public void reader_has_no_books_by_default() {
        // given
        registerReader("Annie");

        // when
        Iterable<String> annieBooks = booksReadBy("Annie");

        // then
        assertThat(annieBooks).isEmpty();
    }

    @Test
    public void reader_can_rate_books() {
        // given
        registerReader("Annie");

        // when
        addBookRating("Annie", "Software Craftsmanship", 4);
        addBookRating("Annie", "Introduction to Algorithms", 3);

        // then
        assertThat(booksReadBy("Annie")).containsExactlyInAnyOrder(
                "Software Craftsmanship [4/5]",
                "Introduction to Algorithms [3/5]"
        );
    }

    @Test
    public void readers_books_are_sorted_alphabetically_by_title() {
        // given
        registerReader("Annie");

        // when
        addBookRating("Annie", "Introduction to Algorithms", 1);
        addBookRating("Annie", "Software Craftsmanship", 2);
        addBookRating("Annie", "Implementing Domain-Driven Design", 3);

        // then
        assertThat(booksReadBy("Annie")).containsExactly(
                "Implementing Domain-Driven Design [3/5]",
                "Introduction to Algorithms [1/5]",
                "Software Craftsmanship [2/5]"
        );
    }

    @Test
    public void there_cannot_be_two_books_of_same_title() {
        // given
        registerReader("Annie");

        // when
        addBookRating("Annie", "Software Craftsmanship", 5);
        addBookRating("Annie", "Software Craftsmanship", 5);
        addBookRating("Annie", "Software Craftsmanship", 5);

        // then
        assertThat(booksReadBy("Annie")).containsExactly(
                "Software Craftsmanship [5/5]"
        );
    }

    @Test
    public void newer_book_rating_overwrite_previous_rating() {
        // given
        registerReader("Annie");

        // when
        addBookRating("Annie", "Software Craftsmanship", 5);
        addBookRating("Annie", "Software Craftsmanship", 1);

        // then
        assertThat(booksReadBy("Annie")).containsExactly(
                "Software Craftsmanship [1/5]"
        );
    }

    @Test
    public void there_can_be_many_readers() {
        // given
        registerReader("Annie");
        registerReader("James");

        // when
        addBookRating("Annie", "Software Craftsmanship", 1);
        addBookRating("Annie", "Introduction to Algorithms", 2);
        addBookRating("James", "Software Craftsmanship", 5);

        // then
        assertThat(booksReadBy("Annie")).containsExactlyInAnyOrder(
                "Software Craftsmanship [1/5]",
                "Introduction to Algorithms [2/5]"
        );
        assertThat(booksReadBy("James")).containsExactlyInAnyOrder(
                "Software Craftsmanship [5/5]"
        );
    }

    @Test
    public void it_is_impossible_add_books_read_by_reader_who_does_not_exist() {
        // given

        // then
        assertThatThrownBy(() -> addBookRating("Annie", "Software Craftsmanship", 1))
                .isInstanceOf(readerNotFoundException())
                .hasMessage("There is no registered reader named 'Annie'");
    }

    @Test
    public void it_is_impossible_to_list_books_of_reader_who_does_not_exist() {
        // given

        // then
        assertThatThrownBy(() -> booksReadBy("Annie"))
                .isExactlyInstanceOf(readerNotFoundException())
                .hasMessage("There is no registered reader named 'Annie'");
    }

    @Test
    public void can_search_by_title_among_books_of_readers() {
        // given
        registerReader("Annie");
        registerReader("James");

        // and
        addBookRating("Annie", "Implementing Domain-Driven Design", 1);
        addBookRating("Annie", "Introduction to Algorithms", 2);
        addBookRating("Annie", "Software Craftsmanship", 3);
        addBookRating("James", "Introduction to Algorithms", 5);

        // then
        assertThat(findBooksWithTitleMatching("Introduction to Algorithms")).containsExactlyInAnyOrder(
                "Annie: Introduction to Algorithms [2/5]",
                "James: Introduction to Algorithms [5/5]"
        );
        assertThat(findBooksWithTitleMatching("Object-Oriented JavaScript")).isEmpty();
    }

    @Test
    public void search_results_are_sorted_from_highest_rating_to_lowest() {
        // given
        registerReader("Annie");
        registerReader("Hakim");
        registerReader("James");

        // and
        addBookRating("Annie", "Introduction to Algorithms", 2);
        addBookRating("Hakim", "Introduction to Algorithms", 1);
        addBookRating("James", "Introduction to Algorithms", 5);

        // then
        assertThat(findBooksWithTitleMatching("Introduction to Algorithms")).containsExactly(
                "James: Introduction to Algorithms [5/5]",
                "Annie: Introduction to Algorithms [2/5]",
                "Hakim: Introduction to Algorithms [1/5]"
        );
    }

    @Test
    public void can_search_by_fragment_of_title() {
        // given
        registerReader("Annie");

        // and
        addBookRating("Annie", "Working Effectively with Legacy Code", 3);
        addBookRating("Annie", "Clean Code", 3);

        // then
        assertThat(findBooksWithTitleMatching("Cod")).containsExactlyInAnyOrder(
                "Annie: Clean Code [3/5]",
                "Annie: Working Effectively with Legacy Code [3/5]"
        );
        assertThat(findBooksWithTitleMatching("n Cod")).containsExactlyInAnyOrder(
                "Annie: Clean Code [3/5]"
        );
    }

    @Test
    public void can_search_by_title_ignoring_case() {
        // given
        registerReader("Annie");

        // and
        addBookRating("Annie", "Working Effectively with Legacy Code", 3);

        // then
        assertThat(findBooksWithTitleMatching("Eff")).containsExactlyInAnyOrder(
                "Annie: Working Effectively with Legacy Code [3/5]"
        );
        assertThat(findBooksWithTitleMatching("eff")).containsExactlyInAnyOrder(
                "Annie: Working Effectively with Legacy Code [3/5]"
        );
        assertThat(findBooksWithTitleMatching("eFF")).containsExactlyInAnyOrder(
                "Annie: Working Effectively with Legacy Code [3/5]"
        );
    }

    protected abstract void registerReader(String reader);

    protected abstract Iterable<String> booksReadBy(String reader);

    protected abstract void addBookRating(String reader, String book, int rating);

    protected abstract Iterable<String> findBooksWithTitleMatching(String bookTitleFragment);

    protected abstract Class<? extends Throwable> readerNotFoundException();

}
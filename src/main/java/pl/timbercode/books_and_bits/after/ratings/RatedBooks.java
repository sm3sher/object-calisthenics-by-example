package pl.timbercode.books_and_bits.after.ratings;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import static java.util.stream.Collectors.toSet;

public class RatedBooks implements Iterable<RatedBook> {

    private Set<RatedBook> ratedBooks = new HashSet<>();

    void add(RatedBook ratedBookToAdd) {
        ratedBooks = ratedBooks.stream()
                               .filter(ratedBook -> ratedBook.hasTitleDifferentThan(ratedBookToAdd))
                               .collect(toSet());
        ratedBooks.add(ratedBookToAdd);
    }

    @Override
    public Iterator<RatedBook> iterator() {
        return ratedBooks.iterator();
    }

    public Stream<RatedBook> stream() {
        return StreamSupport.stream(spliterator(), false);
    }

}